var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request17 = [];

    $http.get('/request/request17').then(function (response){
        $scope.request17=response.data;
        console.log(response);
    });

});