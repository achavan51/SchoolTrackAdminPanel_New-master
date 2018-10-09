<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container-fluid">
    <div class="page-dashboard">
        <div class="row">
            <div class="col-md-2 col-md-offset-1 col-sm-3">
           		<a href="${pageContext.request.contextPath}/route/routeMap" class="menu-link">
                    <div class="menu-block m-block1">
                        <div class="menu-icon"><i class="fa fa-map-marker"></i></div>
                        <div class="menu-name">Routes</div>
                    </div>
                </a>
            </div>
            
            <div class="col-md-2 col-sm-3">
            	<a href="${pageContext.request.contextPath}/schoolAdmin/parentList" class="menu-link">
                    <div class="menu-block m-block2">
                        <div class="menu-icon"><i class="fa fa-users"></i></div>
                        <div class="menu-name">Parents</div>
                    </div>
                </a>
            </div>
            
            <div class="col-md-2 col-sm-3">
            	<a href="${pageContext.request.contextPath}/schoolAdmin/studentList" class="menu-link">
                    <div class="menu-block m-block3">
                        <div class="menu-icon"><i class="fa fa-male"></i></div>
                        <div class="menu-name">Students</div>
                    </div>
                </a>
            </div>
            
            <div class="col-md-2 col-sm-3">
            	<a href="${pageContext.request.contextPath}/route/busList" class="menu-link">
                    <div class="menu-block m-block4">
                        <div class="menu-icon"><i class="fa fa-bus"></i></div>
                        <div class="menu-name">Vehicles</div>
                    </div>
                </a>
            </div>
            
            <div class="col-md-2 col-sm-3">
               <a href="${pageContext.request.contextPath}/route/driverList" class="menu-link">
                    <div class="menu-block m-block5">
                        <div class="menu-icon"><i class="fa fa-user"></i></div>
                        <div class="menu-name">Drivers</div>
                    </div>
                </a>
            </div>
            
             <div class="col-md-2 col-md-offset-4 col-sm-3">
            	<a href="${pageContext.request.contextPath}/extintor/extintorList" class="menu-link">
                    <div class="menu-block m-block4">
                        <div class="menu-icon"><i class="fa fa-fire-extinguisher"></i></div>
                        <div class="menu-name">Extintor</div>
                    </div>
                </a>
            </div>
            
            <div class="col-md-2 col-md-offset-0 col-sm-3">
               <a href="${pageContext.request.contextPath}/newsletter/newsletterList" class="menu-link">
                    <div class="menu-block m-block1">
                        <div class="menu-icon"><i class="fa fa-newspaper-o"></i></div>
                        <div class="menu-name">Newsletter</div>
                    </div>
                </a>
            </div>
             <div class="col-md-2 col-md-offset-0 col-sm-3">
              <a href="${pageContext.request.contextPath}/device/deviceList" class="menu-link"> 
                    <div class="menu-block m-block2">
                        <div class="menu-icon"><i class="fa fa-camera-retro fa-lg"></i></div>
                        <div class="menu-name">Device</div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>