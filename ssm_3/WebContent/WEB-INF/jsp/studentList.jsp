<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$(".sel").click(function(){
		var stuNo = $(this).parent().parent().find("td").eq(0).text();
		$.ajax({
			url:"getByIdFindStudent",
			data:{"stuNo":stuNo},
			dataType:"JSON",
			type:"post",
			success:function(data){
				$("[name=stuName]").val(data.stuName);
				$("[name=age]").val(data.age);
				$("[name=gradeId]").val(data.gradeId);
				$("[name=birthday]").val(data.birthday);
				$("[name=passWord]").val(data.passWord);
				$("#zjz").attr("src","../upload/"+data.zjz);
				$("#gzz").attr("src","../upload/"+data.gzz);
			},
			error:function(){
				alert("...");
			}
		})
	})
	
})
</script>
</head>
<body>
	<table width="700px" border="1">
		<tr>
			<td>学生编号</td>
			<td>学生姓名</td>
			<!-- <td>学生密码</td> -->
			<td>生日</td>
			<td>证件照</td>
			<td>工作照</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.stuNo}</td>
				<td>${item.stuName}</td>
				<%-- <td>${item.passWord}</td> --%>
				<td>${item.birthday}</td>
				<td><img alt="" width="100px" height="60px" src="../upload/${item.zjz}"></td>
				<td><img alt="" width="100px" height="60px"  src="../upload/${item.gzz}"></td>
				<td><a href="#" class="sel">查看</a></td>
			</tr>
		</c:forEach>
	</table>
	<div id="div_1">
		用户名：<input type="text" value="" name="stuName"/><br/>
		年级编号：<input type="text" value="" name="gradeId"/><br/>
		年龄：<input type="text" value="" name="age"/><br/>
		密码：<input type="text" value="" name="passWord"/><br/>
		生日：<input type="text" value="" name="birthday"/><br/>
		证件照：<img alt="" id="zjz" width="150px" height="100" src="">
		工作照：<img alt="" id="gzz" width="150px" height="100" src="">
	</div>
</body>
</html>