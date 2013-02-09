create or replace function pl_table.tmp_dresumn(p_text varchar)
returns table(
	idsigma character varying(10), -- Identificador del registro
	mhresum character(10), -- Identificador de la declaracion jurada
	cperiod character(4), -- Ejercicio de la declaracion jurada
	nautova numeric(18,5), -- Autovaluo
	nbaseim numeric(18,5), -- Base Imponible
	nimpanu numeric(18,5), -- Impuesto Anual
	nimptri numeric(18,5), -- Impuesto Trimestral
	ntotpre numeric(18,5), -- Total de Predios
	nestado integer, -- Estado del registro
	vhostnm character varying(25), -- Estacion
	vusernm character varying(25), -- Usuario
	ddatetm timestamp without time zone, -- Fecha de Registro
	ncosemi numeric(18,5)
)
as
$body$
select 	
	idsigma, mhresum, cperiod,
	nautova::numeric(18,5), nbaseim::numeric(18,5),
	nimpanu::numeric(18,5), nimptri::numeric(18,5),
	ntotpre::numeric(18,5), nestado::integer,
	vhostnm, vusernm,
	now()::timestamp without time zone ddatetm,
	ncosemi::numeric(18,5)

from stringtotable(p_text, '|', ',')
as cols(
	idsigma varchar, mhresum varchar, cperiod varchar, nautova varchar,
	nbaseim varchar, nimpanu varchar, nimptri varchar, ntotpre varchar,
	nestado varchar, vhostnm varchar, vusernm varchar, ddatetm varchar,
	ncosemi varchar
);
$body$
language sql;
select * from pl_table.tmp_dresumn('idsigma: 0000000006, mhresum: 0000000009, cperiod: 2010,45428.50000,45428.50000,90.88000,22.72000,2.00000,1,vhostnm: RENTAS0007,vusernm: ITAMARA,ddatetm: 2010-05-11 14:53:14,11.00')
