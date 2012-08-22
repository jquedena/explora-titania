<%@taglib prefix="s" uri="/struts-tags"%>

	<td>
		<label>Mes :</label>
	</td>
	<td>	
		<s:select 
					 headerKey="-1"
					 headerValue="----- Todas ------"
					 list="listaMeses"
					 listKey="id"
					 listValue="nombre"
					 cssStyle="width: 120px;"
					 id="idMes"
					 onchange="seleccionaMes()"
					 disabled="true"
					 name="mes"
					 cssClass="validate[required3]">					 
			</s:select> 	
	</td>