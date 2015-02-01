package upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class uploading extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	BufferedReader reader=new BufferedReader(new InputStreamReader(req.getInputStream()));
	String msg=reader.readLine();
	reader.readLine();
	reader.readLine();
	while((msg=reader.readLine())!=null)
	{
		System.out.println(msg);
	}
	}
	
	
}
