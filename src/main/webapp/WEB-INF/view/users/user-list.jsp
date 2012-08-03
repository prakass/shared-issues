<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<thead>
		<tr>
			<td>Full name</td>
			<td>Email</td>
			<td>Address</td>
			<td>Actions</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="person" items="${persons}" >
		<tr>
			<td>${person.userSalutation} ${person.firstName} ${person.lastName}</td>
			<td>${person.email}</td>
			<td>${person.city}</td>
			<td>
				<a href="/action/users/edit-user?email=${person.email}"><button>Edit this user</button></a>
				<a href="/action/users/remove-user?email=${person.email}"><button>Remove this user</button></a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>