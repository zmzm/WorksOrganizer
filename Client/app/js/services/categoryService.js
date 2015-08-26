(function () {
    angular.module('ClientApp.CategoryService', []).service('Category', ['$http',
        function ($http) {
            return({
                GetAll: GetAll,
                GetById: GetById,
                Update: Update,
                Delete: Delete,
                Create: Create
            });

            $http.defaults.useXDomain = true;
            
            function GetAll() {
                return $http.get('http://localhost:8080/Server/category/list').then(handleSuccess, handleError('Error getting Category list'));
            }

            function GetById(id) {
                return $http.get('http://localhost:8080/Server/category/' + id).then(handleSuccess, handleError('Error getting Category'));
            }

            function Update(data) {
                return $http.put('http://localhost:8080/Server/category', data).then(handleSuccess, handleError('Error updating Category'));
            }

            function Delete(id) {
                return $http.delete('http://localhost:8080/Server/category/' + id).then(handleSuccess, handleError('Error deleting Category'));
            }

            function Create(data) {
                return $http.post('http://localhost:8080/Server/category', data).then(handleSuccess, handleError('Error creating Category'));
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