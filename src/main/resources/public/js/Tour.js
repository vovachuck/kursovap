var App = angular.module('App',[]);

App.controller('Tour',function ($http,$scope) {
    $http.get('/tour/get').then(function (response){
        $scope.tour=response.data;
        console.log(response);
    });
    this.insertToTour = function add() {
        var nameTour = document.getElementById("nameTour").value;
        var dateStartTour = document.getElementById("dateStartTour").value;
        var dateEndTour = document.getElementById("dateEndTour").value;
        var agency = document.getElementById("agency").value;
        var priceTour = document.getElementById("priceTour").value;


        var req = {
            method: 'POST',
            url: '/tour/insert',
            data: {
                nameTour: nameTour,
                dateStartTour: dateStartTour,
                dateEndTour: dateEndTour,
                agency: agency,
                priceTour: priceTour,
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

    this.startUpdateTour = function startUpdate(idTour,nameTour,dateStartTour,
                                                    dateEndTour,agency,priceTour) {
        document.getElementById("idTourUPD").value = idTour;
        document.getElementById("nameTourUPD").value = nameTour;
        document.getElementById("dateStartTourUPD").value = dateStartTour;
        document.getElementById("dateEndTourUPD").value = dateEndTour;
        document.getElementById("agencyUPD").value = agency;
        document.getElementById("priceTourUPD").value = priceTour;

    };

    this.updateTour = function update() {
        var id = document.getElementById("idTourUPD").value;
        var nameTour = document.getElementById("nameTourUPD").value;
        var dateStartTour = document.getElementById("dateStartTourUPD").value;
        var dateEndTour = document.getElementById("dateEndTourUPD").value;
        var agency = document.getElementById("agencyUPD").value;
        var priceTour = document.getElementById("priceTourUPD").value;

        var req = {
            method: 'POST',
            url: '/tour/update?id=' + id,
            data: {
                nameTour: nameTour,
                dateStartTour: dateStartTour,
                dateEndTour: dateEndTour,
                agency: agency,
                priceTour: priceTour

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

    this.delFromTour = function del(id) {
        var time = performance.now();
        $http.get('/tour/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

