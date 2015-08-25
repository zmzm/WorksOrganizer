(function () {
    'use strict';

    angular.module('ClientApp.StepCtrl', ['ngRoute'])
            .controller('StepController', ['Step', '$routeParams',
                function (Step, $routeParams) {
                    var vm = this;
                    vm.steps = [];
                    GetByProcess();

                    function GetByProcess() {
                        Step.GetByProcess({id: $routeParams.id})
                                .then(function (data) {
                                    vm.steps = data;
                                    console.log(vm.steps);
                                });
                    }
                    ;

                }]);
})();