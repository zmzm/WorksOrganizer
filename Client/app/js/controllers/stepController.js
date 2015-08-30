(function () {
    'use strict';

    angular.module('ClientApp.StepCtrl', ['ngRoute'])
            .controller('StepController', ['Step', 'Field', '$routeParams', '$timeout',
                function (Step, Field, $routeParams, $timeout) {
                    var vm = this;
                    GetByProcess();

                    function GetByProcess() {
                        Step.GetByProcess({id: $routeParams.id})
                                .then(function (data) {
                                    vm.steps = data;
                                    console.log(vm.stepStatus);
                                });
                    }
                    ;
                    vm.GetFields = function (step) {
                        Field.GetByStep(step)
                                .then(function (data) {
                                    vm.fields = data;
                                });
                    };

                    vm.Save = function (field, value) {
                        Field.Update({id: field.id, name: field.name, value: value, meta: field.meta, step: field.step})
                                .then(function (response) {
                                    var info = response;
                                });

                        $timeout(function () {
                            Field.GetByStep(field.step)
                                    .then(function (data) {
                                        vm.fields = data;
                                        var newCount = 0;
                                        var inprogressCount = 0;
                                        for (var i = 0; i < vm.fields.length; i++) {
                                            if (vm.fields[i].value === undefined) {
                                                newCount++;
                                            }
                                            else {
                                                inprogressCount++;
                                            }
                                        }

                                        if (inprogressCount > 0 && inprogressCount < vm.fields.length) {
                                            vm.stepStatus = 'In progress';
                                        }
                                        else if (inprogressCount === vm.fields.length) {
                                            vm.stepStatus = 'Finished';
                                        }
                                        else {
                                            vm.stepStatus = 'New';
                                        }
                                    });
                        }, 250);

                        $timeout(function () {
                            Step.Update({id: field.step.id, name: field.step.name, priority: field.step.priority,
                                process: field.step.process, status: vm.stepStatus, user: field.step.user});
                        }, 350);
                    };

                }])
            .directive('myStatus', function () {
                return {
                    link: function (scope, element, attrs) {
                        attrs.$observe("myStatus", function (val) {
                            if (val === 'Finished') {
                                element.html("<span class='label label-sm label-success'>" + attrs.myStatus + "</span>");
                            }
                            else if (val === 'In progress') {
                                element.html("<span class='label label-sm label-warning'>" + attrs.myStatus + "</span>");
                            }
                            else {
                                element.html("<span class='label label-sm label-primary'>" + attrs.myStatus + "</span>");
                            }
                        });
                    }
                };

            });
})();