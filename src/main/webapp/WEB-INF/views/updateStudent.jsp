<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019/2/18
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
<form  align='center' action="${pageContext.request.contextPath}/student/astudent" method="POST" >
    <input type="hidden" name="_method" value="PUT"/>

                <input type="hidden" name="id" value="${c.id }"/>
                <br/>
				修改修真类型为：<input type="text" name="type" value="${c.type }"/> 
                <br/>
                修改辅导师兄为：<input type="text" name="senior" value="${c.senior }"/> 
                <br/>
                <input type="hidden" name="updatedAt" value="${c.updatedAt}"/>
   <%--             <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${c.updatedAt}"/>--%>
                <br/>
				<input type="submit" value="修改" />


</form>
</body>
</html>
