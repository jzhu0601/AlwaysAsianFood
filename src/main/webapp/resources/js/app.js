/**
 * Created by jzhu on 11/14/2015.
 */
(function () {
    "use strict";
    var asianFoodApp = angular.module("asianFoodApp", ['ngRoute', 'angular-loading-bar']);

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

            .when('/restaurantList/editRestaurant/:id', {
                templateUrl: '/resources/pages/editRestaurant.html',
                controller: 'editRestaurantCtrl'
            })

            .when('/restaurant/rate/:id', {
                templateUrl: '/resources/pages/rateRestaurant.html',
                controller: 'rateRestaurantCtrl'
            })

    });//end config

    asianFoodApp.config(['cfpLoadingBarProvider', function (cfpLoadingBarProvider) {
    }]); //end config

})();//end IFFE



