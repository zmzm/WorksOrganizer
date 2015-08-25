(function () {
    'use strict';

    angular.module('ClientApp.FieldCtrl', ['ngRoute'])
            .controller('FieldController', ['Field', '$routeParams',
                function (Field, $routeParams) {
                    var vm = this;
                    vm.fields = [];
                    GetByStep();

                    function GetByStep() {
                        Field.GetByStep({id: $routeParams.id})
                                .then(function (data) {
                                    vm.fields = data;
                                    console.log(vm.fields);
                                });
                    }
                    ;

                }]);
})();