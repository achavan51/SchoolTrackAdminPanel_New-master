<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
<script>
var saveKara = 0;

 
 $(document).on("click", ".open-AddBookDialog", function () {
	   
	    
	});

 
</script>
<script type="text/javascript">
var saveKara = 0;

function showBtn(){

	 if(saveKara == 0){
		 alert("Please select At least one Route for delete");
	 }
	 else{
		 var result = confirm("Are you sure, you wan to delete Route(s)?");
		 if(result){
			 window.location.href = "deleteRouteList?list="+saveKara;	 
		 }
		 	 
	 }
	 
}

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

$(document).ready(function() {


    $('#routeDataTable').dataTable( {
        "aaSorting": [[1,'asc']],
         aoColumnDefs: [
                   {
                      bSortable: false,
                      aTargets: [ -1 ]
                   }
                 ]
      } );
} ); 

$(document).ready(function() {
    $('#routeDataTable').DataTable();
} );

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

function edit(id){
	var id = id;
	window.location.href = "editClient?id="+id;
	}
	
function deletel(id){
	
	var id = id;
	window.location.href = "deleteClient?id="+id;
}	


function addStops(id){

	var id=id;
	window.location.href="${pageContext.request.contextPath}/route/addNewStops?routeId="+id;
	
}

 function editRoute(id,name,status,start,stop,regNo,driverId,corridorId){
	
	$("#routeId").val(id);
	$("#routeName").val(name);
	$("#status").val(status);
	$("#start").val(start);
	$("#stop").val(stop);
	$("#regNumber").val(regNo);
	$("#driverName").val(driverId);
	$("#corridorId").val(corridorId);
	$('#edit').modal({backdrop: 'static', keyboard: false})
	$("#edit").modal('show');
	
	
}

 function editRoutes(){
	var routeId = $("#routeId").val();
	var routeName=$("#routeName").val();
	var status=$("#status").val();
	var start=$("#start").val();
	var stop=$("#stop").val();
	var busNo=$("#regNumber").val();
	var driverName=$("#driverName").val();
	var corridorId=$("#corridorId").val();
	alert("fvgb")
	 var allData=routeId+","+routeName+","+status+","+start+","+stop+","+busNo+","+driverName+","+corridorId;
	var formData="list="+allData;
	 $.ajax({
	    type : "POST",
	    url : "${pageContext.request.contextPath}/route/editRoute",
	    data : formData,
	    success : function(response) {	 
	    	 $("#edit").modal('hide');
	       alert("Route Updated Successfully!");
//	       location.reload();
	       window.location.href="${pageContext.request.contextPath}/route/routeMap";
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
	        	'routeName': {
	                validators: {
	                    notEmpty: {
	                        message: 'Route Name is required'
	                    }
	                }
	            },
	          
	            'startStop': {
	                validators: {
	                    notEmpty: {
	                        message: 'Start Stop is required'
	                    }
	                }
	            },
	            'endStop': {
	                validators: {
	                    notEmpty: {
	                        message: 'End Stop is required'
	                    }
	                }
	            },
	            'routeStatus' : {
	                validators: {
	                    notEmpty: {
	                        message: 'Status is required'
	                    }
	                }
	            },
	            
	            'bus.regNumber': {
	                
	                validators: {
	                    notEmpty: {
	                        message: 'Please select Bus number'
	                    }
	                                    }
	            },
	           
	            'busDriver.driverName': {
	              
	                validators: {
	                    notEmpty: {
	                        message: 'Please select Driver Name'
	                    }
	            	}
	            },
	            
	            
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
	        	'routeName': {
	                validators: {
	                    notEmpty: {
	                        message: 'Route Name is required'
	                    }
	                }
	            },
	          
	            'start': {
	                validators: {
	                    notEmpty: {
	                        message: 'Start Stop is required'
	                    }
	                }
	            },
	            'stop': {
	                validators: {
	                    notEmpty: {
	                        message: 'End Stop is required'
	                    }
	                }
	            },
	            'status' : {
	                validators: {
	                    notEmpty: {
	                        message: 'Status is required'
	                    }
	                }
	            },
	            
	            'regNumber': {
	                
	                validators: {
	                    notEmpty: {
	                        message: 'Please select Bus number'
	                    }
	                                    }
	            },
	           
	            'driverName': {
	              
	                validators: {
	                    notEmpty: {
	                        message: 'Please select Driver Name'
	                    }
	            	}
	            },
	            
	            
	        }
	    });
	    
	});
	
	
	
