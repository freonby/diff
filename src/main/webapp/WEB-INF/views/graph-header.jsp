<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<header id="cm-header">
	<nav class="cm-navbar cm-navbar-primary">
		<div class="btn btn-primary md-menu-white hidden-md hidden-lg"
			data-toggle="cm-menu"></div>
		<div class="cm-flex">
			<h1>График нагрузки</h1>
		</div>
		<c:import url="profile-menu.jsp"></c:import>


	</nav>
	<nav class="cm-navbar cm-navbar-default cm-navbar-slideup">
		<div class="pull-left" style="border-right: 1px solid #e5e5e5">
			<a id="gyst" class="btn btn-default btn-light "><i
				class="fa fa-bar-chart red" aria-hidden="true"></i></a>
		</div>
		<div class="pull-left" style="border-right: 1px solid #e5e5e5">
			<a id="line" class="btn btn-default btn-light "><i
				class="fa fa-line-chart" aria-hidden="true"></i></a>
		</div>


		<div class="pull-right" style="border-left: 1px solid #e5e5e5">
			<a id="begin" class="btn btn-default btn-light "><i
				class="fa fa-angle-double-left" aria-hidden="true"></i></a>
		</div>
		<div class="pull-right" style="border-left: 1px solid #e5e5e5">
			<a id="prev" class="btn btn-default btn-light "><i
				class="fa fa-arrow-left" aria-hidden="true"></i></a>
		</div>
		<div class="pull-right" style="border-left: 1px solid #e5e5e5">
			<a id="next" class="btn btn-default btn-light "><i
				class="fa fa-arrow-right" aria-hidden="true"></i></a>
		</div>
		<div class="pull-right" style="border-left: 1px solid #e5e5e5">
			<a id="end" class="btn btn-default btn-light "><i
				class="fa fa-angle-double-right" aria-hidden="true"></i></a>
		</div>
	</nav>
</header>