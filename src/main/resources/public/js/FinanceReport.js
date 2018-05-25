var App = angular.module('App',[]);

App.controller('FinanceReport',function ($http,$scope) {
    $http.get('/financereport/get').then(function (response){
        $scope.financereport=response.data;
        console.log(response);
    });
    this.insertToFinance = function add() {
        var costHotel = document.getElementById("costHotel").value;
        var transportation = document.getElementById("transportation").value;
        var unforeseenExpenses = document.getElementById("unforeseenExpenses").value;
        var settlementsAirport = document.getElementById("settlementsAirport").value;



        var req = {
            method: 'POST',
            url: '/financereport/insert',
            data: {
                costHotel: costHotel,
                transportation: transportation,
                unforeseenExpenses: unforeseenExpenses,
                settlementsAirport: settlementsAirport

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

    this.startUpdateFinance = function startUpdate(idFinanceReport,costHotel,transportation,
                                                   unforeseenExpenses,settlementsAirport) {
        document.getElementById("idFinanceReportUPD").value = idFinanceReport;
        document.getElementById("costHotelUPD").value = costHotel;
        document.getElementById("transportationUPD").value = transportation;
        document.getElementById("unforeseenExpensesUPD").value = unforeseenExpenses;
        document.getElementById("settlementsAirportUPD").value = settlementsAirport;


    };

    this.updateFinance = function update() {
        var id = document.getElementById("idFinanceReportUPD").value;
        var costHotel = document.getElementById("costHotelUPD").value;
        var transportation = document.getElementById("transportationUPD").value;
        var unforeseenExpenses = document.getElementById("unforeseenExpensesUPD").value;
        var settlementsAirport = document.getElementById("settlementsAirportUPD").value;


        var req = {
            method: 'POST',
            url: '/financereport/update?id=' + id,
            data: {
                costHotel: costHotel,
                transportation: transportation,
                unforeseenExpenses: unforeseenExpenses,
                settlementsAirport: settlementsAirport


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

    this.delFromFinance = function del(id) {
        var time = performance.now();
        $http.get('/financereport/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

