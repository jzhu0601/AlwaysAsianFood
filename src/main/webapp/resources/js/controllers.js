/**
 * Created by jzhu on 11/16/2015.
 */
(function () {
    "use strict";
    angular
        .module("asianFoodApp")
        .controller("homeCtrl", HomeCtrl);

    function HomeCtrl($scope, $http) {
        $http.get('http://localhost:8080/api/restaurants').
        success(function(data) {
            $scope.restaurants = data;
        });
    } //end HomeCtrl



})();//end IFFE end homeCtrl