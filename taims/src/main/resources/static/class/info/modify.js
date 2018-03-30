var info = new Vue({
	el:"#class-info-add",
	data:{
		id:null,
		name:null,
		major:null,
		typeList:[
			{
				label:"内部定制"
			},{
				label:"企业培训"
			}
		],
		typeId:null,
		stateList:[
			{
				label:"已开班"
			},{
				label:"未开班"
			},{
				label:"已结束"
			}
		],
		stateId:null,
		placeNameList:[
		],
		placeNameId:null
	},
	mounted:function(){
		var info = this;
		var placeForId = 0;
		$.ajax({
			url:"/place/search/list",
			dataType:"json",
			success:function(response){
				for(one of response.result){
					info.placeNameList.push({label:one.name,value:one.id})
					if(one.name == sessionStorage.placeName){
						placeForId = one.id;
						info.placeNameId = placeForId;
					}
				}
			},
			error:function(){
				alert("error");
			}
		});

		this.id = sessionStorage.id;
		this.name = sessionStorage.name;
		this.major = sessionStorage.major;
		this.typeId = sessionStorage.type;
		this.stateId = sessionStorage.state;
		
	},
	methods:{
		updateInfo:function(){
			var checkName = new RegExp("^[\u4e00-\u9fa5]{2,4}$").test(this.name);
			var checkMajor = new RegExp("^[\u4e00-\u9fa5]{2,50}$").test(this.major);
			var info = this;
			if(checkName&&checkName){
					$.ajax({
						url:"/class/update/info",
						type:"post",
						dataType:"json",
						data:{
							"id":info.id,
							"name":info.name,
							"major":info.major,
							"type":info.typeId,
							"state":info.stateId,
							"place_id":info.placeNameId
						},
						success:function(resp){
							info.$Message.success({content:"数据保存成功",
								onClose:function(){
									$("#content",parent.document).attr("src","/class/info/index.html")
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
			$("#content",parent.document).attr("src","/class/info/index.html")
		}
	}
});