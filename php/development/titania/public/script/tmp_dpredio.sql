create or replace function pl_table.tmp_dpredio(p_text varchar)
returns table(
	idsigma character varying(10), -- Identificador de las caracteristicas del predio
	mpredio character(10), -- Identificador del predio
	ctippre character(10), -- Tipo de predio
	cclasif character(10), -- Clasificacion del predio
	ccondic character(10), -- Condicion del predio
	cestado character(10), -- Estado de construccion
	cusogen character(10), -- Uso generico
	cusoesp character(10), -- Uso especifico
	nporcen numeric(10,2), -- Porcentaje de condiminante
	ntertot numeric(18,5), -- Area total del terreno del predio
	nporter numeric(10,2), -- Porcentaje de area de terreno
	nterren numeric(18,5), -- Area total del terreno - Base para el calculo
	ncomtot numeric(18,5), -- Area comun total del predio
	nporcom numeric(10,2), -- Porcentaje de area comun
	narecom numeric(18,5), -- Area comun total - Base para el calculo
	nporafe numeric(10,2), -- Porcentaje afecto
	dfecadq timestamp without time zone, -- Fecha de adquisición del predio
	dfecdes timestamp without time zone, -- Fecha de descargo del predio
	dafecta timestamp without time zone, -- Fecha desde donde se comienzan a generar los tributos
	nfrente numeric(18,5), -- Frontis del predio
	ncanper integer, -- Cantidad de personas que habita el predio
	ctippar character(10), -- Tipo de parque
	vobserv character varying(500), -- Observaciones
	nestado integer, -- Estado del registro
	vhostnm character varying(25), -- Estacion
	vusernm character varying(25), -- Usuario
	ddatetm timestamp without time zone, -- Fecha de Registro
	dfectra timestamp with time zone, -- Fecha de transferencia
	cnotari character varying(100), -- Notaria donde se registra la transferencia
	ctiptra character varying(500), -- Tipo de transferencia
	cpartid character varying(50), -- Nro de partida de la transferencia
	csubtip character varying(10), -- Tipo de predio urbano o rustico
	cmotadq character varying(10), -- Motivo de adquisicion
	mhresum character(10)
)
as
$body$
select 	idsigma, mpredio, ctippre, cclasif,
	ccondic, cestado, cusogen, cusoesp,
	nporcen::numeric(10,2), ntertot::numeric(18,5),
	nporter::numeric(10,2), nterren::numeric(18,5),
	ncomtot::numeric(18,5), nporcom::numeric(10,2),narecom::numeric(18,5),
	nporafe::numeric(10,2), now()::timestamp without time zone dfecadq,
	now()::timestamp without time zone dfecdes,
	now()::timestamp without time zone dafecta,
	nfrente::numeric(18,5), ncanper::integer, ctippar,
	vobserv, nestado::integer, vhostnm, vusernm,
	now()::timestamp without time zone ddatetm,
	now()::timestamp with time zone dfectra,
	cnotari, ctiptra, cpartid, csubtip,
	cmotadq, mhresum

from stringtotable(p_text, '|', ',')
as cols(
	idsigma varchar, mpredio varchar, ctippre varchar, cclasif varchar,
	ccondic varchar, cestado varchar, cusogen varchar, cusoesp varchar,
	nporcen varchar, ntertot varchar, nporter varchar, nterren varchar,
	ncomtot varchar, nporcom varchar, narecom varchar, nporafe varchar,
	dfecadq varchar, dfecdes varchar, dafecta varchar, nfrente varchar, 
	ncanper varchar, ctippar varchar, vobserv varchar, nestado varchar,
	vhostnm varchar, vusernm varchar, ddatetm varchar, dfectra varchar,
	cnotari varchar, ctiptra varchar, cpartid varchar, csubtip varchar,
	cmotadq varchar, mhresum varchar
);
$body$
language sql;
select * from pl_table.tmp_dpredio('idsigma: 0000000008, mpredio: 0000000002, ctippre: 1000000090, cclasif: 1000000224,ccondic: 1000000144, cestado: 1000000157, cusogen: 1000000166, cusoesp: ,100.00, 97.50000, 100.00, 97.50000, 0.00000, 100.00, 0.00000, 0.00,dfecadq: 1900-01-01 12:00:00, dfecdes: 1900-01-01 12:00:00, dafecta : 1900-01-01 12:00:00,  0.00000, 0,, vobserv: , 1,vhostnm: EQUIPO01RE, vusernm: JCHAVELON, ddatetm: 2010-03-24 14:24:13, dfectra: 1900-01-01 12:12:16-04:56:20,cnotari:, ctiptra:, cpartid:, csubtip: 1000000203,cmotadq:, mhresum:0000000001')


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