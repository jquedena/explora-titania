-- CREATE INDEX idx_dpredio_ctippar ON registro.dpredio USING btree (ctippar COLLATE pg_catalog."default") TABLESPACE titania_index;
-- CREATE INDEX idx_dpredio_csubtip ON registro.dpredio USING btree (csubtip COLLATE pg_catalog."default") TABLESPACE titania_index;

/*
drop view registro.vwinstal;

alter table registro.minstal alter column cnumpis type character(5);

CREATE OR REPLACE VIEW registro.vwinstal AS 
 SELECT a.idsigma, a.dpredio, b.cperiod, a.cnumpis, b.nantigu, a.canocon, a.nvalanc, a.nvalalt, a.nvallar, a.ctipint, a.vdesint, b.nvalins
   FROM registro.minstal a
   LEFT JOIN registro.dinstal b ON a.idsigma = b.minstal;

alter table registro.dresumn add ncosemi numeric(18, 5);

*/

CREATE OR REPLACE FUNCTION pl_function.listar_lindero(p_dpredio character varying, p_cperiod character varying, p_ref refcursor)
  RETURNS refcursor AS
$BODY$
begin
	open p_ref for select
		b.vdescri vptocar, c.vdescri vtiplin, a.ccodpre, a.vdirecc, a.mperson, d.vnombre || ' ' || d.vpatern || ' ' || d.vmatern vnombre,
		a.idsigma, a.cptocar, a.ctiplin, a.dpredio
	from registro.mlindero a
		inner join public.mconten b on a.cptocar=b.idsigma
		inner join public.mconten c on a.ctiplin=c.idsigma
		inner join public.mperson d on a.mperson=d.idsigma
	where a.dpredio=p_dpredio;
	return p_ref;
end
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

create or replace view registro.vwpredio as 
select a.idsigma as mpropie, b.idsigma as mpredio, a.ctippro, 
	c.vdescri as vtippro, j.dfecadq, j.dfecdes, o.vnrodoc, o.dfecdoc, o.cmotivo, 
	d.vdescri as vmotivo, o.ctipdat, e.vdescri as vtipfic, o.ctipdoc, 
	e.vdescri as vtipdoc, g.tnompob, h.tnomvia, b.dnumero, b.dinteri, b.dletras, 
	b.ddepart, b.destaci, b.ddeposi, b.drefere, b.dmanzan, b.dnlotes, b.ccatast, 
	b.cplanos, b.ctipmer, b.dnummer, b.cdiscat, b.czoncat, b.cmzacat, b.cseccat, 
	b.cltecat, b.cundcat, b.dbloque, b.dseccio, b.dunidad, b.vdirpre, b.ccodpre, 
	n.cperiod, b.idanexo, b.ccodcuc, i.vdescri as vtippre, j.idsigma as dpredio, 
	j.ctippre, j.cclasif, j.ccondic, j.cestado, j.cusogen, j.cusoesp, j.nporcen, 
	j.ntertot, j.nporter, j.nterren, j.ncomtot, j.nporcom, j.narecom, n.narance, 
	n.nvalpis, n.nvalins, n.nvalter, n.nvalpre, 
	case
		when j.nporafe::integer = 0 then 100.00
		else j.nporafe
	end::numeric(10,2) as nporafe, 
	n.nvalafe, j.dafecta, j.nfrente, j.ncanper, o.vnrodjj, j.ctippar, j.vobserv, 
	o.nestado, a.nestado as pestado, j.nestado as destado, b.nestado as mestado, 
	a.mperson, k.vdescri as vusogen, l.vdescri as vusoesp, m.vdescri as vtippar, 
	j.vusernm, j.ddatetm, j.dfectra, j.cnotari, j.ctiptra, j.cpartid, j.csubtip, 
	j.cmotadq, h.ccodvia, h.mviadis, o.idsigma as mhresum, o.vobserv as mobserv,
	k.viconos, p.vdescri as vcondic, q.vdescri as vestado, r.vdescri as vsubtip,
	coalesce(t.vdescri, 'AFECTO') vregime, u.vobserv as vclasif
