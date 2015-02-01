package MyTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PAchong {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<String> list=getbyWeb();
		
		for(String msg:list)
		{
			System.out.println(msg);
		}
	}

	public static List<String> getbyWeb() throws IOException {
		// TODO Auto-generated method stub
		
		//获取要爬虫的网页
		URL url=new URL("http://cwebmail.mail.163.com/js5/main.jsp?sid=SAQNEkrhXBaTdGfgrBhhjGVwhqkmQwXU#module=welcome.WelcomeModule%7C%7B%7D");
		
		//装饰类 
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(url.openStream()));
		
		//资源存
		List<String> list=new ArrayList<String>();
		
		//定义要爬取的字符串
		String msg="\\w+@\\w+(\\.\\w+)+";
		
		//爬虫引擎
		Pattern pattern=Pattern.compile(msg);
		
		
		//开始爬
		String line=null;
		while((line=bufferedReader.readLine())!=null)
		{
		
			Matcher matcher=pattern.matcher(line);
			
			while(matcher.find())
			{
				list.add(matcher.group());
			}
		}
		
		
		return list;
	}

}
