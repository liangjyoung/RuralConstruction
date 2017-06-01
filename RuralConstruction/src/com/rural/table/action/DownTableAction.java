package com.rural.table.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.table.service.CreateFile;



public class DownTableAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  
	private String fileName;
	private String vilName;
	
	private CreateFile createfile = new CreateFile();
		
		public InputStream getDownloadFile() throws FileNotFoundException,UnsupportedEncodingException {
			 String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("");
			 System.out.println("-------------->"+path+this.createfile.getDownloadfilepath() + getVilName());
			 fileName=URLDecoder.decode(vilName,"utf-8");
			 System.out.println("------ssssss-------->"+path+this.createfile.getDownloadfilepath() + fileName);
				
			 InputStream in = ServletActionContext.getServletContext().getResourceAsStream("//download//"+fileName);
			// InputStream in = Thread.currentThread().getContextClassLoader().getResource(path+this.createfile.getDownloadfilepath() + getVilName()); 
			 if (in == null) {  
		           in = new ByteArrayInputStream("没有发现文件!".getBytes());  
		       }  
			   return in;
			
		}
		

	
		public String getFileName() {
			try {
				this.fileName=getVilName();
				return new String(fileName.getBytes(),"ISO8859-1");
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				System.out.println("getFileName222221111:"+fileName);
			} 
			System.out.println("getFileName:"+fileName);
			return fileName;
		}
		public void setFileName(String fileName) {
			try {
				fileName = getVilName();
				System.out.println("setFileName:"+fileName);
				this.fileName = new String(fileName.getBytes("ISO8859-1"),"utf-8");	
			} catch (UnsupportedEncodingException e) {
				// TODO: handle exception
			}
			
		}
		
	

		public void setCreatefile(CreateFile createfile) {
			this.createfile = createfile;
		}

		public CreateFile getCreatefile() {
			return createfile;
		}



		public void setVilName(String vilName) {
			System.out.println("vilname-------->"+vilName);
			
			try {
				this.vilName = URLDecoder.decode(vilName,"utf-8");
				System.out.println("setvilname-------->"+this.vilName);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//this.vilName = URLDecoder.decode(vilName,"UTF-8");
		}



		public String getVilName() {
			System.out.println("getvilname-------->"+this.vilName);
			return vilName;
		}
	
		
	
	
}
