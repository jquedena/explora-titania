<%@taglib prefix="s" uri="/struts-tags"%>

	<td>
		<label>A�o :</label>
	</td>
	<td>	
		 	<s:select 
					 headerKey="-1"
					 headerValue="----- Todas ------"
					 list="listaAnios"
					 listKey="codigo"
					 listValue="descripcion"
					 cssStyle="width: 120px;"
					 id="idAnio"
					 onchange="seleccionaAnio()"
					 cssClass="validate[required3]"
					 name="anio">
			</s:select> 	
	</td>
	