<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Begin page content -->
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<form name='form_login' class="form-signin"
				action="j_spring_security_check" method="POST">
				<h4 class="form-signin-heading">Авторизация</h4>
				<label for="inputEmail" class="sr-only">Логин</label> <input
					id="inp" type="text" name="inputlogin"
					class="form-control form-margin input-sm" placeholder="Ваш логин" required
					autofocus> <label for="inputPassword" class="sr-only">Пароль</label>
				<input type="password" name="inputPassword"
					class="form-control form-margin input-sm" placeholder="Ваш пароль" required>
				<div class="checkbox">
					<label> <input name="remember_me" type="checkbox">
						Запомнить меня
					</label>
				</div>

				<button class="btn btn-lg btn-primary btn-block" type="submit">
					<span class="glyphicon glyphicon-log-in"></span> Вход
				</button>
				<c:if test="${not empty error}">

					<div class="alert alert-danger form-margin">${error}<br>
						<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
							<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
						</c:if>
						
					</div>
				</c:if>				
			</form>
		</div>
		<!-- /col-md-12 -->
		
	</div>
	<!-- /row -->
</div>
<!-- /container -->

