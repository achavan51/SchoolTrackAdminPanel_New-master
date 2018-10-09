
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><head>

<script
	src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script
	src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>

<script>
var saveKara = 0;

 
 	$(document).on("click", ".open-AddBookDialog", function () {	    
	});
	
	var saveKara = 0;
	
	function useHTML(id,data){
		 var id = "#" + id;
		var text = "";
		for (i = 0; i < data.length; i++) { 
			if(data[i] == "<"){
	   	text += "<<span>";
			}else if(data[i] == ">"){
				text += "</span>>";
			}
			else{
				text += data[i];
			}
		}
		 $(id).val(text);
	}
	
	function showBtn(){
	
		 if(saveKara == 0){
			 alert("Please select At least one Vehicle for delete");
		 }
		 else{
			 var result = confirm("want to delete?");
			 if(result){
				 
				 var formData="list="+saveKara;
				 $.ajax({
				    type : "POST",
				    url : "${pageContext.request.contextPath}/route/checkDependancy",
				    data : formData,
				    success : function(response) {
				    	
				    	if(response == "true"){
				    		alert("Dependency Exit , can't delete.");
				    	}else{
				    		window.location.href = "deleteBusList?list="+saveKara;
				    	}
					   
				      },
				    error : function(e) {
				    	
				    }
				});
				 
				 	 
			 }
				 
		 }
		 
	}



	$(document).ready(function() {
		$('#routeDataTable').DataTable();
	} );


	function edit(id){
		var id = id;
		window.location.href = "editClient?id="+id;
	}
	
	function deletel(id){
		
		var id = id;
		window.location.href = "deleteClient?id="+id;
	}	

	function checkUniqueVehicleNo(){
		
		var regNo= "regNo="+$("#regNumber1").val();
		if(regNo==null){
			regNo= "regNo="+$("#regNumber").val();
		}
		$.ajax({
		    type : "POST",
		    url : "${pageContext.request.contextPath}/route/checkUniqueVehicleNo",
		    data : regNo,
		    success : function(response) {	
		    	
		       
		       if(response){
		    	
		       alert("Vehicle Registration Number Should be Unique:")
		       }
		  
		    },
		    error : function(e) {
		  
		    }
		});
	}
	
	
	function sendDataForUpdation(){
	
	
	 var clientId = $("#clientId").val();
	 var clientUsername = $("#clientUsername").val();
	 var clientPassword = $("#clientPassword").val();
	 var clientName = $("#clientName").val();
	 var clientEmail = $("#clientEmail").val();
	 var clientMobile = $("#clientMobile").val();
	 var clientAddress = $("#clientAddress").val();
	 var clientCountry = $("#clientCountry").val();
	 var clientTimeZone = $("#clientTimeZone").val();
	 var skypeId = $("#skypeId").val();
	 
	 if(clientId == null || clientId == "" || clientUsername == null || clientUsername == "" || clientPassword == null || clientPassword == "" || clientName == null || clientName == "" || clientEmail == null || clientEmail == "" || clientMobile == null || clientMobile == "" || clientAddress == null || clientAddress == "" || clientCountry == null || clientCountry == "" || clientTimeZone == null || clientTimeZone == "" || skypeId == null || skypeId == "" ){
			alert("some fields are empty");
		}
	 else{
	 var allData = clientId+","+clientUsername+","+clientPassword+","+clientName+","+clientEmail+","+clientMobile+","+clientAddress+","+clientCountry+","+clientTimeZone+","+skypeId;
	 
	 var formData = "accessList="+allData;
	 $.ajax({
		    type : "POST",
		    url : "${pageContext.request.contextPath}/admin/updateClient",
		    data : formData,
		    success : function(response) {	       
		       alert("Client Profile Updated");
		    },
		    error : function(e) {
		       alert('Error: ' + e);
		    }
		});
	}
}

