<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags/common"  prefix="si"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<c:set var="personProfile" value="${sessionScope['current.person']}"/>
<!DOCTYPE html>
<!-- Template by freewebsitetemplates.com -->
<html>
<head>
<%@include file="/helper/style-script.jsp" %>
<meta charset="utf-8" />
<title>Shared issues</title>
</head>
<body>
	<div id="user-account-top" class="menu-container" >
	<ul class="menu-items" id="login-logout">
		<c:if test="${sessionScope['current.person']==null && param['login']==null}">
			<li id="login-button"><a href="login.jsp?login=true"><span>Login</span></a></li><span>
		</c:if>
		<c:if test="${sessionScope['current.person']!=null}">
					<p>Welcome!<a href="/action/profile" id="profile-link"> ${personProfile.userSalutation} ${personProfile.firstName} ${personProfile.lastName}</a></p>
					<a id="logout" href="/logout">Logout</a>
		</c:if>
	</ul>
	</div>
	<div class="top-header menu-container">
			<div id="logo">
				<a href="/"><img src="/resources/images/logo1.png" alt="" /></a>		
			</div>
			<security:authorize access="hasRole('USER') or hasRole('ADMIN') or hasRole('SUPERADMIN')">	
			<ul class="menu-items">
				<security:authorize access="hasRole('ADMIN') or hasRole('SUPERADMIN')">
					<li class="selected"><a href="/action/users/all-users"><span>USERS</span></a></li>
				</security:authorize>
				<li><a href="/action/issues/index"><span>ISSUES</span></a></li>
				<li><a href="/action/profile"><span>MY PROFILE</span></a></li>
				<security:authorize access="hasRole('ADMIN') or hasRole('SUPERADMIN')">
					<li><a href="/action/image/all-images"><span>FILES</span></a></li>
				</security:authorize>
				<li><a href="/action/contact"><span>CONTACT ADMIN</span></a></li>	
			</ul>
			</security:authorize>	
	</div>
