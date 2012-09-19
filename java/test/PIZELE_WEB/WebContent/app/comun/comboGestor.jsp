<%@taglib prefix="s" uri="/struts-tags"%>

	<td>
		<label>Gestor :</label>
	</td>
	<td>	
		<!-- codusu -->
	 	<s:select 
				 headerKey="-1"
				 headerValue="----- Seleccione ------"
				 list="listaGestores"
				 listKey="codigoRegistro"
				 listValue="nombreCompleto"
				 cssStyle="width: 300px;"
				 id="idGestor"
				 cssClass="validate[required3]"
				 onchange="seleccionaGestor()">
		</s:select> 	
	</td>