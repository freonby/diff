<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 		<header id="cm-header">
            <nav class="cm-navbar cm-navbar-primary">
                <div class="btn btn-primary md-menu-white hidden-md hidden-lg" data-toggle="cm-menu"></div>
                <div class="cm-flex">
                    <h1>graphPage</h1> 
                    
                </div>
               
              
                <div class="dropdown pull-right">
                    <button class="btn btn-primary md-account-circle-white" data-toggle="dropdown"></button>
                    <ul class="dropdown-menu">
                        <li class="disabled text-center">
                            <a style="cursor:default;"><strong>User</strong></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-cog"></i> Settings</a>
                        </li>
                        <li>
                            <a href="login.html"><i class="fa fa-fw fa-sign-out"></i> Sign out</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <nav class="cm-navbar cm-navbar-default cm-navbar-slideup">
                <div class="cm-flex">
                    <div class="nav-tabs-container">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#">График 1</a></li>
                            <li><a href="#">График 2</a></li>
                            <li><a href="#">График 3</a></li>
                        </ul>
                    </div>
                </div>
               <div class="pull-right" style="border-left:1px solid #e5e5e5"><a id="prev" class="btn btn-default btn-light "><i class="fa fa-arrow-left" aria-hidden="true"></i></a></div>
               <div class="pull-right" style="border-left:1px solid #e5e5e5"><a id="next" class="btn btn-default btn-light "><i class="fa fa-arrow-right" aria-hidden="true"></i></a></div>
            </nav>
        </header>