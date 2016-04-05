var app = angular.module ("NoteManager", ['ngRoute']);

app.controller("AddNote", function($scope, $http) {
    $scope.addNote = function (){
        var data = $.param({
                    title: $scope.title,
                    text: $scope.text
                });
        var config = {
                        headers : {
                            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                        }
                     }

        $http.post("/note-manager-web/AddsTitle.htm", data, config)
        .success(function (data, status, headers, config) {
                        $scope.PostDataResponse = data;
                    })
        .error(function (data, status, header, config) {
                        $scope.ResponseDetails = "Data: " + data +
                            "<hr />status: " + status +
                            "<hr />headers: " + header +
                            "<hr />config: " + config;
        });
    };
});


