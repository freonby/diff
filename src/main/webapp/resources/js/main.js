var night = "#2F2F4C";
var maximum = "#C7504F";
var day = "#C0B48B";
var chartType = "line";
var chartText = "Мощность по интервалам за сутки в относительных единицаx";
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
			align : "center",
			text : chartText
		},
		legend : {
			visible : true,
			position:"top"
		},
		seriesDefaults : {
			type : chartType,
			stack: false,
			labels : {
				visible : false,
				background : "transparent"
			}
		},
		series : [ {
			type : chartType,
			pannable : true,
			field : "abValue",
			name: "потребитель",
			
			
		},{
			type : chartType,
			pannable : true,
			field : "esValue",
			name: "энергосистема",
			
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
	initWidgets();

});
function initWidgets(){
	$.ajax({
		url : 'nav',
		data : ({
			direction : "begin"

		}),
		success : function(data) {
			addToPanel(data);
			createChart();
		}
	});
}
$(window).on("resize", function() {
	kendo.resize($(".chart-wrapper"));
});




$(document).ready(function() {
	$("#slider").kendoSlider({
		showButtons:false,
		tickPlacement:"bottomRight",
        min: 0,
        max: 10,
        smallStep: 1,
        largeStep: 1,
        change: function() {
            var value = this.value();
            sendSliderValue(value);
        }
    });
	$("#alignGraph").click(function() {
		//resetSlider();
		$.ajax({
			url : 'balanceGraph',		
			success : function(data) {
				addToPanel(data);
				createChart();				
			}
		});
	});
	
	$("#prev").click(function() {
		//resetSlider();
		$.ajax({
			url : 'nav',
			data : ({
				direction : "prev"

			}),
			success : function(data) {
				addToPanel(data);
				createChart();
			}
		});
	});
	$("#next").click(function() {
		//resetSlider();
		$.ajax({
			url : 'nav',
			data : ({
				direction : "next"

			}),
			success : function(data) {
				addToPanel(data);
				createChart();
			}
		});
	});
	$("#begin").click(function() {
		//resetSlider();
		$.ajax({
			url : 'nav',
			data : ({
				direction : "begin"

			}),
			success : function(data) {
				addToPanel(data);
				createChart();
			}
		});
	});
	$("#end").click(function() {
		//resetSlider();
		$.ajax({
			url : 'nav',
			data : ({
				direction : "end"

			}),
			success : function(data) {
				addToPanel(data);
				createChart();
			}
		});
	});
	$("#line").click(function() {
		chartType = "line";
		createChart();
	});
	$("#gyst").click(function() {
		chartType = "column";
		createChart();
	});
	$("#area").click(function() {
		chartType = "area";
		createChart();
	});
	
	
});
function addToPanel(data){
	var json = JSON.parse(data);
	$("#abonent").html(json[0]);
	$("#day").html(json[1]);
	$("#count").html(json[2]);
	$("#tarif").html(json[3]);
	$("#alpha").html(json[4]);
	$("#sum").html(json[5]);
	$("#consum").html(json[6]);
	$("#tarifmin").html(json[7]);
	$("#tarifmax").html(json[8]);
}
function sendSliderValue(sliderValue){
	$.ajax({
		url : 'slider',
		data : ({
			value : sliderValue

		}),
		success : function(data) {
			addToPanel(data);
			createChart();
			
		}
	});
}
function updatePane(){
	$.ajax({
		url : 'update',
		
		success : function(data) {
			addToPanel(data);
			
		}
	});
}
function resetSlider(){
	var slider = $("#slider").data("kendoSlider");
	slider.value(0);
	
}

function pingSession(){
	$.ajax({
		url : 'closeSession',
		data : ({
			optionClose : "close"

		}),

	});
	
}
