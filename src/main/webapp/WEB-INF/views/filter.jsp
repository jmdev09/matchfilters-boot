<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Directives Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0/angular.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.13/angular-sanitize.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="/js/script.js"></script>
  <script src="/js/controllers.js"></script>
  <script src="/js/directives.js"></script>
  <script src="/js/services.js"></script>
 
  <link rel="stylesheet" href="/css/style.css" />
</head>

<body ng-app="App" ng-controller="AppController">
  <!--<div id="container" ng-controller="StoreController as store">-->
    <!--<h3>Customers</h3>-->
    <!--<customer info="item" ng-repeat="item in store.customers"></customer>-->
    <!--<h3>Report</h3>-->
    <!--<div id="report" ng-bind-html="store.report"></div>-->
    <!--<button ng-click='store.resetCustomer(0)'>Reset {{store.getCustomer(0).name}}</button>-->
    <!--<button ng-click='store.resetCustomer(1)'>Reset {{store.getCustomer(1).name}}</button>-->
  <!--</div>-->
  <nav class="navbar navbar-dark bg-primary">
      <!-- Navbar content -->
      <h2 class="text-center">Know How Filter Works</h2>
    </nav>
  <div class="form-container">
     
  <form ng-submit="submit()">
    <div class="row form-group">
      <label class="col-sm-6 col-form-label pt-0">Has photo:</label>
      <div class="col-sm-6">
        <label><input type="radio" ng-model="data.photo.value" value="yes">Yes </label>
        <label><input type="radio" ng-model="data.photo.value" value="no">No</label>
        <label><input type="radio" ng-model="data.photo.value" value="all">All</label>
      </div>
    </div>
    <div class="row form-group">
      <label class="col-sm-6 col-form-label pt-0">In Contact:</label>
      <div class="col-sm-6">
        <label><input type="radio" ng-model="data.inContact.value" value="yes">Yes</label>
        <label><input type="radio" ng-model="data.inContact.value" value="no">No</label>
        <label><input type="radio" ng-model="data.inContact.value" value="all">All</label>
      </div>
    </div>
    <div class="row form-group">
      <label class="col-sm-6 col-form-label pt-0">Favourite:</label>
      <div class="col-sm-6">
        <label><input type="radio" ng-model="data.favourite.value" value="yes">Yes</label>
        <label><input type="radio" ng-model="data.favourite.value" value="no">No</label>
       <label><input type="radio" ng-model="data.favourite.value" value="all">All</label>
    </div>
    </div>
    <div class=" row slidecontainer form-group">
      <label class="col-sm-6 col-form-label pt-0">Compatibility Score(in perc)</label>
      <div class="col-sm-6">
          <span class="badge badge-pill badge-primary">{{data.score.value}}</span>
        <input type="range" min="1" max="99" value="50" class="slider" ng-model="data.score.value" id="myScoreRange">
      </div>
    </div>
    <div class="row slidecontainer form-group">
      <label class="col-sm-6 col-form-label pt-0"> Age(in yrs)</label>
      <div class="col-sm-6">
        <span class="badge badge-pill badge-primary">{{data.age.value}}</span>
        <input type="range" min="18" max="95" value="50" class="slider" ng-model="data.age.value" id="myAgeRange">
      </div>
    </div>
    <div class="row slidecontainer form-group">
      <label class="col-sm-6 col-form-label pt-0">Height(in cm)</label>
      <div class="col-sm-6">
        <span class="badge badge-pill badge-primary">{{data.height.value}}</span>
        <input type="range" min="135" max="210" value="50" class="slider" ng-model="data.height.value" id="myHeightRange">
      </div>
    </div>
    <div class="row slidecontainer form-group">
      <label class="col-sm-6 col-form-label pt-0">Distance(in Km)</label>
      <div class="col-sm-6">
        <span class="badge badge-pill badge-primary">{{data.distance.value}}</span>
        <input type="range" min="30" max="300" value="40" step="5" class="slider" ng-model="data.distance.value" id="mydistanceRange">
      </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
<section class="container">
  <div class="row">
      <div class="col-sm-4" ng-repeat="user in fetchedData" >
          <div class="card">
              <img ng-if="user.main_photo" class="card-img-top" ng-src="{{user.main_photo}}" alt="Card image cap">
              <span class="no-image-avail" ng-if="!user.main_photo">No Image Found</span>
              <div class="card-body">
                <h5 class="card-title">{{user.display_name}}</h5>
                <p class="card-text">Job Tilte:- {{user.job_title}}</p>
              </div>
              <ul class="list-group list-group-flush">
                <li class="list-group-item">Age:- {{user.age}}</li>
                <li class="list-group-item">Height:-{{user.height_in_cm}}</li>
                <li class="list-group-item">Compatibility Score:- {{user.compatibility_score}}</li>
                <li class="list-group-item">Favourite:- {{user.favourite}}</li>
                <li class="list-group-item">Religion:-{{user.religion}}</li>
              </ul>
            </div>
      </div>
  </div>
</section>
</body>

</html>