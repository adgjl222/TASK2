<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019/2/15
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>全部</title>
</head>
<body>

<style>
    #jz{ margin:0 auto; width:320px; height:100px; border:1px }
</style>

<div id="jz">
<table  align="center"  cellspacing='0'>
   <%-- <form action="${pageContext.request.contextPath}/student/student" method="get" >
        <input type="submit" value="注册"/>

    </form>--%>

    <a href="${pageContext.request.contextPath}/student/student">注册</a>
    </table>


<table align="center"  cellspacing='0'>
<form action="${pageContext.request.contextPath}/student/listStudent" method="post">
			<span>
				姓名：<input name="name" value="${name }"/> 

                <input type="hidden" name="pageNum" value="1" />  
				<input type="submit" value="查询" />
			</span>
</form>
    </table>
</div>


<table align='center' border="1" cellspacing="0" cellpadding="0">
<tr>
    <th>ID</th>
    <th>线上学号</th>
    <th>姓名</th>
    <th>QQ</th>
    <th>修真类型</th>
    <th>预计入学时间</th>
    <th>毕业院校</th>
    <th>日报链接</th>
    <th>入学宣言</th>
    <th>辅导师兄</th>
    <th>了解方式</th>
    <th>注册时间</th>
    <th>更新时间</th>

    <th>操作</th>

</tr>
    <c:set var="now" value="<%=new java.util.Date()%>"/>

<c:forEach var="student" items="${students}">
    <%-- 时间戳转化为日期--%>
    <jsp:useBean id="createdAt" class="java.util.Date"   scope="page"  />
    <jsp:setProperty property="time" name="createdAt" value="${student.createdAt}"/>
    <jsp:useBean id="updatedAt" class="java.util.Date"   scope="page" />
    <jsp:setProperty property="time" name="updatedAt" value="${student.updatedAt}"/>
    <tr>
    <td>${student.id }</td>
    <td>${student.lineId }</td>
    <td>${student.name }</td>
    <td>${student.qq }</td>
    <td>${student.type }</td>
    <td>${student.estimatedTime }</td>
    <td>${student.graduateFrom }</td>
    <td>${student.logUrl }</td>
    <td>${student.will }</td>
    <td>${student.senior }</td>
    <td>${student.knowFrom }</td>


        <%--formDmatDate 格式化日期显示--%>
    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${createdAt}"/></td>
    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${updatedAt}"/></td>

    <td>

        <a href="${pageContext.request.contextPath}/student/${student.id}">修改改</a>

      <%--  <form action="${pageContext.request.contextPath}/student/${student.id}" method="get">
            <input type="submit" value="修改"/>
        </form>--%>


    <form action="${pageContext.request.contextPath}/student/${student.id}" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        <input type="submit" value="删除"/>
    </form>
</td>

</tr>
    </c:forEach>

    <tr>
        <td class="scott" colspan="20" style="text-align: center;">
            <c:if test="${page.pageNum > 1 }">
                <a href="/student/listStudent?name=${name }&pageNum=1">首页</a>
                <a href="/student/listStudent?name=${name }&pageNum=${page.pageNum - 1 }">上一页</a>
            </c:if>
            <c:if test="${page.pageNum <= 1 }">
                <a href="/student/listStudent?name=${name }&pageNum=1">首页</a>
            </c:if>
            <c:forEach begin="1" end="${page.totalPages}" step="1" var="num">
                <c:if test="${page.pageNum == num }">${num }</c:if>
                <c:if test="${page.pageNum != num }">
                    <a href="/student/listStudent?name=${name }&pageNum=${num }">${num }</a>
                </c:if>
            </c:forEach>
            <c:if test="${page.pageNum < page.totalPages }">
                <a href="/student/listStudent?name=${name }&pageNum=${page.pageNum + 1 }">下一页</a>
                <a href="/student/listStudent?name=${name }&pageNum=${page.totalPages }">尾页</a>
            </c:if>
            <c:if test="${page.pageNum <= 1 }">
                总${1}/${page.totalPages }页
            </c:if>
            <c:if test="${page.pageNum >= page.totalPages }">
                总${1}/${page.totalPages }页
            </c:if>
        </td>
    </tr>
</table>

    </body>
</html>
