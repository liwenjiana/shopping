<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
    <link href="../css/my_new.css" rel="stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
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
    <div class="rightsidebar_box rt">	
        <!--标题栏-->
        <div class="rs_header">
            <span class="address_title">收获地址管理</span>
        </div>
        <!--收货人信息填写栏-->
        <div class="rs_content">
        
            <!--已有地址栏-->
            <div class="address_information_manage">
                <div class="aim_title">
                    <span class="dzmc dzmc_title">地址名称</span><span class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span class="lxdh lxdh_title">联系电话</span><span class="operation operation_title">操作</span>
                </div>
                <c:forEach items="${list }" var="address" >
                
                <div class="aim_content_one aim_active">
                    <span class="dzmc dzmc_active${address.isDefault }">${address.recvTag }</span>
                    <span class="dzxm dzxm_normal">${address.recvName }</span>
                    <span class="dzxq dzxq_normal">${address.recvDistrict}${address.recvAddr }</span>
                    <span class="lxdh lxdh_normal">${address.recvTel }</span>
                    <span class="operation operation_normal">
                    	<span class="aco_change" onclick="showPopup(${ address.id})">修改</span>|
                    	<a class="aco_delete" href="delAddress2.do?id=${ address.id}&uid=${address.uid}" onclick="return confirm('确定删除该地址？')">删除</a>
                    </span>
                    <a class="swmr swmr_normal"  href="setDefualt.do?id=${address.id}">
                          ${address.isDefault==0?"设为默认":"" }
                    </a>
                </div>
                </c:forEach>
      
            </div>
        </div>
        <div style="margin-left: 20px;margin-top: 10px;">
		         <a href="#" class="button-blue"onclick="showPopup(0)" >新增收货地址</a>
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
	<div id="popup_content">	  
	 <div class="rs_content">
	  	<form id="addressForm">
	  	         <h3 id="h3title"></h3>
	  	         <!--隐藏的addressID  -->
	  	          <input type="hidden"    id="id"  name="id">
	            <!--收货人姓名-->
	            <div class="recipients">
	                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="recvName" id="receiverName"/>
	            </div>
	            <!--收货人所在城市等信息-->
	            <div data-toggle="distpicker" class="address_content">
					 <span class="red">*</span>
					 <span class="kuan" style="width:70px">省&nbsp;&nbsp;份：</span>
					             <select id="provinces" name="recvProvince"  style="width:94px" onchange="changeCities(1)"></select>
					  城市：<select id="cities" name="recvCity" style="width:94px" onchange="changeAreas(1)"></select>
					  区/县：<select  id="areas" name="recvArea" style="width:94px"></select>
				</div> 
	            
	            
	            <!--收货人详细地址-->
	            <div class="address_particular">
	                <span class="red">*</span><span class="kuan">详细地址：</span><textarea name="recvAddr" id="receiverAddress" cols="60" rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
	            </div>
	            <!--收货人地址-->
	            <div class="address_tel">
	                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" id="receiverMobile" name="recvTel"/>固定电话：<input type="text" name="recvPhone" id="receiverPhone"/>
	            </div>
	            <!--邮政编码-->
	            <div class="address_postcode">
	                <span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp;<input type="text" name="recvZip"  id="recvZip"/>
	            </div>
	            <!--地址名称-->
	            <div class="address_name">
	                <span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp;<input type="text" id="addressName" name="recvTag"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
	            </div>
	            <!-- 拼接省市区 -->
	            <div style="display:none"><input  name="recvDistrict"  id="recv_district"/></div>
	            <!--保存收货人信息-->  
	            <div >
		         <a href="#" class="button-blue" onclick="postForm()">保存收货人信息</a>
	             </div>
	            <div >
		         <a href="#" class="button-blue"onclick="dismissPopup()" >取消</a>
	             </div> 
    		</form>
    		</div>
	</div>

	<div id="mask"></div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
         <!--前端用的js  -->
