var App = angular.module('App',[]);

App.controller('GroupTourist',function ($http,$scope) {
    $http.get('/grouptourist/get').then(function (response){
        $scope.grouptourist=response.data;
        console.log(response);
    });
    this.insertToGroup = function add() {
        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        var surName = document.getElementById("surName").value;
        var passportData = document.getElementById("passportData").value;
        var gender = document.getElementById("gender").value;
        var kids = document.getElementById("kids").value;
        var hotel = document.getElementById("hotel").value;
        var old = document.getElementById("old").value;
        var category = document.getElementById("category").value;
        var nameGroup = document.getElementById("nameGroup").value;
        var dateOfBirth = document.getElementById("dateOfBirth").value;


        var req = {
            method: 'POST',
            url: '/grouptourist/insert',
            data: {
                firstName: firstName,
                lastName: lastName,
                surName: surName,
                passportData: passportData,
                gender: gender,
                kids: kids,
                hotel: hotel,
                old: old,
                category: category,
                nameGroup: nameGroup,
                dateOfBirth: dateOfBirth

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

    this.startUpdateGroup = function startUpdate(idGroupTourist,firstName,lastName,
                                                 surName,passportData,gender,
                                                 kids,hotel,old,
                                                 category,nameGroup,dateOfBirth
                                                 ) {
        document.getElementById("idGroupTouristUPD").value = idGroupTourist;
        document.getElementById("firstNameUPD").value = firstName;
        document.getElementById("lastNameUPD").value = lastName;
        document.getElementById("surNameUPD").value = surName;
        document.getElementById("passportDataUPD").value = passportData;
        document.getElementById("genderUPD").value = gender;
        document.getElementById("kidsUPD").value = kids;
        document.getElementById("hotelUPD").value = hotel;
        document.getElementById("oldUPD").value = old;
        document.getElementById("categoryUPD").value = category;
        document.getElementById("nameGroupUPD").value = nameGroup;
        document.getElementById("dateOfBirthUPD").value = dateOfBirth;
    };

    this.updateGroup = function update() {
        var id = document.getElementById("idGroupTouristUPD").value;
        var firstName = document.getElementById("firstNameUPD").value;
        var lastName = document.getElementById("lastNameUPD").value;
        var surName = document.getElementById("surNameUPD").value;
        var passportData = document.getElementById("passportDataUPD").value;
        var gender = document.getElementById("genderUPD").value;
        var kids = document.getElementById("kidsUPD").value;
        var hotel = document.getElementById("hotelUPD").value;
        var old = document.getElementById("oldUPD").value;
        var category = document.getElementById("categoryUPD").value;
        var nameGroup = document.getElementById("nameGroupUPD").value;
        var dateOfBirth = document.getElementById("dateOfBirthUPD").value;

        var req = {
            method: 'POST',
            url: '/grouptourist/update?id=' + id,
            data: {
                firstName: firstName,
                lastName: lastName,
                surName: surName,
                passportData: passportData,
                gender: gender,
                kids: kids,
                hotel: hotel,
                old: old,
                category: category,
                nameGroup: nameGroup,
                dateOfBirth: dateOfBirth

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

    this.delFromGroup = function del(id) {
        var time = performance.now();
        $http.get('/grouptourist/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

