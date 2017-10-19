<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#asdfg").live("click",function(){
			alert(1);
		});
		
		$("[name=stuName]").blur(function(){
			$("body").append("<p id='asdfg'>哈哈哈哈</p>");
			var stuName = $(this).val();
			/* $.ajax({
				url:"checkStuName",
				type:"post",
				data:{"stuName":stuName},
				dataType:"JSON",
				success:function(data){
					if(data=="no"){
						$("#message").html("用户名已经存在");
					}else{
						$("#message").html("用户名可以使用");
					}
				},
				error:function(){
					alert("请呼叫网管");
				}
			}) */
		});
	});
</script>
</head>
<body>	
	
	<form action="doAddStudent" method="post" enctype="multipart/form-data">
		用户名：<input type="text" value="" name="stuName"/><span id="message"></span><br/>
		年级编号：<input type="text" value="" name="gradeId"/><br/>
		年龄：<input type="text" value="" name="age"/><br/>
		密码：<input type="text" value="" name="passWord"/><br/>
		生日：<input type="text" value="" name="birthday"/><br/>
		证件照：<input type="file" name="files"/><br/>
		工作照：<input type="file" name="files"/><br/>
		<input type="submit" value="保存"/>
	</form>
</body>
</html>