CREATE OR REPLACE FUNCTION pl_table.tmp_drustic(IN p_text character varying)
  RETURNS TABLE(idsigma character, mrustic character, cclasif character, ccatego character, narance numeric, nhectar numeric, nvalrus numeric, nestado integer, vhostnm character varying, vusernm character varying, ddatetm timestamp without time zone, cperiod character) AS
$BODY$
select 	
	  idsigma, mrustic, cclasif, ccatego,
	  narance::numeric(18,5), nhectar::numeric(18,5),
	  nvalrus::numeric(13,5), nestado::integer,
	  vhostnm, vusernm,
	  now()::timestamp without time zone  ddatetm,
	  cperiod

from stringtotable(p_text, '|', ',')
as cols(
	idsigma varchar, mrustic varchar, cclasif varchar, ccatego varchar,
	narance varchar, nhectar varchar, nvalrus varchar, nestado varchar,
	vhostnm varchar, vusernm varchar, ddatetm varchar, cperiod varchar
);
$BODY$
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION pl_table.tmp_drustic(character varying)
  OWNER TO postgres;