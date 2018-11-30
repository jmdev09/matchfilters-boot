angular.module('App.Services')
    .service('CustomerDataService', ['$http',
        function($http) {

            var getFilterData = function (data) {
                var params = constructParams(data);
                return $http.get("http://localhost:9099/results?" + params).then(function (result) {
                    return result.data;
                });
            };

            var constructParams = function (data) {
                if(data == null) return '';
                var minAge = data.minAge.value;
                var maxAge = data.maxAge.value;
                var minHeight = data.minHeight.value;
                var maxHeight = data.maxHeight.value;
                var minScore = data.minScore.value;
                var maxScore = data.maxScore.value;
                var inContact = data.inContact.value;
                var photo = data.photo.value;
                var favourite = data.favourite.value;
                var distance = data.distance.value;

                var params = "minAge="+minAge+"&maxAge="+maxAge+"&minHeight="+minHeight+"&maxHeight="+maxHeight+"&minScore="+minScore+"&maxScore="+maxScore+"&photo="+photo+"&favourite="+favourite+"&inContact="+inContact+"&distance="+distance;

                return params;
            };

            return {
                getFilterData:getFilterData
            }

        }
    ]);