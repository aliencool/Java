package SmallDemo;

import java.io.File;
import java.io.FilenameFilter;

public class MyFile implements FilenameFilter {
	private String sub;
	public MyFile(String sub)
	{
		this.sub=sub;
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(sub);
	}

}
