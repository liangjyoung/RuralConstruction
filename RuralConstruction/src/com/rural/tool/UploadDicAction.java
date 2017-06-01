package com.rural.tool;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
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
import com.rural.dao.DataCollDataDicDAO;


public class UploadDicAction extends ActionSupport{
	
	private static final long serialVersionUID = -6733917803047908597L;
    private File file;
    private String fileFileName;
    private String fileContentType;
    private DataCollDataDicDAO dataCollDataDicDAO = new DataCollDataDicDAO();
   
    private Map<String, Object> dataMap = new HashMap<String, Object>();
    public static int totalRows = 0;
    public static int handleRows = 0;
   // private IAddUserService studentService;

    
	public void upload() throws Exception {
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
       
       
        String dataDicName = ""; 
        boolean isdChoDic = false; 
        //String num = "";
       // String name = "";
       //boolean choDic = false;
        Integer insertCount = 0;
        Integer updateCount = 0;
       
        try
        {
        	String errorInformation = "";
        	DataCollDataDic dataCollDataDic = new DataCollDataDic();
       
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
                    if (!"数据字典编码".equals(cell0.getContents().trim()))
                    {
                        errorInformation = "数据导入失败,请确认是否未使用模版--数据字典编码";
                    	out.write(errorInformation);
                    	return;
                    }
                    Cell cell1 = sheet[sheetNum].getCell(1, 0);
                    if (!"数据字典名称".equals(cell1.getContents().trim()))
                    {
                        errorInformation = "数据导入失败,请确认是否未使用模版--数据字典名称";
                    	out.write(errorInformation);
                    	return;
                    }
                    Cell cell2 = sheet[sheetNum].getCell(2, 0);
                    if (!"是否多选".equals(cell2.getContents().trim()))
                    {
                        errorInformation = "数据导入失败,请确认是否未使用模版--是否多选";
                    	out.write(errorInformation);
                    	return;
                    }
                   
                    
                    boolean flag = false;
                    for (int rowNum = 1; rowNum <= sheet_i_num; rowNum++)
                    {
                    	flag = false;
                    	handleRows = rowNum;
                        int colNum = 0;
                       dataCollDataDic = new DataCollDataDic();
                        for (colNum = 0; colNum < sheet_j_num; colNum++)
                        {
                            Cell cell = sheet[sheetNum].getCell(colNum, rowNum);
                           
                            name = cell.getContents().trim();
                            if (colNum == 0)
                            {
                                if ("".equals(name.trim()) || name == null)
                                {
                                    errorInformation = "字典编码--不能为空";
                                    //out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation);
                                    flag = true;
                                }
                                else
                                {
                                	//dataDicCode = name;
                                	List<DataCollDataDic> dic = dataCollDataDicDAO.findByDataDicCode(name);
                                	if(dic.size()>0){
                                		for(DataCollDataDic d:dic)
                                			dataCollDataDic.setDataCollDataDicId(d.getDataCollDataDicId());
                                		updateCount += 1;
                                	}
                                	dataDicCode = name;
                                	
                                }
                                dataCollDataDic.setDataDicCode(dataDicCode);
                            }
                            if (colNum == 1) {
                            	if ("".equals(name.trim()) || name == null)
                                {
                                    errorInformation = "字典名称--不能为空";
                                    //out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation);
                                    flag = true;
                                }
                                else
                                {
                                	dataDicName = name;
                                }
                                dataCollDataDic.setDataDicName(dataDicName);
							}
                            if (colNum == 2) {
                            	if ("".equals(name.trim()) || name == null)
                                {
                                    errorInformation = "是否多选--不能为空";
                                    //out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation);
                                    flag = true;
                                }
                                else
                                {
                                	isdChoDic = Boolean.parseBoolean(name);
                                	
                                }
                            	 dataCollDataDic.setIsdChoDic(isdChoDic);
							}
                   
                            
                        }
                        
                        if (flag) {
                        	String message = "\r\n字典编码："+dataDicCode + "\r\n字典名称：" + dataDicName + "\r\n是否多选：" + isdChoDic;
                        	out.write("数据导入失败,第"+ (rowNum + 1) + "行"+ errorInformation+"\r\n数据信息如下：" + message);
							return;
						}
                       
							insertCount += 1;
							dataCollDataDicDAO.attachDirty(dataCollDataDic);
							
						}
                    }
                }
    		out.write("数据导入成功！共插入" + insertCount + "条，修改" + updateCount + "条。");
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

}
