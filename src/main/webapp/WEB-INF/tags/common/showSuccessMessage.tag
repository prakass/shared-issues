<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="message"%>
<c:if test="${sessionScope['success-message']!=null}">
	<c:if test="${message!=null}">
		<span class="success-message">${message}</span>
	</c:if>
	<c:if test="${message==null}">
		<span class="success-message">${sessionScope['success-message']}</span>
	</c:if>
</c:if>
<% request.getSession().removeAttribute("success-message"); %>