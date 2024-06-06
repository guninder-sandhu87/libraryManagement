<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <nav class="navbar navbar-expand-lg p-0" style="background-color: #320373">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">MyLibrary</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon text-white"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="registration.jsp">Register</a>
                    </li>
                </ul>
                <form class="d-flex" role="search">
                    <input class="form-control me-2 mt-2 p-1" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success  mt-2 p-1" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>


</html>
