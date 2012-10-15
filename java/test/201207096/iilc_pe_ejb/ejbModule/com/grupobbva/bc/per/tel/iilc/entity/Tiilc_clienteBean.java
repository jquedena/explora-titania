package com.grupobbva.bc.per.tel.iilc.entity;
/**
 * Bean implementation class for Enterprise Bean: Tiilc_cliente
 */
public abstract class Tiilc_clienteBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey ejbCreate(
		java.math.BigDecimal cod_cliente) throws javax.ejb.CreateException {
		setCod_cliente(cod_cliente);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.math.BigDecimal cod_cliente)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.grupobbva.bc.per.tel.iilc.entity.Tiilc_clienteKey ejbCreate(
		java.math.BigDecimal cod_cliente,
		java.lang.String cod_oficina,
		java.lang.String cod_gestor,
		java.lang.String cod_territorio,
		java.math.BigDecimal mofactv,
		java.math.BigDecimal cs000lineamaxtc,
		java.math.BigDecimal cs000mtoprestamo,
		java.math.BigDecimal montovehicular,
		java.math.BigDecimal montohipotecario,
		java.math.BigDecimal tconsactv,
		java.math.BigDecimal montosubrogados,
		java.math.BigDecimal tsubactv,
		java.math.BigDecimal thipotactv,
		java.math.BigDecimal tvehicactv,
		java.lang.String cs000montocta36,
		java.math.BigDecimal tcuot36act,
		java.math.BigDecimal cs000montocta48,
		java.math.BigDecimal tcuot48act,
		java.math.BigDecimal cs000montocta60,
		java.math.BigDecimal tcuot60act,
		java.math.BigDecimal css000presmena5000,
		java.math.BigDecimal cs000comisdesemen5000,
		java.math.BigDecimal cs000pres5000a15000,
		java.math.BigDecimal c5000comdes15000act,
		java.math.BigDecimal cs000presmaya15000,
		java.math.BigDecimal comdes15000ac,
		java.math.BigDecimal cs000linminadqtc,
		java.math.BigDecimal cs000mixmonprest,
		java.math.BigDecimal cs000mixlinasistc,
		java.math.BigDecimal cs000prestcmena5000,
		java.math.BigDecimal cs000prestc500015000,
		java.math.BigDecimal cs000prestcmaya15000)
		throws javax.ejb.CreateException {
		setCod_cliente(cod_cliente);
		setCod_oficina(cod_oficina);
		setCod_gestor(cod_gestor);
		setCod_territorio(cod_territorio);
		setMofactv(mofactv);
		setCs000lineamaxtc(cs000lineamaxtc);
		setCs000mtoprestamo(cs000mtoprestamo);
		setMontovehicular(montovehicular);
		setMontohipotecario(montohipotecario);
		setTconsactv(tconsactv);
		setMontosubrogados(montosubrogados);
		setTsubactv(tsubactv);
		setThipotactv(thipotactv);
		setTvehicactv(tvehicactv);
		setCs000montocta36(cs000montocta36);
		setTcuot36act(tcuot36act);
		setCs000montocta48(cs000montocta48);
		setTcuot48act(tcuot48act);
		setCs000montocta60(cs000montocta60);
		setTcuot60act(tcuot60act);
		setCss000presmena5000(css000presmena5000);
		setCs000comisdesemen5000(cs000comisdesemen5000);
		setCs000pres5000a15000(cs000pres5000a15000);
		setC5000comdes15000act(c5000comdes15000act);
		setCs000presmaya15000(cs000presmaya15000);
		setComdes15000ac(comdes15000ac);
		setCs000linminadqtc(cs000linminadqtc);
		setCs000mixmonprest(cs000mixmonprest);
		setCs000mixlinasistc(cs000mixlinasistc);
		setCs000prestcmena5000(cs000prestcmena5000);
		setCs000prestc500015000(cs000prestc500015000);
		setCs000prestcmaya15000(cs000prestcmaya15000);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.math.BigDecimal cod_cliente,
		java.lang.String cod_oficina,
		java.lang.String cod_gestor,
		java.lang.String cod_territorio,
		java.math.BigDecimal mofactv,
		java.math.BigDecimal cs000lineamaxtc,
		java.math.BigDecimal cs000mtoprestamo,
		java.math.BigDecimal montovehicular,
		java.math.BigDecimal montohipotecario,
		java.math.BigDecimal tconsactv,
		java.math.BigDecimal montosubrogados,
		java.math.BigDecimal tsubactv,
		java.math.BigDecimal thipotactv,
		java.math.BigDecimal tvehicactv,
		java.lang.String cs000montocta36,
		java.math.BigDecimal tcuot36act,
		java.math.BigDecimal cs000montocta48,
		java.math.BigDecimal tcuot48act,
		java.math.BigDecimal cs000montocta60,
		java.math.BigDecimal tcuot60act,
		java.math.BigDecimal css000presmena5000,
		java.math.BigDecimal cs000comisdesemen5000,
		java.math.BigDecimal cs000pres5000a15000,
		java.math.BigDecimal c5000comdes15000act,
		java.math.BigDecimal cs000presmaya15000,
		java.math.BigDecimal comdes15000ac,
		java.math.BigDecimal cs000linminadqtc,
		java.math.BigDecimal cs000mixmonprest,
		java.math.BigDecimal cs000mixlinasistc,
		java.math.BigDecimal cs000prestcmena5000,
		java.math.BigDecimal cs000prestc500015000,
		java.math.BigDecimal cs000prestcmaya15000)
		throws javax.ejb.CreateException {
	}
	/**
	 * Get accessor for persistent attribute: cod_cliente
	 */
	public abstract java.math.BigDecimal getCod_cliente();
	/**
	 * Set accessor for persistent attribute: cod_cliente
	 */
	public abstract void setCod_cliente(java.math.BigDecimal newCod_cliente);
	/**
	 * Get accessor for persistent attribute: codigo
	 */
	public abstract java.lang.String getCodigo();
	/**
	 * Set accessor for persistent attribute: codigo
	 */
	public abstract void setCodigo(java.lang.String newCodigo);
	/**
	 * Get accessor for persistent attribute: cod_oficina
	 */
	public abstract java.lang.String getCod_oficina();
	/**
	 * Set accessor for persistent attribute: cod_oficina
	 */
	public abstract void setCod_oficina(java.lang.String newCod_oficina);
	/**
	 * Get accessor for persistent attribute: cod_gestor
	 */
	public abstract java.lang.String getCod_gestor();
	/**
	 * Set accessor for persistent attribute: cod_gestor
	 */
	public abstract void setCod_gestor(java.lang.String newCod_gestor);
	/**
	 * Get accessor for persistent attribute: nombre
	 */
	public abstract java.lang.String getNombre();
	/**
	 * Set accessor for persistent attribute: nombre
	 */
	public abstract void setNombre(java.lang.String newNombre);
	/**
	 * Get accessor for persistent attribute: cod_territorio
	 */
	public abstract java.lang.String getCod_territorio();
	/**
	 * Set accessor for persistent attribute: cod_territorio
	 */
	public abstract void setCod_territorio(java.lang.String newCod_territorio);
	/**
	 * Get accessor for persistent attribute: segment1
	 */
	public abstract java.lang.String getSegment1();
	/**
	 * Set accessor for persistent attribute: segment1
	 */
	public abstract void setSegment1(java.lang.String newSegment1);
	/**
	 * Get accessor for persistent attribute: edad
	 */
	public abstract java.math.BigDecimal getEdad();
	/**
	 * Set accessor for persistent attribute: edad
	 */
	public abstract void setEdad(java.math.BigDecimal newEdad);
	/**
	 * Get accessor for persistent attribute: estcivil
	 */
	public abstract java.lang.String getEstcivil();
	/**
	 * Set accessor for persistent attribute: estcivil
	 */
	public abstract void setEstcivil(java.lang.String newEstcivil);
	/**
	 * Get accessor for persistent attribute: calle
	 */
	public abstract java.lang.String getCalle();
	/**
	 * Set accessor for persistent attribute: calle
	 */
	public abstract void setCalle(java.lang.String newCalle);
	/**
	 * Get accessor for persistent attribute: nro
	 */
	public abstract java.lang.String getNro();
	/**
	 * Set accessor for persistent attribute: nro
	 */
	public abstract void setNro(java.lang.String newNro);
	/**
	 * Get accessor for persistent attribute: perfil
	 */
	public abstract java.lang.String getPerfil();
	/**
	 * Set accessor for persistent attribute: perfil
	 */
	public abstract void setPerfil(java.lang.String newPerfil);
	/**
	 * Get accessor for persistent attribute: direc1
	 */
	public abstract java.lang.String getDirec1();
	/**
	 * Set accessor for persistent attribute: direc1
	 */
	public abstract void setDirec1(java.lang.String newDirec1);
	/**
	 * Get accessor for persistent attribute: distrito
	 */
	public abstract java.lang.String getDistrito();
	/**
	 * Set accessor for persistent attribute: distrito
	 */
	public abstract void setDistrito(java.lang.String newDistrito);
	/**
	 * Get accessor for persistent attribute: provincia
	 */
	public abstract java.lang.String getProvincia();
	/**
	 * Set accessor for persistent attribute: provincia
	 */
	public abstract void setProvincia(java.lang.String newProvincia);
	/**
	 * Get accessor for persistent attribute: departamento
	 */
	public abstract java.lang.String getDepartamento();
	/**
	 * Set accessor for persistent attribute: departamento
	 */
	public abstract void setDepartamento(java.lang.String newDepartamento);
	/**
	 * Get accessor for persistent attribute: tipo_persona
	 */
	public abstract java.lang.String getTipo_persona();
	/**
	 * Set accessor for persistent attribute: tipo_persona
	 */
	public abstract void setTipo_persona(java.lang.String newTipo_persona);
	/**
	 * Get accessor for persistent attribute: clasificacion
	 */
	public abstract java.lang.String getClasificacion();
	/**
	 * Set accessor for persistent attribute: clasificacion
	 */
	public abstract void setClasificacion(java.lang.String newClasificacion);
	/**
	 * Get accessor for persistent attribute: telefono
	 */
	public abstract java.lang.String getTelefono();
	/**
	 * Set accessor for persistent attribute: telefono
	 */
	public abstract void setTelefono(java.lang.String newTelefono);
	/**
	 * Get accessor for persistent attribute: vinculacion
	 */
	public abstract java.lang.String getVinculacion();
	/**
	 * Set accessor for persistent attribute: vinculacion
	 */
	public abstract void setVinculacion(java.lang.String newVinculacion);
	/**
	 * Get accessor for persistent attribute: pper
	 */
	public abstract java.math.BigDecimal getPper();
	/**
	 * Set accessor for persistent attribute: pper
	 */
	public abstract void setPper(java.math.BigDecimal newPper);
	/**
	 * Get accessor for persistent attribute: pcom
	 */
	public abstract java.math.BigDecimal getPcom();
	/**
	 * Set accessor for persistent attribute: pcom
	 */
	public abstract void setPcom(java.math.BigDecimal newPcom);
	/**
	 * Get accessor for persistent attribute: vnac
	 */
	public abstract java.math.BigDecimal getVnac();
	/**
	 * Set accessor for persistent attribute: vnac
	 */
	public abstract void setVnac(java.math.BigDecimal newVnac);
	/**
	 * Get accessor for persistent attribute: ccte
	 */
	public abstract java.math.BigDecimal getCcte();
	/**
	 * Set accessor for persistent attribute: ccte
	 */
	public abstract void setCcte(java.math.BigDecimal newCcte);
	/**
	 * Get accessor for persistent attribute: colb
	 */
	public abstract java.math.BigDecimal getColb();
	/**
	 * Set accessor for persistent attribute: colb
	 */
	public abstract void setColb(java.math.BigDecimal newColb);
	/**
	 * Get accessor for persistent attribute: cnet
	 */
	public abstract java.math.BigDecimal getCnet();
	/**
	 * Set accessor for persistent attribute: cnet
	 */
	public abstract void setCnet(java.math.BigDecimal newCnet);
	/**
	 * Get accessor for persistent attribute: paut
	 */
	public abstract java.math.BigDecimal getPaut();
	/**
	 * Set accessor for persistent attribute: paut
	 */
	public abstract void setPaut(java.math.BigDecimal newPaut);
	/**
	 * Get accessor for persistent attribute: dsct
	 */
	public abstract java.math.BigDecimal getDsct();
	/**
	 * Set accessor for persistent attribute: dsct
	 */
	public abstract void setDsct(java.math.BigDecimal newDsct);
	/**
	 * Get accessor for persistent attribute: varc
	 */
	public abstract java.math.BigDecimal getVarc();
	/**
	 * Set accessor for persistent attribute: varc
	 */
	public abstract void setVarc(java.math.BigDecimal newVarc);
	/**
	 * Get accessor for persistent attribute: cemp
	 */
	public abstract java.math.BigDecimal getCemp();
	/**
	 * Set accessor for persistent attribute: cemp
	 */
	public abstract void setCemp(java.math.BigDecimal newCemp);
	/**
	 * Get accessor for persistent attribute: sdep
	 */
	public abstract java.math.BigDecimal getSdep();
	/**
	 * Set accessor for persistent attribute: sdep
	 */
	public abstract void setSdep(java.math.BigDecimal newSdep);
	/**
	 * Get accessor for persistent attribute: cext
	 */
	public abstract java.math.BigDecimal getCext();
	/**
	 * Set accessor for persistent attribute: cext
	 */
	public abstract void setCext(java.math.BigDecimal newCext);
	/**
	 * Get accessor for persistent attribute: phip
	 */
	public abstract java.math.BigDecimal getPhip();
	/**
	 * Set accessor for persistent attribute: phip
	 */
	public abstract void setPhip(java.math.BigDecimal newPhip);
	/**
	 * Get accessor for persistent attribute: leas
	 */
	public abstract java.math.BigDecimal getLeas();
	/**
	 * Set accessor for persistent attribute: leas
	 */
	public abstract void setLeas(java.math.BigDecimal newLeas);
	/**
	 * Get accessor for persistent attribute: vcla
	 */
	public abstract java.math.BigDecimal getVcla();
	/**
	 * Set accessor for persistent attribute: vcla
	 */
	public abstract void setVcla(java.math.BigDecimal newVcla);
	/**
	 * Get accessor for persistent attribute: cvip
	 */
	public abstract java.math.BigDecimal getCvip();
	/**
	 * Set accessor for persistent attribute: cvip
	 */
	public abstract void setCvip(java.math.BigDecimal newCvip);
	/**
	 * Get accessor for persistent attribute: svid
	 */
	public abstract java.math.BigDecimal getSvid();
	/**
	 * Set accessor for persistent attribute: svid
	 */
	public abstract void setSvid(java.math.BigDecimal newSvid);
	/**
	 * Get accessor for persistent attribute: linco
	 */
	public abstract java.math.BigDecimal getLinco();
	/**
	 * Set accessor for persistent attribute: linco
	 */
	public abstract void setLinco(java.math.BigDecimal newLinco);
	/**
	 * Get accessor for persistent attribute: pmiv
	 */
	public abstract java.math.BigDecimal getPmiv();
	/**
	 * Set accessor for persistent attribute: pmiv
	 */
	public abstract void setPmiv(java.math.BigDecimal newPmiv);
	/**
	 * Get accessor for persistent attribute: cloc
	 */
	public abstract java.math.BigDecimal getCloc();
	/**
	 * Set accessor for persistent attribute: cloc
	 */
	public abstract void setCloc(java.math.BigDecimal newCloc);
	/**
	 * Get accessor for persistent attribute: vrep
	 */
	public abstract java.math.BigDecimal getVrep();
	/**
	 * Set accessor for persistent attribute: vrep
	 */
	public abstract void setVrep(java.math.BigDecimal newVrep);
	/**
	 * Get accessor for persistent attribute: ahsd
	 */
	public abstract java.math.BigDecimal getAhsd();
	/**
	 * Set accessor for persistent attribute: ahsd
	 */
	public abstract void setAhsd(java.math.BigDecimal newAhsd);
	/**
	 * Get accessor for persistent attribute: sonc
	 */
	public abstract java.math.BigDecimal getSonc();
	/**
	 * Set accessor for persistent attribute: sonc
	 */
	public abstract void setSonc(java.math.BigDecimal newSonc);
	/**
	 * Get accessor for persistent attribute: tco
	 */
	public abstract java.math.BigDecimal getTco();
	/**
	 * Set accessor for persistent attribute: tco
	 */
	public abstract void setTco(java.math.BigDecimal newTco);
	/**
	 * Get accessor for persistent attribute: b24
	 */
	public abstract java.math.BigDecimal getB24();
	/**
	 * Set accessor for persistent attribute: b24
	 */
	public abstract void setB24(java.math.BigDecimal newB24);
	/**
	 * Get accessor for persistent attribute: cpte
	 */
	public abstract java.math.BigDecimal getCpte();
	/**
	 * Set accessor for persistent attribute: cpte
	 */
	public abstract void setCpte(java.math.BigDecimal newCpte);
	/**
	 * Get accessor for persistent attribute: pref
	 */
	public abstract java.math.BigDecimal getPref();
	/**
	 * Set accessor for persistent attribute: pref
	 */
	public abstract void setPref(java.math.BigDecimal newPref);
	/**
	 * Get accessor for persistent attribute: voro
	 */
	public abstract java.math.BigDecimal getVoro();
	/**
	 * Set accessor for persistent attribute: voro
	 */
	public abstract void setVoro(java.math.BigDecimal newVoro);
	/**
	 * Get accessor for persistent attribute: ahor
	 */
	public abstract java.math.BigDecimal getAhor();
	/**
	 * Set accessor for persistent attribute: ahor
	 */
	public abstract void setAhor(java.math.BigDecimal newAhor);
	/**
	 * Get accessor for persistent attribute: spro
	 */
	public abstract java.math.BigDecimal getSpro();
	/**
	 * Set accessor for persistent attribute: spro
	 */
	public abstract void setSpro(java.math.BigDecimal newSpro);
	/**
	 * Get accessor for persistent attribute: pos
	 */
	public abstract java.math.BigDecimal getPos();
	/**
	 * Set accessor for persistent attribute: pos
	 */
	public abstract void setPos(java.math.BigDecimal newPos);
	/**
	 * Get accessor for persistent attribute: t_act2
	 */
	public abstract java.math.BigDecimal getT_act2();
	/**
	 * Set accessor for persistent attribute: t_act2
	 */
	public abstract void setT_act2(java.math.BigDecimal newT_act2);
	/**
	 * Get accessor for persistent attribute: pmas
	 */
	public abstract java.math.BigDecimal getPmas();
	/**
	 * Set accessor for persistent attribute: pmas
	 */
	public abstract void setPmas(java.math.BigDecimal newPmas);
	/**
	 * Get accessor for persistent attribute: t_act3
	 */
	public abstract java.math.BigDecimal getT_act3();
	/**
	 * Set accessor for persistent attribute: t_act3
	 */
	public abstract void setT_act3(java.math.BigDecimal newT_act3);
	/**
	 * Get accessor for persistent attribute: lcta
	 */
	public abstract java.math.BigDecimal getLcta();
	/**
	 * Set accessor for persistent attribute: lcta
	 */
	public abstract void setLcta(java.math.BigDecimal newLcta);
	/**
	 * Get accessor for persistent attribute: t_act4
	 */
	public abstract java.math.BigDecimal getT_act4();
	/**
	 * Set accessor for persistent attribute: t_act4
	 */
	public abstract void setT_act4(java.math.BigDecimal newT_act4);
	/**
	 * Get accessor for persistent attribute: vpla
	 */
	public abstract java.math.BigDecimal getVpla();
	/**
	 * Set accessor for persistent attribute: vpla
	 */
	public abstract void setVpla(java.math.BigDecimal newVpla);
	/**
	 * Get accessor for persistent attribute: t_act5
	 */
	public abstract java.math.BigDecimal getT_act5();
	/**
	 * Set accessor for persistent attribute: t_act5
	 */
	public abstract void setT_act5(java.math.BigDecimal newT_act5);
	/**
	 * Get accessor for persistent attribute: plzo
	 */
	public abstract java.math.BigDecimal getPlzo();
	/**
	 * Set accessor for persistent attribute: plzo
	 */
	public abstract void setPlzo(java.math.BigDecimal newPlzo);
	/**
	 * Get accessor for persistent attribute: t_act6
	 */
	public abstract java.math.BigDecimal getT_act6();
	/**
	 * Set accessor for persistent attribute: t_act6
	 */
	public abstract void setT_act6(java.math.BigDecimal newT_act6);
	/**
	 * Get accessor for persistent attribute: pserv
	 */
	public abstract java.math.BigDecimal getPserv();
	/**
	 * Set accessor for persistent attribute: pserv
	 */
	public abstract void setPserv(java.math.BigDecimal newPserv);
	/**
	 * Get accessor for persistent attribute: tpr
	 */
	public abstract java.math.BigDecimal getTpr();
	/**
	 * Set accessor for persistent attribute: tpr
	 */
	public abstract void setTpr(java.math.BigDecimal newTpr);
	/**
	 * Get accessor for persistent attribute: prom
	 */
	public abstract java.math.BigDecimal getProm();
	/**
	 * Set accessor for persistent attribute: prom
	 */
	public abstract void setProm(java.math.BigDecimal newProm);
	/**
	 * Get accessor for persistent attribute: t_act_ct2
	 */
	public abstract java.math.BigDecimal getT_act_ct2();
	/**
	 * Set accessor for persistent attribute: t_act_ct2
	 */
	public abstract void setT_act_ct2(java.math.BigDecimal newT_act_ct2);
	/**
	 * Get accessor for persistent attribute: vemp
	 */
	public abstract java.math.BigDecimal getVemp();
	/**
	 * Set accessor for persistent attribute: vemp
	 */
	public abstract void setVemp(java.math.BigDecimal newVemp);
	/**
	 * Get accessor for persistent attribute: t_act_ct3
	 */
	public abstract java.math.BigDecimal getT_act_ct3();
	/**
	 * Set accessor for persistent attribute: t_act_ct3
	 */
	public abstract void setT_act_ct3(java.math.BigDecimal newT_act_ct3);
	/**
	 * Get accessor for persistent attribute: ph
	 */
	public abstract java.math.BigDecimal getPh();
	/**
	 * Set accessor for persistent attribute: ph
	 */
	public abstract void setPh(java.math.BigDecimal newPh);
	/**
	 * Get accessor for persistent attribute: t_act_ct4
	 */
	public abstract java.math.BigDecimal getT_act_ct4();
	/**
	 * Set accessor for persistent attribute: t_act_ct4
	 */
	public abstract void setT_act_ct4(java.math.BigDecimal newT_act_ct4);
	/**
	 * Get accessor for persistent attribute: fcex
	 */
	public abstract java.math.BigDecimal getFcex();
	/**
	 * Set accessor for persistent attribute: fcex
	 */
	public abstract void setFcex(java.math.BigDecimal newFcex);
	/**
	 * Get accessor for persistent attribute: t_act_ct5
	 */
	public abstract java.math.BigDecimal getT_act_ct5();
	/**
	 * Set accessor for persistent attribute: t_act_ct5
	 */
	public abstract void setT_act_ct5(java.math.BigDecimal newT_act_ct5);
	/**
	 * Get accessor for persistent attribute: vctr
	 */
	public abstract java.math.BigDecimal getVctr();
	/**
	 * Set accessor for persistent attribute: vctr
	 */
	public abstract void setVctr(java.math.BigDecimal newVctr);
	/**
	 * Get accessor for persistent attribute: t_act_ct6
	 */
	public abstract java.math.BigDecimal getT_act_ct6();
	/**
	 * Set accessor for persistent attribute: t_act_ct6
	 */
	public abstract void setT_act_ct6(java.math.BigDecimal newT_act_ct6);
	/**
	 * Get accessor for persistent attribute: fmut
	 */
	public abstract java.math.BigDecimal getFmut();
	/**
	 * Set accessor for persistent attribute: fmut
	 */
	public abstract void setFmut(java.math.BigDecimal newFmut);
	/**
	 * Get accessor for persistent attribute: margeno
	 */
	public abstract java.math.BigDecimal getMargeno();
	/**
	 * Set accessor for persistent attribute: margeno
	 */
	public abstract void setMargeno(java.math.BigDecimal newMargeno);
	/**
	 * Get accessor for persistent attribute: nro_documento
	 */
	public abstract java.lang.String getNro_documento();
	/**
	 * Set accessor for persistent attribute: nro_documento
	 */
	public abstract void setNro_documento(java.lang.String newNro_documento);
	/**
	 * Get accessor for persistent attribute: bcorie
	 */
	public abstract java.math.BigDecimal getBcorie();
	/**
	 * Set accessor for persistent attribute: bcorie
	 */
	public abstract void setBcorie(java.math.BigDecimal newBcorie);
	/**
	 * Get accessor for persistent attribute: emph
	 */
	public abstract java.math.BigDecimal getEmph();
	/**
	 * Set accessor for persistent attribute: emph
	 */
	public abstract void setEmph(java.math.BigDecimal newEmph);
	/**
	 * Get accessor for persistent attribute: bcorid
	 */
	public abstract java.math.BigDecimal getBcorid();
	/**
	 * Set accessor for persistent attribute: bcorid
	 */
	public abstract void setBcorid(java.math.BigDecimal newBcorid);
	/**
	 * Get accessor for persistent attribute: aval
	 */
	public abstract java.math.BigDecimal getAval();
	/**
	 * Set accessor for persistent attribute: aval
	 */
	public abstract void setAval(java.math.BigDecimal newAval);
	/**
	 * Get accessor for persistent attribute: bcorii
	 */
	public abstract java.math.BigDecimal getBcorii();
	/**
	 * Set accessor for persistent attribute: bcorii
	 */
	public abstract void setBcorii(java.math.BigDecimal newBcorii);
	/**
	 * Get accessor for persistent attribute: mcla
	 */
	public abstract java.math.BigDecimal getMcla();
	/**
	 * Set accessor for persistent attribute: mcla
	 */
	public abstract void setMcla(java.math.BigDecimal newMcla);
	/**
	 * Get accessor for persistent attribute: bcopas
	 */
	public abstract java.math.BigDecimal getBcopas();
	/**
	 * Set accessor for persistent attribute: bcopas
	 */
	public abstract void setBcopas(java.math.BigDecimal newBcopas);
	/**
	 * Get accessor for persistent attribute: cts
	 */
	public abstract java.math.BigDecimal getCts();
	/**
	 * Set accessor for persistent attribute: cts
	 */
	public abstract void setCts(java.math.BigDecimal newCts);
	/**
	 * Get accessor for persistent attribute: bcovol
	 */
	public abstract java.math.BigDecimal getBcovol();
	/**
	 * Set accessor for persistent attribute: bcovol
	 */
	public abstract void setBcovol(java.math.BigDecimal newBcovol);
	/**
	 * Get accessor for persistent attribute: tdeb
	 */
	public abstract java.math.BigDecimal getTdeb();
	/**
	 * Set accessor for persistent attribute: tdeb
	 */
	public abstract void setTdeb(java.math.BigDecimal newTdeb);
	/**
	 * Get accessor for persistent attribute: porcrie
	 */
	public abstract java.math.BigDecimal getPorcrie();
	/**
	 * Set accessor for persistent attribute: porcrie
	 */
	public abstract void setPorcrie(java.math.BigDecimal newPorcrie);
	/**
	 * Get accessor for persistent attribute: moro
	 */
	public abstract java.math.BigDecimal getMoro();
	/**
	 * Set accessor for persistent attribute: moro
	 */
	public abstract void setMoro(java.math.BigDecimal newMoro);
	/**
	 * Get accessor for persistent attribute: porcrid
	 */
	public abstract java.math.BigDecimal getPorcrid();
	/**
	 * Set accessor for persistent attribute: porcrid
	 */
	public abstract void setPorcrid(java.math.BigDecimal newPorcrid);
	/**
	 * Get accessor for persistent attribute: ctsd
	 */
	public abstract java.math.BigDecimal getCtsd();
	/**
	 * Set accessor for persistent attribute: ctsd
	 */
	public abstract void setCtsd(java.math.BigDecimal newCtsd);
	/**
	 * Get accessor for persistent attribute: porcrii
	 */
	public abstract java.math.BigDecimal getPorcrii();
	/**
	 * Set accessor for persistent attribute: porcrii
	 */
	public abstract void setPorcrii(java.math.BigDecimal newPorcrii);
	/**
	 * Get accessor for persistent attribute: tvip
	 */
	public abstract java.math.BigDecimal getTvip();
	/**
	 * Set accessor for persistent attribute: tvip
	 */
	public abstract void setTvip(java.math.BigDecimal newTvip);
	/**
	 * Get accessor for persistent attribute: sbsrie
	 */
	public abstract java.math.BigDecimal getSbsrie();
	/**
	 * Set accessor for persistent attribute: sbsrie
	 */
	public abstract void setSbsrie(java.math.BigDecimal newSbsrie);
	/**
	 * Get accessor for persistent attribute: sbsrid
	 */
	public abstract java.math.BigDecimal getSbsrid();
	/**
	 * Set accessor for persistent attribute: sbsrid
	 */
	public abstract void setSbsrid(java.math.BigDecimal newSbsrid);
	/**
	 * Get accessor for persistent attribute: sbsrii
	 */
	public abstract java.math.BigDecimal getSbsrii();
	/**
	 * Set accessor for persistent attribute: sbsrii
	 */
	public abstract void setSbsrii(java.math.BigDecimal newSbsrii);
	/**
	 * Get accessor for persistent attribute: sbsjud
	 */
	public abstract java.math.BigDecimal getSbsjud();
	/**
	 * Set accessor for persistent attribute: sbsjud
	 */
	public abstract void setSbsjud(java.math.BigDecimal newSbsjud);
	/**
	 * Get accessor for persistent attribute: cod_empresa
	 */
	public abstract java.lang.String getCod_empresa();
	/**
	 * Set accessor for persistent attribute: cod_empresa
	 */
	public abstract void setCod_empresa(java.lang.String newCod_empresa);
	/**
	 * Get accessor for persistent attribute: des_empresa
	 */
	public abstract java.lang.String getDes_empresa();
	/**
	 * Set accessor for persistent attribute: des_empresa
	 */
	public abstract void setDes_empresa(java.lang.String newDes_empresa);
	/**
	 * Get accessor for persistent attribute: intervpas
	 */
	public abstract java.lang.String getIntervpas();
	/**
	 * Set accessor for persistent attribute: intervpas
	 */
	public abstract void setIntervpas(java.lang.String newIntervpas);
	/**
	 * Get accessor for persistent attribute: mofactv
	 */
	public abstract java.math.BigDecimal getMofactv();
	/**
	 * Set accessor for persistent attribute: mofactv
	 */
	public abstract void setMofactv(java.math.BigDecimal newMofactv);
	/**
	 * Get accessor for persistent attribute: cs000lineamaxtc
	 */
	public abstract java.math.BigDecimal getCs000lineamaxtc();
	/**
	 * Set accessor for persistent attribute: cs000lineamaxtc
	 */
	public abstract void setCs000lineamaxtc(
		java.math.BigDecimal newCs000lineamaxtc);
	/**
	 * Get accessor for persistent attribute: mofpasv
	 */
	public abstract java.lang.String getMofpasv();
	/**
	 * Set accessor for persistent attribute: mofpasv
	 */
	public abstract void setMofpasv(java.lang.String newMofpasv);
	/**
	 * Get accessor for persistent attribute: mofserv
	 */
	public abstract java.lang.String getMofserv();
	/**
	 * Set accessor for persistent attribute: mofserv
	 */
	public abstract void setMofserv(java.lang.String newMofserv);
	/**
	 * Get accessor for persistent attribute: mofcanal
	 */
	public abstract java.lang.String getMofcanal();
	/**
	 * Set accessor for persistent attribute: mofcanal
	 */
	public abstract void setMofcanal(java.lang.String newMofcanal);
	/**
	 * Get accessor for persistent attribute: mphpasv
	 */
	public abstract java.lang.String getMphpasv();
	/**
	 * Set accessor for persistent attribute: mphpasv
	 */
	public abstract void setMphpasv(java.lang.String newMphpasv);
	/**
	 * Get accessor for persistent attribute: cs000mtoprestamo
	 */
	public abstract java.math.BigDecimal getCs000mtoprestamo();
	/**
	 * Set accessor for persistent attribute: cs000mtoprestamo
	 */
	public abstract void setCs000mtoprestamo(
		java.math.BigDecimal newCs000mtoprestamo);
	/**
	 * Get accessor for persistent attribute: montovehicular
	 */
	public abstract java.math.BigDecimal getMontovehicular();
	/**
	 * Set accessor for persistent attribute: montovehicular
	 */
	public abstract void setMontovehicular(
		java.math.BigDecimal newMontovehicular);
	/**
	 * Get accessor for persistent attribute: montohipotecario
	 */
	public abstract java.math.BigDecimal getMontohipotecario();
	/**
	 * Set accessor for persistent attribute: montohipotecario
	 */
	public abstract void setMontohipotecario(
		java.math.BigDecimal newMontohipotecario);
	/**
	 * Get accessor for persistent attribute: ctacteoferta
	 */
	public abstract java.lang.String getCtacteoferta();
	/**
	 * Set accessor for persistent attribute: ctacteoferta
	 */
	public abstract void setCtacteoferta(java.lang.String newCtacteoferta);
	/**
	 * Get accessor for persistent attribute: ctaahoferta
	 */
	public abstract java.lang.String getCtaahoferta();
	/**
	 * Set accessor for persistent attribute: ctaahoferta
	 */
	public abstract void setCtaahoferta(java.lang.String newCtaahoferta);
	/**
	 * Get accessor for persistent attribute: ctapoferta
	 */
	public abstract java.lang.String getCtapoferta();
	/**
	 * Set accessor for persistent attribute: ctapoferta
	 */
	public abstract void setCtapoferta(java.lang.String newCtapoferta);
	/**
	 * Get accessor for persistent attribute: fmutuoofert
	 */
	public abstract java.lang.String getFmutuoofert();
	/**
	 * Set accessor for persistent attribute: fmutuoofert
	 */
	public abstract void setFmutuoofert(java.lang.String newFmutuoofert);
	/**
	 * Get accessor for persistent attribute: ctactsofert
	 */
	public abstract java.lang.String getCtactsofert();
	/**
	 * Set accessor for persistent attribute: ctactsofert
	 */
	public abstract void setCtactsofert(java.lang.String newCtactsofert);
	/**
	 * Get accessor for persistent attribute: tconsactv
	 */
	public abstract java.math.BigDecimal getTconsactv();
	/**
	 * Set accessor for persistent attribute: tconsactv
	 */
	public abstract void setTconsactv(java.math.BigDecimal newTconsactv);
	/**
	 * Get accessor for persistent attribute: montosubrogados
	 */
	public abstract java.math.BigDecimal getMontosubrogados();
	/**
	 * Set accessor for persistent attribute: montosubrogados
	 */
	public abstract void setMontosubrogados(
		java.math.BigDecimal newMontosubrogados);
	/**
	 * Get accessor for persistent attribute: tsubactv
	 */
	public abstract java.math.BigDecimal getTsubactv();
	/**
	 * Set accessor for persistent attribute: tsubactv
	 */
	public abstract void setTsubactv(java.math.BigDecimal newTsubactv);
	/**
	 * Get accessor for persistent attribute: thipotactv
	 */
	public abstract java.math.BigDecimal getThipotactv();
	/**
	 * Set accessor for persistent attribute: thipotactv
	 */
	public abstract void setThipotactv(java.math.BigDecimal newThipotactv);
	/**
	 * Get accessor for persistent attribute: tvehicactv
	 */
	public abstract java.math.BigDecimal getTvehicactv();
	/**
	 * Set accessor for persistent attribute: tvehicactv
	 */
	public abstract void setTvehicactv(java.math.BigDecimal newTvehicactv);
	/**
	 * Get accessor for persistent attribute: tcuot36act
	 */
	public abstract java.math.BigDecimal getTcuot36act();
	/**
	 * Set accessor for persistent attribute: tcuot36act
	 */
	public abstract void setTcuot36act(java.math.BigDecimal newTcuot36act);
	/**
	 * Get accessor for persistent attribute: cs000montocta48
	 */
	public abstract java.math.BigDecimal getCs000montocta48();
	/**
	 * Set accessor for persistent attribute: cs000montocta48
	 */
	public abstract void setCs000montocta48(
		java.math.BigDecimal newCs000montocta48);
	/**
	 * Get accessor for persistent attribute: tcuot48act
	 */
	public abstract java.math.BigDecimal getTcuot48act();
	/**
	 * Set accessor for persistent attribute: tcuot48act
	 */
	public abstract void setTcuot48act(java.math.BigDecimal newTcuot48act);
	/**
	 * Set accessor for persistent attribute: cs000montocta60
	 */
	public abstract void setCs000montocta60(
		java.math.BigDecimal newCs000montocta60);
	/**
	 * Get accessor for persistent attribute: tcuot60act
	 */
	public abstract java.math.BigDecimal getTcuot60act();
	/**
	 * Set accessor for persistent attribute: tcuot60act
	 */
	public abstract void setTcuot60act(java.math.BigDecimal newTcuot60act);
	/**
	 * Get accessor for persistent attribute: css000presmena5000
	 */
	public abstract java.math.BigDecimal getCss000presmena5000();
	/**
	 * Set accessor for persistent attribute: css000presmena5000
	 */
	public abstract void setCss000presmena5000(
		java.math.BigDecimal newCss000presmena5000);
	/**
	 * Get accessor for persistent attribute: cs000comisdesemen5000
	 */
	public abstract java.math.BigDecimal getCs000comisdesemen5000();
	/**
	 * Set accessor for persistent attribute: cs000comisdesemen5000
	 */
	public abstract void setCs000comisdesemen5000(
		java.math.BigDecimal newCs000comisdesemen5000);
	/**
	 * Get accessor for persistent attribute: cs000pres5000a15000
	 */
	public abstract java.math.BigDecimal getCs000pres5000a15000();
	/**
	 * Set accessor for persistent attribute: cs000pres5000a15000
	 */
	public abstract void setCs000pres5000a15000(
		java.math.BigDecimal newCs000pres5000a15000);
	/**
	 * Get accessor for persistent attribute: c5000comdes15000act
	 */
	public abstract java.math.BigDecimal getC5000comdes15000act();
	/**
	 * Set accessor for persistent attribute: c5000comdes15000act
	 */
	public abstract void setC5000comdes15000act(
		java.math.BigDecimal newC5000comdes15000act);
	/**
	 * Get accessor for persistent attribute: cs000presmaya15000
	 */
	public abstract java.math.BigDecimal getCs000presmaya15000();
	/**
	 * Set accessor for persistent attribute: cs000presmaya15000
	 */
	public abstract void setCs000presmaya15000(
		java.math.BigDecimal newCs000presmaya15000);
	/**
	 * Get accessor for persistent attribute: comdes15000ac
	 */
	public abstract java.math.BigDecimal getComdes15000ac();
	/**
	 * Set accessor for persistent attribute: comdes15000ac
	 */
	public abstract void setComdes15000ac(java.math.BigDecimal newComdes15000ac);
	/**
	 * Get accessor for persistent attribute: cs000linminadqtc
	 */
	public abstract java.math.BigDecimal getCs000linminadqtc();
	/**
	 * Set accessor for persistent attribute: cs000linminadqtc
	 */
	public abstract void setCs000linminadqtc(
		java.math.BigDecimal newCs000linminadqtc);
	/**
	 * Get accessor for persistent attribute: cs000tipodecredito
	 */
	public abstract java.lang.String getCs000tipodecredito();
	/**
	 * Set accessor for persistent attribute: cs000tipodecredito
	 */
	public abstract void setCs000tipodecredito(
		java.lang.String newCs000tipodecredito);
	/**
	 * Get accessor for persistent attribute: cs000mixmonprest
	 */
	public abstract java.math.BigDecimal getCs000mixmonprest();
	/**
	 * Set accessor for persistent attribute: cs000mixmonprest
	 */
	public abstract void setCs000mixmonprest(
		java.math.BigDecimal newCs000mixmonprest);
	/**
	 * Get accessor for persistent attribute: cs000mixlinasistc
	 */
	public abstract java.math.BigDecimal getCs000mixlinasistc();
	/**
	 * Set accessor for persistent attribute: cs000mixlinasistc
	 */
	public abstract void setCs000mixlinasistc(
		java.math.BigDecimal newCs000mixlinasistc);
	/**
	 * Get accessor for persistent attribute: cs000mixtipotc
	 */
	public abstract java.lang.String getCs000mixtipotc();
	/**
	 * Set accessor for persistent attribute: cs000mixtipotc
	 */
	public abstract void setCs000mixtipotc(java.lang.String newCs000mixtipotc);
	/**
	 * Get accessor for persistent attribute: cs000prestcmena5000
	 */
	public abstract java.math.BigDecimal getCs000prestcmena5000();
	/**
	 * Set accessor for persistent attribute: cs000prestcmena5000
	 */
	public abstract void setCs000prestcmena5000(
		java.math.BigDecimal newCs000prestcmena5000);
	/**
	 * Get accessor for persistent attribute: cs000prestc500015000
	 */
	public abstract java.math.BigDecimal getCs000prestc500015000();
	/**
	 * Set accessor for persistent attribute: cs000prestc500015000
	 */
	public abstract void setCs000prestc500015000(
		java.math.BigDecimal newCs000prestc500015000);
	/**
	 * Get accessor for persistent attribute: cs000prestcmaya15000
	 */
	public abstract java.math.BigDecimal getCs000prestcmaya15000();
	/**
	 * Set accessor for persistent attribute: cs000prestcmaya15000
	 */
	public abstract void setCs000prestcmaya15000(
		java.math.BigDecimal newCs000prestcmaya15000);
	/**
	 * Get accessor for persistent attribute: atribctactepasv
	 */
	public abstract java.lang.String getAtribctactepasv();
	/**
	 * Set accessor for persistent attribute: atribctactepasv
	 */
	public abstract void setAtribctactepasv(java.lang.String newAtribctactepasv);
	/**
	 * Get accessor for persistent attribute: atribctaahpasv
	 */
	public abstract java.lang.String getAtribctaahpasv();
	/**
	 * Set accessor for persistent attribute: atribctaahpasv
	 */
	public abstract void setAtribctaahpasv(java.lang.String newAtribctaahpasv);
	/**
	 * Get accessor for persistent attribute: atribctaplazpasv
	 */
	public abstract java.lang.String getAtribctaplazpasv();
	/**
	 * Set accessor for persistent attribute: atribctaplazpasv
	 */
	public abstract void setAtribctaplazpasv(
		java.lang.String newAtribctaplazpasv);
	/**
	 * Get accessor for persistent attribute: atribctspasv
	 */
	public abstract java.lang.String getAtribctspasv();
	/**
	 * Set accessor for persistent attribute: atribctspasv
	 */
	public abstract void setAtribctspasv(java.lang.String newAtribctspasv);
	/**
	 * Get accessor for persistent attribute: atribfmutuopasv
	 */
	public abstract java.lang.String getAtribfmutuopasv();
	/**
	 * Set accessor for persistent attribute: atribfmutuopasv
	 */
	public abstract void setAtribfmutuopasv(java.lang.String newAtribfmutuopasv);
	/**
	 * Get accessor for persistent attribute: cobofserv
	 */
	public abstract java.lang.String getCobofserv();
	/**
	 * Set accessor for persistent attribute: cobofserv
	 */
	public abstract void setCobofserv(java.lang.String newCobofserv);
	/**
	 * Get accessor for persistent attribute: svidofserv
	 */
	public abstract java.lang.String getSvidofserv();
	/**
	 * Set accessor for persistent attribute: svidofserv
	 */
	public abstract void setSvidofserv(java.lang.String newSvidofserv);
	/**
	 * Get accessor for persistent attribute: soncofserv
	 */
	public abstract java.lang.String getSoncofserv();
	/**
	 * Set accessor for persistent attribute: soncofserv
	 */
	public abstract void setSoncofserv(java.lang.String newSoncofserv);
	/**
	 * Get accessor for persistent attribute: svincofserv
	 */
	public abstract java.lang.String getSvincofserv();
	/**
	 * Set accessor for persistent attribute: svincofserv
	 */
	public abstract void setSvincofserv(java.lang.String newSvincofserv);
	/**
	 * Get accessor for persistent attribute: phofserv
	 */
	public abstract java.lang.String getPhofserv();
	/**
	 * Set accessor for persistent attribute: phofserv
	 */
	public abstract void setPhofserv(java.lang.String newPhofserv);
	/**
	 * Get accessor for persistent attribute: debofserv
	 */
	public abstract java.lang.String getDebofserv();
	/**
	 * Set accessor for persistent attribute: debofserv
	 */
	public abstract void setDebofserv(java.lang.String newDebofserv);
	/**
	 * Get accessor for persistent attribute: vipofserv
	 */
	public abstract java.lang.String getVipofserv();
	/**
	 * Set accessor for persistent attribute: vipofserv
	 */
	public abstract void setVipofserv(java.lang.String newVipofserv);
	/**
	 * Get accessor for persistent attribute: ofcnetcan
	 */
	public abstract java.lang.String getOfcnetcan();
	/**
	 * Set accessor for persistent attribute: ofcnetcan
	 */
	public abstract void setOfcnetcan(java.lang.String newOfcnetcan);
	/**
	 * Get accessor for persistent attribute: ofcempcan
	 */
	public abstract java.lang.String getOfcempcan();
	/**
	 * Set accessor for persistent attribute: ofcempcan
	 */
	public abstract void setOfcempcan(java.lang.String newOfcempcan);
	/**
	 * Get accessor for persistent attribute: oflincocan
	 */
	public abstract java.lang.String getOflincocan();
	/**
	 * Set accessor for persistent attribute: oflincocan
	 */
	public abstract void setOflincocan(java.lang.String newOflincocan);
	/**
	 * Get accessor for persistent attribute: ofb24can
	 */
	public abstract java.lang.String getOfb24can();
	/**
	 * Set accessor for persistent attribute: ofb24can
	 */
	public abstract void setOfb24can(java.lang.String newOfb24can);
	/**
	 * Get accessor for persistent attribute: ofposcan
	 */
	public abstract java.lang.String getOfposcan();
	/**
	 * Set accessor for persistent attribute: ofposcan
	 */
	public abstract void setOfposcan(java.lang.String newOfposcan);
	/**
	 * Get accessor for persistent attribute: prefijo
	 */
	public abstract java.lang.String getPrefijo();
	/**
	 * Set accessor for persistent attribute: prefijo
	 */
	public abstract void setPrefijo(java.lang.String newPrefijo);
	/**
	 * Get accessor for persistent attribute: cs000montocta36
	 */
	public abstract java.lang.String getCs000montocta36();
	/**
	 * Set accessor for persistent attribute: cs000montocta36
	 */
	public abstract void setCs000montocta36(java.lang.String newCs000montocta36);
	/**
	 * Get accessor for persistent attribute: cs000montocta60
	 */
	public abstract java.math.BigDecimal getCs000montocta60();
}
