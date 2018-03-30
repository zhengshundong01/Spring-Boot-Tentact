var app = angular.module("app",[]);
app.controller("A",function($scope){
	$scope.search = function(e){
		if($scope.searchForm.$valid){
			e.target.action = "www.baidu.com";
			e.target.submit();
		}
	}
});

app.controller("B",function($scope){
	$scope.goods = [{
		"name":"红烧鸡块",
		"price":"11",
		"num":0
	},{
		"name":"炸鸡啤酒",
		"price":"10",
		"num":0
	},{
		"name":"黄金虾球",
		"price":"12",
		"num":0
	}]
	$scope.calc = function(){
		var temp = 0;
		$scope.goods.forEach(function(one){
			temp+=one.price * one.num;
		});
		$scope.total = temp;
	}
	$scope.total = 0;
	$scope.order=function(e){
		if($scope.orderForm.$valid&&$scope.total>0){
			e.target.action = "http://www.taobao.com";
			e.target.submit();
		}
	}
})

app.controller("D",function($scope){
	$scope.today = new Date().toLocaleString();

})

