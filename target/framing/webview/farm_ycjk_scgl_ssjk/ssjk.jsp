<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<style type="text/css">
    .div1{
        width: 100%;
        height: 400px;
        border-style:solid;
        border-width: 0px 0px 3px 0px;
        border-bottom-color: #12AFDB;
        background-color: #D3EEE3;
    }
    .img1{
        line-height: 50px;
        text-align: center;
        width: 144px;
        height: 38px;
        background-image: url(${ctx}/resources/images/scgl_ssjk/d011.png);
        position: relative;top: 27%;left: 20%;

    }
    .img2{
        line-height: 50px;
        text-align: center;
        width: 144px;
        height: 38px;
        background-image: url(${ctx}/resources/images/scgl_ssjk//d012.png);
        position: relative;top: 32%;left: 20%;
    }
    .img3{
        line-height: 50px;
        text-align: center;
        width: 144px;
        height: 38px;
        background-image: url(${ctx}/resources/images/scgl_ssjk//d013.png);
        position: relative;top: 37%;left: 20%;
    }
    .col1{
        width: 400px;
        height: 27.3px;
        background-color: #E44F2F;
        position: relative;top: 17.5%;left: 27.3%;
    }
    .col2{
        width: 600px;
        height: 27.3px;
        background-color: #81B6B2;
        position: relative;top: 22.4%;left: 27.3%;
    }
    .col3{
        width: 750px;
        height: 27.3px;
        background-color: #EBA422;
        position: relative;top: 27.3%;left: 27.3%;
    }
    .text1{
        width: 100px;
        height: 27px;
        position: relative;top:11%;left: 52%;
    }
    .text2{
        width: 100px;
        height: 27px;
        position: relative;top:16%;left: 64%;
    }
    .text3{
        width: 100px;
        height: 27px;
        position: relative;top:21%;left: 73%;
    }
</style>
<body>
<div class="div1">
    <div class="img1">空气温度</div>
    <div class="col1"></div>
    <div class="text1">28.6℃</div>
    <div class="img2">空气湿度</div>
    <div class="col2"></div>
    <div class="text2">0.8%</div>
    <div class="img3">二氧化碳浓度</div>
    <div class="col3"></div>
    <div class="text3">0.2PPM</div>
</div>
</body>
</html>
