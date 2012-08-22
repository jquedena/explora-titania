<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:form id="panelForm" theme="simple">
	<table width="100%" cellpadding="0" cellspacing="0">
		<s:if test="%{#session.__current_user__.esBackupSuplente}">
			<tr>
				<td align="center">
					<b>USTED ACTUA COMO BACKUP DE : </b>
					&nbsp;<s:property value="#session.__current_user__.nombreCompletoGOF"/>
					- GOF - <s:property value="#session.__current_user__.codigoOficina"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<b><label style="color: red;">IMPORTANTE : </label></b>
					&nbsp;
					<b><label style="color: blue;">Recuerde que está ingresando al Módulo de Pizarra como Backup de su GOF. </label></b>
				</td>
			</tr>
		</s:if>	
		<tr>
			<td align="center">
				<hr style="width: 98%;">
			</td>
		</tr>
		<tr>
			<td align="center">
				<img src="<%=request.getContextPath()%>/images/logo/logo02.jpg"  border="0"/>
			</td>
		</tr>
	</table>
	
</s:form>

