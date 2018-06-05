var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request19 = [];

    $http.get('/request/request19').then(function (response){
        $scope.request19=response.data;
        console.log(response);
    });

});