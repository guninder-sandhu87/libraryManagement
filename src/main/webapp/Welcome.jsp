<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Welcome</title>
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
        String userName= (String)session.getAttribute("userName");
        if(userName!=null){
        %>
        <div class="container welcome" >
            <h3 style="text-align:center">Welcome <%=userName%></h3>
        </div>

        <%
        }else{
        request.getSession().setAttribute("user_not_logged","Please Login");
        response.sendRedirect("login.jsp");
        }
        %>
        <div class="container m-5">
        <hr>
             <div class="info">
                <h3>Summary of Books Borrowed</h3>
                <p>You have 0 books borrowed<p>
             </div>
        </hr>
        <h3>What will you like to do today</h3>
        

        </div>


    </body>
</html>
