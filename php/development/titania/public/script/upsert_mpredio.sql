-- select * from registro.mpredio where idsigma='0000000001';
create or replace function pl_function.guardar_mpredio(p_text varchar)
returns int
as
$body$
declare
	ids numeric(18, 0) := 0;
begin
	select coalesce(max(idsigma)::numeric(18, 0), 0) into ids from registro.mpredio;
	
	with new_values(idsigma, mviadis, dnumero, dinteri, dletras, ddepart, destaci, ddeposi,
		drefere, dmanzan, dnlotes, ccatast, cplanos, ctipmer, dnummer, cdiscat, 
		czoncat, cmzacat, cseccat, cltecat, cundcat, dbloque, dseccio, dunidad, 
		mpoblad, vdirpre, nestado, ccodpre, ctippre, idanexo, ccodcuc, vhostnm, 
		vusernm, ddatetm, nlatitu, nlongit, nzoom
	) as (
		select idsigma, mviadis, dnumero, dinteri, dletras, ddepart, destaci, ddeposi,
			drefere, dmanzan, dnlotes, ccatast, cplanos, ctipmer, dnummer, cdiscat, 
			czoncat, cmzacat, cseccat, cltecat, cundcat, dbloque, dseccio, dunidad, 
			mpoblad, vdirpre, nestado, ccodpre, ctippre, idanexo, ccodcuc, vhostnm, 
			vusernm, ddatetm, nlatitu, nlongit, nzoom
		from pl_table.tmp_mpredio(p_text)
	), upsert as ( 
	    update registro.mpredio m set
		mviadis=n.mviadis, dnumero=n.dnumero, dinteri=n.dinteri, dletras=n.dletras,
		ddepart=n.ddepart, destaci=n.destaci, ddeposi=n.ddeposi, drefere=n.drefere,
		dmanzan=n.dmanzan, dnlotes=n.dnlotes, ccatast=n.ccatast, cplanos=n.cplanos,
		ctipmer=n.ctipmer, dnummer=n.dnummer, cdiscat=n.cdiscat, czoncat=n.czoncat,
		cmzacat=n.cmzacat, cseccat=n.cseccat, cltecat=n.cltecat, cundcat=n.cundcat,
		dbloque=n.dbloque, dseccio=n.dseccio, dunidad=n.dunidad, mpoblad=n.mpoblad,
		vdirpre=n.vdirpre, nestado=n.nestado, ccodpre=n.ccodpre, ctippre=n.ctippre,
		idanexo=n.idanexo, ccodcuc=n.ccodcuc, vhostnm=n.vhostnm, vusernm=n.vusernm,
		ddatetm=n.ddatetm, nlatitu=n.nlatitu, nlongit=n.nlongit, nzoom  =n.nzoom
	    from new_values n
	    where m.idsigma = n.idsigma
	    returning m.*
	)
	insert into registro.mpredio(idsigma, mviadis, dnumero, dinteri, dletras, ddepart, destaci, ddeposi,
		drefere, dmanzan, dnlotes, ccatast, cplanos, ctipmer, dnummer, cdiscat, 
		czoncat, cmzacat, cseccat, cltecat, cundcat, dbloque, dseccio, dunidad, 
		mpoblad, vdirpre, nestado, ccodpre, ctippre, idanexo, ccodcuc, vhostnm, 
		vusernm, ddatetm, nlatitu, nlongit, nzoom
	) select rpad((row_number() over(order by idsigma) + ids)::varchar, 10, '0') idsigma, mviadis, dnumero, dinteri, dletras, ddepart, destaci, ddeposi,
		drefere, dmanzan, dnlotes, ccatast, cplanos, ctipmer, dnummer, cdiscat, 
		czoncat, cmzacat, cseccat, cltecat, cundcat, dbloque, dseccio, dunidad, 
		mpoblad, vdirpre, nestado, ccodpre, ctippre, idanexo, ccodcuc, vhostnm, 
		vusernm, ddatetm, nlatitu, nlongit, nzoom
	from new_values where not exists(select 1 from upsert where upsert.idsigma=new_values.idsigma);
	return 1;
exception
when sqlstate '57014' then
	raise notice 'Error';
	return 0;
end
$body$
language plpgsql;


select pl_function.guardar_mpredio('0000000001,0000000809,208,,A,,,,,A,16,1002,,,,,,,,,,,,,0000000000,,1,0000000001,1000000091,0000000001,,localhost,ADMIN,18/01/2013 22:19,11.71,10.25,17|1000000001,0000000809,201,,A,,,,,A,16,1002,,,,,,,,,,,,,0000000000,,1,0000000001,1000000091,0000000001,,localhost,ADMIN,18/01/2013 22:19,11.71,10.25,17');
select * from registro.mpredio where idsigma in('0000000001', '1000000001');

/*
WITH new_values (id, field1, field2) as (
  values 
     (1, 'A', 'X'),
     (2, 'B', 'Y'),
     (3, 'C', 'Z')

),
upsert as
( 
    update mytable m 
        set field1 = nv.field1,
            field2 = nv.field2
    FROM new_values nv
    WHERE m.id = nv.id
    RETURNING m.*
)
INSERT INTO mytable (id, field1, field2)
SELECT id, field1, field2
FROM new_values
WHERE NOT EXISTS (SELECT 1 
                  FROM upsert up 
                  WHERE up.id = new_values.id)
*/