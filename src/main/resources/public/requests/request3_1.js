var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request3_1 = [];

    var countryArrival= 'USA';
    var date1= '2012-12-20';
    var date2= '2018-12-20';
    $http.get('/request/request3_1?countryArrival='+countryArrival+'&date1='+date1+'&date2='+
        date2).then(function (response){
        $scope.request3_1=response.data;
        console.log(response);

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
        var indexair = document.getElementById("countryArrival").selectedIndex;
        countryArrival = document.getElementById("countryArrival").options[indexair].text;
        date1=document.getElementById("date1").value;
        date2=document.getElementById("date2").value;
        $http.get('/request/request3_1?countryArrival='+countryArrival+'&date1='+date1+'&date2='+
            date2).then(function (response){
            $scope.request3_1=response.data;
            console.log(response);
        });
    };
});