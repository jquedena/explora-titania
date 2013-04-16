(function( $ ) {
    $.widget( "ui.autocompleteCategory", $.ui.autocomplete, {
        _renderMenu: function( ul, items ) {
            var that = this,
                currentCategory = "";
            $.each( items, function( index, item ) {
                if ( item.category != currentCategory ) {
                    ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
                    currentCategory = item.category;
                }
                that._renderItem( ul, item );
            });
        }
    });

    $.widget( "ui.combobox", {
        _create: function() {
            var input = null,
            self = this,
            select = this.element.hide(),
            selected = select.children( ":selected" ),
            value = selected.val() ? selected.text() : "",
            wrapper = this.wrapper = $( "<table cellpadding=0 cellspacing=0>" )
            .addClass( "ui-combobox" )
            .css({"height": "19px"})
            .insertAfter( select ),
            tr,
            td_1,
            td_2;
           
            tr = $( "<tr>" ).appendTo( wrapper );
            td_1 = $( "<td>" )
            .appendTo( tr )
            .css({"verticalAlign": "top"});
            td_2 = $( "<td>" )
            .appendTo( tr )
            .css({"verticalAlign": "top"});

             // TODO:  input = $( "<input>" )
            input = this.input = $("<input>") 
            .appendTo( td_1 )
            .val( value )
            .addClass( "ui-combobox-input" )
            .attr("id", select.attr("id").replace("cbo", "txt"))
            .css({"width": select.css("width")})
            .autocomplete({
                delay: 0,
                autoFocus :true,
                minLength: 0,
                source: function( request, response ) {
                    var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
                    response( select.children( "option" ).map(function() {
                        var text = $( this ).text();
                        if ( this.value && ( !request.term || matcher.test(text) ) )
                            return {
                                label: text.replace(
                                    new RegExp(
                                        "(?![^&;]+;)(?!<[^<>]*)(" +
                                        $.ui.autocomplete.escapeRegex(request.term) +
                                        ")(?![^<>]*>)(?![^&;]+;)", "gi"
                                        ), "<b>$1</b>" ),
                                value: text,
                                option: this
                            };
                    }) );
                },
                select: function( event, ui ) {
                    ui.item.option.selected = true;
                    self._trigger( "selected", event, {
                        item: ui.item.option
                    });
                },
                change: function( event, ui ) {
                    if ( !ui.item ) {
                        var matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( $(this).val() ) + "$", "i" ),
                        valid = false;
                        select.children( "option" ).each(function() {
                            if ( $( this ).text().match( matcher ) ) {
                                this.selected = valid = true;
                                return false;
                            }
                        });
                        if ( !valid ) {
                            // remove invalid value, as it didn't match anything
                            $( this ).val( "" );
                            select.val( "" );
                            input.data( "autocomplete" ).term = "";
                            return false;
                        }
                    }
                }
            })
            // .addClass( "ui-widget ui-widget-content ui-corner-left" );
            .addClass( "ui-corner-left" ); 

            input.data( "autocomplete" )._renderItem = function( ul, item ) {
                return $( "<li></li>" )
                .data( "item.autocomplete", item )
                .append( "<a>" + item.label + "</a>" )
                .appendTo( ul );
            };

            //$( "<a>" )
            a = this.a = $("<a>") 
            .attr("id", select.attr("id").replace("cbo", "link"))
            .attr( "tabIndex", -1 )
            .attr( "title", "Desplegar lista" )
            // .css({"top": input.css("top")})
            // .css({"lineHeight": "18px", "height": "18px", "position": "relative", "display": "inline-block"})
            .appendTo( td_2 )
            .button({
                icons: {
                    primary: "ui-icon-triangle-1-s"
                },
                text: false
            })
            .removeClass( "ui-corner-all" )
            .addClass( "ui-corner-right ui-combobox-toggle" )
            .click(function() {
                // close if already visible
                if ( input.autocomplete( "widget" ).is( ":visible" ) ) {
                    input.autocomplete( "close" );
                    return;
                }

                // work around a bug (likely same cause as #5265)
                $( this ).blur();

                // pass empty string as value to search for, displaying all results
                input.autocomplete( "search", "" );
                input.focus();
            });
        },

        destroy: function() {
            this.wrapper.remove();
            this.element.show();
            $.Widget.prototype.destroy.call( this );
        },
        
        disable: function() {
            this.input.prop('disabled',true);
            this.input.autocomplete("disable");
            this.a.button("disable");
        },
        enable: function() {
            this.input.prop('disabled',false);
            this.input.autocomplete("enable");
            this.a.button("enable");
        } 
    });
})( jQuery );

autocompletar = function(id, data, select) {
	$(id).autocomplete({
		minLength: 0,
		autoFocus: true,
		source: data,
		select: select
	}).on("focus", function() {
		$(this).autocomplete("search", "");
	}).data("autocomplete")._renderItem = function(ul, item) {
		return $("<li></li>")
			.data("item.autocomplete", item)
			.append("<a style='width: 250px;'><b>" + item.label + "</b><br>" + item.desc + "</a>")
			.appendTo(ul);
	};
};