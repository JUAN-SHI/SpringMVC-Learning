<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: shijuan
  Date: 2017/12/11
  Time: 上午8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Spring MVC页面重定向</title>
  </head>
  <body>
  <h2>Spring MVC页面重定向</h2>
  <p>点击下面的按钮将结果重定向到新页面</p>
  <form:form method="GET" action="/redirect">
    <table>
      <tr>
        <td><input type="submit" value="页面重定向" /></td>
      </tr>
    </table>
  </form:form>
  </body>
</html>
