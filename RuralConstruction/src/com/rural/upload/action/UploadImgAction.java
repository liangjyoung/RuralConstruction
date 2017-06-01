package com.rural.upload.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import jxl.read.biff.BiffException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.bean.DataCollDataDic;



public class UploadImgAction  extends ActionSupport{
	    
	   private File file;
	    private String fileFileName;
	    private String fileContentType;
	    private String fileName;
	   // private Map<String, Object> dataMap = new HashMap<String, Object>();
	    
	   // private DataCollDataDicDAO dataCollDataDicDAO = new DataCollDataDicDAO();
	   
	    
	    
	    public File getFile() {
			return file;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public void setFile(File file) {
			this.file = file;
		}

		public String getFileFileName() {
			return fileFileName;
		}

		public void setFileFileName(String fileFileName) {
			this.fileFileName = fileFileName;
		}

		public String getFileContentType() {
			return fileContentType;
		}

		public void setFileContentType(String fileContentType) {
			this.fileContentType = fileContentType;
		}

		public Map<String, Object> getDataMap() {
			return dataMap;
		}

		public void setDataMap(Map<String, Object> dataMap) {
			this.dataMap = dataMap;
		}

		private Map<String, Object> dataMap = new HashMap<String, Object>();
	    
	    public void uploadImg() throws Exception {
			FileInputStream is = null;//基于myFile创建一个文件输入流
			FileOutputStream  os =null;// 创建一个输出流  
			String uploadPath = null;// 设置上传文件目录  
			BufferedImage image = null;
			//BufferedImage imageBuffer = null;  
			try {
		        is = new FileInputStream(file);  
		        uploadPath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/uploadImg");  
		        //目录如果不存在先创建  
		        
		       // image =  ImageIO.read(file);    
		        
		        // 设置目标文件  
		      File toFile = new File(uploadPath, this.getFileFileName());  
		        os = new FileOutputStream(toFile);  
		        //设置缓存  
		        byte[] buffer = new byte[1024];  
		        int length = 0;  
		        //读取myFile文件输出到toFile文件中  
		        while ((length = is.read(buffer)) > 0) {  
		            os.write(buffer, 0, length);  
		        }  
		     // ImageIO.write(image, "jpg",toFile); 
		        //int length = 0;  
		        //读取myFile文件输出到toFile文件中  
		        
		        //System.out.println("上传用户"+1);  
		        //System.out.println("上传文件名"+1);  
		        //System.out.println("上传文件类型"+1);  
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				 //关闭输入流  
		        is.close();  
		        //关闭输出流  
		        os.close(); 
			}
			ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write("图片上传成功！");
			
	       
	    }
	    
	    public String deleteImg() throws Exception {
	    	ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
	    	
	    	  String uploadPath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/uploadImg");  
	    	  this.fileName = new String(this.fileName.getBytes("ISO-8859-1"), "UTF-8"); ;
	        File file = new File(uploadPath, this.fileName);
	         boolean flag = false;  
	         // 路径为文件且不为空则进行删除  
	         if (file.isFile() && file.exists()) {  
	             file.delete();  
	              flag = true;
	         } 
	         if (flag) {
	 			dataMap.put("success", true);
	 			
	 		}else{
	 			dataMap.put("success", false);
	 			
	 		}
	 		
	         return SUCCESS;
	    	
	    }

	       

}
