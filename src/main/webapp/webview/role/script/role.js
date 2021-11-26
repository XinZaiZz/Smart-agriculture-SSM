/**
 * 查询角色信息方法
 */	
function getRole(element){
	$(element).datagrid( {
		ajaxSource: path+"/role/find",
		ajaxDataProp:"rows",
		serverMethod:"POST",
		sort: false,
		fnServerParams: function (aoData) {  
			aoData.push({name: "name", value: $("form[name=角色信息查询表单]").find("input[name=name]").val() });
		},
		columns: [{data:"sid",title:"<input type='checkbox' class='group-checkable' data-set='table[title="+$(element).attr("title")+"] .checkboxes' />"},
		          //{ title:"主键ID",data: "sid",orderable:true},
		          { title:"角色名",data: "name",orderable:true},
		          {title:"操作",data:"sid",orderable:false}
		  ],
		paginate: {
            previous: "上一页",
            next: "下一页",
            last: "最后一页",
            first: "第一页"
        },
        pageLength: 10,
        pagingType: "bootstrap_full_number",
        lengthMenu: [[5,10, 15, 20, -1], [5,10, 15, 20, "全部"]],	
        language: {
            aria: {
                sortAscending: ": activate to sort column ascending",
                sortDescending: ": activate to sort column descending"
            },
            emptyTable: "暂无相关数据",
            info: "总记录数： _TOTAL_",
            infoEmpty: "暂无相关记录",
            infoFiltered: "(filtered1 from _MAX_ total records)",
            lengthMenu: "显示 _MENU_ 条数据",
            search: "搜索:",
            zeroRecords: "暂无相关数据",
        },
        columnDefs: [{
        	"createdCell": function (td, cellData, rowData, row, col){
        		$(td).html("<input type='checkbox' class='checkboxes' value="+rowData.sid+" />")
        	},
            orderable: false,
            targets: [0]
        },{
        	"createdCell": function (td, cellData, rowData, row, col){
    			$(td).html("<a href=\"javascript:void(0)\" onclick=\"toUpdate({'sid':'"+rowData.sid+"'})\" title=\"修改\" class=\"label label-sm btn btn-info margin-right-5\">修改</a>" +
    					"<a href=\"javascript:void(0)\" onclick=\"deleteById({'sid':'"+rowData.sid+"'})\" title=\"删除\" class=\"label label-sm btn btn-info margin-right-5\">删除</a>");
    	},
        	targets: [-1]
        }]
} );
$(element).find(".group-checkable").change(function() {
      var e = jQuery(this).attr("data-set"),
      a = jQuery(this).is(":checked");
      jQuery(e).each(function() {
          a ? ($(this).prop("checked", !0), $(this).parents("tr").addClass("active")) : ($(this).prop("checked", !1), $(this).parents("tr").removeClass("active"))
      })
  }),
  $(element).on("change", "tbody tr .checkboxes", function() {
      $(this).parents("tr").toggleClass("active")
  });
}	

/**
 * 打开角色新增页面
 */
function add(){
	$(".jhtml-tabs").tabs("add",{
	      text: "新增角色",
	      url: path+"/webview/role/add.jsp",
	      flush:true,
	      close: true
	    });
}

/**
 * 打开角色修改页面
 */
function toUpdate(params){
	$(".jhtml-tabs").tabs("add",{
      text: "修改角色",
      url: path+"/webview/role/update.jsp?sid="+params.sid,
      flush:true,
      close: true
    });
}

/**
 * 保存角色页面
 */
function save(element){
	$(element).ajaxSubmit({
		beforeSubmit: function(arr, $form, options) {
			return $(element).validation("validate");
		},
		success:function(data){
			$.message.alert({
				message:data.message,
				callback:function(){
					if(data.success){
						var datagrid = $("table[title=角色信息列表]").datagrid();
						datagrid.api().ajax.reload();
					}
				}
			});
		},
		error:function(data){
			$.message.alert({message:data.message});
		}
	});
}

/**
 * 根据ID删除角色
 */
function deleteById(params){
	var sid = params.sid;
	if(/[^(^\s*)|(\s*$)]/.test(sid)){
		$.message.confirm('您确认想要删除记录吗？',function(r){    
	    	if(r){
				$.ajax({
					type: "POST",
					dataType:"json",
					contentType: "application/json; charset=utf-8",
					url: path+"/role/delete",
					data:"[{\"sid\":\""+sid+"\"}]",
					success: function(data) {
						$.message.alert({
							message:data.message,
							callback:function(){
								if(data.success){
									var datagrid = $('table[title=角色信息列表]').datagrid();
									datagrid.api().ajax.reload();
								}
							}
						});
					},
					error: function(data){
						$.message.alert(data.message);
					}
				});
			}
		});  
	}else{
		$.message.alert("请选择要删除的记录！");
		return;
	}
}

/**
 * 批量删除角色信息
 */
function deleteChartInfo(element, params) {
	var $this=this;
	var json = "";
	$(element).find(".checkboxes:checked").each(function(){
		json += (json) ? ',{"sid":"'+$(this).val()+'"}' : '{"sid":"'+$(this).val()+'"}';
	});
	if (json.length == 0) {
		$.message.alert("请选择要删除的记录！");
		return;
	}
	json = "["+json+"]";
		$.message.confirm('您确认想要删除记录吗？',function(r){    
	    	if(r){
				$.ajax({
					type: "POST",
					dataType:"json",
					contentType: "application/json; charset=utf-8",
					url: path+"/role/delete",
					data:json,
					success: function(data) {
						$.message.alert({
							message:data.message,
							callback:function(){
								if(data.success){
									var datagrid = $('table[title=角色信息列表]').datagrid();
									datagrid.api().ajax.reload();
								}
							}
						});
					},
					error: function(data){
						$.message.alert(data.message);
					}
				});
			}
		});  
}

/**
 *  Load form 表单
 */
function load(element,data){
	for(var name in data){
		if(!name){
			continue;
		}
		$("input[name="+name+"]:not(input[type=radio],input[type=checkbox]),select[name="+name+"],textarea[name="+name+"]", element).each(function(i,ele){
			$(ele).val(data[name]);
		});
	}
}

/**
 * 清空form表单
 */
function clear(element, params) {
	$(element).find("input:visible:not(input[type=radio],input[type=checkbox]),select,textarea").val("");
};

