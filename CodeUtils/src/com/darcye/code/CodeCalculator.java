package com.darcye.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 
 * 该工具类用于统计有效代码的行数，并计算出大致的贡献值<p>
 * 
 * 有效代码不包括: package语句， import语句 ，空行。 贡献值计算: 
 * 
 * @author Darcy <a href="http://www.darcye.com">www.darcye.com</a>
 * 
 */
public class CodeCalculator {
	
	private static final double CAL_FACTOR = 50.0;
	
	private String mRootPath;
	
	public CodeCalculator(){};
	
	public CodeCalculator(String rootPath){
		this.mRootPath = rootPath;
	}
	
	public void setRootPath(String rootPath){
		this.mRootPath = rootPath;
	}
	
	/**
	 * 获取贡献值
	 */
	public double getResult(){
		final int totalValidLineNumber = getTotalValidLineNumber();
		return totalValidLineNumber / CAL_FACTOR;
	}
	
	/**
	 * 获取有效行数
	 * @return
	 */
	public int getTotalValidLineNumber(){
		
		if(mRootPath == null)
			throw new NullPointerException("the path is null");
		
		int totalValidLineNum = 0;
		FileList fl = new FileList(mRootPath);
		List<File> javaFiles = fl.recurseListFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		
		for(File f : javaFiles){
			totalValidLineNum += getFileValidLineNumber(f);
		}
		
		return totalValidLineNum;
	}
	
	private int getFileValidLineNumber(File javaFile){
		BufferedReader reader = null;
		int validLineNum = 0;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(javaFile)));
			String lineText;
			while((lineText = reader.readLine()) != null){
				if(isInvalidLine(lineText))
					++validLineNum;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return validLineNum;
	}
	
	private static boolean isInvalidLine(String lineText){
		return lineText != null && !lineText.trim().isEmpty() && !lineText.startsWith("package ") && !lineText.startsWith("import ");
	}
}
