function test(){
    callAjaxPostJSON("index/test"
        , {user: "add"}
        , function(data){
            console.log(data);
            console.log(data.test);
            console.log(data.error);
            $("#test").html(data.test);
        });
}