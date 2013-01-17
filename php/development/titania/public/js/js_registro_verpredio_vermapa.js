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
		geocoder = null;

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