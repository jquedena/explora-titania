<%
 	HttpSession sesion=request.getSession(false);
 	// System.out.println("destruyendo sesion");
 	sesion.invalidate();
%>