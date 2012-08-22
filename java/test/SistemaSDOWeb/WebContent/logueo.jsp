<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>:: Sistema de Dirección de Oficinas</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script language="JavaScript" type="text/javascript">
	function setFocus(){
            document.forms[0].usuario.focus();
    }
	function loginsubmit(){
		if (document.forms[0].usuario.value==''){
			alert("Ingrese código de usuario");
			document.forms[0].usuario.focus();
		}else{
			document.forms[0].submit();
	        document.forms[0].btnLogueo.disabled=true;
		}
	}
</script>
</head>

<body>
<jsp:include page="/base/mensajes.jsp" flush="true" />	


<form action="<%=request.getContextPath()%>/accesoAction.do" enctype="multipart/form-data"
	method="post">
	
	<table align="center" width="800" cellspacing="0" cellpadding="0">
		<tr>
			<td>
					<img src="<%=request.getContextPath()%>/images/sdo.jpg">
			</td>
		</tr>
		<tr>
			<td style="padding:30px;" align="left">
				<table cellspacing="2" cellpadding="2">
					<tr>
						<td style="padding-top:5px;" class="titulocablateral"><b>Usuario:</b></td>
						<td style="padding-top:5px;"><input type="text" name="usuario"
			 size="20" maxlength="12" autocomplete="OFF" class="cajatexto" value="P014381" id="input_idusuario" onkeyup="mensaje_error();"></td>						
					</tr>
					<tr>
						<td style="padding-top:5px;" class="titulocablateral"><b>Password:</b></td>
						<td style="padding-top:5px;"><input type="password" name="password"
			 size="20" maxlength="12" id="input_password" class="cajatexto" onkeyup="mensaje_error();"></td>						
					</tr>				
					<tr>			
						<td style="padding-top:10px;" colspan="2" align="center">
						<input type="button" name="btnLogueo" id="button"
							class="botonnew" value="Ingresar" onClick="javascript:loginsubmit()" />			
						</td>
						<td width="271" class="mensaje">&nbsp;</td>
					</tr>
				</table>
				
			</td>
		</tr>


	</table>
 

</form>

<table align="center" width="800" cellspacing="0" background-color="#f3f9fa"; cellpadding="0">
	<tr>
		<td bgcolor=#264971 align="center" style="padding-top:5px;padding-bottom:5px;"><font color=#ffffff>&copy; Copyright 2008 - BBVA Banco Continental</font></td>
	</tr>
</table>
</body>
</html>