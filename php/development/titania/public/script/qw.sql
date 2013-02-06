create or replace function pl_table.tmp_mpredio(p_text varchar)
returns table(
	idsigma character varying(10), -- Identificador del predio
	mviadis character varying(10), -- Codigo de la via
	dnumero character varying(25), -- Numero
	dinteri character varying(25), -- Interior
	dletras character varying(25), -- Letra
	ddepart character varying(25), -- Departamento
	destaci character varying(25), -- Estacionamiento
	ddeposi character varying(25), -- Deposito
	drefere character varying(100), -- Referencia
	dmanzan character varying(25), -- Manzana
	dnlotes character varying(25), -- Lote
	ccatast character varying(25), -- Codigo Catastral
	cplanos character varying(4), -- Ubicacion en el plano
	ctipmer character varying(1), -- Tipo de Mercado
	dnummer character varying(10), -- Nro de puesto dentro del mercado
	cdiscat character varying(25), -- Distrito Catastral
	czoncat character varying(25), -- Zona Catastral
	cmzacat character varying(25), -- Manzana Catastral
	cseccat character varying(25), -- Sector Catastral
	cltecat character varying(25), -- Lote Catastral
	cundcat character varying(25), -- Unidad Catastral
	dbloque character varying(25), -- Bloque
	dseccio character varying(25), -- Seccion
	dunidad character varying(25), -- Unidad
	mpoblad character varying(10), -- Centro Poblado
	vdirpre character varying(250), -- Direccion del Predio
	nestado character varying(2), -- Estado
	ccodpre character varying(20), -- Codigo de Predio Mostrar
	ctippre character varying(10), -- Tipo de Predio
	idanexo character varying(10), -- Anexo
	ccodcuc character varying(25), -- Codigo unico castastral new
	vhostnm character varying(25), -- Estacion
	vusernm character varying(25), -- Usuario
	ddatetm timestamp without time zone, -- Fecha de Registro
	nlatitu numeric(18,8), -- Latitud del predio
	nlongit numeric(18,8), -- Longitud del predio
	nzoom   numeric(18,8) -- Zoom del mapa
)
as
$body$
select  idsigma, mviadis, dnumero, dinteri,
	dletras, ddepart, destaci, ddeposi,
	drefere, dmanzan, dnlotes, ccatast,
	cplanos, ctipmer, dnummer, cdiscat, 
	czoncat, cmzacat, cseccat, cltecat, 
	cundcat, dbloque, dseccio, dunidad, 
	mpoblad, vdirpre, nestado, ccodpre, 
	ctippre, idanexo, ccodcuc, vhostnm, 
	vusernm, now()::timestamp without time zone ddatetm, 
	nlatitu::numeric(18,8) nlatitu, 
	nlongit::numeric(18,8) nlongit, 
	nzoom::numeric(18,8) nzoom 
from stringtotable(p_text, '|', ',') 
as cols(
	idsigma varchar, mviadis varchar, dnumero varchar, dinteri varchar,
	dletras varchar, ddepart varchar, destaci varchar, ddeposi varchar,
	drefere varchar, dmanzan varchar, dnlotes varchar, ccatast varchar,
	cplanos varchar, ctipmer varchar, dnummer varchar, cdiscat varchar,
	czoncat varchar, cmzacat varchar, cseccat varchar, cltecat varchar,
	cundcat varchar, dbloque varchar, dseccio varchar, dunidad varchar,
	mpoblad varchar, vdirpre varchar, nestado varchar, ccodpre varchar,
	ctippre varchar, idanexo varchar, ccodcuc varchar, vhostnm varchar,
	vusernm varchar, ddatetm varchar, nlatitu varchar, nlongit varchar,
	nzoom varchar
);
$body$
language sql;

select * from pl_table.tmp_mpredio('idsigma,mviadis: 1000000060,dnumero: 201,dinteri: ,dletras: A,ddepart: ,destaci: ,ddeposi: ,drefere: ,dmanzan: A,dnlotes: 16,ccatast: ,cplanos: ,ctipmer: ,dnummer: ,cdiscat: ,czoncat: ,cmzacat: ,cseccat: ,cltecat: ,cundcat: ,dbloque: ,dseccio: ,dunidad: ,mpoblad: 1000000178,vdirpre: ,nestado: 1,ccodpre: 0000000000,ctippre: ,idanexo: 0000000000,ccodcuc: ,vhostnm: ,vusernm: ADMIN,18/01/2013,11.71,10.25,17')

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