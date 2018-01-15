<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: shijuan
  Date: 2017/12/12
  Time: 下午7:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC表单处理之-密码</title>
</head>
<body>
<h2>提交的用户信息</h2>
<table>
    <tr>
        <td>用户名：</td>
        <td>${username}</td>
    </tr>
    <tr>
        <td>密码：</td>
        <td>${password}</td>
    </tr>
    <tr>
        <td>地址：</td>
        <td>${address}</td>
    </tr>

    <tr>
        <td>是否订阅新闻</td>
        <td>${receivePaper}</td>
    </tr>

    <tr>
        <td>喜欢的技术/框架</td>
        <td> <% String[] favoriteFrameworks = (String[])request.getAttribute("favoriteFrameworks");
            for (String framework:favoriteFrameworks) {
                out.println(framework);
            }%>
        </td>
    </tr>



    <tr>
        <td>性别：</td>
        <td>${(gender=="M"? "男" : "女")}</td>
    </tr>

    <tr>
        <td>喜欢的数字：</td>
        <td>${favoriteNumber}</td>
    </tr>

    <tr>
        <td>国家：</td>
        <td>${country}</td>
    </tr>

    <tr>
        <td>技术：</td>
        <td>
            <%
                String[] skills = (String[]) request.getAttribute("skills");
                for (String skill : skills) {
                    out.println(skill);
                }
            %>
        </td>
    </tr>
</table>
</body>
</html>
