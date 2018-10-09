<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stop</title>
<style>
.button{
    border-left-width: 0px;
    width: 108px;
    height: 27px;
    padding-left: 0px;
    margin-left: 0px;
    background-color : #F5BE0A;
}
</style>
</head>

<body>
				       		  					
				       		  		<form id="stopForm" action="${pageContext.request.contextPath}/route/addNewStops">
												<div>
													<label>Route No.</label>&nbsp;&nbsp;&nbsp;
													<input type="text" name="routeId" id="routeId" value="${routeId}" style="width: 114px;" readonly>
												</div>
												
												<br>
												<div >
													<label>Stop No.</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<input type="text" name="stopNo" id="stopNo" value= "${stopCounter}" style="width: 114px;" readonly>
												</div>
												<br>
												<div>
													
													<B>Stop Name: </B><input type="text" name="stopName" id="stopName" style="width: 114px;">
												</div>
												<div >
												<br>
											<label>Latitude: </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="text" name="latitude" id="latitude"  style="width: 114px;">
												</div>
											<br>	
											<div>
											<label>Longitude: </label>&nbsp;&nbsp;
												<input type="text" name="longitude" id="longitude" style="width: 114px;">
												</div>
												
											<br>
											
											<input type="submit" class="button" value="Add" style="margin-left: 85px;" >
				       					
				       					</form>

<script>
/* function addStop(){
	
	var routeNo=$('#routeId').val();
	var stopNo=$('#stopNo').val();
	var stopName=$('#stopName').val();
	var latitude=$('#latitude').val();
	var longitude=$('#longitude').val();
	
	var data=routeNo+","+stopNo+","+stopName+","+latitude+","+longitude;
	
	var formData="data="+data;
	 $.ajax({
		    type : "POST",
		    url : "${pageContext.request.contextPath}/route/addNewStops",
		    data : formData,
		    success : function(response) {	       
		       alert("Stop Added Successfully");
		    },
		    error : function(e) {
		       alert('Error: ' + e);
		    }
		});
	
} */
</script>
</body>
</html>