function addStops(id){

	var id=id;
	window.location.href="${pageContext.request.contextPath}/route/addNewStops?routeId="+id;
	
}

 function editBus(id,regNo,type,capacity,deviceId){
	 
	$("#busId").val(id);
	$("#regNumber").val(regNo);
	$("#type").val(type);
	$("#capacity").val(capacity);
	$("#uniqueID").val(deviceId);
	$('#edit').modal({backdrop: 'static', keyboard: false})
	$("#edit").modal('show');
	
}

 function editBuses(){

	var busId = $("#busId").val();
	 var regNo=$("#regNo").val();
	var type=$("#type").val();
	var capacity=$("#capacity").val();
	var uniqueId = $("#uniqueId").val();
	var allData=busId+","+regNo+","+type+","+capacity+","+uniqueId;
	var formData="list="+allData;
	 $.ajax({
	    type : "POST",
	    url : "${pageContext.request.contextPath}/route/editBus",
	    data : formData,
	    success : function(response) {	 
	    	 $("#edit").modal('hide');
	       alert("Bus Updated Successfully!");
	     //  location.reload();
	      },
	    error : function(e) {
	    	 $("#edit").modal('hide');
	       alert('Error: ' + e);
	    }
	});   
} 



 function malaDeleteKara(id){
		if(saveKara == 0){
			saveKara = id + ",";
		}
		else{
			saveKara = saveKara + id + ",";	
		}
	}

	function removeString(ch){
		ch = ch + ",";
		saveKara = saveKara.replace(ch,'');
	}
	
	

	function deleteAllRow(source){  	
	 	 checkboxes = document.getElementsByName('myTextEditBox');
	 	  for(var i=0, n=checkboxes.length;i<n;i++) {
	 		var id = checkboxes[i].getAttribute('id' );
	 	    checkboxes[i].checked = source.checked;
	 	    if(source.checked){
	 	    malaDeleteKara(id);
	 	    }else{
	 	    	removeString(id);
	 	    }
	 	  }	
	}	

	function displayNote(evt){
		var el = evt.target || evt.srcElement;
		  if (el && el.type == 'checkbox' && el.checked == true) {
		   	    malaDeleteKara(el.id);
		  }
		  else if(el && el.type == 'checkbox' && el.checked == false){
			  removeString(el.id);
		  }
		 
	}
	$(document).ready(function() {
		
		$("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
		    $("#success-alert").alert('close');
		});
	    $('#registerForm').formValidation({
	        framework: 'bootstrap',
	        excluded: ':disabled',
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	regNumber: {
	                validators: {
	                    notEmpty: {
	                        message: 'Vehicle Name is required'
	                    }
	                }
	            },
	            busType: {
	                validators: {
	                    notEmpty: {
	                        message: 'Vehicle Type is required'
	                    }
	                }
	            },
	            capacity: {
	                validators: {
	                    notEmpty: {
	                        message: 'Capacity is number'
	                    }
	                }
	            }
	        }
	    });
	    
	    $('#editForm').formValidation({
	        framework: 'bootstrap',
	        excluded: ':disabled',
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	regNumber: {
	                validators: {
	                    notEmpty: {
	                        message: 'Vehicle Name is required'
	                    }
	                }
	            },
	            busType: {
	                validators: {
	                    notEmpty: {
	                        message: 'Vehicle Type is required'
	                    }
	                }
	            },
	            'device.uniqueID':{
	            	validators: {
	                    notEmpty: {
	                        message: 'Device ID is required'
	                    }
	                }
	            },
	            capacity: {
	                validators: {
	                    notEmpty: {
	                        message: 'Capacity is number'
	                    }
	                }
	            }
	        }
	    });
	});
	
	
</script>

<div class="form-horizontal">
	<div class="row">
		<div class="col-lg-12">
			<div class="fixed-page-header">
				<div class="page-header clearfix">
					<h1 class="page-head-text pull-left">Vehicle</h1>

			 <c:if test="${success == 'success'}">
                   <center> <div class="alert alert-success" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Vehicle Added Successfully
					</div></center>                    	
                    </c:if>    
                    
                     <c:if test="${edit == 'edit'}">
                    <center><div class="alert alert-info" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Vehicle Updated Successfully
					</div> </center>                   	
                    </c:if>    
		
					<button type="submit" class="btn btn-inverse btn-sm pull-right"
						data-toggle="modal" data-target="#forClientRegistration" data-backdrop="static" data-keyboard="false">
						<i class="fa fa-plus-circle"></i> Add Vehicle
					</button>
					<button type="submit" class="btn btn-brown btn-sm pull-right"
						onClick="showBtn()">
						<i class="fa fa-trash-o"></i> Delete
					</button>
				</div>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<div class="panel-name">
						<span class="panel-head">Vehicle List</span>
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table id="example"
							class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th width="2%" class="text-center no-sort"><input
										type="checkbox" onClick="deleteAllRow(this)"></th>
									<th width="25%">Vehicle Number</th>
									<th width="25%">Vehicle Type</th>
									<th width="20%">Device</th>
									<th width="20%">Vehicle Capacity</th>
									<th width="20%">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="bus" items="${busList}">
									<tr>
										<td><input type="checkbox" id="${bus.busId}"
											name="myTextEditBox" value="" onClick="displayNote(event)"></td>
										<td>${bus.regNumber}</td>
										<td>${bus.busType}</td>
										<td>${bus.device.deviceID}</td>
										<td>${bus.capacity}</td>
										<td><button type="button" class="btn btn-default btn-sm"
												value="Edit"
												onClick="editBus('${bus.busId}','${bus.regNumber}','${bus.busType}','${bus.capacity}','${bus.device.deviceID}')">
												<i class="fa fa-pencil-square-o"></i> Edit
											</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- / row -->
