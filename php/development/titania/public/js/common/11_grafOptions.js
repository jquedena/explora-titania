var optionsLine = {
	chart : {renderTo : 'container'},
	title : {text : '<b>Visitas Realizadas</b>'},
	subtitle : {text : ''},
	xAxis : {
		type : 'datetime',
		tickInterval : 7 * 24 * 3600 * 1000, // one week
		tickWidth : 0,
		gridLineWidth : 1,
		labels : {
			align : 'left',
			x : 3,
			y : -3
		}
	},
	yAxis : [ { // left y axis
		title : {
			text : null
		},
		labels : {
			align : 'left',
			x : 3,
			y : 16,
			formatter : function() {
				return Highcharts.numberFormat(this.value, 0);
			}
		},
		showFirstLabel : false
	}, { // right y axis
		linkedTo : 0,
		gridLineWidth : 0,
		opposite : true,
		title : {
			text : null
		},
		labels : {
			align : 'right',
			x : -3,
			y : 16,
			formatter : function() {
				return Highcharts.numberFormat(this.value, 0);
			}
		},
		showFirstLabel : false
	} ],
	legend : {
		align : 'left',
		verticalAlign : 'top',
		y : 5,
		x : 10,
		floating : true,
		borderWidth : 0
	},
	tooltip : {
		shared : true,
		crosshairs : true
	},
	plotOptions : {
		series : {
			cursor : 'pointer',
			point : {
				events : {
					click : function() {
						hs.htmlExpand(null, {
							pageOrigin : {
								x : this.pageX,
								y : this.pageY
							},
							headingText : this.series.name,
							maincontentText : Highcharts.dateFormat(
									'%A, %b %e, %Y', this.x)
									+ ':<br/> ' + this.y + ' visitas',
							width : 200
						});
					}
				}
			},
			marker : {
				lineWidth : 1
			}
		}
	},
	series : [ {
		name : 'A recaudaci\u00F3n',
		lineWidth : 4,
		marker : {radius : 4}
	}, {
		name : 'A tesoreria'
	} ]
};