<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="message"%>
<c:if test="${sessionScope['server-error']!=null}">
	<c:if test="${message!=null}">
		<span class="error-message">${message}</span>
	</c:if>
	<c:if test="${message==null}">
		<span class="error-message">${sessionScope['server-error']}</span>
	</c:if>
</c:if>
<% request.getSession().removeAttribute("server-error"); %>