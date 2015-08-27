(function () {
    'use strict';

    angular.module('ClientApp.LogInCtrl', ['ngRoute'])
            .controller('LogInController', ['AuthenticationService', '$location', '$rootScope',
                function (AuthenticationService, $location, $rootScope) {
                    var vm = this;
                    initController();
                    
                    function initController() {
                        AuthenticationService.ClearCredentials();
                    };

                    vm.login = function () {
                        vm.dataLoading = true;
                        AuthenticationService.Login(vm.username, vm.password, function (response, user) {
                            if (response.success) {
                                AuthenticationService.SetCredentials(vm.username, vm.password, user.roleId.roleName);
                                $location.path('/');
                                console.log($rootScope.globals);
                            } else {
                                vm.dataLoading = false;
                                vm.error = response.message;
                            }
                        });
                    };
                }]);
})();