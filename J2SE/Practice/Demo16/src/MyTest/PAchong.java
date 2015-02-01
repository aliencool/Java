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
		
		//��ȡҪ�������ҳ
		URL url=new URL("http://cwebmail.mail.163.com/js5/main.jsp?sid=SAQNEkrhXBaTdGfgrBhhjGVwhqkmQwXU#module=welcome.WelcomeModule%7C%7B%7D");
		
		//װ���� 
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(url.openStream()));
		
		//��Դ��
		List<String> list=new ArrayList<String>();
		
		//����Ҫ��ȡ���ַ���
		String msg="\\w+@\\w+(\\.\\w+)+";
		
		//��������
		Pattern pattern=Pattern.compile(msg);
		
		
		//��ʼ��
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
