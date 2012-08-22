// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.grupobbva.bc.per.tele.sdo.sesion;

import com.grupobbva.bc.per.tele.sdo.serializable.Perfil;
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

public class _EJSRemoteStatelessSesionPerfiles_5441b32a_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements Tie {
    
    private EJSRemoteStatelessSesionPerfiles_5441b32a target = null;
    private ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.grupobbva.bc.per.tele.sdo.sesion.SesionPerfiles:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (EJSRemoteStatelessSesionPerfiles_5441b32a) target;
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
            switch (method.charAt(0)) {
                case 95: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    } else if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    } else if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case 99: 
                    if (method.equals("createPerfil")) {
                        return createPerfil(in, reply);
                    }
                case 100: 
                    if (method.equals("deletePerfil")) {
                        return deletePerfil(in, reply);
                    }
                case 102: 
                    if (method.equals("findPerfil")) {
                        return findPerfil(in, reply);
                    } else if (method.equals("findAllPerfil")) {
                        return findAllPerfil(in, reply);
                    }
                case 105: 
                    if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    }
                case 114: 
                    if (method.equals("remove")) {
                        return remove(in, reply);
                    }
                case 117: 
                    if (method.equals("updatePerfil")) {
                        return updatePerfil(in, reply);
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
    
    private OutputStream findPerfil(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Perfil result = target.findPerfil(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Perfil.class);
        return out;
    }
    
    private OutputStream updatePerfil(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Perfil arg0 = (Perfil) in.read_value(Perfil.class);
        boolean result = target.updatePerfil(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream findAllPerfil(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Vector result = target.findAllPerfil();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Vector.class);
        return out;
    }
    
    private OutputStream deletePerfil(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        boolean result = target.deletePerfil(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream createPerfil(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Perfil arg0 = (Perfil) in.read_value(Perfil.class);
        boolean result = target.createPerfil(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
}