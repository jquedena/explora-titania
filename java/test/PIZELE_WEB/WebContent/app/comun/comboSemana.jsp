<%@taglib prefix="s" uri="/struts-tags"%>

	<td>
		<label>Semana :</label>
	</td>
	<td>	
		<select style="width: 120px;" 
				id="idSemana"
				disabled="disabled"
				onchange="seleccionaSemana()">
			<option value="-1">----- Todas ------</option>
		</select>	
		<s:hidden name="semana" id="semana"></s:hidden>
	</td>