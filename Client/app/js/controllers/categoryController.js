(function () {
    'use strict';

    angular.module('ClientApp.CategoryCtrl', [])
            .controller('CategoryController', ['Category', '$rootScope',
                function (Category, $rootScope) {
                    $('#main-menu').metisMenu();
                    var vm = this;
                    vm.categories = [];
                    vm.c = [];
                    Categorylist();

                    function Categorylist() {
                        Category.GetAll()
                                .then(function (data) {
                                    vm.categories = data;
                                    console.log(vm.categories);
                                });
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