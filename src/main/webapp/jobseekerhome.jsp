<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    
    <head>
        <meta charset="UTF-8">
        <title>JobSeeker Home</title>
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

if(status != null){
	   if(status.equals("false")){
		   message = "<p><strong>Oops! Something went wrong</strong></p>";
	   }
}
%>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-2">
            <a class="navbar-brand" href="index.jsp"><b style="font-size: 24px;">Job</b><span style="color:#7279E1;font-size: 24px;font-weight: bold;">Portal</span></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav"><a class="text-light" href="jobseekerhome.jsp" style="margin-right:5px;text-decoration: none;"><b> <span style="margin-top:2px;">JobSeeker Home</span></b></a></ul>
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0"><a class="btn btn-danger" href="logout" style="margin-right:5px;text-decoration: none;"><b> <span style="margin-top:2px;">Logout</span></b></a></ul>
            </div>
        </div>
    </nav>
    <header class="py-5" style="background-color:#7279E1">
        <div class="container px-5 py-5">
            <div class="row gx-5 align-items-center justify-content-center">
                <div class="col-lg-8 col-xl-7 col-xxl-6">
                    <div class="my-5 text-center text-xl-start">
                        <h1 class="display-5 fw-bolder text-white mb-2 h6">JobSeeker Home</h1>
                        <span class="text-dark"><%=message %></span>
                        <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                        </div>
                        <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start mt-3">
                            <a class="btn btn-light btn-lg px-4 rounded-pill" href="viewjobseekerprofile.jsp"><b>View Profiles</b></a>
                            <a class="btn btn-light btn-lg px-4 rounded-pill" href="viewalljobs.jsp"><b>View Jobs</b></a>
                        </div>
                    </div>
                </div>
                <div class="col-xl-5 col-xxl-6 d-xl-block text-center"><img class="img-fluid rounded-3" src="https://i.postimg.cc/Xv20WcYJ/image.png" alt="image" /></div>
            </div>
        </div>
    </header>

    <footer class="bg-dark py-4 mt-auto">
        <div class="container px-5">
            <div class="row align-items-center justify-content-between flex-column flex-sm-row">
                <div class="col-auto">
                    <div class="small m-0 text-white">All Rights Reserved | Job Portal</div>
                </div>
                <div class="col-auto">

                </div>
            </div>
        </div>
    </footer>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</body>

</html>