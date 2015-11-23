/**
 * Created by jzhu on 11/14/2015.
 */
(function () {
    "use strict";
    var asianFoodApp = angular.module("asianFoodApp", ['ngRoute']);

    asianFoodApp.config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/resources/pages/home.html',
                controller: 'homeCtrl'
            })

            .when('/restaurantList', {
                templateUrl: '/resources/pages/restaurantList.html',
                controller: 'restaurantCtrl'
            })

            .when('/addRestaurant', {
                templateUrl: '/resources/pages/addRestaurant.html',
                controller: 'addRestaurantCtrl'
            })

            .when('/restaurantList/editRestaurant/:id',{
                templateUrl:'/resources/pages/editRestaurant.html',
                controller:'editRestaurantCtrl'
            })

    });//end config

})();//end IFFE



