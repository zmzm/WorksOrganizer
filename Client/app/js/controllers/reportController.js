(function () {
    'use strict';

    angular.module('ClientApp.ReportCtrl', ['ngRoute'])
            .controller('ReportController', ['Report', '$routeParams','Step',
                function (Report, $routeParams, Step) {
                    var vm = this;
                    vm.reports = [];
                    vm.r = [];
                    GetReport();
                    //ReportList();

                    function Reportlist() {
                        Report.GetAll()
                                .then(function (data) {
                                    vm.reports = data;
                                });
                    }
                    ;

                    vm.DeleteReport = function (report) {
                        Report.Delete(report.id)
                                .then(Reportlist());
                    };

                    vm.GetById = function (report) {
                        Report.GetById(report.id)
                                .then(function (data) {
                                    vm.r = data;
                                    alert(vm.r.name);
                                });
                    };

                    vm.CheckReportStatus = function (report) {
                        vm.status = false;
                        Step.GetByProcess({id: report.process.id})
                                .then(function (data) {
                                    vm.steps = data;
                                    console.log(vm.steps);
                                });
                    };

                    function GetReport() {
                        console.log($routeParams.id)
                        Report.GetByCategory({id: $routeParams.id})
                                .then(function (data) {
                                    vm.r = data;
                                    console.log(vm.r);
                                });
                    }
                    ;

                }]);
})();