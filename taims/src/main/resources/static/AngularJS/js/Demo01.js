 var app = angular.module("app",[]);//使得angular代码覆盖html全页
  
 app.controller("firstController",function($scope){
 	$scope.list = [{
 		"name":"Jack",
 		"sex":"male",
 		"age":20
 	},{
 		"name":"Tom",
 		"sex":"male",
 		"age":18
 	}]

 });
 
app.controller("A",function($scope){
	$scope.name="sasrqrqrq141";
});

app.controller("C",function($scope){
	$scope.test = function(){
		alert($scope.username)
	};
});

app.controller("D",function($scope){
	$scope.flushCity = function(){
		var temp = $scope.province;
		china.forEach(function(one){
			if(one.name == temp){
				$scope.city = one.city;
				return false;
			}
		})
	}; 
	var china = [{
			"name":"辽宁",
			"city":["大连","鞍山","抚顺"]
		},{
			"name":"黑龙江",
			"city":["哈尔滨","齐齐哈尔","漠河"]
		},{
			"name":"吉林",
			"city":["长春","吉林","通化"]
		}];
	$scope.china =china;
	
});