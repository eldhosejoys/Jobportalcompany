<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.jobportal.entities.Resume"%>
<%@page import="java.util.List"%>
<%@page import="com.jobportal.repos.ResumeRepository"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Integer id=(Integer)session.getAttribute("jsid");
	ResumeRepository repo=new ResumeRepository();
	Resume jp=repo.findResumeByjsid(id);
%>
 <form>
 id:
<input type="text"  name="name" value="<%=jp.getId() %>" readonly="readonly"><br><br>

stream:
<input type="text"  name="name" value="<%=jp.getStream() %>" readonly="readonly"><br><br>

college:
<input type="text"  name="name" value="<%=jp.getCollege()%>" readonly="readonly"><br><br>

experience:
<input type="text"  name="name" value="<%=jp.getExperience() %>" readonly="readonly"><br><br>

language known:
<input type="text"  name="name" value="<%=jp.getLanguageknown() %>" readonly="readonly"><br><br>

cgpa:
<input type="text"  name="name" value="<%=jp.getCgpa()%>" readonly="readonly"><br><br>

projects:
<input type="text"  name="name" value="<%=jp.getProjects()%>" readonly="readonly"><br><br>


</form>
<a href="jobseekerhome.jsp">go home</a>
</body>
</html>