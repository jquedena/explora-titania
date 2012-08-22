
(function($){

    $.fn.displayTagAjax = function() {
        var links = new Array();
        var container = this;
        addItemsToArray(this.find("table .sortable a"),links);
        addItemsToArray(this.find(".pagelinks a"),links);
        $.each(links,function()
            {
                    var url = $(this).attr("href");
                    addClickEvent(container, this,url);
                    $(this).removeAttr("href");
            }
        );
        return true;
    };

  function addClickEvent(ctx, element,url){
        $(element).click(
            function(){
                jQuery.ajax(
                {
                    url: url,
                    success: function(data){
                       filteredResponse =  $(data).find(this.selector);
                       if(filteredResponse.size() == 1){
                            $(this).html(filteredResponse);
                       }else{
                            $(this).html(data);
                       }
                       $(this).displayTagAjax();
                       if(updHeader)
                       {
                    	   modificarCabecera(); 
                       }                       
                    } ,
                    data: ({"time":new Date().getTime()}),
                    context: ctx
                });
                
            }
        );
    }

   function addItemsToArray(items,array){
        $.each(items,function()
            {
                    array.push(this);
            }
        );        
    }
    
})(jQuery);



