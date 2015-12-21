/**
 * Created by jzhu on 11/14/2015.
 */
(function () {
    "use strict";
    var asianFoodApp = angular.module("asianFoodApp", ['ngRoute', 'angular-loading-bar', 'jp.ng-bs-animated-button']);

    asianFoodApp.config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/resources/pages/home.html',
                controller: 'homeCtrl',
                caseInsensitiveMatch: true
            })

            .when('/restaurantList', {
                templateUrl: '/resources/pages/restaurantList.html',
                controller: 'restaurantCtrl',
                caseInsensitiveMatch: true
            })

            .when('/addRestaurant', {
                templateUrl: '/resources/pages/addRestaurant.html',
                controller: 'addRestaurantCtrl',
                caseInsensitiveMatch: true
            })

            .when('/restaurantList/editRestaurant/:id', {
                templateUrl: '/resources/pages/editRestaurant.html',
                controller: 'editRestaurantCtrl',
                caseInsensitiveMatch: true
            })

            .when('/restaurant/rate/:id', {
                templateUrl: '/resources/pages/rateRestaurant.html',
                controller: 'rateRestaurantCtrl',
                caseInsensitiveMatch: true
            })

            .otherwise('/');

    });//end config

    asianFoodApp.config(['cfpLoadingBarProvider', function (cfpLoadingBarProvider) {
    }]); //end config


})();//end IFFE



