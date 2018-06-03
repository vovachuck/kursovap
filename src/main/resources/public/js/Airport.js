var App = angular.module('App',[]);

App.controller('Airport',function ($http,$scope) {
    $http.get('/airport/get').then(function (response){
        $scope.airport=response.data;
        console.log(response);
    });
    this.insertToAirport = function add() {
        var dateArrival = document.getElementById("dateArrival").value;
        var departureDate = document.getElementById("departureDate").value;
        var nameJourney = document.getElementById("nameJourney").value;
        var numbSeats = document.getElementById("numbSeats").value;
        var countryDeparture = document.getElementById("countryDeparture").value;
        var countryArrival = document.getElementById("countryArrival").value;
        var numbVacantSeats = document.getElementById("numbVacantSeats").value;




        var req = {
            method: 'POST',
            url: '/airport/insert',
            data: {
                dateArrival: dateArrival,
                departureDate: departureDate,
                nameJourney: nameJourney,
                numbSeats: numbSeats,
                countryDeparture: countryDeparture,
                countryArrival: countryArrival,
                numbVacantSeats: numbVacantSeats,

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

    this.startUpdateAirport = function startUpdate(idAirport,dateArrival,departureDate,
                                                   nameJourney,numbSeats,countryDeparture,countryArrival,
                                                   numbVacantSeats
                                                   ) {
        document.getElementById("idAirportUPD").value = idAirport;
        document.getElementById("dateArrivalUPD").value = dateArrival;
        document.getElementById("departureDateUPD").value = departureDate;
        document.getElementById("nameJourneyUPD").value = nameJourney;
        document.getElementById("numbSeatsUPD").value = numbSeats;
        document.getElementById("countryDepartureUPD").value = countryDeparture;
        document.getElementById("countryArrivalUPD").value = countryArrival;
        document.getElementById("numbVacantSeatsUPD").value = numbVacantSeats;


    };

    this.updateAirport = function update() {
        var id = document.getElementById("idAirportUPD").value;
        var dateArrival = document.getElementById("dateArrivalUPD").value;
        var departureDate = document.getElementById("departureDateUPD").value;
        var nameJourney = document.getElementById("nameJourneyUPD").value;
        var numbSeats = document.getElementById("numbSeatsUPD").value;
        var countryDeparture = document.getElementById("countryDepartureUPD").value;
        var countryArrival = document.getElementById("countryArrivalUPD").value;
        var numbVacantSeats = document.getElementById("numbVacantSeatsUPD").value;



        var req = {
            method: 'POST',
            url: '/airport/update?id=' + id,
            data: {
                dateArrival: dateArrival,
                departureDate: departureDate,
                nameJourney: nameJourney,
                numbSeats: numbSeats,
                countryDeparture: countryDeparture,
                countryArrival: countryArrival,
                numbVacantSeats: numbVacantSeats,



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

    this.delFromAirport = function del(id) {
        var time = performance.now();
        $http.get('/airport/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

