angular.module('App.Controllers')

// App Controller
    .controller('AppController', ['$scope','CustomerDataService',
        function($scope,CustomerDataService) {
            $scope.validatedError = false;
            $scope.data={
                "photo":{
                    "value":"all"
                },
                "inContact":{
                    "value":"all"
                },
                "favourite":{
                    "value":"all"
                },
                "minScore":{
                    "value":"1"
                },
                "maxScore":{
                    "value":"99"
                },
                "minAge":{
                    "value":"18"
                },
                "maxAge":{
                    "value":"99"
                },
                "minHeight":{
                    "value":"135"
                },
                "maxHeight":{
                    "value":"210"
                },
                "distance":{
                    "value":"300"
                }
            };

            $scope.submit = function () {
                //console.log($scope.data);
                if((parseInt($scope.data.minAge.value) > parseInt($scope.data.maxAge.value)) || (parseInt($scope.data.minScore.value) > parseInt($scope.data.maxScore.value)) || (parseInt($scope.data.minHeight.value) > parseInt($scope.data.maxHeight.value))){
                    $scope.validatedError = true;
                }else{
                    $scope.validatedError = false;
                    getFilterData($scope.data);
                }
            };

            var getFilterData = function (data) {
                CustomerDataService.getFilterData(data).then(function (response) {
                    console.log(response);
                    if(response.length == 0) $scope.noResults = true;
                    else $scope.noResults = false;
                    $scope.fetchedData = response;
                });
            };

            (function () {
                getFilterData(null); // initial request to display all results.
            })();

        }
    ]);
