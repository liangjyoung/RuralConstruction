package com.rural.file;

import java.io.File;
import java.io.IOException;


public class CreateFileUtil {  
	    
	    public static boolean createDir(String destDirName) {
	        File dir = new File(destDirName);
	        if (dir.exists()) {
	           System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
	            return false;
	        }
	        if (!destDirName.endsWith(File.separator)) {
	            destDirName = destDirName + File.separator;
	        }
	        //创建目录
	        if (dir.mkdirs()) {
	           System.out.println("创建目录" + destDirName + "成功！");
	            return true;
	        } else {
	           System.out.println("创建目录" + destDirName + "失败！");
	            return false;
	        }
	    }
	   
	    
	  /* public static void main(String[] args) {
	        //创建目录
	        String dirName = "D:/InvesObjFile";
	        CreateFileUtil.createDir(dirName);
	       	       	       
	    }*/
	 
}
