/**
 * Created by jzhu on 11/14/2015.
 */
(function () {
    "use strict";
    var asianFoodApp = angular.module("asianFoodApp", ['ngRoute']);

        asianFoodApp.config(function($routeProvider){
            $routeProvider
                .when('/',{
                    templateUrl:'/resources/pages/home.html',
                    controller:'homeCtrl'
                })

                .when('/restaurantList',{
                    templateUrl:'/resources/pages/restaurantList.html',
                    controller:'restaurantCtrl'
                })
        });//end config

})();//end IFFE



