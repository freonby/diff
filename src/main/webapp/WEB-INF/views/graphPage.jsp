<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<title>graphPage</title>
<div id="global">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-info">
					<div class="panel-heading">Эффективность 1</div>
					<div class="panel-body">
						<div id="d1-c1" style="height: 150px"></div>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-info">
					<div class="panel-heading">Эффективность 2</div>
					<div class="panel-body">
						<div id="d1-c2" style="height: 150px"></div>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-info">
					<div class="panel-heading">Эффективность 3</div>
					<div class="panel-body">
						<div id="d1-c3" style="height: 150px"></div>
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