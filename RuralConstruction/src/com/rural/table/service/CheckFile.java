package com.rural.table.service;

import java.io.File;

public class CheckFile {


	public static boolean applicationtableExists(){
		String p=FileConfig.template_applicationtable;
		return fileExists(p);
	}

	public static Object fileNotExistsTips(){
		return "Please check template file.";
	}
	private static  boolean fileExists(String path){
		File f=new File(path);
		System.out.println("template file path : "+path);
		if(f.exists()){
			return true;
		}
		return false;
	}
}
