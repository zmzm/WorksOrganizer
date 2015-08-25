(function () {
    'use strict';

    angular.module('ClientApp.LogInCtrl', ['ngRoute'])
            .controller('LogInController', ['AuthenticationService', '$location','$rootScope',
                function (AuthenticationService, $location, $rootScope) {
                    var vm = this;
                    
                    vm.login = function () {
                        vm.dataLoading = true;
                        AuthenticationService.Login(vm.username, vm.password, function (response, user) {
                            if (response.success) {
                                AuthenticationService.SetCredentials(vm.username, vm.password, user.roleId.roleName);
                                $location.path('/');
                            } else {
                                vm.dataLoading = false;
                                vm.error = response.message;
                            }
                        });
                    };
                }]);
})();