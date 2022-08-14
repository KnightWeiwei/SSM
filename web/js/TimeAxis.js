var chart = null;
$.getJSON('AllConfirmNum', function (data) {
	//data=JSON.parse(data);
	//console.log(data);
	let res=[];
	let s=[];
	//console.log(res);

	//这是个datetime转换成时间戳模式的一个手写函数！！咱也不知道highcharts为啥要用，反正得转换一下
	function changeTime(d){
		var str = d.replace(/-/g,"/");
		var date=new Date(str);
		var r = Date.UTC(date.getFullYear(),date.getMonth(),date.getDate(),
			date.getHours(),date.getMinutes(),date.getSeconds() );
		return r;
	}

	for(let user of data){
		let  Strdatetime=changeTime(user.datetime);
		//console.log(Strdatetime);
		s.push(Strdatetime);
		s.push(user.num);
		console.log(s);
		res.push(s);
		s=[];
	}
	console.log(res);
	data=res;
	chart = Highcharts.chart('container', {
		chart: {
			zoomType: 'x'
		},
		title: {
			text: '疫情确诊病例'
		},
		subtitle: {
			text: document.ontouchstart === undefined ?
			'鼠标拖动可以进行缩放' : '手势操作进行缩放'
		},
		xAxis: {
			type: 'datetime',
			dateTimeLabelFormats: {
				millisecond: '%H:%M:%S.%L',
				second: '%H:%M:%S',
				minute: '%H:%M',
				hour: '%H:%M',
				day: '%m-%d',
				week: '%m-%d',
				month: '%Y-%m',
				year: '%Y'
			}
		},
		tooltip: {
			dateTimeLabelFormats: {
				millisecond: '%H:%M:%S.%L',
				second: '%H:%M:%S',
				minute: '%H:%M',
				hour: '%H:%M',
				day: '%Y-%m-%d',
				week: '%m-%d',
				month: '%Y-%m',
				year: '%Y'
			}
		},
		yAxis: {
			title: {
				text: '人数'
			}
		},
		legend: {
			enabled: false
		},
		plotOptions: {
			area: {
				fillColor: {
					linearGradient: {
						x1: 0,
						y1: 0,
						x2: 0,
						y2: 1
					},
					stops: [
						[0, new Highcharts.getOptions().colors[0]],
						[1, new Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
					]
				},
				marker: {
					radius: 2
				},
				lineWidth: 1,
				states: {
					hover: {
						lineWidth: 1
					}
				},
				threshold: null
			}
		},
		//console.log(data);
		series: [{
			type: 'area',
			name: '确诊病例',
			data: data
		}]
	});
});