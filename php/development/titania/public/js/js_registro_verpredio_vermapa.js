/*
 var contentString = '<div id="content">' +
	'<h1 id="firstHeading" class="firstHeading">{0}</h1>' +
	'<div id="bodyContent">' +
	'<p><b>Direcci' + String.fromCharCode(243) + 'n: </b> {1} ' +
	'</div>' +
	'</div>';
 */

var map = null,
	image = pathImage + '../img/casa.png',
		markersArray = [],
		mapOptions = null,
		geocoder = new google.maps.Geocoder();

	clearOverlays = function() {
		if (markersArray.length>0)
			markersArray[0].setMap(null);
		markersArray.length = 0;
	};
 
	placeMarker = function(location) {
		var lat = location.lat();
		var lng = location.lng();
  
		$('#longitud').val(lat);
	$('#latitud').val(lng);
	$("#zoom").val(map.getZoom());
  
		clearOverlays();
		var marker = new google.maps.Marker({
			map: map,
			draggable: true,
			animation: google.maps.Animation.DROP,
			icon: image,
			title: "Municipalidad de Puente Piedra",
		position: location
	});

	/*
	var _content = "Mensaje de Prueba";
	var infoWindow = new google.maps.InfoWindow({content: _content});
	infoWindow.open(map, marker);
	*/
	
	google.maps.event.addListener(marker, 'click', function(){
		if (marker.getAnimation() != null)
			marker.setAnimation(null);
		else 
			marker.setAnimation(google.maps.Animation.BOUNCE);
	});

	markersArray.push(marker);
};

initMap = function(){
	clearOverlays();
	map = new google.maps.Map(document.getElementById("map"),mapOptions);
	var marker = new google.maps.Marker({
		map: map,
		draggable: true,
		animation: google.maps.Animation.DROP,
		icon: image,
		title: "Municipalidad de Puente Piedra",
		position: new google.maps.LatLng($('#longitud').val(), $('#latitud').val())
	});

	/*
	var _content = "Mensaje de Prueba";
	var infoWindow = new google.maps.InfoWindow({content: _content});
	infoWindow.open(map, marker);
  	*/
  	
	google.maps.event.addListener(map, 'click', function(event) {placeMarker(event.latLng);});
	markersArray.push(marker);
};

$(document).ready(function() {
	$("#direccionXY").autocomplete({          
		source: function(request, response) {
			if (geocoder == null){
				geocoder = new google.maps.Geocoder();
			} 
			geocoder.geocode( {'address': request.term }, function(results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					// var searchLoc = results[0].geometry.location;
					// var bounds = results[0].geometry.bounds;
					var lat = results[0].geometry.location.lat();
					var lng = results[0].geometry.location.lng();
					var latlng = new google.maps.LatLng(lat, lng);

					geocoder.geocode({'latLng': latlng}, function(results1, status1) {
						if (status1 == google.maps.GeocoderStatus.OK) {
							if (results1[1]) {
								response($.map(results1, function(loc) {
									return {
										label  : loc.formatted_address,
										value  : loc.formatted_address,
										bounds   : loc.geometry.bounds
									};
								}));
							}
						}
					});
				}
			});
		},
		select: function(event,ui){
			// var pos = ui.item.position;
			// var lct = ui.item.locType;
			var bounds = ui.item.bounds;

			if (bounds){
				map.fitBounds(bounds);
			}
		}
	});
	
	mapOptions = {
    		zoom: parseInt($('#zoom').val(), 10),
    		mapTypeId: google.maps.MapTypeId.ROADMAP,
			center: new google.maps.LatLng($('#longitud').val(), $('#latitud').val())
		};

    initMap();
});