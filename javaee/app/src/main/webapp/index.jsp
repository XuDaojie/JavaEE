<%@ page language="java"
         import="java.util.*"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello JSP</title>
</head>
<body>
<h1>Hello JSP</h1>
<!-- HTML注释 客户端可见 -->
<%-- JSP注释 客户端不可见 --%>

<%-- 声明标签 --%>
<%!
    String s = "王小二";

    public int sum(int x, int y) {
        return x + y;
    }
%>
<%-- 脚本标签 --%>
<%
    // JSP内置对象
    out.println("Hello JSP");
%>
<%-- 表达式标签 --%>
<br>
Hello <%=s %><br>
x+y=<%=sum(1, 3) %>

<p>Get your greeting <a href="springMVC/greeting">here</a></p>
</body>
</html>