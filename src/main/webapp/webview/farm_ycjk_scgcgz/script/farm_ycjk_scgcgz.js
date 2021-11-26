/**
 * 查询生产过程跟踪方法
 */
function getFarm_ycjk_scgc(element){
    $(element).datagrid( {
        ajaxSource: path+"/farm_ycjk_scgc/find",
        ajaxDataProp:"rows",
        serverMethod:"POST",
        sort: false,
        fnServerParams: function (aoData) {
            aoData.push({name: "name", value: $("form[name=生产过程跟踪表单]").find("input[name=name]").val() });
        },
        columns: [{data:"sid",title:"<input type='checkbox' class='group-checkable' data-set='table[title="+$(element).attr("title")+"] .checkboxes' />"},
            //{ title:"主键ID",data: "sid",orderable:true},
            { title:"序号",data: "sid",orderable:true},
            {title: "信息标题",data: "xxbt",orderable:true},
            {title: "信息内容",data: "xxnr",orderable:true},
            {title: "保存时间",data: "bcsj",orderable:true}
            // {title:"操作",data:"sid",orderable:false}
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
 * 打开用户新增页面
 */
function add(){
    $(".jhtml-tabs").tabs("add",{
        text: "新增生产过程跟踪",
        url: path+"/webview/farm_ycjk_scgc/add.jsp",
        flush:true,
        close: true
    });
}

/**
 * 打开用户修改页面
 */
function toUpdate(params){
    $(".jhtml-tabs").tabs("add",{
        text: "修改生产过程跟踪",
        url: path+"/webview/farm_ycjk_scgc/update.jsp?sid="+params.sid,
        flush:true,
        close: true
    });
}

/**
 * 保存用户页面
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
                        var datagrid = $("table[title=新增生产过程跟踪表单]").datagrid();
                        datagrid.api().ajax.reload();
                    }
                }
            });
            $(".jhtml-tabs").tabs("add",{
                text: "信息发布",
                url: path+"/webview/farm_ycjk_scgc/scgc.jsp",
                flush:true,
                close: true
            });
        },
        error:function(data){
            $.message.alert({message:data.message});
        }
    });
}

function save1(element){
    $(element).ajaxSubmit({
        beforeSubmit: function(arr, $form, options) {
            return $(element).validation("validate");
        },
        success:function(data){
            $.message.alert({
                message:data.message,
                callback:function(){
                    if(data.success){
                        var datagrid = $("table[title=修改信息发布操作表单]").datagrid();
                        datagrid.api().ajax.reload();
                    }
                }
            });
            $(".jhtml-tabs").tabs("add",{
                text: "信息发布",
                url: path+"/webview/farm_ycjk_scgc/scgc.jsp",
                flush:true,
                close: true
            });
        },
        error:function(data){
            $.message.alert({message:data.message});
        }
    });
}
/**
 * 根据ID删除用户
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
                    url: path+"/farm_ycjk_scgc/delete",
                    data:"[{\"sid\":\""+sid+"\"}]",
                    success: function(data) {
                        $.message.alert({
                            message:data.message,
                            callback:function(){
                                if(data.success){
                                    var datagrid = $('table[title=设备管理列表]').datagrid();
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
 * 批量删除大棚实时监控
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
                url: path+"/farm_ycjk_scgc/delete",
                data:json,
                success: function(data) {
                    $.message.alert({
                        message:data.message,
                        callback:function(){
                            if(data.success){
                                var datagrid = $('table[title=大棚实时监控列表]').datagrid();
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
 *  查询角色
 */
function loadRole(element,params){
    $.ajax({
        type: "POST",
        dataType:"json",
        url: path+"/farm_ycjk_scgc/find",
        success: function(data) {
            $(element).empty();
            for(var i=0;i<data.rows.length;i++){
                $(element).append("<option value='"+data.rows[i].sid+"'>"+data.rows[i].name+"</option>");
            }
        },
        error: function(data){
            $.message.alert(data.message);
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

