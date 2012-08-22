
function gridMultiSelect(idGrid)
{
	idGrid = '#' +  idGrid + ' tr';
		
	$(idGrid)
		.filter(':has(:checkbox:checked)')
		.addClass('seleccionado')
		.end()
		.click(function(event) {
			if (event.target.type !== 'checkbox') 
			{
				$(':checkbox', this).trigger('click');
			}
		})
		.find(':checkbox')
		.click(function(event) {
			$(this).parents('tr:first').toggleClass('seleccionado');
		});  
	
}

function gridMultiSelect_Last(idGrid)
{
	idGrid = '#' +  idGrid + ' tr:last';
		
	$(idGrid)
		.filter(':has(:checkbox:checked)')
		.addClass('seleccionado')
		.end()
		.click(function(event) {
			if (event.target.type !== 'checkbox') 
			{
				$(':checkbox', this).trigger('click');
			}
		})
		.find(':checkbox')
		.click(function(event) {
			$(this).parents('tr:first').toggleClass('seleccionado');
		});  
	
}

function gridSingleSelect(idGrid)
{
	idGrid = '#' +  idGrid + ' tr';
	
	$(idGrid)								
	.click(function(event) 
	{				
		$(idGrid).each(function()
		{  
			if($(this).hasClass('seleccionado'))
			{
				$(this).toggleClass('seleccionado');
			} 
			});
		 					
			$(this).toggleClass('seleccionado');
			if (event.target.type !== 'radio') {
			$(':radio', this).attr('checked', function() {
				return !this.checked;
			});
										
		}				
	});
}

function reprocesarEstilos(idGrid)
{
	
	idGrid = '#' +  idGrid + ' tr';
	
	$(idGrid).each(function(i,objeto)
	{  
		var cssClase = (i%2 == 0 ? 'even' : 'odd');

		if($(this).hasClass('even'))
		{
			$(this).removeClass('even');
		}

		if($(this).hasClass('odd'))
		{
			$(this).removeClass('odd');
		}
			
		$(this).addClass(cssClase);

	});
	
}