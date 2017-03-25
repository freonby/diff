<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<title>Авторизация в системе</title>
<body class="cm-login">

	<div class="text-center"
		style="padding: 90px 0 30px 0; background: #fff; border-bottom: 1px solid #ddd">
		<p>Авторизация в системе</p>
	</div>
	<div class="col-sm-6 col-md-4 col-lg-3"
		style="margin: 40px auto; float: none;">
		<form method="post" action="j_spring_security_check" method="POST">
			<div class="col-xs-12">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-fw fa-user"></i>
						</div>
						<input type="text" name="inputLogin" class="form-control"
							placeholder="Логин">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-fw fa-lock"></i>
						</div>
						<input type="password" name="inputPassword" class="form-control"
							placeholder="Пароль">
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="checkbox">
					<label><input type="checkbox" name="remember_me">
						Запомнить меня</label>
				</div>
			</div>
			<div class="col-xs-6">
				<button type="submit" class="btn btn-block btn-primary">Вход</button>
			</div>
			<c:if test="${not empty error}">
				<div class="alert alert-danger form-margin">${error}<br>
					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</c:if>
				</div>
			</c:if>
		</form>
		
	</div>