//环境趋势图
function kqhjChart() {
    var chartDom = document.getElementById("kqhj");
    var myChart = echarts.init(chartDom);
    var option ;
    option= {
        color: ['#80FFA5', '#00DDFF', '#37A2FF', '#FF0087', '#FFBF00'],
        title: {
            text: '空气环境曲线图'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            right: '5%',
            top:'7%',
            data: ['空气温度(℃)', '空气湿度(%)', '二氧化碳浓度(100*ppm)', '光照强度(kLux)']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '空气温度(℃)',
                type: 'line',
                stack: '总量',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(128, 255, 165)'
                    }, {
                        offset: 1,
                        color: 'rgba(1, 191, 236)'
                    }])
                },
                emphasis: {
                    focus: 'series'
                },
                data: [120, 250, 40, 278, 100, 380, 200]
            },
            {
                name: '空气湿度(%)',
                type: 'line',
                stack: '总量',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(0, 221, 255)'
                    }, {
                        offset: 1,
                        color: 'rgba(77, 119, 255)'
                    }])
                },
                emphasis: {
                    focus: 'series'
                },
                data: [123, 278, 100, 280, 190, 370, 290]
            },
            {
                name: '二氧化碳浓度(100*ppm)',
                type: 'line',
                stack: '总量',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(55, 162, 255)'
                    }, {
                        offset: 1,
                        color: 'rgba(116, 21, 219)'
                    }])
                },
                emphasis: {
                    focus: 'series'
                },
                data: [330, 190, 220, 350, 170, 120, 240]
            },
            {
                name: '光照强度(kLux)',
                type: 'line',
                stack: '总量',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(255, 0, 135)'
                    }, {
                        offset: 1,
                        color: 'rgba(135, 0, 157)'
                    }])
                },
                emphasis: {
                    focus: 'series'
                },
                data: [234, 457, 231, 145, 199, 246, 121]
            }
        ]
    };

    option && myChart.setOption(option);
}

function trhjChart() {
    var chartDom = document.getElementById("trhj");
    var myChart = echarts.init(chartDom);
    var option = {
        color: ['#80FFA5', '#00DDFF', '#37A2FF', '#FF0087', '#FFBF00'],
        title: {
            text: '土壤环境曲线图'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            right: '10%',
            top:'7%',
            data: ['土壤温度(℃)', '土壤湿度(%)', '土壤PH值', '土壤EC值(mS/cm)']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '土壤温度(℃)',
                type: 'line',
                stack: '总量',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(128, 255, 165)'
                    }, {
                        offset: 1,
                        color: 'rgba(1, 191, 236)'
                    }])
                },
                emphasis: {
                    focus: 'series'
                },
                data: [140, 232, 101, 264, 90, 340, 250]
            },
            {
                name: '土壤湿度(%)',
                type: 'line',
                stack: '总量',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(0, 221, 255)'
                    }, {
                        offset: 1,
                        color: 'rgba(77, 119, 255)'
                    }])
                },
                emphasis: {
                    focus: 'series'
                },
                data: [120, 282, 111, 234, 220, 340, 310]
            },
            {
                name: '土壤PH值',
                type: 'line',
                stack: '总量',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(55, 162, 255)'
                    }, {
                        offset: 1,
                        color: 'rgba(116, 21, 219)'
                    }])
                },
                emphasis: {
                    focus: 'series'
                },
                data: [320, 132, 201, 334, 190, 130, 220]
            },
            {
                name: '土壤EC值(mS/cm)',
                type: 'line',
                stack: '总量',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(255, 0, 135)'
                    }, {
                        offset: 1,
                        color: 'rgba(135, 0, 157)'
                    }])
                },
                emphasis: {
                    focus: 'series'
                },
                data: [220, 402, 231, 134, 190, 230, 120]
            }
        ]
    };

    option && myChart.setOption(option);
}