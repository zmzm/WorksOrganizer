(function () {
    'use strict';

    angular.module('ClientApp.AdminCtrl', ['ngRoute'])
            .controller('AdminController', ['Field', 'Report', 'Step', 'Category', 'User', 'Process', 'MetaField',
                function (Field, Report, Step, Category, User, Process, MetaField) {
                    var vm = this;
                    vm.tab = 2;
                    GetReportCount();
                    GetCategoryCount();
                    GetUserCount();
                    GetStepCount();
                    GetProcessCount();
                    GetMetaFieldCount();

                    vm.setTab = function (newTab) {
                        vm.tab = newTab;
                    };

                    vm.isSet = function (tabNum) {
                        return vm.tab === tabNum;
                    };

                    function GetReportCount() {
                        Report.GetAll()
                                .then(function (data) {
                                    vm.reportCount = data.length;
                                });
                    }
                    function GetMetaFieldCount() {
                        MetaField.GetAll()
                                .then(function (data) {
                                    vm.metaFieldCount = data.length;
                                    vm.metaFields = data;
                                });
                    }
                    ;
                    function GetProcessCount() {
                        Process.GetAll()
                                .then(function (data) {
                                    vm.processCount = data.length;
                                    vm.processes = data;
                                });
                    }
                    ;
                    function GetCategoryCount() {
                        Category.GetAll()
                                .then(function (data) {
                                    vm.categoryCount = data.length;
                                    vm.categories = data;
                                });
                    }
                    ;
                    function GetUserCount() {
                        User.GetAll()
                                .then(function (data) {
                                    vm.userCount = data.length;
                                    vm.users = data;
                                    console.log(vm.users);
                                });
                    }
                    ;
                    function GetStepCount() {
                        Step.GetAll()
                                .then(function (data) {
                                    vm.stepCount = data.length;
                                    vm.steps = data;
                                });
                    }
                    ;
                    /*vm.AddCategory = function () {
                     vm.c = {categoryName: vm.categoryName};
                     Category.Create(vm.c)
                     .then(function (data) {
                     vm.info = data;
                     console.log(vm.info);
                     });
                     };*/
                    vm.AddReport = function () {
                        Report.Create({name: vm.reportName, process: {id: vm.p}, category: {id: vm.c}})
                                .then(function (data) {
                                    vm.info = data;
                                    console.log(vm.info);
                                });
                    };
                    vm.AddProcess = function () {
                        Process.Create({name: vm.processName})
                                .then(function (data) {
                                    vm.info = data;
                                    console.log(vm.info);
                                });
                    };
                    vm.AddProcessStep = function () {
                        vm.step = {name: vm.stepName, priority: vm.priorityStep, status: vm.status, process: {id: vm.stepProcess}, user: {id: vm.userStep}};
                        Step.Create(vm.step)
                                .then(function (data) {
                                    vm.info = data;
                                    console.log(vm.info);
                                });
                    };
                    vm.AddField = function () {
                        vm.field = {name: vm.fieldName, value: "", meta: {id: vm.fieldMeta}, step: {id: vm.fieldStep}};
                        console.log(vm.field);
                        Field.Create(vm.field)
                         .then(function (data) {
                         vm.info = data;
                         console.log(vm.info);
                         });
                    };
                }]);
})();


