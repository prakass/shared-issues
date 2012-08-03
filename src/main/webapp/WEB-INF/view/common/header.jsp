<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags/common"  prefix="si"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
	<head>
		<link  rel="stylesheet" type="text/css" href="/resources/css/custom.css"/>
		<script type="text/javascript" src="/resources/js/library.js"></script>
		<script type="text/javascript" src="/resources/js/custom.js"></script>
		<style type="text/css">
		</style>
	</head>
	<body>
	<c:set var="person" value="${sessionScope['current.person']}"/>
	<div>
		<label>Hello !</label>${person.userSalutation} ${person.firstName} ${person.lastName}
	</div>
	<ul>
		<li><a href="/logout">Logout</a> </li>
		<li><a href="/action/profile">My profile</a> </li>
	</ul>
	<div>
		<ul>
		<security:authorize access="hasRole('SUPERADMIN') or hasRole('ADMIN')">
		<li>
		<span>Users</span>
		<ul>
			<li>
				<a href="/action/users/add-user">Add new user</a>
			</li>
			<li>
				<a href="/action/users/all-users">All users</a>
			</li>
			<li>
				<a href="/action/users/search-user">Search users</a>
			</li>
			<li>
				<a href="/action/users/configure-roles">Configure roles</a>
			</li>
		</ul>
		</li>
		</security:authorize>
		<li>
			<span><a href="/action/issues">Issues</a></span>
			<ul>
				<li><a href="/action/issues/index">Dashboard</a></li>
				<li><a href="/action/issues/create">Create new issue</a></li>
				<li><a href="/action/issues/search">Search issue</a></li>
				<li><a href="/action/issues/issue-board">Issue board</a></li>
			</ul>
		</li>
		<li>
			<span><a href="/action/image/all-images">Files</a></span>
		</ul>
	</div>
	