package test;

import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Service;



public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/axis/Helloworld.jws";
		
		Service service=new Service();
		
		Call call=service.createCall();
		
		call.setTargetEndpointAddress(url);
		
		call.setOperationName(new QName(url,"HelloWorld"));
		
		String re=(String) call.invoke(new Object[]{"Bill"});
		
		System.out.println(re);
		
	call.setOperationName(new QName(url,"getpassword"));
		
		System.out.println(call.invoke(new Object[]{}));
		
		
		
		
	
		
	}

}




