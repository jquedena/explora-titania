
<div id="divError"  >
    <div style="position: fixed;" ></div>
	<div id="div_txtError" style="display: none; z-index: 10000;">
		<table id="tabla_txtError" cellpadding="0" cellspacing="0" width="60%" align="center" >
			<tr>
				<td width="4" height="4" id="td_txtError11"
					style="background-position: left top;">
				</td>
				<td height="4" id="td_txtError12">
				</td>
				<td width="4" align="left" id="td_txtError13"
					style="background-position: right top;">
				</td>
			</tr>
			<tr>
				<td id="td_txtError21" width="4">
				</td>
				<td id="td_txtError22" align="center">
					<div id="txtError">
					</div>
				</td>
				<td id="td_txtError23" width="4">
				</td>
			</tr>
			<tr>
				<td height="4" id="td_txtError31"
					style="background-position: left bottom;">
				</td>
				<td id="td_txtError32"></td>
				<td id="td_txtError33" style="background-position: right bottom;">
				</td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
	mensaje_error('${txtError}', '1');
</script>