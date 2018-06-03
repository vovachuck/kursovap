var App = angular.module('App',[]);

App.controller('Hotel',function ($http,$scope) {
    $http.get('/hotel/get').then(function (response){
        $scope.hotel=response.data;
        console.log(response);
    });
    this.insertToBuilding = function add() {
        var numb = document.getElementById("numberAvailable").value;
        var nameH = document.getElementById("hotelName").value;
        var total = document.getElementById("date_eviction").value;
        var total1 = document.getElementById("number_occupied").value;


        var req = {
            method: 'POST',
            url: '/hotel/insert',
            data: {
                numberAvailable: numb,
                hotelName: nameH,
                date_eviction: total,
                number_occupied: total1
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
                                                    date_eviction,number_occupied) {
        document.getElementById("idHotelUPD").value = idHotel;
        document.getElementById("numberAvailableUPD").value = numberAvailable;
        document.getElementById("hotelNameUPD").value = hotelName;
        document.getElementById("date_evictionUPD").value = date_eviction;
        document.getElementById("number_occupiedUPD").value = number_occupied;

    };

    this.updateBuilding = function update() {
        var id = document.getElementById("idHotelUPD").value;
        var numb = document.getElementById("numberAvailableUPD").value;
        var nameH = document.getElementById("hotelNameUPD").value;
        var total = document.getElementById("date_evictionUPD").value;
        var total1 = document.getElementById("number_occupiedUPD").value;

        var req = {
            method: 'POST',
            url: '/hotel/update?id=' + id,
            data: {
                numberAvailable: numb,
                hotelName: nameH,
                date_eviction: total,
                number_occupied: total1

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

