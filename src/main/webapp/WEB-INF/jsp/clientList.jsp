<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Client List</title>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 
  <script src="https://cdn.datatables.net/1.10.8/css/dataTables.bootstrap.min.css"></script>
  <script src="https://cdn.datatables.net/1.10.8/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.8/js/dataTables.bootstrap.min.js"></script>





<script>
var saveKara = 0;

function showBtn(){

	 if(saveKara == 0){
		 alert("Please select Atleast one client for delete");
	 }
	 else{
		
		 var result = confirm("want to delete?");
		 if(result){
			 window.location.href = "deleteClientList?list="+saveKara;	 
		 }
		 	 
	 }
	 
}

 $(function(){
	    $('#browse_app').click(function(){
	        window.location='addClient';
	    });
	});
 
 
 
 $(document).on("click", ".open-AddBookDialog", function () {
	    var myBookId = $(this).data('id');
	    var data = myBookId.split(",");
	    var d = data[0];
	    var d1 = data[1];
	    var d2 = data[2];
	    var d3 = data[3];
	    var d4 = data[4];
	    var d5 = data[5];
	    var d6 = data[6];
	    var d7 = data[7];
	    var d8 = data[8];
	    var d9 = data[9];
	
	    
	    
	    
	    $(".modal-body #clientId").val( d );
	    $(".modal-body #clientUsername").val( d1 );
	    $(".modal-body #clientPassword").val( d2 );
	    $(".modal-body #clientName").val( d3 );
	    $(".modal-body #clientEmail").val( d4 );
	    $(".modal-body #clientMobile").val( d5 );
	    $(".modal-body #clientAddress").val( d6 );
	    $(".modal-body #clientCountry").val( d7 );
	    $(".modal-body #clientTimeZone").val( d8 );
	    $(".modal-body #skypeId").val( d9 );
	    
	});

 
</script>
<script type="text/javascript">

$(document).ready(function() {
    $('#example').DataTable();
} );


function edit(id){
	var id = id;
	window.location.href = "editClient?id="+id;
	}
	
