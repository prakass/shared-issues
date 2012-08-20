<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<span>Select user and configure roles</span>
</div>
<div class="content-content">
<p class="header-font2">Select user</p>
<form action="configure-roles" method="post">
<select id="user-list" name="email">
	<c:forEach var="person" items="${persons}">
		<option value="${person.email}">${person.email}</option>
	</c:forEach>
</select>
<p class="header-font2">Select roles to configure</p>
<select id="role-list" name="roles" multiple="multiple">
		<option id="SUPERADMIN" value="SUPERADMIN">Superadmin</option>
		<option id="ADMIN" value="ADMIN">Admin</option>
		<option id="USER" value="USER">User</option>
</select>
<div>Current roles:<div id="current-roles"></div></div>
<div class="clear"></div>
<br/>
<button type="submit" class="button">SUBMIT</button>
</form>
</div>
</div>
<script>
	var email = $('#user-list option:selected').val();
	$('#user-list').change(function(){
		loadUserRolesAndAppendToRoleList();
	});
	
	function loadUserRolesAndAppendToRoleList(){
		var email = $('#user-list option:selected').val();
		$('#role-list option').each(function(){
			$(this).removeAttr('selected');
		});
		$.ajax({
			  type: "get",
			  url: "get-roles",
			  data: {email:email},
			  success: function(result) {
				  var array = result.split(':');
				  for(item in array){
					  var val =array[item];
					  if(val=='SUPERADMIN'){
						  $('#role-list option#SUPERADMIN').attr('selected','selected');
					  }
					  if(val=='USER'){
						  $('#role-list option#USER').attr('selected','selected');
					  }
					  if(val=='ADMIN'){
						  $('#role-list option#ADMIN').attr('selected','selected');
					  }
				  }
			  }
		});

	}
	
	$(document).ready(function(){
		loadUserRolesAndAppendToRoleList();
	});
</script>
<%@include file="../common/footer.jsp"%>