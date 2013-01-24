<%@page import="org.apache.log4j.Logger"%>
<%@ page isErrorPage="true" %>
<%@ page import="java.io.*" %>
<%@ page import="pe.com.titania.jasper.Constante"%>
<html>
<head>
<title><%=Constante.TITLE %></title>
<style>
	* {
	    font-size: 100%;
	    font-family: Tahoma, Lucida Grande, Lucida Sans, Arial, sans-serif;
	    letter-spacing: .03em;
	}
	
	body {
	    font-size: 0.7em;
	}
</style>
</head>
<body>
<b>Se encontro el siguiente error:</b>
<pre>
<%
	Logger logger = Logger.getLogger(this.getClass());
	exception.printStackTrace(new PrintWriter(out));
	logger.error("Página Error:", exception);
%>
</pre>
</body>
</html>
