(function () {
    angular.module('ClientApp.RoleService', []).service('Role', ['$http',
        function ($http) {
            return({
                GetAll: GetAll,
                GetById: GetById,
                Update: Update,
                Delete: Delete,
                Create: Create
            });
            $http.defaults.useXDomain = true;
            $http.defaults.headers.post["Content-Type"] = "application/json";
            function GetAll() {
                return $http.get('http://localhost:8080/Server/role/list').then(handleSuccess, handleError('Error getting Report list'));
            }

            function GetById(id) {
                return $http.get('http://localhost:8080/Server/role/' + id).then(handleSuccess, handleError('Error getting Report'));
            }

            function Update(data) {
                return $http.put('http://localhost:8080/Server/role', data).then(handleSuccess, handleError('Error updating Report'));
            }

            function Delete(id) {
                return $http.delete('http://localhost:8080/Server/role/' + id).then(handleSuccess, handleError('Error deleting Report'));
            }

            function Create(data) {
                return $http.post('http://localhost:8080/Server/role', data).then(handleSuccess, handleError('Error creating Report'));
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