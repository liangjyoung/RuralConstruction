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

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
public class UploadCountryAction extends ActionSupport{
	
	private static final long serialVersionUID = -6733917803047908597L;
    private File file;
    private String fileFileName;
    private String fileContentType;
    
    private Map<String, Object> dataMap = new HashMap<String, Object>();
    public static int totalRows = 0;
    public static int handleRows = 0;
    
    private CountryBasicInfoDAO  countryBasicInfoDAO = new CountryBasicInfoDAO();
    private CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
    
    
    public int getCityID(String cityNum){
    	int a = 0;
    	List<CityBasicInfo> city = new ArrayList<CityBasicInfo>();
    	city = this.cityBasicInfoDAO.findByProperty1("cityNum", cityNum.trim());
    	if(city.size()>0){
    		for(CityBasicInfo cityBasicInfo:city){
    			a = cityBasicInfo.getCityBasicInfoId();
    		}
    	}
    	System.out.println("--------->"+a);
    	return a;
    
    }
    
    public void uploadCountry() throws Exception{
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
        
        Integer insertCount = 0;
        Integer updateCount = 0;
        String cityNum = "";
        String countryNum = "";
        String countryName= "";
        String countryLongi = "";
        String countryLati = "";
        String countryMeas = "";
        String countryPop = "";
        String countryHholds="";
        byte[] countryIntro;
        
        try{
        	
        	String errorInformation = "";
        	String errorInfo = "";
        	CountryBasicInfo countryBasicInfo = new CountryBasicInfo();
        	CityBasicInfo cityBasicInfo = new CityBasicInfo();
        	 Sheet[] sheet = workBook.getSheets();
             int sheet_i_num = 0;// 获取工作表格的行数
             int sheet_j_num = 0;// 获取表格的列数
             String name = "";// 用来得到每一个单元格的内容,下面用到.
             
             if (sheet != null && sheet.length > 0){
            	 for (int sheetNum = 0; sheetNum < 1; sheetNum++){
            		// 获得有多少个工作表格,对每一个操作 (3.1这里首先要得到要读取的工作表格有多少行.)
                     sheet_i_num = sheet[sheetNum].getRows() - 1;
                     totalRows = sheet_i_num;
                     sheet_j_num = sheet[sheetNum].getColumns();
                     // 接下来就是对每一行进行的去数据了,此处从rowNum = 1开始,第一行一般是标题

                     Cell cell0 = sheet[sheetNum].getCell(0, 0);
                     
                     boolean flagg=false;
                     if (!"所属市级编码(市.00.00.000)".equals(cell0.getContents().trim()))
                     {
                         errorInformation += "数据导入失败,请确认是否未使用模版--所属市级编码(市.00.00.000)"+" ";
                     	//out.write(errorInformation);
                     	//return;
                         flagg=true;
                     }
                     Cell cell1 = sheet[sheetNum].getCell(1, 0);
                     if (!"编号(市.县.00.000)".equals(cell1.getContents().trim()))
                     {
                     	if(flagg){
                    		 errorInformation += "是否未使用模版--编号(市.县.00.000))"+" ";
                    	}else{
                         errorInformation += "数据导入失败,请确认是否未使用模版--编号(市.县.00.000)"+" ";
                     	}
                         flagg=true;
                     }
                     Cell cell2 = sheet[sheetNum].getCell(2, 0);
                     if (!"名称".equals(cell2.getContents().trim()))
                     {
                     	if(flagg){
                       		 errorInformation += "是否未使用模版--名称"+" ";
                       	}else{
                         errorInformation += "数据导入失败,请确认是否未使用模版--名称"+" ";
                     	//out.write(errorInformation);
                     	//return;
                       	}
                         flagg=true;
                     }
                     Cell cell3 = sheet[sheetNum].getCell(3, 0);
                     if (!"经度".equals(cell3.getContents().trim()))
                     {
                     	if(flagg){
                       		 errorInformation += "是否未使用模版--经度"+" ";
                       	}else{
                         errorInformation += "数据导入失败,请确认是否未使用模版--经度"+" ";
                     	//out.write(errorInformation);
                     	//return;
                       	}
                         flagg=true;
                     }
                     Cell cell4 = sheet[sheetNum].getCell(4, 0);
                     if (!"纬度".equals(cell4.getContents().trim()))
                     {
                     	if(flagg){
                       		 errorInformation += "是否未使用模版--纬度"+" ";
                       	}else{
                         errorInformation += "数据导入失败,请确认是否未使用模版--纬度"+" ";
                     	//out.write(errorInformation);
                     	//return;
                       	}
                         flagg=true;
                     }
                     
                     Cell cell5 = sheet[sheetNum].getCell(5, 0);
                     if (!"面积(平方公里)".equals(cell5.getContents().trim()))
                     {
                     	if(flagg){
                       		 errorInformation += "是否未使用模版--面积(平方公里)"+" ";
                       	}else{
                         errorInformation += "数据导入失败,请确认是否未使用模版--面积(平方公里)"+" ";
                     	//out.write(errorInformation);
                     	//return;
                       	}
                         flagg=true;
                     }
                     Cell cell6 = sheet[sheetNum].getCell(6, 0);
                     if (!"人口数(万人)".equals(cell6.getContents().trim()))
                     {
                     	if(flagg){
                       		 errorInformation += "是否未使用模版--人口数(万人)"+" ";
                       	}else{
                         errorInformation += "数据导入失败,请确认是否未使用模版--人口数(万人)"+" ";
                     	//out.write(errorInformation);
                     	//return;
                       	}
                         flagg=true;
                     }
                     Cell cell7 = sheet[sheetNum].getCell(7, 0);
                     if (!"户数".equals(cell7.getContents().trim()))
                     {
                     	if(flagg){
                       		 errorInformation += "是否未使用模版--户数"+" ";
                       	}else{
                         errorInformation += "数据导入失败,请确认是否未使用模版--户数"+" ";
                     	//out.write(errorInformation);
                     	//return;
                       	}
                         flagg=true;
                     }
                     Cell cell8 = sheet[sheetNum].getCell(8, 0);
                     if (!"简介".equals(cell8.getContents().trim()))
                     {
                     	if(flagg){
                       		 errorInformation += "是否未使用模版--简介"+" ";
                       	}else{
                         errorInformation += "数据导入失败,请确认是否未使用模版--简介"+" ";
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
                         
                         countryBasicInfo = new CountryBasicInfo();
                         cityBasicInfo = new CityBasicInfo();
                         for (colNum = 0; colNum < sheet_j_num; colNum++)
                         {
                             Cell cell = sheet[sheetNum].getCell(colNum, rowNum);
                            
                             name = cell.getContents().trim();
                             
                             if (colNum == 0)
                             {
                                 if ("".equals(name.trim()) || name == null)
                                 {
                                     errorInformation += "所属市级编码(市.00.00.000)--不能为空"+" ";
                                     //out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation);
                                     flag = true;
                                 }
                                 else
                                 {
                                 	
                                 	cityNum = name;
                                 	if(this.getCityID(cityNum)==0){
                                 		errorInfo = "此县(区)所属市并不存在，请先导入相对应的市"+" ";
                                 		flg = true;
                                 	}
                                 	else{
                                 		cityBasicInfo.setCityBasicInfoId(this.getCityID(cityNum));
                                 	}
                           	  		
                                 }
                                 	
                                 countryBasicInfo.setCityBasicInfo(cityBasicInfo);
                              }
                             
                             if (colNum == 1) {
                             	if ("".equals(name.trim()) || name == null)
                                 {
                                     errorInformation += "编号(市.县.00.000)--不能为空"+" ";
                                     //out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation);
                                     flag = true;
                                 }
                                 else
                                 {
                                 	//dicEntryCode = name;
                                 	List<CountryBasicInfo> country = countryBasicInfoDAO.findByProperty1("countryNum", countryNum);
                                 	if(country.size()>0){
                                 		for(CountryBasicInfo c:country){
                                 			countryBasicInfo.setCountryBasicInfoId(c.getCountryBasicInfoId());
                                 			countryBasicInfo.setCityBasicInfo(c.getCityBasicInfo());
                                 		}
                                 		updateCount += 1;
                                 			
                                 		
                                 	}
                                 	countryNum = name;
                                 }
                             	countryBasicInfo.setCountryNum(countryNum);
 							}
                             
                             
                             if (colNum == 2) {
                             	if ("".equals(name.trim()) || name == null)
                                 {
                                     errorInformation += "名称--不能为空"+" ";
                                     //out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation);
                                     flag = true;
                                 }
                                 else
                                 {
                                	 countryName = name;
                                 	
                                 }
                             	countryBasicInfo.setCountryName(countryName);
 							}
                             
                             if (colNum == 3) {
                              	
                            	 countryLongi = name;
                                 
                              	countryBasicInfo.setCountryLongi(countryLongi);
  							}
                             
                             if (colNum == 4) {
                               	
                            	 countryLati = name;
                                 
                              	countryBasicInfo.setCountryLati(countryLati);
  							}
                             
                             if (colNum == 5) {
                               	
                            	 countryMeas = name;
                                 
                            	 countryBasicInfo.setCountryMeas(countryMeas);
  							}
                             
                             if (colNum == 6) {
                               	
                            	 countryPop = name;
                                 
                            	 countryBasicInfo.setCountryPop(countryPop);
  							}
                             
                             if (colNum == 7) {
                               	
                            	 countryHholds = name;
                                 
                            	 countryBasicInfo.setCountryHholds(countryHholds);
  							}
                             
                             if (colNum == 8) {
                                try{	
                                	countryIntro = name.getBytes("utf-8");
                                 
                                	countryBasicInfo.setCountryIntro(countryIntro);
                                }catch(UnsupportedEncodingException e){
                        			
                        			e.printStackTrace();
                        		 }
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
 							countryBasicInfoDAO.attachDirty(countryBasicInfo);
 					    	}
                         
                     }
            		 
            	 }
             }
             out.write("。"+"成功导入数据:共插入" + insertCount + "条，修改" + updateCount + "条。");
         	return;
        	
        } catch (Exception e)
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
    private String fileNameDownload = "县（区）级区划模板.xls";
	
    //返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流  
	public InputStream getIsss() throws Exception{
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

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}

	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}

	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}

	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
	}
	
	


}