var info = new Vue({
	el:"#place-info-add",
	data:{
		name:null
	},
	methods:{
		saveInfo:function(){
			var checkName = new RegExp("^[\u4e00-\u9fa5]{2,50}$").test(this.name);
			var info = this;
			if(checkName){
				$.ajax({
					url:"/place/insert/info",
					type:"post",
					dataType:"json",
					data:{
						"name":info.name						
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