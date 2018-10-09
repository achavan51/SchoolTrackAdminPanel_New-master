<ul class="nav navbar-nav">
	<li id="homeActive" ><a href="${pageContext.request.contextPath}/admin/home">Home</a></li>
	<li id="schoolsActive" ><a href="${pageContext.request.contextPath}/admin/schoolList">Schools</a></li>
 	<li id="schoolAdminActive" ><a href="${pageContext.request.contextPath}/admin/schoolAdmin">School Admin</a></li>
	<li id="reportActive" ><a href="${pageContext.request.contextPath}/admin/reports">Reports</a></li>
	<li id="settingActive" ><a href="${pageContext.request.contextPath}/admin/settings">Settings</a></li>
</ul>

<script>
$(function(){
	if("${homeActive}" == 'homeActive'){
		$("#homeActive").addClass("active");
	}else if("${schoolsActive}" == 'schoolsActive'){
		$("#schoolsActive").addClass("active");
	}else if(("${schoolAdminActive}" == 'schoolAdminActive')){
		$("#schoolAdminActive").addClass("active");
	}else if(("${reportActive}" == 'reportActive')){
		$("#reportActive").addClass("active");
	}else if(("${settingActive}" == 'settingActive')){
		$("#settingActive").addClass("active");
	}
	
})
</script>