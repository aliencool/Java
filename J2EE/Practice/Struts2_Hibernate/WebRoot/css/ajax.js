// JavaScript Document
var count=0;
var select=0;
	function getKeyCode(e)
	{
		var keycode;
		if(window.event)
		{
			keycode=e.keyCode;
		}
		else if(e.which)
		{
			keycode=e.which;
		}
		return keycode;
	}
function getSuggest(Keyword,e)
{
	var keycode=getKeyCode(e);
	
	
	if(Keyword==null&&Keyword=="")
	{
	clearDiv();
	return;
	}
	
		if(keycode==40||keycode==38||keycode==13)
		{
			return;
		}
	
	
	var xmlhttp;
	if(window.XMLHttpRequest)
	{
			xmlhttp=new XMLHttpRequest();	
	}else
	{
			xmlhttp=new ActiveX("Microsoft.XMLHTTP");
	}
	var url="Search.action?Search_date="+Keyword+"&flag=like";
	xmlhttp.open("POST",url,true);
	xmlhttp.onreadystatechange=function()
	{
		
		if(xmlhttp.readyState==4&&xmlhttp.status==200)
		{
		
			
			var Text=xmlhttp.responseText;
			
			
			var spit_msg=Text.split("|");
			
			var msg="<ul id='sug'>";
			
			for(var i=0;i<spit_msg.length-1;i++)
			{
			if(i==3)break;
				var msg=msg+
						"<li  onclick=\"theMouseClick("+ count +")\" onmouseover=\"theMouseOver(" + count + ");\" " +
							"onmouseout=\"theMouseOut("+ count +");\">"+spit_msg[i]+"</li>";
				
				count++;
			 }
			 msg=msg+"</ul>";
			 document.getElementById("dSuggest").innerHTML=msg;
			
			 showDiv();
			
			 count=0;
		}	
	}
	xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8"); 
	xmlhttp.send(null);
}


	function showDiv(){

	document.getElementById("dSuggest").style.display = "block";
}
	
	function theMouseClick(pos) {
		var key =document.getElementById("sug").getElementsByTagName("LI")[pos].innerHTML;
	
		document.getElementById("search").value=key;
		clear();
	}
	function upanddown(e,key)
	{
		var keycode=getKeyCode(e);
		
		var li =document.getElementById("sug").getElementsByTagName("LI");
		if(keycode==13)
		{
			window.location.href="Search.action?Search_date="+key+"&flag=search";
		}
		
		
		if(keycode==38||keycode==40)
		{
			if(li==null)
			{
				return;
			}
		
			
			if(keycode==38)
			{
				select--;
				
				if(select==-1)select=li.length-1;
			}
			
			if(keycode==40)
			{
				
				select++;
				
				if(select>=li.length)select=0;
			}
				
		set_style(select);
		
		var key =document.getElementById("sug").getElementsByTagName("LI")[select].innerHTML;
		document.getElementById("search").value=key;	
		
		
		}
		
	
	}
	
	function clear()
	{
		document.getElementById("dSuggest").style.display = "none";
	}
	

	function set_style(num)
	{
		
		var key =document.getElementById("sug").getElementsByTagName("LI");
		for(i=0;i<key.length;i++)
		{
			if(i==num)
			{
				document.getElementById("sug").getElementsByTagName("LI")[i].className="select";
			}
			else
			{
				document.getElementById("sug").getElementsByTagName("LI")[i].className="";
			}
		}
	}
	
	
	function theMouseOver(pos)
	{
		document.getElementById("sug").getElementsByTagName("LI")[pos].className="select";
		var key =document.getElementById("sug").getElementsByTagName("LI")[pos].innerHTML;
		
		select=pos;
		set_style(select);
		document.getElementById("search").value=key;	
	}

		function theMouseOut(pos)
	{
		document.getElementById("sug").getElementsByTagName("LI")[pos].className="";
	}