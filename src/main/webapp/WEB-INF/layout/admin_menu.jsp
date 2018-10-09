<!-- <style>
#adminMenu{
  margin-left: 23px;
  margin-top: 40px;
}
</style>
<div id="adminMenu" ng-app="adminMenuApp" ng-controller="adminMenuCtrl">
<input class="btn btn-primary btn-sm" type="button" value="Add Employee" ng-click="addEmployee()" style="width: 140px"><br><br> 
<input class="btn btn-primary btn-sm" type="button" value="Add Client" ng-click="addClient()" style="width: 140px"><br><br> 
<input class="btn btn-primary btn-sm" type="button" value="Add Project" ng-click="addProject()" style="width: 140px"><br><br> 
<input class="btn btn-primary btn-sm"  type="button" value="Add Holiday" ng-click="addHoliday()" style="width: 140px"><br><br>
<input class="btn btn-primary btn-sm"  type="button" value="Add EmpProject" ng-click="addEmployeeProject()" style="width: 140px">
</div>
<script>

 var app = angular.module('adminMenuApp', []);
 app.controller('adminMenuCtrl', ['$scope','$window',function($scope,$window) {
     $scope.addEmployee = function() {
        $window.location.href="addEmployee";
     };
     $scope.addClient = function() {
         $window.location.href="addClient";
     };
     $scope.addProject = function() {
         $window.location.href="addProject";
      };
     $scope.addHoliday = function() {
         $window.location.href="addHoliday";
      };
       $scope.addEmployeeProject = function() {
          $window.location.href="addEmployeeProject";
       }; 
          
}]);
 
 

</script> -->