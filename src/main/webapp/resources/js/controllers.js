/**
 * Created by jzhu on 11/16/2015.
 */
(function () {
    "use strict";
    angular
        .module("asianFoodApp")
        .controller("homeCtrl", HomeCtrl);

    function HomeCtrl($scope, $http, $location) {

        $scope.boolValue = true;
        $scope.term = "";
        $scope.location = "";
        $scope.image_url = "";
        $scope.rating_img_url = "";
        $scope.businessAddresses = "";
        $scope.display_phone = "";
        $scope.website = "";
        $scope.submitSearch = function () {
            $scope.boolValue = false;
            var data = {
                term: $scope.term,
                location: $scope.location
            }; //end data
            var res = $http.post('/api/yelp/searchRestaurant', data)
                .success(function (responseData) {
                    $scope.image_url = responseData.image_url;
                    $scope.rating_img_url = responseData.rating_img_url;
                    $scope.businessAddresses = responseData.location.display_address.toString();
                    $scope.display_phone = responseData.display_phone;
                    $scope.website = responseData.url;
                    $scope.restaurantName = responseData.id;
                    // console.log(responseData);
                }).error(function () {
                });
        }//end submit function

        $scope.returnSearch = function () {
            $scope.boolValue = true;
            $scope.image_url = "";
            $scope.rating_img_url = "";
            $scope.businessAddresses = "";
            $scope.display_phone = "";
            $scope.website = "";
        }//end returnSearch

        $scope.rateRestYelp = function () {
            $http.get('/api/restaurants/' + $scope.restaurantName)
                .success(function (data) {
                    if (data.restaurantName === undefined) {
                        var sendData = {
                            restaurantName: $scope.restaurantName,
                            restaurantAddress: $scope.businessAddresses,
                            phoneNum: $scope.display_phone,
                            website: $scope.website,
                            businessHours: null
                        }; //end sendData
                        var res = $http.post('/api/restaurants', sendData);
                    } else {
                        //go to the rate the already exist restaruant
                        $location.path('/restaurant/rate/' + data.restaurantId);
                    }
                });
        }//end rateRestYelp

    } //end HomeCtrl

    angular
        .module("asianFoodApp")
        .controller("restaurantCtrl", RestaurantCtrl);

    function RestaurantCtrl($scope, $http) {
        $http.get('/api/restaurants').
        success(function (data) {
            $scope.restaurants = data;
        });
    }//end restaurantCtrl

    angular
        .module("asianFoodApp")
        .controller("addRestaurantCtrl", AddRestaurantCtrl);

    function AddRestaurantCtrl($scope, $http) {
        $scope.restaurantName = "";
        $scope.restaurantAddress = "";
        $scope.phoneNum = "";
        $scope.website = "";
        $scope.businessHours = "";

        $scope.submit = function () {
            var data = {
                restaurantName: $scope.restaurantName,
                restaurantAddress: $scope.restaurantAddress,
                phoneNum: $scope.phoneNum,
                website: $scope.website,
                businessHours: $scope.businessHours
            }; //end data
            var res = $http.post('/api/restaurants', data);
        }//end submit function
    } //end AddRestaurantCtrl

    angular
        .module("asianFoodApp")
        .controller("editRestaurantCtrl", EditRestaurantCtrl);

    function EditRestaurantCtrl($scope, $routeParams, $http, $location) {
        var restaurantId = $routeParams.id;
        var url = "/api/restaurants/" + restaurantId;

        $http.get(url).success(function (data) {
            $scope.restaurant = data;
        });

        $scope.submit = function () {
            var dataRec = {
                restaurantId: restaurantId,
                restaurantName: $scope.restaurant.restaurantName,
                restaurantAddress: $scope.restaurant.restaurantAddress,
                phoneNum: $scope.restaurant.phoneNum,
                website: $scope.restaurant.website,
                businessHours: $scope.restaurant.businessHours
            }; //end dataRec
            var res = $http.put('/api/restaurants/' + restaurantId, dataRec);
        }//end submit function
        $scope.cancel = function (path) {
            $location.path('/restaurantList');
        }//end cancel
    } //end EditRestaurantCtrl

    angular
        .module("asianFoodApp")
        .controller("rateRestaurantCtrl", RateRestaurantCtrl);

    function RateRestaurantCtrl($scope, $http, $routeParams, $location, $timeout) {

        $scope.isSubmitting = null;
        $scope.result = null;

        $scope.options = {
            buttonDefaultClass: 'btn-primary',
            buttonSubmittingClass: 'btn-info',
            buttonSuccessClass: 'btn-success',
            buttonSuccessText: 'Review Submitted',
            buttonErrorText: 'Review cannot be submitted'
        };


        var restaurantId = $routeParams.id;
        $scope.rating = "";
        $scope.reviewContent = "";
        $scope.submit = function () {
            $scope.isSubmitting = true;
            var dataRec = {
                reviewStar: $scope.rating,
                reviewContent: $scope.reviewContent,
                restaurantId: restaurantId
            };//end dataRec
            var res = $http.post('api/reviews/' + restaurantId, dataRec).success(function () {
                $scope.result = 'success'
            }).error(function () {
                $scope.result = 'error';
            });

        } //end submit
        $scope.cancel = function (path) {
            $location.path('/restaurantList');
        }//end cancel
    }//end RateRestaurantCtrl

})();//end IFFE