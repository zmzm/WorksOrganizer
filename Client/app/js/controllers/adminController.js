(function () {
    'use strict';

    angular.module('ClientApp.AdminCtrl', ['ngRoute'])
            .controller('AdminController', ['Field', 'Report', 'Step', 'Category', 'User',
                function (Field, Report, Step, Category, User) {
                    var vm = this;
                    GetReportCount();
                    GetCategoryCount();
                    GetUserCount();
                    GetStepCount();

                    function GetReportCount() {
                        Report.GetAll()
                                .then(function (data) {
                                    vm.reportCount = data.length;
                                });
                    }
                    ;
                    function GetCategoryCount() {
                        Category.GetAll()
                                .then(function (data) {
                                    vm.categoryCount = data.length;
                                });
                    }
                    ;
                    function GetUserCount() {
                        User.GetAll()
                                .then(function (data) {
                                    vm.userCount = data.length;
                                });
                    }
                    ;
                    function GetStepCount() {
                        Step.GetAll()
                                .then(function (data) {
                                    vm.stepCount = data.length;
                                });
                    }
                    ;
                }]);
})();


