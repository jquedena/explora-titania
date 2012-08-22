<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<link href="css/dtreemenu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/dtreemenu.js"></script>
<script type="text/javascript">
/* ================================================================ 
This copyright notice must be untouched at all times.
Copyright (c) 2008 Stu Nicholls - stunicholls.com - all rights reserved.
=================================================================== */
$(document).ready(function(){
	$("ul.subnav").parent().append("<span/>"); //Only shows drop down trigger when js is enabled - Adds empty span tag after ul.subnav
	// $("ul.topnav li span").click(function(){ //When trigger is clicked...
	$("ul.topnav li span, ul.topnav li a").mouseover(function(){ //When trigger is clicked...
		//Following events are applied to the subnav itself (moving subnav up and down)
		$(this).parent().find("ul.subnav").show(); //Drop down the subnav on click .slideDown("fast")
		$(this).parent().hover(function(){
		}, function(){
			$(this).parent().find("ul.subnav").hide(); //When the mouse hovers out of the subnav, move it back up .slideUp("slow")
		});
	
		//Following events are applied to the trigger (Hover events for the trigger)
	}).hover(function(){
		$(this).addClass("subhover"); //On hover over, add class "subhover"
	}, function(){ //On Hover Out
		$(this).removeClass("subhover"); //On hover out, remove class "subhover"
	});
	
	$('a.link').click(function(){
		_attr=$(this).attr('back_href');
		if(_attr != undefined){
			$("#_refresh").attr('href', _attr);
		} else {
			$("#_refresh").attr('href', 'actionBienvenida.do');
		}
	});
});

/*
$(document).ready(function(){
	closetimer = 0;
	if($("#nav")) {
		$("#nav b").mouseover(function() {
			clearTimeout(closetimer);
			if(this.className.indexOf("clicked") != -1) {
				$(this).parent().next().slideUp(100);
				$(this).removeClass("clicked");
			}
			else {
				$("#nav b").removeClass();
				$(this).addClass("clicked");
				$("#nav ul:visible").slideUp(100);
				$(this).parent().next().slideDown(250);
			}
			return false;
		});
		$("#nav").mouseover(function() {
			clearTimeout(closetimer);
		});
		$("#nav").mouseout(function() {
			closetimer = window.setTimeout(function(){
				$("#nav ul:visible").slideUp(500);
				$("#nav b").removeClass("clicked");
			}, 100);
		}); 
	}
});
*/
var accionCerrar = 0;
function cerrarSesion()
{
	accionCerrar = 1;
	window.close();         
}

function oculta (kpa) {
	document.getElementById(kpa).style.visibility="hidden";
}

function muestra (kpa) {
   document.getElementById(kpa).style.visibility="visible";
}

function cerrarSx() { 
	var form = document.getElementById("idForm");
	
	form.action = "logOffAction.do";
	form.method = "post";
	
	if(accionCerrar == 1) {
		accionCerrar = 0;
		form.submit();
	}
}

window.onunload = cerrarSx 
</script>

<div id="topLogueo">
<form id = "idForm"></form>
<table border=0 cellspacing=0 cellpadding=0 align="center" width="100%">
<tr>
	<td bgcolor="#000000" width="65" height="80"><img src="images/sdo_int.jpg"></td>
	<td bgcolor="#000000" align="center">
		<span style="font-size:16px;font-weight:bold;color:#ffffff">SDO<br/>Sistema de Direcci&oacute;n de Oficinas</span>
	</td>
	<td width="32" bgcolor="#000000"><img src="images/user.png"></td>
	<td width="63" bgcolor="#000000" style="font-weight: bold; text-align: center; color:#ffffff;">
		<c:if test ="${nombre!=null}">
			<p class="nameUser" style="padding-left: 7px;">Bienvenido</p>
			<p class="nameUser" style="padding-left: 7px;"></p>
		</c:if>
		<c:if test="${nombre==null}">
			<p style="padding-left: 7px;"></p>
		</c:if>
	</td>
	<td width="233" bgcolor="#000000" style="font-size: 10px; font-weight: bold; text-align: center; color:#ffffff;">
		Usuario conectado: <br/><b>${sessionScope.gestor.nombreGestor}</b>
		<br />
		<a href="javascript:cerrarSesion();"><img src="images/salir.jpg" border="0" alt="desconectar"></a>
	</td>
</tr>
<tr>
	<td colspan="5" height="30">
	<div id=content>
	<!-- nav -->
	<ul class="topnav">
		<c:forEach items="${listaAccesoMenu}" var="objBean" > 
			<c:if test="${objBean.hijo=='0'}">
				<li><!--  class='first' -->
					<a href="#"><b><c:out value="${objBean.descripcion}"/></b></a>
					<ul class='subnav'><!-- w<c:out value="${objBean.padre}"/> -->
					 <c:forEach items="${listaAccesoMenu}" var="obj" > 
						<c:if test="${objBean.padre==obj.hijo}">
							<li><a class="link" href="${obj.link}" back_href="${obj.link}" target="MAIN"><c:out value="${obj.descripcion}"/></a></li>
						</c:if> 
					</c:forEach>
					</ul>
				</li>
			</c:if> 
		</c:forEach>
		<li style="float:right;padding:0px;"><a style="padding:0px;padding-top:7px;" id="_refresh" href="actionBienvenida.do" target="MAIN">Actualizar <img style="padding-top:10px;border:0px;" src='images/actualizar.gif' /></a></li>
	</ul>
	</div>
	</td>
</tr>
</table>
</div>

