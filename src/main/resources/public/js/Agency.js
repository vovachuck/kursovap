var App = angular.module('App',[]);

App.controller('Agency',function ($http,$scope) {
    $http.get('/agency/get').then(function (response){
        $scope.agency=response.data;
        console.log(response);
    });

    this.startInsertAgency= function startUpdate() {
        $http.get('/grouptourist/get').then(function (response) {
            var group = response.data;
            var selector = document.getElementById("idGroupTourist");
            $(selector).empty();
            for (var i = 0; i < group.length; i++) {
                var option = document.createElement("option");
                option.text = group[i].firstName;
                option.value = group[i].idGroupTourist;
                selector.add(option);

            }
        });

        $http.get('/airport/get').then(function (response) {
                var air = response.data;
                var selector = document.getElementById("idAirport");
                $(selector).empty();
                for (var i = 0; i < air.length; i++) {
                    var option = document.createElement("option");
                    option.text = air[i].nameJourney;
                    option.value = air[i].idAirport;
                    selector.add(option);

                }
        });
            $http.get('/tour/get').then(function (response) {
                var tour = response.data;
                var selector = document.getElementById("idTour");
                $(selector).empty();
                for (var i = 0; i < tour.length; i++) {
                    var option = document.createElement("option");
                    option.text = tour[i].nameTour;
                    option.value = tour[i].idTour;
                    selector.add(option);

                }
            });
                $http.get('/storage/get').then(function (response) {
                    var store = response.data;
                    var selector = document.getElementById("idStorage");
                    $(selector).empty();
                    for (var i = 0; i < store.length; i++) {
                        var option = document.createElement("option");
                        option.text = store[i].marking;
                        option.value = store[i].idStorage;
                        selector.add(option);

                    }
                });
                    $http.get('/financereport/get').then(function (response) {
                        var finance = response.data;
                        var selector = document.getElementById("idFinanceReport");
                        $(selector).empty();
                        for (var i = 0; i < finance.length; i++) {
                            var option = document.createElement("option");
                            option.text = finance[i].idFinanceReport;
                            option.value = finance[i].idFinanceReport;
                            selector.add(option);

                        }
                    });
                        $http.get('/hotel/get').then(function (response) {
                            var hotel = response.data;
                            var selector = document.getElementById("idHotel");
                            $(selector).empty();
                            for (var i = 0; i < hotel.length; i++) {
                                var option = document.createElement("option");
                                option.text = hotel[i].hotelName;
                                option.value = hotel[i].idHotel;
                                selector.add(option);

                            }
                        });

                            $http.get('/country/get').then(function (response) {
                                var country = response.data;
                                var selector = document.getElementById("idCountry");
                                $(selector).empty();
                                for (var i = 0; i < country.length; i++) {
                                    var option = document.createElement("option");
                                    option.text = country[i].nameCountry;
                                    option.value = country[i].idCountry;
                                    selector.add(option);

                                }
                            });
        };


    this.insertToAgency = function add() {
        var indexGroupTouirist = document.getElementById("idGroupTourist").selectedIndex;
        var group_id = document.getElementById("idGroupTourist").options[indexGroupTouirist].value;

        var indexAirport = document.getElementById("idAirport").selectedIndex;
        var airport_id = document.getElementById("idAirport").options[indexAirport].value;

        var indexTour = document.getElementById("idTour").selectedIndex;
        var tour_id = document.getElementById("idTour").options[indexTour].value;

        var indexStorage = document.getElementById("idStorage").selectedIndex;
        var storage_id = document.getElementById("idStorage").options[indexStorage].value;

        var indexFinanceReport = document.getElementById("idFinanceReport").selectedIndex;
        var finance_id = document.getElementById("idFinanceReport").options[indexFinanceReport].value;

        var price = document.getElementById("priceAllTour").value;

        var indexHotel = document.getElementById("idHotel").selectedIndex;
        var hotel_id = document.getElementById("idHotel").options[indexHotel].value;

        var indexCountry = document.getElementById("idCountry").selectedIndex;
        var country_id = document.getElementById("idCountry").options[indexCountry].value;




        var req = {
            method: 'POST',
            url: '/agency/insert',
            data: {
                grouptourist_idGroupTourist:group_id,
                airport_idAirport:airport_id,
                tour_idTour:tour_id,
                storage_idStorage:storage_id,
                financereport_idFinanceReport:finance_id,
                priceAllTour:price,
                hotel_id_hotel:hotel_id,
                country_id_country:country_id




            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdateAgency = function startUpdate(idAgency,idGroupTourist,idAirport,
                                                  idTour,idStorage,idFinanceReport,priceAllTour,
                                                  idHotel,idCountry)
    {
        document.getElementById("idAgencyUPD").value = idAgency;
        document.getElementById("idGroupTouristUPD").value = idGroupTourist;
        document.getElementById("idAirportUPD").value = idAirport;
        document.getElementById("idTourUPD").value = idTour;
        document.getElementById("idStorageUPD").value = idStorage;
        document.getElementById("idFinanceReportUPD").value = idFinanceReport;
        document.getElementById("priceAllTourUPD").value = priceAllTour;
        document.getElementById("idHotelUPD").value = idHotel;
        document.getElementById("idCountryUPD").value = idCountry;




        $http.get('/grouptourist/get').then(function (response) {
            var group = response.data;
            var selector = document.getElementById("idGroupTouristUPD");
            $(selector).empty();
            for (var i = 0; i < group.length; i++) {
                var option = document.createElement("option");
                if (group[i].idGroupTourist == group){
                    option.selected = 'selected';
                }
                option.text = group[i].idGroupTourist;
                option.value = group[i].idGroupTourist;
                selector.add(option);

            }
        });

        $http.get('/airport/get').then(function (response) {
            var air = response.data;
            var selector = document.getElementById("idAirportUPD");
            $(selector).empty();
            for (var i = 0; i < air.length; i++) {
                var option = document.createElement("option");
                if (air[i].idAirport == air){
                    option.selected = 'selected';
                }
                option.text = air[i].idAirport;
                option.value = air[i].idAirport;
                selector.add(option);

            }
        });
        $http.get('/tour/get').then(function (response) {
            var tour = response.data;
            var selector = document.getElementById("idTourUPD");
            $(selector).empty();
            for (var i = 0; i < tour.length; i++) {
                var option = document.createElement("option");
                if (tour[i].idTour == tour){
                    option.selected = 'selected';
                }
                option.text = tour[i].idTour;
                option.value = tour[i].idTour;
                selector.add(option);

            }
        });
        $http.get('/storage/get').then(function (response) {
            var store = response.data;
            var selector = document.getElementById("idStorageUPD");
            $(selector).empty();
            for (var i = 0; i < store.length; i++) {
                var option = document.createElement("option");
                if (store[i].idStorage == store){
                    option.selected = 'selected';
                }
                option.text = store[i].idStorage;
                option.value = store[i].idStorage;
                selector.add(option);

            }
        });
        $http.get('/financereport/get').then(function (response) {
            var finance = response.data;
            var selector = document.getElementById("idFinanceReportUPD");
            $(selector).empty();
            for (var i = 0; i < finance.length; i++) {
                var option = document.createElement("option");
                if (finance[i].idFinanceReport == finance){
                    option.selected = 'selected';
                }
                option.text = finance[i].idFinanceReport;
                option.value = finance[i].idFinanceReport;
                selector.add(option);

            }
        });
        $http.get('/hotel/get').then(function (response) {
            var hotel = response.data;
            var selector = document.getElementById("idHotelUPD");
            $(selector).empty();
            for (var i = 0; i < hotel.length; i++) {
                var option = document.createElement("option");
                if (hotel[i].idHotel == hotel){
                    option.selected = 'selected';
                }
                option.text = hotel[i].idHotel;
                option.value = hotel[i].idHotel;
                selector.add(option);

            }
        });

        $http.get('/country/get').then(function (response) {
            var country = response.data;
            var selector = document.getElementById("idCountryUPD");
            $(selector).empty();
            for (var i = 0; i < country.length; i++) {
                var option = document.createElement("option");
                if (country[i].idCountry == country){
                    option.selected = 'selected';
                }
                option.text = country[i].idCountry;
                option.value = country[i].idCountry;
                selector.add(option);

            }
        });
        };







    this.updateAgency = function update() {
        var id = document.getElementById("idAgencyUPD").value;
        var indexGroupTouirist = document.getElementById("idGroupTouristUPD").selectedIndex;
        var group_id = document.getElementById("idGroupTouristUPD").options[indexGroupTouirist].value;

        var indexAirport = document.getElementById("idAirportUPD").selectedIndex;
        var airport_id = document.getElementById("idAirportUPD").options[indexAirport].value;

        var indexTour = document.getElementById("idTourUPD").selectedIndex;
        var tour_id = document.getElementById("idTourUPD").options[indexTour].value;

        var indexStorage = document.getElementById("idStorageUPD").selectedIndex;
        var storage_id = document.getElementById("idStorageUPD").options[indexStorage].value;

        var indexFinanceReport = document.getElementById("idFinanceReportUPD").selectedIndex;
        var finance_id = document.getElementById("idFinanceReportUPD").options[indexFinanceReport].value;

        var price = document.getElementById("priceAllTourUPD").value;

        var indexHotel = document.getElementById("idHotelUPD").selectedIndex;
        var hotel_id = document.getElementById("idHotelUPD").options[indexHotel].value;

        var indexCountry = document.getElementById("idCountryUPD").selectedIndex;
        var country_id = document.getElementById("idCountryUPD").options[indexCountry].value;




        var req = {
            method: 'POST',
            url: '/agency/update?id=' + id,
            data: {
                grouptourist_idGroupTourist:group_id,
                airport_idAirport:airport_id,
                tour_idTour:tour_id,
                storage_idStorage:storage_id,
                financereport_idFinanceReport:finance_id,
                priceAllTour:price,
                hotel_id_hotel:hotel_id,
                country_id_country:country_id

            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.delFromAgency = function del(id) {
        $http.get('/agency/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

