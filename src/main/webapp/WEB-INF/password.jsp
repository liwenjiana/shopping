<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="Stylesheet"/>
    <link href="../css/header.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
    <style type="text/css">
     .msg_error{background:#f00 ; color:#fff;margin-left: 5px}
     .msg_ok{background:#0f0; margin-left:: 5px; color:#fff}
    </style>
</head>
<body>
<!-- 顶部 -->
<c:import url="../main/header.do"></c:import>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
<!-- 左边栏-->
<c:import url="user_left.jsp"></c:import>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="profile.do">我的信息</a></span>
            <span class="rs_header_active"><a href="password.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span><input  id="old_password" type="password"/><span id="old_password_hint" class="change_hint"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span><input id="new_password" type="password"/><span id="new_password_hint"  class="change_hint"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span><input  id="comfirm_password"  type="password"/><span   id="comfirm_password_hint" class="confirm_hint"></span>
            </div>
            <div class="save_password"  onclick="tijiao()">
                保存更改
            </div>
             <div >
                     <span id="tishi" style="background:red;color:#fff"></span>
            </div>
        </div>


    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="../images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>

</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script type="text/javascript">

function tijiao(){
	if($("#old_password_hint").hasClass("msg_ok")&&$("#new_password_hint").hasClass("msg_ok")&&$("#comfirm_password_hint").hasClass("msg_ok")){	
		alert("111")
		$.ajax({
			"url":"handlePassword.do",
			"data":"oldPassword="+$("#old_password").val()+"&newPassword="+$("#new_password").val(),
			"type":"post",
			"dataType":"json",
			"success":function(obj){
				if(obj.state==1){
					console.log($("#new_password").val());
					alert("修改成功");
					$("#old_password_hint").html("");
					$("#new_password_hint").html("");
					$("#comfirm_password_hint").html("");
					$("#old_password").val("");
					$("#new_password").val("");
					$("#comfirm_password").val("");
				}else{
					alert("什么鬼")
					$("#tishi").html(obj.mesage);
				}
			},
			"error":function(){
				alert("登录过时，请重新登录");
				location.href="login.do";
			}
		});
	}
}
       //1.验证3个密码的长度
  //验证旧密码是否正确
  function doPassword(){
	  $.ajax({
			 "url":"checkPassword.do",
			 "data":"oldPassword="+$("#old_password").val(),
			 "type":"get",
			 "dataType":"json",
			 "success":function(obj){
				 var css=obj.state==1?"msg_ok":"msg_error";
				 $("#old_password_hint").html(obj.message);
				 $("#old_password_hint").attr("class",css);
			 }
		 });
       }
 
  function checkpassword(){
	 var npwd= $("#new_password").val();
	 var cpwd=$("#comfirm_password").val();
	 if(npwd==cpwd){
		  $("#comfirm_password_hint").html("密码一致");
		  $("#comfirm_password_hint").attr("class","msg_ok");
	 }else{
		 $("#comfirm_password_hint").html("密码不一致");
		  $("#comfirm_password_hint").attr("class","msg_error");
	 }
       }
       $("#old_password").blur(function(){
    	   var pwd=$("#old_password").val();
    	   if(pwd.length<6){
    		   $("#old_password_hint").html("密码不能少于6为");
    		   $("#old_password_hint").attr("class","msg_error");
    	   }else{
    		   $("#old_password_hint").html("密码格式正确");
    		   $("#old_password_hint").attr("class","msg_ok");
    		   doPassword();
    	   }
       });
       $("#new_password").blur(function(){
    	   var pwd=$("#new_password").val();
    	   if(pwd.length<6){
    		   $("#new_password_hint").html("密码不能少于6为");
    		   $("#new_password_hint").attr("class","msg_error");
    	   }else{
    		   $("#new_password_hint").html("密码格式正确");
    		   $("#new_password_hint").attr("class","msg_ok");
    		   checkpassword();
    	   }
       });
       $("#comfirm_password").blur(function(){
    	   var pwd=$("#comfirm_password").val();
    	   if(pwd.length<6){
    		   $("#comfirm_password_hint").html("密码不能少于6为");
    		   $("#comfirm_password_hint").attr("class","msg_error");
    	   }else{
    		   $("#comfirm_password_hint").html("密码格式正确");
    		   $("#comfirm_password_hint").attr("class","msg_ok");
    		   checkpassword();
    	   }
       });
</script>

</html>