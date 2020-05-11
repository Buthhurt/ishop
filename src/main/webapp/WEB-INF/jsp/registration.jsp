<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="windows-1251" %>
<%@ page import="by.gvu.jd2.ishop.bean.define.Define" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <jsp:useBean id="errorMessage" class="java.lang.String" type="java.lang.String" scope="request" />
    <c:set var="test" scope="page" value="qwe" />
    <c:if test="${errorMessage!=null && errorMessage.length()>0}">
        <nav class="navbar navbar-light bg-danger">
            <c:out value="${errorMessage}"/>
        </nav>
    </c:if>
    <div class = "container">
        <div class="row">
            <div class="col">
                <form class="border border-dark p-5" action="Controller" method="post">
                    <p class="h4 mb-4 text-center">Регистрация</p>

                    <input type="text" id="${Define.WEB_USER_LOGIN}" name="${Define.WEB_USER_LOGIN}" class="form-control mb-4" placeholder="Login" value="${test}">

                    <input type="password" id="${Define.WEB_USER_PASSWORD}" name="${Define.WEB_USER_PASSWORD}" class="form-control mb-4" placeholder="Password" value="${test}">

                    <input type="password" id="${Define.WEB_USER_PASSWORD_CONFIRM}" name="${Define.WEB_USER_PASSWORD_CONFIRM}" class="form-control mb-4" placeholder="Password confirm" value="${test}">

                    <input type="email" id="${Define.WEB_USER_EMAIL}" name="${Define.WEB_USER_EMAIL}" class="form-control mb-4" placeholder="Email" value="${test}@${test}.${test}">

                    <input type="text" id="${Define.WEB_USER_FIRST_NAME}" name="${Define.WEB_USER_FIRST_NAME}" class="form-control mb-4" placeholder="First name" value="${test}">

                    <input type="text" id="${Define.WEB_USER_SECOND_NAME}" name="${Define.WEB_USER_SECOND_NAME}" class="form-control mb-4" placeholder="Second name" value="${test}">

                    <input type="text" id="${Define.WEB_USER_NIK_NAME}" name="${Define.WEB_USER_NIK_NAME}" class="form-control mb-4" placeholder="Nik name" value="${test}">

                    <button class="btn btn-info btn-block my-4" type="submit">Зарегестрироваться</button>
                    <a class="btn btn-light btn-block my-4" href="./">Выход</a>

                    <input type="hidden" name="${Define.COMMAND}" value="${Define.COMMAND_REGISTRATION}">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
