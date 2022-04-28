<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.jobportal.entities.Jobs"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jobportal.repos.JobsRepository"%>
    <!DOCTYPE html>
    <html>
    
    <head>
        <meta charset="ISO-8859-1">
        <title>JobPortal</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" />
    </head>
    <%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);

if(session.getAttribute("adminname")!=null){
    response.sendRedirect("adminhome.jsp");
}

if(session.getAttribute("jpemail")!=null){
    response.sendRedirect("jobproviderhome.jsp");
}

if(session.getAttribute("jsemail")!=null){
    response.sendRedirect("jobseekerhome.jsp");
}

JobsRepository repo = new JobsRepository();
ArrayList<Jobs> joblist = repo.listJob();
Jobs job = null;
%>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-2">
            <a class="navbar-brand" href="index.jsp"><b style="font-size: 24px;">Job</b><span style="color:#7279E1;font-size: 24px;font-weight: bold;">Portal</span></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0"><a class="text-light" href="about.jsp" style="margin-right:5px;text-decoration: none;"><b> <span style="margin-top:2px;">About Us</span></b></a></ul>
            </div>
        </div>
    </nav>
    <header class="py-5" style="background-color:#7279E1; background-image: url('https://i.postimg.cc/6qnwV08Y/image.png');background-repeat: no-repeat;background-position: center; background-size: cover;
    ">
        <div class="container px-5 py-5 ">
            <div class="row gx-5 align-items-center justify-content-center ">
                <!-- <div class="col-xl-5 col-xxl-6 d-xl-block text-center "><img class="img-fluid rounded-3 " src="https://i.postimg.cc/2yKkY1ns/image.png " alt="image " /></div> -->
                <div class="col-lg-12 ">
                    <div class="my-5 text-center text-start ">
                        <h1 class="display-5 fw-bolder text-white mb-2 h6 ">Find Perfect Job & Profesionals</h1>
                        <p class="lead fw-normal text-light mb-4 ">The portal for both Job Providers and Seekers.</p>
                        <div class="d-grid gap-3 d-sm-flex justify-content-center justify-content-start ">
                        </div>
                        <div class="d-grid gap-3 d-sm-flex justify-content-center justify-content-start ">
                            <a class="btn btn-light btn-lg px-4 rounded-pill " href="jobproviderlogin.jsp"><b>Job Provider</b></a>
                            <a class="btn btn-light btn-lg px-4 rounded-pill " href="jobseekerlogin.jsp"><b>Job Seeker</b></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <section class="py-2 pt-4 " id="features ">
        <div class="container ">
            <div class="row ">
                <div class="col-md-1 "></div>
                <div class="col-md-10 ">
                    <div class="box text-justify ">
                    <div class="box">
<h2 class=" text-center class">All about Jobs in Single Portal</h2>
<p class=" text-center">Now you can find jobs online for free, apply for the jobs available from different companies in India easily with this portal. Find some here. Register an account to start. Then you can add your resume to your profile for job provider to view.</p>
</div>

<h2 class=" text-center class my-4">Available Jobs</h2>
<div class="row row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-3">
<%
Integer size = 0;
if(joblist.size() > 10){
	size = 10;
}
else{
	size = joblist.size();
}

for(int i = 0; i < size; i++)
			{
				job = joblist.get(i);
				
				int rno = job.getId();
				String name = job.getName();
				String qualification = job.getQualification();
				String skills=job.getSkills();
				int yop=job.getYop();
				
				int jpid=job.getJpid();
				
				%>
<div class="col mb-4">
<div class="shadow-sm card flex-row flex-wrap">
<div class="card-body col-12 col-sm-9">
<h4 class="card-title text-dark"><%=name%></h4>
<p class="card-text">Qualification: <%=qualification%></p>
<p class="card-text">Skills Required: <%=skills%></p>
<p class="card-text">Year of Passing: <%=yop%></p>
<a href="viewlogin?id=<%=rno%>&jpid=<%=jpid%>&jname=<%=name%>&qualification=<%=qualification%>&yop=<%=yop%>" class="btn btn-primary">Apply</a>
</div>
</div>
</div>
<% }%>
</div>
<p>Job portals, or job boards, are sites where you can advertise jobs and search for resumes. They are an integral part of almost every hiring process and using them effectively will translate into qualified candidates for relatively low costs.</p>

                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>
    </section>


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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js " type="text/javascript "></script>
</body>

</html>




    