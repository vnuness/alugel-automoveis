jQuery(document).ready(function ($) {

                loadTable();
                loadPieGraph();
                loadBarGraph();

                function loadBarGraph() {

                    $.ajax({
                        url: "../locacoes-mensais",
                        type: 'GET',
                        assync: true,
                        success: function (result) {
                            buildBarGraph(result);
                        },
                        error: function () {
                            JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar os Status dos Veículos!');
                            return false;
                        }
                    });


                }

                function buildBarGraph(data)
                {
                    var graph = [];
                    let day;

                    for (i = 0; i < 31; i++) {
                        if (i < 9) {
                            day = '0' + (i + 1);
                        } else {
                            day = '' + (i + 1);
                        }
                        graph[i] = [day, 0];
                    }
//                    console.log(graph);
                    for(let index in data) {
                        console.log(data);
                        if(data[index].dataLocacao < 9) {
                            graph[data[index].dataLocacao] = ['0' + data[index].dataLocacao.toString(), data[index].quantidade];
                        } else {
                            graph[data[index].dataLocacao] = [data[index].dataLocacao.toString(), data[index].quantidade];
                        }
                    }

                    Highcharts.chart('bar', {
                        chart: {
                            type: 'column',
                            backgroundColor: {
                                linearGradient: {x1: 0, y1: 0, x2: 1, y2: 1},
                                stops: [
                                    [0, '#2a2a2b'],
                                    [1, '#3e3e40']
                                ]
                            },
                        },
                        title: {
                            text: 'Total de Locações por dia',
                            style: {
                                color: '#E0E0E3',
                                textTransform: 'uppercase',
                                fontSize: '20px'
                            }
                        },
                        xAxis: {
                            type: 'category',
                            labels: {
                                rotation: -45,
                                style: {
                                    fontSize: '13px',
                                    fontFamily: 'Verdana, sans-serif'
                                }
                            }
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: 'Locações'
                            }
                        },
                        legend: {
                            enabled: false
                        },
                        tooltip: {
                            pointFormat: 'Total no dia: <b>{point.y:1f}</b>'
                        },
                        series: [{
                                name: 'Locações',
                                data: graph,
                                dataLabels: {
                                    enabled: true,
                                    rotation: -90,
                                    color: '#FFFFFF',
                                    align: 'right',
                                    format: '{point.y:.f}', // one decimal
                                    y: 10, // 10 pixels down from the top
                                    style: {
                                        fontSize: '13px',
                                        fontFamily: 'Verdana, sans-serif'
                                    }
                                }
                            }]
                    });
                    //console.log(graph);
                }

                //console.log(testeArray());


                $('.counter').counterUp({
                    delay: 100,
                    time: 1200
                });
                $('.circliful-chart').circliful();
                $('.highcharts-button-symbol').hide();
                $('.highcharts-button-box').hide();


                function loadPieGraph() {
                    $.ajax({
                        url: "../locacoescategoria",
                        type: 'GET',
                        assync: true,
                        success: function (result) {
                            buildPieGraph(result);
                        },
                        error: function () {
                            JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar os Status dos Veículos!');
                            return false;
                        }
                    });

                }

                function buildPieGraph(data) {
                    Highcharts.chart('pie', {
                        chart: {
                            backgroundColor: {
                                linearGradient: {x1: 0, y1: 0, x2: 1, y2: 1},
                                stops: [
                                    [0, '#2a2a2b'],
                                    [1, '#3e3e40']
                                ]
                            },
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false,
                            type: 'pie'
                        },
                        title: {
                            style: {
                                color: '#E0E0E3',
                                textTransform: 'uppercase',
                                fontSize: '20px'
                            },
                            text: 'Total de Locações por categoria'
                        },
                        subtitle: {
                            style: {
                                color: '#E0E0E3',
                                textTransform: 'uppercase'
                            }
                        },
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: false
                                },
                                showInLegend: true
                            }
                        },
                        scrollbar: {
                            barBackgroundColor: '#808083',
                            barBorderColor: '#808083',
                            buttonArrowColor: '#CCC',
                            buttonBackgroundColor: '#606063',
                            buttonBorderColor: '#606063',
                            rifleColor: '#FFF',
                            trackBackgroundColor: '#404043',
                            trackBorderColor: '#404043'
                        },
                        legend: {
                            itemStyle: {
                                color: '#E0E0E3'
                            },
                            itemHoverStyle: {
                                color: '#FFF'
                            },
                            itemHiddenStyle: {
                                color: '#606063'
                            }
                        },
                        labels: {
                            style: {
                                color: '#707073'
                            }
                        },
                        legendBackgroundColor: 'rgba(0, 0, 0, 0.5)',
                        background2: '#505053',
                        dataLabelsColor: '#B0B0B3',
                        textColor: '#C0C0C0',
                        contrastTextColor: '#F0F0F3',
                        maskColor: 'rgba(255,255,255,0.3)',
                        series: [{
                                name: 'Abrange',
                                colorByPoint: true,
                                data: data
                            }]
                    });
                    $('.highcharts-button-symbol').hide();
                    $('.highcharts-button-box').hide();
                }

            });
            // BEGIN SVG WEATHER ICON
            if (typeof Skycons !== 'undefined') {
                var icons = new Skycons(
                        {"color": "#3bafda"},
                {"resizeClear": true}
                ),
                        list = [
                            "clear-day", "clear-night", "partly-cloudy-day",
                            "partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
                            "fog"
                        ],
                        i;
                for (i = list.length; i--; )
                    icons.set(list[i], list[i]);
                icons.play();
            }
            ;

            function loadTable()
            {
                $.ajax({
                    url: "../ultimaslocacoes",
                    type: 'GET',
                    success: function (result) {
                        popTable(result);
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar a Tabela!');
                    }
                });
            }

            function popTable(data)
            {
                $('#ultimas-locacoes tr').not(':first').remove(); //Aqui eu limpo a tabela
                var html = ''; // Aqui declaro a variável que receberá o conteúdo HTML
                for (var i in data) { // aqui faço um FOREACH, para a minha lista de dados. Cada linha de dado, preencho uma linha na tabela
                    html = '<tr><td>' + (parseInt(i) + 1) + '</td>' +
                            '<td>' + data[i].cliente + '</td>' +
                            '<td>' + moment(moment(data[i].dataLocacao, "YYYY-mm-DD")).format("DD/mm/YYYY") + '</td>' +
                            '<td>' + moment(moment(data[i].dataDevolucao, "YYYY-mm-DD")).format("DD/mm/YYYY") + '</td>';

                    if (data[i].avaliacao === "Satisfeito") {
                        html += '<td><span class="badge badge-warning">' + data[i].avaliacao + '</span></td></tr>';
                    } else if (data[i].avaliacao === "Insatisfeito") {
                        html += '<td><span class="badge badge-danger">' + data[i].avaliacao + '</span></td></tr>';
                    } else {
                        html += '<td><span class="badge badge-success">' + data[i].avaliacao + '</span></td></tr>';
                    }

                    $('#ultimas-locacoes tr').last().after(html);
                }
            }