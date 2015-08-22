(function () {
    'use strict';

    angular.module('ClientApp.CategoryCtrl', ['ngRoute'])
            .controller('CategoryController', ['Category',
                function (Category) {
                    var vm = this;
                    vm.categories = [];
                    Categorylist();

                    function Categorylist() {
                        Category.GetAll()
                                .then(function (data) {
                                    vm.categories = data;
                                    console.log(vm.categories);
                                });
                    }
                    ;

                }]);
})();