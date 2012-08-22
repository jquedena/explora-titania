package entities.websphere_deploy.ORACLE_V10_1;

/**
 * Tiido_epigrafeBeanAdaptorBinding_b2c8f8ed
 */
public class Tiido_epigrafeBeanAdaptorBinding_b2c8f8ed implements com.ibm.ws.ejbpersistence.beanextensions.EJBAdapterBinding {
	/**
	 * getExtractor
	 */
	public com.ibm.ws.ejbpersistence.dataaccess.EJBExtractor getExtractor() {
		// extractor for entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanExtractor_b2c8f8ed
		com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor extractor =  new entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanExtractor_b2c8f8ed();
		extractor.setPrimaryKeyColumns(new int[] {1,2});
		extractor.setDataColumns(new int[] {1,2,3,4,5,6,7,8,9,10,11,12});
		return extractor;
	}
	/**
	 * getInjector
	 */
	public com.ibm.ws.ejbpersistence.beanextensions.EJBInjector getInjector() {
		return new entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanInjectorImpl_b2c8f8ed();
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
		cat[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogRDBAlias("Tiido_epigrafe", "Tiido_epigrafe1_Alias", "ORACLE", "IIDO.TIIDO_EPIGRAFE", "Tiido_epigrafe_Tiido_epigrafe1_Table", 10, 0, 0);


		//-----------------------------------Table Type-----------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[12];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("COD_EPIGRAFE", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 8, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ANHO", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 4, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("NOM_EPIGRAFE", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 50, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("IND_CLASE", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 2, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("IND_SUB_CLASE", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 2, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[5] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ORDEN", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 4, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[6] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("IND_GRUPO", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 2, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[7] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ABREVIATURA", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 10, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[8] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("IND_HIJO", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 10, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[9] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("IND_AFECTA", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 1, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[10] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("PORCENTAJE_MAX", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._NUMERIC, -1, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 5, 0, 0, false);
		fields[11] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("PORCENTAJE_MIN", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._NUMERIC, -1, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 5, 0, 0, false);
		primarykey = new String[2];
		primarykey[0] = "COD_EPIGRAFE";
		primarykey[1] = "ANHO";
		cat[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("Tiido_epigrafe", "Tiido_epigrafe1_Table", null, fields, primarykey);


		//-----------------------------------Bean Type-----------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[14];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("cod_epigrafe", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("anho", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("nom_epigrafe", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ind_clase", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ind_sub_clase", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[5] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("orden", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[6] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ind_grupo", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[7] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("abreviatura", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[8] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ind_hijo", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[9] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ind_afecta", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[10] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("porcentaje_max", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._DECIMAL, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, true);
		fields[11] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("porcentaje_min", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._DECIMAL, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, true);
		fields[12] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("tiido_acciones", "Tiido_acciones", com.ibm.ObjectQuery.engine.OSQLConstants.MANY, "tiido_acc_epigrafe_fk", com.ibm.ObjectQuery.engine.OSQLConstants.SINGLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLSymbols.LISTOF, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO, false);
		fields[13] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("tiido_metas_gestor", "Tiido_metas_gestor", com.ibm.ObjectQuery.engine.OSQLConstants.MANY, "tiido_metges_epigrafe_fk", com.ibm.ObjectQuery.engine.OSQLConstants.SINGLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLSymbols.LISTOF, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO, false);
		primarykey = new String[2];
		primarykey[0] = "cod_epigrafe";
		primarykey[1] = "anho";
		cat[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("Tiido_epigrafe", "Tiido_epigrafe_BO", "entities.Tiido_epigrafeBean", fields, primarykey);


		//--------------------------------------View--------------------------------------
		composedObjs = null;
		composedObjImpls = null;
		subhomes = null;
		cat[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogView("Tiido_epigrafe", "Tiido_epigrafe_Tiido_epigrafe_BO", "Tiido_epigrafe_Tiido_epigrafe1_Alias", composedObjs, composedObjImpls, 
		"select t1.COD_EPIGRAFE,t1.ANHO,t1.NOM_EPIGRAFE,t1.IND_CLASE,t1.IND_SUB_CLASE,t1.ORDEN,t1.IND_GRUPO,t1.ABREVIATURA,t1.IND_HIJO,t1.IND_AFECTA,t1.PORCENTAJE_MAX,t1.PORCENTAJE_MIN,(select  nest  (t2) from Tiido_acciones_Tiido_acciones1_Alias t2 where t2.COD_EPIGRAFE = t1.COD_EPIGRAFE and t2.ANHO = t1.ANHO),(select  nest  (t3) from Tiido_metas_gestor_Tiido_metas_gestor1_Alias t3 where t3.COD_EPIGRAFE = t1.COD_EPIGRAFE and t3.ANHO = t1.ANHO) from _this t1", 
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
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("Create");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Create");
		daSpec.setInputRecordName("Create");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.CREATE_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("Remove");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Remove");
		daSpec.setInputRecordName("Remove");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.REMOVE_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("Store");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("StoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("FindByCodEpigAnho");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByCodEpigAnho");
		daSpec.setInputRecordName("FindByCodEpigAnho");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("FindByCodEpigAnho444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByCodEpigAnho");
		daSpec.setInputRecordName("FindByCodEpigAnho");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("FindByPrimaryKey");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("FindByPrimaryKey444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("FindEpiByAnho");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindEpiByAnho");
		daSpec.setInputRecordName("FindEpiByAnho");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("FindEpiByAnho444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindEpiByAnho");
		daSpec.setInputRecordName("FindEpiByAnho");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("FindByCodEpig");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByCodEpig");
		daSpec.setInputRecordName("FindByCodEpig");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("FindByCodEpig444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByCodEpig");
		daSpec.setInputRecordName("FindByCodEpig");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("ReadReadChecking");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("ReadReadChecking");
		daSpec.setInputRecordName("ReadReadChecking");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.READ_READ);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("ReadReadCheckingForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("ReadReadChecking");
		daSpec.setInputRecordName("ReadReadChecking");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.READ_READ);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("PartialStore");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.OTHER);
		daSpec.setProperty("IS_PARTIAL_UPDATE", Boolean.TRUE);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("entities.websphere_deploy.ORACLE_V10_1.Tiido_epigrafeBeanFunctionSet_b2c8f8ed");
		iSpec.setFunctionName("PartialStoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.OTHER);
		daSpec.setProperty("IS_PARTIAL_UPDATE", Boolean.TRUE);
		daSpec.setQueryScope(new String[]{"Tiido_epigrafe"});
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
	 * Tiido_epigrafeBeanAdaptorBinding_b2c8f8ed
	 */
	public Tiido_epigrafeBeanAdaptorBinding_b2c8f8ed() {
		properties = new java.util.HashMap();
		properties.put("VERSION", "7.0.0.0");
	}
	private java.util.HashMap properties;
}
