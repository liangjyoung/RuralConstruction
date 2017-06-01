package com.rural.download;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.rural.bean.EvalContInvesObj;
import com.rural.bean.VilFilData;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.EvalExpertDistDAO;
import com.rural.dao.VilFilDataDAO;

/**
* @ClassName: ListFileServlet
* @Description: 列出Web系统中所有下载文件
* @author: 孤傲苍狼
* @date: 2015-1-4 下午9:54:40
*
*/ 
public class ListFileServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
	@Autowired
	private EvalExpertDistDAO evalExpertDistDAO = new EvalExpertDistDAO();

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		Integer distID = Integer.parseInt(request.getParameter("distID"));
		Integer evalContID = Integer.parseInt(request.getParameter("contID"));
		System.out.println("distID="+distID+",contID="+evalContID);
//		EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
//		EvalExpertDistDAO evalExpertDistDAO = new EvalExpertDistDAO();
		List<EvalContInvesObj> methObjs = new ArrayList<EvalContInvesObj>();
		methObjs = evalContInvesObjDAO.findByProperty("evalCont.evalContId", evalContID);
		//根据expertDistID得到所有的“村庄数据采集记录”
		Integer vilDataCollRecID = evalExpertDistDAO.findById(distID).getVilEvalSco().getVilDataCollRec().getVilDataCollRecId();
        //获取上传文件的目录
//        String uploadFilePath = this.getServletContext().getRealPath("/uploadFile");
        //存储要下载的文件名
        Map<String,String> fileNameMap = new HashMap<String,String>();
        //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
//        listfile(new File(uploadFilePath),fileNameMap);//File既可以代表一个文件也可以代表一个目录
        listfile(fileNameMap, vilDataCollRecID, methObjs);
        //将Map集合发送到listfile.jsp页面进行显示
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/rural/VillBuildEval/listfile.jsp").forward(request, response);
    }
    
//    /**
//    * @Method: listfile
//    * @Description: 递归遍历指定目录下的所有文件
//    * @Anthor:孤傲苍狼
//    * @param file 即代表一个文件，也代表一个文件目录
//    * @param map 存储文件名的Map集合
//    */ 
//    public void listfile(File file,Map<String,String> map){
//        //如果file代表的不是一个文件，而是一个目录
//        if(!file.isFile()){
//            //列出该目录下的所有文件和目录
//            File files[] = file.listFiles();
//            //遍历files[]数组
//            for(File f : files){
//                //递归
//                listfile(f,map);
//            }
//        }else{
//            /**
//             * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
//                file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
//                那么file.getName().substring(file.getName().indexOf("_")+1)处理之后就可以得到阿_凡_达.avi部分
//             */
//            String realName = file.getName().substring(file.getName().indexOf("_")+1);
//            //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
//            map.put(file.getName(), realName);
//        }
//    	
//    }
    /**
     * 根据“村庄数据采集记录ID”和“调查对象ID”查询数据库中对应的“文件标识”
     */
    private void listfile(Map<String, String> fileNameMap, Integer vilDataCollRecID, List<EvalContInvesObj> methObjs) {
		VilFilDataDAO vilFilDataDAO = new VilFilDataDAO();
		List<VilFilData> vilFilDatas = new ArrayList<VilFilData>();
		String sql = "InvesObjID in (";
		for(EvalContInvesObj methObj : methObjs){
			sql += ("'" + methObj.getInvesObj().getInvesObjId() + "',"); 
		}
		sql += "'')";
		sql += " and VilDataCollRecID = " + vilDataCollRecID;
		vilFilDatas = vilFilDataDAO.findBySql(sql);
		//存在相应的记录
		if(vilFilDatas.size() > 0){
			for(VilFilData vilFilData : vilFilDatas){
				String vilFilIdef = vilFilData.getVilFilIdef();
				if(vilFilIdef != null && vilFilIdef != "")
					fileNameMap.put(vilFilIdef, vilFilIdef);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}

	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

	public EvalExpertDistDAO getEvalExpertDistDAO() {
		return evalExpertDistDAO;
	}

	public void setEvalExpertDistDAO(EvalExpertDistDAO evalExpertDistDAO) {
		this.evalExpertDistDAO = evalExpertDistDAO;
	}
	

}