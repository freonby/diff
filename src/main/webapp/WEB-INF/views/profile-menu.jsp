<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="dropdown pull-right">
	<button class="btn btn-primary" data-toggle="dropdown">
		<i class="fa fa-user" aria-hidden="true"></i>
	</button>
	<ul class="dropdown-menu">
		<li class="disabled text-center"><a style="cursor: default;"><strong>
					${username}</strong></a></li>
		<li class="divider"></li>
		
		<li class="text-center"><a href="logout"><i class="fa fa-sign-out"
				aria-hidden="true"></i> Выход</a></li>
	</ul>
</div>