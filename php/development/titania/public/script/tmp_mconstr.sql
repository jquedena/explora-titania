create or replace function pl_table.tmp_mconstr(p_text varchar)
returns table(
	  idsigma character(10),
	  dpredio character(10),
	  cnitems integer, -- Nro de orden de la construccion
	  cnumpis character varying(5), -- Nro de piso
	  cmescon character(2), -- Mes de la construccion
	  canocon character(4), -- Periodo de Construccion
	  cmateri character varying(10), -- Material
	  cconser character varying(10), -- Estado de conservacion
	  cmurcol character varying(10), -- Muros y columnas
	  ctechos character varying(10), -- Techos
	  cmpisos character varying(10), -- Pisos
	  cpueven character varying(10), -- Puertas y ventanas
	  crevest character varying(10), -- Revestimientos
	  cbanios character varying(10), -- Sanitarios
	  celectr character varying(10), -- Instalaciones electricas
	  narecom numeric(18,5), -- Area comun
	  nporcom numeric(18,5), -- Porcentaje de area comun
	  nestado integer, -- Estado del registro
	  vhostnm character varying(25), -- Estacion
	  vusernm character varying(25), -- Usuario
	  ddatetm timestamp without time zone, -- Fecha de Registro
	  narecon numeric(10,5)-- Area Construida
)
as
$body$
select  
	  idsigma,dpredio,cnitems::integer,cnumpis,
	  cmescon,canocon,cmateri,cconser,cmurcol,
	  ctechos,cmpisos,cpueven,crevest,cbanios,
	  celectr, narecom::numeric(18,5),
	  nporcom::numeric(18,5),nestado::integer,
	  vhostnm,vusernm,
	  now()::timestamp without time zone ddatetm,
	  narecon::numeric(10,5)

from stringtotable(p_text, '|', ',')
as cols(
	  idsigma varchar,dpredio varchar,cnitems varchar,cnumpis varchar,
	  cmescon varchar,canocon varchar,cmateri varchar,cconser varchar,
	  cmurcol varchar,ctechos varchar,cmpisos varchar,cpueven varchar,
	  crevest varchar,cbanios varchar,celectr varchar,narecom varchar,
	  nporcom varchar,nestado varchar,vhostnm varchar,vusernm varchar,
	  ddatetm varchar,narecon varchar
);
$body$
language sql;
select * from pl_table.tmp_mconstr('idsigma:0000000007,dpredio:0000000011,1,cnumpis:01,cmescon:,canocon:1980,cmateri:1000000163,cconser:1000000151,cmurcol:1000000231,ctechos:1000000242,
cmpisos:1000000258,cpueven:1000000267,crevest:1000000278,cbanios:1000000288,celectr:1000000300,0.00000,100.00000,1,vhostnm: test.explora.com.pe,vusernm: root,ddatetm: 2012-11-15 04:18:54,65.00000')
