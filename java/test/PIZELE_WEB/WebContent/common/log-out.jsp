<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
    
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/app.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/theme/bbva/jquery-ui.css"/>
	
			
        <title>Pizarra Electrónica</title>
       	
       	<script>
			function noBack()
			{
				window.history.forward(1);
			}
		</script>
	        
    </head>
    <body onload="window.close();" onunload="noBack();">
        


       	<div id="toppanel">				
			<div class="content clearfix ui-widget ui-widget-content ui-corner-all" style="width: 800px;background-color: white;">
		
        <table border="0" cellpadding="0" cellspacing="0" align="center" width="800px">
            <tr>
                <td colspan="2" width="100%">
                    <div>
						<br>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr height="45px">
								<td width="4px">
								</td>
								<td width="160px">
									<img src="<%=request.getContextPath()%>/images/logo/logo_promo.png"/>
								</td>
								<td align="right" class="titulo">
									Pizarra Electrónica
								</td>
							</tr>
						</table>
					</div>
                </td>
            </tr>
            <tr>
            	<td>
            		<br>
            	</td>
            </tr>
            <tr>
                <td width="100%" valign="top" colspan="2" align="center" height="400px">                	
                	<label style="font-size:24px;color: #00a4e2;position: static;">
							<br>"Su sesión ha finalizado."<br>
					</label>                		
                </td>
            </tr>            
            <tr>
            	<td>
            		<br>
            	</td>
            </tr>
            <tr>
                <td width="100%">
                    <div class="fondo_div_footer">
						&copy; BBVA Continental Copyright - Todos los Derechos Reservados.
					</div>
                </td>
            </tr>
            <tr>
            	<td>
            		<br>
            	</td>
            </tr>
        </table>
 			</div> 
		</div> 
     
                      
    </body>
    
		
</html>

