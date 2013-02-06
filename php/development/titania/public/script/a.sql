-- set search_path = registro;
/*
drop FUNCTION if exists registro.texttoarray();
CREATE OR REPLACE FUNCTION pl_table.texttoarray()
RETURNS setof registro.mpredio AS
$BODY$
declare
	output registro.mpredio%ROWTYPE;
begin
	select * into output from registro.mpredio limit 1;
	return next output;
	return;
end
$BODY$
LANGUAGE plpgsql VOLATILE;

select * from pl_table.texttoarray();
*/

BEGIN; select tesoreria.fx_Estadocuenta('0000000158','%','0','2013-01-30','0','0','%','ref_cursor'); FETCH ALL IN ref_cursor;