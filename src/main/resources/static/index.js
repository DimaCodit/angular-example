angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1';

    // $scope.savePatient = function () {
    //     console.log($scope.NewPatient)
    //     $http.post(contextPath + '/patient', $scope.NewPatient)
    //         .then(function (resp){
    //             $scope.NewPatient = null
    //             $scope.fillTable();
    //         })
    //
    // };

    $scope.fillTable = function (pageIndex = 1) {
        $http({
            url: contextPath + '/product',
            method: 'GET',
            params: {
                'page-number': pageIndex ? pageIndex : 1,
                // 'age': $scope.filter ? $scope.filter.age : null
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;
            let minPageIndex = pageIndex - 1;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 1;
            if (maxPageIndex > $scope.ProductsPage.totalPages) {
                maxPageIndex = $scope.ProductsPage.totalPages;
            }

            $scope.PaginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
        });
    };

    $scope.generatePagesIndexes = function(startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.fillTable();

    $scope.deleteProductById = function (id) {
        $http.delete(contextPath + '/product/' + id).then(function () {
            $scope.fillTable();
        });
    };

});