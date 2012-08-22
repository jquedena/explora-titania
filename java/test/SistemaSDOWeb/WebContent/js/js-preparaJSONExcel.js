function cutHex(h) {return (h.charAt(0)=="#") ? h.substring(1,7):h;}
function HexToR(h) {return parseInt((cutHex(h)).substring(0,2),16);}
function HexToG(h) {return parseInt((cutHex(h)).substring(2,4),16);}
function HexToB(h) {return parseInt((cutHex(h)).substring(4,6),16);}

function prepareColor(rgb) {
	auxi = Array();
	
	rgb = (rgb.toLowerCase() == "#fff" || rgb.toLowerCase() == "white") ? "#ffffff" : rgb;
	rgb = (rgb == "#000" || rgb.toLowerCase() == "black") ? "#000000" : rgb;
	
	if(rgb.indexOf("#")>=0) {
		auxi[0] = HexToR(rgb) == NaN ? 255 : HexToR(rgb);
		auxi[1] = HexToG(rgb) == NaN ? 0 : HexToG(rgb);
		auxi[2] = HexToB(rgb) == NaN ? 0 : HexToB(rgb);
	} else {
		_color = rgb.replace("rgb(", "");
		_color = _color.replace(")", "");
		_color = _color.replace(" ", "");
		temp = _color.split(',');
		for(i=0; i<temp.length; i++) {
			auxi[i] = parseInt(temp[i]);
		}
	}
	
	_color = auxi.join(",");
	return _color;
}

function prepareJSON(className, label, format) {
	var jsonTable = "[";
	var i = 0;
	var j = 0;
	var row = null;
	
	$(className).each(function(){
		j = 0;
		$(this).find(label).each(function(){
			content = $(this).html().replace("<br/>", ' ');
			content = content.replace("<br>", ' ')
			content = content.replace("<BR>", ' ')
			content = content.replace("<BR/>", ' ')
			content = content.replace("'", '')
			content = content.replace("&nbsp;", ' ');
			
			rowspan = ($(this).attr('rowspan') == undefined || $(this).attr('rowspan') == '1') ? 0 : $(this).attr('rowspan');
			colspan = ($(this).attr('colspan') == undefined || $(this).attr('colspan') == '1') ? 0 : $(this).attr('colspan');
			
			fontWeight = $(this).css("fontWeight");
			color = prepareColor($(this).css("color"));
			backgroundColor = prepareColor($(this).css("backgroundColor"));
			dataType = $(this).attr("type");
			pattern = $(this).attr("pattern");
			
			// console.log($(this).css("color"));
			// console.log($(this).css("backgroundColor"));
			
			if(content.toUpperCase().indexOf('<INPUT')>=0) {
				caption = $(content).val();
			} else if(content.toUpperCase().indexOf('<SPAN')>=0) {
				caption = $(content).text();
			} else if(content.toUpperCase().indexOf('<B')>=0) {
				caption = $(content).text();
				fontWeight = "bold";
			} else {
				caption = $(this).text(); // content.replace("<BR>", ' ').replace("<BR/>", ' ');
			}
			
			test = new Boolean(caption);
			if(!test) {
				// console.log('Valor Nulo ... '+caption);
				caption = "";
			}
			
			jsonRow  = "{row:" + i;
			jsonRow += ",col:" + j;
			jsonRow += ",caption:'" + $.trim(caption) + "'";
			jsonRow += ",rowspan:" + rowspan;
			jsonRow += ",colspan:" + colspan;
			jsonRow += ",fontWeight:'" + fontWeight + "'";
			jsonRow += ",color:'" + color + "'";
			jsonRow += ",backgroundColor:'" + backgroundColor + "'";
			jsonRow += ",type:'" + dataType + "'";
			jsonRow += ",pattern:'" + pattern + "'}";
			// console.log(jsonRow);
			jsonTable += jsonRow + ",";
			j++;
		});
		
		i++;
	});
	
	if(jsonTable.length == 1) {
		return "";
	}
	
	jsonTable = jsonTable.substr(0, jsonTable.length - 1) + "]";
	// alert(jsonTable);
	return jsonTable;
}	

function prepareJSONTable() {
	$("#header").val(prepareJSON(".DataGrid .Header", "th"));
	$("#rows").val(prepareJSON(".DataGrid .Row", "td"));
	$("#footer").val(prepareJSON(".DataGrid .Footer", "td"));
}