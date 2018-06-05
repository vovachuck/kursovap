var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request23 = [];


    var date1= '2016-05-20';

    $http.get('/request/request23?date1='+date1).then(function (response){
        $scope.request23=response.data;
        console.log(response);

        document.getElementById("date1").value=date1;

    });

    this.update_request = function add() {

        date1=document.getElementById("date1").value;

        $http.get('/request/request23?date1='+date1).then(function (response){
            $scope.request23=response.data;
            console.log(response);
        });
    };
});