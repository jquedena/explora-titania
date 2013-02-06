drop function public.test(p text);
create or replace function public.test(p text)
returns table(campo1 text, campo2 text)
as
$$
declare
	_row varchar := '{{1,2},{2,3}}';
BEGIN
	select _row::varchar[][] into _rows;
	raise notice 'Test %', _row;

	WITH RECURSIVE t(campo1, campo2, n) AS (
		SELECT '', '', 1
	UNION ALL
		SELECT '2', '1', n+1 FROM t
	)campo1, campo2, n FROM t LIMIT 10 LOOP;

	FOR mviews IN SELECT campo1, campo2, n FROM t LIMIT 10 LOOP

	-- Now "mviews" has one record from cs_materialized_views

	RAISE NOTICE 'Refreshing materialized view %s ...', mviews.campo1;
    END LOOP;
	
	
END
$$
language plpgsql;


select public.test();
/*
WITH RECURSIVE t(n) AS (
    SELECT ('{{1,2},{2,3}}'::varchar[][])
  UNION ALL
    SELECT n+1 FROM t
)
SELECT n FROM t LIMIT 2;*/

-- VALUES (1, 'one'), (2, 'two'), (3, 'three');