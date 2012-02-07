//$(function(){
    callAjaxPostJSON("index/testjson"
        , {s: "a"}
        , function(data){
            console.log(data);
            //console.log(data.test);
            //console.log(data.error);
            //$("#test").html(data.test);
        });
        
    /*jQuery("#jsonmap").jqGrid({        
            url:path+'index.php/index/testjson',
            datatype: "json",
            colNames:['Inv No','Date', 'Client', 'Test'],
            colModel:[
                    {name:'idrowst',index:'idrowst', width:55},
                    {name:'idrol',index:'idrol', width:90},
                    {name:'vnameid',index:'vnameid', width:100},
                    {name:'ctipobj',index:'ctipobj', width:80, align:"right"}		
            ],
            rowNum:10,
            rowList:[10,20,30],
            pager: '#pjmap',
            sortname: 'idrowst',
        viewrecords: true,
        sortorder: "desc",
            jsonReader: {
                    repeatitems : false,
                    id: "0"
            },
            caption: "JSON Mapping",
            height: '100%'
    });
    jQuery("#jsonmap").jqGrid('navGrid','#pjmap',{edit:false,add:false,del:false});*/
//});