<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
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
        <%
                String userNotLogged= (String)session.getAttribute("user_not_logged");
                if(userNotLogged!=null){
         %>
                <div class="container userNotLogged">
                    <div class="centered">
                        <h3 style="text-align:center;color:red"><%=userNotLogged%></h3>
                    </div>
                 </div>
                <%
                }
           %>

        <div class="container login-form" >
            <div class="container inner-login" style=" color:snow;border-radius: 3px;width: 80%">
                <div class="row m-3">
                    <div class="col-lg-8 offset-lg-2 mt-3">
                        <h2 style="text-align: center">Login</h2>
                        <p style="text-align: center" class="lead">Enter the world of books</p>
                        <form action="login" method="post">


                            <div class="form-group row m-3">
                                <label for="email" class="col-sm-2 col-form-label text-right">Email </label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email"
                                           required>
                                </div>
                            </div>
                            <div class="form-group row m-3">
                                <label for="password" class="col-sm-2 col-form-label text-right">Password</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="password" name="password"
                                           placeholder="Enter your password">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-12 text-center">
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
