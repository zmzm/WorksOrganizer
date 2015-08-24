(function () {
    'use strict';

    angular.module('ClientApp.SignInCtrl', ['ngRoute'])
            .controller('SignInController', ['User',
                function (User) {
                    var vm = this;
                    vm.categories = [];
                    vm.c = [];
                }]);
})();