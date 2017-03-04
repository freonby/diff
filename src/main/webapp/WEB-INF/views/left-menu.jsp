<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<body class="${bodyClass}">
        <div id="cm-menu">
            <nav class="cm-navbar cm-navbar-primary">
                <div class="cm-flex"><a href="index.html" class="cm-logo"></a></div>
                <div class="btn btn-primary md-menu-white" data-toggle="cm-menu"></div>
            </nav>
            <div id="cm-menu-content">
                <div id="cm-menu-items-wrapper">
                    <div id="cm-menu-scroller">
                        <ul class="cm-menu-items">
                            <li class="active"><a href="userPage" class="sf-file-text">Разделы</a></li>
                            <li><a href="calcPage" class="sf-calculator">Расчеты</a></li>
                            <li><a href="graphPage" class="sf-monitor">График нагрузки</a></li>
                            <li><a href="logout" class="sf-lock-open">Выход</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
