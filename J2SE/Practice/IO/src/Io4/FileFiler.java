package Io4;

import java.io.File;
import java.io.FileFilter;

public class FileFiler implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.isHidden();
	}

}
