 <%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.numericupdown.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/app/configuracion/js/configSemaforo_Script.js"></script>
  
<script language="JavaScript">

	$(document).ready(function()
	{
    	$(".spinSemaforo").NumericUpDown();			  		  		 	    		
   	});
   		
</script>  

<s:form id="currentForm" theme="simple">
  					
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Configuración de Semáforo</label>
</div> 
<div align="center" style="margin: 5px 5px 5px 5px; ">
	<table width="300px;">
		         <tr>
					<td align="left">
						<label>Superior(Mayor igual a) :</label>
					</td>
					
					<td align="left">
						<s:hidden  id="hdrangosuperior" name="valor3" >
						
						</s:hidden>
                    	<s:textfield  id="rangoSuperior" name="valor3" disabled="true" style="width:30px;"   
                    				  cssClass="validate[required,custom[integer]]" 
                    				  maxlength="4">
						</s:textfield> 
                    	&nbsp;<label>%</label>
                    </td>
                    
					<td bgcolor= "#00FF00" width="75px" height="15px" style="border: 1px solid #2b91e6;">
						
					</td>

				</tr>
		        
		        <tr>
					<td align="left">
						<label>Medio(Entre) :</label>
					</td>
					
					<td align="left">
						<s:textfield id="rangoMedio" name="valor2" cssClass="spinSemaforo" onblur="calcularSuperior()"  
									 style="width:30px;" maxlength="4">
						</s:textfield > 
						&nbsp;<label>%</label>
					</td>
					                     
					<td bgcolor= "#FFFF00" width="75px" height="15px" style="border: 1px solid #2b91e6;">
						
					</td>
				</tr>
				
				<tr>
					<td align="left">
						<label>Inferior(Menor igual a) :</label>
					</td>
					
					<td align="left">
			        <s:textfield  type="text" id="rangoInferior" name="valor1" cssClass="spinSemaforo"  style="width:30px;"
			        				maxlength="4">
					</s:textfield> 
					&nbsp;<label>%</label>
                    </td>
                    
					<td bgcolor= "#FF0000" width="75px" height="15px" style="border: 1px solid #2b91e6;">
						
					</td>
				</tr>
	     </table>
</div>	
</div> 

<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">    
	<div style="margin: 3px 3px 3px 3px;">				
		<sj:a button="true"  onclick="executeActionForm_guardarSemaforo()" buttonIcon="ui-icon-circle-check">
			Grabar
		</sj:a>
		<sj:a button="true" onclick="exportarExcelSemaforo()" buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a>
		<sj:a button="true" onclick="print()"  buttonIcon="ui-icon-print">
			Imprimir
		</sj:a>
	</div>													
</div>
</s:form>

