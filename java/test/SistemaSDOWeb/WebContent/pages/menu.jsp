<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!--top part start -->
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/dtree.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/dtree.js"></script>
<table class="BordaBranca" cellspacing=0 cellpadding=0 border=0>
	<tbody>
		<tr>
			<td style="WIDTH: 157px" align=left
				background="<%=request.getContextPath()%>/images/fondoTop.png"><script
				type="text/javascript">
function getUrlInicioPopup(url)
{
 window.open('<%=request.getContextPath()%>/'+url,"ventana","width=800px,height=600px,top=165,left=260,menubar=no,scrollbars=no,toolbar=no,resizable=no,status=no,location=no");
}
function getUrlInicio(url)
{
	// alert(url);
	window.open('<%=request.getContextPath()%>/'+url,"ventana","width=800px,height=600px,top=165,left=260,menubar=no,scrollbars=no,toolbar=no,resizable=no,status=no,location=no");
}
   
	o = new dTree('o'); 
	o.config.folderLinks=false;
    <c:forEach items="${listaAccesoMenu}" var="objBean" >
    <c:if test="${objBean.descripcion=='Masiva'}">
       	o.add(<c:out value="${objBean.padre}"/>,<c:out value="${objBean.hijo}"/>,'<c:out value="${objBean.descripcion}"/>',"javascript:getUrlInicioPopup('<c:out value="${objBean.link}"/>');",'<c:out value="${objBean.descripcion}"/>');
    </c:if>
    <c:if test="${objBean.descripcion!='Masiva'}">
    	o.add(<c:out value="${objBean.padre}"/>,<c:out value="${objBean.hijo}"/>,'<c:out value="${objBean.descripcion}"/>','<c:out value="${objBean.link}"/>','<c:out value="${objBean.descripcion}"/>','MAIN');	   	
    </c:if>	
    </c:forEach>
    document.write(o);
</script></td>
		</tr>
	</tbody>
</table>

<!--top part end -->
