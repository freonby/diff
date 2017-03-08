<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<body class="${bodyClass}">
        <div id="cm-menu">
            <nav class="cm-navbar cm-navbar-primary">
                <div class="cm-flex"><a href="index.html" class="cm-logo"></a></div>
               <div class="btn btn-primary" data-toggle="cm-menu"><i class="fa fa-bars" aria-hidden="true"></i></div>
            </nav>
            <div id="cm-menu-content">
                <div id="cm-menu-items-wrapper">
                    <div id="cm-menu-scroller">
                        <ul class="cm-menu-items">
                             <li><a href="userPage" class="btn btn-default"><i class="fa fa-list" aria-hidden="true"></i>Разделы</a></li>
                            <li><a href="calcPage" class="btn btn-default"><i class="fa fa-calculator" aria-hidden="true"></i> Данные</a></li>
                            <li><a href="graphPage" class="btn btn-default"><i class="fa fa-pie-chart" aria-hidden="true"></i> График</a></li>
                            <li><a href="logout" class="btn btn-default"><i class="fa fa-sign-out" aria-hidden="true"></i> Выход</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
