var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request3 = [];

    var category= 'go rest';
    var countryArrival= 'USA';
    var date1= '2012-12-20';
    var date2= '2018-12-20';
    $http.get('/request/request3?category='+category+'&countryArrival='+countryArrival+'&date1='+date1+'&date2='+
    date2).then(function (response){
        $scope.request3=response.data;
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
        $http.get('/airport/get').then(function (response) {
            var air = response.data;
            var selector = document.getElementById("countryArrival");
            $(selector).empty();
            for (var i = 0; i < air.length; i++) {
                var option = document.createElement("option");
                if (air[i].countryArrival == countryArrival){
                    option.selected = 'selected';
                }
                option.text = air[i].countryArrival;
                option.value = air[i].idAirport;
                selector.add(option);

            }
        });
        //document.getElementById("category").value=category;
        //document.getElementById("countryArrival").value=countryArrival;
        document.getElementById("date1").value=date1;
        document.getElementById("date2").value=date2;
    });

    this.update_request = function add() {

        /*category=document.getElementById("category").value;
        countryArrival=document.getElementById("countryArrival").value;*/
        var indexgroup = document.getElementById("category").selectedIndex;
        category = document.getElementById("category").options[indexgroup].text;
        var indexair = document.getElementById("countryArrival").selectedIndex;
        countryArrival = document.getElementById("countryArrival").options[indexair].text;
        date1=document.getElementById("date1").value;
        date2=document.getElementById("date2").value;
        $http.get('/request/request3?category='+category+'&countryArrival='+countryArrival+'&date1='+date1+'&date2='+
            date2).then(function (response){
            $scope.request3=response.data;
            console.log(response);
        });
    };
});