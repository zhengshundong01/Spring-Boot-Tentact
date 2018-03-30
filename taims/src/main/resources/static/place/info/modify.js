var info = new Vue({
	el:"#place-info-add",
	data:{
		id:null,
		name:null
	},
	mounted:function(){
		this.id = sessionStorage.id;
		this.name = sessionStorage.name;
	},
	methods:{
		updateInfo:function(){
			var checkName = new RegExp("^[\u4e00-\u9fa5]{2,50}$").test(this.name);
			var info = this;
			if(checkName){
					$.ajax({
						url:"/place/update/info",
						type:"post",
						dataType:"json",
						data:{
							"id":info.id,
							"name":info.name,
						},
						success:function(resp){
							info.$Message.success({content:"数据保存成功",
								onClose:function(){
									$("#content",parent.document).attr("src","/place/info/index.html")
								}
							});
						},
						error:function(){
							info.$Message.error("添加失败")
						}
					});
			}else{
				info.$Message.error("输入信息有误！")
			}
		},
		cancelInfo:function(){
			$("#content",parent.document).attr("src","/place/info/index.html")
		}
	}
});