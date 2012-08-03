<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="message"%>
<c:if test="${sessionScope['server-error']!=null}">
	<c:if test="${message!=null}">
		<p style="color:red;">${message}</p>
	</c:if>
	<c:if test="${message==null}">
		<p style="color:red;">${sessionScope['server-error']}</p>
	</c:if>
</c:if>
<% request.getSession().removeAttribute("server-error"); %>