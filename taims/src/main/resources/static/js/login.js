var system = new Vue({
	el:".system",
	data:{
		loginRole:"学生",
		recoverRole:"员工"
	},
	methods:{
		showLoginPanel:function(){
			$("#loginTab").addClass("tab-active");
			$("#recoverTab").removeClass("tab-active");
			$("#loginPannel").addClass("pannel-active");
			$("#recoverPannel").removeClass("pannel-active");
			
		},
		showRecoverPanel:function(){
			$("#loginTab").removeClass("tab-active");
			$("#recoverTab").addClass("tab-active");
			$("#recoverPannel").addClass("pannel-active");
			$("#loginPannel").removeClass("pannel-active");
		}
	}
});