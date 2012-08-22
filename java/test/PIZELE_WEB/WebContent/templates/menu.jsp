<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<s:set name="opciones_html" value="#session.__current_user__.listaOpciones_html"/>
<s:set name="opciones_js" value="#session.__current_user__.listaOpciones_js"/>

<s:iterator  value="opciones_js" var="opc_js">
	<s:property escapeHtml="#opc_js"/>			
</s:iterator>  
	
<div id="divHeaderMenu" class="ui-widget-header" align="left" style="width: 100%;border: 0px;">	
<table>
	<tr>
		<s:iterator  value="opciones_html" var="opc_html">
			<td>
				<s:property escapeHtml="#opc_html"/>
			</td>
		</s:iterator>
	</tr>
</table>
</div>      
      

		
		
		
			

    

		  