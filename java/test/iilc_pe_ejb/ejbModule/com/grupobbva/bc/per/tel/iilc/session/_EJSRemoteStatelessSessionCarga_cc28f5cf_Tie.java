// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.grupobbva.bc.per.tel.iilc.session;

import com.grupobbva.bc.per.tel.iilc.serializable.Area;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
import com.grupobbva.bc.per.tel.iilc.serializable.Total;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.rmi.Remote;
import javax.ejb.CreateException;
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

public class _EJSRemoteStatelessSessionCarga_cc28f5cf_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements Tie {
    
    private EJSRemoteStatelessSessionCarga_cc28f5cf target = null;
    private ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.grupobbva.bc.per.tel.iilc.session.SessionCarga:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (EJSRemoteStatelessSessionCarga_cc28f5cf) target;
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
                case 10: 
                    if (method.equals("createArea")) {
                        return createArea(in, reply);
                    }
                case 11: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    } else if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    } else if (method.equals("createTotal")) {
                        return createTotal(in, reply);
                    } else if (method.equals("deleteAreas")) {
                        return deleteAreas(in, reply);
                    }
                case 12: 
                    if (method.equals("createGestor")) {
                        return createGestor(in, reply);
                    } else if (method.equals("createPerfil")) {
                        return createPerfil(in, reply);
                    } else if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case 13: 
                    if (method.equals("createCliente")) {
                        return createCliente(in, reply);
                    } else if (method.equals("createOficina")) {
                        return createOficina(in, reply);
                    } else if (method.equals("createEmpresa")) {
                        return createEmpresa(in, reply);
                    } else if (method.equals("deleteTotales")) {
                        return deleteTotales(in, reply);
                    }
                case 14: 
                    if (method.equals("deleteGestores")) {
                        return deleteGestores(in, reply);
                    } else if (method.equals("deleteClientes")) {
                        return deleteClientes(in, reply);
                    } else if (method.equals("deleteOficinas")) {
                        return deleteOficinas(in, reply);
                    } else if (method.equals("deleteEmpresas")) {
                        return deleteEmpresas(in, reply);
                    }
                case 15: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    }
                case 16: 
                    if (method.equals("createMultitabla")) {
                        return createMultitabla(in, reply);
                    } else if (method.equals("createTerritorio")) {
                        return createTerritorio(in, reply);
                    }
                case 17: 
                    if (method.equals("deleteTerritorios")) {
                        return deleteTerritorios(in, reply);
                    }
                case 19: 
                    if (method.equals("createPermisoPerfil")) {
                        return createPermisoPerfil(in, reply);
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
    
    private OutputStream createCliente(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Cliente arg0 = (Cliente) in.read_value(Cliente.class);
        boolean result = target.createCliente(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream createTotal(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Total arg0 = (Total) in.read_value(Total.class);
        boolean result = target.createTotal(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream createArea(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Area arg0 = (Area) in.read_value(Area.class);
        boolean result = target.createArea(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream createOficina(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Oficina arg0 = (Oficina) in.read_value(Oficina.class);
        boolean result = target.createOficina(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream createGestor(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Gestor arg0 = (Gestor) in.read_value(Gestor.class);
        boolean result = target.createGestor(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream createMultitabla(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Multitabla arg0 = (Multitabla) in.read_value(Multitabla.class);
        boolean result = target.createMultitabla(arg0);
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
    
    private OutputStream createPermisoPerfil(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        PermisoPerfil arg0 = (PermisoPerfil) in.read_value(PermisoPerfil.class);
        boolean result = target.createPermisoPerfil(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream createTerritorio(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Territorio arg0 = (Territorio) in.read_value(Territorio.class);
        boolean result;
        try {
            result = target.createTerritorio(arg0);
        } catch (CreateException ex) {
            String id = "IDL:javax/ejb/CreateEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,CreateException.class);
            return out;
        }
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream createEmpresa(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Empresa arg0 = (Empresa) in.read_value(Empresa.class);
        boolean result = target.createEmpresa(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream deleteTerritorios(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        boolean result = target.deleteTerritorios();
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream deleteAreas(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        boolean result = target.deleteAreas();
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream deleteGestores(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        boolean result = target.deleteGestores();
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream deleteClientes(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        boolean result = target.deleteClientes();
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream deleteOficinas(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        boolean result = target.deleteOficinas();
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream deleteTotales(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        boolean result = target.deleteTotales();
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream deleteEmpresas(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        boolean result = target.deleteEmpresas();
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
}
