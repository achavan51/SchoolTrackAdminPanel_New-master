<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>School Track</title>
<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/favicon.png"/>
<!-- Bootstrap -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome/css/font-awesome.min.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.1.11.3.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular.min.1.2.27.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular-resource.min.1.2.27.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
function showProfile(){
	$.ajax({
		type :"GET",
		contentType : 'application/json',
		url  :"${pageContext.request.contextPath}/schooladmin/profile",
		success :function(object){
			$("#name").val(object.name);
			$("#accountType").val(object.accountType);
			$("#userName").val(object.userName);
			$("#password").val(object.password);
			$("#schoolId").val(object.school);
			$("#address").val(object.address);
			$("#email").val(object.email);
			$("#age").val(object.age);
			$("#city").val(object.city);
			
		},
		error : function(e){
			alert("Errorrr");
		}
		
	})
	$("#schoolAdmin").modal('show');
}
</script>
</head>
<body>
	<div id="wrapper">
    
        <!-- Navigation -->
        <div class="header">
            <div class="top-head clearfix">
                <div class="header-logo">
                	<a class="navbar-brand" href="javascript:void(0);"> 
                    	<img src="${pageContext.request.contextPath}/resources/images/logo/logo.png" id="logo"> 
                  	</a>
                </div>                
                <ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle profile-img"
						data-toggle="dropdown" href="javascript:void(0);"> <img
							src="${pageContext.request.contextPath}/resources/images/profile-pic.jpg"> ${userName}<i
							class="fa fa-caret-down"></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<!-- <li><a href="#"><i class="fa fa-th-large"></i>&nbsp;
									Portal</a></li> -->
							<li><a  onclick="showProfile()"><i
									class="fa fa-user fa-fw"></i> User Profile</a></li>
							<li class="divider"></li>
							<li><a href="${pageContext.request.contextPath}/j_spring_security_logout"><i class="fa fa-sign-out fa-fw"></i>
									Logout</a></li>
						</ul> <!-- /.dropdown-user --></li>
					<!-- /.dropdown -->
					</ul>
                <!-- /.navbar-top-links -->
            </div>
        </div>
        <!-- /.header -->
        
        <nav class="navbar navbar-default main-menu" role="navigation">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#dashboard-menu">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
            </div>
        
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="dashboard-menu">
            	<tiles:insertAttribute name="header" />
                
                <%-- <ul class="nav navbar-nav navbar-right">
                    <!--  <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
                    <li><a href="${pageContext.request.contextPath}/j_spring_security_logout"><i class="fa fa-power-off"></i> Logout</a></li>
                </ul> --%>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
        
        <div class="page-container">
            <div id="page-wrapper" class="wrapper-fluid">
                <div class="container-fluid">
        			<tiles:insertAttribute name="body" />
               	</div>
          	</div>
       	</div>
        
        <div class="footer">
        	Copyright 2015 Ciweb Tech LLC
      	</div>
        
        
 <div class="modal fade" id="schoolAdmin" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">School Admin Details</h4>
            </div>
            <div class="modal-body">
                <form id="registerForm"  class="form-horizontal" role="form" name="registerForm">
                
                
                <div class="form-group">
                        <label class="col-sm-3 control-label">Admin Name &#42;</label>
                        <div class="col-sm-8">
                        	<input type="text" name="name" id="name" value="" class="form-control" maxlength="50" readonly="readonly">
                        </div>
                   	</div>
              
                  	<div class="form-group">
                        <label class="col-sm-3 control-label">Account Type &#42;</label>
                        <div class="col-sm-8">
                            <input type="text" name="accountType" id="accountType" value="" class="form-control" maxlength="50" readonly="readonly">
                     	</div>
                    </div>
                    
                    <div class="form-group">
                       	<label class="col-sm-3 control-label">User Name &#42;</label>
                        <div class="col-sm-8">
                            <input type="text" name="username" id="userName" value="" class="form-control" maxlength="10" readonly="readonly">
                      	</div>
                    </div>
                  	
                    
                  	<div class="form-group">
                        <label class="col-sm-3 control-label">School Name &#42;</label>
                        <div class="col-sm-8">
                         <input type="text" name="schoolId" id="schoolId" value="" class="form-control" maxlength="10" readonly="readonly">
                       </div>
                    </div>
                    
                  	<div class="form-group">
                        <label class="col-sm-3 control-label">Address &#42;</label>
                        <div class="col-sm-8">
                            <input type="text" name="address" id="address" value="" class="form-control" readonly="readonly" >
                        </div>
                    </div>
                    
                  	<div class="form-group">
                        <label class="col-sm-3 control-label">Email &#42;</label>
                        <div class="col-sm-8">
                            <input type="email" name="email" id="email" value="" class="form-control" readonly="readonly">
                        </div>
                   	</div>
                    
                  	<div class="form-group">
                        <label class="col-sm-3 control-label">Age &#42;</label>
                        <div class="col-sm-8">
                        	<input type="number" name="age" id="age" value="" class="form-control" readonly="readonly">
                        </div>
                    </div>
                    
                  	<div class="form-group">
                        <label class="col-sm-3 control-label">City &#42;</label>
                        <div class="col-sm-8">
                        	<input type="text" name="city" id="city" value="" class="form-control" readonly="readonly">
                        </div>
                    </div>
                    
            		<div class="modal-footer text-center">
                </div> 
                </form>               
			</div>
                   
				
       		</div>
			
		</div>
	</div>
</div>
	</body>
</html>
