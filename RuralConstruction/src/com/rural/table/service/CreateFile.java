package com.rural.table.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class CreateFile {
	private String template_applicationtable="\\template\\template_applicationtable.xml";
	private String applicationfilepath="\\download\\applicationtables\\";
	private String cache="";
	private String downloadfilepath="\\download\\";
	private String applicationzippath=downloadfilepath;

	private XML2Word xml2word=new XML2Word();
	public CreateFile(){
		File directory = new File("");
		String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("");  
		System.out.println("uoloadpath---------------------------------"+path);
		this.applicationfilepath=path+applicationfilepath;
		this.template_applicationtable=path+template_applicationtable;
		this.applicationzippath=path+applicationzippath;
		System.out.println(path);
	}
	
	 //递归删除文件夹
    public  boolean checkFilePath(File file) {
     if (file.exists()) {//判断文件是否存在
      if (file.isFile()) {//判断是否是文件
       file.delete();//删除文件 
      } else if (file.isDirectory()) {//否则如果它是一个目录
       File[] files = file.listFiles();//声明目录下所有的文件 files[];
       for (int i = 0;i < files.length;i ++) {//遍历目录下所有的文件
    	   files[i].delete();//把每个文件用这个方法进行迭代
       }
       file.delete();//删除文件夹
      }
      file.mkdirs();
      return true;
     } else {
    	 file.mkdirs();
      System.out.println("所删除的文件不存在");
      return false;
     }
    }
	public boolean createFile(String filename){
		System.out.println(filename);
		File file =new File(filename);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}else{
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {			
				e.printStackTrace();
				return false;
			}
		}
		System.out.println("create file successed!");
		return true;
	}
	
	
	public boolean createApplicationTable(String vilname,List<String> items, List<String> data) throws IOException{
		//studentname=new String(studentname.getBytes(),"UTF-8");
		
		String filename=vilname+".doc";
		//username = new String(username.getBytes("ISO-8859-1“), "UTF-8");
		//filename=new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		String applicationtable=applicationfilepath+filename;
		System.out.println(applicationtable);

	//	if(!this.initApplicationTableFile(filename)) return false;
		//Java2Word document=new Java2Word();
		//document.open(applicationtable);
		System.out.println("items size:"+items.size()+"    "+"data size:"+data.size());
		//for(int i=0;i<items.size();i++){

	//	if(!this.initApplicationTableFile(filename)) return false;
	//	Java2Word document=new Java2Word();
		//document.open(applicationtable);
		//for(int i=0;i<items.size();i++){

			//document.conv(applicationtable, items, data);

			if(!xml2word.changeFileText(template_applicationtable, applicationtable, items, data)) return false;

		//}

		//document.replaceText(applicationtable, "sname", "asdasdas", 1);
//		 
		return true;
	}
	public String getApplicationTablePath(){
		System.out.println(applicationfilepath);
		return this.applicationfilepath;
	}
	public String getApplicationZipPath(){
		System.out.println(applicationzippath);
		return this.applicationzippath;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

	public String getTemplate_applicationtable() {
		return template_applicationtable;
	}

	public void setTemplate_applicationtable(String templateApplicationtable) {
		template_applicationtable = templateApplicationtable;
	}

	public String getApplicationfilepath() {
		return applicationfilepath;
	}

	public void setApplicationfilepath(String applicationfilepath) {
		this.applicationfilepath = applicationfilepath;
	}

	public String getDownloadfilepath() {
		return downloadfilepath;
	}

	public void setDownloadfilepath(String downloadfilepath) {
		this.downloadfilepath = downloadfilepath;
	}

	public String getApplicationzippath() {
		return applicationzippath;
	}

	public void setApplicationzippath(String applicationzippath) {
		this.applicationzippath = applicationzippath;
	}
	
}
