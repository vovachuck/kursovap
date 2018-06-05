var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request25 = [];
    var nameGroup = "America tour";

    $http.get('/request/request25?nameGroup='+nameGroup).then(function (response){
        $scope.request25=response.data;
        console.log(response);

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
        var indexnameGroup = document.getElementById("nameGroup").selectedIndex;
        nameGroup = document.getElementById("nameGroup").options[indexnameGroup].text;

        $http.get('/request/request25?nameGroup='+nameGroup).then(function (response){
            $scope.request25=response.data;
            console.log(response);
        });
    };
});