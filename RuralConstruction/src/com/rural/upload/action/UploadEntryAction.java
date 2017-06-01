package com.rural.upload.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.bean.DataCollDataDic;
import com.rural.bean.DataCollDicEntry;
import com.rural.dao.DataCollDataDicDAO;
import com.rural.dao.DataCollDicEntryDAO;

public class UploadEntryAction extends ActionSupport{

	private static final long serialVersionUID = -6733917803047908597L;
    private File file;
    private String fileFileName;
    private String fileContentType;
    private DataCollDataDicDAO dataCollDataDicDAO = new DataCollDataDicDAO();
    private DataCollDicEntryDAO dataCollDicEntryDAO = new DataCollDicEntryDAO();
   
    private Map<String, Object> dataMap = new HashMap<String, Object>();
    public static int totalRows = 0;
    public static int handleRows = 0;
   // private IAddUserService studentService;
    
    
	public int getDicID(String dataDicCode){
		int a =0 ;
		List<DataCollDataDic> dic = new ArrayList<DataCollDataDic>();
		dic = this.dataCollDataDicDAO.findByProperty1("dataDicCode", dataDicCode.trim());
		if(dic.size()>0){
		for (DataCollDataDic dataCollDataDic : dic) {
			a = dataCollDataDic.getDataCollDataDicId();
		}
	  }
		System.out.println("--------->"+a);
		return a;
		
	}

    
	public void uploadEntry() throws Exception {
		InputStream is = null;//基于myFile创建一个文件输入流
		OutputStream os =null;// 创建一个输出流  
		String uploadPath = null;// 设置上传文件目录  
		try {
	        is = new FileInputStream(file);  
	        uploadPath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/uploadFile");  
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
        File importExcel = new File(uploadPath+"\\"+fileFileName);
        Workbook workBook = null;
        if (!importExcel.exists())
        {
        	out.write("找不到指定的文件");
        	return;
        }

        try
        {
            workBook = Workbook.getWorkbook(importExcel);
        }
        catch (BiffException e2)
        {
        	out.write("找不到指定的文件");
        	return;
        }
        String dataDicCode = "" ;
       
       String dicEntryCode = "";
        String dicEntryName = ""; 
        
       // boolean isdChoDic = false; 
        //String num = "";
       // String name = "";
       //boolean choDic = false;
        Integer insertCount = 0;
        Integer updateCount = 0;
       
        try
        {
        	String errorInformation = "";
        	String errorInfo = "";
        	DataCollDataDic dataCollDataDic = new DataCollDataDic();
        	DataCollDicEntry dataCollDicEntry = new DataCollDicEntry();
            
            Sheet[] sheet = workBook.getSheets();
            int sheet_i_num = 0;// 获取工作表格的行数
            int sheet_j_num = 0;// 获取表格的列数
            String name = "";// 用来得到每一个单元格的内容,下面用到.
            boolean isChois;
            if (sheet != null && sheet.length > 0)
            {// 判断一下
                for (int sheetNum = 0; sheetNum < 1; sheetNum++)
                {// 获得有多少个工作表格,对每一个操作 (3.1这里首先要得到要读取的工作表格有多少行.)
                    sheet_i_num = sheet[sheetNum].getRows() - 1;
                    totalRows = sheet_i_num;
                    sheet_j_num = sheet[sheetNum].getColumns();
                    // 接下来就是对每一行进行的去数据了,此处从rowNum = 1开始,第一行一般是标题

                    Cell cell0 = sheet[sheetNum].getCell(0, 0);
                    
                    boolean flagg=false;
                    
                    
                    if (!"数据字典编码(A01)".equals(cell0.getContents().trim()))
                    {
                        errorInformation += "数据导入失败,请确认是否未使用模版--数据字典编码(A01)"+" ";
                    	//out.write(errorInformation);
                    	//return;
                        flagg=true;
                    }
                    Cell cell1 = sheet[sheetNum].getCell(1, 0);
                    if (!"数据字典条目编码(A01.01)".equals(cell1.getContents().trim()))
                    {
                    	if(flagg){
                   		 errorInformation += "是否未使用模版--数据字典条目编码(A01.01)"+" ";
                   	}else{
                        errorInformation += "数据导入失败,请确认是否未使用模版--数据字典条目编码(A01.01)"+" ";
                    	//out.write(errorInformation);
                    	//return;
                    	}
                        flagg=true;
                    }
                    Cell cell2 = sheet[sheetNum].getCell(2, 0);
                    if (!"数据字典条目名称".equals(cell2.getContents().trim()))
                    {
                    	if(flagg){
                      		 errorInformation += "是否未使用模版--数据字典条目名称"+" ";
                      	}else{
                        errorInformation += "数据导入失败,请确认是否未使用模版--数据字典条目名称"+" ";
                    	//out.write(errorInformation);
                    	//return;
                      	}
                        flagg=true;
                    }
                    
                    if(flagg){
                    	out.write(errorInformation);
                    	return;
                    	
                    }
                   
                    
                    boolean flag = false;
                    boolean flg = false;
                    int flagNum = 0;
                    int flgNum =0;
                    for (int rowNum = 1; rowNum <= sheet_i_num; rowNum++)
                    {
                    	flag = false;
                    	handleRows = rowNum;
                        int colNum = 0;
                        dataCollDicEntry = new DataCollDicEntry();
                        dataCollDataDic = new DataCollDataDic();
                        for (colNum = 0; colNum < sheet_j_num; colNum++)
                        {
                            Cell cell = sheet[sheetNum].getCell(colNum, rowNum);
                           
                            name = cell.getContents().trim();
                            if (colNum == 0)
                            {
                                if ("".equals(name.trim()) || name == null)
                                {
                                    errorInformation = "数据字典编码(A01)--不能为空"+" ";
                                    //out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation);
                                    flag = true;
                                }
                                else
                                {
                                	/*
                                	int a = this.getDicID(name);
                                	List<DataCollDicEntry> entry = dataCollDicEntryDAO.findByProperty1("dataCollDataDic.dataCollDataDicId", a);
                                	if(entry.size()>0){
                                		for(DataCollDicEntry d:entry){
                                		dataCollDicEntry.setDataCollDicEntryId(d.getDataCollDicEntryId());
                                		dataCollDicEntry.setDataCollDataDic(d.getDataCollDataDic());
                                		
                                		}
                                		
                                		
                                	}
                                	*/
                                	dataDicCode = name;
                                	if(this.getDicID(dataDicCode)==0){
                                		errorInfo = "此条数据字典条目所属的数据字典并不存在，请先导入相对应的数据字典"+" ";
                                		flg = true;
                                		
                                	}else{
                                	dataCollDataDic.setDataCollDataDicId(this.getDicID(dataDicCode));
                                	}
                          	  		
                                }
                                	
                                dataCollDicEntry.setDataCollDataDic(dataCollDataDic);	
                             }
  
                            if (colNum == 1) {
                            	if ("".equals(name.trim()) || name == null)
                                {
                                    errorInformation = "数据字典条目编码(A01.01)--不能为空"+" ";
                                    //out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation);
                                    flag = true;
                                }
                                else
                                {
                                	//dicEntryCode = name;
                                	List<DataCollDicEntry> entry1 = dataCollDicEntryDAO.findByDicEntryCode(name);
                                	if(entry1.size()>0){
                                		for(DataCollDicEntry a:entry1){
                                			dataCollDicEntry.setDataCollDicEntryId(a.getDataCollDicEntryId());
                                			dataCollDicEntry.setDataCollDataDic(a.getDataCollDataDic());
                                		}
                                		updateCount += 1;
                                			
                                		
                                	}
                                	dicEntryCode = name;
                                }
                            	dataCollDicEntry.setDicEntryCode(dicEntryCode);
							}
                            if (colNum == 2) {
                            	if ("".equals(name.trim()) || name == null)
                                {
                                    errorInformation = "数据字典条目名称--不能为空"+" ";
                                    //out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation);
                                    flag = true;
                                }
                                else
                                {
                                	dicEntryName = name;
                                	
                                }
                            	dataCollDicEntry.setDicEntryName(dicEntryName);
							}
                   
                            
                        }
                        
                        if (flag) {
                        	//String message = "\r\n数据字典编码："+dataDicCode + "\r\n数据字典条目编码：" + dicEntryCode + "\r\n数据字典条目名称：" + dicEntryName;
                        	if(flagNum==0){
                        	out.write("失败导入数据:第"+ (rowNum + 1) + "行"+", "+ errorInformation+" "+"\r\n" );
                        	}else{
                        		out.write("第"+ (rowNum + 1) + "行"+" ,"+ errorInformation+" "+"\r\n" );
                        	}
                        	flagNum++;
						}
                        if(flg){
                        	if(flgNum==0){
                        		out.write("失败导入数据:第"+ (rowNum + 1) + "行"+" ,"+ errorInfo+" "+"\r\n" );
                        		
                        	}else{
                        		
                        	    out.write("第"+ (rowNum + 1) + "行"+", "+ errorInfo+" "+"\r\n" );
                        	}
                        	flgNum++;
                        }
                        if(!(flag)&&!(flg)){
                       
							insertCount += 1;
							dataCollDicEntryDAO.attachDirty(dataCollDicEntry);
					    	}
							
						}
                    }
                }
    		out.write("。"+"成功导入数据:共插入" + insertCount + "条，修改" + updateCount + "条。");
        	return;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            out.write("数据导入失败,请联系管理员，解决问题");
        }
        finally
        {
            if (workBook != null)
            {
                workBook.close();
            }
        }
		return;
	}
	
	
	//该属性石依赖注入的属性，可以在配置文件中动态指定该属性
    private String fileNameDownload = "数据字典条目模板.xls";
	
    //返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流  
	public InputStream getIs() throws Exception{
	   InputStream in = ServletActionContext.getServletContext().getResourceAsStream("//download//" + fileNameDownload);
	   if (in == null) {  
           in = new ByteArrayInputStream("没有发现文件!".getBytes());  
       }  
	   return in;
	}
	
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


	public File getFile() {
		return file;
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


	public DataCollDataDicDAO getDataCollDataDicDAO() {
		return dataCollDataDicDAO;
	}


	public void setDataCollDataDicDAO(DataCollDataDicDAO dataCollDataDicDAO) {
		this.dataCollDataDicDAO = dataCollDataDicDAO;
	}


	public Map<String, Object> getDataMap() {
		return dataMap;
	}


	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}


	public DataCollDicEntryDAO getDataCollDicEntryDAO() {
		return dataCollDicEntryDAO;
	}


	public void setDataCollDicEntryDAO(DataCollDicEntryDAO dataCollDicEntryDAO) {
		this.dataCollDicEntryDAO = dataCollDicEntryDAO;
	}
	
	
	
}
