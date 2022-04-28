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
    <title>JobProvider Edit</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" />
</head>
<%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);

if(session.getAttribute("jpemail")==null){
	response.sendRedirect("jobproviderlogin.jsp");
}

String status = request.getParameter("status");
String message = "";	
if((status != null)&&status.equals("false")){	  
	 message = "<p ><strong>Oops! Something went wrong</strong></p>";
}

Integer id= (Integer)session.getAttribute("jpid");
JobProviderRepository repo=new JobProviderRepository();
JobProvider jp=repo.findJobProviderById(id);

%>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-2">
            <a class="navbar-brand" href="index.jsp"><b style="font-size: 24px;">Job</b><span style="color:#7279E1;font-size: 24px;font-weight: bold;">Portal</span></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav"><a class="text-light" href="jobproviderhome.jsp" style="margin-right:5px;text-decoration: none;"><b> <span style="margin-top:2px;">JobProvider Home</span></b></a></ul>
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0"><a class="text-light btn btn-danger" href="logout" style="margin-right:5px;text-decoration: none;"><b> <span style="margin-top:2px;">Logout</span></b></a></ul>
            </div>
        </div>
    </nav>
    <header class="py-2" style="background-color:#7279E1">
        <div class="container px-5 ">
            <div class="row gx-5 align-items-center justify-content-center ">
                <div class="col-lg-5 col-xl-6 col-xxl-6 ">
                    <div class="my-5 text-xl-start ">
                        <div class="card shadow " style="border-radius: 25px;background-color:#ece9e9;">
                            <div class="card-body p-4 " style="">
                                <h1 class=" card-title text-center pb-4 h3 "><span style="color:#000000;font-weight: bold; ">JobProvider Edit</span> </h1>
                                <span class="text-dark text-danger"><%=message %></span>
                                <span class="card-text ">
                                    <form action="editprovider" method="POST" id="formsubmit ">
                                        <span id="formerror "></span>
                                <div class="form-group ">
                                    <label for="id"><span class="font-weight-bold ">Profile ID:</span></label>
                                    <input required type="number" class="form-control " name="id" id="id" placeholder="Your ID " value="<%=jp.getId()%>" readonly>
                                </div>
                                <div class="form-group ">
                                    <label for="name"><span class="font-weight-bold ">Company Name:</span></label>
                                    <input required type="text " class="form-control " name="name" id="name" value="<%=jp.getName()%>" placeholder="Your Comapany Name ">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="location"><span class="font-weight-bold ">Location:</span></label>
                                    <input required type="text" class="form-control " name="location" id="location" value="<%=jp.getLocation()%>" placeholder="Your Company Location ">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="contact"><span class="font-weight-bold ">Contact Number:</span></label>
                                    <input required type="text" class="form-control " name="contact" id="contact"  value="<%=jp.getContact()%>" pattern="[6-9]{1}[0-9]{9}" placeholder="Your Company Contact Number">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="website"><span class="font-weight-bold ">Website:</span></label>
                                    <input required type="text" class="form-control " name="website" id="website" placeholder="Your Company Website " value="<%=jp.getWebsite()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="technology"><span class="font-weight-bold ">Technology:</span></label>
                                    <input required type="text" class="form-control " name="technology" id="technology" placeholder="Your Company Technology " value="<%=jp.getTechnology()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="email"><span class="font-weight-bold ">Email ID:</span></label>
                                    <input required type="email" class="form-control " name="email" id="email" value="<%=jp.getEmail()%>" placeholder="Your Email Address ">
                                </div>
                                <div class="form-group mt-3">
                                    <input required type="password" class="form-control " name="pass" id="pass" value="<%=jp.getPassword() %>" placeholder="Password " hidden>
                                </div>
                                <center><button type="submit" class="btn btn-dark mt-2 font-weight-bold">Update JobProvider</button></center>
                                </form>
                                <div class="mt-3 text-center"><a href="viewjobproviderprofile.jsp">View JobProvider</a> 👉</div>
                                </span><br>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- <div class="col-xl-5 col-xxl-6 d-xl-block text-center "><img class="img-fluid rounded-3 " src="https://i.postimg.cc/Xv20WcYJ/image.png " alt="image " /></div> -->
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