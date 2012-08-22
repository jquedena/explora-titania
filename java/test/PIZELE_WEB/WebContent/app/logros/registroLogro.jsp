<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/app/logros/js/registroLogro_Script.js"></script>
<script type="text/javascript">
	var permiso = '<s:property value="permiso"/>';
	$(document).ready(function(){
		inicializarEstadoAnioMes();
		seleccioneChangeTextAnio();
		seleccioneChangeTextMes();
		seleccioneChangeTextTerritorio();
		seleccioneChangeTextOficina();
		
		$("#bodyRubro2").scroll(function () {
			$("#headRubro2").scrollLeft($(this).scrollLeft());
			$("#bodyRubro1").scrollTop($(this).scrollTop());
		});
		
		if($("#idOficinaFiltro").val()!='-1') {
			cargarLogros();
		}
		
		if(permiso=='0'){
			$("#cmdGrabar").css({"display":"none"});
		}
	});
	
	$.subscribe('onDPClose', function(event,data) {
		if($('#idTerritorioFiltro').val()=="-1") {
			openDialogInfo("Seleccione un territorio.");
		} else {
			if($('#idOficinaFiltro').val()=="-1"){
				openDialogInfo("Seleccione la oficina.");
			} else {
				cargarLogros();
			}
		}
	});
</script>

<style>
	#headRubro2 a,
	#headRubro2 a:active,
	#headRubro2 a:hover,
	#headRubro2 a:link,
	#headRubro2 a:visited {
		text-decoration:none;
		font-weight: normal;
		cursor: pointer;
		color: #fff;
	}
	.ui-widget-top { border-top: 1px solid #ccc; } /* 2b91e6 */
	.ui-widget-bottom { border-bottom: 1px solid #ccc; }
	.ui-widget-left { border-left: 1px solid #ccc; }
	.ui-widget-right { border-right: 1px solid #ccc; }
</style>

<s:form id="currentForm" theme="simple">
<s:hidden id="xlsHead" name="xlsHead" value="" />
<s:hidden id="xlsBody" name="xlsBody" value="" />
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px;">   
	<div class="fondo_div_principal">
		<label>Registro de Logros</label>
	</div> 
	<div align="left" style="margin: 5px;">
		<table width="100%">
			<s:include value="../comun/filtroTerritorioOficina.jsp"></s:include>
		</table>
		
		<table width="100%">
		<tr>
			<td style="width: 55px;">
				<label>Ver el d&iacute;a :</label>
			</td>
			<td>
				<sj:datepicker id="idDia" 
					displayFormat="dd/mm/yy"
					buttonImageOnly="true"
					readonly="true"
					cssClass="validate[required]"
					value="%{dia}"
					onchange="validarFecha()"
					cssStyle="width: 85px;"
					onCompleteTopics="onDPClose">
				</sj:datepicker>
			</td>
			<td align="right">
				&nbsp;
			</td>
		</tr>
		</table>
	</div>
</div>

<div class="ui-widget ui-widget-content ui-corner-all" style="width: 790px; margin: 3px;">
	<div class="fondo_div_principal">
		<label>Registro de Logros Diarios</label>
	</div>
	<div id="divRubroLogro" style="display: none; overflow: auto; width: 792px;">
		<table align="center" style="width:790px; height: 240px; padding: 1px; margin: 1px;" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td style="height:25px; text-align: left; width:405px;" class="ui-widget-top ui-widget-left">
					<div id="headRubro1">&nbsp;</div>
				</td>
				<td style="height: 25px; text-align: left; width: 385px;" class="ui-widget-top ui-widget-left ui-widget-right">
					<div id="headRubro2" style="overflow: hidden;width:370px;">&nbsp;</div>
				</td>
			</tr>
			<tr>
				<td style="vertical-align: top; text-align: left; height: 215px; width: 405px;" class="ui-widget-left ui-widget-bottom">
					<div id="bodyRubro1" style="height: 200px;">&nbsp;</div>
				</td>
				<td style="vertical-align: top; text-align: left; height: 215px; width: 385px;" class="ui-widget-bottom ui-widget-left ui-widget-right">
					<div id="bodyRubro2" style="height: 215px; width: 385px; overflow: scroll;">&nbsp;</div>
				</td>
			</tr>
		</table>
	</div>
</div>

<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px;">
	<div style="margin: 3px;">
		<sj:a button="true" onclick="executeActionForm_guardarDecisor()" buttonIcon="ui-icon-circle-check" id="cmdGrabar">
			Grabar
		</sj:a>
		<sj:a button="true" onclick="exportarExcelRubroLogro()" buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a>
		<sj:a button="true" onclick="print()" buttonIcon="ui-icon-print">
			Imprimir
		</sj:a>
	</div>
</div>
</s:form>