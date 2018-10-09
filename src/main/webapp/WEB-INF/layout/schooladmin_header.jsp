<ul class="nav navbar-nav long">
	<li id="homeActive" onclick="homeActive()"><a href="${pageContext.request.contextPath}/schoolAdmin/home">Home</a></li>
	<li id="routesActive"   onclick="routesActive()"><a href="${pageContext.request.contextPath}/route/routeMap">Routes</a></li>
  	<li id="parentActive" ><a href="${pageContext.request.contextPath}/schoolAdmin/parentList">Parents</a></li>
	<li id="studentActive"><a href="${pageContext.request.contextPath}/schoolAdmin/studentList">Students</a></li>
	<li id="vehicleActive"><a href="${pageContext.request.contextPath}/route/busList">Vehicles</a></li>
 	<li id="driverActive"><a href="${pageContext.request.contextPath}/route/driverList">Drivers</a></li>
 	<li id="extintorActive"><a href="${pageContext.request.contextPath}/extintor/extintorList">Extintor</a></li>
 	<li id="newsSletterActive"><a href="${pageContext.request.contextPath}/newsletter/newsletterList">Newsletter</a></li>
 	<li id="deviceActive"><a href="${pageContext.request.contextPath}/device/deviceList">Device</a></li>
</ul>
<script type="text/javascript">
$(function(){
	if("${homeActive}" == 'homeActive'){
		$("#homeActive").addClass("active");
	}else if("${routesActive}" == 'routesActive'){
		$("#routesActive").addClass("active");
	}else if(("${parentActive}" == 'parentActive')){
		$("#parentActive").addClass("active");
	}else if(("${studentActive}" == 'studentActive')){
		$("#studentActive").addClass("active");
	}else if(("${vehicleActive}" == 'vehicleActive')){
		$("#vehicleActive").addClass("active");
	}else if(("${driverActive}" == 'driverActive')){
		$("#driverActive").addClass("active");
	}else if(("${extintorActive}" == 'extintorActive')){
		$("#extintorActive").addClass("active");
	}else if(("${newsSletterActive}" == 'newsSletterActive')){
		$("#newsSletterActive").addClass("active");
	}else if(("${deviceActive}" == 'deviceActive')){
		$("#deviceActive").addClass("active");
	}
	
})
</script>

