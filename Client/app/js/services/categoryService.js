(function () {

    angular.module('ClientApp.CategoryService', []).service('Category', ['$http',
        function ($http) {
            return({
                GetAll: GetAll
            });

            function GetAll() {
                var request = $http({
                    method: 'GET',
                    url: 'http://localhost:8080/Server/category/list',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
                return request.then(handleSuccess, handleError('Error getting Category list'));
            }

            function handleSuccess(response) {
                return response.data;
            }

            function handleError(error) {
                return function () {
                    return {success: false, message: error};
                };
            }
        }

    ]);

})();