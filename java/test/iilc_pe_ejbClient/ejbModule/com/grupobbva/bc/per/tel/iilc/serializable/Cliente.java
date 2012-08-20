package com.grupobbva.bc.per.tel.iilc.serializable;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected int cod_cliente;
	
	protected String cod_territorio;
	protected String cod_oficina;
	protected String cod_gestor;
	protected String nro_documento;
	protected String nombre;
	protected String codigo;
	protected String segment1;
	protected int edad;
	protected String estcivil;
	protected String perfil;
	protected String direc1;
	protected String calle;
	protected String nro;
	protected String distrito;
	protected String provincia;
	protected String departamento;
	protected String tipo_persona;
	protected String clasificacion;
	protected String telefono;
	protected String vinculacion;
	protected String prefijo;

	protected long pper;
	protected long pcom;
	protected long vnac;
	protected long ccte;
	protected long colb;
	protected String cnet;
	protected long paut;
	protected long dsct;
	protected long varc;
	protected String cemp;
	protected long cext;
	protected long phip;
	protected long leas;
	protected long vcla;
	protected long cvip;
	protected String linco;
	protected long pmiv;
	protected long cloc;
	protected long vrep;
	protected long ahsd;
	protected long sonc;
	protected String b24;
	protected long cpte;
	protected long pref;
	protected long voro;
	protected long ahor;
	protected long spro;
	protected String pos;
	protected long pmas;
	protected long lcta;
	protected long vpla;
	protected long plzo;
	protected long pserv;
	protected long prom;
	protected long svid;
	protected long vemp;
	protected long sdep;
	protected long ph;
	protected long fcex;
	protected long vctr;
	protected long fmut;
	protected long emph;
	protected long aval;
	protected long mcla;
	protected long cts;
	protected long tdeb;
	protected long moro;
	protected long ctsd;
	protected long tvip;
	
	protected long tco;
	protected long t_act2;
	protected long t_act3;
	protected long t_act4;
	protected long t_act5;
	protected long t_act6;
	protected long tpr;
	
	protected long t_act_ct2;
	protected long t_act_ct3;
	protected long t_act_ct4;
	protected long t_act_ct5;
	protected String t_act_ct6;
	
	protected long margeno;
	protected long bcorie;
	protected long bcorid;
	protected long bcorii;
	protected long bcopas;
	protected long bcovol;
	protected long porcrie;
	protected long porcrid;
	protected long porcrii;
	protected long sbsrie;
	protected long sbsrid;
	protected long sbsrii;
	protected long sbsjud;
	
	protected String cod_empresa;
	protected String des_empresa;
	
	// ALZ (2010.09.22) CAMPOS NUEVOS (PETICION 2010-03-204)
	protected String intervpas;
	protected long mofactv;
	protected long cs000lineamaxtc;
	protected String mofpasv;
	protected String mofserv;
	protected String mofcanal;
	protected String mphpasv;
	protected long cs000mtoprestamo;
	protected long montovehicular;
	protected long montohipotecario;
	protected String ctacteoferta;
	protected String ctaahoferta;
	protected String ctapoferta;
	protected String fmutuoofert;
	protected String ctactsofert;
	protected BigDecimal tconsactv;
	protected long montosubrogados;
	protected BigDecimal tsubactv;
	protected BigDecimal thipotactv;
	protected BigDecimal tvehicactv;
	protected String cs000montocta36;
	protected BigDecimal tcuot36act;
	protected long cs000montocta48;
	protected BigDecimal tcuot48act;
	protected BigDecimal cs000montocta60;
	protected BigDecimal tcuot60act;
	protected BigDecimal cs000presmena5000;
	protected BigDecimal cs000comisdesemen5000;
	protected BigDecimal cs000pres5000a15000;
	protected BigDecimal c5000comdes15000act;
	protected BigDecimal cs000presmaya15000;
	protected BigDecimal comdes15000ac;
	protected long cs000linminadqtc;
	protected String cs000tipodecredito;
	protected long cs000mixmonprest;
	protected long cs000mixlinasistc;
	protected String cs000mixtipotc;
	protected BigDecimal cs000prestcmena5000;
	protected BigDecimal cs000prestc500015000;
	protected BigDecimal cs000prestcmaya15000;
	protected String atribctactepasv;
	protected String atribctaahpasv;
	protected String atribctaplazpasv;
	protected String atribctspasv;
	protected String atribfmutuopasv;
	protected String cobofserv;
	protected String svidofserv;
	protected String soncofserv;
	protected String svincofserv;
	protected String phofserv;
	protected String debofserv;
	protected String vipofserv;
	protected String ofcnetcan;
	protected String ofcempcan;
	protected String oflincocan;
	protected String ofb24can;
	protected String ofposcan;
	
	public Cliente(){
		tconsactv = new BigDecimal("0");
		tsubactv = new BigDecimal("0");
		thipotactv = new BigDecimal("0");
		tvehicactv = new BigDecimal("0");
		//cs000montocta36 = new BigDecimal("0");
		tcuot36act = new BigDecimal("0");
		//cs000montocta48 = new BigDecimal("0");
		tcuot48act = new BigDecimal("0");
		cs000montocta60 = new BigDecimal("0");
		tcuot60act = new BigDecimal("0");
		cs000presmena5000 = new BigDecimal("0");
		cs000comisdesemen5000 = new BigDecimal("0");
		cs000pres5000a15000 = new BigDecimal("0");
		c5000comdes15000act = new BigDecimal("0");
		cs000presmaya15000 = new BigDecimal("0");
		comdes15000ac = new BigDecimal("0");
		cs000prestcmena5000 = new BigDecimal("0");
		cs000prestc500015000 = new BigDecimal("0");
		cs000prestcmaya15000 = new BigDecimal("0");
	}
	
	/*
	 * Campos calculados o_O (de la secuencia de campos, toma el primero que no sea nulo)
	 */
	public String getOfertaSeguro(){
		if(svidofserv!=null)
			return svidofserv;
		else if(soncofserv!=null)
			return soncofserv;
		else if(svincofserv!=null)
			return svincofserv;
		else
			return "";
	}
	public String getOfertaTarjetas(){
		if(debofserv!=null)
			return debofserv;
		else if(vipofserv!=null)
			return vipofserv;
		else
			return "";
	}
	
	/*
	 * getters y setters
	 */
	public long getAhor() {
		return ahor;
	}
	public void setAhor(long ahor) {
		this.ahor = ahor;
	}
	public long getAhsd() {
		return ahsd;
	}
	public void setAhsd(long ahsd) {
		this.ahsd = ahsd;
	}
	public String getAtribctaahpasv() {
		return atribctaahpasv;
	}
	public void setAtribctaahpasv(String atribctaahpasv) {
		this.atribctaahpasv = atribctaahpasv;
	}
	public String getAtribctactepasv() {
		return atribctactepasv;
	}
	public void setAtribctactepasv(String atribctactepasv) {
		this.atribctactepasv = atribctactepasv;
	}
	public String getAtribctaplazpasv() {
		return atribctaplazpasv;
	}
	public void setAtribctaplazpasv(String atribctaplazpasv) {
		this.atribctaplazpasv = atribctaplazpasv;
	}
	public String getAtribctspasv() {
		return atribctspasv;
	}
	public void setAtribctspasv(String atribctspasv) {
		this.atribctspasv = atribctspasv;
	}
	public String getAtribfmutuopasv() {
		return atribfmutuopasv;
	}
	public void setAtribfmutuopasv(String atribfmutuopasv) {
		this.atribfmutuopasv = atribfmutuopasv;
	}
	public String getMofcanal() {
		return mofcanal;
	}
	public void setMofcanal(String mofcanal) {
		this.mofcanal = mofcanal;
	}
	public String getMofpasv() {
		return mofpasv;
	}
	public void setMofpasv(String mofpasv) {
		this.mofpasv = mofpasv;
	}
	public String getMofserv() {
		return mofserv;
	}
	public void setMofserv(String mofserv) {
		this.mofserv = mofserv;
	}
	public long getMontohipotecario() {
		return montohipotecario;
	}
	public long getAval() {
		return aval;
	}
	public void setAval(long aval) {
		this.aval = aval;
	}
	public String getB24() {
		return b24;
	}
	public void setB24(String b24) {
		this.b24 = b24;
	}
	public long getBcopas() {
		return bcopas;
	}
	public void setBcopas(long bcopas) {
		this.bcopas = bcopas;
	}
	public long getBcorid() {
		return bcorid;
	}
	public void setBcorid(long bcorid) {
		this.bcorid = bcorid;
	}
	public long getBcorie() {
		return bcorie;
	}
	public void setBcorie(long bcorie) {
		this.bcorie = bcorie;
	}
	public long getBcorii() {
		return bcorii;
	}
	public void setBcorii(long bcorii) {
		this.bcorii = bcorii;
	}
	public long getBcovol() {
		return bcovol;
	}
	public void setBcovol(long bcovol) {
		this.bcovol = bcovol;
	}
	public BigDecimal getC5000comdes15000act() {
		return c5000comdes15000act;
	}
	public void setC5000comdes15000act(BigDecimal c5000comdes15000act) {
		this.c5000comdes15000act = c5000comdes15000act;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public long getCcte() {
		return ccte;
	}
	public void setCcte(long ccte) {
		this.ccte = ccte;
	}
	public String getCemp() {
		return cemp;
	}
	public void setCemp(String cemp) {
		this.cemp = cemp;
	}
	public long getCext() {
		return cext;
	}
	public void setCext(long cext) {
		this.cext = cext;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public long getCloc() {
		return cloc;
	}
	public void setCloc(long cloc) {
		this.cloc = cloc;
	}
	public String getCnet() {
		return cnet;
	}
	public void setCnet(String cnet) {
		this.cnet = cnet;
	}
	public String getCobofserv() {
		return cobofserv;
	}
	public void setCobofserv(String cobofserv) {
		this.cobofserv = cobofserv;
	}
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getCod_empresa() {
		return cod_empresa;
	}
	public void setCod_empresa(String cod_empresa) {
		this.cod_empresa = cod_empresa;
	}
	public String getCod_gestor() {
		return cod_gestor;
	}
	public void setCod_gestor(String cod_gestor) {
		this.cod_gestor = cod_gestor;
	}
	public String getCod_oficina() {
		return cod_oficina;
	}
	public void setCod_oficina(String cod_oficina) {
		this.cod_oficina = cod_oficina;
	}
	public String getCod_territorio() {
		return cod_territorio;
	}
	public void setCod_territorio(String cod_territorio) {
		this.cod_territorio = cod_territorio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public long getColb() {
		return colb;
	}
	public void setColb(long colb) {
		this.colb = colb;
	}
	public BigDecimal getComdes15000ac() {
		return comdes15000ac;
	}
	public void setComdes15000ac(BigDecimal comdes15000ac) {
		this.comdes15000ac = comdes15000ac;
	}
	public long getCpte() {
		return cpte;
	}
	public void setCpte(long cpte) {
		this.cpte = cpte;
	}
	public BigDecimal getCs000comisdesemen5000() {
		return cs000comisdesemen5000;
	}
	public void setCs000comisdesemen5000(BigDecimal cs000comisdesemen5000) {
		this.cs000comisdesemen5000 = cs000comisdesemen5000;
	}
	public long getCs000lineamaxtc() {
		return cs000lineamaxtc;
	}
	public void setCs000lineamaxtc(long cs000lineamaxtc) {
		this.cs000lineamaxtc = cs000lineamaxtc;
	}
	public long getCs000linminadqtc() {
		return cs000linminadqtc;
	}
	public void setCs000linminadqtc(long cs000linminadqtc) {
		this.cs000linminadqtc = cs000linminadqtc;
	}
	public long getCs000mixlinasistc() {
		return cs000mixlinasistc;
	}
	public void setCs000mixlinasistc(long cs000mixlinasistc) {
		this.cs000mixlinasistc = cs000mixlinasistc;
	}
	public long getCs000mixmonprest() {
		return cs000mixmonprest;
	}
	public void setCs000mixmonprest(long cs000mixmonprest) {
		this.cs000mixmonprest = cs000mixmonprest;
	}
	public String getCs000mixtipotc() {
		return cs000mixtipotc;
	}
	public void setCs000mixtipotc(String cs000mixtipotc) {
		this.cs000mixtipotc = cs000mixtipotc;
	}
	public String getCs000montocta36() {
		if (cs000montocta36!=null){
			if (cs000montocta36.length()==7)
				return cs000montocta36.substring(0,6) + "-" + cs000montocta36.substring(6,7);
		}
		return cs000montocta36;
	}
	public void setCs000montocta36(String cs000montocta36) {
		this.cs000montocta36 = cs000montocta36;
	}
	public long getCs000montocta48() {
		return cs000montocta48;
	}
	public void setCs000montocta48(long cs000montocta48) {
		this.cs000montocta48 = cs000montocta48;
	}
	public BigDecimal getCs000montocta60() {
		return cs000montocta60;
	}
	public void setCs000montocta60(BigDecimal cs000montocta60) {
		this.cs000montocta60 = cs000montocta60;
	}
	public BigDecimal getCs000pres5000a15000() {
		return cs000pres5000a15000;
	}
	public void setCs000pres5000a15000(BigDecimal cs000pres5000a15000) {
		this.cs000pres5000a15000 = cs000pres5000a15000;
	}
	public BigDecimal getCs000presmaya15000() {
		return cs000presmaya15000;
	}
	public void setCs000presmaya15000(BigDecimal cs000presmaya15000) {
		this.cs000presmaya15000 = cs000presmaya15000;
	}
	public BigDecimal getCs000presmena5000() {
		return cs000presmena5000;
	}
	public void setCs000presmena5000(BigDecimal cs000presmena5000) {
		this.cs000presmena5000 = cs000presmena5000;
	}
	public BigDecimal getCs000prestc500015000() {
		return cs000prestc500015000;
	}
	public void setCs000prestc500015000(BigDecimal cs000prestc500015000) {
		this.cs000prestc500015000 = cs000prestc500015000;
	}
	public BigDecimal getCs000prestcmaya15000() {
		return cs000prestcmaya15000;
	}
	public void setCs000prestcmaya15000(BigDecimal cs000prestcmaya15000) {
		this.cs000prestcmaya15000 = cs000prestcmaya15000;
	}
	public BigDecimal getCs000prestcmena5000() {
		return cs000prestcmena5000;
	}
	public void setCs000prestcmena5000(BigDecimal cs000prestcmena5000) {
		this.cs000prestcmena5000 = cs000prestcmena5000;
	}
	public String getCs000tipodecredito() {
		return cs000tipodecredito;
	}
	public void setCs000tipodecredito(String cs000tipodecredito) {
		this.cs000tipodecredito = cs000tipodecredito;
	}
	public String getCtaahoferta() {
		return ctaahoferta;
	}
	public void setCtaahoferta(String ctaahoferta) {
		this.ctaahoferta = ctaahoferta;
	}
	public String getCtacteoferta() {
		return ctacteoferta;
	}
	public void setCtacteoferta(String ctacteoferta) {
		this.ctacteoferta = ctacteoferta;
	}
	public String getCtactsofert() {
		return ctactsofert;
	}
	public void setCtactsofert(String ctactsofert) {
		this.ctactsofert = ctactsofert;
	}
	public String getCtapoferta() {
		return ctapoferta;
	}
	public void setCtapoferta(String ctapoferta) {
		this.ctapoferta = ctapoferta;
	}
	public long getCts() {
		return cts;
	}
	public void setCts(long cts) {
		this.cts = cts;
	}
	public long getCtsd() {
		return ctsd;
	}
	public void setCtsd(long ctsd) {
		this.ctsd = ctsd;
	}
	public long getCvip() {
		return cvip;
	}
	public void setCvip(long cvip) {
		this.cvip = cvip;
	}
	public String getDebofserv() {
		return debofserv;
	}
	public void setDebofserv(String debofserv) {
		this.debofserv = debofserv;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getDes_empresa() {
		return des_empresa;
	}
	public void setDes_empresa(String des_empresa) {
		this.des_empresa = des_empresa;
	}
	public String getDirec1() {
		return direc1;
	}
	public void setDirec1(String direc1) {
		this.direc1 = direc1;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public long getDsct() {
		return dsct;
	}
	public void setDsct(long dsct) {
		this.dsct = dsct;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public long getEmph() {
		return emph;
	}
	public void setEmph(long emph) {
		this.emph = emph;
	}
	public String getEstcivil() {
		return estcivil;
	}
	public void setEstcivil(String estcivil) {
		this.estcivil = estcivil;
	}
	public long getFcex() {
		return fcex;
	}
	public void setFcex(long fcex) {
		this.fcex = fcex;
	}
	public long getFmut() {
		return fmut;
	}
	public void setFmut(long fmut) {
		this.fmut = fmut;
	}
	public String getFmutuoofert() {
		return fmutuoofert;
	}
	public void setFmutuoofert(String fmutuoofert) {
		this.fmutuoofert = fmutuoofert;
	}
	public String getIntervpas() {
		return intervpas;
	}
	public void setIntervpas(String intervpas) {
		this.intervpas = intervpas;
	}
	public long getLcta() {
		return lcta;
	}
	public void setLcta(long lcta) {
		this.lcta = lcta;
	}
	public long getLeas() {
		return leas;
	}
	public void setLeas(long leas) {
		this.leas = leas;
	}
	public String getLinco() {
		return linco;
	}
	public void setLinco(String linco) {
		this.linco = linco;
	}
	public long getMargeno() {
		return margeno;
	}
	public void setMargeno(long margeno) {
		this.margeno = margeno;
	}
	public long getMcla() {
		return mcla;
	}
	public void setMcla(long mcla) {
		this.mcla = mcla;
	}
	public long getMofactv() {
		return mofactv;
	}
	public void setMofactv(long mofactv) {
		this.mofactv = mofactv;
	}
	public void setMontohipotecario(long montohipotecario) {
		this.montohipotecario = montohipotecario;
	}
	public long getMontosubrogados() {
		return montosubrogados;
	}
	public void setMontosubrogados(long montosubrogados) {
		this.montosubrogados = montosubrogados;
	}
	public long getMontovehicular() {
		return montovehicular;
	}
	public void setMontovehicular(long montovehicular) {
		this.montovehicular = montovehicular;
	}
	public long getMoro() {
		return moro;
	}
	public void setMoro(long moro) {
		this.moro = moro;
	}
	public String getMphpasv() {
		return mphpasv;
	}
	public void setMphpasv(String mphpasv) {
		this.mphpasv = mphpasv;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNro() {
		return nro;
	}
	public void setNro(String nro) {
		this.nro = nro;
	}
	public String getNro_documento() {
		return nro_documento;
	}
	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}
	public String getOfb24can() {
		return ofb24can;
	}
	public void setOfb24can(String ofb24can) {
		this.ofb24can = ofb24can;
	}
	public String getOfcempcan() {
		return ofcempcan;
	}
	public void setOfcempcan(String ofcempcan) {
		this.ofcempcan = ofcempcan;
	}
	public String getOfcnetcan() {
		return ofcnetcan;
	}
	public void setOfcnetcan(String ofcnetcan) {
		this.ofcnetcan = ofcnetcan;
	}
	public String getOflincocan() {
		return oflincocan;
	}
	public void setOflincocan(String oflincocan) {
		this.oflincocan = oflincocan;
	}
	public String getOfposcan() {
		return ofposcan;
	}
	public void setOfposcan(String ofposcan) {
		this.ofposcan = ofposcan;
	}
	public long getPaut() {
		return paut;
	}
	public void setPaut(long paut) {
		this.paut = paut;
	}
	public long getPcom() {
		return pcom;
	}
	public void setPcom(long pcom) {
		this.pcom = pcom;
	}
	public long getCs000mtoprestamo() {
		return cs000mtoprestamo;
	}
	public void setCs000mtoprestamo(long cs000mtoprestamo) {
		this.cs000mtoprestamo = cs000mtoprestamo;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public long getPh() {
		return ph;
	}
	public void setPh(long ph) {
		this.ph = ph;
	}
	public long getPhip() {
		return phip;
	}
	public void setPhip(long phip) {
		this.phip = phip;
	}
	public String getPhofserv() {
		return phofserv;
	}
	public void setPhofserv(String phofserv) {
		this.phofserv = phofserv;
	}
	public long getPlzo() {
		return plzo;
	}
	public void setPlzo(long plzo) {
		this.plzo = plzo;
	}
	public long getPmas() {
		return pmas;
	}
	public void setPmas(long pmas) {
		this.pmas = pmas;
	}
	public long getPmiv() {
		return pmiv;
	}
	public void setPmiv(long pmiv) {
		this.pmiv = pmiv;
	}
	public long getPorcrid() {
		return porcrid;
	}
	public void setPorcrid(long porcrid) {
		this.porcrid = porcrid;
	}
	public long getPorcrie() {
		return porcrie;
	}
	public void setPorcrie(long porcrie) {
		this.porcrie = porcrie;
	}
	public long getPorcrii() {
		return porcrii;
	}
	public void setPorcrii(long porcrii) {
		this.porcrii = porcrii;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public long getPper() {
		return pper;
	}
	public void setPper(long pper) {
		this.pper = pper;
	}
	public long getPref() {
		return pref;
	}
	public void setPref(long pref) {
		this.pref = pref;
	}
	public long getProm() {
		return prom;
	}
	public void setProm(long prom) {
		this.prom = prom;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public long getPserv() {
		return pserv;
	}
	public void setPserv(long pserv) {
		this.pserv = pserv;
	}
	public long getSbsjud() {
		return sbsjud;
	}
	public void setSbsjud(long sbsjud) {
		this.sbsjud = sbsjud;
	}
	public long getSbsrid() {
		return sbsrid;
	}
	public void setSbsrid(long sbsrid) {
		this.sbsrid = sbsrid;
	}
	public long getSbsrie() {
		return sbsrie;
	}
	public void setSbsrie(long sbsrie) {
		this.sbsrie = sbsrie;
	}
	public long getSbsrii() {
		return sbsrii;
	}
	public void setSbsrii(long sbsrii) {
		this.sbsrii = sbsrii;
	}
	public long getSdep() {
		return sdep;
	}
	public void setSdep(long sdep) {
		this.sdep = sdep;
	}
	public String getSegment1() {
		return segment1;
	}
	public void setSegment1(String segment1) {
		this.segment1 = segment1;
	}
	public long getSonc() {
		return sonc;
	}
	public void setSonc(long sonc) {
		this.sonc = sonc;
	}
	public String getSoncofserv() {
		return soncofserv;
	}
	public void setSoncofserv(String soncofserv) {
		this.soncofserv = soncofserv;
	}
	public long getSpro() {
		return spro;
	}
	public void setSpro(long spro) {
		this.spro = spro;
	}
	public long getSvid() {
		return svid;
	}
	public void setSvid(long svid) {
		this.svid = svid;
	}
	public String getSvidofserv() {
		return svidofserv;
	}
	public void setSvidofserv(String svidofserv) {
		this.svidofserv = svidofserv;
	}
	public String getSvincofserv() {
		return svincofserv;
	}
	public void setSvincofserv(String svincofserv) {
		this.svincofserv = svincofserv;
	}
	public long getT_act_ct2() {
		return t_act_ct2;
	}
	public void setT_act_ct2(long t_act_ct2) {
		this.t_act_ct2 = t_act_ct2;
	}
	public long getT_act_ct3() {
		return t_act_ct3;
	}
	public void setT_act_ct3(long t_act_ct3) {
		this.t_act_ct3 = t_act_ct3;
	}
	public long getT_act_ct4() {
		return t_act_ct4;
	}
	public void setT_act_ct4(long t_act_ct4) {
		this.t_act_ct4 = t_act_ct4;
	}
	public long getT_act_ct5() {
		return t_act_ct5;
	}
	public void setT_act_ct5(long t_act_ct5) {
		this.t_act_ct5 = t_act_ct5;
	}
	public String getT_act_ct6() {
		return t_act_ct6;
	}
	public void setT_act_ct6(String t_act_ct6) {
		this.t_act_ct6 = t_act_ct6;
	}
	public long getT_act2() {
		return t_act2;
	}
	public void setT_act2(long t_act2) {
		this.t_act2 = t_act2;
	}
	public long getT_act3() {
		return t_act3;
	}
	public void setT_act3(long t_act3) {
		this.t_act3 = t_act3;
	}
	public long getT_act4() {
		return t_act4;
	}
	public void setT_act4(long t_act4) {
		this.t_act4 = t_act4;
	}
	public long getT_act5() {
		return t_act5;
	}
	public void setT_act5(long t_act5) {
		this.t_act5 = t_act5;
	}
	public long getT_act6() {
		return t_act6;
	}
	public void setT_act6(long t_act6) {
		this.t_act6 = t_act6;
	}
	public long getTco() {
		return tco;
	}
	public void setTco(long tco) {
		this.tco = tco;
	}
	public BigDecimal getTconsactv() {
		return tconsactv;
	}
	public void setTconsactv(BigDecimal tconsactv) {
		this.tconsactv = tconsactv;
	}
	public BigDecimal getTcuot36act() {
		return tcuot36act;
	}
	public void setTcuot36act(BigDecimal tcuot36act) {
		this.tcuot36act = tcuot36act;
	}
	public BigDecimal getTcuot48act() {
		return tcuot48act;
	}
	public void setTcuot48act(BigDecimal tcuot48act) {
		this.tcuot48act = tcuot48act;
	}
	public BigDecimal getTcuot60act() {
		return tcuot60act;
	}
	public void setTcuot60act(BigDecimal tcuot60act) {
		this.tcuot60act = tcuot60act;
	}
	public long getTdeb() {
		return tdeb;
	}
	public void setTdeb(long tdeb) {
		this.tdeb = tdeb;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public BigDecimal getThipotactv() {
		return thipotactv;
	}
	public void setThipotactv(BigDecimal thipotactv) {
		this.thipotactv = thipotactv;
	}
	public String getTipo_persona() {
		return tipo_persona;
	}
	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
	}
	public long getTpr() {
		return tpr;
	}
	public void setTpr(long tpr) {
		this.tpr = tpr;
	}
	public BigDecimal getTsubactv() {
		return tsubactv;
	}
	public void setTsubactv(BigDecimal tsubactv) {
		this.tsubactv = tsubactv;
	}
	public BigDecimal getTvehicactv() {
		return tvehicactv;
	}
	public void setTvehicactv(BigDecimal tvehicactv) {
		this.tvehicactv = tvehicactv;
	}
	public long getTvip() {
		return tvip;
	}
	public void setTvip(long tvip) {
		this.tvip = tvip;
	}
	public long getVarc() {
		return varc;
	}
	public void setVarc(long varc) {
		this.varc = varc;
	}
	public long getVcla() {
		return vcla;
	}
	public void setVcla(long vcla) {
		this.vcla = vcla;
	}
	public long getVctr() {
		return vctr;
	}
	public void setVctr(long vctr) {
		this.vctr = vctr;
	}
	public long getVemp() {
		return vemp;
	}
	public void setVemp(long vemp) {
		this.vemp = vemp;
	}
	public String getVinculacion() {
		return vinculacion;
	}
	public void setVinculacion(String vinculacion) {
		this.vinculacion = vinculacion;
	}
	public String getVipofserv() {
		return vipofserv;
	}
	public void setVipofserv(String vipofserv) {
		this.vipofserv = vipofserv;
	}
	public long getVnac() {
		return vnac;
	}
	public void setVnac(long vnac) {
		this.vnac = vnac;
	}
	public long getVoro() {
		return voro;
	}
	public void setVoro(long voro) {
		this.voro = voro;
	}
	public long getVpla() {
		return vpla;
	}
	public void setVpla(long vpla) {
		this.vpla = vpla;
	}
	public long getVrep() {
		return vrep;
	}
	public void setVrep(long vrep) {
		this.vrep = vrep;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
}