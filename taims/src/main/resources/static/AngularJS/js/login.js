var app = angular.module("loginApp",[]);

app.controller("loginController",function($scope, $login, $recover){
	
	$scope.login = function(e){
		if($scope.loginForm.$valid){
			e.target.action = "/user/login";
			e.target.submit();
		}
		$scope.loginSystem($scope);
	}
	$scope.showRecover = function(){
		$login.hide();
		$recover.show();
	}
	
});

app.controller("recoverController",function($scope, $login, $recover){
	$scope.step=1;
	$scope.next = function(e){
		$recover.next($scope,e,$login);
	}
	$scope.showLogin=function(){
		$recover.hide($scope);
		$login.show();
	}
});

var Login = function(){
	
}

Login.prototype.loginSystem = function($scope){
	throw "抽象";
}

Login.prototype.show = function(){
	throw "抽象";
}
Login.prototype.hide = function(){
	throw "抽象";
}

var LoginImpl  = function(){
	
}
LoginImpl.prototype = new Login();

LoginImpl.prototype.loginSystem = function($scope){
	if($scope.loginForm.$valid){
		alert("login")
	}else{
		
	}
}
LoginImpl.prototype.show = function(){
	$(".login-container").show();
}
LoginImpl.prototype.hide = function(){
	$(".login-container").hide();
}
var Recover = function(){

}

Recover.prototype.show=function(){
	throw "抽象";
}
Recover.prototype.hide=function($scope){
	throw "抽象";
}

Recover.prototype.next = function($scope,e,$login){
	throw "抽象";
}
var RecoverImpl = function(){
	
}

RecoverImpl.prototype.show = function(){
	$(".recover-container").show();
}
RecoverImpl.prototype.hide = function($scope){
	$(".recover-container").hide();
	$scope.step=1;
	$(".recover-container .input").val("");
}
RecoverImpl.prototype.next = function($scope,e,$login){
	var name = $(e.target).attr("name");
	var bool = eval("$scope." + name +".$valid");
	if(bool){
		$scope.step = $scope.step + 1;
	}
	if(name == "step3"){
		var obj = this;
		var timer = setInterval(function(){
			var sec = $("#sec");
			var temp = sec.html();
			if(temp > 0 ){
				temp = temp-1;
				sec.html(temp);
			}else{
				obj.hide($scope);
				$login.show();
				clearInterval(timer);//关闭定时器
				sec.html(10);
			}
		},1000);
	}
}

app.service("$login",LoginImpl);
app.service("$recover",RecoverImpl);
