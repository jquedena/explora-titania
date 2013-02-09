﻿create or replace function pl_table.tmp_dconstr(p_text varchar)
returns table(
	idsigma character(10), -- Identificador del registro
	mconstr character(10), -- Id de la construccion
	nantigu integer, -- Años que tiene la construcion
	nvaluni numeric(18,5), -- Valor del unitario del piso
	nincrem numeric(18,5), -- Incremento
	npordep numeric(18,5), -- % de depreciacion
	ndepred numeric(18,5), -- Depreciacion
	nvalare numeric(18,5), -- Valor del unitario del piso depreciado
	nvalcom numeric(18,5), -- Valor del Area Comun
	nvalpis numeric(18,5), -- Valor del Piso
	nestado integer, -- Estado del registro
	vhostnm character varying(25), -- Estacion
	vusernm character varying(25), -- Usuario
	ddatetm timestamp without time zone, -- Fecha de Registro
	cperiod character(4) -- Ejercicio
)
as
$body$
select  idsigma, mconstr, nantigu::integer, nvaluni::numeric(18,5),
	nincrem::numeric(18,5), npordep::numeric(18,5), ndepred::numeric(18,5), nvalare::numeric(18,5),
	nvalcom::numeric(18,5), nvalpis::numeric(18,5), nestado::integer, vhostnm,
	vusernm, now()::timestamp without time zone ddatetm, 
	cperiod 

from stringtotable(p_text, '|', ',')
as cols(

	idsigma varchar, mconstr varchar, nantigu varchar, nvaluni varchar,
	nincrem varchar, npordep varchar, ndepred varchar, nvalare varchar,
	nvalcom varchar, nvalpis varchar, nestado varchar, vhostnm varchar,
	vusernm varchar, ddatetm varchar, cperiod varchar 
);
$body$
language sql;
select * from pl_table.tmp_dconstr('idsigma,0000000001,27,93.15000,0.00000,23.00000,90.42000,302.73000,0.00000,19677.45000, 1,vhostnm: test.explora.com.pe,vusernm: root,ddatetm: 2012-11-15 04:18:57,cperiod: 2007');

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