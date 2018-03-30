var info = new Vue({
	el:"#student-info-add",
	data:{
		name:null,
		sex:"男",
		classList:[
		],
		classId:null,
		tel:null,
		pid:null,
		school:null,
		major:null,
		yearList:[
		],
		yearId:null,
		state:"学习"
	},
	mounted:function(){
		$.ajax({
			url:"/class/search/list",
			dataType:"json",
			success:function(response){
				for(one of response.result){
					info.classList.push({label:one.name,value:one.id})
				}
			},
			error:function(){
				alert("error");
			}
		});
		var date=new Date();
		//alert(date.getFullYear());
		var year=date.getFullYear();
		for(var i=5;i>=0;i--){
			var temp=year+i;
			//console.log(year-i);
			this.yearList.push({
				label:temp,value:temp
			});
		};
		for(var i=1;i<=10;i++){
			var temp=year-i;
			//console.log(year-i);
			this.yearList.push({
				label:temp,value:temp
			});
		}
		this.yearId=year;

	},
	methods:{
		selectDate:function(date){
			this.birthday = date;
		},
		saveInfo:function(){
			var checkName = new RegExp("^[\u4e00-\u9fa5]{2,20}$").test(this.name);
			var checkBirthday = (this.birthday!=null&&this.birthday!="");
			var checkClassId = (this.classId!=null&&this.classId!="");
			var checkName = new RegExp("^1[0-9]{10}$").test(this.tel);
			var checkPid = IdentityCodeValid(this.pid);
			var checkSchool = new RegExp("^[\u4e00-\u9fa5]{4,50}$").test(this.school);
			var checkMajor = new RegExp("^[\u4e00-\u9fa5]{2,50}$").test(this.major);
			var info = this;
			if(checkName&&checkBirthday&&checkClassId&&checkName&&checkPid&&checkSchool&&checkMajor){
				var checkPidCount = false;
				$.ajax({
					url:"/student/info/search/pidCount",
					type:"post",
					dataType:"json",
					data:{
						"pid":info.pid
					},
					async:false,
					success:function(resp){
						if (resp.result == true) {
							alert("系统中存在此身份证号");
							checkPidCount=true;
						}
					},
					error:function(){
					}
				});
				if(checkPidCount==false){
					$.ajax({
						url:"/student/info/insert/info",
						type:"post",
						dataType:"json",
						data:{
							"name":info.name,
							"sex":info.sex,
							"birthday":info.birthday,
							"class_id":info.classId,
							"tel":info.tel,
							"pid":info.pid,
							"school":info.school,
							"major":info.major,
							"year":info.yearId,
							"state":info.state
						},
						success:function(resp){
							info.$Message.success({content:"数据保存成功",
								onClose:function(){
									$("#content",parent.document).attr("src","/student/info/index.html")
								}
							});
						},
						error:function(){
							info.$Message.error("添加失败")
						}
					});
				}else{
					info.$Message.error("添加失败")
				}
			}else{
				info.$Message.error("输入信息有误！")
			}
		},
		cancelInfo:function(){
			$("#content",parent.document).attr("src","/student/info/index.html")
		}
		
	}
});