package entities;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTiido_ingresosHomeBean_8a37af04
 */
public class EJSCMPTiido_ingresosHomeBean_8a37af04 extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPTiido_ingresosHomeBean_8a37af04
	 */
	public EJSCMPTiido_ingresosHomeBean_8a37af04() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public entities.Tiido_ingresosLocal create_Local(java.math.BigDecimal id_ingresos) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		entities.Tiido_ingresosLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			entities.Tiido_ingresosBean bean = (entities.Tiido_ingresosBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(id_ingresos);
			Object ejsKey = keyFromBean(bean);
			result = (entities.Tiido_ingresosLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(id_ingresos);
			super.afterPostCreate(beanO, ejsKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if(preCreateFlag && !createFailed)
				super.afterPostCreateCompletion(beanO);
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return result;
	}
	/**
	 * findByPrimaryKey_Local
	 */
	public entities.Tiido_ingresosLocal findByPrimaryKey_Local(entities.Tiido_ingresosKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (entities.Tiido_ingresosLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		entities.ConcreteTiido_ingresos_8a37af04 tmpEJB = (entities.ConcreteTiido_ingresos_8a37af04) generalEJB;
		entities.Tiido_ingresosKey keyClass = new entities.Tiido_ingresosKey();
		keyClass.id_ingresos = tmpEJB.getId_ingresos();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public entities.Tiido_ingresosKey keyFromFields(java.math.BigDecimal f0) {
		entities.Tiido_ingresosKey keyClass = new entities.Tiido_ingresosKey();
		keyClass.id_ingresos = f0;
		return keyClass;
	}
}
