var night = "#2F2F4C";
var maximum = "#C7504F";
var day = "#C0B48B";
var chartType = "column";
var chartText = "Активная энергия, прием (A+)";
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
				format : "{0} кВт"
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
$(function() {
	$("#select-energy").kendoMobileButtonGroup({
		select : function(e) {
			var index = this.current().index();
			switch (index) {
			case 0:
				sendParamEnergy(1);
				chartText = "Активная энергия, прием (A+)";
				createChart();

				break;
			case 1:
				sendParamEnergy(2);
				chartText = "Активная энергия, отдача (A-)";
				createChart();

				break;
			case 2:
				sendParamEnergy(3);
				chartText = "Реактивная энергия, прием (R+)";
				createChart();

				break;
			case 3:
				sendParamEnergy(4);
				chartText = "Реактивная энергия, отдача (R-)";
				createChart();

				break;
			}
		}
	});
});
$(function() {
	$("#select-interval").kendoMobileButtonGroup({
		select : function(e) {
			var index = this.current().index();
			switch (index) {
			case 0:
				sendParamEnergy(30);
				createChart();
				// kendoConsole.log("Интервал: 30 мин");
				break;
			case 1:
				sendParamEnergy(60);
				createChart();

				break;

			}
		}
	});
});

function sendParamEnergy(typeEnergy) {
	$.ajax({
		url : 'dispatch',
		data : ({
			paramEnergy : typeEnergy

		}),
		success : function(data) {

		}
	});

}
