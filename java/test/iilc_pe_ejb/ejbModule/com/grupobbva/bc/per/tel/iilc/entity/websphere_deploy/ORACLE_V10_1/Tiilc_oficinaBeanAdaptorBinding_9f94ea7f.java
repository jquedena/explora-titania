package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

/**
 * Tiilc_oficinaBeanAdaptorBinding_9f94ea7f
 */
public class Tiilc_oficinaBeanAdaptorBinding_9f94ea7f implements com.ibm.ws.ejbpersistence.beanextensions.EJBAdapterBinding {
	/**
	 * getExtractor
	 */
	public com.ibm.ws.ejbpersistence.dataaccess.EJBExtractor getExtractor() {
		// extractor for com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanExtractor_9f94ea7f
		com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor extractor =  new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanExtractor_9f94ea7f();
		extractor.setPrimaryKeyColumns(new int[] {1,4,3});
		extractor.setDataColumns(new int[] {1,2,4,3});
		return extractor;
	}
	/**
	 * getInjector
	 */
	public com.ibm.ws.ejbpersistence.beanextensions.EJBInjector getInjector() {
		return new com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanInjectorImpl_9f94ea7f();
	}
	/**
	 * getAdapter
	 */
	public com.ibm.websphere.ejbpersistence.EJBToRAAdapter getAdapter() {
		return com.ibm.ws.rsadapter.cci.WSRelationalRAAdapter.createAdapter();
	}
	/**
	 * getMetadata
	 */
	public Object[] getMetadata() {
		
		java.lang.String[] primarykey, subhomes, composedObjs, composedObjImpls;
		com.ibm.ObjectQuery.metadata.OSQLExternalCatalogEntry[] cat;
		com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[] fields;
		cat = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogEntry[5];

		//-------------------------------------Alias-------------------------------------
		cat[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogRDBAlias("Tiilc_oficina", "Tiilc_oficina1_Alias", "ORACLE", "IILC.TIILC_OFICINA", "Tiilc_oficina_Tiilc_oficina1_Table", 10, 0, 0);


		//-----------------------------------Table Type-----------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[4];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("COD_OFICINA", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 4, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("DES_OFICINA", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 100, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("COD_AREA", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 4, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("COD_TERRITORIO", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 4, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		primarykey = new String[3];
		primarykey[0] = "COD_AREA";
		primarykey[1] = "COD_TERRITORIO";
		primarykey[2] = "COD_OFICINA";
		cat[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("Tiilc_oficina", "Tiilc_oficina1_Table", null, fields, primarykey);


		//-----------------------------------Bean Type-----------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[4];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("cod_oficina", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("des_oficina", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("tiilc_territorio_fk", "Tiilc_territorio", com.ibm.ObjectQuery.engine.OSQLConstants.SINGLE, "tiilc_oficina", com.ibm.ObjectQuery.engine.OSQLConstants.MANY, true, com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO, false);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("tiilc_gestor", "Tiilc_gestor", com.ibm.ObjectQuery.engine.OSQLConstants.MANY, "tiilc_oficina_fk", com.ibm.ObjectQuery.engine.OSQLConstants.SINGLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLSymbols.LISTOF, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO, false);
		primarykey = new String[2];
		primarykey[0] = "cod_oficina";
		primarykey[1] = "tiilc_territorio_fk";
		cat[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("Tiilc_oficina", "Tiilc_oficina_BO", "com.grupobbva.bc.per.tel.iilc.entity.Tiilc_oficinaBean", fields, primarykey);


		//--------------------------------------View--------------------------------------
		composedObjs = null;
		composedObjImpls = null;
		subhomes = null;
		cat[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogView("Tiilc_oficina", "Tiilc_oficina_Tiilc_oficina_BO", "Tiilc_oficina_Tiilc_oficina1_Alias", composedObjs, composedObjImpls, 
		"select t1.COD_OFICINA,t1.DES_OFICINA,(select t2 from Tiilc_territorio_Tiilc_territorio1_Alias t2 where t2.COD_AREA = t1.COD_AREA and t2.COD_TERRITORIO = t1.COD_TERRITORIO),(select  nest  (t3) from Tiilc_gestor_Tiilc_gestor1_Alias t3 where t3.COD_AREA = t1.COD_AREA and t3.COD_TERRITORIO = t1.COD_TERRITORIO and t3.COD_OFICINA = t1.COD_OFICINA) from _this t1", 
		null, subhomes, 
		0, null);



		cat[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalSysApplOptions(14, false);

		return cat;
	}
	/**
	 * createDataAccessSpecs
	 */
	public java.util.Collection createDataAccessSpecs() throws javax.resource.ResourceException {
		com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec daSpec;
		com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl iSpec;
		java.util.Collection result = new java.util.ArrayList(16);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("Create");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Create");
		daSpec.setInputRecordName("Create");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.CREATE_BEAN);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("Remove");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Remove");
		daSpec.setInputRecordName("Remove");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.REMOVE_BEAN);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("Store");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("StoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("FindAllOficinaxTer");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAllOficinaxTer");
		daSpec.setInputRecordName("FindAllOficinaxTer");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina","Tiilc_territorio"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("FindAllOficinaxTer444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAllOficinaxTer");
		daSpec.setInputRecordName("FindAllOficinaxTer");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina","Tiilc_territorio"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("FindAllOficinaxCod_oficina");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAllOficinaxCod_oficina");
		daSpec.setInputRecordName("FindAllOficinaxCod_oficina");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("FindAllOficinaxCod_oficina444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAllOficinaxCod_oficina");
		daSpec.setInputRecordName("FindAllOficinaxCod_oficina");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("FindByPrimaryKey");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("FindByPrimaryKey444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("findTiilc_oficinaByTiilc_territorio_fkKey_Local");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findTiilc_oficinaByTiilc_territorio_fkKey_Local");
		daSpec.setInputRecordName("findTiilc_oficinaByTiilc_territorio_fkKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"tiilc_territorio_fk"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("findTiilc_oficinaByTiilc_territorio_fkKey_Local444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findTiilc_oficinaByTiilc_territorio_fkKey_Local");
		daSpec.setInputRecordName("findTiilc_oficinaByTiilc_territorio_fkKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"tiilc_territorio_fk"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("ReadReadChecking");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("ReadReadChecking");
		daSpec.setInputRecordName("ReadReadChecking");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.READ_READ);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("ReadReadCheckingForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("ReadReadChecking");
		daSpec.setInputRecordName("ReadReadChecking");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.READ_READ);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("PartialStore");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.OTHER);
		daSpec.setProperty("IS_PARTIAL_UPDATE", Boolean.TRUE);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1.Tiilc_oficinaBeanFunctionSet_9f94ea7f");
		iSpec.setFunctionName("PartialStoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.OTHER);
		daSpec.setProperty("IS_PARTIAL_UPDATE", Boolean.TRUE);
		daSpec.setQueryScope(new String[]{"Tiilc_oficina"});
		result.add(daSpec);

		return result;

	}
	/**
	 * getProperties
	 */
	public java.util.HashMap getProperties() {
		properties.put("USING_DB_AUTO_OCC_COLLISION_DETECTION", Boolean.FALSE);
		properties.put("NEED_REFRESH_AFTER_PERSISTENCE", Boolean.FALSE);
		return properties;
	}
	/**
	 * Tiilc_oficinaBeanAdaptorBinding_9f94ea7f
	 */
	public Tiilc_oficinaBeanAdaptorBinding_9f94ea7f() {
		properties = new java.util.HashMap();
		properties.put("VERSION", "7.0.0.0");
	}
	private java.util.HashMap properties;
}
