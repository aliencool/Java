package Io4;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterGL implements FilenameFilter {
	private String msg;
	public FileNameFilterGL(String msg)
	{
		this.msg=msg;
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		if(!msg.contains(".")) throw new ClassCastException();
		return name.endsWith(msg);
	}

}
