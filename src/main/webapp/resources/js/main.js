var night = "#2F2F4C";
var maximum = "#C7504F";
var day = "#C0B48B";
var chartType = "column";
var chartText = "Мощность по интервалам за сутки";
function createChart() {

	$("#chart").kendoChart({

		dataSource : {
			transport : {

				read : {
					url : "gson",
					dataType : "json"
				}
			},
		},
		title : {
			align : "left",
			text : chartText
		},
		legend : {
			visible : false
		},
		seriesDefaults : {
			type : chartType,
			labels : {
				visible : false,
				background : "transparent"
			}
		},
		series : [ {
			type : chartType,
			pannable : true,
			field : "value",
			colorField : "color"
		} ],
		valueAxis : {

			majorGridLines : {
				visible : true
			},
			crosshair : {
				color : day,
				width : 1,
				dashType : "dot",
				visible : true
			},
			labels : {
				format : "{0}"
			},
			visible : true
		},
		categoryAxis : {

			field : "interval",
			labels : {
				rotation : "-45",
				step : 1
			},
			majorGridLines : {
				visible : true
			},
			crosshair : {
				color : day,
				width : 1,
				dashType : "dot",
				visible : true
			},
			line : {
				visible : true
			}
		},
		tooltip : {
			visible : true,
			format : "{0}%",
			template : "#= value #"
		}
	});
}

$(document).ready(function() {
	$("#prev").click();
	createChart();

});

$(document).bind("kendo:skinChange", createChart);
$(window).on("resize", function() {
	kendo.resize($(".chart-wrapper"));
});

function gystType() {

	chartType = "column";
	$("#gystChart").removeClass();
	$("#gystChart").addClass("k-button k-primary");
	$("#lineChart").removeClass();
	$("#lineChart").addClass("k-button");
	$("#areaChart").removeClass();
	$("#areaChart").addClass("k-button");
	createChart();

};

function lineType() {

	chartType = "line";
	$("#gystChart").removeClass();
	$("#gystChart").addClass("k-button");
	$("#lineChart").removeClass();
	$("#lineChart").addClass("k-button k-primary");
	$("#areaChart").removeClass();
	$("#areaChart").addClass("k-button");
	createChart();

};

function areaType() {

	chartType = "area";
	$("#gystChart").removeClass();
	$("#gystChart").addClass("k-button");
	$("#lineChart").removeClass();
	$("#lineChart").addClass("k-button");
	$("#areaChart").removeClass();
	$("#areaChart").addClass("k-button k-primary");
	createChart();

};


$(function() {
	$("#select-chart").kendoMobileButtonGroup({
		select : function(e) {
			var index = this.current().index();
			switch (index) {
			case 0:

				lineType();
				break;
			case 1:

				gystType();
				break;
			case 2:

				areaType();
				break;
			}
		}
	});
});


$(document).ready(function() {

	$("#prev").click(function() {

		$.ajax({
			url : 'prev',
			data : ({
				param : "prev"

			}),
			success : function(data) {
				var json = JSON.parse(data);
				$("#abonent").html(json[0]);
				$("#day").html(json[1]);
				$("#count").html(json[2]);
				$("#tarif").html(json[3]);
				$("#alpha").html(json[4]);
				$("#sum").html(json[5]);
				createChart();
			}
		});
	});
	$("#next").click(function() {

		$.ajax({
			url : 'next',
			data : ({
				param : "next"

			}),
			success : function(data) {
				var json = JSON.parse(data);
				$("#abonent").html(json[0]);
				$("#day").html(json[1]);
				$("#count").html(json[2]);
				$("#tarif").html(json[3]);
				$("#alpha").html(json[4]);
				$("#sum").html(json[5]);
				createChart();
			}
		});
	});
});
