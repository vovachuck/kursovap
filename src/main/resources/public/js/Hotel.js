var App = angular.module('App',[]);

App.controller('Hotel',function ($http,$scope) {
    $http.get('/hotel/get').then(function (response){
        $scope.hotel=response.data;
        console.log(response);
    });
    this.insertToBuilding = function add() {
        var numb = document.getElementById("numberAvailable").value;
        var nameH = document.getElementById("hotelName").value;
        var total = document.getElementById("numberOccupied").value;


        var req = {
            method: 'POST',
            url: '/hotel/insert',
            data: {
                numberAvailable: numb,
                hotelName: nameH,
                numberOccupied: total
            }
        };
        //console.log(req);
        var time = performance.now();
        $http(req).then(function (resp) {
            //console.log(resp);
            time = performance.now() - time;
            console.log('Додавання нового запису = ', time);
            alert("--------");
            window.location.reload();
        })
    };

    this.startUpdateBuilding = function startUpdate(idHotel,numberAvailable,hotelName,
                                                    numberOccupied) {
        document.getElementById("idHotelUPD").value = idHotel;
        document.getElementById("numberAvailableUPD").value = numberAvailable;
        document.getElementById("hotelNameUPD").value = hotelName;
        document.getElementById("numberOccupiedUPD").value = numberOccupied;

    };

    this.updateBuilding = function update() {
        var id = document.getElementById("idHotelUPD").value;
        var numb = document.getElementById("numberAvailableUPD").value;
        var nameH = document.getElementById("hotelNameUPD").value;
        var total = document.getElementById("numberOccupiedUPD").value;

        var req = {
            method: 'POST',
            url: '/hotel/update?id=' + id,
            data: {
                numberAvailable: numb,
                hotelName: nameH,
                numberOccupied: total

            }
        };
        //console.log(req);
        var time = performance.now();
        $http(req).then(function (resp) {
            //console.log(resp);
            time = performance.now() - time;
            console.log('Оновлення = ', time);
            alert("--------");
            window.location.reload();
        })
    };

    this.delFromBuilding = function del(id) {
        var time = performance.now();
        $http.get('/hotel/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

