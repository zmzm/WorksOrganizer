(function () {
    angular.module('ClientApp.StepService', []).service('Step', ['$http',
        function ($http) {
            return({
                GetAll: GetAll,
                GetById: GetById,
                Update: Update,
                Delete: Delete,
                Create: Create,
                GetByProcess:GetByProcess
            });

            $http.defaults.useXDomain = true;
            
            function GetAll() {
                return $http.get('http://localhost:8080/Server/processstep/list').then(handleSuccess, handleError('Error getting Category list'));
            }

            function GetById(id) {
                return $http.get('http://localhost:8080/Server/processstep/' + id).then(handleSuccess, handleError('Error getting Category'));
            }

            function Update(data) {
                return $http.put('http://localhost:8080/Server/processstep', data).then(handleSuccess, handleError('Error updating Category'));
            }

            function Delete(id) {
                return $http.delete('http://localhost:8080/Server/processstep/' + id).then(handleSuccess, handleError('Error deleting Category'));
            }

            function Create(data) {
                return $http.post('http://localhost:8080/Server/processstep', data).then(handleSuccess, handleError('Error creating Category'));
            }
            
            function GetByProcess(data) {
                return $http.post('http://localhost:8080/Server/processstep/process', data).then(handleSuccess, handleError('Error creating Category'));
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