(function () {
    'use strict';

    angular.module('ClientApp.ReportGeneratorCtrl', ['ngRoute'])
            .controller('ReportGeneratorController', ['Step', '$routeParams', 'Field', 'Report',
                function (Step, $routeParams, Field, Report) {
                    var vm = this;
                    Get();

                    function Get() {
                        vm.status = true;
                        vm.rfields = [];
                        console.log($routeParams.id1, $routeParams.id2);
                        Step.GetByProcess({id: $routeParams.id1})
                                .then(function (data) {
                                    vm.rsteps = data;
                                    if (vm.rsteps.length === 0) {
                                        swal({title: "Oops!",
                                            text: "Go back and fill all steps.",
                                            type: "error",
                                            showCancelButton: false,
                                            confirmButtonColor: "#DD6B55",
                                            confirmButtonText: "Go back!",
                                            closeOnConfirm: true},
                                        function () {
                                            window.location.href = '#/';
                                        });
                                    }
                                    else {
                                        var j = 0;
                                        for (var i = 0; i < vm.rsteps.length; i++) {
                                            if (vm.rsteps[i].status !== "Finished") {
                                                vm.status = false;
                                                swal({title: "Oops!",
                                                    text: "Go back and fill all steps.",
                                                    type: "error",
                                                    showCancelButton: false,
                                                    confirmButtonColor: "#DD6B55",
                                                    confirmButtonText: "Go back!",
                                                    closeOnConfirm: true},
                                                function () {
                                                    window.location.href = '#/';
                                                });
                                            }
                                            else {
                                                Field.GetByStep(vm.rsteps[i])
                                                        .then(function (data) {
                                                            vm.rfields[j] = data;
                                                            j++;
                                                            console.log(vm.rfields[0]);
                                                        });
                                            }
                                        }
                                    }
                                });
                                Report.GetById($routeParams.id2)
                                        .then(function(data){
                                            vm.report = data;
                                        });
                    }
                    ;
                }]);
})();