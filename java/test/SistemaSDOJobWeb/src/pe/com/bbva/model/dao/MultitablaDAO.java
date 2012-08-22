package pe.com.bbva.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import pe.com.bbva.model.entity.Multitabla;
import pe.com.bbva.model.entity.MultitablaId;
import pe.com.indra.component.model.AbstractSQL;
import pe.com.indra.component.model.DataAccessException;

public class MultitablaDAO extends AbstractSQL {
	
	public Multitabla getMultitabla(String codMult, String codElem) {
		Multitabla multitabla = null;
        try {
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("cod_mult = ", codMult);
            parameters.put("cod_elem = ", codElem);
            ResultSet rst = this.findByParams2("IIDO.TIIDO_MULTITABLA", parameters);
            if (rst != null) {
                if(rst.next()) {
                	multitabla = new Multitabla();
                	multitabla.setId(new MultitablaId());
                	multitabla.getId().setCodMult(rst.getString("COD_MULT").toString());
                	multitabla.getId().setCodElem(rst.getString("COD_ELEM").toString());
                	multitabla.setValor1(rst.getString("VALOR1").toString());
                	multitabla.setValor2("");
                	multitabla.setValor3("");
                	multitabla.setValor4("");
                }
            }
            this.close();
        } catch (DataAccessException e) {
            log.error("[MultitablaService::getMultitabla]", e);
        } catch (SQLException e) {
            log.error("[MultitablaService::getMultitabla]", e);
        }
        return multitabla;
    }
}
