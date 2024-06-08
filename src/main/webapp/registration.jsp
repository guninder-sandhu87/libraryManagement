<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
        <style>
            body{
                background: linear-gradient(to right,rgba(101, 16, 227,0.6),rgba(101, 16, 227,0.1));

            }
        </style>

    </head>
    <body>
        <%@include file="header.jsp" %>


        <div class="container login-form" >
            <div class="container inner-login" style=" color:snow;border-radius: 3px;width: 80%">
                <div class="row m-3">
                    <div class="col-lg-8 offset-lg-2 mt-3">
                        <h2 style="text-align: center">Join Sandhuz Library</h2>
                        <p style="text-align: center" class="lead">Sign up for a membership or our newsletter</p>
                        <form action="register" method="post">

                            <div class="form-group row m-3">
                                <label for="name" class="col-sm-2 col-form-label">Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter your full name"
                                           required>
                                </div>
                            </div>
                            <div class="form-group row m-3">
                                <label for="email" class="col-sm-2 col-form-label text-right">Email </label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email"
                                           required>
                                </div>
                            </div>
                            <div class="form-group row m-3">
                                <label for="phone" class="col-sm-2 col-form-label text-right">Mb</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="phone" name="phone"
                                           placeholder="Enter your phone number">
                                </div>
                            </div>
                            <div class="form-group row m-3">
                                <label for="password" class="col-sm-2 col-form-label text-right">Password</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="password" name="password"
                                           placeholder="Enter your password">
                                </div>
                            </div>
                            <div class="form-group row m-3">
                                <label for="re_password" class="col-sm-2 col-form-label text-right">Re-password</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="re_password" name="re_password"
                                           placeholder="Enter your password again">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-12 text-center">
                                    <button type="submit" class="btn btn-primary">Sign Up</button>
                                </div>
                            </div>
                             <%
                                 String email_already_used=(String)request.getAttribute("user_false");
                                 System.out.println("email_already_used"+ email_already_used);
                                 if(email_already_used!=null){
                                 %>
                                 <br>
                                 <br>
                                 <div class="form-group row">
                                     <div class="col-sm-12 text-center">
                                 <p1 style="color:red; text-align:center"><%=email_already_used%></p1>
                                    </div>
                                 </div>
                                 <%
                                    }
                                 %>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
