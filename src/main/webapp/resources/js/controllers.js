/**
 * Created by jzhu on 11/16/2015.
 */
(function () {
    "use strict";
    angular
        .module("asianFoodApp")
        .controller("homeCtrl", HomeCtrl);

    function HomeCtrl($scope, $http) {

    } //end HomeCtrl

    angular
        .module("asianFoodApp")
        .controller("restaurantCtrl", RestaurantCtrl);

    function RestaurantCtrl($scope,$http) {
        $http.get('http://localhost:8080/api/restaurants').
        success(function (data) {
            $scope.restaurants = data;
        });
    }//end restaurantCtrl

})();//end IFFE end homeCtrl