<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="/helper/tags.jsp"%>
	<div style="display:none;">
		<form:input path="profilePicture"/>
	</div>
	<table class="form-table">
		<tr>
			<td>Your first name</td>
			<td><form:input path="firstName" class="required"/> </td>
		</tr>
		<tr>
			<td>Your last name</td>
			<td><form:input path="lastName" class="required"/> </td>
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
		<tr <c:if test="${person.email!=null}">style="display:none;"</c:if>>
			<td>Your email <br/>(This will be used as username)</td>
			<td><form:input path="email" class="required email"/> </td>
		</tr>
		<tr <c:if test="${person.email!=null}">style="display:none;"</c:if>>
			<td>Select your password</td>
			<td><input type="password" name="password1" id="password1" class="required" minlength="6"/> </td>
		</tr>
		
		<tr <c:if test="${person.email!=null}">style="display:none;"</c:if>>
			<td>Confirm you password</td>
			<td><input name="password2" type="password" class="required" minlength="6" equalTo="#password1"/> </td>
		</tr>
		
		<c:if test="${person.email!=null}">
			<tr style="display:none;"></tr>
		</c:if>
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
			<td><button type="submit"  class="button">SUBMIT</button> </td>
		</tr>
	</table>
	<c:if test="${person.email!=null}">
		<form:input path="password" cssStyle="display:none;"/>
	</c:if>
	<script>
		$('form').validate();
	</script>