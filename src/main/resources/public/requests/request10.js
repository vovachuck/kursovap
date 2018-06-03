var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request10 = [];
    var nameGroup = 'America tour';
    var category = 'go rest';
    $http.get('/request/request10?nameGroup='+nameGroup+'&category='+category).then(function (response){
        $scope.request10=response.data;
        console.log(response);
        var selector = document.getElementById("category");
        $(selector).empty();

        var option = document.createElement("option");

        option.text = "go cargo";
        option.value = 0;
        selector.add(option);
        var option = document.createElement("option");
        option.text = "go rest";
        option.value = 1;
        selector.add(option);
        var option = document.createElement("option");
        option.text = "kid";
        option.value = 2;
        selector.add(option);
        selector.selectedIndex=1;
        $http.get('/grouptourist/get').then(function (response) {
            var group = response.data;
            var selector = document.getElementById("nameGroup");
            $(selector).empty();
            for (var i = 0; i < group.length; i++) {
                var option = document.createElement("option");
                if (group[i].nameGroup == nameGroup){
                    option.selected = 'selected';
                }
                option.text = group[i].nameGroup;
                option.value = group[i].idGroupTourist;
                selector.add(option);

            }
        });
        // document.getElementById("nameCountry").value = nameCountry;

    });

    this.update_request = function add() {

        // nameCountry = document.getElementById("nameCountry").value;
        var index = document.getElementById("nameGroup").selectedIndex;
        nameGroup = document.getElementById("nameGroup").options[index].text;
        var indexgroup = document.getElementById("category").selectedIndex;
        category = document.getElementById("category").options[indexgroup].text;
        $http.get('/request/request10?nameGroup='+nameGroup+'&category='+category).then(function (response){
            $scope.request10=response.data;
            console.log(response);
        });
    };
});