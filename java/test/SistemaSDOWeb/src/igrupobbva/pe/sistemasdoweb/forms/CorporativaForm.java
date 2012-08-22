/**
 * Nombre	   : Corporativa.java  
 * Version     : 1.0	
 * Creacion    : 03/12/2008
 * Autor       : Orlando Pihue Montoya.
 * Usuario     : P020912
 * Finalidad   : Unifica la llamada de todos los sessions de modo que este se llame en la parte web.
 *
 * Modificacion: << fecha de modificacion>>
 * Autor       : <<quien actualizo el archivo>>
 * Usuario     : <<codigo de usuario modificador>>
 * Detalle     : <<descripcion de la modificacion>>
 */
package igrupobbva.pe.sistemasdoweb.forms;
import org.apache.struts.action.ActionForm;

public class CorporativaForm extends ActionForm{
    
    private String codMult;
    private String codEle;    
    private String valor1;
    private String valor2;
    private String valor3;
    private String valor4;
    
    
	/**
	 * @return Returns the codEle.
	 */
	public String getCodEle() {
		return codEle;
	}
	/**
	 * @param codEle The codEle to set.
	 */
	public void setCodEle(String codEle) {
		this.codEle = codEle;
	}
	/**
	 * @return Returns the codMult.
	 */
	public String getCodMult() {
		return codMult;
	}
	/**
	 * @param codMult The codMult to set.
	 */
	public void setCodMult(String codMult) {
		this.codMult = codMult;
	}
    /**
     * @return Returns the valor1.
     */
    public String getValor1() {
        return valor1;
    }
    /**
     * @param valor1 The valor1 to set.
     */
    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }
    /**
     * @return Returns the valor2.
     */
    public String getValor2() {
        return valor2;
    }
    /**
     * @param valor2 The valor2 to set.
     */
    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }
    /**
     * @return Returns the valor3.
     */
    public String getValor3() {
        return valor3;
    }
    /**
     * @param valor3 The valor3 to set.
     */
    public void setValor3(String valor3) {
        this.valor3 = valor3;
    }
    /**
     * @return Returns the valor4.
     */
    public String getValor4() {
        return valor4;
    }
    /**
     * @param valor4 The valor4 to set.
     */
    public void setValor4(String valor4) {
        this.valor4 = valor4;
    }
}