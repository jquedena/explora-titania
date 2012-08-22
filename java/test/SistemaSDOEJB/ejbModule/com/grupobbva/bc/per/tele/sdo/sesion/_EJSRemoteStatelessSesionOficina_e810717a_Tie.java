// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.grupobbva.bc.per.tele.sdo.sesion;

import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija;
import com.grupobbva.bc.per.tele.sdo.serializable.Territorio;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.rmi.Remote;
import java.util.Vector;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import javax.rmi.CORBA.Tie;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.CORBA.portable.UnknownException;

public class _EJSRemoteStatelessSesionOficina_e810717a_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements Tie {
    
    private EJSRemoteStatelessSesionOficina_e810717a target = null;
    private ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.grupobbva.bc.per.tele.sdo.sesion.SesionOficina:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (EJSRemoteStatelessSesionOficina_e810717a) target;
    }
    
    public Remote getTarget() {
        return target;
    }
    
    public org.omg.CORBA.Object thisObject() {
        return this;
    }
    
    public void deactivate() {
        if (orb != null) {
            orb.disconnect(this);
            _set_delegate(null);
        }
    }
    
    public ORB orb() {
        return _orb();
    }
    
    public void orb(ORB orb) {
        orb.connect(this);
    }
    
    public void _set_delegate(Delegate del) {
        super._set_delegate(del);
        if (del != null)
            orb = _orb();
        else
            orb = null;
    }
    
    public String[] _ids() { 
        return _type_ids;
    }
    
    public OutputStream _invoke(String method, InputStream _in, ResponseHandler reply) throws SystemException {
        try {
            org.omg.CORBA_2_3.portable.InputStream in = 
                (org.omg.CORBA_2_3.portable.InputStream) _in;
            switch (method.length()) {
                case 6: 
                    if (method.equals("remove")) {
                        return remove(in, reply);
                    }
                case 9: 
                    if (method.equals("findHijas")) {
                        return findHijas(in, reply);
                    }
                case 11: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    } else if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    }
                case 12: 
                    if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case 15: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    } else if (method.equals("findAllOficinas")) {
                        return findAllOficinas(in, reply);
                    } else if (method.equals("findOficinaHija")) {
                        return findOficinaHija(in, reply);
                    } else if (method.equals("eliminarOficina")) {
                        return eliminarOficina(in, reply);
                    }
                case 16: 
                    if (method.equals("findByCodOficina")) {
                        return findByCodOficina(in, reply);
                    } else if (method.equals("crearOficinaHija")) {
                        return crearOficinaHija(in, reply);
                    }
                case 19: 
                    if (method.equals("findByCodigoOficina")) {
                        return findByCodigoOficina(in, reply);
                    } else if (method.equals("findOficinaAndTerri")) {
                        return findOficinaAndTerri(in, reply);
                    } else if (method.equals("eliminarOficinaHija")) {
                        return eliminarOficinaHija(in, reply);
                    }
                case 20: 
                    if (method.equals("findTodosOficinaHija")) {
                        return findTodosOficinaHija(in, reply);
                    } else if (method.equals("findByCodOficinaHija")) {
                        return findByCodOficinaHija(in, reply);
                    }
                case 21: 
                    if (method.equals("findListaByCodOficina")) {
                        return findListaByCodOficina(in, reply);
                    } else if (method.equals("actualizarOficinaHija")) {
                        return actualizarOficinaHija(in, reply);
                    }
                case 24: 
                    if (method.equals("findAllOficinaByCodTerri")) {
                        return findAllOficinaByCodTerri(in, reply);
                    }
                case 26: 
                    if (method.equals("findTerritorioByCodOficina")) {
                        return findTerritorioByCodOficina(in, reply);
                    }
                case 27: 
                    if (method.equals("editarTerritoriosDeOficinas")) {
                        return editarTerritoriosDeOficinas(in, reply);
                    }
                case 29: 
                    if (method.equals("findAllOficinaByCodTerri_MOD1")) {
                        return findAllOficinaByCodTerri_MOD1(in, reply);
                    } else if (method.equals("findAllOficinaByCodTerri_MOD2")) {
                        return findAllOficinaByCodTerri_MOD2(in, reply);
                    }
                case 41: 
                    if (method.equals("busOficinaxTerritorio__CORBA_WStringValue")) {
                        return busOficinaxTerritorio__CORBA_WStringValue(in, reply);
                    }
                case 50: 
                    if (method.equals("busOficinaxTerritorio__CORBA_WStringValue__boolean")) {
                        return busOficinaxTerritorio__CORBA_WStringValue__boolean(in, reply);
                    }
                case 65: 
                    if (method.equals("editarOficina__com_grupobbva_bc_per_tele_sdo_serializable_Oficina")) {
                        return editarOficina__com_grupobbva_bc_per_tele_sdo_serializable_Oficina(in, reply);
                    }
                case 72: 
                    if (method.equals("nuevaOficina__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue")) {
                        return nuevaOficina__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(in, reply);
                    }
                case 73: 
                    if (method.equals("editarOficina__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue")) {
                        return editarOficina__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(in, reply);
                    }
                case 92: 
                    if (method.equals("nuevaOficina__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue")) {
                        return nuevaOficina__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(in, reply);
                    }
            }
            throw new BAD_OPERATION();
        } catch (SystemException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new UnknownException(ex);
        }
    }
    
    private OutputStream _get_EJBHome(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        EJBHome result = target.getEJBHome();
        OutputStream out = reply.createReply();
        Util.writeRemoteObject(out,result);
        return out;
    }
    
    private OutputStream _get_primaryKey(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Object result = target.getPrimaryKey();
        OutputStream out = reply.createReply();
        Util.writeAny(out,result);
        return out;
    }
    
    private OutputStream remove(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        try {
            target.remove();
        } catch (RemoveException ex) {
            String id = "IDL:javax/ejb/RemoveEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,RemoveException.class);
            return out;
        }
        OutputStream out = reply.createReply();
        return out;
    }
    
    private OutputStream _get_handle(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Handle result = target.getHandle();
        OutputStream out = reply.createReply();
        Util.writeAbstractObject(out,result);
        return out;
    }
    
    private OutputStream isIdentical(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        EJBObject arg0 = (EJBObject) in.read_Object(EJBObject.class);
        boolean result = target.isIdentical(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream findAllOficinaByCodTerri(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Vector result = target.findAllOficinaByCodTerri(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream findAllOficinas(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Vector result = target.findAllOficinas();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream findByCodOficina(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Oficina result = target.findByCodOficina(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Oficina.class);
        return out;
    }
    
    private OutputStream findListaByCodOficina(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Vector result = target.findListaByCodOficina(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream busOficinaxTerritorio__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Vector result = target.busOficinaxTerritorio(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream nuevaOficina__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        Vector result = target.nuevaOficina(arg0, arg1, arg2);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream editarOficina__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        Vector result = target.editarOficina(arg0, arg1, arg2);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream findByCodigoOficina(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        boolean result = target.findByCodigoOficina(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream findOficinaAndTerri(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        boolean result = target.findOficinaAndTerri(arg0, arg1);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream findAllOficinaByCodTerri_MOD1(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        Vector result = target.findAllOficinaByCodTerri_MOD1(arg0, arg1, arg2);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream findAllOficinaByCodTerri_MOD2(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Vector result = target.findAllOficinaByCodTerri_MOD2(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream editarTerritoriosDeOficinas(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        Vector result = target.editarTerritoriosDeOficinas(arg0, arg1);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream findTerritorioByCodOficina(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Territorio result = target.findTerritorioByCodOficina(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Territorio.class);
        return out;
    }
    
    private OutputStream findOficinaHija(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        OficinaHija arg0 = (OficinaHija) in.read_value(OficinaHija.class);
        OficinaHija result = target.findOficinaHija(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,OficinaHija.class);
        return out;
    }
    
    private OutputStream crearOficinaHija(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        OficinaHija arg0 = (OficinaHija) in.read_value(OficinaHija.class);
        boolean result = target.crearOficinaHija(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream actualizarOficinaHija(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        OficinaHija arg0 = (OficinaHija) in.read_value(OficinaHija.class);
        boolean result = target.actualizarOficinaHija(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream eliminarOficinaHija(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        OficinaHija arg0 = (OficinaHija) in.read_value(OficinaHija.class);
        boolean result = target.eliminarOficinaHija(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream findTodosOficinaHija(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Vector result = target.findTodosOficinaHija();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream findHijas(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Vector result = target.findHijas(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream findByCodOficinaHija(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Oficina result = target.findByCodOficinaHija(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Oficina.class);
        return out;
    }
    
    private OutputStream busOficinaxTerritorio__CORBA_WStringValue__boolean(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        boolean arg1 = in.read_boolean();
        Vector result = target.busOficinaxTerritorio(arg0, arg1);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream editarOficina__com_grupobbva_bc_per_tele_sdo_serializable_Oficina(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Oficina arg0 = (Oficina) in.read_value(Oficina.class);
        Vector result = target.editarOficina(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream eliminarOficina(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        int result = target.eliminarOficina(arg0);
        OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private OutputStream nuevaOficina__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        int result = target.nuevaOficina(arg0, arg1, arg2, arg3);
        OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
}