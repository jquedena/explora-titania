<%@taglib prefix="s" uri="/struts-tags"%>

	<tr>
			<td colspan="4" align="center">
				<table align="center" class="dataTable" width="250px;">
			    <tr class="even">
			                    <td bgcolor= "#00FF00" width="20px"></td>
							    <td>><s:label  id="rangoSuperior" name="rangosuperior"></s:label>%</td>
							
							    <td bgcolor= "#FFFF00" width="20px"> </td>
							    <td><s:label  id="rangoMedio2" name="rangomedio2"></s:label> - 
							         <s:label  id="rangoMedio" name="rangomedio1"></s:label>% 
							    </td>
							  
							    <td bgcolor= "#FF0000" width="20px"></td>
							    <td><<s:label  id="rangoInferior" name="rangoinferior"></s:label>% </td>
			                       
			    </tr>
			  </table>
			</td>
		</tr>