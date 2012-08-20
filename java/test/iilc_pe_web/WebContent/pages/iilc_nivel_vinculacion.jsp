<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css'
	type="text/css">
<title>Carpetas Comerciales</title>

</head>
<body>
<p align="center" class="TituloPagServGen">NIVELES DE VINCULACI&Oacute;N</p>
<center>
  <table cellspacing="0" cellpadding="0" border="1">
    <tr height="20">
      <td colspan="2" height="20" width="294" align="center" class="FondoAzulPeq">FAMILIAS DE PRODUCTOS</td>
    </tr>
    <tr height="20" class="FondoGris1">
      <td height="20">Familia 1:</td>
      <td>ahor, ahod, ccte, cvip</td>
    </tr>
    <tr height="20" class="FondoGris2">
      <td height="20">Familia 2:</td>
      <td>ctsd, fmut. plazo, sdep</td>
    </tr>
    <tr height="20" class="FondoGris1">
      <td height="20">Familia 3:</td>
      <td>ph, pserv,sonc,spro,svip,b24</td>
    </tr>
    <tr height="20" class="FondoGris2">
      <td height="20">Familia 4:</td>
      <td>phip, mcla, moro, vcla, voro, vpla</td>
    </tr>
  </table>
  <p>&nbsp;  </p>
  <table cellspacing="0" cellpadding="0" border="1">
    <tr height="20">
      <td colspan="2" height="20" width="450" align="center" class="FondoAzulPeq">SI EL CLIENTE TIENE CONTRATOS</td>
    </tr>
    <tr height="20" class="FondoGris1">
      <td height="20">En ninguna Línea Com.</td>
      <td><div align="center">Desvinculado</div></td>
    </tr>
    <tr height="20" class="FondoGris2">
      <td height="20">En m&aacute;s de 1 L&iacute;nea Com., fam 1 &oacute; 2</td>
      <td><div align="center">Poco Vinculado</div></td>
    </tr>
    <tr height="40" class="FondoGris1">
      <td height="40" width="286">En m&aacute;s de 2 L&iacute;neas Com. y menos de 6 L&iacute;neas Com., fam 1,2,3 &oacute; 1,2,3 y 4</td>
      <td><div align="center">Vinculado</div></td>
    </tr>
    <tr height="20" class="FondoGris2">
      <td height="20">En m&aacute;s de 5 L&iacute;neas Com., fam 1,2,3 &oacute; 1,2,3 y 4</td>
      <td><div align="center">Muy Vinculado</div></td>
    </tr>
  </table>
</center>
</body>
</html:html>
