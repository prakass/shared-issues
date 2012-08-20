<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table id="user-list">
	<thead>
		<tr>
			<th>Full name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="person" items="${persons}" >
		<tr>
			<td>${person.userSalutation} ${person.firstName} ${person.lastName}</td>
			<td>${person.email}</td>
			<td>${person.city}</td>
			<td>
				<a href="/action/users/edit-user?email=${person.email}"><img src="/resources/images/icons/edit-3.jpg" class="action-icon" title="Edit this user"/> </a>
				<a href="/action/users/remove-user?email=${person.email}"><img src="/resources/images/icons/delete-4.png" class="action-icon" title="Remove this user"/></a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>