(function () {
    angular.module('ClientApp.ReportService', []).service('Report', ['$http',
        function ($http) {
            return({
                GetAll: GetAll,
                GetById: GetById,
                Update: Update,
                Delete: Delete,
                Create: Create,
                GetByCategory: GetByCategory
            });
            $http.defaults.useXDomain = true;
            $http.defaults.headers.post["Content-Type"] = "application/json";
            function GetAll() {
                return $http.get('http://localhost:8080/Server/report/list').then(handleSuccess, handleError('Error getting Report list'));
            }

            function GetById(id) {
                return $http.get('http://localhost:8080/Server/report/' + id).then(handleSuccess, handleError('Error getting Report'));
            }

            function Update(data) {
                return $http.put('http://localhost:8080/Server/report', data).then(handleSuccess, handleError('Error updating Report'));
            }

            function Delete(id) {
                return $http.delete('http://localhost:8080/Server/report/' + id).then(handleSuccess, handleError('Error deleting Report'));
            }

            function Create(data) {
                return $http.delete('http://localhost:8080/Server/report', data).then(handleSuccess, handleError('Error creating Report'));
            }

            function GetByCategory(category) {
                return $http.post('http://localhost:8080/Server/report/category', category).then(handleSuccess, handleError('Error getting Report'));
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