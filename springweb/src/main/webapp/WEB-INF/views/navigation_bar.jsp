<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Basic Accordion - jQuery EasyUI Demo</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/easyui/themes/default/easyui.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/easyui/themes/icon.css'/>">
<script type="text/javascript" src="<spring:url value="/resources/easyui/jquery.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/easyui/jquery.easyui.min.js"/>"></script>
<title>Insert title here</title>
</head>
<body>
    <div class="easyui-accordion" style="width:200px;height:300px;">
        <!-- <div title="About" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
            <h3 style="color:#0099FF;">Accordion for jQuery</h3>
            <p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p>
        </div>
        <div title="Help" data-options="iconCls:'icon-help'" style="padding:10px;">
            <p>The accordion allows you to provide multiple panels and display one or more at a time. Each panel has built-in support for expanding and collapsing. Clicking on a panel header to expand or collapse that panel body. The panel content can be loaded via ajax by specifying a 'href' property. Users can define a panel to be selected. If it is not specified, then the first panel is taken by default.</p>         
        </div> -->
        
<%--         <c:forEach items="${menu}" var="modul"> <c:out value="${modul.modulName}"/>--%>
        	<div title="Title" data-options="iconCls:'icon-search'" style="padding:10px;">
            <ul class="easyui-tree">
                <li>
                    <span>Foods</span>
                    <ul>
                        
                        <li>
                            <span>Vegetables</span>
                            <ul>
                                <li>tomato</li>
                                <li>carrot</li>
                                <li>cabbage</li>
                                <li>potato</li>
                                <li>lettuce</li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
<%--         </c:forEach> --%>
    </div>
</body>
</html>