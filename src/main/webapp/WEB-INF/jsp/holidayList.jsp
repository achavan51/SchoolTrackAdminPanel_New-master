<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>

 <meta name="viewport" content="width=device-width, initial-scale=1">


<script>

$(function(){
    $('#browse_app').click(function(){
        window.location='addHoliday';
    });
});

</script>

<script type="text/javascript">

$(document).ready(function() {
    $('#example').DataTable();
} );



function edit(id){
	var id = id;
	window.location.href = "editHoliday?id="+id;
	}
	
function deletel(id){
	//alert("delete "+id);
	var id = id;
	window.location.href = "deleteHoliday?id="+id;
}	
</script>

</head>
<body >
<button id="btn"  class="open-AddBookDialog btn btn-primary" type="button" onClick="showBtn()" >Delete</button>
<button  class="open-AddBookDialog btn btn-primary" data-toggle="modal"  data-id=""  data-target="#forHolidayRegistration">Add Holiday</button>
<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
            	<th>DELETE</th>
                <th>Title</th>
                <th>Date</th>
                <th>Description</th>
                <th>DETAILS</th>
            </tr>
        </thead>
 
        <tfoot>
            <tr>
            	<th>DELETE</th>
                <th>Title</th>
                <th>Date</th>
                <th>Description</th>
                <th>DETAILS</th>
                
            </tr>
        </tfoot>
 
        <tbody>
        <c:forEach var="holiday" items="${holidayList}">
            <tr>
  					<td>
          				  <input type="checkbox" id="${holiday.holidayId}"  name="myTextEditBox" value="" onClick="displayNote(event)"/> Delete
        			</td>
	                <td>${holiday.holidayTitle}</td>
	                <td>${holiday.holidayDate}</td>
	                <td>${holiday.holidayDescription}</td>
	                <td id="${holiday.holidayId}" class="open-AddBookDialog btn btn-primary" data-toggle="modal"  data-id="${employee.id},${employee.userName},${employee.password},${employee.firstName},${employee.lastName},${employee.birthDate},${employee.sex},${employee.maritalStatus},${employee.email},${employee.address},${employee.city},${employee.state},${employee.zip},${employee.country},${employee.phone},${employee.designation},${employee.userRole.role},${employee.userRole.id},${employee.supervisor.superVisorId},${employee.supervisor.sId}"  data-target="#myModal"><img src='${pageContext.request.contextPath}/resources/images/Pencil-icon.png'  style="height: 26px;"></td>
            		<div class="container">  
				  		<div class="modal fade" id="myModal" role="dialog">
				    		<div class="modal-dialog">
				    
				      		<!-- Modal content-->
				      			<div class="modal-content">
				        			<div class="modal-header">
				          				<button type="button" class="close" data-dismiss="modal">&times;</button>
				          					<h4 class="modal-title">Holiday Details</h4>
				        			</div>
				        			<div class="modal-body">
				       		 			<form id="updateForm"  class="form-horizontal" role="form" name="updateForm">
				       		  				<div class="form-group">
											<div class="container-fluid">
											<section class="container">
											<div class="container-page">
											<div class="col-md-6">
												<h3 class="dark-grey">Holiday Edit Form</h3>
				       		  				
				       		  					<div class="form-group col-lg-4">
													<label>ID</label>
													<input type="text" name="holidayId" id="holidayId" value="" class="form-control" readonly>
												</div>
												
												<div class="form-group col-lg-4">
													<label>holidayTitle</label>
													<input type="text" name="holidayTitle" id="holidayTitle" value="" class="form-control"  onkeypress="return AllowAlphabet(event);"   onblur="checkUsernameUpdate();">
												</div>
												
												<div class="form-group col-lg-4">
													<label>holidayDate</label>
													<input type="text" name="holidayDate" id="holidayDate" value="" class="form-control"  onblur="password_length_update()" >
												</div>
												
												<div class="form-group col-lg-4">
													<label>holidayDescription</label>
													<input type="text" name="holidayDescription" id="holidayDescription" value="" class="form-control"  onkeypress="return AllowAlphabet(event);" >
												</div>
												
											
				       						</div>
				       					</div>
				       					</section>
				       					</div>
				       					</div>
				       					</form>
				        			</div>
				        			<div class="modal-footer">
				          				<button type="button" class="btn btn-default" onclick="sendDataForUpdation();" data-dismiss="modal">Close</button>
				        			</div>
				      			</div>
				    	</div>
				  </div>
				 
				</div>
            </tr>
         </c:forEach>
         </tbody>
</table>


</body>
</html>

