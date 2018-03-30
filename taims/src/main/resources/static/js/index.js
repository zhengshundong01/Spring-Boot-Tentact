var app=new Vue({
	el:"#app",
	methods:{
		link:function(name){
			var url = "";
			if (name=="student-info") {
				url="/student/info/index.html";
			}
			if (name=="place-info") {
				url="/class/info/index.html";
			}
			if (name=="class-info") {
				url="/place/info/index.html";
			}
			
			$("#content").attr("src", url);
		}
	}
});