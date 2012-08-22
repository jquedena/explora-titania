<!--  Marca de Orlando PM -->
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<link href="css/dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript"  src="<%=request.getContextPath()%>/script/dtree.js"></script>
<body background="../images/fondomenu1x.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" rightmargin="0" bottommargin="0">
<table width="100%" border="0" height="100%"    cellpadding="0" cellspacing="0" valing="top">  
 <tr>
  <td width="100%" height="100%" valign="top" bgcolor="#FBFBFB">
<script type="text/javascript">
    <!--
    function getUrlInicioPopup(url)
		{		
		 window.open(url,"ventana","width=550px,height=250px,top=165,left=260,menubar=no,scrollbars=no,toolbar=no,resizable=no,status=no,location=no");
		}    
    
	o = new dTree('o'); 
	o.config.folderLinks=false;		
    <c:forEach items="${listaAccesoMenu}" var="objBean" > 
       o.add(<c:out value="${objBean.padre}"/>,<c:out value="${objBean.hijo}"/>,'<c:out value="${objBean.descripcion}"/>',"${objBean.link}",'<c:out value="${objBean.descripcion}"/>','MAIN');	
    </c:forEach>		
    document.write(o);
	//-->
</script>
<script>
function regresar() {
	window.open('logueo.jsp', _self);
}
</script>
</td>
 </tr>
</table>

