(function () {
    'use strict';

    angular.module('ClientApp.CategoryCtrl', ['ngRoute'])
            .controller('CategoryController', ['Category','$rootScope',
                function (Category, $rootScope) {
                    var vm = this;
                    vm.categories = [];
                    vm.c = [];
                    Categorylist();

                    function Categorylist() {
                       // if ($rootScope.globals.currentUser !== undefined) {
                            console.log($rootScope.globals);
                            Category.GetAll()
                                    .then(function (data) {
                                        vm.categories = data;
                                        console.log(vm.categories);
                                    });
                       // }
                    }
                    ;

                    vm.DeleteCategory = function (category) {
                        Category.Delete(category.id)
                                .then(Categorylist());
                    };

                    vm.GetById = function (category) {
                        Category.GetById(category.id)
                                .then(function (data) {
                                    vm.c = data;
                                    alert(vm.c.categoryName);
                                });
                    };

                }]);
})();