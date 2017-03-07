<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<title>Главная</title>
   <div id="global">
            <div class="container-fluid cm-container-white">
                <h2 style="margin-top:0;">Расчет</h2>
                <p>Портал осуществляет расчет интервально-дифференцированного тарифа предприятия</p>
            </div>
            <div class="container-fluid">
                <div class="row cm-fix-height">
                    
                    <div class="col-xs-6 col-sm-6 col-md-3 col-lg-2">
                        <a href="graphPage" class="panel panel-default thumbnail cm-thumbnail">
                            <div class="panel-body text-center">
                                <span class="fa fa-bar-chart"></span>
                                <h4>Графики</h4> <small>Графический анализ нагрузки на энергосистему</small>
                            </div>
                        </a>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-3 col-lg-2">
                        <a href="calcPage" class="panel panel-default thumbnail cm-thumbnail">
                            <div class="panel-body text-center">
                                <span class="fa fa-calculator"></span>
                                <h4>Расчеты</h4> <small>Расчет прогнозных показателей предприятия</small>
                            </div>
                        </a>
                    </div>
                    
                    
                </div>
            </div>