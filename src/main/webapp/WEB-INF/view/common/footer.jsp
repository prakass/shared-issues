<%@include file="/helper/tags.jsp" %>
<% System.out.println("Visit record:"+request.getLocale()+"|"+request.getRemoteHost()+"|"+request.getRequestURI()+"|"+request.getMethod()); %>
	<%
		Object visits = request.getServletContext().getAttribute("visits");
		if (visits != null) {
			int visit = Integer.parseInt(visits.toString());
			visit = visit + 1;
			System.out.println(visit);
			request.getServletContext().setAttribute("visits", visit);
		} else {
			request.getServletContext().setAttribute("visits", 1);
		}
	%>
	<div class="content-box">
	<sec:authorize access="hasRole('SUPERADMIN')">	
		<span class="header-font2">Current total number of visits: <%=request.getServletContext().getAttribute("visits")%></span>
	</sec:authorize>
	</div>

<div id="footer">
		<div>
			
			<div style="width:400px;margin-top:0px;">
				<span class="header-font1">Contact us</span><br/>
				<span class="content-font1">Orientation project(2012)@Helsinki Metropolia University</span><br/>	
				<span class="content-font1">Kirstinharju 3 C 37,Espoo Finland</span><br/>
				<span>+358417040062</span><br/>
				<div class="clear2"></div>		
			</div>	
			<div style="width:300px;">
				&copy Copyright 2012. All rights reserved
			</div>	
		</div>
	</div>
<%@include file="/helper/scripts.jsp" %>
</body>
</html>