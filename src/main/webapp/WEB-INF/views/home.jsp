<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script src="<%=application.getContextPath()%>/resources/js/app.js"></script>
	<script src="<%=application.getContextPath()%>/resources/js/router.js"></script>
	<style>
	body {background-image : url('http://blacktandt.cafe24.com/web/upload/thumnail/1301025th.jpg');
		  background-repeat : no-repeat;
		  background-size : cover;}
		  .grid_item {width: 100px;height: 100px;display: inline-block;}
	</style>
</head>
<body>
<div id="war"></div>
	<script>
	app.run("<%=application.getContextPath()%>")
	</script>
</body>
</html>