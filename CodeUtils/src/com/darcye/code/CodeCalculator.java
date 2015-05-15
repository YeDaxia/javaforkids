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
 * �ù���������ͳ����Ч���������������������µĹ���ֵ<p>
 * 
 * ��Ч���벻����: package��䣬 import��� �����С� ����ֵ����: 
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
	 * ��ȡ����ֵ
	 */
	public double getResult(){
		final int totalValidLineNumber = getTotalValidLineNumber();
		return totalValidLineNumber / CAL_FACTOR;
	}
	
	/**
	 * ��ȡ��Ч����
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
