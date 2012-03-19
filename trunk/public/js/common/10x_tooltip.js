$(document).ready(function() 
{
   $('#content a[tooltip]').each(function()
   {
      $(this).qtip({
         content: $(this).attr('tooltip'), // Use the tooltip attribute of the element for the content
         style: 'dark' // Give it a crea mstyle to make it stand out
      });
   });
   //-----------------------------------------------------------
   $('#content img[tooltip]').each(function()
   {
      $(this).qtip({
         content: $(this).attr('tooltip'), // Use the tooltip attribute of the element for the content
		 corner: {
				 target: 'topRight',
				 tooltip: 'topLeft'
      		     },
		 position: {
					   target: 'mouse',
					   adjust: { mouse: true }
					},
		 show: { delay: 0 },
         style: { 
				  //width: 600,
				  padding: 5,
				  //background: '#A2D959',
				  //color: 'black',
				  textAlign: 'center',
				  border: {
					 width: 7,
					 radius: 5,
					 //color: '#A2D959'
				  },				  
				  tip: { // Now an object instead of a string
						 corner: 'topLeft', // We declare our corner within the object using the corner sub-option
						 size: {
							x: 20, // Be careful that the x and y values refer to coordinates on screen, not height or width.
							y : 20 // Depending on which corner your tooltip is at, x and y could mean either height or width!
						 }
					   },
				  name: 'green' // Inherit the rest of the attributes from the preset dark style
			   }
      });
   });
});