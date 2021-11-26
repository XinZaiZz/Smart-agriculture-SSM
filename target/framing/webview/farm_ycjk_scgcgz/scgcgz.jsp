<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: youxin
  Date: 2021/7/11
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${ctx}/resources/css/scgcgz.css" type="text/css">
</head>
<body>
<div class="div">
    <div class="top"></div><br />

    <%--<div class="div__bottom_item" id="div__bottom_item">--%>
    <div class="bottom" id="bottom">
        <%--<div class="left">
            <div class="icon1"></div>
            &lt;%&ndash;<div class="icon2"></div>
            <div class="icon3"></div>
            <div class="icon4"></div>
            <div class="icon5"></div>
            <div class="icon6"></div>&ndash;%&gt;
        </div>
        <div class="right" >
            <div class="items" >
                <div class="iconContent1"></div>
                <div class="content">
                    <p class="time">2021-7-11</p>
                    <p>播种   测试2</p>
                    <p>操作员   [系统管理员]</p>
                </div>
            </div>
            &lt;%&ndash;<div class="items">
                <div class="iconContent2"></div>
                <div class="content">
                    <p class="time">2021-7-11</p>
                    <p>播种   测试2</p>
                    <p>操作员   [系统管理员]</p>
                </div>
            </div>
            <div class="items">
                <div class="iconContent3"></div>
                <div class="content">
                    <p class="time">2021-7-11</p>
                    <p>播种   测试2</p>
                    <p>操作员   [系统管理员]</p>
                </div>
            </div>
            <div class="items">
                <div class="iconContent4"></div>
                <div class="content">
                    <p class="time">2021-7-11</p>
                    <p>播种   测试2</p>
                    <p>操作员   [系统管理员]</p>
                </div>
            </div>
            <div class="items">
                <div class="iconContent5"></div>
                <div class="content">
                    <p class="time">2021-7-11</p>
                    <p>播种   测试2</p>
                    <p>操作员   [系统管理员]</p>
                </div>
            </div>
            <div class="items">
                <div class="iconContent6"></div>
                <div class="content">
                    <p class="time">2021-7-11</p>
                    <p>播种   测试2</p>
                    <p>操作员   [系统管理员]</p>
                </div>
            </div>&ndash;%&gt;
        </div>--%>
    </div>
    <%--</div>--%>
</div>

</body>
<script type="text/javascript">

    var scgc_scgcms ;
    var scgc_bzxx;
    var scgc_czsj;
    var scgc_czry;
    <c:forEach var="item" items="${scgc_list}">
        var i = 1;
        scgc_scgcms = '${item.scgcms}';
        scgc_bzxx = '${item.bzxx}';
        scgc_czsj = '${item.czsj}';
        scgc_czry = '${item.czry}';
        // console.log(scgc_scgcms,scgc_bzxx,scgc_czsj,scgc_czry);
        // var e = document.getElementById("bottom");
        var div1 = document.createElement("div");
        div1.className = "bottom";
        div1.id = "bottom" ;
        div1.innerHTML = "<div class='left'><div class='icon1'>" +
            "</div></div><div class='right'>" +
            "<div class='items'><div class='iconContent1'></div>" +
            "<div class='content'>"+"<p class='time'>"+scgc_czsj+"</p>" +
            "<p>"+scgc_scgcms+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+scgc_bzxx+"</p>" +
            "<p>"+scgc_czry+"</p>"+"</div></div></div></div>"
        // e.innerHTML = div1.innerHTML;
        document.getElementById("bottom").appendChild(div1);
        div1.id = "bottom" +i;
        // console.log(document.getElementById("bottom"));
        i++;
    </c:forEach>

    <%--var list = '${scgc_list}';--%>
    <%--console.log(list)--%>
</script>
</html>


