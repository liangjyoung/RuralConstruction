package com.rural.table.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class XML2Word {
	/*
	 * 
	 * @Author:Rick
	 * filepath 模板文件路径
	 * tofilepath 要生成的文件路径
	 * items word xml模板文件中的占位符
	 * data  word xml文件要替换的数据
	 */
	  public boolean changeFileText(String filepath,String tofilepath,List<String> items,List<String > data){
		  System.out.println("filepath :"+filepath);
		  System.out.println("tofilepath :"+tofilepath);
		  
		  File file = new File(filepath);
		  String line=null;
		  FileInputStream fis=null;
		  FileOutputStream fos=null;
		  BufferedInputStream bis=null;
		  try{
		   fis = new FileInputStream(file);
		  StringBuffer  sb=new StringBuffer ();
		 
		  bis=new BufferedInputStream(fis);
	   //   BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		  byte[] buffer=new byte[1024];
		  int len=1024;
		  String result= "";
	      while((len=fis.read(buffer))>0){
	    	  String cache=new String(buffer,0,len,"UTF-8");
	    	 
	    	 result+=cache;
	      }
	     
	     // result=new String(result.getBytes(),"UTF-8");
	    //   System.out.println(items+"-----------"+data);
	      for(int i=0;i<items.size();i++){
//	    	  /*
//	    	   * 
//	    	   * 正则替换文件中的占位符
//	    	   */
//	  
	    	  result=result.replaceAll("\\{"+items.get(i)+"\\}", data.get(i));
	      }
	      System.out.println(result);
	     // tofilepath=tofilepath.substring(0,tofilepath.indexOf("."))+".doc";
		  File out=new File(tofilepath);
		  out.createNewFile();
		  if(out.exists()){
			  System.out.println("heihei--"+out.getPath());
		  }
		  OutputStreamWriter pw = null;
		  
		  fos=new FileOutputStream(out);
		  pw = new OutputStreamWriter(fos,"UTF-8");
		  pw.write(result);
		  pw.close();
		  //fos.write(result.getBytes());
		  
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			try {
				fis.close();
				fos.close();
				bis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		  return true;
	  }
}
