create or replace function pl_table.tmp_mhresum(p_text varchar)
returns table(
	  idsigma character varying(10),
	  ctipdat character(10),
	  vnrodoc character varying(50),
	  dfecdoc timestamp without time zone,
	  cmotivo character(10),
	  ctipdoc character(10),
	  vnrodjj character varying(50),
	  vobserv character varying(500),
	  nestado integer,
	  vhostnm character varying(25),
	  vusernm character varying(25),
	  ddatetm timestamp without time zone,
	  cperini character(4),
	  cperfin character(4),
	  mperson character(10)
)
as
$body$
select    idsigma,ctipdat,vnrodoc,
	  now()::timestamp without time zone dfecdoc,
	  cmotivo,ctipdoc,vnrodjj,vobserv,
	  nestado::integer,vhostnm,vusernm,
	  now()::timestamp without time zone ddatetm,
	  cperini,cperfin, mperson

from stringtotable(p_text, '|', ',')
as cols(
	 idsigma varchar,ctipdat varchar,vnrodoc varchar,dfecdoc varchar,
	  cmotivo varchar,ctipdoc  varchar,vnrodjj  varchar,vobserv  varchar,
	  nestado varchar,vhostnm  varchar,vusernm  varchar,
	  ddatetm  varchar,
	  cperini varchar,cperfin varchar, mperson varchar

);
$body$
language sql;
select * from pl_table.tmp_mhresum('idsigma:0000000006,ctipdat:1000000002,vnrodoc:2009105515,dfecdoc:2011-03-14 00:00:00,cmotivo:1000000109,ctipdoc:1000000022,vnrodjj:,vobserv:,0,vhostnm: PLATAFORMA,vusernm: LALVARADO,ddatetm:2011-03-14 11:44:46,:cperini:2009,cperfin:2009, mperson:0000000002');

