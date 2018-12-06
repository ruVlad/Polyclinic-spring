<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #111;
        }

        .active {
            background-color: #4CAF50;
        }

        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: #111;
            color: white;
            text-align: center;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:hover {
            background-color: #f2f2f2
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        fieldset {
            color: white;
            background-color: #333;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add New Health Sertificate</title>
</head>
<body>


<form:form method="POST" commandName="healthSertificate" action="${pageContext.request.contextPath}/healthSertificate/edit/${healthSertificate.id}.html">
    <table>
        <tbody>
        <tr>
            <td>ID Disease:</td>
            <td><form:input path="idDisease" /></td>
        </tr>
        <tr>
            <td>ID Doctor:</td>
            <td><form:input path="idDoctor" /></td>
        </tr>
        <tr>
            <td>ID Patient:</td>
            <td><form:input path="idPatient" /></td>
        </tr>
        <tr>
            <td>Date of Issue:</td>
            <td><form:input path="dateOfIssue" /></td>
        </tr>
        <tr>
            <td>Expiry Date:</td>
            <td><form:input path="expiryDate" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add" /></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>

