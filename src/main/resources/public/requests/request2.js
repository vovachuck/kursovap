var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request2 = [];
    var hotelName = "Amerik";
    $http.get('/request/request2?hotelName='+hotelName).then(function (response){
        $scope.request2=response.data;
        console.log(response);
        $http.get('/hotel/get').then(function (response) {
            var hotel = response.data;
            var selector = document.getElementById("hotelName");
            $(selector).empty();
            for (var i = 0; i < hotel.length; i++) {
                var option = document.createElement("option");
                if (hotel[i].hotelName == hotelName){
                    option.selected = 'selected';
                }
                option.text = hotel[i].hotelName;
                option.value = hotel[i].idHotel;
                selector.add(option);

            }
        });
     // document.getElementById("hotelName").value = hotelName;

    });

    this.update_request = function add() {
        var indexHotel = document.getElementById("hotelName").selectedIndex;
        hotelName = document.getElementById("hotelName").options[indexHotel].text;

        $http.get('/request/request2?hotelName='+hotelName).then(function (response){
            $scope.request2=response.data;
            console.log(response);
        });
    };
});