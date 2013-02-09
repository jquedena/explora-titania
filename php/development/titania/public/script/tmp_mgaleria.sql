create or replace function pl_table.tmp_mgaleria(p_text varchar)
returns table(
	  idsigma character varying(10),
	  dpredio character varying(10),
	  vfotonm character varying(25),
	  vdescri character varying(250),
	  nestado integer,
	  vusernm character varying(25),
	  vhostnm character varying(25),
	  ddatetm timestamp without time zone
)
as
$body$
select  
	  idsigma,dpredio,vfotonm,vdescri,
	  nestado::integer,vusernm,vhostnm,
	  now()::timestamp without time zone ddatetm


from stringtotable(p_text, '|', ',')
as cols(
	  idsigma varchar,dpredio varchar,vfotonm varchar,vdescri varchar,
	  nestado varchar,vusernm varchar,vhostnm varchar,ddatetm varchar
);
$body$
language sql;
select * from pl_table.tmp_mgaleria('idsigma:,dpredio:,vfotonm:,vdescri:,1,vusernm:,vhostnm:,ddatetm:');


