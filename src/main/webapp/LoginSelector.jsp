<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%

	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

%>
<form>
<h3>Welcome</h3><br>
<a href="jobseekerlogin.jsp">
<button type="button"><strong>JobSeeker </strong></button>
 </a><br><br>
 <a href="jobproviderlogin.jsp">
 <button type="button"><strong>JobProvider</strong></button>
 </a><br><br>
</form>
</body>
</html>