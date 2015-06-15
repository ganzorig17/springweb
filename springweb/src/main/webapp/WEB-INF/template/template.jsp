<%-- <%@ include file="/WEB-INF/template/includes.jsp"%> --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta name="google-site-verification" content="xxxxxxxxx" />
<!-- 		<title><tiles:insertAttribute name="title" ignore="true" /></title> -->
<%-- 		<meta name="description" content="<tiles:insertAttribute name="page_description" ignore="true"/>"> --%>
<!-- 		<c:url var="cssURL" value="/static/css/style.min.css" /> -->
<%-- 		<link href="${cssURL}" rel="stylesheet" type="text/css" /> --%>
<%-- 		<link rel="icon" href="<c:url value="/static/images/favicon.ico"/>" type="image/x-icon" /> --%>
<%-- 		<link rel="shortcut icon" href="<c:url value="/static/images/favicon.ico"/>" type="image/x-icon" /> --%>
<!-- 		<meta charset="utf-8"> -->
<%-- 		<meta property="og:image" content="<tiles:insertAttribute name="og_image" ignore="true"/>" /> --%>
<%-- 		<meta property="og:title" content="<tiles:insertAttribute name="og_title" ignore="true"/>" /> --%>
<%-- 		<meta property="og:description" content="<tiles:insertAttribute name="og_desc" ignore="true"/>" /> --%>
<%-- 		<link rel="stylesheet" href="<tiles:insertAttribute name="jquery_ui_css" ignore="true"/>" /> --%>
</head>
<body>
	<div id="wrapper">
		<header>
			<tiles:insertAttribute name="header" />
		</header>
		<div class="Row">
			<div class="Cell" id="menu">
				<tiles:insertAttribute name="navigation_bar" />
			</div>
			<div class="Cell" id="page">
				<tiles:insertAttribute name="content" />
			</div>
		</div>
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>

<style type="text/css">
.Table {
	display: table;
}

.Title {
	display: table-caption;
	text-align: center;
	font-weight: bold;
	font-size: larger;
}

.Heading {
	display: table-row;
	font-weight: bold;
	text-align: center;
}

.Row {
	display: table-row;
}

.Cell {
	display: table-cell;
	border: solid;
	border-width: thin;
	padding-left: 5px;
	padding-right: 5px;
}

html, body {
	min-height: 100%;
	padding: 0;
	margin: 0;
}

#wrapper {
	padding: 50px 0;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
}

#content {
	min-height: 100%;
	background-color: green;
}

header {
	margin-top: -50px;
	height: 50px;
	background-color: #E0ECFF;
}

footer {
	margin-bottom: -50px;
	height: 50px;
	background-color: #E0ECFF;
}

p {
	margin: 0;
	padding: 0 0 1em 0;
}
</style>
</html>