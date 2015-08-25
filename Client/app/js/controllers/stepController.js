(function () {
    'use strict';

    angular.module('ClientApp.StepCtrl', ['ngRoute'])
            .controller('StepController', ['Step', 'Field', '$routeParams',
                function (Step, Field, $routeParams) {
                    var vm = this;
                    GetByProcess();

                    function GetByProcess() {
                        Step.GetByProcess({id: $routeParams.id})
                                .then(function (data) {
                                    vm.steps = data;
                                    console.log(vm.steps.length);
                                });
                    }
                    ;
                    vm.GetFields = function (step) {
                        Field.GetByStep(step)
                                .then(function (data) {
                                    vm.fields = data;
                                    console.log(vm.fields);
                                });
                    };

                }]);
})();