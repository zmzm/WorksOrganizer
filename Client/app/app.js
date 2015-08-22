(function () {
    'use strict';
    
angular.module('ClientApp', [
  'ngRoute',
  'ClientApp.CategoryCtrl',
  'ClientApp.CategoryService'
]).
config(['$routeProvider', function($routeProvider) {
$routeProvider
                .when('/view1', {
                    templateUrl: 'views/view1.html',
                    controller: 'CategoryController',
                    controllerAs: 'vm'
                })
                .otherwise({
                    redirectTo: '/view1'
                });
        }]);
})();