var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request4 = [];
    var firstName = "Volodymyr";
    var lastName = "Lakusta";

    $http.get('/request/request4?firstName='+firstName+"&lastName="+lastName).then(function (response){
        $scope.request4=response.data;
        console.log(response);

         document.getElementById("firstName").value = firstName;
        document.getElementById("lastName").value = lastName;

    });

    this.update_request = function add() {

        firstName = document.getElementById("firstName").value;
        lastName = document.getElementById("lastName").value;


        $http.get('/request/request4?firstName='+firstName+"&lastName="+lastName).then(function (response){
            $scope.request4=response.data;
            console.log(response);
        });
    };
});