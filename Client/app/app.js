(function () {
    'use strict';

    angular.module('ClientApp', [
        'ngRoute',
        'ClientApp.CategoryCtrl',
        'ClientApp.CategoryService',
        'ClientApp.ReportCtrl',
        'ClientApp.ReportService',
        'ClientApp.UserService',
        'ClientApp.SignInCtrl',
        'ClientApp.LogInCtrl',
        'ClientApp.Auth',
        'ClientApp.StepCtrl',
        'ClientApp.StepService',
        'ClientApp.FieldCtrl',
        'ClientApp.FieldService',
        'ClientApp.AdminCtrl',
        'ClientApp.ProcessService',
        'ClientApp.MetaFieldService',
        'ui.bootstrap'
    ]).
            config(['$routeProvider', function ($routeProvider) {
                    $routeProvider
                            .when('/', {
                                templateUrl: 'views/home.html'
                            }).when('/category/:id', {
                        templateUrl: 'views/report.html',
                        controller: 'ReportController',
                        controllerAs: 'vm'
                    }).when('/signup', {
                        templateUrl: 'views/signin.html',
                        controller: 'SignInController',
                        controllerAs: 'vm'
                    }).when('/login', {
                        templateUrl: 'views/login.html',
                        controller: 'LogInController',
                        controllerAs: 'vm'
                    }).when('/report/:id', {
                        templateUrl: 'views/step.html',
                        controller: 'StepController',
                        controllerAs: 'vm'
                    }).when('/dashboard', {
                        templateUrl: 'views/adminPage.html',
                        controller: 'AdminController',
                        controllerAs: 'vm'
                    })
                            .otherwise({
                                redirectTo: '/'
                            });
                }]);

    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/signup', '/login']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/signup');
            }
        });
    }
})();