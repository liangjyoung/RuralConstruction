package com.rural.app.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.joyu.an.bean.BaseDataBean;
import com.opensymphony.xwork2.ActionSupport;
import com.rural.app.service.DownBaseDataService;
import com.rural.app.service.IDownBaseDataService;
import com.rural.table.service.CreateFile;

public class DownBaseDataAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDownBaseDataService iDownBaseDataService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private CreateFile createfile = new CreateFile();
	 
	
	public void setiDownBaseDataService(IDownBaseDataService iDownBaseDataService) {
		this.iDownBaseDataService = iDownBaseDataService;
	}
	public IDownBaseDataService getiDownBaseDataService() {
		return iDownBaseDataService;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	
	
	
	//该属性石依赖注入的属性，可以在配置文件中动态指定该属性
    private String fileNameDownload = "baseData.db";
	public String getFileNameDownload() {
		try {
			return new String(fileNameDownload.getBytes(),"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			return this.fileNameDownload;
		} 
	}

	public void setFileNameDownload(String fileNameDownload) {
		try {
			this.fileNameDownload = new String(fileNameDownload.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
		} 
	}
	
	//返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流  
	public InputStream getIsssss() throws Exception{
		String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("");
		System.out.println("----------->"+path+this.createfile.getDownloadfilepath() + fileNameDownload);
	   InputStream in = ServletActionContext.getServletContext().getResourceAsStream("//download//"+ fileNameDownload);
	   if (in == null) {  
           in = new ByteArrayInputStream("没有发现文件!".getBytes());  
       }  
	   return in;
	}
	
	
	
	

	public String aa(){
		String message ="";
	        dataMap.put("success",true);
			//JSONArray.fromObject(iDownBaseDataService.downApp()));
			return SUCCESS;
	}
	
	/** 
	 * java.io.ObjectOutputStream 
	 * 对象输出流,时一个高级流,作用是可以直接将java 
	 * 中的一个对象转换为一组字节后写出,这组字节的格式由ObjectOutputStream维护 
	 * 若希望该对象可以被写出,那么前提是该对象所属的类必须实现Serializable接口 
	 *  
	 * 该方法涉及到两个操作 
	 * 1.将对象转换为一组字节 
	 * 2.将该组字节写入到文件中(硬盘上) 
	 * 上面的操作称为数据持久化 
	 * @author  bx
	 */ 
	@SuppressWarnings("finally")
	public String downApp(){
		String message ="";
		BaseDataBean baseDataBean = new BaseDataBean();
		baseDataBean =iDownBaseDataService.downApp();
		FileOutputStream fos=null;  
        ObjectOutputStream oos=null; 
        try {
        	String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("");
        	 fos = new FileOutputStream(new File(path+this.createfile.getDownloadfilepath()+"baseData.db"));  
             oos=new ObjectOutputStream(fos);  
             oos.writeObject(baseDataBean);  
             /* 
              * oos的writeObject方法的作用 
              * 将给定的java对象转换为一组字节后写出 
              * 这里由于oos时装载FileOutputStream上的 
              * 所以转换的这组字节最终通过FileOutputStream写入到了文件中 
              * 
             
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/baseData.db"));  
             BaseDataBean baseDataBeanw = (BaseDataBean)ois.readObject();
             System.out.println(JSONArray.fromObject(baseDataBeanw));  */
            
		} catch (FileNotFoundException e) {  
			  dataMap.put("success", "文件不存在");
			e.printStackTrace();  
        } catch (IOException e) {  
        	  dataMap.put("success", "IO流输出错误");
        	e.printStackTrace();  
            
        }finally{  
            try {  
            	 oos.flush();  
                 oos.close();  
                 fos.close();
                dataMap.put("success", true);
              //  dataMap.put("progress", DownBaseDataService.handleRows);
            } catch (IOException e) {  
            	dataMap.put("success", "out.close错误");
            	e.printStackTrace(); 
              
            }
        
		//JSONArray.fromObject(iDownBaseDataService.downApp()));
		return SUCCESS;
	}
	}
	public void setCreatefile(CreateFile createfile) {
		this.createfile = createfile;
	}
	public CreateFile getCreatefile() {
		return createfile;
	}
}
