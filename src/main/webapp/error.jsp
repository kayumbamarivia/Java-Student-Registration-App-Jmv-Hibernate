<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error</title>
<style>
body {
	text-align: center;
}

h1 {
	color: #4CAF50;
}

h2 {
	color: #333;
}
</style>
</head>
<body>
	<h1>Error</h1>
	<h2><%=exception.getMessage()%><br />
	</h2>
</body>
</html>
