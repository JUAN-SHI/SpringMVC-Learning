<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: shijuan
  Date: 2017/12/27
  Time: 下午7:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC上传文件实例</title>
</head>
<body>

    <form:form method="POST" enctype="multipart/form-data">
        请选择一个文件上传：
        <input type="file" name="file"/>
           <input type="submit" value="提交上传"/>
    </form:form>
</body>
</html>
