<%@taglib prefix="s" uri="/struts-tags"%>

<tr>
	<td>
		<label>Territorio :</label>
	</td>
	<td>
		<s:if test="%{#session.__current_user__.territorio==null}">
			<s:select 
					 headerKey="-1"
					 headerValue="----- Todas ------"
					 list="listaTerritorios"
					 listKey="codigo"
					 listValue="descripcion"
					 cssStyle="width: 300px;"
					 id="idTerritorioFiltro"
					 onchange="filtrarOficinas()"
					 cssClass="validate[required3] ui-print-notext">
			</s:select> 
		</s:if>			
		<s:else>
			<s:textfield id="descTerritorioFiltro"  name="#session.__current_user__.territorio.descripcion" cssStyle="width:300px;" cssClass="ui-print-notext" disabled="true" />
			<s:hidden id="idTerritorioFiltro" name="#session.__current_user__.territorio.codigo"></s:hidden>			
		</s:else>	
	</td>
	<td>
		<label>Oficina :</label>
	</td>
	<td>
		<s:if test="%{#session.__current_user__.oficina!=null}">
			<s:textfield id="descOficinaFiltro" name="#session.__current_user__.oficina.descripcion" cssStyle="width:300px;" cssClass="ui-print-notext" disabled="true" />
			<s:hidden id="idOficinaFiltro" name="#session.__current_user__.oficina.codigo"></s:hidden>
		</s:if>	
		<s:else>
			<s:select 
					 headerKey="-1"
					 headerValue="----- Todas ------"
					 id="idOficinaFiltro"
					 list="listaOficinas"
					 listKey="codigo"
					 listValue="descripcion"
					 cssStyle="width: 300px;"
					 onchange="seleccionaOficinas()"
					 cssClass="validate[required3] ui-print-notext">
			</s:select> 
		</s:else>
	</td>
</tr>

