var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request1 = [];
    var nameCountry = "USA";

    $http.get('/request/request1?nameCountry='+nameCountry).then(function (response){
        $scope.request1=response.data;
        console.log(response);

        $http.get('/country/get').then(function (response) {
            var country = response.data;
            var selector = document.getElementById("nameCountry");
            $(selector).empty();
            for (var i = 0; i < country.length; i++) {
                var option = document.createElement("option");
                if (country[i].nameCountry == nameCountry){
                    option.selected = 'selected';
                }
                option.text = country[i].nameCountry;
                option.value = country[i].idCountry;
                selector.add(option);

            }
        });
     // document.getElementById("nameCountry").value = nameCountry;

    });

    this.update_request = function add() {

       // nameCountry = document.getElementById("nameCountry").value;
        var indexCountry = document.getElementById("nameCountry").selectedIndex;
        nameCountry = document.getElementById("nameCountry").options[indexCountry].text;

        $http.get('/request/request1?nameCountry='+nameCountry).then(function (response){
            $scope.request1=response.data;
            console.log(response);
        });
    };
});