CREATE OR REPLACE VIEW IIDO.VIIDO_MIS AS
SELECT b.cod_epi cod_epi,
	b.cod_territorio cod_terr ,
	b.cod_oficina ,
	b.cod_registro cod_gestor ,
	TO_CHAR(to_date(b.fec_facturacion, 'dd/MM/yyyy'), 'MM') mes ,
	TO_CHAR(to_date(b.fec_facturacion, 'dd/MM/yyyy'), 'yyyy') anho ,
	SUM(TRUNC(b.monto_facturacion, 0)) total,
	COUNT(1) operaciones
FROM iido.tiido_interfaz_mis b
GROUP BY b.cod_epi ,
	b.cod_territorio ,
	b.cod_oficina ,
	b.cod_registro ,
	TO_CHAR(to_date(b.fec_facturacion, 'dd/MM/yyyy'), 'MM') ,
	TO_CHAR(to_date(b.fec_facturacion, 'dd/MM/yyyy'), 'yyyy');