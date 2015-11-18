/**
 * Created by jzhu on 11/14/2015.
 */
(function () {
    "use strict";
    var asianFoodApp = angular.module("asianFoodApp", ["ui.router"]);

    asianFoodApp.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {

        //default url when first loading the page
        $urlRouterProvider.otherwise("/");

        //$stateProvider
        //    .state("restaurantList", {
        //        url: "/restaurants",
        //        templateUrl: "views/restaurantListView.html",
        //        controller: "RestaurantListCtrl"
        //    })

    }]); //end config


})();//end IFFE



