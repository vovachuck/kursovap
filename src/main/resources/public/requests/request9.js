var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request9 = [];


    var date1= '2012-12-20';
    var date2= '2018-12-20';
    $http.get('/request/request9?date1='+date1+'&date2='+
        date2).then(function (response){
        $scope.request9=response.data;
        console.log(response);

        document.getElementById("date1").value=date1;
        document.getElementById("date2").value=date2;
    });

    this.update_request = function add() {

        date1=document.getElementById("date1").value;
        date2=document.getElementById("date2").value;
        $http.get('/request/request9?date1='+date1+'&date2='+
            date2).then(function (response){
            $scope.request9=response.data;
            console.log(response);
        });
    };
});