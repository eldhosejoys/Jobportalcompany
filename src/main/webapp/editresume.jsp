<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.jobportal.entities.Resume"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jobportal.repos.ResumeRepository"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>JobSeeker Edit Resume</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" />
</head>
<%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);

if(session.getAttribute("jsemail")==null){
	response.sendRedirect("jobseekerlogin.jsp");
}

String status = request.getParameter("status");
String message = "";	

if((status != null)&&status.equals("false")){	  
	 message = "<p ><strong>Oops! Something went wrong</strong></p>";
}

Integer id= (Integer)session.getAttribute("jsid");
ResumeRepository repo=new ResumeRepository();
Resume rs=repo.findResumeByjsid(id);
%>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-2">
            <a class="navbar-brand" href="index.jsp"><b style="font-size: 24px;">Job</b><span style="color:#7279E1;font-size: 24px;font-weight: bold;">Portal</span></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav"><a class="text-light" href="jobseekerhome.jsp" style="margin-right:5px;text-decoration: none;"><b> <span style="margin-top:2px;">JobSeeker Home</span></b></a></ul>
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
                                <h1 class=" card-title text-center pb-4 h3 "><span style="color:#000000;font-weight: bold; ">JobSeeker Edit Resume</span> </h1>
                                <span class="text-danger text-center"><%=message %></span>
                                <span class="card-text ">
                                <form action="editresume" method="POST" id="formsubmit">
                                    <span id="formerror "></span>
                                <div class="form-group ">
                                    <label for="id"><span class="font-weight-bold ">Resume ID:</span></label>
                                    <input readonly required type="number" class="form-control " name="id" id="id" placeholder="Your id" value="<%=rs.getId()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="stream"><span class="font-weight-bold ">Stream:</span></label>
                                    <input required type="text" class="form-control " name="stream" id="stream" placeholder="Your Stream " value="<%=rs.getStream()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="college"><span class="font-weight-bold ">College:</span></label>
                                    <input required type="text" class="form-control " name="college" id="college" placeholder="Your College " value="<%=rs.getCollege()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="experience"><span class="font-weight-bold ">Experience:</span></label>
                                    <input required type="number" class="form-control " name="experience" id="experience" placeholder="Your experience "  min="0" max="30" value="<%=rs.getExperience()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="languageknown"><span class="font-weight-bold ">Languages known:</span></label>
                                    <input required type="text" class="form-control " name="language" id="languageknown" placeholder="languages known " value="<%=rs.getLanguageknown()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="cgpa"><span class="font-weight-bold ">Cgpa:</span></label>
                                    <input required type="number" class="form-control " name="cgpa" id="cgpa"  min="0" max="100" placeholder="Your cgpa" value="<%=rs.getCgpa()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="projects"><span class="font-weight-bold ">Projects:</span></label>
                                    <input required type="text" class="form-control " name="project" id="projects" placeholder="Your projects" value="<%=rs.getProjects()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="yop"><span class="font-weight-bold ">YOP:</span></label>
                                    <input required type="number" class="form-control " name="yop" id="yop" placeholder="Your yop" value="<%=rs.getYop()%>">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="skills"><span class="font-weight-bold ">Skills:</span></label>
                                    <input required type="text" class="form-control " name="skill" id="skills" placeholder="Your skills" value="<%=rs.getSkills()%>">
                                </div>
                                <center><button type="submit " class="btn btn-dark mt-4 font-weight-bold">Update Resume</button></center>
                                </form>
                                <div class="mt-3 text-center"><a href="viewresume.jsp">View Resume</a> 👉</div>
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