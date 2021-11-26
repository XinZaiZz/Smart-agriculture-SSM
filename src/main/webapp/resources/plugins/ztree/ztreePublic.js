
/**
 * 生成多选下拉树Ztree，位置<input id="tg+'Id'" />处生成。
 * 并且datas数据的key放在<input id="tg+'Id'" />,显示值value放在<input id="tg+'Name'" />
 * 
 * @param tg 目标名(规则名),共同前缀，
 * @param datas 数据源
 * @param wid 显示框的宽度
 * @param hei 显示框的高度
 */
function initCheckBoxTree(tg,datas,wid,hei){
		initDIV(tg,wid,hei);
	var setting = {
			check: {
				enable: true,
				chkboxType: {"Y":"", "N":""}
			},
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick,
				onCheck: function(e, treeId, treeNode) {
					//初始化定义变量：cId选中节点id、cName选中节点名称
					var  cId = "" , cName = "" ;
					var zTree = $.fn.zTree.getZTreeObj(treeId);
					nodes = zTree.getCheckedNodes(true);
					for (var i=0; i<nodes.length; i++) {
						cName += nodes[i].name + ",";
						cId += nodes[i].id + ",";
					}
					if (cId.length > 0) cId = cId.substring(0, cId.length-1);
					if (cName.length > 0) cName = cName.substring(0, cName.length-1);
					$("#"+ tg +"Id").val(cId);
					$("#"+ tg +"Name").val(cName);
				}
			}
	};
	var zTree = $.fn.zTree.init($("#"+ tg +"Tree"), setting,datas);
	showMenuTree(tg +"Name", tg +"Content", function(event) {
		checkMenuTree(tg +"Name", tg +"Content", event);
	});
	defaultSelect(tg +"Tree", tg +"Id");
	checkDefaultNode(tg +"Tree", tg +"Id",true);//在树中选中用户选择的节点
	
	//return zTree;
}



/**
 * 生成单选下拉树Ztree，位置<input id="tg+'Id'" />处生成。
 * 并且datas数据的key放在<input id="tg+'Id'" />,显示值value放在<input id="tg+'Name'" />
 * 
 * @param tg 目标名(规则名),共同前缀，
 * @param datas 数据源
 * @param wid 显示框的宽度
 * @param hei 显示框的高度
 */
function initZtree(tg,datas,wid,hei){
		initDIV(tg,wid,hei);
	var setting = {
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		view : {
			dblClickExpand : false
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onClick : onClick,
			onCheck:function(e, treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj(treeId);
				nodes = zTree.getCheckedNodes(true);
				if (nodes.length != 0) {
					$("#"+ tg +"Id").val(nodes[0].id);
					$("#"+ tg +"Name").val(nodes[0].name);
				} else {
					$("#"+ tg +"Id").val("");
					$("#"+ tg +"Name").val("");
				}
			}
		}
	};
	$.fn.zTree.init($("#"+ tg +"Tree"), setting,datas);
	showMenuTree(tg +"Name", tg +"Content", function(event) {
		checkMenuTree(tg +"Name", tg +"Content", event);
	});
	defaultSelect(tg +"Tree", tg +"Id");

	//return zTree;
}


/**
 * 在body中追加Ztree要用的DIV
 * @param tg 目标名(规则名)
 * @param wid 宽度
 * @param hei 高度
 */
function initDIV(tg,wid,hei){
	//如果不存在显示框DIV，则创建
	if($(tg+"Content").length==0){
		$("body").append("<div id=\""+ tg +"Content\" class=\"menuContent\""+
			"style=\"display: none;overflow-y:auto;overflow-x:auto; z-index:99;position: absolute;width: " + wid + "px; height: "+ hei +"px;\">"+
			"<ul id=\""+ tg +"Tree\" class=\"ztree\"></ul>"+
		"</div>");
	}
}

function onClick(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj(treeId);
	zTree.checkNode(treeNode, !treeNode.checked, null, true);
	return false;
}

/**
 * clickId,treeSelDivId){
 * @param targetId
 * @param contentId
 * @param onBodyDown
 */
