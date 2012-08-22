
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<script language="JavaScript">

	$(document).ready(function()
	{	
		fn_CalcularDistribMes();		
		fn_ActivarQuintaSemana();		
		$("#idAnio").removeClass('validate[required3]');
		$("#idMes").removeClass('validate[required3]');
		$("#idTerritorioFiltro").removeClass('validate[required3]');
		$("#idOficinaFiltro").removeClass('validate[required3]'); 		   
   	});
   	
</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js">
</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/app/configuracion/js/configBasicaMeta_Script.js">
</script>

<s:if test="%{#session.__current_user__.codigoPerfil!='ADM'}">
	<script language="JavaScript">

		validarQuintaSemana = false;
   	
	</script>	
</s:if>	

<s:form id="currentForm" theme="simple">

<s:hidden name="des_terr" id="des_terr"></s:hidden>
<s:hidden name="des_ofi" id="des_ofi"></s:hidden>
<s:hidden name="des_anio" id="des_anio"></s:hidden>
<s:hidden name="des_mes" id="des_mes"></s:hidden>
<s:hidden name="des_sem1" id="des_sem1"></s:hidden>
<s:hidden name="des_sem2" id="des_sem2"></s:hidden>
<s:hidden name="des_sem3" id="des_sem3"></s:hidden>
<s:hidden name="des_sem4" id="des_sem4"></s:hidden>
<s:hidden name="des_sem5" id="des_sem5"></s:hidden>
<s:hidden name="des_min_con_per" id="des_min_con_per"></s:hidden>
<s:hidden name="des_min_con_no_per" id="des_min_con_no_per"></s:hidden>
<s:hidden name="des_min_vis_per" id="des_min_vis_per"></s:hidden>
<s:hidden name="des_min_vis_no_per" id="des_min_vis_no_per"></s:hidden>
			
	<div class="ui-widget ui-widget-content ui-corner-all"
		style="width: 99%; margin: 3px 3px 3px 3px;">
	<div class="fondo_div_principal"><label>Configuración
	Básica de Metas</label></div>
	<div align="left" style="margin: 5px 5px 5px 5px;">
	<table width="100%">
		<s:include value="../comun/filtroTerritorioOficina.jsp"></s:include>
		<tr>
			<s:include value="../comun/comboAnio.jsp"></s:include>
			<s:include value="../comun/comboMes.jsp"></s:include>
			
			
		</tr>
		<tr>
			<td colspan="4" align="center">
			<div class="ui-widget ui-widget-content ui-corner-all" align="left"
				style="margin: 3px 3px 3px 0px; width: 610px;">
			<div style="margin: 3px 3px 3px 3px;">
			<table width="600px;">
				<tr>
					<td>
					<table width="600px;" class="dataTable">
						<tr>
							<td align="left"><label></label></td>
							<th align="left"><label>Semana1</label></th>
							<th align="left"><label>Semana2</label></th>
							<th align="left"><label>Semana3</label></th>
							<th align="left"><label>Semana4</label></th>
							<th align="left"><label>Semana5</label></th>
							<th align="left"><label>% Distribuido Mes</label></th>

						</tr>
						<tr>
							<th align="left" style="width: 120px"><label>Porcentaje
							Semanal</label></th>
							<s:hidden name="basicaMeta.id" id="id"></s:hidden>
							<td>
								<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
									<s:textfield name="basicaMeta.semana1"
									cssStyle="width:30px;" id="semana1" maxlength="3"
									onchange="fn_CalcularDistribMes(this);"
									onkeypress="return fn_validaTecla('entero', this);"></s:textfield>%
								</s:if>	
								<s:else>
									<s:textfield name="basicaMeta.semana1"
									cssStyle="width:30px;" id="semana1" maxlength="3"
									onchange="fn_CalcularDistribMes(this);"
									onkeypress="return fn_validaTecla('entero', this);"
									readonly="true" disabled="true"></s:textfield>%
								</s:else>		
							</td>
							<td>
								<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
									<s:textfield name="basicaMeta.semana2"
										cssStyle="width:30px;" id="semana2" maxlength="3"
										onchange="fn_CalcularDistribMes(this);"
										onkeypress="return fn_validaTecla('entero', this);"></s:textfield>%
								</s:if>	
								<s:else>
									<s:textfield name="basicaMeta.semana2"
										cssStyle="width:30px;" id="semana2" maxlength="3"
										onchange="fn_CalcularDistribMes(this);"
										onkeypress="return fn_validaTecla('entero', this);"
										readonly="true" disabled="true"></s:textfield>%
								</s:else>		
							</td>
							<td>
								<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
									<s:textfield name="basicaMeta.semana3"
											cssStyle="width:30px;" id="semana3" maxlength="3"
											onchange="fn_CalcularDistribMes(this);"
											onkeypress="return fn_validaTecla('entero', this);"></s:textfield>%
								</s:if>	
								<s:else>
									<s:textfield name="basicaMeta.semana3"
											cssStyle="width:30px;" id="semana3" maxlength="3"
											onchange="fn_CalcularDistribMes(this);"
											onkeypress="return fn_validaTecla('entero', this);"
											readonly="true" disabled="true"></s:textfield>%
								</s:else>
							</td>
							<td>
								<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
									<s:textfield name="basicaMeta.semana4"
												cssStyle="width:30px;" id="semana4" maxlength="3"
												onchange="fn_CalcularDistribMes(this);"
												onkeypress="return fn_validaTecla('entero', this);"></s:textfield>%
								</s:if>	
								<s:else>
									<s:textfield name="basicaMeta.semana4"
												cssStyle="width:30px;" id="semana4" maxlength="3"
												onchange="fn_CalcularDistribMes(this);"
												onkeypress="return fn_validaTecla('entero', this);"
												readonly="true" disabled="true"></s:textfield>%
								</s:else>
							</td>
							<td>
									<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
										<s:textfield name="basicaMeta.semana5"
											cssStyle="width:30px;" id="semana5" maxlength="3"
											onchange="fn_CalcularDistribMes(this);"
											onkeypress="return fn_validaTecla('entero', this);"></s:textfield>%
									</s:if>	
									<s:else>
										<s:textfield name="basicaMeta.semana5"
											cssStyle="width:30px;" id="semana5" maxlength="3"
											onchange="fn_CalcularDistribMes(this);"
											onkeypress="return fn_validaTecla('entero', this);"
											readonly="true" disabled="true"></s:textfield>%
									</s:else>
								</td>
							<td>
								<s:textfield cssStyle="width:30px;" disabled="true" readonly="true"
									maxlength="3" id="distribuidoMes"></s:textfield>%
								</td>
						</tr>
					</table>
					<br>
					<table class="dataTable" align="left">
						<tr>
							<td align="left" style="width: 120px"></td>
							<th align="left"><label>Personalizados Diarios</label></th>
							<th align="left"><label>No Personalizados Diarios</label></th>
						</tr>

						<tr>
							<th align="left"><label>Número Mínimo de Contactos
							Diarios</label></th>
							<td>
								<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
									<s:textfield name="basicaMeta.min_con_dia_perso"
													cssStyle="width:60px;" maxlength="4" cssClass="validate[min[1]]"
													id="min_con_dia_perso" onchange="fn_OnlyZero(this);"
													onkeypress="return fn_validaTecla('entero', this);"></s:textfield>
								</s:if>	
								<s:else>
									<s:textfield name="basicaMeta.min_con_dia_perso"
												cssStyle="width:60px;" maxlength="4" cssClass="validate[min[1]]"
												id="min_con_dia_perso" onchange="fn_OnlyZero(this);"
												onkeypress="return fn_validaTecla('entero', this);"
												readonly="true" disabled="true"></s:textfield>
								</s:else>
							</td>
							<td>
								<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
									<s:textfield name="basicaMeta.min_con_dia_no_perso"
													cssStyle="width:60px;" maxlength="4" cssClass="validate[min[1]]"
													id="min_con_dia_no_perso" onchange="fn_OnlyZero(this);"
													onkeypress="return fn_validaTecla('entero', this);"></s:textfield>
								</s:if>	
								<s:else>
									<s:textfield name="basicaMeta.min_con_dia_no_perso"
													cssStyle="width:60px;" maxlength="4" cssClass="validate[min[1]]"
													id="min_con_dia_no_perso" onchange="fn_OnlyZero(this);"
													onkeypress="return fn_validaTecla('entero', this);"
													disabled="true" readonly="true"></s:textfield>
								</s:else>
							</td>
						</tr>

						<tr style="display: none;">
							<th align="left"><label>Número Mínimo de Visitas
							Diarias</label></th>
							<td>
								<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
									<s:textfield name="basicaMeta.min_vis_dia_perso"
												cssStyle="width:60px;" maxlength="4" id="min_vis_dia_perso"
												onchange="fn_OnlyZero(this);"
												onkeypress="return fn_validaTecla('entero', this);"
												cssClass="validate[min[1]]"></s:textfield>
								</s:if>	
								<s:else>
									<s:textfield name="basicaMeta.min_vis_dia_perso"
												cssStyle="width:60px;" maxlength="4" id="min_vis_dia_perso"
												onchange="fn_OnlyZero(this);"
												onkeypress="return fn_validaTecla('entero', this);"
												cssClass="validate[min[1]]"
												readonly="true" disabled="true"></s:textfield>
								</s:else>
							</td>
							<td>
								<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
									<s:textfield name="basicaMeta.min_vis_dia_no_perso"
													cssStyle="width:60px;" maxlength="4" id="min_vis_dia_no_perso"
													onchange="fn_OnlyZero(this);"
													onkeypress="return fn_validaTecla('entero', this);"
													cssClass="validate[min[1]]"></s:textfield>
								</s:if>	
								<s:else>
									<s:textfield name="basicaMeta.min_vis_dia_no_perso"
													cssStyle="width:60px;" maxlength="4" id="min_vis_dia_no_perso"
													onchange="fn_OnlyZero(this);"
													onkeypress="return fn_validaTecla('entero', this);"
													cssClass="validate[min[1]]"
													disabled="true" readonly="true"></s:textfield>
								</s:else>															
							</td>
						</tr>
					</table>

					</td>
				</tr>
			</table>
			</div>
			</div>
			</td>
		</tr>
	</table>
	</div>
	</div>


	<div class="ui-widget ui-widget-content ui-corner-all" align="center"
		style="width: 99%; margin: 3px 3px 3px 3px;">
	<div style="margin: 3px 3px 3px 3px;">
	<s:if test="%{#session.__current_user__.codigoPerfil=='ADM'}">
		<sj:a button="true"
		onclick="executeActionForm_guardarConfigBasicaMeta()"
		buttonIcon="ui-icon-circle-check">
			Grabar
		</sj:a> <sj:a button="true"
		onclick="executeActionForm_eliminarConfigBasicaMeta()"
		buttonIcon="ui-icon-circle-close">
			Suprimir
		</sj:a> 
	</s:if>	

		<sj:a button="true" onclick="exportarExcelConfigBasicaMeta()"
		buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a> <sj:a button="true" onclick="print()" buttonIcon="ui-icon-print">
			Imprimir
		</sj:a></div>
	</div>
</s:form>

