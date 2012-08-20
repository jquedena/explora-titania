var myColumns;
var myData;
var myFooters1;
var myFooters2;
var myFooters3;

function creaGrilla(rows,cols,numFooters,estiloGrilla){
	
	var grid = new AW.Grid.Extended;
	
	grid.setId("myGrid");
	grid.setFixedLeft(2);
	grid.setSelectionMode("single-row");
	
	grid.setCellText(myData);
	grid.setHeaderText(myColumns);
	
	grid.setFooterVisible(true);
	grid.setFooterCount(numFooters);
	grid.setFooterText(myFooters1, 0);
	grid.setFooterText(myFooters2, 1);
	grid.setFooterText(myFooters3, 2);

	grid.setRowCount(rows);
	grid.setColumnCount(cols);
	
	var rowHeight = grid.getRowHeight();
	var maxVisibleRows = rows+numFooters;
	//if(maxVisibleRows>12) maxVisibleRows=12;
	estiloGrilla.height = ((rowHeight*(maxVisibleRows))+44) + 'px';
	estiloGrilla.width = "100%";
	
	grid.onHeaderClicked = function(event, index){return true;}; 
	grid.setVirtualMode(false);
	
	grid.refresh();
}