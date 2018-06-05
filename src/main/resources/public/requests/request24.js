var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request24 = [];
    var category = "go rest";

    $http.get('/request/request24?category='+category).then(function (response){
        $scope.request24=response.data;
        console.log(response);

        $http.get('/grouptourist/get').then(function (response) {
            var group = response.data;
            var selector = document.getElementById("category");
            $(selector).empty();
            for (var i = 0; i < group.length; i++) {
                var option = document.createElement("option");
                if (group[i].category == category){
                    option.selected = 'selected';
                }
                option.text = group[i].category;
                option.value = group[i].idGroupTourist;
                selector.add(option);

            }
        });
        // document.getElementById("nameCountry").value = nameCountry;

    });

    this.update_request = function add() {

        // nameCountry = document.getElementById("nameCountry").value;
        var indexcategory = document.getElementById("category").selectedIndex;
        category = document.getElementById("category").options[indexcategory].text;

        $http.get('/request/request24?category='+category).then(function (response){
            $scope.request24=response.data;
            console.log(response);
        });
    };
});