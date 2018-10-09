<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script> 
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>    
<script>

$(document).ready(function() {
    $('#formAdd').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	'stopName': {
                validators: {
                    notEmpty: {
                        message: 'Stop Name is required'
                    }
                }
            },
          
            'latitude': {
                validators: {
                    notEmpty: {
                        message: 'Latitude Should be Decimal'
                    }
                }
            },
            'longitude': {
                validators: {
                    notEmpty: {
                        message: 'Latitude Should be Decimal'
                        	
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
        	'stopsName': {
                validators: {
                    notEmpty: {
                        message: 'Stop Name is required'
                    }
                }
            },
          
            'latitudes': {
                validators: {
                    notEmpty: {
                        message: 'Latitude Should be Decimal'
                    }
                }
            },
            'longitudes': {
                validators: {
                    notEmpty: {
                        message: 'Longitude Should be Decimal'
                        	
                    }
                }
            },
              
        }
    });
    
});
  $(document).ready(function() {
	// If the browser supports the Geolocation API
	if (typeof navigator.geolocation == "undefined") {
	  $("#error").text("Your browser doesn't support the Geolocation API");
	  return;
	}
	
	// Save the positions' history
	var path = [];

	var array =  "${coordinateList}".split(",");
	
  
	for(var i=0,j=1;i < array.length-1;i++,j++){
		 path.push(new google.maps.LatLng(array[i], array[j]));
		 j=j+1;
		 i=i+1;
	}
	navigator.geolocation.watchPosition(function(position) {
	  // Save the current position
		 /* if(array.length == 1){
			   alert("current zero");
			 navigator.geolocation.getCurrentPosition(function(position) {
				 path.push(new google.maps.LatLng(position.coords.latitude, position.coords.longitude));
			  }, function(error) {
				alert('Unable to get location: ' + error.message);
		});
			
	
		 } */

	  // Create the map
	  var myOptions = {
		zoom : 16,
		center : path[0],
		mapTypeId : google.maps.MapTypeId.ROADMAP
	  }
	  var map = new google.maps.Map(document.getElementById("map"), myOptions);
	
	  
	  /* for(var i=0;i< array.length;i++){
		alert("array"+array[0].stopName);
		  
	  } */
	 // Uncomment this block if you want to set a path

	 /* path.push(
		  new google.maps.LatLng(
			position.coords.latitude + (Math.random() / 10 * ((i % 2) ? 1 : -1)),
			position.coords.longitude 
		  )
		); */
	  // Create the polyline's points
	 /*  for(var i = 0; i < 5; i++) {
		// Create a random point using the user current position and a random generated number.
		// The number will be once positive and once negative using based on the parity of i
		// and to reduce the range the number is divided by 10
		path.push(
		  new google.maps.LatLng(
			position.coords.latitude + (Math.random() / 10 * ((i % 2) ? 1 : -1)),
			position.coords.longitude + (Math.random() / 10 * ((i % 2) ? 1 : -1))
		  )
		);
	  } */
	  

	  // Create the array that will be used to fit the view to the points range and
	  // place the markers to the polyline's points
	  var latLngBounds = new google.maps.LatLngBounds();
	  for(var i = 0; i < path.length; i++) {
		latLngBounds.extend(path[i]);
		// Place the marker
		new google.maps.Marker({
		  map: map,
		  position: path[i],
		  title: "Point " + (i + 1)
		});
	  }
	  // Creates the polyline object
	  var polyline = new google.maps.Polyline({
		map: map,
		path: path,
		strokeColor: '#0000FF',
		strokeOpacity: 0.7,
		strokeWeight: 1
	  });
	  // Fit the bounds of the generated points
	  map.fitBounds(latLngBounds);
	},
	function(positionError){
	  $("#error").append("Error: " + positionError.message + "<br />");
	},
	{
	  enableHighAccuracy: true,
	  timeout: 10 * 1000 // 10 seconds
	});
  });
  
  $(document).ready(function() {
      $('#example').DataTable({
    	  "paging":   false
     	}); 
	});
</script>

<div class="form-horizontal">
	<div class="row">
		<div class="col-lg-12">
			<div class="fixed-page-header">
				<div class="page-header clearfix">
					<h1 class="page-head-text pull-left">Bus Stop</h1>         
					<button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#addStop"><i class="fa fa-plus-circle"></i> Add Stop</button></td>           
					<a class="btn btn-inverse btn-sm pull-right" href="javascript:history.back();"><i class="fa fa-angle-double-left"></i> Back</a>
				</div>                                    
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->    
        
        
    <div class="row">                 
        <div class="col-md-6">
        	<div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head">Map</span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
           			<div id="map" class="map-box"></div>
              	</div>
          	</div>
      	</div>
        
        <div class="col-md-6 nopad-l">
            <div id="stopList" class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head">Stop List</span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                                <th width="15%" class="text-center">Stop No</th>
                                <th width="15%">Name</th>
                                <th width="25%">Latitude</th>
                                <th width="25%">Longitude</th>
                                <th width="15%">Action</th>                 
                            </tr>
                          </thead>
                            <tbody>
                                <c:forEach var="stop" items="${stopList}">
                                    <tr>                                       
                                       <td class="text-center">${stop.stopNo}</td>  
                                       <td>${stop.stopName}</td> 
                                       <td>${stop.latitude}</td> 
                                       <td>${stop.longitude}</td> 
                                       
                                       <td><button type="button" class="btn btn-default btn-sm" onClick="editRoute('${stop.stopNo}','${stop.stopName}','${stop.latitude}','${stop.longitude}','${stop.stopId}','${stop.route.routeNo}')">Edit</button></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
						</table>
					</div>
    				<p id="error"></p>
                </div>                                    
            </div>
        </div>
    </div>
	<!-- / row -->   