</script>

<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left">Route</h1>   
                    
                     <c:if test="${success == 'success'}">
                   <center> <div class="alert alert-success" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Route Added Successfully
					</div></center>                    	
                    </c:if>    
                    
                     <c:if test="${edit == 'edit'}">
                    <center><div class="alert alert-info" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Route Updated Successfully
					</div> </center>                   	
                    </c:if>    
                                     
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#addRoutes" data-backdrop="static" data-keyboard="false"><i class="fa fa-plus-circle"></i>  Add Route</button>                    
                    <button type="submit" class="btn btn-brown btn-sm pull-right" onClick="showBtn()" ><i class="fa fa-trash-o"></i> Delete</button>
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
                        <span class="panel-head">Route List</span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="routeDataTable" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                              <th width="3%" class="text-center no-sort"><input type="checkbox" onClick="deleteAllRow(this)"></th>
                              <th width="12%">Name</th>
                              <th width="10%">Status</th>
                              <th width="10%">Start Stop</th>
                              <th width="10%">End Stop</th>
                              <th width="10%">Corridor ID</th>
                              <th width="10%">Bus Number</th>
                              <th width="15%">Driver Name</th>
                              <th width="10%">Add Stop</th>
                              <th width="10%">Action</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="route" items="${routeList}">
                              <tr>
                                <td class="text-center"><input type="checkbox" id="${route.routeNo}" name="myTextEditBox" value="" onClick="displayNote(event)"></td>
                                <td>${route.routeName}</td>
                              
                                	 <c:choose>
                                        <c:when test="${route.routeStatus=='1'}">
                                        	<td>ON</td>
                                        </c:when>    
                                        <c:otherwise>
                                        	<td>OFF</td>
                                        </c:otherwise>
                                      </c:choose>
                                
                                <td>${route.startStop}</td>
                                <td>${route.endStop}</td>
                                <td>${route.corridorId}</td>
                                <td>${route.bus.regNumber}</td>
                                <td>${route.busDriver.driverName}</td>
                                <td><button type="submit" class="btn btn-default btn-sm" onClick="addStops(${route.routeNo})"><i class="fa fa-plus-circle"></i> Add Stops</button></td>
                                <td><button type="submit" class="btn btn-default btn-sm" onClick="editRoute('${route.routeNo}','${route.routeName}','${route.routeStatus}','${route.startStop}','${route.endStop}','${route.bus.regNumber}','${route.busDriver.driverId}','${route.corridorId}');"><i class="fa fa-pencil-square-o"></i> Edit</button></td>
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

<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Edit Route </h4>
      </div>
      
      <form id="editForm" method="post" action="${pageContext.request.contextPath}/route/routeMap">
      <div class="modal-body">
      	<div class="form-horizontal">
            <div class="form-group">
             <!-- 	<label class="col-sm-3 control-label">Route Number :</label> -->
                <div class="col-sm-8">
                  <input type="hidden" name="routeId" id="routeId" class="form-control" readOnly>
                </div>
            </div>
            <input type="hidden" name="action" value="edit" />
            <div class="form-group">
                <label class="col-sm-3 control-label">&#42; Route Name  : </label>
                <div class="col-sm-8">
                  <input type="text" name="routeName" id="routeName" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('routeName').value)">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">&#42; Status : </label>
                <div class="col-sm-8">
                	
                  <select name="status" id="status" class="form-control" >
               			<option value="false">ON</option>
                        <option value="true">OFF</option>
                  </select>
                </div>
            </div>
            
            <div class="form-group">
                <label class="col-sm-3 control-label">&#42; Start Stop : </label>
                <div class="col-sm-8">
                  <input type="text" name="start" id="start" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('start').value)">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">&#42; End Stop : </label>
                <div class="col-sm-8">
                  <input type="text" name="stop" id="stop" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('stop').value)">
                </div>
            </div>
            <div class="form-group">
            <!--     <label class="col-sm-3 control-label">Corridor Id :</label> -->
                <div class="col-sm-8">
                  <input type="hidden" name="corridorId" id="corridorId" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">&#42; Bus Number : </label>
                <div class="col-sm-8">
                	
                  <select name="regNumber" id="regNumber" class="form-control" >
              
                    <c:forEach var="bus" items="${busList}">
                      <option value="${bus.regNumber}">${bus.regNumber}</option>
                    </c:forEach>
                  </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">&#42; Driver : </label>
                <div class="col-sm-8">
                  <select id="driverName" name="driverName" class="form-control" >
                    <c:forEach var="busDriver" items="${busDriverList}">
                      <option value="${busDriver.driverId}">${busDriver.driverId},${busDriver.driverName},${busDriver.address},${busDriver.city}</option>
                    </c:forEach>
                  </select>
                </div>
            </div>
      	</div>
        <div class="modal-footer text-center">
            <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
            <input type="submit" class="btn btn-sky btn-sm"  value="Update" >
        </div>
    </div>
    </form> 
  </div>
