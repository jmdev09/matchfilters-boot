angular.module('App.Services')
  .service('CustomerDataService', ['$http', '$rootScope',
    function($http, $rootScope) {

      // // notify app about service error:
      // function reportError(process, err) {
      //   err.process = process;
      //   $rootScope.$broadcast('SERVICE_ERROR', err);
      // }
      //
      // // mock service to return dummy data:
      // this.getCustomers = function() {
      //   var request = $http.get('customer-data.json');
      //   request.error(function(err) {
      //     reportError('getCustomers', err);
      //   });
      //
      //   return request;
      // };
      //
      // // service identifier:
      // this.toString = function() {
      //   return 'CustomerDataService';
      // };

        var getFilterData = function (data) {
            // return $http.get('consumer/?'+"age="+data.age.value+"favourite="+data.favourite.value+"height="+data.height.value+"inContact="+data.inContact.value+"photo="+data.photo.value+"score="+data.score.value).then(function(result){
            //   // return result.data;
            //   return $http.get('customer-data.json');
            // });
            if(data == null){
                return $http.get("http://localhost:9099/home");
            }
            var params = constructParams(data);
            return $http.get("http://localhost:9099/home?" + params);
            // return $http.get('customer-data.json');
        };

        var constructParams = function (data) {
            var age = data.age.value;
            var height = data.height.value;
            var score = data.score.value;
            var inContact = data.inContact.value;
            var photo = data.photo.value;
            var favourite = data.favourite.value;
            var distance = data.distance.value;

            var params = "minAge="+age+"&minHeight="+height+"&minScore="+score+"&photo="+photo+"&favourite="+favourite+"&distance="+distance;
            return params;
        }

        return {
          getFilterData:getFilterData
        }

    }
  ]);