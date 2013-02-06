create or replace function pl_table.tmp_mpredio(p_text text)
returns table(campo1 text, campo2 text)
as
$body$
declare
	_rows text[];
	_row text[];
begin
	select p_text::text[] into _rows;
	foreach _row in array _rows loop
	
	end loop;
end
$body$
language plsql;