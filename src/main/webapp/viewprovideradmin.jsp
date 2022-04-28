<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.jobportal.entities.JobProvider"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jobportal.repos.JobProviderRepository"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>View JobProviders</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" />
</head>
		<% 
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setDateHeader("Expires", -1);

		if(session.getAttribute("adminname")==null){
			response.sendRedirect("adminLogin.jsp");
		}
		
		JobProviderRepository repo = new JobProviderRepository();
		ArrayList<JobProvider> providerlist = repo.listJP();
		JobProvider jp = null;
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
                        <h1 class="text-center">View All JobProviders</h1>
                        <div class="my-5 text-center text-xl-start">
                            <table class="table table-light table-stripped">
                                <thead>
                                    <tr>
                                    <th>#ID</th>
                                    <th>Name</th>
                                    <th>location</th>
                                    <th>Contact</th>
                                    <th>website</th>
                                    <th>email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                for(int i = 0; i < providerlist.size(); i++)
                                {
                                    jp = providerlist.get(i);
                                    
                                    int rno = jp.getId();
                                    String name = jp.getName();
                                    String location = jp.getLocation();
                                    String contact=jp.getContact();
                                    String website=jp.getWebsite();
                                    String email=jp.getEmail();
                                    %>
                                    <tr>
				<td><%=rno%> </td>
					<td><%=name%></td>
					<td><%=location%> </td>
					<td> <%=contact%> </td>
					<td><%=website%></td>
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