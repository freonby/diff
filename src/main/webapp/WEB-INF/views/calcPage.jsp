<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<title>Данные</title>
<div id="global">
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Энергосистема</div>

					<table class="table">
						<thead>
							<tr>
								<th>Интервал</th>
								<th>Мощность</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="itemEs" items="${esList}">
								<tr>
									<td>${itemEs.intervalNumber}</td>
									<td>${itemEs.consumption}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Потребитель</div>
					<table class="table">
						<thead>
							<tr>
								<th>Интервал</th>
								<th>Мощность</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="itemAb" items="${abList}">
								<tr>
									<td>${itemAb.intervalNumber}</td>
									<td>${itemAb.consumption}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>