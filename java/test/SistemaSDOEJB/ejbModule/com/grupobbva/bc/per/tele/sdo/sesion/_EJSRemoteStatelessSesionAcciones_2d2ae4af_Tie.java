// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.grupobbva.bc.per.tele.sdo.sesion;

import com.grupobbva.bc.per.tele.sdo.serializable.Accion;
import com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento;
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

public class _EJSRemoteStatelessSesionAcciones_2d2ae4af_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements Tie {
    
    private EJSRemoteStatelessSesionAcciones_2d2ae4af target = null;
    private ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.grupobbva.bc.per.tele.sdo.sesion.SesionAcciones:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (EJSRemoteStatelessSesionAcciones_2d2ae4af) target;
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
                    if (method.equals("busAccion")) {
                        return busAccion(in, reply);
                    }
                case 10: 
                    if (method.equals("busAllAnho")) {
                        return busAllAnho(in, reply);
                    }
                case 11: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    } else if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    } else if (method.equals("nuevaAccion")) {
                        return nuevaAccion(in, reply);
                    }
                case 12: 
                    if (method.equals("codigoAccion")) {
                        return codigoAccion(in, reply);
                    } else if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case 13: 
                    if (method.equals("codOficinaMax")) {
                        return codOficinaMax(in, reply);
                    } else if (method.equals("edicionAccion")) {
                        return edicionAccion(in, reply);
                    }
                case 14: 
                    if (method.equals("eliminarAccion")) {
                        return eliminarAccion(in, reply);
                    }
                case 15: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    } else if (method.equals("busAccionesPGG3")) {
                        return busAccionesPGG3(in, reply);
                    }
                case 22: 
                    if (method.equals("actualizarSeguimiento1")) {
                        return actualizarSeguimiento1(in, reply);
                    } else if (method.equals("actualizarSeguimiento2")) {
                        return actualizarSeguimiento2(in, reply);
                    }
                case 95: 
                    if (method.equals("pggSeguimiento1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue")) {
                        return pggSeguimiento1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(in, reply);
                    } else if (method.equals("pggSeguimiento2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue")) {
                        return pggSeguimiento2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(in, reply);
                    }
                case 101: 
                    if (method.equals("pggEsfuerzoAdicional1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue")) {
                        return pggEsfuerzoAdicional1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(in, reply);
                    } else if (method.equals("pggEsfuerzoAdicional2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue")) {
                        return pggEsfuerzoAdicional2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(in, reply);
                    }
                case 155: 
                    if (method.equals("pggSeguimiento1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento")) {
                        return pggSeguimiento1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento(in, reply);
                    } else if (method.equals("pggSeguimiento2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento")) {
                        return pggSeguimiento2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento(in, reply);
                    }
                case 161: 
                    if (method.equals("pggEsfuerzoAdicional1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento")) {
                        return pggEsfuerzoAdicional1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento(in, reply);
                    } else if (method.equals("pggEsfuerzoAdicional2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento")) {
                        return pggEsfuerzoAdicional2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento(in, reply);
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
    
    private OutputStream busAllAnho(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Vector result = target.busAllAnho();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream busAccionesPGG3(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        Vector result = target.busAccionesPGG3(arg0, arg1, arg2, arg3);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream codigoAccion(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        int result = target.codigoAccion();
        OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private OutputStream eliminarAccion(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Vector result = target.eliminarAccion(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream codOficinaMax(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Vector result = target.codOficinaMax(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream pggSeguimiento1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        Vector result = target.pggSeguimiento1(arg0, arg1, arg2, arg3);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream pggEsfuerzoAdicional1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        Vector result = target.pggEsfuerzoAdicional1(arg0, arg1, arg2, arg3);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream pggSeguimiento2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        Vector result = target.pggSeguimiento2(arg0, arg1, arg2, arg3);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream pggEsfuerzoAdicional2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        Vector result = target.pggEsfuerzoAdicional2(arg0, arg1, arg2, arg3);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream busAccion(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Accion result = target.busAccion(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Accion.class);
        return out;
    }
    
    private OutputStream pggSeguimiento1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        ProgSeguimiento arg4 = (ProgSeguimiento) in.read_value(ProgSeguimiento.class);
        Vector result = target.pggSeguimiento1(arg0, arg1, arg2, arg3, arg4);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream pggEsfuerzoAdicional1__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        ProgSeguimiento arg4 = (ProgSeguimiento) in.read_value(ProgSeguimiento.class);
        Vector result = target.pggEsfuerzoAdicional1(arg0, arg1, arg2, arg3, arg4);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream pggSeguimiento2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        ProgSeguimiento arg4 = (ProgSeguimiento) in.read_value(ProgSeguimiento.class);
        Vector result = target.pggSeguimiento2(arg0, arg1, arg2, arg3, arg4);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream pggEsfuerzoAdicional2__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__com_grupobbva_bc_per_tele_sdo_serializable_ProgSeguimiento(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        ProgSeguimiento arg4 = (ProgSeguimiento) in.read_value(ProgSeguimiento.class);
        Vector result = target.pggEsfuerzoAdicional2(arg0, arg1, arg2, arg3, arg4);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream nuevaAccion(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        String arg4 = (String) in.read_value(String.class);
        String arg5 = (String) in.read_value(String.class);
        String arg6 = (String) in.read_value(String.class);
        String arg7 = (String) in.read_value(String.class);
        String arg8 = (String) in.read_value(String.class);
        String arg9 = (String) in.read_value(String.class);
        String arg10 = (String) in.read_value(String.class);
        String arg11 = (String) in.read_value(String.class);
        String arg12 = (String) in.read_value(String.class);
        String arg13 = (String) in.read_value(String.class);
        String arg14 = (String) in.read_value(String.class);
        String arg15 = (String) in.read_value(String.class);
        String arg16 = (String) in.read_value(String.class);
        Vector result = target.nuevaAccion(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream actualizarSeguimiento1(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        String arg4 = (String) in.read_value(String.class);
        String arg5 = (String) in.read_value(String.class);
        boolean result = target.actualizarSeguimiento1(arg0, arg1, arg2, arg3, arg4, arg5);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream actualizarSeguimiento2(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        String arg4 = (String) in.read_value(String.class);
        String arg5 = (String) in.read_value(String.class);
        boolean result = target.actualizarSeguimiento2(arg0, arg1, arg2, arg3, arg4, arg5);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream edicionAccion(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        String arg3 = (String) in.read_value(String.class);
        String arg4 = (String) in.read_value(String.class);
        boolean result = target.edicionAccion(arg0, arg1, arg2, arg3, arg4);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
}
