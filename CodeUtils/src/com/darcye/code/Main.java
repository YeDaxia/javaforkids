package com.darcye.code;

import java.io.File;

/**
 * 
 * 函数入口
 * 
 * @author Darcy
 *
 */
public class Main {
	
	public static void main(String[] args) {
		File chatperPaths = new File("C:/Users/Administrator/Desktop/jfk_code");
		
		CodeCalculator cal = new CodeCalculator();
		
		for(File chPath : chatperPaths.listFiles()){
			cal.setRootPath(chPath.getPath());
			System.out.println("章节为: " + chPath.getName() + " 的贡献值为 : "+ cal.getResult());
		}
		
	}
	
}