from registro.mhresum o
	join registro.mpropie a on o.idsigma::bpchar = a.mhresum
	join registro.mpredio b on a.mpredio = b.idsigma
	join mconten c on a.ctippro = c.idsigma
	join mconten d on o.cmotivo = d.idsigma
	join registro.vwpoblad g on b.mpoblad = g.mpoblad
	join registro.vwviadis h on b.mviadis = h.mviadis
	join mconten i on b.ctippre = i.idsigma
	join registro.dpredio j on b.idsigma = j.mpredio and o.idsigma::bpchar = j.mhresum
	join registro.vpredio n on j.idsigma::bpchar = n.dpredio
	join mconten e on o.ctipdat = e.idsigma
	join mconten f on o.ctipdoc = f.idsigma
	left join mconten k on j.cusogen = k.idsigma
	left join mconten l on j.cusoesp = l.idsigma
	left join mconten m on j.ctippar = m.idsigma
	left join mconten p on j.ccondic = p.idsigma
	left join mconten q on j.cestado = q.idsigma
	left join mconten r on j.csubtip = r.idsigma
	left join registro.minafec s on a.mpredio=s.mpredio and a.mperson=s.mperson
	left join mconten t on s.ctipina = t.idsigma
	left join mconten u on j.cclasif = u.idsigma;

drop function if exists pl_select.listar_predios(p_mhresum character varying, p_cidpers character varying);	
create or replace function pl_select.listar_predios(p_mhresum character varying, p_cidpers character varying)
returns table(
	  ccodpre character(10)
	, tnumero character varying(300)
	, vdirpre character varying(300)
	, vusogen character varying(250)
	, viconos character varying(25)
	, cusogen character(10)
	, nterren numeric(18, 5)
	, narecom numeric(18, 5)	
	, narance numeric(10, 5)
	, nvalter numeric(18, 5)
	, nvalpis numeric(18, 5)
	, nvalins numeric(18, 5)
	, nvalpre numeric(18, 5)
	, nporafe numeric(10, 2)
	, nvalafe numeric(18, 5)
	, dfecadq timestamp without time zone
	, vnrodoc character(50)
	, nporcen numeric(18, 5)
	, mpredio character(10)
	, dpredio character varying(10)
	, tnompob text
	, tnomvia text
	, dnumero character varying(25)
	, ddepart character varying(25)
	, dmanzan character varying(25)
	, dnlotes character varying(25)
	, mhresum character varying(10)
	, cperiod character(4)
	, vcondic character varying(250)
	, vestado character varying(250)
	, vsubtip character varying(250)
	, vregime character varying(250)
	, mperson character(10)
	, vnombre text
	, ptipdoc text
	, pnrodoc text
	, direccf text
	, vclasif character varying(250)
	, ccodvia character(10)
	, pestado integer
	, mestado character(1)
	, destado integer
) as
$body$
	select right(a.ccodpre, 10) :: character(10) ccodpre
		, ((a.tnompob
			|| ' ' || a.tnomvia
			|| case when length(trim(a.dnumero)) > 0 then ' Nro. ' || trim(a.dnumero) else '' end
			|| case when length(trim(a.ddepart)) > 0 then ' Dpt. ' || trim(a.ddepart) else '' end
			|| case when length(trim(a.dmanzan)) > 0 then ' Mza. ' || trim(a.dmanzan) else '' end
			|| case when length(trim(a.dnlotes)) > 0 then ' Lte. ' || trim(a.dnlotes) else '' end) :: character varying(300)) tnumero
		, (a.tnomvia
			|| case when length(trim(a.dnumero)) > 0 then ' Nro. ' || trim(a.dnumero) else '' end
			|| case when length(trim(a.ddepart)) > 0 then ' Dpt. ' || trim(a.ddepart) else '' end
			|| case when length(trim(a.dmanzan)) > 0 then ' Mza. ' || trim(a.dmanzan) else '' end
			|| case when length(trim(a.dnlotes)) > 0 then ' Lte. ' || trim(a.dnlotes) else '' end) :: character varying(300) vdirpre
		, a.vusogen
		, a.viconos
		, a.cusogen
		, a.nterren
		, a.narecom
		, a.narance
		, a.nvalter
		, a.nvalpis
		, a.nvalins
		, a.nvalpre
		, a.nporafe
		, a.nvalafe
		, a.dfecadq
		, a.vnrodoc
		, a.nporcen
		, a.mpredio
		, a.dpredio
		, a.tnompob
		, a.tnomvia
		, a.dnumero
		, a.ddepart
		, a.dmanzan
		, a.dnlotes
		, a.mhresum
		, a.cperiod
		, a.vcondic
		, a.vestado
		, a.vsubtip
		, a.vregime
		, a.mperson
		, b.crazsoc as vnombre
		, coalesce(b.vtipdoc, 'DNI') as ptipdoc
		, b.vnrodoc as pnrodoc
		, b.direccf
		, a.vclasif
		, a.ccodvia
		, a.pestado
		, a.mestado
		, a.destado
	from registro.vwpredio a
		inner join public.vwperson b on a.mperson=b.cidpers
	where ($1='-1' or a.mhresum = $1)
		and a.mperson=$2 
		and ($1='-1' or a.cperiod=(select max(x.cperiod) from registro.dresumn x where x.mhresum = $1));
