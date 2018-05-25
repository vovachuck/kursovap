var App = angular.module('App',[]);

App.controller('Storage',function ($http,$scope) {
    $http.get('/storage/get').then(function (response){
        $scope.storage=response.data;
        console.log(response);
    });
    this.insertToStorage = function add() {
        var marking = document.getElementById("marking").value;
        var weight = document.getElementById("weight").value;
        var datePack = document.getElementById("datePack").value;
        var airplaneClass = document.getElementById("airplaneClass").value;
        var numbPlacesCargo = document.getElementById("numbPlacesCargo").value;
        var departureDateCargo = document.getElementById("departureDateCargo").value;
        var arrivalDateCargo = document.getElementById("arrivalDateCargo").value;
        var priceStoreCargo = document.getElementById("priceStoreCargo").value;


        var req = {
            method: 'POST',
            url: '/storage/insert',
            data: {
                marking: marking,
                weight: weight,
                datePack: datePack,
                airplaneClass: airplaneClass,
                numbPlacesCargo: numbPlacesCargo,
                departureDateCargo: departureDateCargo,
                arrivalDateCargo: arrivalDateCargo,
                priceStoreCargo: priceStoreCargo,
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

    this.startUpdateStorage = function startUpdate(idStorage,marking,weight,
                                                datePack,airplaneClass,numbPlacesCargo,
                                                departureDateCargo,arrivalDateCargo,priceStoreCargo) {
        document.getElementById("idStorageUPD").value = idStorage;
        document.getElementById("markingUPD").value = marking;
        document.getElementById("weightUPD").value = weight;
        document.getElementById("datePackUPD").value = datePack;
        document.getElementById("airplaneClassUPD").value = airplaneClass;
        document.getElementById("numbPlacesCargoUPD").value = numbPlacesCargo;
        document.getElementById("departureDateCargoUPD").value = departureDateCargo;
        document.getElementById("arrivalDateCargoUPD").value = arrivalDateCargo;
        document.getElementById("priceStoreCargoUPD").value = priceStoreCargo;


    };

    this.updateStorage = function update() {
        var id = document.getElementById("idStorageUPD").value;
        var marking = document.getElementById("markingUPD").value;
        var weight = document.getElementById("weightUPD").value;
        var datePack = document.getElementById("datePackUPD").value;
        var airplaneClass = document.getElementById("airplaneClassUPD").value;
        var numbPlacesCargo = document.getElementById("numbPlacesCargoUPD").value;
        var departureDateCargo = document.getElementById("departureDateCargoUPD").value;
        var arrivalDateCargo = document.getElementById("arrivalDateCargoUPD").value;
        var priceStoreCargo = document.getElementById("priceStoreCargoUPD").value;

        var req = {
            method: 'POST',
            url: '/storage/update?id=' + id,
            data: {
                marking: marking,
                weight: weight,
                datePack: datePack,
                airplaneClass: airplaneClass,
                numbPlacesCargo: numbPlacesCargo,
                departureDateCargo: departureDateCargo,
                arrivalDateCargo: arrivalDateCargo,
                priceStoreCargo: priceStoreCargo

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

    this.delFromStorage = function del(id) {
        var time = performance.now();
        $http.get('/storage/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

