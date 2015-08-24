(function () {
    'use strict';
    
angular.module('ClientApp', [
  'ngRoute',
  'ClientApp.CategoryCtrl',
  'ClientApp.CategoryService',
  'ClientApp.ReportCtrl',
  'ClientApp.ReportService'
]).
config(['$routeProvider', function($routeProvider) {
$routeProvider
                .when('/', {
                    templateUrl: 'views/home.html'
                    //controller: 'CategoryController',
                    //controllerAs: 'vm'
                }).when('/category/:id', {
                    templateUrl: 'views/report.html',
                    controller: 'ReportController',
                    controllerAs: 'vm'
                })
                .otherwise({
                    redirectTo: '/'
                });
        }]);
})();