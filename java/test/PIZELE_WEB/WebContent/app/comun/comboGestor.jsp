<%@taglib prefix="s" uri="/struts-tags"%>

	<td>
		<label>Gestor :</label>
	</td>
	<td>	
		 	<s:select 
					 headerKey="-1"
					 headerValue="----- Seleccione ------"
					 list="listaGestores"
					 listKey="codusu"
					 listValue="nombreCompleto"
					 cssStyle="width: 300px;"
					 id="idGestor"
					 cssClass="validate[required3]"
					 onchange="seleccionaGestor()">
			</s:select> 	
	</td>