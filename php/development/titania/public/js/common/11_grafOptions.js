var optionsLine = {
    chart: {
        renderTo: 'container',
        type: 'scatter',
        zoomType: 'xy'
    },
    title: {
        text: 'Visitas Realizadas'
    },
    subtitle: {
        text: false
    },
    xAxis: {
        title: {
            enabled: true,
            text: 'Semana'
        },
        startOnTick: true,
        endOnTick: true,
        showLastLabel: true
    },
    yAxis: {
        title: {
            text: 'Horas'
        }
    },
    tooltip: {
        formatter: function() {
                return ''+
                this.x +' cm, '+ this.y +' kg';
        }
    },
    legend: {
        layout: 'vertical',
        align: 'left',
        verticalAlign: 'top',
        x: 100,
        y: 70,
        floating: true,
        backgroundColor: '#FFFFFF',
        borderWidth: 1
    },
    plotOptions: {
        scatter: {
            marker: {
                radius: 5,
                states: {
                    hover: {
                        enabled: true,
                        lineColor: 'rgb(100,100,100)'
                    }
                }
            },
            states: {
                hover: {
                    marker: {
                        enabled: false
                    }
                }
            }
        }
    },
    series: [{
        name: 'Recaudacion',
        color: 'rgba(223, 83, 83, .5)',
        data: [[1, 1], [2, 1], [3,1]]

    }, {
        name: 'Tesoreria',
        color: 'rgba(119, 152, 191, .5)',
        data: [[1, 0]]
    }]
};