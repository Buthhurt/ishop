<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="windows-1251" %>
<%@ page import="by.gvu.jd2.ishop.bean.define.Define" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>IShop</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body class="m-2">
    <a type="button" class="btn btn-success" href="login">Войти</a>
    <a type="button" class="btn btn-info" href="${Define.REGISTRATION_PAGE}">Зарегестрироваться</a>
</body>
</html>