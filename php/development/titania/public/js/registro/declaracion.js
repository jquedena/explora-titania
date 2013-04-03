/**
 * 
 */
$(function(){

			var lastSel, mydata = [
			{id:"1", name:"test", note:"0000000001" }

			],
			grid = $("#list"),
			
			//Agregar
			onclickSubmitLocal = function(options,postdata) {
			
			var grid_p = grid[0].p, idname = grid_p.prmNames.id, grid_id = grid[0].id,	id_in_postdata = grid_id+"_id", rowid = postdata[id_in_postdata],
						 addMode = rowid === "_empty",	oldValueOfSortColumn;
			// postdata has row id property with another name. we fix it:
			if (addMode) {
				// generate new id
				var new_id = grid_p.records + 1;
				while ($("#"+new_id).length !== 0) {
				new_id++;
				}
				postdata[idname] = String(new_id);
			} else if (typeof(postdata[idname]) === "undefined") {
					// set id property only if the property not exist
					postdata[idname] = rowid;
			}
			delete postdata[id_in_postdata];
			// prepare postdata for tree grid
			if(grid_p.treeGrid === true) {
				if(addMode) {
					var tr_par_id = grid_p.treeGridModel === 'adjacency' ? grid_p.treeReader.parent_id_field : 'parent_id';
					postdata[tr_par_id] = grid_p.selrow;
			}
			$.each(grid_p.treeReader, function (i){
				if(postdata.hasOwnProperty(this)) {
					delete postdata[this];
				}
			});
			}
			// decode data if there encoded with autoencode
			if(grid_p.autoencode) {
				$.each(postdata,function(n,v){
					postdata[n] = $.jgrid.htmlDecode(v); // TODO: some columns could be skipped
				});
			}
				// save old value from the sorted column
				oldValueOfSortColumn = grid_p.sortname === "" ? undefined: grid.jqGrid('getCell',rowid,grid_p.sortname);
				// save the data in the grid
			if (grid_p.treeGrid === true) {
				if (addMode) {
					grid.jqGrid("addChildNode",rowid,grid_p.selrow,postdata);
			} else {
				grid.jqGrid("setTreeRow",rowid,postdata);
			}
			} else {
				if (addMode) {
					grid.jqGrid("addRowData",rowid,postdata,options.addedrow);
				} else {
					grid.jqGrid("setRowData",rowid,postdata);
				}
			}
			
			if ((addMode && options.closeAfterAdd) || (!addMode && options.closeAfterEdit)) {
				// close the edit/add dialog
				$.jgrid.hideModal("#editmod"+grid_id,
				{gb:"#gbox_"+grid_id,jqm:options.jqModal,onClose:options.onClose});
			}
			if (postdata[grid_p.sortname] !== oldValueOfSortColumn) {
				// if the data are changed in the column by which are currently sorted
				// we need resort the grid
				setTimeout(function() {
				grid.trigger("reloadGrid", [{current:true}]);
				},100);
			}
			// !!! the most important step: skip ajax request to the server
			this.processing = true;
			return {};
			},
			//Editar 
			editSettings = {
				//recreateForm:true,
				jqModal:false,
				reloadAfterSubmit:false,
				closeOnEscape:true,
				savekey: [true,13],
				closeAfterEdit:true,
				onclickSubmit:onclickSubmitLocal
				},
			addSettings = {
			//recreateForm:true,
			jqModal:false,
			reloadAfterSubmit:false,
			savekey: [true,13],
			closeOnEscape:true,
			closeAfterAdd:true,
			onclickSubmit:onclickSubmitLocal
			},
			delSettings = {
				// because I use "local" data I don't want to send the changes to the server
				// so I use "processing:true" setting and delete the row manually in onclickSubmit
				onclickSubmit: function(options, rowid) {
					var grid_id = $.jgrid.jqID(grid[0].id),
					grid_p = grid[0].p,
					newPage = grid[0].p.page;
					// delete the row
					grid.delRowData(rowid);
					$.jgrid.hideModal("#delmod"+grid_id,
					{gb:"#gbox_"+grid_id,jqm:options.jqModal,onClose:options.onClose});
					if (grid_p.lastpage > 1) {// on the multipage grid reload the grid
						if (grid_p.reccount === 0 && newPage === grid_p.lastpage) {
							// if after deliting there are no rows on the current page
							// which is the last page of the grid
							newPage--; // go to the previous page
						}
					// reload grid to make the row from the next page visable.
					grid.trigger("reloadGrid", [{page:newPage}]);
					}
					return true;
				},
				processing:true
			},
			initDateEdit = function(elem) {
				setTimeout(function() {
				$(elem).datepicker({
				dateFormat: 'dd-M-yy',
				autoSize: true,
				showOn: 'button', // it dosn't work in searching dialog
				changeYear: true,
				changeMonth: true,
				showButtonPanel: true,
				showWeek: true
				});
				//$(elem).focus();
				},100);
			},
			initDateSearch = function(elem) {
				setTimeout(function() {
				$(elem).datepicker({
				dateFormat: 'dd-M-yy',
				autoSize: true,
				//showOn: 'button', // it dosn't work in searching dialog
				changeYear: true,
				changeMonth: true,
				showButtonPanel: true,
				showWeek: true
				});
				//$(elem).focus();
				},100);
			};
			
			grid.jqGrid({
				datatype:'local',
				data: mydata,
				colNames:['Inv No','Direccion'],
				colModel:[
				{name:'id',index:'id',width:70,align:'center',sorttype: 'int',searchoptions:{sopt:['eq','ne']},hidden:true},	
				{name:'note',index:'note',width:500,sortable:false,editable:true,edittype:'textarea'}
				],
				rowNum:10,
				//rowList:[5,10,20],
				pager: '#pager',
				gridview:true,
				rownumbers:true,
				autoencode:true,
				ignoreCase:true,
				sortname: 'No',
				viewrecords: true,
				sortorder: 'desc',
				caption:'Predios',
				height: '100%',
				width: '100%',
				editurl: 'clientArray',
				ondblClickRow: function(rowid, ri, ci) {
					var p = grid[0].p;
					if (p.selrow !== rowid) {
						// prevent the row from be unselected on double-click
						// the implementation is for "multiselect:false" which we use,
						// but one can easy modify the code for "multiselect:true"
						grid.jqGrid('setSelection', rowid);
					}
					grid.jqGrid('editGridRow', rowid, editSettings);
				},
				onSelectRow: function(id) {
					if (id && id !== lastSel) {
					// cancel editing of the previous selected row if it was in editing state.
					// jqGrid hold intern savedRow array inside of jqGrid object,
					// so it is safe to call restoreRow method with any id parameter
					// if jqGrid not in editing state
					if (typeof lastSel !== "undefined") {
					grid.jqGrid('restoreRow',lastSel);
					}
					lastSel = id;
					}
				}
			}).jqGrid('navGrid','#pager',{},editSettings,addSettings,delSettings,
			{multipleSearch:true,overlay:false,
			onClose:function(form){
			// if we close the search dialog during the datapicker are opened
			// the datepicker will stay opened. To fix this we have to hide
			// the div used by datepicker
			$("div#ui-datepicker-div.ui-datepicker").hide();
			}}); 
			
			//Persona
			
			var lastSel, mydata = [
			           			{id:"1", name:"test", note:" GOMEZ OSORIO IGNACIO" }

			           			],
			           			grid = $("#list2"),
			           			
			           			//Agregar
			           			onclickSubmitLocal = function(options,postdata) {
			           			
			           			var grid_p = grid[0].p, idname = grid_p.prmNames.id, grid_id = grid[0].id,	id_in_postdata = grid_id+"_id", rowid = postdata[id_in_postdata],
			           						 addMode = rowid === "_empty",	oldValueOfSortColumn;
			           			// postdata has row id property with another name. we fix it:
			           			if (addMode) {
			           				// generate new id
			           				var new_id = grid_p.records + 1;
			           				while ($("#"+new_id).length !== 0) {
			           				new_id++;
			           				}
			           				postdata[idname] = String(new_id);
			           			} else if (typeof(postdata[idname]) === "undefined") {
			           					// set id property only if the property not exist
			           					postdata[idname] = rowid;
			           			}
			           			delete postdata[id_in_postdata];
			           			// prepare postdata for tree grid
			           			if(grid_p.treeGrid === true) {
			           				if(addMode) {
			           					var tr_par_id = grid_p.treeGridModel === 'adjacency' ? grid_p.treeReader.parent_id_field : 'parent_id';
			           					postdata[tr_par_id] = grid_p.selrow;
			           			}
			           			$.each(grid_p.treeReader, function (i){
			           				if(postdata.hasOwnProperty(this)) {
			           					delete postdata[this];
			           				}
			           			});
			           			}
			           			// decode data if there encoded with autoencode
			           			if(grid_p.autoencode) {
			           				$.each(postdata,function(n,v){
			           					postdata[n] = $.jgrid.htmlDecode(v); // TODO: some columns could be skipped
			           				});
			           			}
			           				// save old value from the sorted column
			           				oldValueOfSortColumn = grid_p.sortname === "" ? undefined: grid.jqGrid('getCell',rowid,grid_p.sortname);
			           				// save the data in the grid
			           			if (grid_p.treeGrid === true) {
			           				if (addMode) {
			           					grid.jqGrid("addChildNode",rowid,grid_p.selrow,postdata);
			           			} else {
			           				grid.jqGrid("setTreeRow",rowid,postdata);
			           			}
			           			} else {
			           				if (addMode) {
			           					grid.jqGrid("addRowData",rowid,postdata,options.addedrow);
			           				} else {
			           					grid.jqGrid("setRowData",rowid,postdata);
			           				}
			           			}
			           			
			           			if ((addMode && options.closeAfterAdd) || (!addMode && options.closeAfterEdit)) {
			           				// close the edit/add dialog
			           				$.jgrid.hideModal("#editmod"+grid_id,
			           				{gb:"#gbox_"+grid_id,jqm:options.jqModal,onClose:options.onClose});
			           			}
			           			if (postdata[grid_p.sortname] !== oldValueOfSortColumn) {
			           				// if the data are changed in the column by which are currently sorted
			           				// we need resort the grid
			           				setTimeout(function() {
			           				grid.trigger("reloadGrid", [{current:true}]);
			           				},100);
			           			}
			           			// !!! the most important step: skip ajax request to the server
			           			this.processing = true;
			           			return {};
			           			},
			           			//Editar 
			           			editSettings = {
			           				//recreateForm:true,
			           				jqModal:false,
			           				reloadAfterSubmit:false,
			           				closeOnEscape:true,
			           				savekey: [true,13],
			           				closeAfterEdit:true,
			           				onclickSubmit:onclickSubmitLocal
			           				},
			           			addSettings = {
			           			//recreateForm:true,
			           			jqModal:false,
			           			reloadAfterSubmit:false,
			           			savekey: [true,13],
			           			closeOnEscape:true,
			           			closeAfterAdd:true,
			           			onclickSubmit:onclickSubmitLocal
			           			},
			           			delSettings = {
			           				// because I use "local" data I don't want to send the changes to the server
			           				// so I use "processing:true" setting and delete the row manually in onclickSubmit
			           				onclickSubmit: function(options, rowid) {
			           					var grid_id = $.jgrid.jqID(grid[0].id),
			           					grid_p = grid[0].p,
			           					newPage = grid[0].p.page;
			           					// delete the row
			           					grid.delRowData(rowid);
			           					$.jgrid.hideModal("#delmod"+grid_id,
			           					{gb:"#gbox_"+grid_id,jqm:options.jqModal,onClose:options.onClose});
			           					if (grid_p.lastpage > 1) {// on the multipage grid reload the grid
			           						if (grid_p.reccount === 0 && newPage === grid_p.lastpage) {
			           							// if after deliting there are no rows on the current page
			           							// which is the last page of the grid
			           							newPage--; // go to the previous page
			           						}
			           					// reload grid to make the row from the next page visable.
			           					grid.trigger("reloadGrid", [{page:newPage}]);
			           					}
			           					return true;
			           				},
			           				processing:true
			           			},
			           			initDateEdit = function(elem) {
			           				setTimeout(function() {
			           				$(elem).datepicker({
			           				dateFormat: 'dd-M-yy',
			           				autoSize: true,
			           				showOn: 'button', // it dosn't work in searching dialog
			           				changeYear: true,
			           				changeMonth: true,
			           				showButtonPanel: true,
			           				showWeek: true
			           				});
			           				//$(elem).focus();
			           				},100);
			           			},
			           			initDateSearch = function(elem) {
			           				setTimeout(function() {
			           				$(elem).datepicker({
			           				dateFormat: 'dd-M-yy',
			           				autoSize: true,
			           				//showOn: 'button', // it dosn't work in searching dialog
			           				changeYear: true,
			           				changeMonth: true,
			           				showButtonPanel: true,
			           				showWeek: true
			           				});
			           				//$(elem).focus();
			           				},100);
			           			};
			           			
			           			grid.jqGrid({
			           				datatype:'local',
			           				data: mydata,
			           				colNames:['Inv No','Direccion'],
			           				colModel:[
			           				{name:'id',index:'id',width:70,align:'center',sorttype: 'int',searchoptions:{sopt:['eq','ne']},hidden:true},	
			           				{name:'note',index:'note',width:500,sortable:false,editable:true,edittype:'textarea'}
			           				],
			           				rowNum:10,
			           				//rowList:[5,10,20],
			           				pager: '#pager2',
			           				gridview:true,
			           				rownumbers:true,
			           				autoencode:true,
			           				ignoreCase:true,
			           				sortname: 'No',
			           				viewrecords: true,
			           				sortorder: 'desc',
			           				caption:'Persona',
			           				height: '100%',
			           				width: '100%',
			           				editurl: 'clientArray',
			           				ondblClickRow: function(rowid, ri, ci) {
			           					var p = grid[0].p;
			           					if (p.selrow !== rowid) {
			           						// prevent the row from be unselected on double-click
			           						// the implementation is for "multiselect:false" which we use,
			           						// but one can easy modify the code for "multiselect:true"
			           						grid.jqGrid('setSelection', rowid);
			           					}
			           					grid.jqGrid('editGridRow', rowid, editSettings);
			           				},
			           				onSelectRow: function(id) {
			           					if (id && id !== lastSel) {
			           					// cancel editing of the previous selected row if it was in editing state.
			           					// jqGrid hold intern savedRow array inside of jqGrid object,
			           					// so it is safe to call restoreRow method with any id parameter
			           					// if jqGrid not in editing state
			           					if (typeof lastSel !== "undefined") {
			           					grid.jqGrid('restoreRow',lastSel);
			           					}
			           					lastSel = id;
			           					}
			           				}
			           			}).jqGrid('navGrid','#pager2',{},editSettings,addSettings,delSettings,
			           			{multipleSearch:true,overlay:false,
			           			onClose:function(form){
			           			// if we close the search dialog during the datapicker are opened
			           			// the datepicker will stay opened. To fix this we have to hide
			           			// the div used by datepicker
			           			$("div#ui-datepicker-div.ui-datepicker").hide();
			           			}}); 
			
			

    
});