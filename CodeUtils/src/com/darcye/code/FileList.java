package com.darcye.code;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 递归遍历文件夹下的文件
 * 
 * @author Darcy
 * @date 2014-9-28 上午10:22:16
 * @version V1.0
 */
public class FileList {
	
	private String mRootPath;
	
	private List<File> mFiles = new ArrayList<File>();
	
	private FilenameFilter mFilenameFilter;
	
	public FileList(String rootPath){
		this.mRootPath = rootPath;
	}
	
	public List<File> recurseListFiles(){
		return recurseListFiles(null);
	}
	
	public List<File> recurseListFiles(FilenameFilter filter){
		this.mFilenameFilter = filter;
		recurseListFiles1(mRootPath);
		return mFiles;
	}
	
	private void recurseListFiles1(String p){
		File path = new File(p);
		if(!path.isDirectory())return;
		File[] files = path.listFiles();
		for(File f : files){
			if(f.isDirectory()){
				recurseListFiles1(f.getPath());
			}else{
				if(mFilenameFilter==null || mFilenameFilter.accept(f, f.getName())){
					mFiles.add(f);
				}
			}
		}
	}
}