</div>

<div class="modal fade" id="edit" tabindex="-1" role="dialog"
	aria-labelledby="delete-domain" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Edit Vehicle</h4>
			</div>
			<form:form id="editForm" class="form-horizontal" method="post"
				name="registerForm"
				action="${pageContext.request.contextPath}/route/busList"
				commandName="bus">
				<div class="modal-body">
					<div class="form-group">
						<%--   <form:label path="busId" class="col-sm-3 control-label">Vehicle ID.</form:label> --%>
						<div class="col-sm-8">
							<form:input type="hidden" path="busId" id="busId"
								class="form-control" />
						</div>
					</div>
					<input type="hidden" name="action" value="edit">
					<div class="form-group">
						<form:label path="regNumber" class="col-sm-3 control-label">* Vehicle Registration Number</form:label>
						<div class="col-sm-8">
							<form:input path="regNumber" id="regNumber" name="regNumber"
								class="form-control" maxlength="50" onblur="checkUniqueVehicleNo(); useHTML(this.id,document.getElementById('regNumber').value);" />
						</div>
					</div>

					<div class="form-group">
						<form:label path="busType" class="col-sm-3 control-label">* Vehicle Type</form:label>
						<div class="col-sm-8">
							<form:input path="busType" id="type" name="busType"
								class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('type').value)"/>
						</div>
					</div>
					<div class="form-group">
						<form:label path="device.uniqueID" class="col-sm-3 control-label">* DeviceID</form:label>
						<div class="col-sm-8">
							<form:select  path="device.uniqueID"  id="uniqueID" class="form-control">
								<c:forEach var="device" items="${deviceList}">
									<option value="${device.uniqueID}">${device.deviceID}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<form:label path="capacity" class="col-sm-3 control-label">* Capacity</form:label>
						<div class="col-sm-8">
							<form:input path="capacity" type="number" id="capacity"
								name="capacity" class="form-control" maxlength="3" />
						</div>
					</div>
				</div>
				<div class="modal-footer text-center">
					<button type="button" class="btn btn-default btn-sm"
						data-dismiss="modal">Cancel</button>
					<input type="submit" class="btn btn-sky btn-sm" value="Update">
				</div>
			</form:form>
		</div>
	</div>
</div>


<div class="modal fade" id="forClientRegistration" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add Vehicle</h4>
			</div>
			<form:form id="registerForm" class="form-horizontal" method="post"
				name="registerForm"
				action="${pageContext.request.contextPath}/route/busList"
				commandName="bus">
				<div class="modal-body">
					<div class="form-group">
						<%--   <form:label path="busId" class="col-sm-3 control-label">Vehicle ID.</form:label> --%>
						<div class="col-sm-8">
							<form:input type="hidden" path="busId" id="routeNo"
								class="form-control" />
						</div>
					</div>
					<input type="hidden" name="action" value="add">
					<div class="form-group">
						<form:label path="regNumber" class="col-sm-3 control-label">* Vehicle Registration Number</form:label>
						<div class="col-sm-8">
							<form:input path="regNumber" id="regNumber1" name="regNumber"
								class="form-control" maxlength="50" onblur="checkUniqueVehicleNo(); useHTML(this.id,document.getElementById('regNumber1').value)" />
						</div>
					</div>

					<div class="form-group">
						<form:label path="busType" class="col-sm-3 control-label">* Vehicle Type</form:label>
						<div class="col-sm-8">
							<form:input path="busType" id="busType" name="busType"
								class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('busType').value)"/>
						</div>
					</div>
					<div class="form-group">
						<form:label path="device.uniqueID" class="col-sm-3 control-label">* DeviceID</form:label>
						<div class="col-sm-8">
							<form:select  path="device.uniqueID"  id="uniqueIDD" class="form-control">
								<option value="">Select</option>
								<c:forEach var="device" items="${deviceList}">
									<option value="${device.uniqueID}">${device.deviceID}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<form:label path="capacity" class="col-sm-3 control-label">* Capacity</form:label>
						<div class="col-sm-8">
							<form:input path="capacity" type="number" id="capacity"
								name="capacity" class="form-control" maxlength="3"/>
						</div>
					</div>
				</div>
				<div class="modal-footer text-center">
					<button type="button" class="btn btn-default btn-sm"
						data-dismiss="modal">Cancel</button>
					<input type="submit" class="btn btn-sky btn-sm" value="Save">
				</div>
			</form:form>
		</div>
	</div>
</div>