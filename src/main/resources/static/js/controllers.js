angular.module('App.Controllers')

// App Controller
    .controller('AppController', ['$scope','CustomerDataService',
        function($scope,CustomerDataService) {
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
                console.log($scope.data);
                var errors = validate($scope.data);
                if(errors.length == 0)
                    getFilterData($scope.data);
                else{
                    document.querySelector(".errors").innerHTML = "Erorrrrrrr";
                    document.querySelector(".btn btn-primary").disabled = true;
                }
            };

            var validate = function (data) {
                var errors = [];
                if(parseInt(data.minAge.value) > parseInt(data.maxAge.value)) errors.push("age");
                if(parseInt(data.minScore.value) > parseInt(data.maxScore.value)) errors.push("score");
                if(parseInt(data.minHeight.value) > parseInt(data.maxHeight.value)) errors.push("height");
                return errors;

            }

            var getFilterData = function (data) {
                CustomerDataService.getFilterData(data).then(function (response) {
                    console.log(response.data);
                    $scope.fetchedData = response;
                });
            };

            (function () {
                getFilterData(null); // initial request to display all results.
            })();

        }
    ]);
