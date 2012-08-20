package com.grupobbva.bc.per.tel.iilc.entity;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_clienteBeanCacheEntry_f5b4eb46;

/**
 * Bean implementation class for Enterprise Bean: Tiilc_cliente
 */
public class ConcreteTiilc_cliente_f5b4eb46 extends com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteBean implements javax.ejb.EntityBean, ConcreteBean {
	static final long serialVersionUID = 61;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
		instanceExtension.setEntityContext(ctx);
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		super.unsetEntityContext();
		instanceExtension.unsetEntityContext();
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
			super.ejbActivate();
			instanceExtension.ejbActivate();
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
		instanceExtension.ejbLoad();
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
		super.ejbPassivate();
		instanceExtension.ejbPassivate();
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
		super.ejbRemove();
		instanceExtension.ejbRemove();
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
		super.ejbStore();
		instanceExtension.ejbStore();
	}
	private ConcreteBeanInstanceExtension instanceExtension;
	private Tiilc_clienteBeanCacheEntry_f5b4eb46 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTiilc_cliente_f5b4eb46
	 */
	public ConcreteTiilc_cliente_f5b4eb46() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_clienteBeanInjector_f5b4eb46 getInjector() {
		return (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_clienteBeanInjector_f5b4eb46)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.Tiilc_clienteBeanCacheEntry_f5b4eb46) inRecord;
		super.ejbLoad();
	}
	/**
	 * resetCMP
	 */
	public void resetCMP() {
			dataCacheEntry = null;
	}
	/**
	 * resetCMR
	 */
	public void resetCMR() {
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey ejbFindByPrimaryKey(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey primaryKey) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey ejbFindByPrimaryKeyForCMR_Local(com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey pk) throws javax.ejb.FinderException {
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey ejbCreate(java.math.BigDecimal cod_cliente) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_clienteBeanCacheEntry_f5b4eb46) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_cliente);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.math.BigDecimal cod_cliente) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_cliente);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey ejbCreate(java.math.BigDecimal cod_cliente, java.lang.String cod_oficina, java.lang.String cod_gestor, java.lang.String cod_territorio, java.math.BigDecimal mofactv, java.math.BigDecimal cs000lineamaxtc, java.math.BigDecimal cs000mtoprestamo, java.math.BigDecimal montovehicular, java.math.BigDecimal montohipotecario, java.math.BigDecimal tconsactv, java.math.BigDecimal montosubrogados, java.math.BigDecimal tsubactv, java.math.BigDecimal thipotactv, java.math.BigDecimal tvehicactv, java.lang.String cs000montocta36, java.math.BigDecimal tcuot36act, java.math.BigDecimal cs000montocta48, java.math.BigDecimal tcuot48act, java.math.BigDecimal cs000montocta60, java.math.BigDecimal tcuot60act, java.math.BigDecimal css000presmena5000, java.math.BigDecimal cs000comisdesemen5000, java.math.BigDecimal cs000pres5000a15000, java.math.BigDecimal c5000comdes15000act, java.math.BigDecimal cs000presmaya15000, java.math.BigDecimal comdes15000ac, java.math.BigDecimal cs000linminadqtc, java.math.BigDecimal cs000mixmonprest, java.math.BigDecimal cs000mixlinasistc, java.math.BigDecimal cs000prestcmena5000, java.math.BigDecimal cs000prestc500015000, java.math.BigDecimal cs000prestcmaya15000) throws javax.ejb.CreateException {
		dataCacheEntry = (Tiilc_clienteBeanCacheEntry_f5b4eb46) instanceExtension.createDataCacheEntry();
		 super.ejbCreate(cod_cliente, cod_oficina, cod_gestor, cod_territorio, mofactv, cs000lineamaxtc, cs000mtoprestamo, montovehicular, montohipotecario, tconsactv, montosubrogados, tsubactv, thipotactv, tvehicactv, cs000montocta36, tcuot36act, cs000montocta48, tcuot48act, cs000montocta60, tcuot60act, css000presmena5000, cs000comisdesemen5000, cs000pres5000a15000, c5000comdes15000act, cs000presmaya15000, comdes15000ac, cs000linminadqtc, cs000mixmonprest, cs000mixlinasistc, cs000prestcmena5000, cs000prestc500015000, cs000prestcmaya15000);
		return (com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.math.BigDecimal cod_cliente, java.lang.String cod_oficina, java.lang.String cod_gestor, java.lang.String cod_territorio, java.math.BigDecimal mofactv, java.math.BigDecimal cs000lineamaxtc, java.math.BigDecimal cs000mtoprestamo, java.math.BigDecimal montovehicular, java.math.BigDecimal montohipotecario, java.math.BigDecimal tconsactv, java.math.BigDecimal montosubrogados, java.math.BigDecimal tsubactv, java.math.BigDecimal thipotactv, java.math.BigDecimal tvehicactv, java.lang.String cs000montocta36, java.math.BigDecimal tcuot36act, java.math.BigDecimal cs000montocta48, java.math.BigDecimal tcuot48act, java.math.BigDecimal cs000montocta60, java.math.BigDecimal tcuot60act, java.math.BigDecimal css000presmena5000, java.math.BigDecimal cs000comisdesemen5000, java.math.BigDecimal cs000pres5000a15000, java.math.BigDecimal c5000comdes15000act, java.math.BigDecimal cs000presmaya15000, java.math.BigDecimal comdes15000ac, java.math.BigDecimal cs000linminadqtc, java.math.BigDecimal cs000mixmonprest, java.math.BigDecimal cs000mixlinasistc, java.math.BigDecimal cs000prestcmena5000, java.math.BigDecimal cs000prestc500015000, java.math.BigDecimal cs000prestcmaya15000) throws javax.ejb.CreateException {
		super.ejbPostCreate(cod_cliente, cod_oficina, cod_gestor, cod_territorio, mofactv, cs000lineamaxtc, cs000mtoprestamo, montovehicular, montohipotecario, tconsactv, montosubrogados, tsubactv, thipotactv, tvehicactv, cs000montocta36, tcuot36act, cs000montocta48, tcuot48act, cs000montocta60, tcuot60act, css000presmena5000, cs000comisdesemen5000, cs000pres5000a15000, c5000comdes15000act, cs000presmaya15000, comdes15000ac, cs000linminadqtc, cs000mixmonprest, cs000mixlinasistc, cs000prestcmena5000, cs000prestc500015000, cs000prestcmaya15000);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey pk = new com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey();
		pk.cod_cliente = getCod_cliente();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 155;
	}
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return dataCacheEntry.getOCCColumn();
	}
	/**
	 * Get accessor for persistent attribute: cod_cliente
	 */
	public java.math.BigDecimal getCod_cliente() {
		return dataCacheEntry.getCod_cliente();
	}
	/**
	 * Set accessor for persistent attribute: cod_cliente
	 */
	public void setCod_cliente(java.math.BigDecimal newCod_cliente) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(0,getCod_cliente(),newCod_cliente);
		else
			instanceExtension.markDirty(0);
		dataCacheEntry.setCod_cliente(newCod_cliente);
	}
	/**
	 * Get accessor for persistent attribute: codigo
	 */
	public java.lang.String getCodigo() {
		return dataCacheEntry.getCodigo();
	}
	/**
	 * Set accessor for persistent attribute: codigo
	 */
	public void setCodigo(java.lang.String newCodigo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(1,getCodigo(),newCodigo);
		else
			instanceExtension.markDirty(1);
		dataCacheEntry.setCodigo(newCodigo);
	}
	/**
	 * Get accessor for persistent attribute: cod_oficina
	 */
	public java.lang.String getCod_oficina() {
		return dataCacheEntry.getCod_oficina();
	}
	/**
	 * Set accessor for persistent attribute: cod_oficina
	 */
	public void setCod_oficina(java.lang.String newCod_oficina) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(2,getCod_oficina(),newCod_oficina);
		else
			instanceExtension.markDirty(2);
		dataCacheEntry.setCod_oficina(newCod_oficina);
	}
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public java.lang.String getCod_gestor() {
		return dataCacheEntry.getCod_gestor();
	}
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public void setCod_gestor(java.lang.String newCod_gestor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(3,getCod_gestor(),newCod_gestor);
		else
			instanceExtension.markDirty(3);
		dataCacheEntry.setCod_gestor(newCod_gestor);
	}
	/**
	 * Get accessor for persistent attribute: nombre
	 */
	public java.lang.String getNombre() {
		return dataCacheEntry.getNombre();
	}
	/**
	 * Set accessor for persistent attribute: nombre
	 */
	public void setNombre(java.lang.String newNombre) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(4,getNombre(),newNombre);
		else
			instanceExtension.markDirty(4);
		dataCacheEntry.setNombre(newNombre);
	}
	/**
	 * Get accessor for persistent attribute: cod_territorio
	 */
	public java.lang.String getCod_territorio() {
		return dataCacheEntry.getCod_territorio();
	}
	/**
	 * Set accessor for persistent attribute: cod_territorio
	 */
	public void setCod_territorio(java.lang.String newCod_territorio) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(5,getCod_territorio(),newCod_territorio);
		else
			instanceExtension.markDirty(5);
		dataCacheEntry.setCod_territorio(newCod_territorio);
	}
	/**
	 * Get accessor for persistent attribute: segment1
	 */
	public java.lang.String getSegment1() {
		return dataCacheEntry.getSegment1();
	}
	/**
	 * Set accessor for persistent attribute: segment1
	 */
	public void setSegment1(java.lang.String newSegment1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(6,getSegment1(),newSegment1);
		else
			instanceExtension.markDirty(6);
		dataCacheEntry.setSegment1(newSegment1);
	}
	/**
	 * Get accessor for persistent attribute: edad
	 */
	public java.math.BigDecimal getEdad() {
		return dataCacheEntry.getEdad();
	}
	/**
	 * Set accessor for persistent attribute: edad
	 */
	public void setEdad(java.math.BigDecimal newEdad) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(7,getEdad(),newEdad);
		else
			instanceExtension.markDirty(7);
		dataCacheEntry.setEdad(newEdad);
	}
	/**
	 * Get accessor for persistent attribute: estcivil
	 */
	public java.lang.String getEstcivil() {
		return dataCacheEntry.getEstcivil();
	}
	/**
	 * Set accessor for persistent attribute: estcivil
	 */
	public void setEstcivil(java.lang.String newEstcivil) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(8,getEstcivil(),newEstcivil);
		else
			instanceExtension.markDirty(8);
		dataCacheEntry.setEstcivil(newEstcivil);
	}
	/**
	 * Get accessor for persistent attribute: calle
	 */
	public java.lang.String getCalle() {
		return dataCacheEntry.getCalle();
	}
	/**
	 * Set accessor for persistent attribute: calle
	 */
	public void setCalle(java.lang.String newCalle) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(9,getCalle(),newCalle);
		else
			instanceExtension.markDirty(9);
		dataCacheEntry.setCalle(newCalle);
	}
	/**
	 * Get accessor for persistent attribute: nro
	 */
	public java.lang.String getNro() {
		return dataCacheEntry.getNro();
	}
	/**
	 * Set accessor for persistent attribute: nro
	 */
	public void setNro(java.lang.String newNro) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(10,getNro(),newNro);
		else
			instanceExtension.markDirty(10);
		dataCacheEntry.setNro(newNro);
	}
	/**
	 * Get accessor for persistent attribute: perfil
	 */
	public java.lang.String getPerfil() {
		return dataCacheEntry.getPerfil();
	}
	/**
	 * Set accessor for persistent attribute: perfil
	 */
	public void setPerfil(java.lang.String newPerfil) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(11,getPerfil(),newPerfil);
		else
			instanceExtension.markDirty(11);
		dataCacheEntry.setPerfil(newPerfil);
	}
	/**
	 * Get accessor for persistent attribute: direc1
	 */
	public java.lang.String getDirec1() {
		return dataCacheEntry.getDirec1();
	}
	/**
	 * Set accessor for persistent attribute: direc1
	 */
	public void setDirec1(java.lang.String newDirec1) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(12,getDirec1(),newDirec1);
		else
			instanceExtension.markDirty(12);
		dataCacheEntry.setDirec1(newDirec1);
	}
	/**
	 * Get accessor for persistent attribute: distrito
	 */
	public java.lang.String getDistrito() {
		return dataCacheEntry.getDistrito();
	}
	/**
	 * Set accessor for persistent attribute: distrito
	 */
	public void setDistrito(java.lang.String newDistrito) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(13,getDistrito(),newDistrito);
		else
			instanceExtension.markDirty(13);
		dataCacheEntry.setDistrito(newDistrito);
	}
	/**
	 * Get accessor for persistent attribute: provincia
	 */
	public java.lang.String getProvincia() {
		return dataCacheEntry.getProvincia();
	}
	/**
	 * Set accessor for persistent attribute: provincia
	 */
	public void setProvincia(java.lang.String newProvincia) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(14,getProvincia(),newProvincia);
		else
			instanceExtension.markDirty(14);
		dataCacheEntry.setProvincia(newProvincia);
	}
	/**
	 * Get accessor for persistent attribute: departamento
	 */
	public java.lang.String getDepartamento() {
		return dataCacheEntry.getDepartamento();
	}
	/**
	 * Set accessor for persistent attribute: departamento
	 */
	public void setDepartamento(java.lang.String newDepartamento) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(15,getDepartamento(),newDepartamento);
		else
			instanceExtension.markDirty(15);
		dataCacheEntry.setDepartamento(newDepartamento);
	}
	/**
	 * Get accessor for persistent attribute: tipo_persona
	 */
	public java.lang.String getTipo_persona() {
		return dataCacheEntry.getTipo_persona();
	}
	/**
	 * Set accessor for persistent attribute: tipo_persona
	 */
	public void setTipo_persona(java.lang.String newTipo_persona) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(16,getTipo_persona(),newTipo_persona);
		else
			instanceExtension.markDirty(16);
		dataCacheEntry.setTipo_persona(newTipo_persona);
	}
	/**
	 * Get accessor for persistent attribute: clasificacion
	 */
	public java.lang.String getClasificacion() {
		return dataCacheEntry.getClasificacion();
	}
	/**
	 * Set accessor for persistent attribute: clasificacion
	 */
	public void setClasificacion(java.lang.String newClasificacion) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(17,getClasificacion(),newClasificacion);
		else
			instanceExtension.markDirty(17);
		dataCacheEntry.setClasificacion(newClasificacion);
	}
	/**
	 * Get accessor for persistent attribute: telefono
	 */
	public java.lang.String getTelefono() {
		return dataCacheEntry.getTelefono();
	}
	/**
	 * Set accessor for persistent attribute: telefono
	 */
	public void setTelefono(java.lang.String newTelefono) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(18,getTelefono(),newTelefono);
		else
			instanceExtension.markDirty(18);
		dataCacheEntry.setTelefono(newTelefono);
	}
	/**
	 * Get accessor for persistent attribute: vinculacion
	 */
	public java.lang.String getVinculacion() {
		return dataCacheEntry.getVinculacion();
	}
	/**
	 * Set accessor for persistent attribute: vinculacion
	 */
	public void setVinculacion(java.lang.String newVinculacion) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(19,getVinculacion(),newVinculacion);
		else
			instanceExtension.markDirty(19);
		dataCacheEntry.setVinculacion(newVinculacion);
	}
	/**
	 * Get accessor for persistent attribute: pper
	 */
	public java.math.BigDecimal getPper() {
		return dataCacheEntry.getPper();
	}
	/**
	 * Set accessor for persistent attribute: pper
	 */
	public void setPper(java.math.BigDecimal newPper) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(20,getPper(),newPper);
		else
			instanceExtension.markDirty(20);
		dataCacheEntry.setPper(newPper);
	}
	/**
	 * Get accessor for persistent attribute: pcom
	 */
	public java.math.BigDecimal getPcom() {
		return dataCacheEntry.getPcom();
	}
	/**
	 * Set accessor for persistent attribute: pcom
	 */
	public void setPcom(java.math.BigDecimal newPcom) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(21,getPcom(),newPcom);
		else
			instanceExtension.markDirty(21);
		dataCacheEntry.setPcom(newPcom);
	}
	/**
	 * Get accessor for persistent attribute: vnac
	 */
	public java.math.BigDecimal getVnac() {
		return dataCacheEntry.getVnac();
	}
	/**
	 * Set accessor for persistent attribute: vnac
	 */
	public void setVnac(java.math.BigDecimal newVnac) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(22,getVnac(),newVnac);
		else
			instanceExtension.markDirty(22);
		dataCacheEntry.setVnac(newVnac);
	}
	/**
	 * Get accessor for persistent attribute: ccte
	 */
	public java.math.BigDecimal getCcte() {
		return dataCacheEntry.getCcte();
	}
	/**
	 * Set accessor for persistent attribute: ccte
	 */
	public void setCcte(java.math.BigDecimal newCcte) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(23,getCcte(),newCcte);
		else
			instanceExtension.markDirty(23);
		dataCacheEntry.setCcte(newCcte);
	}
	/**
	 * Get accessor for persistent attribute: colb
	 */
	public java.math.BigDecimal getColb() {
		return dataCacheEntry.getColb();
	}
	/**
	 * Set accessor for persistent attribute: colb
	 */
	public void setColb(java.math.BigDecimal newColb) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(24,getColb(),newColb);
		else
			instanceExtension.markDirty(24);
		dataCacheEntry.setColb(newColb);
	}
	/**
	 * Get accessor for persistent attribute: cnet
	 */
	public java.math.BigDecimal getCnet() {
		return dataCacheEntry.getCnet();
	}
	/**
	 * Set accessor for persistent attribute: cnet
	 */
	public void setCnet(java.math.BigDecimal newCnet) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(25,getCnet(),newCnet);
		else
			instanceExtension.markDirty(25);
		dataCacheEntry.setCnet(newCnet);
	}
	/**
	 * Get accessor for persistent attribute: paut
	 */
	public java.math.BigDecimal getPaut() {
		return dataCacheEntry.getPaut();
	}
	/**
	 * Set accessor for persistent attribute: paut
	 */
	public void setPaut(java.math.BigDecimal newPaut) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(26,getPaut(),newPaut);
		else
			instanceExtension.markDirty(26);
		dataCacheEntry.setPaut(newPaut);
	}
	/**
	 * Get accessor for persistent attribute: dsct
	 */
	public java.math.BigDecimal getDsct() {
		return dataCacheEntry.getDsct();
	}
	/**
	 * Set accessor for persistent attribute: dsct
	 */
	public void setDsct(java.math.BigDecimal newDsct) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(27,getDsct(),newDsct);
		else
			instanceExtension.markDirty(27);
		dataCacheEntry.setDsct(newDsct);
	}
	/**
	 * Get accessor for persistent attribute: varc
	 */
	public java.math.BigDecimal getVarc() {
		return dataCacheEntry.getVarc();
	}
	/**
	 * Set accessor for persistent attribute: varc
	 */
	public void setVarc(java.math.BigDecimal newVarc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(28,getVarc(),newVarc);
		else
			instanceExtension.markDirty(28);
		dataCacheEntry.setVarc(newVarc);
	}
	/**
	 * Get accessor for persistent attribute: cemp
	 */
	public java.math.BigDecimal getCemp() {
		return dataCacheEntry.getCemp();
	}
	/**
	 * Set accessor for persistent attribute: cemp
	 */
	public void setCemp(java.math.BigDecimal newCemp) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(29,getCemp(),newCemp);
		else
			instanceExtension.markDirty(29);
		dataCacheEntry.setCemp(newCemp);
	}
	/**
	 * Get accessor for persistent attribute: sdep
	 */
	public java.math.BigDecimal getSdep() {
		return dataCacheEntry.getSdep();
	}
	/**
	 * Set accessor for persistent attribute: sdep
	 */
	public void setSdep(java.math.BigDecimal newSdep) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(30,getSdep(),newSdep);
		else
			instanceExtension.markDirty(30);
		dataCacheEntry.setSdep(newSdep);
	}
	/**
	 * Get accessor for persistent attribute: cext
	 */
	public java.math.BigDecimal getCext() {
		return dataCacheEntry.getCext();
	}
	/**
	 * Set accessor for persistent attribute: cext
	 */
	public void setCext(java.math.BigDecimal newCext) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(31,getCext(),newCext);
		else
			instanceExtension.markDirty(31);
		dataCacheEntry.setCext(newCext);
	}
	/**
	 * Get accessor for persistent attribute: phip
	 */
	public java.math.BigDecimal getPhip() {
		return dataCacheEntry.getPhip();
	}
	/**
	 * Set accessor for persistent attribute: phip
	 */
	public void setPhip(java.math.BigDecimal newPhip) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(32,getPhip(),newPhip);
		else
			instanceExtension.markDirty(32);
		dataCacheEntry.setPhip(newPhip);
	}
	/**
	 * Get accessor for persistent attribute: leas
	 */
	public java.math.BigDecimal getLeas() {
		return dataCacheEntry.getLeas();
	}
	/**
	 * Set accessor for persistent attribute: leas
	 */
	public void setLeas(java.math.BigDecimal newLeas) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(33,getLeas(),newLeas);
		else
			instanceExtension.markDirty(33);
		dataCacheEntry.setLeas(newLeas);
	}
	/**
	 * Get accessor for persistent attribute: vcla
	 */
	public java.math.BigDecimal getVcla() {
		return dataCacheEntry.getVcla();
	}
	/**
	 * Set accessor for persistent attribute: vcla
	 */
	public void setVcla(java.math.BigDecimal newVcla) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(34,getVcla(),newVcla);
		else
			instanceExtension.markDirty(34);
		dataCacheEntry.setVcla(newVcla);
	}
	/**
	 * Get accessor for persistent attribute: cvip
	 */
	public java.math.BigDecimal getCvip() {
		return dataCacheEntry.getCvip();
	}
	/**
	 * Set accessor for persistent attribute: cvip
	 */
	public void setCvip(java.math.BigDecimal newCvip) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(35,getCvip(),newCvip);
		else
			instanceExtension.markDirty(35);
		dataCacheEntry.setCvip(newCvip);
	}
	/**
	 * Get accessor for persistent attribute: svid
	 */
	public java.math.BigDecimal getSvid() {
		return dataCacheEntry.getSvid();
	}
	/**
	 * Set accessor for persistent attribute: svid
	 */
	public void setSvid(java.math.BigDecimal newSvid) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(36,getSvid(),newSvid);
		else
			instanceExtension.markDirty(36);
		dataCacheEntry.setSvid(newSvid);
	}
	/**
	 * Get accessor for persistent attribute: linco
	 */
	public java.math.BigDecimal getLinco() {
		return dataCacheEntry.getLinco();
	}
	/**
	 * Set accessor for persistent attribute: linco
	 */
	public void setLinco(java.math.BigDecimal newLinco) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(37,getLinco(),newLinco);
		else
			instanceExtension.markDirty(37);
		dataCacheEntry.setLinco(newLinco);
	}
	/**
	 * Get accessor for persistent attribute: pmiv
	 */
	public java.math.BigDecimal getPmiv() {
		return dataCacheEntry.getPmiv();
	}
	/**
	 * Set accessor for persistent attribute: pmiv
	 */
	public void setPmiv(java.math.BigDecimal newPmiv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(38,getPmiv(),newPmiv);
		else
			instanceExtension.markDirty(38);
		dataCacheEntry.setPmiv(newPmiv);
	}
	/**
	 * Get accessor for persistent attribute: cloc
	 */
	public java.math.BigDecimal getCloc() {
		return dataCacheEntry.getCloc();
	}
	/**
	 * Set accessor for persistent attribute: cloc
	 */
	public void setCloc(java.math.BigDecimal newCloc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(39,getCloc(),newCloc);
		else
			instanceExtension.markDirty(39);
		dataCacheEntry.setCloc(newCloc);
	}
	/**
	 * Get accessor for persistent attribute: vrep
	 */
	public java.math.BigDecimal getVrep() {
		return dataCacheEntry.getVrep();
	}
	/**
	 * Set accessor for persistent attribute: vrep
	 */
	public void setVrep(java.math.BigDecimal newVrep) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(40,getVrep(),newVrep);
		else
			instanceExtension.markDirty(40);
		dataCacheEntry.setVrep(newVrep);
	}
	/**
	 * Get accessor for persistent attribute: ahsd
	 */
	public java.math.BigDecimal getAhsd() {
		return dataCacheEntry.getAhsd();
	}
	/**
	 * Set accessor for persistent attribute: ahsd
	 */
	public void setAhsd(java.math.BigDecimal newAhsd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(41,getAhsd(),newAhsd);
		else
			instanceExtension.markDirty(41);
		dataCacheEntry.setAhsd(newAhsd);
	}
	/**
	 * Get accessor for persistent attribute: sonc
	 */
	public java.math.BigDecimal getSonc() {
		return dataCacheEntry.getSonc();
	}
	/**
	 * Set accessor for persistent attribute: sonc
	 */
	public void setSonc(java.math.BigDecimal newSonc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(42,getSonc(),newSonc);
		else
			instanceExtension.markDirty(42);
		dataCacheEntry.setSonc(newSonc);
	}
	/**
	 * Get accessor for persistent attribute: tco
	 */
	public java.math.BigDecimal getTco() {
		return dataCacheEntry.getTco();
	}
	/**
	 * Set accessor for persistent attribute: tco
	 */
	public void setTco(java.math.BigDecimal newTco) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(43,getTco(),newTco);
		else
			instanceExtension.markDirty(43);
		dataCacheEntry.setTco(newTco);
	}
	/**
	 * Get accessor for persistent attribute: b24
	 */
	public java.math.BigDecimal getB24() {
		return dataCacheEntry.getB24();
	}
	/**
	 * Set accessor for persistent attribute: b24
	 */
	public void setB24(java.math.BigDecimal newB24) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(44,getB24(),newB24);
		else
			instanceExtension.markDirty(44);
		dataCacheEntry.setB24(newB24);
	}
	/**
	 * Get accessor for persistent attribute: cpte
	 */
	public java.math.BigDecimal getCpte() {
		return dataCacheEntry.getCpte();
	}
	/**
	 * Set accessor for persistent attribute: cpte
	 */
	public void setCpte(java.math.BigDecimal newCpte) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(45,getCpte(),newCpte);
		else
			instanceExtension.markDirty(45);
		dataCacheEntry.setCpte(newCpte);
	}
	/**
	 * Get accessor for persistent attribute: pref
	 */
	public java.math.BigDecimal getPref() {
		return dataCacheEntry.getPref();
	}
	/**
	 * Set accessor for persistent attribute: pref
	 */
	public void setPref(java.math.BigDecimal newPref) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(46,getPref(),newPref);
		else
			instanceExtension.markDirty(46);
		dataCacheEntry.setPref(newPref);
	}
	/**
	 * Get accessor for persistent attribute: voro
	 */
	public java.math.BigDecimal getVoro() {
		return dataCacheEntry.getVoro();
	}
	/**
	 * Set accessor for persistent attribute: voro
	 */
	public void setVoro(java.math.BigDecimal newVoro) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(47,getVoro(),newVoro);
		else
			instanceExtension.markDirty(47);
		dataCacheEntry.setVoro(newVoro);
	}
	/**
	 * Get accessor for persistent attribute: ahor
	 */
	public java.math.BigDecimal getAhor() {
		return dataCacheEntry.getAhor();
	}
	/**
	 * Set accessor for persistent attribute: ahor
	 */
	public void setAhor(java.math.BigDecimal newAhor) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(48,getAhor(),newAhor);
		else
			instanceExtension.markDirty(48);
		dataCacheEntry.setAhor(newAhor);
	}
	/**
	 * Get accessor for persistent attribute: spro
	 */
	public java.math.BigDecimal getSpro() {
		return dataCacheEntry.getSpro();
	}
	/**
	 * Set accessor for persistent attribute: spro
	 */
	public void setSpro(java.math.BigDecimal newSpro) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(49,getSpro(),newSpro);
		else
			instanceExtension.markDirty(49);
		dataCacheEntry.setSpro(newSpro);
	}
	/**
	 * Get accessor for persistent attribute: pos
	 */
	public java.math.BigDecimal getPos() {
		return dataCacheEntry.getPos();
	}
	/**
	 * Set accessor for persistent attribute: pos
	 */
	public void setPos(java.math.BigDecimal newPos) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(50,getPos(),newPos);
		else
			instanceExtension.markDirty(50);
		dataCacheEntry.setPos(newPos);
	}
	/**
	 * Get accessor for persistent attribute: t_act2
	 */
	public java.math.BigDecimal getT_act2() {
		return dataCacheEntry.getT_act2();
	}
	/**
	 * Set accessor for persistent attribute: t_act2
	 */
	public void setT_act2(java.math.BigDecimal newT_act2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(51,getT_act2(),newT_act2);
		else
			instanceExtension.markDirty(51);
		dataCacheEntry.setT_act2(newT_act2);
	}
	/**
	 * Get accessor for persistent attribute: pmas
	 */
	public java.math.BigDecimal getPmas() {
		return dataCacheEntry.getPmas();
	}
	/**
	 * Set accessor for persistent attribute: pmas
	 */
	public void setPmas(java.math.BigDecimal newPmas) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(52,getPmas(),newPmas);
		else
			instanceExtension.markDirty(52);
		dataCacheEntry.setPmas(newPmas);
	}
	/**
	 * Get accessor for persistent attribute: t_act3
	 */
	public java.math.BigDecimal getT_act3() {
		return dataCacheEntry.getT_act3();
	}
	/**
	 * Set accessor for persistent attribute: t_act3
	 */
	public void setT_act3(java.math.BigDecimal newT_act3) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(53,getT_act3(),newT_act3);
		else
			instanceExtension.markDirty(53);
		dataCacheEntry.setT_act3(newT_act3);
	}
	/**
	 * Get accessor for persistent attribute: lcta
	 */
	public java.math.BigDecimal getLcta() {
		return dataCacheEntry.getLcta();
	}
	/**
	 * Set accessor for persistent attribute: lcta
	 */
	public void setLcta(java.math.BigDecimal newLcta) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(54,getLcta(),newLcta);
		else
			instanceExtension.markDirty(54);
		dataCacheEntry.setLcta(newLcta);
	}
	/**
	 * Get accessor for persistent attribute: t_act4
	 */
	public java.math.BigDecimal getT_act4() {
		return dataCacheEntry.getT_act4();
	}
	/**
	 * Set accessor for persistent attribute: t_act4
	 */
	public void setT_act4(java.math.BigDecimal newT_act4) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(55,getT_act4(),newT_act4);
		else
			instanceExtension.markDirty(55);
		dataCacheEntry.setT_act4(newT_act4);
	}
	/**
	 * Get accessor for persistent attribute: vpla
	 */
	public java.math.BigDecimal getVpla() {
		return dataCacheEntry.getVpla();
	}
	/**
	 * Set accessor for persistent attribute: vpla
	 */
	public void setVpla(java.math.BigDecimal newVpla) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(56,getVpla(),newVpla);
		else
			instanceExtension.markDirty(56);
		dataCacheEntry.setVpla(newVpla);
	}
	/**
	 * Get accessor for persistent attribute: t_act5
	 */
	public java.math.BigDecimal getT_act5() {
		return dataCacheEntry.getT_act5();
	}
	/**
	 * Set accessor for persistent attribute: t_act5
	 */
	public void setT_act5(java.math.BigDecimal newT_act5) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(57,getT_act5(),newT_act5);
		else
			instanceExtension.markDirty(57);
		dataCacheEntry.setT_act5(newT_act5);
	}
	/**
	 * Get accessor for persistent attribute: plzo
	 */
	public java.math.BigDecimal getPlzo() {
		return dataCacheEntry.getPlzo();
	}
	/**
	 * Set accessor for persistent attribute: plzo
	 */
	public void setPlzo(java.math.BigDecimal newPlzo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(58,getPlzo(),newPlzo);
		else
			instanceExtension.markDirty(58);
		dataCacheEntry.setPlzo(newPlzo);
	}
	/**
	 * Get accessor for persistent attribute: t_act6
	 */
	public java.math.BigDecimal getT_act6() {
		return dataCacheEntry.getT_act6();
	}
	/**
	 * Set accessor for persistent attribute: t_act6
	 */
	public void setT_act6(java.math.BigDecimal newT_act6) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(59,getT_act6(),newT_act6);
		else
			instanceExtension.markDirty(59);
		dataCacheEntry.setT_act6(newT_act6);
	}
	/**
	 * Get accessor for persistent attribute: pserv
	 */
	public java.math.BigDecimal getPserv() {
		return dataCacheEntry.getPserv();
	}
	/**
	 * Set accessor for persistent attribute: pserv
	 */
	public void setPserv(java.math.BigDecimal newPserv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(60,getPserv(),newPserv);
		else
			instanceExtension.markDirty(60);
		dataCacheEntry.setPserv(newPserv);
	}
	/**
	 * Get accessor for persistent attribute: tpr
	 */
	public java.math.BigDecimal getTpr() {
		return dataCacheEntry.getTpr();
	}
	/**
	 * Set accessor for persistent attribute: tpr
	 */
	public void setTpr(java.math.BigDecimal newTpr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(61,getTpr(),newTpr);
		else
			instanceExtension.markDirty(61);
		dataCacheEntry.setTpr(newTpr);
	}
	/**
	 * Get accessor for persistent attribute: prom
	 */
	public java.math.BigDecimal getProm() {
		return dataCacheEntry.getProm();
	}
	/**
	 * Set accessor for persistent attribute: prom
	 */
	public void setProm(java.math.BigDecimal newProm) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(62,getProm(),newProm);
		else
			instanceExtension.markDirty(62);
		dataCacheEntry.setProm(newProm);
	}
	/**
	 * Get accessor for persistent attribute: t_act_ct2
	 */
	public java.math.BigDecimal getT_act_ct2() {
		return dataCacheEntry.getT_act_ct2();
	}
	/**
	 * Set accessor for persistent attribute: t_act_ct2
	 */
	public void setT_act_ct2(java.math.BigDecimal newT_act_ct2) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(63,getT_act_ct2(),newT_act_ct2);
		else
			instanceExtension.markDirty(63);
		dataCacheEntry.setT_act_ct2(newT_act_ct2);
	}
	/**
	 * Get accessor for persistent attribute: vemp
	 */
	public java.math.BigDecimal getVemp() {
		return dataCacheEntry.getVemp();
	}
	/**
	 * Set accessor for persistent attribute: vemp
	 */
	public void setVemp(java.math.BigDecimal newVemp) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(64,getVemp(),newVemp);
		else
			instanceExtension.markDirty(64);
		dataCacheEntry.setVemp(newVemp);
	}
	/**
	 * Get accessor for persistent attribute: t_act_ct3
	 */
	public java.math.BigDecimal getT_act_ct3() {
		return dataCacheEntry.getT_act_ct3();
	}
	/**
	 * Set accessor for persistent attribute: t_act_ct3
	 */
	public void setT_act_ct3(java.math.BigDecimal newT_act_ct3) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(65,getT_act_ct3(),newT_act_ct3);
		else
			instanceExtension.markDirty(65);
		dataCacheEntry.setT_act_ct3(newT_act_ct3);
	}
	/**
	 * Get accessor for persistent attribute: ph
	 */
	public java.math.BigDecimal getPh() {
		return dataCacheEntry.getPh();
	}
	/**
	 * Set accessor for persistent attribute: ph
	 */
	public void setPh(java.math.BigDecimal newPh) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(66,getPh(),newPh);
		else
			instanceExtension.markDirty(66);
		dataCacheEntry.setPh(newPh);
	}
	/**
	 * Get accessor for persistent attribute: t_act_ct4
	 */
	public java.math.BigDecimal getT_act_ct4() {
		return dataCacheEntry.getT_act_ct4();
	}
	/**
	 * Set accessor for persistent attribute: t_act_ct4
	 */
	public void setT_act_ct4(java.math.BigDecimal newT_act_ct4) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(67,getT_act_ct4(),newT_act_ct4);
		else
			instanceExtension.markDirty(67);
		dataCacheEntry.setT_act_ct4(newT_act_ct4);
	}
	/**
	 * Get accessor for persistent attribute: fcex
	 */
	public java.math.BigDecimal getFcex() {
		return dataCacheEntry.getFcex();
	}
	/**
	 * Set accessor for persistent attribute: fcex
	 */
	public void setFcex(java.math.BigDecimal newFcex) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(68,getFcex(),newFcex);
		else
			instanceExtension.markDirty(68);
		dataCacheEntry.setFcex(newFcex);
	}
	/**
	 * Get accessor for persistent attribute: t_act_ct5
	 */
	public java.math.BigDecimal getT_act_ct5() {
		return dataCacheEntry.getT_act_ct5();
	}
	/**
	 * Set accessor for persistent attribute: t_act_ct5
	 */
	public void setT_act_ct5(java.math.BigDecimal newT_act_ct5) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(69,getT_act_ct5(),newT_act_ct5);
		else
			instanceExtension.markDirty(69);
		dataCacheEntry.setT_act_ct5(newT_act_ct5);
	}
	/**
	 * Get accessor for persistent attribute: vctr
	 */
	public java.math.BigDecimal getVctr() {
		return dataCacheEntry.getVctr();
	}
	/**
	 * Set accessor for persistent attribute: vctr
	 */
	public void setVctr(java.math.BigDecimal newVctr) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(70,getVctr(),newVctr);
		else
			instanceExtension.markDirty(70);
		dataCacheEntry.setVctr(newVctr);
	}
	/**
	 * Get accessor for persistent attribute: t_act_ct6
	 */
	public java.math.BigDecimal getT_act_ct6() {
		return dataCacheEntry.getT_act_ct6();
	}
	/**
	 * Set accessor for persistent attribute: t_act_ct6
	 */
	public void setT_act_ct6(java.math.BigDecimal newT_act_ct6) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(71,getT_act_ct6(),newT_act_ct6);
		else
			instanceExtension.markDirty(71);
		dataCacheEntry.setT_act_ct6(newT_act_ct6);
	}
	/**
	 * Get accessor for persistent attribute: fmut
	 */
	public java.math.BigDecimal getFmut() {
		return dataCacheEntry.getFmut();
	}
	/**
	 * Set accessor for persistent attribute: fmut
	 */
	public void setFmut(java.math.BigDecimal newFmut) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(72,getFmut(),newFmut);
		else
			instanceExtension.markDirty(72);
		dataCacheEntry.setFmut(newFmut);
	}
	/**
	 * Get accessor for persistent attribute: margeno
	 */
	public java.math.BigDecimal getMargeno() {
		return dataCacheEntry.getMargeno();
	}
	/**
	 * Set accessor for persistent attribute: margeno
	 */
	public void setMargeno(java.math.BigDecimal newMargeno) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(73,getMargeno(),newMargeno);
		else
			instanceExtension.markDirty(73);
		dataCacheEntry.setMargeno(newMargeno);
	}
	/**
	 * Get accessor for persistent attribute: nro_documento
	 */
	public java.lang.String getNro_documento() {
		return dataCacheEntry.getNro_documento();
	}
	/**
	 * Set accessor for persistent attribute: nro_documento
	 */
	public void setNro_documento(java.lang.String newNro_documento) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(74,getNro_documento(),newNro_documento);
		else
			instanceExtension.markDirty(74);
		dataCacheEntry.setNro_documento(newNro_documento);
	}
	/**
	 * Get accessor for persistent attribute: bcorie
	 */
	public java.math.BigDecimal getBcorie() {
		return dataCacheEntry.getBcorie();
	}
	/**
	 * Set accessor for persistent attribute: bcorie
	 */
	public void setBcorie(java.math.BigDecimal newBcorie) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(75,getBcorie(),newBcorie);
		else
			instanceExtension.markDirty(75);
		dataCacheEntry.setBcorie(newBcorie);
	}
	/**
	 * Get accessor for persistent attribute: emph
	 */
	public java.math.BigDecimal getEmph() {
		return dataCacheEntry.getEmph();
	}
	/**
	 * Set accessor for persistent attribute: emph
	 */
	public void setEmph(java.math.BigDecimal newEmph) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(76,getEmph(),newEmph);
		else
			instanceExtension.markDirty(76);
		dataCacheEntry.setEmph(newEmph);
	}
	/**
	 * Get accessor for persistent attribute: bcorid
	 */
	public java.math.BigDecimal getBcorid() {
		return dataCacheEntry.getBcorid();
	}
	/**
	 * Set accessor for persistent attribute: bcorid
	 */
	public void setBcorid(java.math.BigDecimal newBcorid) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(77,getBcorid(),newBcorid);
		else
			instanceExtension.markDirty(77);
		dataCacheEntry.setBcorid(newBcorid);
	}
	/**
	 * Get accessor for persistent attribute: aval
	 */
	public java.math.BigDecimal getAval() {
		return dataCacheEntry.getAval();
	}
	/**
	 * Set accessor for persistent attribute: aval
	 */
	public void setAval(java.math.BigDecimal newAval) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(78,getAval(),newAval);
		else
			instanceExtension.markDirty(78);
		dataCacheEntry.setAval(newAval);
	}
	/**
	 * Get accessor for persistent attribute: bcorii
	 */
	public java.math.BigDecimal getBcorii() {
		return dataCacheEntry.getBcorii();
	}
	/**
	 * Set accessor for persistent attribute: bcorii
	 */
	public void setBcorii(java.math.BigDecimal newBcorii) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(79,getBcorii(),newBcorii);
		else
			instanceExtension.markDirty(79);
		dataCacheEntry.setBcorii(newBcorii);
	}
	/**
	 * Get accessor for persistent attribute: mcla
	 */
	public java.math.BigDecimal getMcla() {
		return dataCacheEntry.getMcla();
	}
	/**
	 * Set accessor for persistent attribute: mcla
	 */
	public void setMcla(java.math.BigDecimal newMcla) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(80,getMcla(),newMcla);
		else
			instanceExtension.markDirty(80);
		dataCacheEntry.setMcla(newMcla);
	}
	/**
	 * Get accessor for persistent attribute: bcopas
	 */
	public java.math.BigDecimal getBcopas() {
		return dataCacheEntry.getBcopas();
	}
	/**
	 * Set accessor for persistent attribute: bcopas
	 */
	public void setBcopas(java.math.BigDecimal newBcopas) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(81,getBcopas(),newBcopas);
		else
			instanceExtension.markDirty(81);
		dataCacheEntry.setBcopas(newBcopas);
	}
	/**
	 * Get accessor for persistent attribute: cts
	 */
	public java.math.BigDecimal getCts() {
		return dataCacheEntry.getCts();
	}
	/**
	 * Set accessor for persistent attribute: cts
	 */
	public void setCts(java.math.BigDecimal newCts) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(82,getCts(),newCts);
		else
			instanceExtension.markDirty(82);
		dataCacheEntry.setCts(newCts);
	}
	/**
	 * Get accessor for persistent attribute: bcovol
	 */
	public java.math.BigDecimal getBcovol() {
		return dataCacheEntry.getBcovol();
	}
	/**
	 * Set accessor for persistent attribute: bcovol
	 */
	public void setBcovol(java.math.BigDecimal newBcovol) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(83,getBcovol(),newBcovol);
		else
			instanceExtension.markDirty(83);
		dataCacheEntry.setBcovol(newBcovol);
	}
	/**
	 * Get accessor for persistent attribute: tdeb
	 */
	public java.math.BigDecimal getTdeb() {
		return dataCacheEntry.getTdeb();
	}
	/**
	 * Set accessor for persistent attribute: tdeb
	 */
	public void setTdeb(java.math.BigDecimal newTdeb) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(84,getTdeb(),newTdeb);
		else
			instanceExtension.markDirty(84);
		dataCacheEntry.setTdeb(newTdeb);
	}
	/**
	 * Get accessor for persistent attribute: porcrie
	 */
	public java.math.BigDecimal getPorcrie() {
		return dataCacheEntry.getPorcrie();
	}
	/**
	 * Set accessor for persistent attribute: porcrie
	 */
	public void setPorcrie(java.math.BigDecimal newPorcrie) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(85,getPorcrie(),newPorcrie);
		else
			instanceExtension.markDirty(85);
		dataCacheEntry.setPorcrie(newPorcrie);
	}
	/**
	 * Get accessor for persistent attribute: moro
	 */
	public java.math.BigDecimal getMoro() {
		return dataCacheEntry.getMoro();
	}
	/**
	 * Set accessor for persistent attribute: moro
	 */
	public void setMoro(java.math.BigDecimal newMoro) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(86,getMoro(),newMoro);
		else
			instanceExtension.markDirty(86);
		dataCacheEntry.setMoro(newMoro);
	}
	/**
	 * Get accessor for persistent attribute: porcrid
	 */
	public java.math.BigDecimal getPorcrid() {
		return dataCacheEntry.getPorcrid();
	}
	/**
	 * Set accessor for persistent attribute: porcrid
	 */
	public void setPorcrid(java.math.BigDecimal newPorcrid) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(87,getPorcrid(),newPorcrid);
		else
			instanceExtension.markDirty(87);
		dataCacheEntry.setPorcrid(newPorcrid);
	}
	/**
	 * Get accessor for persistent attribute: ctsd
	 */
	public java.math.BigDecimal getCtsd() {
		return dataCacheEntry.getCtsd();
	}
	/**
	 * Set accessor for persistent attribute: ctsd
	 */
	public void setCtsd(java.math.BigDecimal newCtsd) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(88,getCtsd(),newCtsd);
		else
			instanceExtension.markDirty(88);
		dataCacheEntry.setCtsd(newCtsd);
	}
	/**
	 * Get accessor for persistent attribute: porcrii
	 */
	public java.math.BigDecimal getPorcrii() {
		return dataCacheEntry.getPorcrii();
	}
	/**
	 * Set accessor for persistent attribute: porcrii
	 */
	public void setPorcrii(java.math.BigDecimal newPorcrii) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(89,getPorcrii(),newPorcrii);
		else
			instanceExtension.markDirty(89);
		dataCacheEntry.setPorcrii(newPorcrii);
	}
	/**
	 * Get accessor for persistent attribute: tvip
	 */
	public java.math.BigDecimal getTvip() {
		return dataCacheEntry.getTvip();
	}
	/**
	 * Set accessor for persistent attribute: tvip
	 */
	public void setTvip(java.math.BigDecimal newTvip) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(90,getTvip(),newTvip);
		else
			instanceExtension.markDirty(90);
		dataCacheEntry.setTvip(newTvip);
	}
	/**
	 * Get accessor for persistent attribute: sbsrie
	 */
	public java.math.BigDecimal getSbsrie() {
		return dataCacheEntry.getSbsrie();
	}
	/**
	 * Set accessor for persistent attribute: sbsrie
	 */
	public void setSbsrie(java.math.BigDecimal newSbsrie) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(91,getSbsrie(),newSbsrie);
		else
			instanceExtension.markDirty(91);
		dataCacheEntry.setSbsrie(newSbsrie);
	}
	/**
	 * Get accessor for persistent attribute: sbsrid
	 */
	public java.math.BigDecimal getSbsrid() {
		return dataCacheEntry.getSbsrid();
	}
	/**
	 * Set accessor for persistent attribute: sbsrid
	 */
	public void setSbsrid(java.math.BigDecimal newSbsrid) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(92,getSbsrid(),newSbsrid);
		else
			instanceExtension.markDirty(92);
		dataCacheEntry.setSbsrid(newSbsrid);
	}
	/**
	 * Get accessor for persistent attribute: sbsrii
	 */
	public java.math.BigDecimal getSbsrii() {
		return dataCacheEntry.getSbsrii();
	}
	/**
	 * Set accessor for persistent attribute: sbsrii
	 */
	public void setSbsrii(java.math.BigDecimal newSbsrii) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(93,getSbsrii(),newSbsrii);
		else
			instanceExtension.markDirty(93);
		dataCacheEntry.setSbsrii(newSbsrii);
	}
	/**
	 * Get accessor for persistent attribute: sbsjud
	 */
	public java.math.BigDecimal getSbsjud() {
		return dataCacheEntry.getSbsjud();
	}
	/**
	 * Set accessor for persistent attribute: sbsjud
	 */
	public void setSbsjud(java.math.BigDecimal newSbsjud) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(94,getSbsjud(),newSbsjud);
		else
			instanceExtension.markDirty(94);
		dataCacheEntry.setSbsjud(newSbsjud);
	}
	/**
	 * Get accessor for persistent attribute: cod_empresa
	 */
	public java.lang.String getCod_empresa() {
		return dataCacheEntry.getCod_empresa();
	}
	/**
	 * Set accessor for persistent attribute: cod_empresa
	 */
	public void setCod_empresa(java.lang.String newCod_empresa) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(95,getCod_empresa(),newCod_empresa);
		else
			instanceExtension.markDirty(95);
		dataCacheEntry.setCod_empresa(newCod_empresa);
	}
	/**
	 * Get accessor for persistent attribute: des_empresa
	 */
	public java.lang.String getDes_empresa() {
		return dataCacheEntry.getDes_empresa();
	}
	/**
	 * Set accessor for persistent attribute: des_empresa
	 */
	public void setDes_empresa(java.lang.String newDes_empresa) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(96,getDes_empresa(),newDes_empresa);
		else
			instanceExtension.markDirty(96);
		dataCacheEntry.setDes_empresa(newDes_empresa);
	}
	/**
	 * Get accessor for persistent attribute: intervpas
	 */
	public java.lang.String getIntervpas() {
		return dataCacheEntry.getIntervpas();
	}
	/**
	 * Set accessor for persistent attribute: intervpas
	 */
	public void setIntervpas(java.lang.String newIntervpas) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(97,getIntervpas(),newIntervpas);
		else
			instanceExtension.markDirty(97);
		dataCacheEntry.setIntervpas(newIntervpas);
	}
	/**
	 * Get accessor for persistent attribute: mofactv
	 */
	public java.math.BigDecimal getMofactv() {
		return dataCacheEntry.getMofactv();
	}
	/**
	 * Set accessor for persistent attribute: mofactv
	 */
	public void setMofactv(java.math.BigDecimal newMofactv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(98,getMofactv(),newMofactv);
		else
			instanceExtension.markDirty(98);
		dataCacheEntry.setMofactv(newMofactv);
	}
	/**
	 * Get accessor for persistent attribute: cs000lineamaxtc
	 */
	public java.math.BigDecimal getCs000lineamaxtc() {
		return dataCacheEntry.getCs000lineamaxtc();
	}
	/**
	 * Set accessor for persistent attribute: cs000lineamaxtc
	 */
	public void setCs000lineamaxtc(java.math.BigDecimal newCs000lineamaxtc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(99,getCs000lineamaxtc(),newCs000lineamaxtc);
		else
			instanceExtension.markDirty(99);
		dataCacheEntry.setCs000lineamaxtc(newCs000lineamaxtc);
	}
	/**
	 * Get accessor for persistent attribute: mofpasv
	 */
	public java.lang.String getMofpasv() {
		return dataCacheEntry.getMofpasv();
	}
	/**
	 * Set accessor for persistent attribute: mofpasv
	 */
	public void setMofpasv(java.lang.String newMofpasv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(100,getMofpasv(),newMofpasv);
		else
			instanceExtension.markDirty(100);
		dataCacheEntry.setMofpasv(newMofpasv);
	}
	/**
	 * Get accessor for persistent attribute: mofserv
	 */
	public java.lang.String getMofserv() {
		return dataCacheEntry.getMofserv();
	}
	/**
	 * Set accessor for persistent attribute: mofserv
	 */
	public void setMofserv(java.lang.String newMofserv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(101,getMofserv(),newMofserv);
		else
			instanceExtension.markDirty(101);
		dataCacheEntry.setMofserv(newMofserv);
	}
	/**
	 * Get accessor for persistent attribute: mofcanal
	 */
	public java.lang.String getMofcanal() {
		return dataCacheEntry.getMofcanal();
	}
	/**
	 * Set accessor for persistent attribute: mofcanal
	 */
	public void setMofcanal(java.lang.String newMofcanal) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(102,getMofcanal(),newMofcanal);
		else
			instanceExtension.markDirty(102);
		dataCacheEntry.setMofcanal(newMofcanal);
	}
	/**
	 * Get accessor for persistent attribute: mphpasv
	 */
	public java.lang.String getMphpasv() {
		return dataCacheEntry.getMphpasv();
	}
	/**
	 * Set accessor for persistent attribute: mphpasv
	 */
	public void setMphpasv(java.lang.String newMphpasv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(103,getMphpasv(),newMphpasv);
		else
			instanceExtension.markDirty(103);
		dataCacheEntry.setMphpasv(newMphpasv);
	}
	/**
	 * Get accessor for persistent attribute: cs000mtoprestamo
	 */
	public java.math.BigDecimal getCs000mtoprestamo() {
		return dataCacheEntry.getCs000mtoprestamo();
	}
	/**
	 * Set accessor for persistent attribute: cs000mtoprestamo
	 */
	public void setCs000mtoprestamo(java.math.BigDecimal newCs000mtoprestamo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(104,getCs000mtoprestamo(),newCs000mtoprestamo);
		else
			instanceExtension.markDirty(104);
		dataCacheEntry.setCs000mtoprestamo(newCs000mtoprestamo);
	}
	/**
	 * Get accessor for persistent attribute: montovehicular
	 */
	public java.math.BigDecimal getMontovehicular() {
		return dataCacheEntry.getMontovehicular();
	}
	/**
	 * Set accessor for persistent attribute: montovehicular
	 */
	public void setMontovehicular(java.math.BigDecimal newMontovehicular) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(105,getMontovehicular(),newMontovehicular);
		else
			instanceExtension.markDirty(105);
		dataCacheEntry.setMontovehicular(newMontovehicular);
	}
	/**
	 * Get accessor for persistent attribute: montohipotecario
	 */
	public java.math.BigDecimal getMontohipotecario() {
		return dataCacheEntry.getMontohipotecario();
	}
	/**
	 * Set accessor for persistent attribute: montohipotecario
	 */
	public void setMontohipotecario(java.math.BigDecimal newMontohipotecario) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(106,getMontohipotecario(),newMontohipotecario);
		else
			instanceExtension.markDirty(106);
		dataCacheEntry.setMontohipotecario(newMontohipotecario);
	}
	/**
	 * Get accessor for persistent attribute: ctacteoferta
	 */
	public java.lang.String getCtacteoferta() {
		return dataCacheEntry.getCtacteoferta();
	}
	/**
	 * Set accessor for persistent attribute: ctacteoferta
	 */
	public void setCtacteoferta(java.lang.String newCtacteoferta) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(107,getCtacteoferta(),newCtacteoferta);
		else
			instanceExtension.markDirty(107);
		dataCacheEntry.setCtacteoferta(newCtacteoferta);
	}
	/**
	 * Get accessor for persistent attribute: ctaahoferta
	 */
	public java.lang.String getCtaahoferta() {
		return dataCacheEntry.getCtaahoferta();
	}
	/**
	 * Set accessor for persistent attribute: ctaahoferta
	 */
	public void setCtaahoferta(java.lang.String newCtaahoferta) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(108,getCtaahoferta(),newCtaahoferta);
		else
			instanceExtension.markDirty(108);
		dataCacheEntry.setCtaahoferta(newCtaahoferta);
	}
	/**
	 * Get accessor for persistent attribute: ctapoferta
	 */
	public java.lang.String getCtapoferta() {
		return dataCacheEntry.getCtapoferta();
	}
	/**
	 * Set accessor for persistent attribute: ctapoferta
	 */
	public void setCtapoferta(java.lang.String newCtapoferta) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(109,getCtapoferta(),newCtapoferta);
		else
			instanceExtension.markDirty(109);
		dataCacheEntry.setCtapoferta(newCtapoferta);
	}
	/**
	 * Get accessor for persistent attribute: fmutuoofert
	 */
	public java.lang.String getFmutuoofert() {
		return dataCacheEntry.getFmutuoofert();
	}
	/**
	 * Set accessor for persistent attribute: fmutuoofert
	 */
	public void setFmutuoofert(java.lang.String newFmutuoofert) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(110,getFmutuoofert(),newFmutuoofert);
		else
			instanceExtension.markDirty(110);
		dataCacheEntry.setFmutuoofert(newFmutuoofert);
	}
	/**
	 * Get accessor for persistent attribute: ctactsofert
	 */
	public java.lang.String getCtactsofert() {
		return dataCacheEntry.getCtactsofert();
	}
	/**
	 * Set accessor for persistent attribute: ctactsofert
	 */
	public void setCtactsofert(java.lang.String newCtactsofert) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(111,getCtactsofert(),newCtactsofert);
		else
			instanceExtension.markDirty(111);
		dataCacheEntry.setCtactsofert(newCtactsofert);
	}
	/**
	 * Get accessor for persistent attribute: tconsactv
	 */
	public java.math.BigDecimal getTconsactv() {
		return dataCacheEntry.getTconsactv();
	}
	/**
	 * Set accessor for persistent attribute: tconsactv
	 */
	public void setTconsactv(java.math.BigDecimal newTconsactv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(112,getTconsactv(),newTconsactv);
		else
			instanceExtension.markDirty(112);
		dataCacheEntry.setTconsactv(newTconsactv);
	}
	/**
	 * Get accessor for persistent attribute: montosubrogados
	 */
	public java.math.BigDecimal getMontosubrogados() {
		return dataCacheEntry.getMontosubrogados();
	}
	/**
	 * Set accessor for persistent attribute: montosubrogados
	 */
	public void setMontosubrogados(java.math.BigDecimal newMontosubrogados) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(113,getMontosubrogados(),newMontosubrogados);
		else
			instanceExtension.markDirty(113);
		dataCacheEntry.setMontosubrogados(newMontosubrogados);
	}
	/**
	 * Get accessor for persistent attribute: tsubactv
	 */
	public java.math.BigDecimal getTsubactv() {
		return dataCacheEntry.getTsubactv();
	}
	/**
	 * Set accessor for persistent attribute: tsubactv
	 */
	public void setTsubactv(java.math.BigDecimal newTsubactv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(114,getTsubactv(),newTsubactv);
		else
			instanceExtension.markDirty(114);
		dataCacheEntry.setTsubactv(newTsubactv);
	}
	/**
	 * Get accessor for persistent attribute: thipotactv
	 */
	public java.math.BigDecimal getThipotactv() {
		return dataCacheEntry.getThipotactv();
	}
	/**
	 * Set accessor for persistent attribute: thipotactv
	 */
	public void setThipotactv(java.math.BigDecimal newThipotactv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(115,getThipotactv(),newThipotactv);
		else
			instanceExtension.markDirty(115);
		dataCacheEntry.setThipotactv(newThipotactv);
	}
	/**
	 * Get accessor for persistent attribute: tvehicactv
	 */
	public java.math.BigDecimal getTvehicactv() {
		return dataCacheEntry.getTvehicactv();
	}
	/**
	 * Set accessor for persistent attribute: tvehicactv
	 */
	public void setTvehicactv(java.math.BigDecimal newTvehicactv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(116,getTvehicactv(),newTvehicactv);
		else
			instanceExtension.markDirty(116);
		dataCacheEntry.setTvehicactv(newTvehicactv);
	}
	/**
	 * Get accessor for persistent attribute: cs000montocta36
	 */
	public java.lang.String getCs000montocta36() {
		return dataCacheEntry.getCs000montocta36();
	}
	/**
	 * Set accessor for persistent attribute: cs000montocta36
	 */
	public void setCs000montocta36(java.lang.String newCs000montocta36) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(117,getCs000montocta36(),newCs000montocta36);
		else
			instanceExtension.markDirty(117);
		dataCacheEntry.setCs000montocta36(newCs000montocta36);
	}
	/**
	 * Get accessor for persistent attribute: tcuot36act
	 */
	public java.math.BigDecimal getTcuot36act() {
		return dataCacheEntry.getTcuot36act();
	}
	/**
	 * Set accessor for persistent attribute: tcuot36act
	 */
	public void setTcuot36act(java.math.BigDecimal newTcuot36act) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(118,getTcuot36act(),newTcuot36act);
		else
			instanceExtension.markDirty(118);
		dataCacheEntry.setTcuot36act(newTcuot36act);
	}
	/**
	 * Get accessor for persistent attribute: cs000montocta48
	 */
	public java.math.BigDecimal getCs000montocta48() {
		return dataCacheEntry.getCs000montocta48();
	}
	/**
	 * Set accessor for persistent attribute: cs000montocta48
	 */
	public void setCs000montocta48(java.math.BigDecimal newCs000montocta48) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(119,getCs000montocta48(),newCs000montocta48);
		else
			instanceExtension.markDirty(119);
		dataCacheEntry.setCs000montocta48(newCs000montocta48);
	}
	/**
	 * Get accessor for persistent attribute: tcuot48act
	 */
	public java.math.BigDecimal getTcuot48act() {
		return dataCacheEntry.getTcuot48act();
	}
	/**
	 * Set accessor for persistent attribute: tcuot48act
	 */
	public void setTcuot48act(java.math.BigDecimal newTcuot48act) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(120,getTcuot48act(),newTcuot48act);
		else
			instanceExtension.markDirty(120);
		dataCacheEntry.setTcuot48act(newTcuot48act);
	}
	/**
	 * Get accessor for persistent attribute: cs000montocta60
	 */
	public java.math.BigDecimal getCs000montocta60() {
		return dataCacheEntry.getCs000montocta60();
	}
	/**
	 * Set accessor for persistent attribute: cs000montocta60
	 */
	public void setCs000montocta60(java.math.BigDecimal newCs000montocta60) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(121,getCs000montocta60(),newCs000montocta60);
		else
			instanceExtension.markDirty(121);
		dataCacheEntry.setCs000montocta60(newCs000montocta60);
	}
	/**
	 * Get accessor for persistent attribute: tcuot60act
	 */
	public java.math.BigDecimal getTcuot60act() {
		return dataCacheEntry.getTcuot60act();
	}
	/**
	 * Set accessor for persistent attribute: tcuot60act
	 */
	public void setTcuot60act(java.math.BigDecimal newTcuot60act) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(122,getTcuot60act(),newTcuot60act);
		else
			instanceExtension.markDirty(122);
		dataCacheEntry.setTcuot60act(newTcuot60act);
	}
	/**
	 * Get accessor for persistent attribute: css000presmena5000
	 */
	public java.math.BigDecimal getCss000presmena5000() {
		return dataCacheEntry.getCss000presmena5000();
	}
	/**
	 * Set accessor for persistent attribute: css000presmena5000
	 */
	public void setCss000presmena5000(java.math.BigDecimal newCss000presmena5000) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(123,getCss000presmena5000(),newCss000presmena5000);
		else
			instanceExtension.markDirty(123);
		dataCacheEntry.setCss000presmena5000(newCss000presmena5000);
	}
	/**
	 * Get accessor for persistent attribute: cs000comisdesemen5000
	 */
	public java.math.BigDecimal getCs000comisdesemen5000() {
		return dataCacheEntry.getCs000comisdesemen5000();
	}
	/**
	 * Set accessor for persistent attribute: cs000comisdesemen5000
	 */
	public void setCs000comisdesemen5000(java.math.BigDecimal newCs000comisdesemen5000) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(124,getCs000comisdesemen5000(),newCs000comisdesemen5000);
		else
			instanceExtension.markDirty(124);
		dataCacheEntry.setCs000comisdesemen5000(newCs000comisdesemen5000);
	}
	/**
	 * Get accessor for persistent attribute: cs000pres5000a15000
	 */
	public java.math.BigDecimal getCs000pres5000a15000() {
		return dataCacheEntry.getCs000pres5000a15000();
	}
	/**
	 * Set accessor for persistent attribute: cs000pres5000a15000
	 */
	public void setCs000pres5000a15000(java.math.BigDecimal newCs000pres5000a15000) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(125,getCs000pres5000a15000(),newCs000pres5000a15000);
		else
			instanceExtension.markDirty(125);
		dataCacheEntry.setCs000pres5000a15000(newCs000pres5000a15000);
	}
	/**
	 * Get accessor for persistent attribute: c5000comdes15000act
	 */
	public java.math.BigDecimal getC5000comdes15000act() {
		return dataCacheEntry.getC5000comdes15000act();
	}
	/**
	 * Set accessor for persistent attribute: c5000comdes15000act
	 */
	public void setC5000comdes15000act(java.math.BigDecimal newC5000comdes15000act) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(126,getC5000comdes15000act(),newC5000comdes15000act);
		else
			instanceExtension.markDirty(126);
		dataCacheEntry.setC5000comdes15000act(newC5000comdes15000act);
	}
	/**
	 * Get accessor for persistent attribute: cs000presmaya15000
	 */
	public java.math.BigDecimal getCs000presmaya15000() {
		return dataCacheEntry.getCs000presmaya15000();
	}
	/**
	 * Set accessor for persistent attribute: cs000presmaya15000
	 */
	public void setCs000presmaya15000(java.math.BigDecimal newCs000presmaya15000) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(127,getCs000presmaya15000(),newCs000presmaya15000);
		else
			instanceExtension.markDirty(127);
		dataCacheEntry.setCs000presmaya15000(newCs000presmaya15000);
	}
	/**
	 * Get accessor for persistent attribute: comdes15000ac
	 */
	public java.math.BigDecimal getComdes15000ac() {
		return dataCacheEntry.getComdes15000ac();
	}
	/**
	 * Set accessor for persistent attribute: comdes15000ac
	 */
	public void setComdes15000ac(java.math.BigDecimal newComdes15000ac) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(128,getComdes15000ac(),newComdes15000ac);
		else
			instanceExtension.markDirty(128);
		dataCacheEntry.setComdes15000ac(newComdes15000ac);
	}
	/**
	 * Get accessor for persistent attribute: cs000linminadqtc
	 */
	public java.math.BigDecimal getCs000linminadqtc() {
		return dataCacheEntry.getCs000linminadqtc();
	}
	/**
	 * Set accessor for persistent attribute: cs000linminadqtc
	 */
	public void setCs000linminadqtc(java.math.BigDecimal newCs000linminadqtc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(129,getCs000linminadqtc(),newCs000linminadqtc);
		else
			instanceExtension.markDirty(129);
		dataCacheEntry.setCs000linminadqtc(newCs000linminadqtc);
	}
	/**
	 * Get accessor for persistent attribute: cs000tipodecredito
	 */
	public java.lang.String getCs000tipodecredito() {
		return dataCacheEntry.getCs000tipodecredito();
	}
	/**
	 * Set accessor for persistent attribute: cs000tipodecredito
	 */
	public void setCs000tipodecredito(java.lang.String newCs000tipodecredito) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(130,getCs000tipodecredito(),newCs000tipodecredito);
		else
			instanceExtension.markDirty(130);
		dataCacheEntry.setCs000tipodecredito(newCs000tipodecredito);
	}
	/**
	 * Get accessor for persistent attribute: cs000mixmonprest
	 */
	public java.math.BigDecimal getCs000mixmonprest() {
		return dataCacheEntry.getCs000mixmonprest();
	}
	/**
	 * Set accessor for persistent attribute: cs000mixmonprest
	 */
	public void setCs000mixmonprest(java.math.BigDecimal newCs000mixmonprest) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(131,getCs000mixmonprest(),newCs000mixmonprest);
		else
			instanceExtension.markDirty(131);
		dataCacheEntry.setCs000mixmonprest(newCs000mixmonprest);
	}
	/**
	 * Get accessor for persistent attribute: cs000mixlinasistc
	 */
	public java.math.BigDecimal getCs000mixlinasistc() {
		return dataCacheEntry.getCs000mixlinasistc();
	}
	/**
	 * Set accessor for persistent attribute: cs000mixlinasistc
	 */
	public void setCs000mixlinasistc(java.math.BigDecimal newCs000mixlinasistc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(132,getCs000mixlinasistc(),newCs000mixlinasistc);
		else
			instanceExtension.markDirty(132);
		dataCacheEntry.setCs000mixlinasistc(newCs000mixlinasistc);
	}
	/**
	 * Get accessor for persistent attribute: cs000mixtipotc
	 */
	public java.lang.String getCs000mixtipotc() {
		return dataCacheEntry.getCs000mixtipotc();
	}
	/**
	 * Set accessor for persistent attribute: cs000mixtipotc
	 */
	public void setCs000mixtipotc(java.lang.String newCs000mixtipotc) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(133,getCs000mixtipotc(),newCs000mixtipotc);
		else
			instanceExtension.markDirty(133);
		dataCacheEntry.setCs000mixtipotc(newCs000mixtipotc);
	}
	/**
	 * Get accessor for persistent attribute: cs000prestcmena5000
	 */
	public java.math.BigDecimal getCs000prestcmena5000() {
		return dataCacheEntry.getCs000prestcmena5000();
	}
	/**
	 * Set accessor for persistent attribute: cs000prestcmena5000
	 */
	public void setCs000prestcmena5000(java.math.BigDecimal newCs000prestcmena5000) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(134,getCs000prestcmena5000(),newCs000prestcmena5000);
		else
			instanceExtension.markDirty(134);
		dataCacheEntry.setCs000prestcmena5000(newCs000prestcmena5000);
	}
	/**
	 * Get accessor for persistent attribute: cs000prestc500015000
	 */
	public java.math.BigDecimal getCs000prestc500015000() {
		return dataCacheEntry.getCs000prestc500015000();
	}
	/**
	 * Set accessor for persistent attribute: cs000prestc500015000
	 */
	public void setCs000prestc500015000(java.math.BigDecimal newCs000prestc500015000) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(135,getCs000prestc500015000(),newCs000prestc500015000);
		else
			instanceExtension.markDirty(135);
		dataCacheEntry.setCs000prestc500015000(newCs000prestc500015000);
	}
	/**
	 * Get accessor for persistent attribute: cs000prestcmaya15000
	 */
	public java.math.BigDecimal getCs000prestcmaya15000() {
		return dataCacheEntry.getCs000prestcmaya15000();
	}
	/**
	 * Set accessor for persistent attribute: cs000prestcmaya15000
	 */
	public void setCs000prestcmaya15000(java.math.BigDecimal newCs000prestcmaya15000) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(136,getCs000prestcmaya15000(),newCs000prestcmaya15000);
		else
			instanceExtension.markDirty(136);
		dataCacheEntry.setCs000prestcmaya15000(newCs000prestcmaya15000);
	}
	/**
	 * Get accessor for persistent attribute: atribctactepasv
	 */
	public java.lang.String getAtribctactepasv() {
		return dataCacheEntry.getAtribctactepasv();
	}
	/**
	 * Set accessor for persistent attribute: atribctactepasv
	 */
	public void setAtribctactepasv(java.lang.String newAtribctactepasv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(137,getAtribctactepasv(),newAtribctactepasv);
		else
			instanceExtension.markDirty(137);
		dataCacheEntry.setAtribctactepasv(newAtribctactepasv);
	}
	/**
	 * Get accessor for persistent attribute: atribctaahpasv
	 */
	public java.lang.String getAtribctaahpasv() {
		return dataCacheEntry.getAtribctaahpasv();
	}
	/**
	 * Set accessor for persistent attribute: atribctaahpasv
	 */
	public void setAtribctaahpasv(java.lang.String newAtribctaahpasv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(138,getAtribctaahpasv(),newAtribctaahpasv);
		else
			instanceExtension.markDirty(138);
		dataCacheEntry.setAtribctaahpasv(newAtribctaahpasv);
	}
	/**
	 * Get accessor for persistent attribute: atribctaplazpasv
	 */
	public java.lang.String getAtribctaplazpasv() {
		return dataCacheEntry.getAtribctaplazpasv();
	}
	/**
	 * Set accessor for persistent attribute: atribctaplazpasv
	 */
	public void setAtribctaplazpasv(java.lang.String newAtribctaplazpasv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(139,getAtribctaplazpasv(),newAtribctaplazpasv);
		else
			instanceExtension.markDirty(139);
		dataCacheEntry.setAtribctaplazpasv(newAtribctaplazpasv);
	}
	/**
	 * Get accessor for persistent attribute: atribctspasv
	 */
	public java.lang.String getAtribctspasv() {
		return dataCacheEntry.getAtribctspasv();
	}
	/**
	 * Set accessor for persistent attribute: atribctspasv
	 */
	public void setAtribctspasv(java.lang.String newAtribctspasv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(140,getAtribctspasv(),newAtribctspasv);
		else
			instanceExtension.markDirty(140);
		dataCacheEntry.setAtribctspasv(newAtribctspasv);
	}
	/**
	 * Get accessor for persistent attribute: atribfmutuopasv
	 */
	public java.lang.String getAtribfmutuopasv() {
		return dataCacheEntry.getAtribfmutuopasv();
	}
	/**
	 * Set accessor for persistent attribute: atribfmutuopasv
	 */
	public void setAtribfmutuopasv(java.lang.String newAtribfmutuopasv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(141,getAtribfmutuopasv(),newAtribfmutuopasv);
		else
			instanceExtension.markDirty(141);
		dataCacheEntry.setAtribfmutuopasv(newAtribfmutuopasv);
	}
	/**
	 * Get accessor for persistent attribute: cobofserv
	 */
	public java.lang.String getCobofserv() {
		return dataCacheEntry.getCobofserv();
	}
	/**
	 * Set accessor for persistent attribute: cobofserv
	 */
	public void setCobofserv(java.lang.String newCobofserv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(142,getCobofserv(),newCobofserv);
		else
			instanceExtension.markDirty(142);
		dataCacheEntry.setCobofserv(newCobofserv);
	}
	/**
	 * Get accessor for persistent attribute: svidofserv
	 */
	public java.lang.String getSvidofserv() {
		return dataCacheEntry.getSvidofserv();
	}
	/**
	 * Set accessor for persistent attribute: svidofserv
	 */
	public void setSvidofserv(java.lang.String newSvidofserv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(143,getSvidofserv(),newSvidofserv);
		else
			instanceExtension.markDirty(143);
		dataCacheEntry.setSvidofserv(newSvidofserv);
	}
	/**
	 * Get accessor for persistent attribute: soncofserv
	 */
	public java.lang.String getSoncofserv() {
		return dataCacheEntry.getSoncofserv();
	}
	/**
	 * Set accessor for persistent attribute: soncofserv
	 */
	public void setSoncofserv(java.lang.String newSoncofserv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(144,getSoncofserv(),newSoncofserv);
		else
			instanceExtension.markDirty(144);
		dataCacheEntry.setSoncofserv(newSoncofserv);
	}
	/**
	 * Get accessor for persistent attribute: svincofserv
	 */
	public java.lang.String getSvincofserv() {
		return dataCacheEntry.getSvincofserv();
	}
	/**
	 * Set accessor for persistent attribute: svincofserv
	 */
	public void setSvincofserv(java.lang.String newSvincofserv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(145,getSvincofserv(),newSvincofserv);
		else
			instanceExtension.markDirty(145);
		dataCacheEntry.setSvincofserv(newSvincofserv);
	}
	/**
	 * Get accessor for persistent attribute: phofserv
	 */
	public java.lang.String getPhofserv() {
		return dataCacheEntry.getPhofserv();
	}
	/**
	 * Set accessor for persistent attribute: phofserv
	 */
	public void setPhofserv(java.lang.String newPhofserv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(146,getPhofserv(),newPhofserv);
		else
			instanceExtension.markDirty(146);
		dataCacheEntry.setPhofserv(newPhofserv);
	}
	/**
	 * Get accessor for persistent attribute: debofserv
	 */
	public java.lang.String getDebofserv() {
		return dataCacheEntry.getDebofserv();
	}
	/**
	 * Set accessor for persistent attribute: debofserv
	 */
	public void setDebofserv(java.lang.String newDebofserv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(147,getDebofserv(),newDebofserv);
		else
			instanceExtension.markDirty(147);
		dataCacheEntry.setDebofserv(newDebofserv);
	}
	/**
	 * Get accessor for persistent attribute: vipofserv
	 */
	public java.lang.String getVipofserv() {
		return dataCacheEntry.getVipofserv();
	}
	/**
	 * Set accessor for persistent attribute: vipofserv
	 */
	public void setVipofserv(java.lang.String newVipofserv) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(148,getVipofserv(),newVipofserv);
		else
			instanceExtension.markDirty(148);
		dataCacheEntry.setVipofserv(newVipofserv);
	}
	/**
	 * Get accessor for persistent attribute: ofcnetcan
	 */
	public java.lang.String getOfcnetcan() {
		return dataCacheEntry.getOfcnetcan();
	}
	/**
	 * Set accessor for persistent attribute: ofcnetcan
	 */
	public void setOfcnetcan(java.lang.String newOfcnetcan) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(149,getOfcnetcan(),newOfcnetcan);
		else
			instanceExtension.markDirty(149);
		dataCacheEntry.setOfcnetcan(newOfcnetcan);
	}
	/**
	 * Get accessor for persistent attribute: ofcempcan
	 */
	public java.lang.String getOfcempcan() {
		return dataCacheEntry.getOfcempcan();
	}
	/**
	 * Set accessor for persistent attribute: ofcempcan
	 */
	public void setOfcempcan(java.lang.String newOfcempcan) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(150,getOfcempcan(),newOfcempcan);
		else
			instanceExtension.markDirty(150);
		dataCacheEntry.setOfcempcan(newOfcempcan);
	}
	/**
	 * Get accessor for persistent attribute: oflincocan
	 */
	public java.lang.String getOflincocan() {
		return dataCacheEntry.getOflincocan();
	}
	/**
	 * Set accessor for persistent attribute: oflincocan
	 */
	public void setOflincocan(java.lang.String newOflincocan) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(151,getOflincocan(),newOflincocan);
		else
			instanceExtension.markDirty(151);
		dataCacheEntry.setOflincocan(newOflincocan);
	}
	/**
	 * Get accessor for persistent attribute: ofb24can
	 */
	public java.lang.String getOfb24can() {
		return dataCacheEntry.getOfb24can();
	}
	/**
	 * Set accessor for persistent attribute: ofb24can
	 */
	public void setOfb24can(java.lang.String newOfb24can) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(152,getOfb24can(),newOfb24can);
		else
			instanceExtension.markDirty(152);
		dataCacheEntry.setOfb24can(newOfb24can);
	}
	/**
	 * Get accessor for persistent attribute: ofposcan
	 */
	public java.lang.String getOfposcan() {
		return dataCacheEntry.getOfposcan();
	}
	/**
	 * Set accessor for persistent attribute: ofposcan
	 */
	public void setOfposcan(java.lang.String newOfposcan) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(153,getOfposcan(),newOfposcan);
		else
			instanceExtension.markDirty(153);
		dataCacheEntry.setOfposcan(newOfposcan);
	}
	/**
	 * Get accessor for persistent attribute: prefijo
	 */
	public java.lang.String getPrefijo() {
		return dataCacheEntry.getPrefijo();
	}
	/**
	 * Set accessor for persistent attribute: prefijo
	 */
	public void setPrefijo(java.lang.String newPrefijo) {
		if (instanceExtension.needValuesOnMarkDirty())
			instanceExtension.markDirty(154,getPrefijo(),newPrefijo);
		else
			instanceExtension.markDirty(154);
		dataCacheEntry.setPrefijo(newPrefijo);
	}
}
