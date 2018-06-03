var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request15 = [];
    var nameJourney = "Amerika-Kiev";

    $http.get('/request/request15?nameJourney='+nameJourney).then(function (response){
        $scope.request15=response.data;
        console.log(response);

        $http.get('/airport/get').then(function (response) {
            var air = response.data;
            var selector = document.getElementById("nameJourney");
            $(selector).empty();
            for (var i = 0; i < air.length; i++) {
                var option = document.createElement("option");
                if (air[i].nameJourney == nameJourney){
                    option.selected = 'selected';
                }
                option.text = air[i].nameJourney;
                option.value = air[i].idAirport;
                selector.add(option);

            }
        });
        // document.getElementById("nameCountry").value = nameCountry;

    });

    this.update_request = function add() {

        // nameCountry = document.getElementById("nameCountry").value;
        var indexnameJourney = document.getElementById("nameJourney").selectedIndex;
        nameJourney = document.getElementById("nameJourney").options[indexnameJourney].text;

        $http.get('/request/request15?nameJourney='+nameJourney).then(function (response){
            $scope.request15=response.data;
            console.log(response);
        });
    };
});