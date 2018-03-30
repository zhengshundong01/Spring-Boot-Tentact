var info = new Vue({
	el:"#class-info",
	data:{
		columns:[
			{
				width:60,
				type:'selection',
				align:'center'
			},{
				title:"编号",
				key:"id",
				align:"center"
			},{
				title:"地点",
				key:"name",
				align:"center"
			},{
				title:"培训科目",
				key:"major",
				align:"center"
			},{
				title:"类型",
				key:"type",
				align:"center"
			},{
				title:"状态",
				key:"state",
				align:"center"
			},{
				title:"地点",
				key:"placeName",
				align:"center"
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
	                            	 sessionStorage.id=info.data[params.index].id;
	                            	 sessionStorage.name=info.data[params.index].name;
	                            	 sessionStorage.major=info.data[params.index].major;
	                            	 sessionStorage.type=info.data[params.index].type;
	                            	 sessionStorage.state=info.data[params.index].state;
	                            	 sessionStorage.placeName=info.data[params.index].placeName;
	                            	 $("#content",parent.document).attr("src","/class/info/modify.html")
	                             }
	                         }
	                     }, '修改'),
	                     h('Button', {
	                         props: {
	                             type: 'error',
	                             size: 'small'
	                         },
	                         style: {
//	                             marginRight: '5px',
//	                            	 color:'#fff'
	                         },
	                         on: {
	                             click: function(){
	                            	 $.ajax({
	                            		 url:"/class/delete/id",
	                            		 dataType:"json",
	                            		 type:"post",
	                            		 data:{
	                            			 id:info.data[params.index].id
	                            		 },
	                            		 success:function(resp){
	                            			 alert("删除成功！")
	                            			 info.reload();
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
		size:2,
		total:0,
		currentPage:1
	},mounted:function(){//在网页加载后先显示这个方法
		this.reload();
	},
	methods:{
		toPage:function(i){
			this.currentPage = i;
			$.ajax({
				url:"/class/search/page",
				type:"post",
				dataType:"json",
				data:{
					start:(this.currentPage-1)* this.size,
					length:this.size
				},
				success:function(resp){
					//回调
					info.data=resp.result;
				},
				error:function(){
					alert("error")
				}
			});
		},
		reload:function(){
			var info=this;
			$.ajax({
				url:"/class/search/count",
				type:"get",
				dataType:"json",
				async:false,
				success:function(resp){
					info.total=resp.count;
					var i = Math.ceil(info.total/info.size);
					if (info.currentPage > i) {
						info.currentPage = i;
					}
				},
				error:function(){
					alert("erro")
				}
			});
			
			$.ajax({
				url:"/class/search/page",
				type:"post",
				dataType:"json",
				data:{//上传的数据
					start:(this.currentPage-1)* this.size,
					length:this.size
				},
				success:function(resp){
					info.data=resp.result;
				},
				error:function(){
					alert("erro")
				}
			});
		},
		selectRow:function(item){
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
				url:"/class/delete/ids",
				type:"post",
				dataType:"json",
				data:{"ids":info.ids},
				traditional:true,//ajsx默认不可以上传数组，该参数允许上传数组
				success:function(resp){
					info.reload();
				},
				error:function(){
					alert("erro")
				}
			});
		},
		add:function(){
			$("#content",parent.document).attr("src","/class/info/add.html")
		}
	}
});