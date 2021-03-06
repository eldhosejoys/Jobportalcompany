<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    
    <head>
        <meta charset="UTF-8">
        <title>JobSeeker Registration</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" />
    </head>
<%

response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);

if(session.getAttribute("jsemail")!=null){
	response.sendRedirect("jobseekerhome.jsp");
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
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0"><a class="text-light" href="about.jsp" style="margin-right:5px;text-decoration: none;"><b> <span style="margin-top:2px;">About Us</span></b></a></ul>
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
                                <h1 class=" card-title text-center pb-4 h3 "><span style="color:#000000;font-weight: bold; ">JobSeeker Registration</span> </h1>
                                <p class="text-danger text-center"><%=message %></p>
                                <span class="card-text ">
                                <form action="jsregister" method="post" id="formsubmit">
                                    <span id="formerror "></span>
                                <div class="form-group ">
                                    <label for="name"><span class="font-weight-bold ">Name:</span></label>
                                    <input required type="text " class="form-control " name="name" id="name" placeholder="Your Name ">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="age"><span class="font-weight-bold ">Age:</span></label>
                                    <input required type="number" class="form-control " name="age" id="age" placeholder="Your Age" min="15">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="dob"><span class="font-weight-bold ">Date of Birth:</span></label>
                                    <input required type="text" class="form-control " name="dob" id="dob" placeholder="Your Date of Birth ">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="email"><span class="font-weight-bold ">Email ID:</span></label>
                                    <input required type="email" class="form-control " name="email" id="email" placeholder="Your Email Address ">
                                </div>
                                <div class="form-group mt-3">
                                    <label for="contact"><span class="font-weight-bold ">Contact Number:</span></label>
                                    <input required type="text" class="form-control " name="contact" id="contact" pattern="[6-9]{1}[0-9]{9}" placeholder="Your Contact Number">
                                </div>
                                <div class="form-group mt-3 ">
                                    <label for="pwd " class="font-weight-bold ">Password:</label>
                                    <input required type="password" class="form-control " name="password" id="password" placeholder="Your Password ">
                                </div>
                                <center><button type="submit " class="btn btn-dark mt-4 font-weight-bold">Register Now</button></center>
                                </form>
                                <div class="mt-3 text-center"><a href="jobseekerlogin.jsp">Login to your Account</a> ????</div>
                                </span><br>
                            </div>
                        </div>
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