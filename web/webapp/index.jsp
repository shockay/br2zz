<%@page import="java.text.SimpleDateFormat,java.util.Date,java.text.ParseException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%
				String endTime = "2017-08-28 21:30:00";
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        boolean toShowQiYi = false;
		        try{
		            toShowQiYi = new Date().before(sdf.parse(endTime));
		        }catch (ParseException e){
		            e.printStackTrace();
		        }
		        request.setAttribute("toShowQiYi",toShowQiYi);
			%>
      
 <c:if test="${not empty toShowQiYi && toShowQiYi}">
    <!-- 七夕活动 dbr 2017.08.17 start -->
    <div class="my-article banner-box">
      <img src="${static_base}/images/blank.gif?${version_image}" data-image='{
          "standard":{"high":"", "normal":"${static_base}/images/index/img-b-banner.jpg?${version_image}"}
          ,"medium":{"high":"", "normal":"${static_base}/images/index/img-b-banner.jpg?${version_image}"}
          ,"small":{"high":"", "normal":"${static_base}/images/index/img-m-banner.jpg?${version_image}"}
        }' />
      <a class="img-link none-xs" href="javascript:;" data-show-modal=".vtModal" >
        <img src="${static_base}/images/blank.gif?${version_image}"/></a>
      <a class="img-link none block-xs gift_selection" href="javascript:void(0);"><img src="${static_base}/images/blank.gif?${version_image}"/></a>
      <div class="link-box">
        <a href="https://www.michaelkors.cn/trend/QIXI"><span>为 TA 选购节日礼品甄选</span><i class="i-black"></i></a>
      </div>
    </div>
    <!-- 七夕活动 dbr 2017.08.17 end -->
  </c:if>     
      
 
 
 
      
      
      
      
      
      