function showMenuTree(targetId, contentId, onBodyDown) {
	var offset,h;
	var treeDiv = $("#"+contentId);
	var onBodyDown = function(event){//定义绑定事件event.target.id == "menuBtn" || 
		if (!(event.target.id == targetId || event.target.id == contentId || $(event.target).parents("#"+contentId).length>0)) {
			treeDiv.fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
	};
	$("#"+targetId).bind("click",function(event){
		offset = $(this).offset();
		h = $(this).outerHeight();
		treeDiv.css({"left":offset.left + "px" ,"top":offset.top + h + "px" }).slideDown("fast");
		$("body").bind("mousedown", onBodyDown);
	});
	
	/*var obj = $("#" + targetId);
	var offset = obj.offset();
	$("#" + contentId).css({
		left : offset.left + "px",
		top : offset.top + obj.outerHeight() + "px"
	}).slideDown("fast");

	$("body").bind("mousedown", onBodyDown);*/
}
function hideMenuTree(targetId, contentId) {
	$("#" + contentId).fadeOut("fast");
}
function checkMenuTree(targetId, contentId, event) {
	if (!(event.target.id == "menuBtn" || event.target.id == targetId
			|| event.target.id == contentId || $(event.target).parents(
			"#" + contentId).length > 0)) {
		hideMenuTree(targetId, contentId);
	}
}
function defaultSelect(treeId, valueId) {
	var zTree = $.fn.zTree.getZTreeObj(treeId);
	if (zTree!=null) {
		var node = zTree.getNodeByParam("id", $("#" + valueId).val(),
				null);
		if (node != null) {
			zTree.expandNode(node.getParentNode());
			zTree.checkNode(node, true, null, true);
		}
	}
}

/**
 * 设置树的指定节点为选中状态，并且展开所选节点的全部父节点
 * @param zTree
 * @param nowUpId
 * @param checked Boolean 
 * checked = true 表示勾选节点  checked = false 表示节点取消勾选 省略此参数，则根据对此节点的勾选状态进行 toggle 切换
 * 不影响 treeNode.nochecked = true 的节点。
 */
function checkDefaultNode(treeId,valueId,checked){
	var zTree = $.fn.zTree.getZTreeObj(treeId);
	var nowUpId = $("#" + valueId).val();
	if(/[^(^\s*)|(\s*$)]/.test(nowUpId)){///[^(^\s*)|(\s*$)|0]/
		var arr = nowUpId.split(",");
		for(var i=0;i<arr.length;i++){
			var nowUpNode = zTree.getNodeByParam("id", arr[i]);
			if(nowUpNode!=null){
				zTree.checkNode(nowUpNode, checked, null, true);
				if(nowUpNode.getParentNode()!=null){
					zTree.expandNode(nowUpNode.getParentNode(),true);
				}
			}
		}
	}
}


/**
 * 设置树的指定节点【以及该节点的全部子节点】为不可选状态
 * @param zTree 指定树
 * @param nowId 指定节点
 */
function chkDisabledNode(zTree,nowId){
	if(/[^(^\s*)|(\s*$)]/.test(nowId)){///[^(^\s*)|(\s*$)|0]/
		var nowNode = zTree.getNodeByParam("id", nowId);
		if(nowNode!=null){
			zTree.setChkDisabled(nowNode, true ,false, true);
		}
	}
}

/**
 * 清空树中被选中的全部节点
 * @param treeObj
 */
function clearCheckNodesObj(treeObj){
	 var nodes = treeObj.getCheckedNodes(true);//当前被选中节点的信息
	 if(nodes!=null){
		 for(var i=0;i<nodes.length;i++){
		 	 treeObj.checkNode(nodes[i], false, null, true);//设置该节点的状态为不选中
		 }	  
	 }
}

/**
 * 清空树中被选中的全部节点
 * @param treeObj
 * @param treeId
 */
function clearCheckNodes(treeObj, treeId){
	 if(treeObj==null){
		treeObj = $.fn.zTree.getZTreeObj(treeId); 
	 }
	 clearCheckNodesObj(treeObj);
}



/**
 * 获取数据源
 * @param url 访问地址
 * @returns {String} 数据源
 */
function getDatas(url){
	var data="";
	$.ajax({
		type:"POST",
		url:url,
		async:false,
		data:{
			time:new Date().getTime()
		},
		success:function(result){
			data=result;
		},
		error:function(){
			alert("系统响应异常！");
		},
		dataType:'json'
	});
	return data;
}

/**
 * 获取数据源
 * @param url 访问地址
 * @returns {String} 数据源
 */
function getDatas(url,type1){
	var data="";
	$.ajax({
		type:"POST",
		url:url,
		async:false,
		data:{
			time:new Date().getTime(),
			ut:type1
		},
		success:function(result){
			data=result;
		},
		error:function(){
			alert("系统响应异常！");
		},
		dataType:'json'
	});
	return data;
}

/**
 * 获取数据源
 * @param url 访问地址
 * @param queryParams 查询参数串，
 * 	格式如params.workunitstype=1&params.workunitsstatus=1
 * @returns {String} 数据源
 */
function getJsonDatas(url,queryParams){
	var data="";
	$.ajax({
		type:"POST",
		url:url,
		async:false,
		data: queryParams,
		success:function(result){
			data = result;
		},
		error:function(){
			alert("系统响应异常！");
		},
		dataType:'json'
	});
	return data;
}