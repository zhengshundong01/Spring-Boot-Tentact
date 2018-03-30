//var arr=[];
var Info=new Vue({
	el:"#student-info",
	data:{
		columns:[
		{
			width:60,
			type:'selection',
			align:'center'
		},{
			title:"编号",
			key:"id",
			align:"center",
			width:80
		},{
			title:"姓名",
			key:"name",
			align:"center",
			width:100
		},{
			title:"性别",
			key:"sex",
			align:"center",
			width:80
		},{
			title:"生日",
			key:"birthday",
			align:"center",
			width:150
		},{
			title:"班级",
			key:"className",
			align:"center",
			width:110
		},{
			title:"电话号码",
			key:"tel",
			align:"center",
			width:150
		},{
			title:"身份证",
			key:"pid",
			align:"center",
			width:220
		},{
			title:"毕业院校",
			key:"school",
			align:"center",
			width:200
				
		},{
			title:"所学专业",
			key:"major",
			align:"center",
			width:100
		},{
			title:"毕业年份",
			key:"year",
			width:100
		},{
			title:"状态",
			key:"state",
			align:"center",
			width:100
		},{
			title:"操作",
			align:"center",
			width:150,
			key:"action",
			
			render: function(h, params){
                 return h('div', [
                     h('Button', {
                         props: {
                             type: 'primary',
                             size: 'small'
                         },
                         style: {
                        	 
                         },
                         on: {
                             click: function(){
                            	 sessionStorage.id=Info.data[params.index].id;
                            	 sessionStorage.name=Info.data[params.index].name;
                            	 sessionStorage.sex=Info.data[params.index].sex;
                            	 sessionStorage.birthday=Info.data[params.index].birthday;
                            	 sessionStorage.className=Info.data[params.index].className;
                            	 sessionStorage.tel=Info.data[params.index].tel;
                            	 sessionStorage.pid=Info.data[params.index].pid;
                            	 sessionStorage.school=Info.data[params.index].school;
                            	 sessionStorage.major=Info.data[params.index].major;
                            	 sessionStorage.year=Info.data[params.index].year;
                            	 sessionStorage.state=Info.data[params.index].state;
                            	 $("#content",parent.document).attr("src","/student/info/modify.html")
                             }
                         }
                     }, '修改'),
                     h('Button', {
                         props: {
                             type: 'error',
                             size: 'small'
                         },
                         style: {
//                             marginRight: '5px',
//                            	 color:'#fff'
                         },
                         on: {
                             click: function(){
                            	 $.ajax({
                            		 url:"/student/info/delete/id",
                            		 dataType:"json",
                            		 type:"post",
                            		 data:{
                            			 id:Info.data[params.index].id
                            		 },
                            		 success:function(resp){
                            			 alert("删除成功！")
                            			 Info.reload();
                            		 },
                            		 error:function(){
                            			 alert("error")
                            		 }
                            	 })
                               //?????没明白
                                
                             }
                         }
                     }, '删除'),
                 ]);
             }

		}],
		data:[],
		size:6,
		total:0,
		currentPage:1//定义当前页数
	},
	mounted:function(){//在网页加载后先显示这个方法
		this.reload();
	},
	methods:{
		toPage:function(i){
			this.currentPage = i;
			$.ajax({
				url:"/student/info/search/Page",
				type:"post",
				dataType:"json",
				data:{
					start:(this.currentPage-1)* this.size,
					length:this.size
				},
				success:function(resp){
					//回调
					Info.data=resp.result;
				},
				error:function(){
					alert("error")
				}
			});
		},
		reload:function(){
			var Info=this;
			$.ajax({
				url:"/student/info/search/Count",
				type:"get",
				dataType:"json",
				async:false,
				success:function(resp){
					Info.total=resp.count;
					var i = Math.ceil(Info.total/Info.size);
					if (Info.currentPage > i) {
						Info.currentPage = i;
					}
				},
				error:function(){
					alert("erro")
				}
			});
			
			$.ajax({
				url:"/student/info/search/Page",
				type:"post",
				dataType:"json",
				data:{//上传的数据
					start:(this.currentPage-1)* this.size,
					length:this.size
				},
				success:function(resp){
					Info.data=resp.result;
				},
				error:function(){
					alert("erro")
				}
			});
		},
		selectRow:function(item){
//			arr = [];//方法二
//			for(var one of item){
//				arr.push(one.id);
//			}
			var ids = [];
			for(var one of item){
				ids.push(one.id);
			}
			this.ids = ids;
		},
		deleteByids:function(){
//			arr = [];//方法二
//			alert(arr)
			$.ajax({
				url:"/student/info/delete/ids",
				type:"post",
				dataType:"json",
				data:{"ids":Info.ids},
				traditional:true,//ajsx默认不可以上传数组，该参数允许上传数组
				success:function(resp){
					Info.reload();
				},
				error:function(){
					alert("erro")
				}
			});
		},
		add:function(){
			$("#content",parent.document).attr("src","/student/info/add.html")
		}
	}
});