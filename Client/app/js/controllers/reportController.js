(function () {
    'use strict';

    angular.module('ClientApp.ReportCtrl', ['ngRoute'])
            .controller('ReportController', ['Report', '$routeParams', 'Step',
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

                    function CheckReportStatus(report) {
                         vm.reportStatus = [];
                        for (var j = 0; j < report.length; j++) {
                            Step.GetByProcess({id: report[j].process.id})
                                    .then(function (data) {
                                        vm.steps = data;
                                        console.log(vm.steps);
                                        var newCount = 0;
                                        var inProgressCount = 0;
                                        var finishedCount = 0;
                                        for (var i = 0; i < vm.steps.length; i++) {
                                            if (vm.steps[i].status === 'New') {
                                                newCount++;
                                            }
                                            else if (vm.steps[i].status === 'In progress') {
                                                inProgressCount++;
                                            }
                                            else {
                                                finishedCount++;
                                            }
                                        }
                                        if (inProgressCount > 0 || finishedCount < vm.steps.length) {
                                            vm.reportStatus = "In progress";
                                        }
                                        if (finishedCount === vm.steps.length) {
                                            vm.reportStatus = "Finished";
                                        }
                                        if (newCount === vm.steps.length) {
                                            vm.reportStatus = "New";
                                        }
                                    });
                        }
                    }
                    ;

                    function GetReport() {
                        console.log($routeParams.id);
                        Report.GetByCategory({id: $routeParams.id})
                                .then(function (data) {
                                    vm.r = data;
                                    CheckReportStatus(vm.r);
                                });
                    }
                    ;

                }]);
})();