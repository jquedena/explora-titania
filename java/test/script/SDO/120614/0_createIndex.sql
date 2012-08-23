create index idx_interfaz_mis_ind_sdo_00 on iido.interfaz_mis_ind_sdo(cod_epi);
create index idx_interfaz_mis_ind_sdo_01 on iido.interfaz_mis_ind_sdo(cod_territorio);
create index idx_interfaz_mis_ind_sdo_02 on iido.interfaz_mis_ind_sdo(cod_oficina);
create index idx_interfaz_mis_ind_sdo_03 on iido.interfaz_mis_ind_sdo(cod_registro);

create index idx_tiido_interfaz_mis_00 on iido.tiido_interfaz_mis(cod_epi);
create index idx_tiido_interfaz_mis_01 on iido.tiido_interfaz_mis(cod_territorio);
create index idx_tiido_interfaz_mis_02 on iido.tiido_interfaz_mis(cod_oficina);
create index idx_tiido_interfaz_mis_03 on iido.tiido_interfaz_mis(cod_registro);