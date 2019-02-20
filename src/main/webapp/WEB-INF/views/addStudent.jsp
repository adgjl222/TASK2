<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019/1/14
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <title>添加学生信息</title>
    <%--统一样式--%>
    <style>
        label {display:inline-block; width: 10em; margin-right: 1em; text-align: right; }
    </style>
    <title>Document</title>
</head>
<body>


<div>
    <form  action="${pageContext.request.contextPath}/student/student" method="post" >


        <input type="hidden" name="createdAt" value="<%=System.currentTimeMillis()%>">
        <input type="hidden" name="updatedAt" value="<%=System.currentTimeMillis()%>">

        <%--
          解决数据库中字段全为not null 时，表单中string类型----默认为字符长度为0，不是null,可以正常提交
          而int,long基本类型，没有默认值，要求必填，不填的话，页面400错误，同时数据库操作失败
          required 属性 要求必填或者必选，是html5的新特性·
          oninvalid="this.setCustomValidity('请输入姓名')" ------在字段无效时显示自定义消息
          oninput="setCustomValidity('')"---------------------- 删除经过验证的字段上的invalidate消息 --%>

        <label>QQ：</label><input type="text" name="qq"  required="" maxlength="15"
                                 oninvalid="this.setCustomValidity('请输入qq')" oninput="setCustomValidity('')" />
        <br/>
        <label>预计入学时间：</label><input type="text"  name="estimatedTime"
                                   />
        <br/>
        <label>毕业院校：</label><input type="text" name="graduateFrom"  value="郑州大学" required=""
                                   oninvalid="this.setCustomValidity('毕业院校不能为空')" oninput="setCustomValidity('')"/>
        <br/>

        <label>姓名：</label><input name="name" type="text" required=""
                                 oninvalid="this.setCustomValidity('请输入姓名')" oninput="setCustomValidity('')" />
        <br/>

        <label>修真类型：</label><input type="text" name="type" required=""
                                   oninvalid="this.setCustomValidity('修真类型不能为空')" oninput="setCustomValidity('')" />
        <br/>

        <label>线上学号：</label><input type="text" name="lineId" min="1" max="2147483647" required />

        <br/>
        <label>日报连接：</label><input type="text" name="logUrl"  required=""
                                   oninvalid="this.setCustomValidity('日报链接不能为空')" oninput="setCustomValidity('')"/>
        <br/>
        <label>入学宣言：</label><input type="text" name="will"  required=""
                                 oninvalid="this.setCustomValidity('入学宣言不能为空')" oninput="setCustomValidity('')"/>
        <br>
        <label>辅导师兄：</label><input type="text" name="senior"  required=""
                                   oninvalid="this.setCustomValidity('辅导师兄不能为空')" oninput="setCustomValidity('')"/>
        <br/>
        <label>了解方式：</label><input type="text" name="knowFrom"  required=""
                                      oninvalid="this.setCustomValidity('了解方式不能为空')" oninput="setCustomValidity('')"/>
        <br/>
        <input id="btn" type="submit" name="ok" value="注册"/><input type="reset" name="r" value="清空">


    </form>

</div>

</body>
</html>
