<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jobportal.entities.JobSeeker"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jobportal.repos.JobSeekerRepository"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>View JobSeekers</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" />
</head>
<% 
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);

if(session.getAttribute("adminname")==null){
	response.sendRedirect("adminLogin.jsp");
}
		
		JobSeekerRepository repo = new JobSeekerRepository();
		ArrayList<JobSeeker> seekerlist = repo.listJS();
		JobSeeker js = null;
%>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-2">
        <a class="navbar-brand" href="index.jsp"><b style="font-size: 24px;">Job</b><span style="color:#7279E1;font-size: 24px;font-weight: bold;">Portal</span></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav"><a class="text-light" href="adminhome.jsp" style="margin-right:5px;text-decoration: none;"><b> <span style="margin-top:2px;">Admin Home</span></b></a></ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0"><a class="text-light btn btn-danger" href="logout" style="margin-right:5px;text-decoration: none;"><b> <span style="margin-top:2px;">Logout</span></b></a></ul>
        </div>
    </div>
</nav>
<header class="py-2" style="background-color:#7279E1">
    <div class="container px-5 ">
        <div class="row gx-5 align-items-center justify-content-center ">
            <div class="col-12">
                <h1 class="text-center">View All Jobs available</h1>
                <div class="my-5 text-center text-xl-start">
                    <table class="table table-light table-stripped">
                        <thead>
                            <tr>
                            <th>#ID</th>
				            <th>Name</th>
				            <th>Age</th>
				            <th>Contact</th>
				            <th>DOB</th>
				            <th>email</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                        for(int i = 0; i < seekerlist.size(); i++)
                    
                    {
                        js = seekerlist.get(i);
                        
                        int rno = js.getId();
                        String name = js.getName();
                        int age = js.getAge();
                        String contact=js.getContact();
                        String dob=js.getDob();
                        String email=js.getEmail();
                        %>
                            <tr>
                            <td><%=rno%> </td>
                            <td><%=name%></td>
                            <td><%=age%> </td>
                            <td> <%=contact%> </td>
                            <td><%=dob%></td>
                            <td> <%=email%> </td>
        
            
        </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-xl-5 col-xxl-6 d-xl-block text-center "><img class="img-fluid rounded-3 " src="https://i.postimg.cc/Xv20WcYJ/image.png " alt="image " /></div>
        </div>
    </div>
</header>

<footer class="bg-dark py-4 mt-auto ">
    <div class="container px-5 ">
        <div class="row align-items-center justify-content-between flex-column flex-sm-row ">
            <div class="col-auto ">
                <div class="small m-0 text-white ">All Rights Reserved | Job Portal</div>
            </div>
            <div class="col-auto ">

            </div>
        </div>
    </div>
</footer>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</body>

</html>