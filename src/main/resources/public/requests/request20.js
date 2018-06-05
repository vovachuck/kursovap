var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request20 = [];
    var nameTour = "Golden Gate";

    $http.get('/request/request20?nameTour='+nameTour).then(function (response){
        $scope.request20=response.data;
        console.log(response);


        // document.getElementById("nameCountry").value = nameCountry;
        $http.get('/tour/get').then(function (response) {
            var tour = response.data;
            var selector = document.getElementById("nameTour");
            $(selector).empty();
            for (var i = 0; i < tour.length; i++) {
                var option = document.createElement("option");
                if (tour[i].nameTour == nameTour){
                    option.selected = 'selected';
                }
                option.text = tour[i].nameTour;
                option.value = tour[i].idTour;
                selector.add(option);

            }
        });
    });

    this.update_request = function add() {

        // nameCountry = document.getElementById("nameCountry").value;
        var indexnameTour = document.getElementById("nameTour").selectedIndex;
        nameTour = document.getElementById("nameTour").options[indexnameTour].text;

        $http.get('/request/request20?nameTour='+nameTour).then(function (response){
            $scope.request20=response.data;
            console.log(response);
        });
    };
});