</div>

 <form id="editForm">
<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
   	<div class="modal-dialog">
		<div class="modal-content">
			  <div class="modal-header">
			 
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Edit Bus Stop</h4>
			  </div>
              
			  <div class="modal-body">              	
        		<div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Stop Number :</label>
                        <div class="col-sm-8">
                            <input type="text" name="stopNumber" id="stopNumber" class="form-control" readOnly>
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Stop Name :</label>
                        <div class="col-sm-8">
                            <input type="text" name="stopsName" id="stopsName" class="form-control" maxlength="20">
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Latitude :</label>
                        <div class="col-sm-8">
                            <input type="number" step="0.01" name="latitudes" id="latitudes" class="form-control" maxlength="10">
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Longitude :</label>
                        <div class="col-sm-8">
                            <input type="number" step="0.01" name="longitudes" id="longitudes" class="form-control" maxlength="10">
                        </div>
                    </div>
              	</div>
            </div>
            
            <div class="modal-footer text-center">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-sky btn-sm" onClick="editStop()" data-dismiss="modal">Save</button>
            </div>				
     	</div>
     </div>
</div>
</form>
<div class="modal fade" id="addStop" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
   	<div class="modal-dialog">
		<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Add Bus Stop</h4>
			  </div>
              <form id="formAdd" action="${pageContext.request.contextPath}/route/addNewStops" method="post">
			  <div class="modal-body">              	
        		<div class="form-horizontal">
        		
				    <div class="form-group">
                        <label class="col-sm-3 control-label">* Route Number :</label>
                        <div class="col-sm-8">
                            <input type="text" name="routeId" id="routeId" value= "${routeId}" class="form-control" readOnly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Stop Number :</label>
                        <div class="col-sm-8">
                            <input type="text" name="stopNo" id="stopNumber" value= "${stopCounter}" class="form-control" readOnly>
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Stop Name :</label>
                        <div class="col-sm-8">
                            <input type="text" name="stopName" id="stopsName" class="form-control" maxlength="20">
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Latitude :</label>
                        <div class="col-sm-8">
                            <input type="number" step="0.01" name="latitude" id="latitudes" class="form-control" maxlength="10">
                        </div>
                    </div>
				
                    <div class="form-group">
                        <label class="col-sm-3 control-label">* Longitude :</label>
                        <div class="col-sm-8">
                            <input type="number" step="0.01" name="longitude" id="longitudes" class="form-control" maxlength="10">
                        </div>
                    </div>
                    <input type="hidden" id="stopId" name="id">
                    <input type="hidden" id="routeNumber" name="id">
              	</div>
            </div>
             <div class="modal-footer text-center">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                <input type="submit" class="btn btn-sky btn-sm"  value="Save">
            </div>
           </form>            
     	</div>
   	</div>
</div>


<script>
	function editRoute(stopNo,stopName,latitude,longitude,stopId,routeNo){
	//	alert(stopNo);
		$("#stopNumber").val(stopNo);
		$("#stopsName").val(stopName);
		$("#latitudes").val(latitude);
		$("#longitudes").val(longitude);
		$("#stopId").val(stopId);
		$("#routeNumber").val(routeNo);
		$("#edit").modal('show');
	}
	function editStop(){
	
	 var stopId = $("#stopId").val();
	 var stopNo = $("#stopNumber").val();
	 var stopName= $("#stopsName").val();
	 var latitude= $("#latitudes").val();
	 var longitude = $("#longitudes").val();
	 var routeNo=$("#routeNumber").val();
	 var data=stopId+","+stopName+","+latitude+","+longitude+","+stopNo+","+routeNo;
	 var formData="list="+data;
	 $.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath}/route/editStop",
		data : formData,
		success : function(response) {	 
			 $("#edit").modal('hide');
		   alert("Stop Updated Successfully!");
		   window.location.href="${pageContext.request.contextPath}/route/addNewStops?routeId="+routeNo;
		  },
		error : function(e) {
			 $("#edit").modal('hide');
		   alert('Error: ' + e);
		}
	});
}
	
function addStop(){

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

} 
</script>