$body$
language sql;

create or replace function pl_function.listar_predios(p_mhresum character varying, p_cidpers character varying, p_ref refcursor)
	returns refcursor as
$body$
begin
	open p_ref for select a.ccodpre
		, a.tnumero
		, a.vusogen
		, a.viconos
		, a.cusogen
		, a.nterren
		, a.narance
		, a.nvalter
		, a.nvalpis
		, a.nvalins
		, a.nvalpre
		, a.nporafe
		, a.nvalafe
		, a.dfecadq
		, a.vnrodoc
		, a.nporcen
		, a.mpredio
		, a.dpredio
		, a.tnompob
		, a.tnomvia
		, a.dnumero
		, a.ddepart
		, a.dmanzan
		, a.dnlotes
		, a.mhresum
		, a.cperiod
		, a.pestado
		, a.mestado
		, a.destado
		from pl_select.listar_predios(p_mhresum, p_cidpers) a;
	return p_ref;
end
$body$
language plpgsql volatile cost 100;

-- select * from registro.vwpredio limit 10;
-- select * from pl_select.listar_predios('0000000471', '0000000158');
-- select * from registro.vwpredio where mhresum='0000000471';

drop function if exists pl_select.listar_predios(p_mhresum character varying, p_cperiod character varying, p_cidpers character varying);
drop function if exists pl_select.listar_predios(p_mhresum character varying, p_cperiod character varying, p_ccodpre character varying, p_cidpers character varying);
create or replace function pl_select.listar_predios(p_mhresum character varying, p_cperiod character varying, p_ccodpre character varying, p_cidpers character varying)
returns table(
	  ccodpre character
	, tnumero character varying
	, vusogen character varying
	, viconos character varying
	, cusogen character
	, nterren numeric
	, narance numeric
	, nvalter numeric
	, nvalpis numeric
	, nvalins numeric
	, nvalpre numeric
	, nporafe numeric
	, nvalafe numeric
	, dfecadq timestamp without time zone
	, vnrodoc character
	, nporcen numeric
	, mpredio character
	, dpredio character varying
	, tnompob text
	, tnomvia text
	, dnumero character varying
	, ddepart character varying
	, dmanzan character varying
	, dnlotes character varying
	, mhresum character varying
	, cperiod character
	, cnumpis character varying(2)
	, nantigu integer
	, cmescon character(2)
	, canocon character(4)
	, vmateri character varying(250)
	, vconser character varying(250)
	, vmurcol character varying(250)
	, vtechos character varying(250)
	, vmpisos character varying(250)
	, vpueven character varying(250)
	, vrevest character varying(250)
	, vbanios character varying(250)
	, velectr character varying(250)
	, narecon numeric(10, 5)
	, nvaluni numeric(18, 5)
	, nincrem numeric(18, 5)
	, npordep numeric(18, 5)
	, ndepred numeric(18, 5)
	, nvalare numeric(18, 5)
	, narecom numeric(18, 5)
	, nporcom numeric(18, 5)
	, nvalcom numeric(18, 5)
	, ivalpis numeric(18, 5)
	, idsigma character(10)
	, cnitems integer
	, vcondic character varying
	, vestado character varying
	, vsubtip character varying
	, vregime character varying
	, vdirpre character varying
	, mperson character
	, vnombre text
	, ptipdoc text
	, pnrodoc text
	, vclasif character varying
	, ccodvia character
	, ncomter numeric
	, direccf text
	, ctiprep integer
	, vtiprep character
	, vdesrep character varying(30)
	, vinstal character varying(300)
	, ninstal numeric(18, 5)
	, codpre2 character
	, nautova numeric(18, 5)
	, nbaseim numeric(18, 5)
	, nimpanu numeric(18, 5)
	, nimptri numeric(18, 5)
	, ncosemi numeric(18, 5)
) as
$body$
	select a.mperson ccodpre
		, a.tnumero, a.vusogen, a.viconos, a.cusogen
		, a.nterren, a.narance, a.nvalter, a.nvalpis
		, a.nvalins, a.nvalpre, a.nporafe, a.nvalafe
		, a.dfecadq, a.vnrodoc, a.nporcen, a.mpredio
		, a.dpredio, a.tnompob, a.tnomvia, a.dnumero
		, a.ddepart, a.dmanzan, a.dnlotes, a.mhresum
		, a.cperiod, '' cnumpis, 0 nantigu, '' cmescon
		, '' canocon, '' vmateri, '' vconser, '' vmurcol
		, '' vtechos, '' vmpisos, '' vpueven, '' vrevest
		, '' vbanios, '' velectr, 0 narecon, 0 nvaluni
		, 0 nincrem, 0 npordep, 0 ndepred, 0 nvalare
		, 0 narecom, 0 nporcom, 0 nvalcom, 0 ivalpis
		, '' idsigma, 0 cnitems, a.vcondic, a.vestado
		, a.vsubtip, a.vregime, a.vdirpre, a.mperson
		, a.vnombre, a.ptipdoc, a.pnrodoc, a.vclasif
		, a.ccodvia, a.narecom ncomter, a.direccf, 1 ctiprep
		, 'HR' vtiprep, 'Hoja de Resumem' vdesrep
		, '' vinstal, 0 ninstal, ccodpre codpre2
		, nautova, nbaseim, nimpanu, nimptri, coalesce(ncosemi, 0) ncosemi
	from pl_select.listar_predios($1, $4) a
		inner join registro.dresumn b on a.mhresum=b.mhresum and a.cperiod=b.cperiod
	where ($2 = '-1' or a.cperiod=$2) and a.destado=1
	union all
	select a.ccodpre
		, a.tnumero, a.vusogen, a.viconos, a.cusogen
		, a.nterren, a.narance, a.nvalter, a.nvalpis
		, a.nvalins, a.nvalpre, a.nporafe, a.nvalafe
		, a.dfecadq, a.vnrodoc, a.nporcen, a.mpredio
		, a.dpredio, a.tnompob, a.tnomvia, a.dnumero
		, a.ddepart, a.dmanzan, a.dnlotes, a.mhresum
		, a.cperiod, c.cnumpis, c.nantigu, c.cmescon
		, c.canocon, c.vmateri, c.vconser, c.vmurcol
		, c.vtechos, c.vmpisos, c.vpueven, c.vrevest
		, c.vbanios, c.velectr, c.narecon, c.nvaluni
		, c.nincrem, c.npordep, c.ndepred, c.nvalare
		, c.narecom, c.nporcom, c.nvalcom, c.nvalpis as ivalpis
		, c.idsigma, c.cnitems, a.vcondic, a.vestado
		, a.vsubtip, a.vregime, a.vdirpre, a.mperson
		, a.vnombre, a.ptipdoc, a.pnrodoc, a.vclasif
		, a.ccodvia, a.narecom ncomter, a.direccf, 2 ctiprep
		, 'PU' vtiprep, 'Predio Urbano' vdesrep
		, '' vinstal, 0 ninstal, '' codpre2
		, 0 nautova, 0 nbaseim, 0 nimpanu, 0 nimptri, 0 ncosemi
	from pl_select.listar_predios($1, $4) a
		left join registro.vwconstr c on a.dpredio=c.dpredio and a.cperiod=c.cperiod
	where
		($2 = '-1' or a.cperiod=$2) and
		($3 = '-1' or a.ccodpre=$3) and
		 a.destado=1
	union all
	select a.ccodpre
		, a.tnumero, a.vusogen, a.viconos, a.cusogen
		, a.nterren, a.narance, a.nvalter, a.nvalpis
		, a.nvalins, a.nvalpre, a.nporafe, a.nvalafe
		, a.dfecadq, a.vnrodoc, a.nporcen, a.mpredio
		, a.dpredio, a.tnompob, a.tnomvia, a.dnumero
		, a.ddepart, a.dmanzan, a.dnlotes, a.mhresum
		, a.cperiod, b.cnumpis, 0 nantigu, '' cmescon
		, '' canocon, '' vmateri, '' vconser, '' vmurcol
		, '' vtechos, '' vmpisos, '' vpueven, '' vrevest
		, '' vbanios, '' velectr, 0 narecon, 0 nvaluni
		, 0 nincrem, 0 npordep, 0 ndepred, 0 nvalare
		, 0 narecom, 0 nporcom, 0 nvalcom, 0 ivalpis
		, '' idsigma, 0 cnitems, a.vcondic, a.vestado
		, a.vsubtip, a.vregime, a.vdirpre, a.mperson
		, a.vnombre, a.ptipdoc, a.pnrodoc, a.vclasif
		, a.ccodvia, a.narecom ncomter, a.direccf, 3 ctiprep
		, 'OI' vtiprep, 'Otras Instalaciones' vdesrep
		, b.vdesint vinstal, b.nvalins ninstal, '' codpre2
		, 0 nautova, 0 nbaseim, 0 nimpanu, 0 nimptri, 0 ncosemi
	from pl_select.listar_predios($1, $4) a
		inner join registro.vwinstal b on a.dpredio=b.dpredio and a.cperiod=b.cperiod
	where
		($2 = '-1' or a.cperiod=$2) and
		($3 = '-1' or a.ccodpre=$3) and
		 a.destado=1
$body$
language sql;

CREATE OR REPLACE FUNCTION pl_function.listar_caracteristica_rustico(p_dpredio character varying, p_cperiod character varying, p_ref refcursor)
  RETURNS refcursor AS
$BODY$
begin
	open p_ref for select
		b.vdescri vclasif, c.vdescri vcatego, a.narance
		, a.nhectar, a.nvalrus, a.idsigma, a.mrustic
		, a.cclasif, a.ccatego, d.dpredio, a.nestado
		, a.cperiod		
	from registro.drustic a
		inner join public.mconten b on a.cclasif=b.idsigma
		inner join public.mconten c on a.ccatego=c.idsigma
		inner join registro.mrustic d on a.mrustic=d.idsigma
	where d.dpredio=p_dpredio and a.cperiod=p_cperiod;
	return p_ref;
end
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

select public.grantallobject();
select * from pl_select.listar_predios('-1', '-1', '-1', '0000000158');
-- select * from pl_select.listar_predios('-1', '0000000158');

-- select mhresum, nautova, nbaseim, nimpanu, nimptri, ncosemi from registro.dresumn limit 10;
-- select * from registro.dpredio where mhresum='0000000470'