</div>
</div>

<div class="modal fade" id="addRoutes" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Add Route</h4>
      </div>
      	 <form:form id="registerForm" class="form-horizontal" method="POST" name="registerForm" action="${pageContext.request.contextPath}/route/routeMap" commandName="route">            
      	<div class="modal-body">
            
            <div class="form-group">
              <%--   <form:label path="routeNo" class="col-sm-3 control-label">Route No.</form:label> --%>
                <div class="col-sm-8">
                	<form:input type="hidden" path="routeNo" id="routeNo"  class="form-control" />
                	
               	</div>
           	</div>
           	<input type="hidden" name="action" value="add" />
            <div class="form-group">
                <form:label  path="routeName" class="col-sm-3 control-label">&#42; Route Name : </form:label>
                <div class="col-sm-8">
                	<form:input  path="routeName" id="routeName"  class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('routeName').value)"/>
               	</div>
            </div>
            <div class="form-group">
                <form:label path="routeStatus" class="col-sm-3 control-label">&#42; Status : </form:label>
                <div class="col-sm-8">
                    <form:select  path="routeStatus" id="routeStatus" class="form-control">
                      <form:option value="">Select</form:option>
                      <form:option value="1">ON</form:option>
                      <form:option value="0">OFF</form:option>
                    </form:select>
               	</div>
            </div>
            <div class="form-group">
                <form:label path="startStop" class="col-sm-3 control-label">&#42; Start Stop : </form:label>
                <div class="col-sm-8">
                	<form:input name="startStop1" path="startStop" id="startStop"  class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('startStop').value)"/>
               	</div>
            </div>
            <div class="form-group">
                <form:label path="endStop" class="col-sm-3 control-label"> &#42; End Stop :</form:label>
                <div class="col-sm-8">
                	<form:input path="endStop" name="endStop1" id="endStop"  class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('endStop').value)"/>
               	</div>
            </div>
            <div class="form-group">
                <%-- <form:label path="corridorId" class="col-sm-3 control-label">Corridor ID</form:label> --%>
                <div class="col-sm-8">
                	<form:input type = "hidden" path="corridorId" id="corridorId" value="" class="form-control" />
               	</div>
            </div>
            <div class="form-group">
                <form:label path="bus.regNumber" class="col-sm-3 control-label">&#42; Bus Number : </form:label>
                <div class="col-sm-8">
                    <form:select path="bus.regNumber" id="regNumber1" class="form-control" >
                    	<form:option value="">Select Bus</form:option>
                      <c:forEach var="bus" items="${busList}">
                        <form:option value="${bus.regNumber}">${bus.regNumber}</form:option>
                      </c:forEach>
                    </form:select>
               	</div>
             </div>
             <div class="form-group">
                <form:label path="busDriver.driverName" class="col-sm-3 control-label" id="driver1">&#42; Driver :  </form:label>
                <div class="col-sm-8">
                    <form:select path="busDriver.driverName" id="driverName1" class="form-control" >
                    	<form:option value="">Select Driver</form:option>
                      <c:forEach var="busDriver" items="${busDriverList}">
                        <form:option value="${busDriver.driverId}">${busDriver.driverId},${busDriver.driverName},${busDriver.address},${busDriver.city}</form:option>
                      </c:forEach>
                    </form:select>
               	</div>
              </div>
            </div>
         	 <div class="modal-footer text-center">
            	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
            	<button type="submit"  class="btn btn-primary">Save</button>
            </div>   
            
          </form:form>
        </div>
      </div>
    </div>

<script src="script.js" type="text/javascript" defer="defer"></script>
