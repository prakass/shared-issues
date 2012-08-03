<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="/helper/tags.jsp"%>
	<div style="display:none;">
		<form:input path="profilePicture"/>
	</div>
	<table>
		<tr>
			<td>Your first name</td>
			<td><form:input path="firstName"/> </td>
		</tr>
		<tr>
			<td>Your last name</td>
			<td><form:input path="lastName"/> </td>
		</tr>
		<tr>
			<td>Select Salutation</td>
			<td>
				<form:select path="userSalutation">
					<form:option value="Mr">Mr</form:option>
					<form:option value="Mrs">Mrs</form:option>
					<form:option value="Dear">Dear</form:option>
					<form:option value="Er">Er</form:option>
					<form:option value="Dr">Dr</form:option>
				</form:select>
			 </td>
		</tr>
		<tr>
			<td>Your email <br/>(This will be used as username)</td>
			<td><form:input path="email"/> </td>
		</tr>
		
		<tr>
			<td>Select your password</td>
			<td><form:password path="password"/> </td>
		</tr>
		
		<tr>
			<td>Confirm you password</td>
			<td><input name="password1"/> </td>
		</tr>
		<tr>
			<td>Your address</td>
			<td><form:input path="address"/> </td>
		</tr>
		<tr>
			<td>Your city</td>
			<td><form:input path="city"/> </td>
		</tr>
		<tr>
			<td>Your zipcode</td>
			<td><form:input path="zipCode"/> </td>
		</tr>
		<tr>
			<td>Select country</td>
			<td><form:input path="country"/> </td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit"  value="Submit" class="button"> </td>
		</tr>
	</table>
