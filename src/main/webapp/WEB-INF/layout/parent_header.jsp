
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     <!--  <a class="navbar-brand" href="#">WebSiteName</a> -->
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" style="width: 1261px;">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        
        <li><a href="#">Parent Menu</a></li>
         <li><a href="#">Parent Menu</a></li>
        <li><a href="#">Parent Menu</a></li>
        <li><a href="#">Bus Details</a></li>
       
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <!--  <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
        <li><a style="visibility:hidden" href="${pageContext.request.contextPath}/j_spring_security_logout"><span class="glyphicon glyphicon-log-in"></span>hhLogout</a></li>
      </ul> 
    </div>
  </div>
</nav>