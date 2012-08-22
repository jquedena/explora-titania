<html>
<head>
<script language="JavaScript">
function ExporttoExcel()
{
   var sOption="toolbar=yes,location=no,directories=yes,menubar=yes,";
       sOption+="scrollbars=yes,width=750,height=600,left=100,top=25";

   var sWinHTML = document.getElementById('contentstart').innerHTML;

   var winprint=window.open("","",sOption);
       winprint.document.open();
       winprint.document.write('<html>');
       winprint.document.write('<head>');

       winprint.document.write('function Prueba(){');
       winprint.document.write('}');
       
       winprint.document.write('<%@page contentType="application/vnd.ms-excel"%>')
       winprint.document.write('<meta http-equiv="Content-Type" content="application/vnd.ms-excel">')
         winprint.document.write('<meta http-equiv="Content-disposition": attachment; filename="file.xls">')
         winprint.document.write('</head><body>')

       winprint.document.write(sWinHTML);
       winprint.document.write('HOOOLLAA');
       winprint.document.write('</body>');
       winprint.document.write('');
       winprint.document.write('</html>');
       winprint.document.close();
       winprint.focus();
}

</script>
</head>

<body>
<a href="javascript:ExporttoExcel();">Export to Excel</a>

<div id="contentstart">
	<table>
		<tr><td>testing</td></tr>
	</table>
</div>
</body>
</html>
