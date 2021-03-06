angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1';

    $scope.saveProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath + '/product', $scope.NewProduct)
            .then(function (resp){
                $scope.NewProduct = null
                $scope.fillTable();
            })

    };

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

    $scope.fillCategories = function () {
        $http({
            url: contextPath + '/category',
            method: 'GET',
        }).then(function (response) {
            $scope.Categories = response.data;
        });
    };

    $scope.fillCart = function () {
        $http({
            url: contextPath + '/cart/',
            method: 'GET',
        }).then(function (response) {
            $scope.Cart = response.data;
        });
    };

    $scope.fillTable();
    $scope.fillCategories();
    $scope.fillCart();

    $scope.deleteProductById = function (id) {
        $http.delete(contextPath + '/product/' + id).then(function () {
            $scope.fillTable();
        });
    };

    $scope.addToCart = function (id) {
        $http.put(contextPath + '/cart/add/' + id).then(function () {
            $scope.fillCart();
        });
    };

    $scope.deleteFromCart = function (id) {
        $http.delete(contextPath + '/cart/delete/' + id).then(function () {
            $scope.fillCart();
        });
    };

    $scope.clearCart = function () {
        $http.get(contextPath + '/cart/clear').then(function () {
            $scope.fillCart();
        });
    };

});