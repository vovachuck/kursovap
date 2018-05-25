var App = angular.module('App',[]);

App.controller('Customs',function ($http,$scope) {
    $http.get('/customs/get').then(function (response){
        $scope.customs=response.data;
        console.log(response);
    });
    this.insertToCustoms = function add() {
        var nati = document.getElementById("nationality").value;
        var type = document.getElementById("typeVisa").value;
        var dateEnd = document.getElementById("dateEnd").value;
        var dateStart = document.getElementById("dateStart").value;
        var price = document.getElementById("priceVIsa").value;


        var req = {
            method: 'POST',
            url: '/customs/insert',
            data: {
                nationality: nati,
                typeVisa: type,
                dateEnd: dateEnd,
                dateStart: dateStart,
                priceVIsa: price
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

    this.startUpdateCustoms = function startUpdate(idCustoms,nationality,typeVisa,
                                                   dateEnd,dateStart,
                                                   priceVIsa) {
        document.getElementById("idCustomsUPD").value = idCustoms;
        document.getElementById("nationalityUPD").value = nationality;
        document.getElementById("typeVisaUPD").value = typeVisa;
        document.getElementById("dateEndUPD").value = dateEnd;
        document.getElementById("dateStartUPD").value = dateStart;
        document.getElementById("priceVIsaUPD").value = priceVIsa;

    };

    this.updateCustoms = function update() {
        var id = document.getElementById("idCustomsUPD").value;
        var nati = document.getElementById("nationalityUPD").value;
        var type = document.getElementById("typeVisaUPD").value;
        var dateEnd = document.getElementById("dateEndUPD").value;
        var dateStart = document.getElementById("dateStartUPD").value;
        var price = document.getElementById("priceVIsaUPD").value;

        var req = {
            method: 'POST',
            url: '/customs/update?id=' + id,
            data: {
                nationality: nati,
                typeVisa: type,
                dateEnd: dateEnd,
                dateStart: dateStart,
                priceVIsa: price

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

    this.delFromCustoms = function del(id) {
        var time = performance.now();
        $http.get('/customs/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

