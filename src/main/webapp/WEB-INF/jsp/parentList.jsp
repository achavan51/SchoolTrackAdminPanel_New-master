<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="http://formvalidation.io/vendor/formvalidation/js/formValidation.min.js"></script>
<script src="http://formvalidation.io/vendor/formvalidation/js/framework/bootstrap.min.js"></script>


<script type="text/javascript">
var saveKara = 0;

function showBtn(){

	 if(saveKara == 0){
		 alert("Please select At least one Parent for delete");
	 }
	 else{		
		 var result = confirm("Are you sure, you want to delete parent(s)?");
		 if(result){
			 window.location.href = "deleteParentList?list="+saveKara;	 
		 } 
	 }
}

$(function(){
	$('#browse_app').click(function(){
		window.location='addClient';
	});
});



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

function checkUniqueUsername(){
	
	var userName= "userName="+$("#username").val();
	
	$.ajax({
	    type : "POST",
	    url : "${pageContext.request.contextPath}/admin/checkUniqueUserName",
	    data : userName,
	    success : function(response) {	
	    	
	       
	       if(response){
	    	
	      
	       alert("User already registered with this Username")
	       
	       }
	  
	    },
	    error : function(e) {
	  
	    }
	});
}


function sendDataForRegistration(){

	 
	 var name=$("#aName").val();
	 var address=$("#aAddress").val();
	 var email=$("#aEmail").val();
	 var username=$("#username").val();
	 if(email != null && email != '' && username != null && username != ''){
	 var password=$("#aPassword").val();
	 var age=$("#aAge").val();
	 var city=$("#aCity").val();
	var school=$("#schoolId").val();
	
	var accountType=$("#accountType").val();

	 var allData = name+","+address+","+email+","+password+","+age+","+city+","+school+","+username+","+accountType;

	 
	 var formData = "accessList="+allData;
	 $.ajax({
		    type : "POST",
		    url : "${pageContext.request.contextPath}/admin/addSchoolAdmin",
		    data : formData,
		    success : function(response) {	
		    	
		    	$("#forClientRegistration").modal('hide');
		       alert("Parent Admin Added Successfully ");
		       
		    },
		    error : function(e) {
		    	alert("Please Enter Mandatory FIeld and UserName Should be Unique");
		    }
		});
	}else{
		alert("Please Enter Mandatory FIeld and UserName Should be Unique");
	}
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

function AllowAlphabet(e)
{
  isIE = document.all ? 1 : 0
  keyEntry = !isIE ? e.which : event.keyCode;
  if (((keyEntry >= '65') && (keyEntry <= '90')) || ((keyEntry >= '97') && (keyEntry <= '122')) || (keyEntry == '46') || (keyEntry == '32') || keyEntry == '45' || keyEntry == '9' || keyEntry == '13' || keyEntry == '20' || keyEntry == '13' || keyEntry == '37' || keyEntry == '38' || keyEntry == '39' || keyEntry == '40' || keyEntry == '46' || keyEntry == '8'|| keyEntry == '11' || keyEntry == '9')
     return true;
  else
	{
    	alert('Please Enter Only Character values.');	
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
    
     $("#aEmail").val("");
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

function editParent(id,name,school,address,email,age,city,password,username,accountType){
	$("#parentId").val(id);
	$("#name1").val(name);
	$("#school1").val(school);
	$("#address1").val(address);
	$("#email1").val(email);
	$("#age1").val(age);
	$("#city1").val(city);
	$("#password1").val(password);
	$("#username1").val(username);
	$("#accountType1").val(accountType);
	$('#edit').modal({backdrop: 'static', keyboard: false})
	$("#edit").modal('show');
	
}

function editParents(){
	
	var id=$("#parentId").val();
	var name=$("#name1").val();
	var school=$("#school1").val();
	var address=$("#address1").val();
	var email=$("#email1").val();
	var age=$("#age1").val();
	var city=$("#city1").val();
	var password=$("#password1").val();
	var username=$("#username1").val();
	var accountType=$("#accountType1").val();
	var allData=id+","+name+","+school+","+address+","+email+","+age+","+city+","+password+","+username+","+accountType;
	var formData="list="+allData;
	 $.ajax({
	    type : "POST",
	    url : "${pageContext.request.contextPath}/schoolAdmin/editParent",
	    data : formData,
	    success : function(response) {	 
	    	 $("#edit").modal('hide');
	       alert("Parent Updated Successfully!");
	       location.reload();
	      },
	    error : function(e) {
	    	$("#edit").modal('hide');
		       alert("Error"+e);
		       
	    }
	});   
	
}

function emailValidateRegistration() 
{
	 var mail = $("#aEmail").val();
     if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
     {
       return (true)
     }
     $("#aEmail").val("");
     return (false)
}

$(document).ready(function() {

	var title1="";
	$(".dropdown dt a").on('click', function () {
	          $(".dropdown dd ul").slideToggle('fast');
	      });

	      $(".dropdown dd ul li a").on('click', function () {
	          $(".dropdown dd ul").hide();
	      });

	      function getSelectedValue(id) {
	           return $("#" + id).find("dt a span.value").html();
	      }

	      $(document).bind('click', function (e) {
	          var $clicked = $(e.target);
	          if (!$clicked.parents().hasClass("dropdown")) $(".dropdown dd ul").hide();
	      });


	      $('.mutliSelect input[type="checkbox"]').on('click', function () {
	        
	          var title = $(this).closest('.mutliSelect').find('input[type="checkbox"]').val(),
	              title = $(this).val() + ",";
	        	
	        	
	        	
	          if ($(this).is(':checked')) {
	        	  title1=title1+title;
	              var html = '<span title="' + title + '">' + title + '</span>';
	              $('.multiSel').append(html);
	              $(".hida").hide();
	          } 
	          else {
	        	  title1=title1.replace(title,"");
	              $('span[title="' + title + '"]').remove();
	              var ret = $(".hida");
	              $('.dropdown dt a').append(ret);
	              
	          }
	          $('#student1').val(title1);
	      });

    $('#example').dataTable( {
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
	
	$("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
	    $("#success-alert").alert('close');
	});
	
    $('#frm').formValidation({
    	
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	username: {
        		verbose: false,
                validators: {
                	
                    notEmpty: {
                    
                        message: 'Username is required'
                    },
        			stringLength: {
            				min: 6,
            				max: 20,
            		message: 'Username must be more than 6 and less than 20 characters long'
        			},
        		regexp: {
            		regexp: /^[a-zA-Z0-9_\.]+$/,
            		message: 'Username can only consist of alphabetical, number, dot and underscore'
        			},
        			
                }
            },
            name: {
                validators: {
                    notEmpty: {
                        message: 'Name should be required'
                    }
                }
            },
            
            password: {
                validators: {
                    notEmpty: {
                        message: 'Password is required'
                    }
            
                }
            },
            
            'school.schoolName': {
                validators: {
                    notEmpty: {
                        message: 'Please select School'
                    }
                }
            },
            
            address: {
                validators: {
                    notEmpty: {
                        message: 'Address is required'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please Enter Valid Email'
                    }
                }
            },
            
            age: {
                validators: {
                    notEmpty: {
                        message: 'Age should be a number '
                    }
                }
            },
            city: {
                validators: {
                    notEmpty: {
                    	
                        message: 'City is required'
      
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
        	username: {
        		verbose: false,
                validators: {
                	
                    notEmpty: {
                    
                        message: 'Username is required'
                    },
        			stringLength: {
            				min: 6,
            				max: 20,
            		message: 'Username must be more than 6 and less than 20 characters long'
        			},
        		regexp: {
            		regexp: /^[a-zA-Z0-9_\.]+$/,
            		message: 'Username can only consist of alphabetical, number, dot and underscore'
        			},
        			
                }
            },
            name: {
                validators: {
                    notEmpty: {
                        message: 'Name is required'
                    }
                }
            },
            
            password: {
                validators: {
                    notEmpty: {
                        message: 'Password is required'
                    }
                }
            },
            
            'school.schoolName': {
                validators: {
                    notEmpty: {
                        message: 'Please select School'
                    }
                }
            },
            
            address: {
                validators: {
                    notEmpty: {
                        message: 'Address is required'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please Enter Valid Email'
                    }
                }
            },
            
            age: {
                validators: {
                    notEmpty: {
                        message: 'Age should be a number '
                    }
                }
            },
            city: {
                validators: {
                    notEmpty: {
                    	
                        message: 'City is required'
      
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
                    <h1 class="page-head-text pull-left">Parent</h1>     
                    
                         
                  <c:if test="${success == 'success'}">
                   <center> <div class="alert alert-success" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Parent Added Successfully
					</div></center>                    	
                    </c:if>    
                    
                     <c:if test="${edit == 'edit'}">
                    <center><div class="alert alert-info" id="success-alert">
    					<button type="button" class="close" data-dismiss="alert">x</button>
    						<strong>Success! </strong>
   								 Parent Updated Successfully
					</div> </center>                   	
                    </c:if>  
                                   
                    <button type="submit" class="btn btn-inverse btn-sm pull-right" data-toggle="modal"  data-target="#forClientRegistration" data-backdrop="static" data-keyboard="false"><i class="fa fa-plus-circle"></i>  Add Parent</button>                    
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
                        <span class="panel-head">Parent List</span>
                    </div>                                        
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="example" class="table table-bordered table-striped table-hover">
                          <thead>
                            <tr>
                            	<th width="2%" class="text-center no-sort"><input type="checkbox" onClick="deleteAllRow(this)"/></th>
                                <th width="10%">Name</th>
                                <th width="15%">School Name</th>
                                <th width="20%">Address</th>
                                <th width="15%">Email</th>
                                <th width="10%">Age</th>
                                <th width="10%">City</th>
                                <th width="10%">Action</th>                             
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="schoolAdmin" items="${schoolAdminList}">
                            <c:if test= "${schoolAdmin.accountType eq 'Parent'}">    
                                <tr>              
                                        <td><input type="checkbox" id="${schoolAdmin.id}"  name="myTextEditBox" value="" onClick="displayNote(event)"/></td>
                                        <td>${schoolAdmin.name}</td>
                                        <td>${schoolAdmin.school.schoolName}</td>
                                        <td>${schoolAdmin.address}</td>
                                        <td>${schoolAdmin.email}</td>
                                        <td>${schoolAdmin.age}</td>
                                        <td>${schoolAdmin.city}</td>
                                        <td><button type="submit"  class="btn btn-default btn-sm" value="Edit" onClick="editParent('${schoolAdmin.id}','${schoolAdmin.name}','${schoolAdmin.school.schoolName}','${schoolAdmin.address}','${schoolAdmin.email}','${schoolAdmin.age}','${schoolAdmin.city}','${schoolAdmin.password}','${schoolAdmin.username}','${schoolAdmin.accountType}');" ><i class="fa fa-pencil-square-o"></i>Edit</button></td>
                                   	</tr>  
                                   </c:if>                                      
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

<div class="modal fade" id="forClientRegistration" tabindex="-1" role="dialog" aria-labelledby="delete-domain" aria-hidden="true">
    <div class="modal-dialog">
    	<!-- Modal content-->
      
            
             <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Parent Details</h4>
            </div>
            <div class="modal-body">
                <form:form id="frm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/schoolAdmin/parentList" commandName="schoolAdmin">
                
                <input type="hidden" name="action" value="add">
                <input type="hidden" name="student1" id="student1"> 
                <div class="form-group">
                        <form:label path="name" class="col-sm-3 control-label">&#42; Parent Name</form:label>
                        <div class="col-sm-8">
                        	<form:input path="name" type="text" id="aName" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('aName').value)"/>
                        </div>
                   	</div>
              
               
                    
                     
                    <div class="form-group">
                       	<form:label path="username" class="col-sm-3 control-label">&#42; Username</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="username" id="username" value="" class="form-control" maxlength="20" onblur = "checkUniqueUsername(); useHTML(this.id,document.getElementById('username').value);" />
                      	</div>
                    </div>
                  	
                  	<div class="form-group">
                        <form:label path="password" class="col-sm-3 control-label">&#42; Password</form:label>
                        <div class="col-sm-8">
                        	<form:input type="text" path="password" id="aPassword" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('aPassword').value)"/>
                        </div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="school.schoolName" class="col-sm-3 control-label">&#42; School Name</form:label>
                        <div class="col-sm-8">
                        	<form:select path="school.schoolName" id="schoolId" class="form-control" >
                        		<form:option value="">Select</form:option>
                            	<c:forEach var="school" items="${schoolList}">
                               	<form:option value="${school.schoolName}">${school.schoolName}</form:option>
                        		</c:forEach>
                        	</form:select>
                       </div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label">&#42; Address</form:label>
                        <div class="col-sm-8">
                            <form:input  path="address" type="text" id="aAddress" value="" class="form-control" maxlength="80" onblur = "useHTML(this.id,document.getElementById('aAddress').value)"/>
                        </div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="email" class="col-sm-3 control-label">&#42; Email</form:label>
                        <div class="col-sm-8">
                            <form:input path="email" type="email" id="aEmail" class="form-control"  maxlength="30" />
                        </div>
                   	</div>
                    
                  	<div class="form-group">
                        <form:label path="age" class="col-sm-3 control-label"> &#42; Age (Years)</form:label>
                        <div class="col-sm-8">
                        	<form:input path="age" type="number" min="1" step="1"  id="aAge" value="" class="form-control" />
                        </div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="city" class="col-sm-3 control-label"> &#42; City</form:label>
                        <div class="col-sm-8">
                        	<form:input path="city" type="text"  id="aCity" value="" class="form-control" maxlength="40" onblur = "useHTML(this.id,document.getElementById('aCity').value)"/>
                        </div>
                    </div>
                    
                      <div class="form-group">
                    	<label path="school.schoolName" class="col-sm-3 control-label">&#42; Student</label>
                    	<div class="col-sm-8">
                    	<dl class="dropdown"> 
  
   						 <dt>
    						<a href="#">
      							<span class="hida form-control  ">Select</span>    
     						 	<p class="multiSel form-control"></p>  
    						</a>
    					</dt>
  
    					<dd>
        				<div class="mutliSelect " >
            				<ul>
            				
            				<c:forEach var="student" items="${studentList}">
                              <li> 	<input type="checkbox" value="${student.id}-${student.name}">${student.name}</li>
                        	</c:forEach>
                
            				</ul>
        				</div>
    					</dd>
  
						</dl>
                    	</div>
                    </div>
                   
                   
            		<div class="modal-footer text-center">
                    	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                    	<button type="submit" class="btn btn-sky btn-sm" >Save</button>
                	</div> 
                </form:form>               
			</div>
       		</div>
            
            
            
        </div>
    </div>
    
    <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      	<div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Edit </h4>
			  </div>
			 <form:form id="editForm" class="form-horizontal" method="POST" name="frm" action="${pageContext.request.contextPath}/schoolAdmin/parentList" commandName="schoolAdmin">
                
      
            <form:input path="id" id="parentId" class="form-control" type="hidden" />
           <input type="hidden" name="action" value="edit">
                <div class="form-group">
                        <form:label path="name" class="col-sm-3 control-label">&#42; Parent Name</form:label>
                        <div class="col-sm-8">
                        	<form:input path="name" type="text" id="name1" value="" class="form-control" maxlength="50" onblur = "useHTML(this.id,document.getElementById('aName').value)"/>
                        </div>
                   	</div>
  
                    <div class="form-group">
                       	<form:label path="username" class="col-sm-3 control-label">&#42; Username</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" path="username" id="username1" value="" class="form-control" maxlength="20" onblur = "checkUniqueUsername(); useHTML(this.id,document.getElementById('username').value);" />
                      	</div>
                    </div>
                  	
                  	<div class="form-group">
                        <form:label path="password" class="col-sm-3 control-label">&#42; Password </form:label>
                        <div class="col-sm-8">
                        	<form:input type="text" path="password" id="password1" value="" class="form-control" maxlength="20" onblur = "useHTML(this.id,document.getElementById('aPassword').value)"/>
                        </div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="school.schoolName" class="col-sm-3 control-label">&#42; School Name </form:label>
                        <div class="col-sm-8">
                        	<form:select path="school.schoolName" id="school1" class="form-control" >
                        		<form:option value="">Select</form:option>
                            	<c:forEach var="school" items="${schoolList}">
                               	<form:option value="${school.schoolName}">${school.schoolName}</form:option>
                        		</c:forEach>
                        	</form:select>
                       </div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="address" class="col-sm-3 control-label">&#42; Address </form:label>
                        <div class="col-sm-8">
                            <form:input  path="address" type="text" id="address1" value="" class="form-control" maxlength="80" onblur = "useHTML(this.id,document.getElementById('aAddress').value)"/>
                        </div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="email" class="col-sm-3 control-label">&#42; Email </form:label>
                        <div class="col-sm-8">
                            <form:input path="email" type="email" id="email1" class="form-control"  maxlength="30" />
                        </div>
                   	</div>
                    
                  	<div class="form-group">
                        <form:label path="age" class="col-sm-3 control-label">&#42; Age (Years) </form:label>
                        <div class="col-sm-8">
                        	<form:input path="age" type="number" min="1" step="1"  id="age1" value="" class="form-control" />
                        </div>
                    </div>
                    
                  	<div class="form-group">
                        <form:label path="city" class="col-sm-3 control-label">&#42; City </form:label>
                        <div class="col-sm-8">
                        	<form:input path="city" type="text"  id="city1" value="" class="form-control" maxlength="20" />
                        </div>
                    </div>
                    
                   
            		<div class="modal-footer text-center">
                    	<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                    	<button type="submit" class="btn btn-sky btn-sm" >Update</button>
                	</div> 
        </form:form>
            </div>
        </div>
    </div>
			  