<!-- <script type="text/javascript" src="../js/distpicker.data.js"></script> -->
<!-- <script type="text/javascript" src="../js/distpicker.js"></script> -->
<script type="text/javascript" src="../js/personal.js"></script>
<script type="text/javascript">
	$(".lxdh_normal").each(function(i,e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
</script>
<script type="text/javascript">
	$(function(){
		$("#leftsidebar_box dd").hide();
	    $("#leftsidebar_box .address dd").show();
	    $("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder2.png");
	    $("#leftsidebar_box .address").find('img').attr("src","../images/myOrder/myOrder1.png");
	})
</script>
<script type="text/javascript">
//===弹出添加地址的窗口===
	function showPopup(id) {
	    $("#id").val(id);
		var tilte=id==0?"新增收货地址":"修改收货地址";
		$("#h3title").html(tilte);
		$("#addressForm")[0].reset();
		var popupWidth = 700;
		var popupHeight = 440;
		var windowWidth = $(window).width();
		var windowHeight = $(document).height();
		$("#mask").css({
			"width": windowWidth,
			"height": windowHeight
		});
		$("#mask").show();
		$("#popup_content").css({
			"width": popupWidth,
			"height": popupHeight,
			"left": (windowWidth - popupWidth) / 2,
			"top": 50
		});
		if(id!=0){
			$.ajax({
				"url":"get.do",
				"data":"id="+id,
				"type":"get",
				"dataType":"json",
				"success":function(obj){
					 $("#receiverName").val(obj.data.recvName);
					 $("#receiverAddress").val(obj.data.recvAddr);
					 $("#receiverMobile").val(obj.data.recvTel);  
					 $("#receiverPhone").val(obj.data.recvPhone);
					 $("#recvZip").val(obj.data.recvZip);
				     $("#addressName").val(obj.data.recvTag);
				     var province=obj.data.recvProvince;
				     var city=obj.data.recvCity;
				     var area=obj.data.recvArea;
				     getProvince(province,city,area);
				    
				}
			});
		}else{
			getProvince(-1,-1,-1);
			
		}
		
		$("#popup_content").show();
	}
    //===隐藏添加地址的窗口====
	function dismissPopup() {
	
		$("#mask").hide();
		
		$("#popup_content").hide();
	}
	//===获取省列表===
    function getProvince(province,city,area){
		$.ajax({
			"url":"../dist/province.do",
			"type":"get",
			"dataType":"json",
			"success":function(obj){
				    var provinces=obj.data;
				    var op=document.createElement("option");
			    	op.value=-1;
			    	op.text="---请选择---";
			    	document.getElementById("provinces").appendChild(op);
				    for(var i=0;i<provinces.length;i++){
				    	var op=document.createElement("option");
				    	op.value=provinces[i].code;
				    	op.text=provinces[i].name;
				    	document.getElementById("provinces").appendChild(op);
				    }
				    $("#provinces").val(province);
				    getCities(city,area);
			}
		});
	}
	
//
  //===获取市列表===
    function getCities(city,area){
	    $("#cities").empty();
	    $("#areas").empty();  
		$.ajax({
			"url":"../dist/cities.do",
			"data":"provinceCode="+$("#provinces").val(),
			"type":"get",
			"dataType":"json",
			"success":function(obj){
				     var provinces=obj.data;
			         if($("#provinces").val()==-1){
						    var op=document.createElement("option");
					    	op.value=-1;
					    	op.text="---请选择--";
					    	document.getElementById("cities").appendChild(op);
			         }    	
				    for(var i=0;i<provinces.length;i++){
				    	var op=document.createElement("option");
				    	op.value=provinces[i].code;
				    	op.text=provinces[i].name;
				    	document.getElementById("cities").appendChild(op);
				    }
				    if($("#provinces").val()==-1){
				    	$("#cities").val(-1);
				    }else{
				    	 $("#cities").val(provinces[0].code);
				    }
				   
				    //获取city后获取area
				    getAreas(area);
			}
		});
		
	}
    //===获取区列表===
    function getAreas(area){
    	$("#areas").empty();
		$.ajax({
			"url":"../dist/areas.do",
			"data":"cityCode="+$("#cities").val(),
			"type":"get",
			"dataType":"json",
			"success":function(obj){
				    var cities=obj.data;
				    if($("#cities").val()==-1){
						var op=document.createElement("option");
					   op.value=-1;
					   op.text="---请选择---";
					   document.getElementById("areas").appendChild(op);
				    }
				    for(var i=0;i<cities.length;i++){
				    	var op=document.createElement("option");
				    	op.value=cities[i].code;
				    	op.text=cities[i].name;
				    	document.getElementById("areas").appendChild(op);
				    }
				    
				    if($("#cities").val()==-1||$("#provinces").val()==-1){
				    	$("#areas").val(-1);
				    }else{
				    	$("#areas").val(cities[0].code);
				    }
			}
		});
	}


    
    //===添加表单数据===
    function postForm(){	
    	var id=$("#id").val();
    	var url=id==0?"../address/add.do":"../address/update.do";
    	var data=$("#addressForm").serialize();
    	$.ajax({
    		"url":url,
    		"data":data,
    		"type":"post",
    		"dataType":"json",
    		"success":function(obj){
    			console.log(obj.state);
    			alert(obj.message);
    			location.href="list.do";
    		}
    	});
    }
//省市区发生改变，选项变化
function changeCities(){
	var area=$("#areas").val();
	var city=$("#cities").val();
	console.log(area);
	console.log(city);
	
	getCities(city,area);
}
function changeAreas(){
	var area=$("#areas").val();
	getAreas(area);
}
	</script>
</html>