function deletel(id){
	
	var id = id;
	window.location.href = "deleteClient?id="+id;
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

function sendDataForRegistration(){
	
	
	 /* var clientId = $("#cclientId").val();
	 alert(clientId);
	 var clientUsername = $("#cclientUsername").val();
	 alert(clientUsername);
	 var clientPassword = $("#cclientPassword").val();
	 alert(clientPassword);
	 var clientName = $("#cclientName").val();
	 alert(clientName);
	 var clientEmail = $("#cclientEmail").val();
	 alert(clientEmail);
	 var clientMobile = $("#cclientMobile").val();
	 alert(clientMobile);
	 var clientAddress = $("#cclientAddress").val();
	 alert(clientAddress);
	 var clientCountry = $("#cclientCountry").val();
	 alert(clientCountry);
	 var clientTimeZone = $("#cclientTimeZone").val();
	 alert(clientTimeZone);
	 var skypeId = $("#sskypeId").val();
	 alert(skypeId);
	 */
	 
	 var name=$("#aName").val();
	 var address=$("#aAddress").val();
	 var email=$("#aEmail").val();
	 var password=$("#aPassword").val();
	 var age=$("#aAge").val();
	 var city=$("#aCity").val();
	var school=$("#schoolId").val();
	var username=$("#username").val();
	var accountType=$("#accountType").val();
//	alert(school);
	// var school=$("#school").val();
	/*  if( clientUsername == null || clientUsername == "" || clientPassword == null || clientPassword == "" || clientName == null || clientName == "" || clientEmail == null || clientEmail == "" || clientMobile == null || clientMobile == "" || clientAddress == null || clientAddress == "" || clientCountry == null || clientCountry == "" || clientTimeZone == null || clientTimeZone == "" || skypeId == null || skypeId == "" ){
			alert("some fields are empty");
		}
	 else{ */
	 var allData = name+","+address+","+email+","+password+","+age+","+city+","+school+","+username+","+accountType;

	 
	 var formData = "accessList="+allData;
	 $.ajax({
		    type : "POST",
		    url : "${pageContext.request.contextPath}/admin/addClient",
		    data : formData,
		    success : function(response) {	       
		       alert("Client Profile Added");
		    },
		    error : function(e) {
		       alert('Error: ' + e);
		    }
		});
	}


function malaDeleteKara(id){
	if(saveKara == 0){
		saveKara = id + ",";
		alert(saveKara);
	}
	else{
		saveKara = saveKara + id + ",";	
		alert(saveKara);
	}
	//showAlert(saveKara);
}

function removeString(ch){
	ch = ch + ",";
	saveKara = saveKara.replace(ch,'');
	alert(saveKara);
//	showAlert(saveKara);
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

function AllowAlphabet(e)
{
  isIE = document.all ? 1 : 0
  keyEntry = !isIE ? e.which : event.keyCode;
  if (((keyEntry >= '65') && (keyEntry <= '90')) || ((keyEntry >= '97') && (keyEntry <= '122')) || (keyEntry == '46') || (keyEntry == '32') || keyEntry == '45' || keyEntry == '9' || keyEntry == '13' || keyEntry == '20' || keyEntry == '13' || keyEntry == '37' || keyEntry == '38' || keyEntry == '39' || keyEntry == '40' || keyEntry == '46' || keyEntry == '8'|| keyEntry == '11' || keyEntry == '9')
     return true;
  else
	{
    	alert('Please Enter Only Character values.');
    	//$("#password").val("");	
    	return false;
    }
}

function AllowNumber(e)
{
  isIE = document.all ? 1 : 0
  keyEntry = !isIE ? e.which : event.keyCode;
  if (((keyEntry >= '48') && (keyEntry <= '57')) || ((keyEntry >= '96') && (keyEntry <= '105')) || (keyEntry == '46') || (keyEntry == '37') || keyEntry == '39' || keyEntry == '9' || keyEntry == '8'  || keyEntry == '13' || keyEntry == '38' || keyEntry == '39' || keyEntry == '40' || keyEntry == '46' )
     return true;
  else
	{
    	alert('Please Enter Only numbers .');
    	return false;
    }
}

function phoneValidUpdate(inputtxt)
{
  var phoneno = /^\d{10}$/;
  if(inputtxt.value.match(phoneno))
  {
      return true;
  }
  else
  {
     alert("Not a valid Phone Number");
     $("#clientPhone").val("");
     return false;
  }
}

function phoneValidRegistration(inputtxt)
{
  var phoneno = /^\d{10}$/;
  if(inputtxt.value.match(phoneno))
  {
      return true;
  }
  else
  {
     alert("Not a valid Phone Number");
     $("#cclientPhone").val("");
     return false;
  }
}

function emailValidateUpdate() 
{
	 var mail = $("#clientEmail").val();
     if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
     {
       return (true)
     }
     alert("You have entered an invalid email address!")
     $("#clientEmail").val("");
     return (false)
}

function emailValidateRegistration() 
{
	 var mail = $("#cclientEmail").val();
     if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
     {
       return (true)
     }
     alert("You have entered an invalid email address!")
     $("#cclientEmail").val("");
     return (false)
}


function password_length_update()
{  	
  var userInput = $("#clientPassword").val().length;
  //alert(userInput);
  if(userInput >= 6 )
     {  	
       return true;  	
     }
  else
     {  	
	    alert("Please input atleast " +6+ " characters");  	
	    $("#clientPassword").val("");
       return false;  	
     }  
}

function password_length_registration()
{  	
  var userInput = $("#cclientPassword").val().length;  
  //alert(userInput);
  if(userInput >= 6 )
     {  	
       return true;  	
     }
  else
     {  	
	    alert("Please input atleast " +6+ " characters");  		
	    $("#cclientPassword").val("");
       return false;  	
     }  
}
</script>

</head>
<body >
<button id="btn"  class="open-AddBookDialog btn btn-primary" type="button" onClick="showBtn()" >Delete</button>
<button  class="open-AddBookDialog btn btn-primary" data-toggle="modal"  data-id=""  data-target="#forClientRegistration">Add School Admin</button>
<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
            	<th>DELETE</th>
                <th>Name</th>
                <th>School Name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Age</th>
                <th>City</th>
            </tr>
        </thead>
 
        <tfoot>
            <tr>
            	<th>DELETE</th>
                <th>Name</th>
                <th>School Name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Age</th>
                <th>City</th>
                
               
            </tr>
        </tfoot>
 
        <tbody>
        <c:forEach var="schoolAdmin" items="${schoolAdminList}">
            <tr>
  					<td>
          				  <input type="checkbox" id="${schoolAdmin.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/>
          			</td>
	                <td>${schoolAdmin.name}</td>
	                <td>${schoolAdmin.school.schoolName}</td>
	                <td>${schoolAdmin.address}</td>
	                <td>${schoolAdmin.email}</td>
	                <td>${schoolAdmin.age}</td>
	                <td>${schoolAdmin.city}</td>
	                
	                     </tr>
         </c:forEach>
         </tbody>
</table>
	                <%-- 
	                <td id="${client.clientId}" class="open-AddBookDialog btn btn-primary" data-toggle="modal"  data-id="${client.clientId},${client.clientUsername},${client.clientPassword},${client.clientName},${client.clientEmail},${client.clientMobile},${client.clientAddress},${client.clientCountry},${client.clientTimeZone},${client.skypeId}"  data-target="#myModal"><img src='${pageContext.request.contextPath}/resources/images/Pencil-icon.png'  style="height: 26px;"></td>
	                
					 <div class="container">  
				  		<div class="modal fade" id="myModal" role="dialog">
				    		<div class="modal-dialog">
				    
				      		<!-- Modal content-->
				      			<div class="modal-content">
				        			<div class="modal-header">
				          				<button type="button" class="close" data-dismiss="modal">&times;</button>
				          					<h4 class="modal-title">Employee Details</h4>
				        			</div>
				        			<div class="modal-body">
				       		 			<form id="updateForm"  class="form-horizontal" role="form" name="updateForm">
				       		  				<div class="form-group">
											<div class="container-fluid">
											<section class="container">
											<div class="container-page">
											<div class="col-md-6">
												<h3 class="dark-grey">Employee Edit Form</h3>
				       		  				
				       		  					<div class="form-group col-lg-4">
													<label>ID</label>
													<input type="text" name="clientId" id="clientId" value="" class="form-control" readonly>
												</div>
												
												<div class="form-group col-lg-4">
													<label>Client Username</label>
													<input type="text" name="clientUsername" id="clientUsername" value="" class="form-control"  onkeypress="return AllowAlphabet(event);"   onblur="checkUsernameUpdate();">
												</div>
												
												<div class="form-group col-lg-4">
													<label>Client Password</label>
													<input type="text" name="clientPassword" id="clientPassword" value="" class="form-control"  onblur="password_length_update()" >
												</div>
												
												<div class="form-group col-lg-4">
													<label>Client Name</label>
													<input type="text" name="clientName" id="clientName" value="" class="form-control"  onkeypress="return AllowAlphabet(event);" >
												</div>
												
												<div class="form-group col-lg-4">
													<label>email</label>
													<input type="text" name="clientEmail" id="clientEmail" value="" class="form-control" onblur="emailValidateUpdate()">
												</div>
												
												<div class="form-group col-lg-4">
													<label>Mobile No</label>
													<input type="text" name="clientMobile" id="clientMobile" value="" class="form-control" onblur="return phoneValidUpdate(clientMobile);">
												</div>
												
												<div class="form-group col-lg-4">
													<label>Address</label>
													<input type="text" name="clientAddress" id="clientAddress" value="" class="form-control" onkeypress="return AllowAlphabet(event);">
												</div>
												
												<div class="form-group col-lg-4">
													<label>Country</label>
													<input type="text" name="clientCountry" id="clientCountry" value="" class="form-control " onkeypress="return AllowAlphabet(event);">
												</div>
												
												<div class="form-group col-lg-4">
													<label>Time Zone</label>
													<input type="text" name="clientTimeZone" id="clientTimeZone" value="" class="form-control "  >
												</div>
												
												
												<div class="form-group col-lg-4">
													<label>Skype Id</label>
													<input type="text" name="skypeId" id="skypeId" value="" class="form-control " onkeypress="return AllowAlphabet(event);">
												</div>
												
												
												<!-- <div class="form-group col-lg-4">
													<label>Sex</label>
													<select  id="skypeId" name="skypeId" class="form-control" >
													    <option value="male">male</option>
													    <option value="female">female</option>
												
													</select> 
												</div>
				       		  				 -->
				       		  				
				       		  				
				       		  				
				        						<!-- clientId&nbsp<input type="text" name="clientId" id="clientId" value=""/><br>
				        						clientName&nbsp<input type="text" name="clientName" id="clientName" value=""/><br>
				       							clientEmail&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="clientEmail" id="clientEmail" value=""/><br>
				        						clientMobile&nbsp&nbsp&nbsp<input type="text" name="clientMobile" id="clientMobile" value=""/><br>
				        						clientAddress&nbsp<input type="text" name="clientAddress" id="clientAddress" value=""/><br>
				        						clientCountry&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="clientCountry" id="clientCountry" value=""/><br>	
				       							clientTimeZone<input type="text" name="clientTimeZone" id="clientTimeZone" value=""/><br>
				       							skypeId<input type="text" name="skypeId" id="skypeId" value=""/><br> -->
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
				 
				</div> --%>
       
	 <div class="container">  
				  		<div class="modal fade" id="forClientRegistration" role="dialog">
				    		<div class="modal-dialog">
				    
				      		<!-- Modal content-->
				      			<div class="modal-content">
				        			<div class="modal-header">
				          				<button type="button" class="close" data-dismiss="modal">&times;</button>
				          					<h4 class="modal-title">School Admin Details</h4>
				        			</div>
				        			<div class="modal-body">
				       		 			<form id="registerForm"  class="form-horizontal" role="form" name="registerForm">
				       		  				<div class="form-group">
											<div class="container-fluid">
											<section class="container">
											<div class="container-page">
											<div class="col-md-6">
												<h3 class="dark-grey">School Admin Registration</h3>
				       		  				
				       		  					
				       		  					
												<div>
													<label>User Name</label>
													<input type="text" name="username" id="username" value="" class="form-control">
												</div>
												
												<div >
													<label>Account Type</label>
													<select name="accountType" id="accountType" class="form-control" >
													
													<option value="SchoolAdmin">School Admin</option>
													
													</select>
												</div>
												
												<div >
													<label>Admin Name</label>
													<input type="text" name="name" id="aName" value="" class="form-control">
												</div>
												
												<div>
													<label>Admin Password</label>
													<input type="text" name="password" id="aPassword" value="" class="form-control" ">
												</div>
												
												<div>
													<label>School Name</label>
												<select name="schoolName" id="schoolId" class="form-control" >
  													
  													<c:forEach var="school" items="${schoolList}">
  															<option value="${school.schoolName}">${school.schoolName}</option>
												</c:forEach>
												</select>
												
												<div>
													<label>Address</label>
													<input type="text" name="address" id="aAddress" value="" class="form-control" >
												</div>
												
												<div>
													<label>Email</label>
													<input type="text" name="email" id="aEmail" value="" class="form-control" >
												</div>
												
												<div>
													<label>Age</label>
													<input type="text" name="age" id="aAge" value="" class="form-control" >
												</div>
												
												<div>
													<label>City</label>
													<input type="text" name="city" id="aCity" value="" class="form-control">
												</div>
												
												<!-- <div class="form-group col-lg-4">
													<label>Country</label>
													<input type="text" name="cclientCountry" id="cclientCountry" value="" class="form-control " onkeypress="return AllowAlphabet(event);">
												</div>
												
												<div class="form-group col-lg-4">
													<label>Time Zone</label>
													<input type="text" name="cclientTimeZone" id="cclientTimeZone" value="" class="form-control " onkeypress="return AllowAlphabet(event);">
												</div>
												
												
												<div class="form-group col-lg-4">
													<label>Skype Id</label>
													<input type="text" name="sskypeId" id="sskypeId" value="" class="form-control " onkeypress="return AllowAlphabet(event);">
												</div>
												
												
												<div class="form-group col-lg-4">
													<label>Sex</label>
													<select  id="skypeId" name="skypeId" class="form-control" >
													    <option value="male">male</option>
													    <option value="female">female</option>
												
													</select> 
												</div>
				       		  				
				       		  				
				       		  				
				       		  				
				        						 -->
				       					</div>
				       					</div>
				       					</section>
				       					</div>
				       					</div>
				       					</form>
				        			</div>
				        			<div class="modal-footer">
				          				<button type="button" class="btn btn-default" onClick="sendDataForRegistration();" data-dismiss="modal">Submit</button>
				        			</div>
				      			</div>
				    	</div>
				  </div>
				 
				</div>

