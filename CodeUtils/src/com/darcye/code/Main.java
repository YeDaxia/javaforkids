package com.darcye.code;

import java.io.File;

/**
 * 
 * �������
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
			System.out.println("�½�Ϊ: " + chPath.getName() + " �Ĺ���ֵΪ : "+ cal.getResult());
		}
		
	}
	
}
