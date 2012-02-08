function test(){        
    jQuery("#jsonmap").jqGrid({        
            url: path+"index/testjson",
            datatype: "json",
            height: 250,
            width: 450,
            colNames:['Inv No','Date', 'Client', 'Test'],
            colModel:[
                    {name:'idrowst',index:'idrowst', width:55, sorteable: false},
                    {name:'idrol',index:'idrol', width:90},
                    {name:'vnameid',index:'vnameid', width:100},
                    {name:'ctipobj',index:'ctipobj', width:80, align:"right"}		
            ],
            rowNum:3,
            rowList:[3,4,5],
            pager: '#pjmap',
            viewrecords: true
    });
    // jQuery("#jsonmap").jqGrid('navGrid','#pjmap',{edit:false,add:false,del:false});
    
    /*for(var i=0;i<=x.length;i++)
	jQuery("#jsonmap").jqGrid('addRowData',i+1,x[i]);*/
}