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

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" />

<TITLE></TITLE>

</HEAD>
<STYLE type=text/css>
  #mensaje {
	BORDER-RIGHT: #d7e8f0 2px solid; PADDING-RIGHT: 5px; BORDER-TOP: #d7e8f0 2px solid; PADDING-LEFT: 5px; FONT-SIZE: 11px; BACKGROUND: #f5f8fa; 
	PADDING-BOTTOM: 5px; BORDER-LEFT: #d7e8f0 2px solid; COLOR: #000; LINE-HEIGHT: 14px; 
	PADDING-TOP: 5px; BORDER-BOTTOM: #d7e8f0 2px solid; FONT-FAMILY: Verdana,Arial,sans-serif;
}
.Estilo29 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold;}
</STYLE>


<BODY style="margin:0px 0px 0px 0px;">
<center>
   <!-- style="width: 100%;padding-top: 100px;" -->
    	
        <div id="body" style="margin-top: 200px; width: 425px;">
        	<div>
        	<table>
        	<tr>
        		<td>        			
        		</td>
        		<td class='Estilo29'><%=request.getAttribute("mensajeSesionTermino") %></td>
        	</tr>
        	</table></div>
		</div>    
</center>

</BODY>
</html:html>
