<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags/common"  prefix="si"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="personProfile" value="${sessionScope['current.person']}"/>
<c:set var="tab" value="${sessionScope['tab']}"/>
<!DOCTYPE html>
<!-- Template by freewebsitetemplates.com -->
<html>
<head>
<%@include file="/helper/styles.jsp" %>
<meta charset="utf-8" />
<title>Shared tasks</title>
<link rel="SHORTCUT ICON" href="/resources/images/logo1.png" type="image/x-icon" />
</head>
<body>
	<div id="user-account-top" class="menu-container" >
	<ul class="menu-items" id="login-logout">
		<c:if test="${sessionScope['current.person']==null && param['login']==null}">
			<li id="login-button"><a href="login.jsp?login=true"><span>Login</span></a></li><span>
		</c:if>
		<c:if test="${sessionScope['current.person']!=null}">
					<p>Welcome!<a href="/action/profile" id="profile-link"> ${personProfile.userSalutation} ${personProfile.firstName} ${personProfile.lastName}</a></p>
					<a class="logout" href="/logout">Logout</a>
		</c:if>
	</ul>
	</div>
	<div class="top-header menu-container">
			<div id="logo">
				<a href="/"><img src="/resources/images/logo1.png" alt="" /></a>		
			</div>
				<sec:authorize access="hasRole('USER') or hasRole('ADMIN') or hasRole('SUPERADMIN')">	
			<ul class="menu-items">
				<li <c:if test="${tab eq 'issues'}">class="selected"</c:if>><a href="/action/issues/index"><span>Dashboard</span></a></li>
				<sec:authorize access="hasRole('ADMIN') or hasRole('SUPERADMIN')">
					<li <c:if test="${tab eq 'users'}">class="selected"</c:if>><a href="/action/users/all-users"><span>USERS</span></a></li>
				</sec:authorize>
				<li <c:if test="${tab eq 'profile'}">class="selected"</c:if>><a href="/action/profile"><span>MY PROFILE</span></a></li>
				<sec:authorize access="hasRole('ADMIN') or hasRole('SUPERADMIN')">
					<li <c:if test="${tab eq 'files'}">class="selected"</c:if>><a href="/action/image/all-images"><span>IMAGES</span></a></li>
				</sec:authorize>
				<li <c:if test="${tab eq 'contact'}">class="selected"</c:if>><a href="/action/contact"><span>CONTACT</span></a></li>	
			</ul>
			</sec:authorize>	
	</div>
	<div id="submenu-container">
		<si:showSuccessMessage/>
		<si:showServerError/>
		<c:if test="${tab eq 'users'}">
			<a class="logout" href="/action/users/add-user">Add new account</a>
			 <span class="logout">|</span>
			 <a class="logout" href="/action/users/configure-roles">Configure roles</a> 
		</c:if>
		<c:if test="${tab eq 'issues'}">
			<a class="logout" href="/action/issues/create">Create new task</a>
		</c:if>
		<c:if test="${tab eq 'profile'}">
			<a href="/action/edit-profile" class="logout">Edit my profile </a><span class="logout">|</span>
			<a href="/action/change-password" class="logout"> Change my password</a>
		</c:if>
	</diV>
