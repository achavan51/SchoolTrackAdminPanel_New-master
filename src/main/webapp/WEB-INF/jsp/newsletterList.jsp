 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><head>
 
<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>
 
<script type="text/javascript">

$(document).ready(function() {
	var arrayList='${newsletterList}';
	if(arrayList.length==2){
		document.getElementById("deleteButton").disabled = true;  	
	}
	else
		{
		document.getElementById("deleteButton").enabled = true;  
		}
	
	
    $('#registerForm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	news: {
                validators: {
                    notEmpty: {
                        message: 'News Field Should not be Empty'
                    }
                }
            }
        }
    });
});

var saveKara = 0;

 
 $(document).on("click", ".open-AddBookDialog", function () {
	   
	    
	});


var saveKara = 0;

function showBtn(){

	 if(saveKara == 0){
		 alert("Please select At least one NewsLetter for delete");
	 }
	 else{
		 var result = confirm("Are you sure, you want to delete newsletter(s)?");
		 if(result){
			 window.location.href = "deleteNewsletterList?list="+saveKara;	 
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


function addStops(id){

	var id=id;
	window.location.href="${pageContext.request.contextPath}/route/addNewStops?routeId="+id;
	
}

 function editExtintors(id,type,status){
	 
	$("#id").val(id);
	$("#type").val(type);
	$("#status").val(status);
	$('#edit').modal({backdrop: 'static', keyboard: false});
	$("#edit").modal('show');
	
	
}

 function editExtintor(){
	var id = $("#id").val();
	var type=$("#type").val();
	var status=$("#status").val();
	var busNo=$("#regNumber").val();
	 var allData=id+","+type+","+status+","+busNo;
	var formData="list="+allData;
	 $.ajax({
	    type : "POST",
	    url : "${pageContext.request.contextPath}/extintor/editExtintor",
	    data : formData,
	    success : function(response) {	 
	    	 $("#edit").modal('hide');
	       alert("Route Updated Successfully!");
	       location.reload();
	      },
	    error : function(e) {
	    	 $("#edit").modal('hide');
	       alert('Error: ' + e);
	    }
	});   
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
	  	    malaDeleteKara(id);
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

	
	
</script>

<div class="form-horizontal">
    <div class="row">
        <div class="col-lg-12">
            <div class="fixed-page-header">
                <div class="page-header clearfix">
                    <h1 class="page-head-text pull-left">Newsletter</h1>
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal" data-target="#addNewsletter" data-backdrop="static" data-keyboard="false"><i class="fa fa-plus-circle"></i>  Add Newsletter</button> 
                                     
                    <button type="submit" id="deleteButton" class="btn btn-brown btn-sm pull-right" onClick="showBtn()" ><i class="fa fa-trash-o"></i> Delete</button>
                </div>                                    
            </div>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
           
    <div class="row">                        
      <!--   <%@page import="com.comlink.controller.MasterController"%>-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>

<!-- start: Meta -->
<meta charset="utf-8">
<title>Comlink | Summary Report</title>
<meta name="description" content="Get Spiffed Dashboard ">
<meta name="author" content="Get Spiffed Dashboard ">
<!-- end: Meta -->

<!-- start: Mobile Specific -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- end: Mobile Specific -->

<!-- start: CSS -->
<style>
.checkbox {
  display: float: right;;
}
</style>
<link
	href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
	href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
<link id="bootstrap-style" href="resources/css/bootstrap.css"
	rel="stylesheet">
	<link  rel="stylesheet" type="text/css"  href="resources/css/custom.css" rel="stylesheet">





<!--
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">-->




<link href="resources/css/bootstrap.css" rel="stylesheet">



<!--<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>-->
<!--<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  -->
<link href="resources/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">

<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
<link id="base-style" href="resources/css/style.css" rel="stylesheet">
<link id="base-style-responsive"
	href="resources/css/style-responsive.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Droid+Sans:400,700">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Droid+Serif">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Boogaloo">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Economica:700,400italic">


<!--[if lt IE 7 ]>
	<link id="ie-style" href="resources/css/style-ie.css" rel="stylesheet">
	<link href="resources/css/custom.css" type="text/css" rel="stylesheet">
	<![endif]-->
<!--[if IE 8 ]>
	<link id="ie-style" href="resources/css/style-ie.css" rel="stylesheet">
	<link href="resources/css/custom.css" type="text/css" rel="stylesheet">
	<![endif]-->
<!--[if IE 9 ]>
	<![endif]-->

<!-- end: CSS -->


<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

<!-- start: Favicon -->
<link rel="shortcut icon" href="resources/img/favicon.ico">
<!-- end: Favicon -->
<style>
.clr {
	clear: both;
}
</style>
</head>
<body>
	<div id="overlay">
		<ul>
			<li class="li1"></li>
			<li class="li2"></li>
			<li class="li3"></li>
			<li class="li4"></li>
			<li class="li5"></li>
			<li class="li6"></li>
		</ul>
	</div>
	<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a> <a class="brand" href="index.html"> <!--<img alt="Perfectum Dashboard" src="resources/img/logo20.png" />-->
					<div class="login-logo">
						<img src="resources/img/logo-white.png" alt="logo" width="160"
							height="70">
					</div></a>
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right p-top">
						<!-- start: Notifications Dropdown -->
						<!-- end: Notifications Dropdown -->
						<!-- start: Message Dropdown -->
						<!-- end: Message Dropdown -->
						<li><a class="btn" href="#"> <i
								class="icon-wrench icon-white"></i>
						</a></li>
						<!-- start: User Dropdown -->
						<li class="dropdown"><a class="btn dropdown-toggle"
							data-toggle="dropdown" href="#"> <i
								class="icon-user icon-white"></i> <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<%
									 if(45==45){
								%>
									<li><a href="/ReportingPortal/user-management?id="><i
								class="icon-user"></i><span class="hidden-tablet">User Management
									</span></a></li>
									<%}%>
								<li><a href="changepassword.html"><i class="icon-user"></i>
										Change Password</a></li>
								<li><a href="/ReportingPortal/logout"><i class="icon-off"></i>Logout</a></li>
							</ul></li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->

			</div>
		</div>
	</div>
	<!-- start: Header -->

	<div class="container-fluid">
		<div class="row-fluid">
<div class="span2 main-menu-span">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<!--<li><a href="index.html"><i class="icon-home icon-white"></i><span class="hidden-tablet"> Dashboard</span></a></li>
                          <li><a href="profile.html"><i class="icon-user icon-white"></i><span class="hidden-tablet"> My Profile</span></a></li>-->
						<!-- <li><a href="friends.html"><i class="icon-globe icon-white"></i><span class="hidden-tablet">Report</span></a></li>-->

						<li><a href="summary-report.html"><i
								class="icon-tasks icon-white"></i><span class="hidden-tablet">Reports</span></a></li>
						
					
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!-- start: Main Menu -->
		
			<!--/span-->
			<!-- end: Main Menu -->
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>

			<div id="content" class="span10">
				<!-- start: Content -->


				<div class="row breadrump-block">
					<hr>
					<div class="span8">
						<ul class="breadcrumb">
							<li><a href="index.html">Home</a> <span class="divider">/</span>
							</li>
							<li><a href="#">Report</a></li>

						</ul>
					</div>
					<div class="span3"></div>
					<hr>
				</div>



				<div class="row-fluid sortable">
					<div class="parentrightreport">
						<div class="box-header" data-original-title="">
							<h2>
								<i class="icon-edit"></i><span class="break"></span>View Report
							</h2>
							<div class="box-icon">
								<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>

							</div	>
						</div>

						<div class="box-content">

							<form class="" action="summary-report.html" method="post">
								<div class="parentline1 clearfix">
									<div class="childsline1">

										<div class="control-group">
											<label class="control-label" for="date01">Start Date</label>
											<div id="datetimepicker" class="input-append date">
												<input required data-format="dd/MM/yyyy hh:mm:ss"
													type="text" name="startdate" value="${sdate}"></input> <span
													class="add-on"> <i data-time-icon="icon-time"
													data-date-icon="icon-calendar"></i>
												</span>
											</div>
											<!--<div class="controls">
								<input type="text" class="input-xlarge datepicker" id="date01" value="02/16/12">
							  </div>-->
										</div>
									</div>

									<div class="childsline1">
										<div class="control-group">
											<label class="control-label" for="date01">End Date</label>
											<div id="datetimepicker1" class="input-append date">
												<input required data-format="dd/MM/yyyy hh:mm:ss"
													type="text" name="enddate" value="${edate}"></input> <span
													class="add-on"> <i data-time-icon="icon-time"
													data-date-icon="icon-calendar"></i>
												</span>
											</div>
										</div>
									</div>
									
									<div class="childsline1">
										<div class="inputline1">
											<label class="control-label" for="focusedInput">Ticket
												Number</label>
											<div class="controls">
												<input name="focusedInput" class="inputline1"
													id="focusedInput" type="text" value="${focusedInput}">
											</div>
										</div>
									</div>
									
									<div class="childsline1">
										<div class="inputline1">
											<label class="control-label" for="focusedInput">Request
												Source</label>
											<div class="controls">
												<input name="Request Source" class="inputline1" id="Request Source" type="text"
													value="${RequestSource}"></input>
											</div>
										</div>
									</div>
										<div class="childsline1">
										<div class="inputline1">
											<label class="control-label" for="focusedInput">Carrier/Route</label>
											<div class="controls">
												<input class="" name="carrier-route"
													id="carrier-route" type="text" value="${carrierroute}">
											</div>
										</div>

									</div>
									<div class="childsline1">
										<div class="inputline1">
											<label class="control-label" for="selectError">Status</label>
											<div class="controls">
												<select id="s-report" data-rel="chosen" name="optionsRadios"
													value="${type-test}">
													<option value="ALL">All</option>
													<option value="PASS">Pass</option>
													<option value="FAIL">Fail</option>
												</select>

											</div>
										</div>
									</div>

								</div>

								<div class="clr"></div>
								<div class="parentline2 clearfix">
									<div class="box">
										<div class="control-group">
											<label class="control-label" for="selectError">
												Type Test</label>
												<div class="" style="">
													<label><input type="checkbox" id="checkALl" onClick="selectAll(this)">
														 All</label>
												</div>
											<div id="container">
											
												
												
													
												<div class="childtests">
													<label><input type="checkbox" name="type-test"
														value="ANSWER_DETECT">ANSWER_DETECT</label>
												</div>
												
												
												<div class="childtests">
													<label><input type="checkbox" name="type-test"
														value="Connectivity">Connectivity</label>
												</div>
												
												<div class="childtests">
													<label><input type="checkbox" name="type-test"
														value="FAX">FAX</label>
												</div>
												
												
												<div class="childtests">
													<label><input type="checkbox" name="type-test"
														value="VoiceQuality">VoiceQuality</label>
												</div>
												
												<div class="childtests">
													<label><input type="checkbox" name="type-test"
														value="FAS">FAS</label>
												</div>
												
												
												<div class="childtests">
													<label><input type="checkbox" name="type-test"
														value="Provisioning">Provisioning</label>
												</div>
												
											</div>
											
										</div>
									</div>
								</div>

								<div class="box span12"
									style="margin-left: 0px; margin-top: -25px;">
									
								</div>
								<div class="parentline1" style="margin-bottom: 20px;">
									<button type="submit" class="btn btn-primary click"
										href="#credits">Submit</button>
										<button type="submit" class="btn btn-primary click"
								href="#downloadsummaryReport"
								onClick="window.open('downloadsummaryReport')">Download
								Summary Report</button>
								<button type="submit" class="btn btn-primary click"
								href="#downloadDetailsReport"
								onClick="window.open('downloadDetailsReport')">Download
								Detail Report</button>
								</div>
							</form>
							

							
					<div class="parentposts">
							<div id="newpost" class="mar-top20">
								<table
									class="table table-striped table-bordered bootstrap-datatable datatable ">
									<thead>
										<tr>
											<th></th>
											<th>RecordID</th>
											<th>Testplan id</th>
											<th>Request id</th>
											<th>Test name</th>
											<th>Test file name</th>
											<th>Test Requested By</th>
											<th>File rcvd at</th>
											<th>File sent to_proc</th>
											<th>File Completed</th>
											<th>Test Duration</th>
											<th>Test Type</th>
											<th>No calls_req</th>
											<th>No calls_proc</th>
											<th>Country Name</th>
											<th>Country Code</th>
											<th>Start Range</th>
											<th>Carrier Spec</th>
											<th>Route Id</th>
											<th>Report Type</th>
											<th>Test Status</th>
											<th>Test Code</th>
											<th>Successful Calls</th>
											<th>Failed Calls</th>
										</tr>
									</thead>
									<tbody>${testlog}
									</tbody>
								</table>

							</div>
							</div>
						</div>
						<!--/span-->
					</div>
				</div>
				<!--/row-->
				<!--/row-->
				<hr>
				<!-- end: Content -->
				<!--/#content.span10-->
			</div>
			<!--/fluid-row-->

			<div class="modal hide fade" id="myModal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3>Settings</h3>
				</div>
				<div class="modal-body">
					<p>Here settings can be configured...</p>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
						class="btn btn-primary">Save changes</a>
				</div>
			</div>

			<div class="clearfix"></div>



		</div>
		<!--/.fluid-container-->
		<footer>
			<p>
				<span style="text-align: left; float: left">&copy; 2016 <a
					href="http://www.comlinkinc.com/index.html" target="_blank">Get
						Spiffed, Inc. </a> all rights reserved
				</span>
			</p>

		</footer>
	</div>

	<!-- start: JavaScript-->

	<script src="resources/js/jquery-1.7.2.min.js"></script>
	<script src="resources/js/jquery-ui-1.8.21.custom.min.js"></script>

	<script src="resources/js/bootstrap.js"></script>

	<script src="resources/js/jquery.cookie.js"></script>

	<script src='resources/js/fullcalendar.min.js'></script>

	<script src='resources/js/jquery.dataTables.min.js'></script>

	<script src="resources/js/excanvas.js"></script>
	<script src="resources/js/jquery.flot.min.js"></script>
	<script src="resources/js/jquery.flot.pie.min.js"></script>
	<script src="resources/js/jquery.flot.stack.js"></script>
	<script src="resources/js/jquery.flot.resize.min.js"></script>

	<script src="resources/js/jquery.chosen.min.js"></script>

	<script src="resources/js/jquery.uniform.min.js"></script>

	<script src="resources/js/jquery.cleditor.min.js"></script>

	<script src="resources/js/jquery.noty.js"></script>

	<script src="resources/js/jquery.elfinder.min.js"></script>

	<script src="resources/js/jquery.raty.min.js"></script>

	<script src="resources/js/jquery.iphone.toggle.js"></script>

	<script src="resources/js/jquery.uploadify-3.1.min.js"></script>

	<script src="resources/js/jquery.gritter.min.js"></script>

	<script src="resources/js/jquery.imagesloaded.js"></script>

	<script src="resources/js/jquery.masonry.min.js"></script>

	<script src="resources/js/jquery.knob.js"></script>

	<script src="resources/js/jquery.sparkline.min.js"></script>

	<script src="resources/js/custom.js"></script>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


	<script type="text/javascript"
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script>
	<script type="text/javascript"
		src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
	<script type="text/javascript"
		src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
	<script type="text/javascript"
		src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
	<script type="text/javascript">
      $('#datetimepicker').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        // language: 'pt-BR'
      });
      $('#datetimepicker1').datetimepicker({
           format: 'dd/MM/yyyy hh:mm:ss',
           // language: 'pt-BR'
         });
    </script>
	<script>

	$( document ).ready(function() {
	    if($("#carrier-route").val()=="0"){
	    	$("#carrier-route").val("");
	    }

	    var pf = "${optionsRadios}";
	    $("#s-report").val(pf);
		var result = "${typetest}".substring(1, "${typetest}".length-1);
	    result = result.split(",");
	    for (var i = 0; i < result.length; i++) {
	    	result[i] = result[i].replace(/ /g,'');
	    	$(":checkbox").filter(function() {
	    		  return this.value == result[i];
	    	}).prop("checked","true");	
		}
	    
	});

	</script>

	<!-- end: JavaScript-->



	<script>
    function showhide()
     {
        var div = document.getElementById("newpost");
    if (div.style.display !== "none") {
        div.style.display = "none";
    }
    else {
        div.style.display = "block";
    }
     }
  </script>
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker1').datetimepicker({
			});
		});
	</script>
