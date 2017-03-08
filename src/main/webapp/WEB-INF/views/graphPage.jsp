<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<title>График нагрузки</title>
<div id="global">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-heading">Информация об объекте</div>
					<table class="table">
						<tbody>
							<tr>
								<td>Потребитель</td>
								<td><strong><i id="abonent"></i></strong></td>
							</tr>
							<tr>
								<td>Дата</td>
								<td>06.03.2017</td>
							</tr>
							<tr>
								<td>Мощность за сутки</td>
								<td><strong><i id="consum"></i></strong> кВт</td>
							</tr>
							<tr>
								<td>Минимальный тариф</td>
								<td><strong><i id="tarifmin"></i></strong> BYN/кВт</td>
							</tr>
							<tr>
								<td>Максимальный тариф</td>
								<td><strong><i id="tarifmax"></i></strong> BYN/кВт</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-heading">Данные расчета</div>
					<table class="table">
						<tbody>
							<tr>
								<td>Сутки</td>
								<td><strong><i id="day"></i>/<i id="count"></i></strong></td>
							</tr>
							<tr class="success">
								<td>Ежесуточный тариф</td>
								<td><strong><i id="tarif"></i></strong> BYN/кВт</td>
							</tr>
							<tr>
								<td>Коэффициент &alpha;</td>
								<td><strong><i id="alpha"></i></strong></td>
							</tr>
							<tr class="info">
								<td>Оплата по тарифу</td>
								<td><strong><i id="sum"></i></strong> BYN</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<button id="gyst" class="btn btn-primary btn-md" title="Гистограмма">
									<i class="fa fa-bar-chart" aria-hidden="true" ></i>
								</button>
								<button id="line" class="btn btn-primary btn-md" title="Линейный график">
									<i class="fa fa-line-chart" aria-hidden="true"></i>
								</button>
								<button id="area" class="btn btn-primary btn-md" title="График по площади">
									<i class="fa fa-area-chart" aria-hidden="true"></i>
								</button>
								<button id="alignGraph" class="btn btn-primary btn-md" title="Выравнивание графика">
									<i class="fa fa-arrows-h" aria-hidden="true"></i>
								</button>
								
							</div>

						</div>
					</div>
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								Регулирование нагрузки <i class="fa fa-percent"
									aria-hidden="true"></i>
							</div>
							<div class="panel-body">
								<div class="chart-wrapper">
									<input id="slider" class="balSlider" value="0" />
								</div>
							</div>

						</div>
					</div>

				</div>
			</div>
			
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">Суточный график нагрузки</div>
			<div class="panel-body">
				<div class="chart-wrapper">
					<div id="chart"></div>
				</div>
			</div>
		</div>


	</div>