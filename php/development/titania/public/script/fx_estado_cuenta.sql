-- Function: tesoreria.fx_estadocuenta_base(character varying, character varying, character varying, character varying)

-- DROP FUNCTION tesoreria.fx_estadocuenta_base(character varying, character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION tesoreria.fx_estadocuenta_base(p_cidpers character varying, p_cperiod character varying, p_estado character varying, p_fecproy character varying)
  RETURNS SETOF record AS
$BODY$
declare
  r record;
BEGIN
	
	CREATE TEMPORARY  TABLE t_estcta_base (idsigma varchar(10) 
																	, ctiping varchar(10) 
																	, ctiprec varchar(10) 
																	, cidpers varchar(10)
																	, cidpred varchar(10)
																	, ccodpre varchar(10)
																	, cejerci varchar(4) 
																	, cperiod varchar(2) 
																	, nimpins decimal(18, 2)
																	, nfacrea decimal(18, 5)
																	, nfacmor decimal(18, 5)
																	, tmp_nimprea decimal(18, 2)
																	, tmp_nimpmor decimal(18, 2)
																	, tmp_ndiaven int
																	, dfecven TIMESTAMP
																	, ncosemi decimal(18, 2)
																	, nestado char(1)
																	, vestado varchar(50) 
																	, nestad2 char(1)
																	, vestad2 varchar(50)
																	, nestad3 char(1)
																	, nimpins2 decimal(18, 2)
																	, nimprea  decimal(18, 2)
																	, nimpmor  decimal(18, 2)
																	, ntotals  decimal(18, 2)
																	, cidvalr varchar(50) 
																	, cnroval varchar(50) 
																	, dfecnotval varchar(50)
																	, cidexp varchar(50) 
																	, cnroexp varchar(50) 
																	, dfecnotexp varchar(50) 
																	, cnroexptr varchar(50) 
																	, dfecnottr varchar(50) 
																	, nordnEst int) ON COMMIT DROP;

		insert into t_estcta_base(
					idsigma, ctiping, ctiprec
				, cidpers, cidpred, ccodpre, cejerci
				, cperiod, nimpins, nfacrea, nfacmor
				, tmp_nimprea, tmp_nimpmor, tmp_ndiaven
				, ncosemi, nestado, vestado
				, nestad2, vestad2, nestad3
				, nimpins2, dfecven, cidvalr, cnroval 
				, dfecnotval, cidexp, cnroexp, dfecnotexp
				, cnroexptr, dfecnottr, nordnEst
			)
		select distinct
		  aa.idsigma 
		, aa.ctiping 
		, aa.ctiprec 
		, aa.cidpers
		, (case when aa.ctiping='0000000273' then aa.cidpers else aa.cidpred end) as cidpred
		, COALESCE( (case when aa.ctiping='0000000273' then aa.cidpers else right(ax.ccodpre, 10) end) , '') as ccodpre
		, COALESCE(trim(aa.cperanio), '') as cejerci 
		, substring('0' ||  trim(replace(aa.cperiod, 'A', '')) from '..$') as cperiod
		, (aa.imp_insol - (case when aa.nestado='I' then COALESCE(f.nimpins, 0) else 0 end)) as nimpins 
		,  (case when bx.ntipcuo is null then 1 
			  else
				(case when COALESCE(c.estado_general, '0') = '0' and bx.ntipcuo<>1 then COALESCE( (case when COALESCE(bx.nipmapl, 0)=0 then COALESCE(bx.nfacrea, 1) else bx.nfacrea * bx.nfacipm end)  * COALESCE(g.nimprea, 1) , 0)
				else aa.fact_reaj end)
			  end) as nfacrea
		, COALESCE(bx.nmorapl * (bx.nmontim / 100), 0) * COALESCE(g.nimpmor, 1) as nfacmor
		, (aa.imp_reaj - (case when aa.ctiping='0000000312' then COALESCE(f.nimprea, 0) else 0 end) ) as tmp_nimprea
		, aa.imp_mora as tmp_nimpmor
		, COALESCE(case 
								when aa.ctiping in('0000000278', '0000000273') and aa.nestado<>'I' then 
									case when (cast(p_fecproy as date) - cast(bx.dfecven as date)) < 0 then 0 else (cast(p_fecproy as date) - cast(bx.dfecven as date)) end
								else
									case when (cast(p_fecproy as date) - cast(aa.dfecven as date)) < 0 then 0 else (cast(p_fecproy as date) - cast(aa.dfecven as date)) end 
								end, 0) as tmp_ndiaven
    
		, ((costo_emis - COALESCE(f.ncosemi, 0)) * COALESCE(g.ncosemi, 1) ) as ncosemi
		, (case when aa.nestado = '0' or  aa.nestado = 'I' and bx.dfecven < now()
			then 'K'
			else aa.nestado end ) as nestado
		, (case when  aa.nestado = '0' or  aa.nestado = 'I' and bx.dfecven < now() 
			then 'Para Valor'
			else ltrim(rtrim(c.descripcion)) end) as vestado
		, (case when aa.nestado='3' then '1' else c.estado_general end) as  nestad2
		, e.descripcion as vestad2
		,  aa.nestado as nestad3
		,  aa.imp_insol as nimpins2
		, (case when aa.ctiping in('0000000278', '0000000273') and aa.nestado<>'I' then bx.dfecven else aa.dfecven end ) as dfecven
		, '' as cidvalr 
		, '' as cnroval   
		, '' as dfecnotval 
		, '' as cidexp 
		, '' as cnroexp 
		, '' as dfecnotexp 
		, '' as cnroexpttr 
		, '' as dfecnottr 
		, m.norden as nordnEst 

	from "tesoreria"."mestcta" as aa
		left join "registro".mpredio as ax on (aa.cidpred=ax.idsigma and ax.nestado='1')
		left join tesoreria.mreajus as bx on ((aa.ctiping=bx.ctiping and cast(replace(substring(aa.cperiod from 1 for 2), 'A', '') as integer )=bx.cnromes and aa.cperanio=bx.cperanio and bx.ntipcuo=0) or (aa.ctiping=bx.ctiping and bx.ntipcuo=1))
		left join "public".mestados as c on (aa.nestado=c.estado)
		left join "public".mestados as e on (c.estado_general=e.estado )
		left join (select cidecta, sum(imp_insol) as nimpins , sum(imp_reaj) as nimprea, sum(costo_emis) as ncosemi from tesoreria.mtesore where nestado='1' and cidpers='0000008080' group by cidecta) f on (aa.idsigma = f.cidecta)
		left join tesoreria.mexonera as g on ( aa.cidpers=g.cidpers and aa.cidpred=g.cidpred and aa.cperanio=g.cperiod and aa.ctiping=g.ctiping )
		left join MEstados m on ((case when aa.nestado in('0', 'I') and bx.dfecven < now() then 'K' else aa.nestado end) = m.estado)
	where aa.cidpers=p_cidpers  
		and COALESCE(aa.cperanio, '') like '%' ||  p_cperiod  ||  '%' 
		and (aa.imp_insol  +   aa.costo_emis) > 0.01 
		and (case when aa.nestado='3' then '1' else aa.nestado end) in (select estado from "public".mestados where estado_general like '%' ||  p_estado  ||  '%');

		
		update t_estcta_base set nfacrea=1 where nfacrea=0 ;
		
		update t_estcta_base set nimprea = (case when COALESCE(nestad2, '0') = '0' and ctiprec<>'0000000312' then nimpins * nfacrea else tmp_nimprea end)
											, nimpmor = (case when COALESCE(nestad2, '0')='0' then nimpins * nfacrea * nfacmor * tmp_ndiaven else tmp_nimpmor end + case when nestad3='I' then tmp_nimpmor else 0 end)
											, ntotals = (cast(case when COALESCE(nestad2, '0')='0' and ctiprec<>'0000000312' then nimpins * nfacrea else tmp_nimprea end as decimal(18, 2)) 
																	+ cast(case when COALESCE(nestad2, '0')='0' then nimpins * nfacrea * nfacmor * tmp_ndiaven else tmp_nimpmor end + case when nestad3='I' then tmp_nimpmor else 0 end as decimal(18, 2)) 
																	+ ncosemi)
											;
					
		delete from t_estcta_base where ctiping='0000000278' and cejerci < '2002'; -- Arbitrios Condonados
		delete from t_estcta_base where ctiping in ('0000000273' , '0000000278') and ccodpre is null ;
		delete from t_estcta_base where cejerci = '' and ctiping in('0000000273', '0000000278') ; -- No existen Predio
		delete from t_estcta_base where nestado='A';
		

		for r in EXECUTE 'select * from t_estcta_base' loop
			return next r;
		end loop;
	return;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION tesoreria.fx_estadocuenta_base(character varying, character varying, character varying, character varying)
  OWNER TO postgres;
GRANT EXECUTE ON FUNCTION tesoreria.fx_estadocuenta_base(character varying, character varying, character varying, character varying) TO postgres;
GRANT EXECUTE ON FUNCTION tesoreria.fx_estadocuenta_base(character varying, character varying, character varying, character varying) TO public;
GRANT EXECUTE ON FUNCTION tesoreria.fx_estadocuenta_base(character varying, character varying, character varying, character varying) TO desarrollo;