</body>
</html>
<script>
$(function() {
	$("#SnapHost_Calendar2").datepicker({
		showOn : 'both',
		buttonImage : 'http://www.snaphost.com/jquery/calendar.gif',
		buttonImageOnly : true,
		changeMonth : true,
		showOtherMonths : true,
		selectOtherMonths : true
	});
});
</script>

<script>

function ajaxcall(id){
	alert(id);
	$.ajax({
		type : "POST",		
		contentType : "application/json",
		url : "getSearchResult.html",
		dataType: "resources/jsON",
		data : {
	        "id" : id
	    },				
		success : function(data) {
			console.log("SUCCESS: ", data);
			//display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			//display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}


$( document ).ready(function() {
    if($("#carrier-route").val()=="0"){
    	$("#carrier-route").val("");
    }
});

function selectAll(source) {
	  checkboxes = document.getElementsByName('type-test');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
</script>iv class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                   <div class="panel-name">
                        <span class="panel-head">Newsletter List</span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="routeDataTable" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            	<th width="10%" class="text-center no-sort"><input type="checkbox" onClick="deleteAllRow(this)"></th>
                                <th width="60%">News</th>
                                <th width="30%">Date</th>
                            </tr>
                          </thead>
                            <tbody>
                                <c:forEach var="newsletter" items="${newsletterList}">
                                    <tr>
                                       <td class="text-center"><input type="checkbox" id="${newsletter.id}" name="myTextEditBox" value="" onClick="displayNote(event)"></td>
                                       <td>${newsletter.news}</td>  
                                       <td>${newsletter.date}</td>       
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

<div class="modal fade" id="addNewsletter" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
    <div class="modal-dialog">
    	<!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"> Add NewsLetter : </h4>
            </div>
            <form:form id="registerForm" class="form-horizontal" method="post" name="registerForm" action="${pageContext.request.contextPath}/newsletter/newsletterList" commandName="newsletter">
                <div class="modal-body">            
                    <div class="form-group">
                        <form:label path="news" class="col-sm-3 control-label">* News :</form:label>
                        <%-- <div class="col-sm-8">
                            <form:input path="news" id="news" value="" class="form-control" maxlength="100" />
                        </div> --%>
                         <input type="hidden" name=action value="add" />
                       
                        <div class="col-sm-8">
                      <form:textarea path="news" rows="2" id="news" cols="50" maxlength="100" onblur = "useHTML(this.id,document.getElementById('news').value)"/>
                        </div>
                        
                    </div>
               	</div>
                <div class="modal-footer text-center">                
            		<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                  	<button type="submit" class="btn btn-sky btn-sm">Save</button>
                </div>
            </form:form>
        </div>
	</div>
</div>
					
<script src="script.js" type="text/javascript" defer="defer"></script>
