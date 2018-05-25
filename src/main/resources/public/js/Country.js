var App = angular.module('App',[]);

App.controller('Country',function ($http,$scope) {
    $http.get('/country/get').then(function (response){
        $scope.country=response.data;
        console.log(response);
    });

    this.startInsertCountry = function startUpdate() {
        $http.get('/customs/get').then(function (response) {
            var customs = response.data;
            var selector = document.getElementById("idCustoms");
            $(selector).empty();
            for (var i = 0; i < customs.length; i++) {
                var option = document.createElement("option");
                option.text = customs[i].nationality;
                option.value = customs[i].idCustoms;
                selector.add(option);

            }
        });



    };


    this.insertToCountry = function add() {
        var nameCountry = document.getElementById("nameCountry").value;

        var indexCustoms = document.getElementById("idCustoms").selectedIndex;
        var customs_id = document.getElementById("idCustoms").options[indexCustoms].value;




        var req = {
            method: 'POST',
            url: '/country/insert',
            data: {
                nameCountry:nameCountry,
                customs_idCustoms:customs_id



            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdateCountry = function startUpdate(idCountry,nameCountry,idCustoms) {
        document.getElementById("idCountryUPD").value = idCountry;
        document.getElementById("nameCountryUPD").value = nameCountry;
        document.getElementById("idCustomsUPD").value = idCustoms;


        $http.get('/customs/get').then(function (response) {
            var customs = response.data;
            var selector = document.getElementById("idCustomsUPD");
            $(selector).empty();
            for (var i = 0; i < customs.length; i++) {
                var option = document.createElement("option");
                if (customs[i].idCustoms == customs){
                    option.selected = 'selected';
                }
                option.text = customs[i].nationality;
                option.value = customs[i].idCustoms;
                selector.add(option);

            }
        });





    };

    this.updateCountry = function update() {
        var id = document.getElementById("idCountryUPD").value;
        var nameCountry = document.getElementById("nameCountryUPD").value;


        var indexCustoms = document.getElementById("idCustomsUPD").selectedIndex;
        var customs_id = document.getElementById("idCustomsUPD").options[indexCustoms].value;




        var req = {
            method: 'POST',
            url: '/country/update?id=' + id,
            data: {

                nameCountry:nameCountry,

                customs_idCustoms:customs_id

            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.delFromCountry = function del(id) {
        $http.get('/country/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

