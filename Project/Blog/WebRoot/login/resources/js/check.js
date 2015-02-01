   
	
		function check_User()
	{
		$("#user").html("<img src='resources/images/loading.gif'/><font color="+"#FF0000"+" size="+"3"+">检查用户名中....</font>");
		if($("#LoginForm_user").val()!=null||$("#LoginForm_user").val()!="")
		{
			$.post("UserAction",{"flag":3,"actionuser.u_Name":$("#LoginForm_user").val()},function(date)
		{
			if(date==1991)
			{
				$("#user").html("<font color="+"#FF0000"+" size="+"3"+">恭喜用户名可用</font>")
			}else
			{
				document.getElementById("user").innerHTML="<img src='resources/images/error.png'><font color="+"#FF0000"+" size="+"3"+">用户名被人占用</font></img>";
				return false;
			}
		});
		}
	}
	
		 
	
	
	function cheack_nick()
	{
	
	var user=$("#LoginForm_nickname").val();
	
		if(user==""||user==null)
		{	
			
			document.getElementById("nickname").innerHTML="<img src='resources/images/error.png'><font color="+"#FF0000"+" size="+"3"+">不能为空</font></img>";
		}
		else
		{
				 $("#nickname").hide();
		 return true;
			}
			return false;
		 
		 
	}
	
	
	
	function cheack_password()
	{
		var password_cheack=/\w{5,}/;
		var cheackpwd=$("#LoginForm_password").val();
		var cheackpwd1=$("#LoginForm_check_passworld").val();
			if((!password_cheack.test(cheackpwd))||(!password_cheack.test(cheackpwd1))||cheackpwd1==null||cheackpwd1=="")
			{	
					
				document.getElementById("answerJS").innerHTML="<img src='resources/images/error.png'><font color="+"#FF0000"+" size="+"3"+">密码不一致或者长度小于5</font></img>";
				document.getElementById("answer1JS").innerHTML="<img src='resources/images/error.png'><font color="+"#FF0000"+" size="+"3"+">密码不一致或者长度小于5</font></img>";
			}
			else if(cheackpwd.value==cheackpwd1.value)
			{
				 $("#answerJS").hide();
				 $("#answer1JS").hide();
				 return true;
			}
			return false;
	}
	function cheack_email()
	{
	
		
			var email=$("#LoginForm_email").val();
		var emil_cheack=/\w+([_+.]\w)*@\w+([-.]\w+)*\.\w+/;
		if((!emil_cheack.test(email))||!(email!=""))
		{
			
				
			document.getElementById("email").innerHTML="<img src='resources/images/error.png'><font color="+"#FF0000"+" size="+"3"+">邮箱格式错误</font></img>";
		}
		else
		{	
			Email_check=true;
			 $("#email").hide();
		 return true;
			}
			return false;
	
	}
	function cheack_birthday()
	{
		var bir_cheack=/\d{4}-\d{2}/;
		var telebir=$("#LoginForm_birthday").val();
		if((!bir_cheack.test(telebir))||!(telebir!=""))
		{
		
			document.getElementById("birthday").innerHTML="<img src='resources/images/error.png'><font color="+"#FF0000"+" size="+"3"+">格式:1999-11</font></img>";
		}
		else
		{
			
		 $("#birthday").hide();
		 return true;
			}
			return false;
	
	}
	
	function check_all()
	{
		if(!(cheack_birthday()&&cheack_email()&&cheack_password()&&cheack_nick()&&check_User()))
		{
			$("#LoginForm_nickname").focus();
		}else
		{
			
		return 	true;
		}
		
	}