package com.rural.villageColldData.service;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.joyu.an.bean.UploadDataBean;
import com.joyu.an.bean.data.CollectDataFile;
import com.joyu.an.bean.data.CollectDataItem;
import com.joyu.an.bean.data.EvaluateDataAdvance;
import com.joyu.an.bean.data.EvaluateDataItem;
import com.rural.bean.DataCollDataDic;
import com.rural.bean.DataCollDicEntry;
import com.rural.bean.EvalCont;
import com.rural.bean.EvalContInvesObj;
import com.rural.bean.EvalContSubSco;
import com.rural.bean.InvesObj;
import com.rural.bean.InvesObjData;
import com.rural.bean.InvesPro;
import com.rural.bean.PrmtMeas;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.bean.VilFilData;
import com.rural.dao.DataCollDataDicDAO;
import com.rural.dao.DataCollDicEntryDAO;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.InvesObjDAO;
import com.rural.dao.InvesObjDataDAO;
import com.rural.dao.InvesProDAO;
import com.rural.dao.PrmtMeasDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.dao.VilFilDataDAO;
import com.rural.tool.Criterion;
import com.rural.villageColldData.action.ColldDataDUIXIANGAction;
import com.sun.net.httpserver.Authenticator.Success;

public class ColldDataDUIXIANGService implements IColldDataDUIXIANGService{

	
	private InvesObjDataDAO invesObjDataDAO=new InvesObjDataDAO();
	private VilDataCollRecDAO vilDataCollRecDAO=new VilDataCollRecDAO();
	private InvesObjDAO invesObjDAO=new InvesObjDAO();
	private InvesProDAO invesProDAO = new InvesProDAO();
	private DataCollDicEntryDAO dataCollDicEntryDAO=new DataCollDicEntryDAO();
	private DataCollDataDicDAO dataCollDataDicDAO=new DataCollDataDicDAO();
	private VilBasicInfoDAO vilBasicInfoDAO=new VilBasicInfoDAO();
	private EvalContInvesObjDAO evalContInvesObjDAO=new EvalContInvesObjDAO();
	
	//新加
	private VilFilDataDAO vilFilDataDAO=new VilFilDataDAO();
	private VilEvalScoDAO vilEvalScoDAO=new VilEvalScoDAO();
	private EvalContSubScoDAO evalContSubScoDAO= new EvalContSubScoDAO();
	private EvalContDAO evalContDAO =new EvalContDAO();
	private PrmtMeasDAO prmtMeasDAO = new PrmtMeasDAO();
public String UploadFile(String vfile1, int InvesObjId, int VilDataCollRecId) {
		String ssdd="cheng";
	 String uploadPath12 = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/uploadImg/"+vfile1);
	 VilFilData  vilFilData=new VilFilData();
		
		InvesObj  invesObj=new InvesObj();
		
		VilDataCollRec vilDataCollRec=new VilDataCollRec();
		
		invesObj=invesObjDAO.findById(InvesObjId);
		
		vilDataCollRec=vilDataCollRecDAO.findById(VilDataCollRecId);
		vilFilData.setVilFilIdef(uploadPath12);
		vilFilData.setInvesObj(invesObj);
		vilFilData.setVilDataCollRec(vilDataCollRec);
		vilFilDataDAO.save(vilFilData);
		return ssdd;
	}
	Comparator c = new Comparator<VilDataCollRec>() {  
        public int compare(VilDataCollRec v1, VilDataCollRec v2) {  
            // TODO Auto-generated method stub  
        	 int flag = v1.getCollTim().compareTo(v2.getCollTim());  
        	 return flag;  
		    }  
		};   

	    public String UploadData(String filed) throws SQLException{ 	//输入文件标识,根据文件标识找到需要上传的数据。
	    	//读取需要上传的数据
	    	 String uploadPath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/DataInput/"+filed); 
//	    	 String uploadPath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/DataInput/"+"蔺家楼_uploadData_20170411015924.db"); 
	    	 String uploadPath1 = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/uploadImg"); //上传附件时的路径
	    	// uploadPath=uploadPath+"\\"+"蔺家楼_uploadData_20170411015924.db";
	    	 ObjectInputStream ois;
	    	 UploadDataBean UploadData=new UploadDataBean();
	    	 try {
				
					ois = new ObjectInputStream(new FileInputStream(uploadPath));
					UploadData = (UploadDataBean)ois.readObject();
	            
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				e.printStackTrace();
			}
	    	
            
            
	    	//end
	    	//采集数据列表的上传
	    	
	    	//获取日期最近的村庄采集记录ID
   		String divicode=UploadData.getAreaCode();
   		List<VilBasicInfo>  VilBasicInfoList=vilBasicInfoDAO.findByProperty1("vilNum",divicode);
   		VilBasicInfo vilBasicInfo=VilBasicInfoList.get(0);
   		List<VilDataCollRec> vi=vilDataCollRecDAO.findByProperty1("vilBasicInfo.vilBasicInfoId", vilBasicInfo.getVilBasicInfoId());
   		Collections.sort(vi,c);   
   		VilDataCollRec newVilDataCollRec=vi.get(vi.size()-1);
   		newVilDataCollRec.setCollEqptCode(UploadData.getUserCode());
   		vilDataCollRecDAO.attachDirty(newVilDataCollRec);
   		int newVilDataCollRecID=newVilDataCollRec.getVilDataCollRecId();
   		
   	//首先为所有的调查对象插入采集记录
   		List<InvesObj> invesObjList1=invesObjDAO.findAll();
   		for(int i=0;i<invesObjList1.size();i++){
   			List<InvesObjData> invesObjDataList1=invesObjDataDAO.findInvIDAndRecD(newVilDataCollRecID,invesObjList1.get(i).getInvesObjId());
   			if(invesObjDataList1.size()==0){
   				InvesObjData invesObjData= new InvesObjData();
   				invesObjData.setVilDataCollRec(newVilDataCollRec);
   				invesObjData.setInvesObj(invesObjList1.get(i));
   				invesObjDataDAO.attachDirty(invesObjData);
   			}
   		}


	    	//循环插入
   		for(int i=0;i<UploadData.getCollectDataItemList().size();i++){
	    		CollectDataItem collectDataItem=UploadData.getCollectDataItemList().get(i);
	    		List<InvesObj> invesObjList=invesObjDAO.findByInvesObjCode(collectDataItem.getMicode());
	    		InvesObj invesObj=invesObjList.get(0);//根据对象编号获得调查编号
	    		DataCollDataDic dataCollDataDic=invesObj.getDataCollDataDic();//获取采集字典条目
	    		
	    		if(dataCollDataDic==null){//若采集数据字典ID为null，则表示采集数据需要填写，否则为选择
	    			List<InvesObjData> invesObjDataList =invesObjDataDAO.findInvIDAndRecD(newVilDataCollRec.getVilDataCollRecId(),invesObj.getInvesObjId());
	    			InvesObjData invesObjData= new InvesObjData();
	    			if(invesObjDataList.size()!=0){
	    				invesObjData=invesObjDataList.get(0);
	    			}
//   				InvesObjData delInvesObjData=new InvesObjData();
//   	    		delInvesObjData.setVilDataCollRec(newVilDataCollRec);
//   	    		delInvesObjData.setInvesObj(invesObj);
//   	    		invesObjDataDAO.delete1(delInvesObjData);//想要根据条件删除只要新建一个对象，然后给他的村庄记录ID赋值即可根据条件删除；！！！！！！检测
   	    		
	    			invesObjData.setVilDataCollRec(newVilDataCollRec);
	    			invesObjData.setInvesObjDataValu(collectDataItem.getValue());
	    			invesObjData.setInvesObjNote(collectDataItem.getRemark());
	    			invesObjData.setInvesObj(invesObj);
	    			invesObjDataDAO.attachDirty(invesObjData);
	    		}else{
	    			if(dataCollDataDic.getIsdChoDic()==true){
	    				//判断是否多选，若为多选则需要根据‘，’对采集数据进行拆分,然后逐条添加！！！！！！！！懒加载问题
	    				//先删除掉关于该对象的所有多选数据！！！！！！检测删除
	    				InvesObjData delInvesObjData=new InvesObjData();
	    	    		delInvesObjData.setVilDataCollRec(newVilDataCollRec);
	    	    		delInvesObjData.setInvesObj(invesObj);
	    	    		invesObjDataDAO.delete1(delInvesObjData);//想要根据条件删除只要新建一个对象，然后给他的村庄记录ID赋值即可根据条件删除；！！！！！！检测
	    	    		
	    				String[] multchoose =collectDataItem.getValue().split("，");//多选数据用中文逗号分隔
	    				List<DataCollDicEntry> DataCollDicEntryList =dataCollDicEntryDAO.findByDataCollDataDicId(dataCollDataDic.getDataCollDataDicId());
	    				for(DataCollDicEntry dataCollDicEntry : DataCollDicEntryList){
	    					for(int j=0;j<multchoose.length;j++){//多选是逐条插入
	    						if(dataCollDicEntry.getDicEntryName().equals(multchoose[j])){
	    							InvesObjData invesObjData= new InvesObjData();
	    			    			invesObjData.setVilDataCollRec(newVilDataCollRec);
	    			    			invesObjData.setDataCollDicEntry(dataCollDicEntry);
	    			    			invesObjData.setInvesObjNote(collectDataItem.getRemark());
	    			    			invesObjData.setInvesObj(invesObj);
	    			    			invesObjDataDAO.attachDirty(invesObjData);
	    						}
	    					}
	    				}
	    			}else{//表示单选
//	    				InvesObjData delInvesObjData=new InvesObjData();
//	    	    		delInvesObjData.setVilDataCollRec(newVilDataCollRec);
//	    	    		delInvesObjData.setInvesObj(invesObj);
//	    	    		invesObjDataDAO.delete1(delInvesObjData);//想要根据条件删除只要新建一个对象，然后给他的村庄记录ID赋值即可根据条件删除；！！！！！！检测
	    	    		
	    				String choose=collectDataItem.getValue();
	    				List<DataCollDicEntry> DataCollDicEntryList =dataCollDicEntryDAO.findByDataCollDataDicId(dataCollDataDic.getDataCollDataDicId());
	    				for(DataCollDicEntry dataCollDicEntry : DataCollDicEntryList){
	    					if(dataCollDicEntry.getDicEntryName().equals(choose)){
	    						List<InvesObjData> invesObjDataList =invesObjDataDAO.findInvIDAndRecD(newVilDataCollRec.getVilDataCollRecId(),invesObj.getInvesObjId());
	    		    			InvesObjData invesObjData= new InvesObjData();
	    		    			if(invesObjDataList.size()!=0){
	    		    				invesObjData=invesObjDataList.get(0);
	    		    			}
   			    			invesObjData.setVilDataCollRec(newVilDataCollRec);
   			    			invesObjData.setDataCollDicEntry(dataCollDicEntry);
   			    			invesObjData.setInvesObjNote(collectDataItem.getRemark());
   			    			invesObjData.setInvesObj(invesObj);
   			    			invesObjDataDAO.attachDirty(invesObjData);
   						}
	    				}
	    			}
	    		}
	    	}//循环插入end
   		
   		//采集文件（附件）列表的上传
   		for(int i=0;i<UploadData.getCollectDataFileList().size();i++){
   			CollectDataFile collectDataFile=UploadData.getCollectDataFileList().get(i);
   			List<InvesObj> invesObjList=invesObjDAO.findByInvesObjCode(collectDataFile.getMicode());
	    		InvesObj invesObj=invesObjList.get(0);//获得调查对象编号
	    		
	    		List<VilFilData> vilFilDataList =vilFilDataDAO.findRecIDAndInvID(newVilDataCollRec.getVilDataCollRecId(),invesObj.getInvesObjId());
	    		VilFilData vilFilData= new VilFilData();
   			if(vilFilDataList.size()!=0){
   				vilFilData=vilFilDataList.get(0);
   			}
	    		
	    		//！！！！！！！！！！！！！！！！对文件路径的修改，若之前传了需要删除！！！！！！！！！！！
	    		//上传的文件路径是文件存放的相对路径。也就是/acode/fileName，需要对路径进行加，需要确定主路经
	    		vilFilData.setVilDataCollRec(newVilDataCollRec);
	    		vilFilData.setInvesObj(invesObj);
	    		vilFilData.setVilFilIdef(uploadPath1+"\\"+collectDataFile.getAcode()+"\\"+collectDataFile.getFileName());
	    		vilFilData.setVilFilExpl(collectDataFile.getFileTitle());
	    		vilFilDataDAO.attachDirty(vilFilData);
   		}
   		
   		//自评得分直接自己打，不上传
   		invesObjDataDAO.saveScoreAuto(newVilDataCollRecID+"");
   		//诊断提升措施列表的上传
   		List<VilEvalSco> vilEvalScoList= vilEvalScoDAO.findByProperty("vilDataCollRec", newVilDataCollRec);
   		VilEvalSco vilEvalSco=vilEvalScoList.get(0);
   		//List<EvalContSubSco> evalContSubSco =evalContSubScoDAO.findByProperty("VilEvalSco", vilEvalSco);//根据得分ID找到每项评价内容得分
   		
   		for(int i=0;i<UploadData.getEvaluateDataAdvanceList().size();i++){
   			EvaluateDataAdvance evaluateDataAdvance=UploadData.getEvaluateDataAdvanceList().get(i);
   			List<EvalCont> evalContList =evalContDAO.findByEvalContNum(evaluateDataAdvance.getMicode());
   			EvalCont evalCont = evalContList.get(0);
   			List<EvalContSubSco> evalContSubScoList =evalContSubScoDAO.findByContScore(vilEvalSco.getVilEvalScoId(), evalCont.getEvalContId());
   			EvalContSubSco evalContSubSco=evalContSubScoList.get(0);
   			List<PrmtMeas> prmtMeasList=prmtMeasDAO.findByProperty("evalContSubSco", evalContSubSco);
   			PrmtMeas prmtMeas=new PrmtMeas();
   			if(prmtMeasList.size()!=0){
   				prmtMeas=prmtMeasList.get(0);
   			}
   			prmtMeas.setEvalContSubSco(evalContSubSco);
   			prmtMeas.setPrmtMeas(evaluateDataAdvance.getContent());
   			prmtMeas.setPrmtMeasComp(evaluateDataAdvance.getUnit());
   			prmtMeas.setPrmtMeasValue(evaluateDataAdvance.getNumber().toString());
   			prmtMeas.setExpectPrmtSco(evaluateDataAdvance.getScore().toString());
   			prmtMeasDAO.attachDirty(prmtMeas);
   			
   			
   		}
	    	return "SUCCESS";
	    }
	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}

	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}

	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}
	public String UploadApps(String Apps1){
		 // TODO Auto-generated method stub 
		String app="true";
		String uploadPath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/DataInput/"+Apps1);
		String uploadPath2 = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/uploadImg/");
        long startTime=System.currentTimeMillis();  
        try {  
            ZipInputStream Zin=new ZipInputStream(new FileInputStream(uploadPath/*"C:\\Users\\dell1\\Desktop\\Input\\蔺家楼_uploadFile_20170411015924.zip"*/));//输入源zip路径  
            BufferedInputStream Bin=new BufferedInputStream(Zin);  
            String Parent=uploadPath2; //输出路径（文件夹目录）  
            File Fout=null;  
            ZipEntry entry;  
            try {  
                while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){  
                    Fout=new File(Parent,entry.getName());  
                    if(!Fout.exists()){  
                        (new File(Fout.getParent())).mkdirs();  
                    }  
                    FileOutputStream out=new FileOutputStream(Fout);  
                    BufferedOutputStream Bout=new BufferedOutputStream(out);  
                    int b;  
                    while((b=Bin.read())!=-1){  
                        Bout.write(b);  
                    }  
                    Bout.close();  
                    out.close();  
                    System.out.println(Fout+"解压成功");      
                }  
                Bin.close();  
                Zin.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        long endTime=System.currentTimeMillis();  
        System.out.println("耗费时间： "+(endTime-startTime)+" ms");
        return app;
	}
	public String DDD(String sss){
		String ss="";
		try {
			String ddaa=invesObjDataDAO.saveScoreAuto(sss);
			ss=ddaa;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ss;
	}

	public List<InvesPro> getChildPermissions(String parentId) {
		// TODO Auto-generated method stub
		//���parentId���õ����ӽڵ�������û�
		List<InvesPro> list = new ArrayList<InvesPro>();
		if (parentId==null) {
			list = this.invesProDAO.findFather();
		}else{
			list = this.invesProDAO.findChild(parentId);
		}
		return list;
	}
	
	public String addColldDataDUIXIANG3(int InvesObjDataId,int InvesObjId,int VilDataCollRecId,String old2,String old1) {
		// TODO Auto-generated method stub
		InvesObjData  invesObjData=new InvesObjData();
		//��У�ڵ�ʦ��������ѧԺID
		InvesObj  invesObj=new InvesObj();
		
		VilDataCollRec vilDataCollRec=new VilDataCollRec();
		String message = "";
		
		invesObj=invesObjDAO.findById(InvesObjId);
		
		vilDataCollRec=vilDataCollRecDAO.findById(VilDataCollRecId);
		invesObjData.setInvesObj(invesObj);
		invesObjData.setVilDataCollRec(vilDataCollRec);
		invesObjData.setInvesObjDataValu(old2);
		invesObjData.setInvesObjNote(old1);
		message="成功！";
		//invesObjData.setInvesObjDataValu(InvesObjDataValu);
		//invesObjData.setInvesObjNote(InvesObjNote);
		
		invesObjDataDAO.save(invesObjData);
		
		invesObjData = invesObjDataDAO.findById(InvesObjDataId);
		invesObjDataDAO.delete(invesObjData);
		return message;
		
		
	}
	
	public String addColldDataDUIXIANG(int VilDataCollRecId) {
		String sObjID = "";
		
		String message = "";
		//List<InvesObj> fflist = this.invesObjDAO.findByProperty("invesPro.invesProNum", s.trim());//根据点击的父节点ID查询Up为ID的List
		List<InvesObj> fflist = this.invesObjDAO.findAll();
		
			for (InvesObj invesObj : fflist) {
				sObjID = sObjID +invesObj.getInvesObjId().toString()+",";
			}
			//System.out.println("--------->"+sObjID);
		
			sObjID= sObjID.substring(0, sObjID.lastIndexOf(","));
		// TODO Auto-generated method stub
			
		InvesObjData  invesObjData=new InvesObjData();
		//��У�ڵ�ʦ��������ѧԺID
		InvesObj  invesObj=new InvesObj();
		//DataCollDicEntry dataCollDicEntry= new DataCollDicEntry();
		VilDataCollRec vilDataCollRec=new VilDataCollRec();
		for(String b:sObjID.split(",")){
		invesObj=invesObjDAO.findById(Integer.parseInt(b.trim()));
		//dataCollDicEntry=dataCollDicEntryDAO.findById(DataCollDicEntryId);
		vilDataCollRec=vilDataCollRecDAO.findById(VilDataCollRecId);
		invesObjData.setInvesObj(invesObj);
		//invesObjData.setDataCollDicEntry(dataCollDicEntry);
		invesObjData.setVilDataCollRec(vilDataCollRec);
		//invesObjData.setInvesObjDataValu(InvesObjDataValu);
		//invesObjData.setInvesObjNote(InvesObjNote);
		
		invesObjDataDAO.save(invesObjData);
		
			}
		message="成功！";
		return message;
		
	}
	public boolean isAdd(int DataCollDicEntryId){
		InvesObjData  invesObjData=new InvesObjData();
		//String message = "";
		//invgatDwork=null;
		List<?> serList = invesObjDataDAO.findByDataCollDicEntryId(DataCollDicEntryId);
		if (serList != null && serList.size() > 0) {
			invesObjData = (InvesObjData)serList.get(0);
		//System.out.println("--------->"+JSONArray.fromObject(invgatDwork));
			//message = "该村已被分配，不能重复分配!";
			return false;
		}else{
			//message = "可以成功分配!";
			return true;
		}
		
	}
	public boolean isAdd1(int VilDataCollRecId){
		//InvesObjData  invesObjData=new InvesObjData();
		//String message = "";
		//invgatDwork=null;
		List<InvesObjData> serList = invesObjDataDAO.findByVilDataCollRecId1(VilDataCollRecId);
		if (serList != null && serList.size() > 0) {
			//invesObjData = (InvesObjData)serList.get(0);
		//System.out.println("--------->"+JSONArray.fromObject(invgatDwork));
			//message = "该村已被分配，不能重复分配!";
			return false;
		}else{
			//message = "可以成功分配!";
			return true;
		}
		
	}
	
	public String addColldDataDUIXIANG1(int InvesObjDataId,int InvesObjId,int VilDataCollRecId,String DataCollDicEntryId,String old1) {
		// TODO Auto-generated method stub
		InvesObjData  invesObjData=new InvesObjData();
		//��У�ڵ�ʦ��������ѧԺID
		InvesObj  invesObj=new InvesObj();
		DataCollDicEntry dataCollDicEntry= new DataCollDicEntry();
		VilDataCollRec vilDataCollRec=new VilDataCollRec();
		
		/*String hh="";
		List<InvesObjData> listdd=this.invesObjDataDAO.findByProperty("invesObj.invesObjId", InvesObjId);
		for (InvesObjData invesObjData2 : listdd) {
			hh=invesObjData2.getInvesObjDataId().toString()+",";//根据前台的对象Id得到数据表的Id
		}
		String dh="";
		List<InvesObjData> listaa=this.invesObjDataDAO.findByProperty("vilDataCollRec.vilDataCollRecId", VilDataCollRecId);
		for (InvesObjData invesObjData2 : listaa) {
			dh=invesObjData2.getInvesObjDataId().toString()+",";
		}
		String yh=dh+hh;
		System.out.println(yh);
		String[] array = yh.split(",");
	        StringBuilder sb = new StringBuilder();
	        for (String str : array) {
	            if(sb.indexOf(str) != -1){
	                continue;
	            }
	            sb.append(str).append(",");
	        }
	    String newStr = sb.toString().substring(0,sb.length() - 1);
	    System.out.println(newStr);*/
		
		List<InvesObjData> listaa=this.invesObjDataDAO.findInvIDAndRecD1(VilDataCollRecId,InvesObjId);
		
		for (InvesObjData invesObjData2 : listaa) {
			String s=invesObjData2.getInvesObjDataId().toString();
			//System.out.println("-------------------->"+s);
			invesObjData = invesObjDataDAO.findById(Integer.parseInt(s.trim()));
			invesObjDataDAO.delete(invesObjData);
		}
		
		String message = "";
		for(String b:DataCollDicEntryId.split(",")){
		invesObj=invesObjDAO.findById(InvesObjId);
		dataCollDicEntry=dataCollDicEntryDAO.findById(Integer.parseInt(b.trim()));
		vilDataCollRec=vilDataCollRecDAO.findById(VilDataCollRecId);
		invesObjData.setInvesObj(invesObj);
		invesObjData.setVilDataCollRec(vilDataCollRec);
		invesObjData.setDataCollDicEntry(dataCollDicEntry);
		invesObjData.setInvesObjNote(old1);
		message="成功！";
		//invesObjData.setInvesObjDataValu(InvesObjDataValu);
		//invesObjData.setInvesObjNote(InvesObjNote);
		
		invesObjDataDAO.save(invesObjData);
		}
		
		return message;
		
		
	}
	
	public void delColldDataDUIXIANG(int InvesObjDataId) {
		// TODO Auto-generated method stub
		InvesObjData  invesObjData=new InvesObjData();
		invesObjData = invesObjDataDAO.findById(InvesObjDataId);
		invesObjDataDAO.delete(invesObjData);
	}
	
	public void ediColldDataDUIXIANG(int InvesObjDataId,String InvesObjDataValu,String InvesObjNote) {
		// TODO Auto-generated method stub
		InvesObjData  invesObjData=new InvesObjData();
		//��У�ڵ�ʦ��������ѧԺID
		
		
		invesObjData=invesObjDataDAO.findById(InvesObjDataId);
		
		invesObjData.setInvesObjDataValu(InvesObjDataValu);
		invesObjData.setInvesObjNote(InvesObjNote);
		invesObjDataDAO.attachDirty(invesObjData);
	}
	
	

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		String fss = ColldDataDUIXIANGAction.getObjlFSysIDs().trim();//父节点标记
		String ss = ColldDataDUIXIANGAction.getObjlSysIDs().trim();//子节点标记
		String ss1=ColldDataDUIXIANGAction.getJQS1().trim();
		String ss4=ColldDataDUIXIANGAction.getJQS3().trim();
		
		Integer g=0;
		List<VilBasicInfo> listvv=this.vilBasicInfoDAO.findByVilNum(ss1.trim());//获取到村庄
		for (VilBasicInfo vilBasicInfo : listvv) {
			g = vilBasicInfo.getVilBasicInfoId();//获得村庄的id
		}
		List<VilDataCollRec> vd = vilDataCollRecDAO.findNewRec1(g, ss4);//根据村庄id找到采集记录
		//获取采集记录的id
		Integer b =0;
		for (VilDataCollRec vilDataCollRec : vd) {
			b = vilDataCollRec.getVilDataCollRecId();
		}
		//System.out.println(b);
		/*String sObjID1="";
		List<VilBasicInfo> listvv=this.vilBasicInfoDAO.findByVilNum(ss1.trim());
		
		for (VilBasicInfo vilBasicInfo : listvv) {
			sObjID1=sObjID1+VIl(vilBasicInfo.getVilBasicInfoId());
		}
		System.out.println("--------->"+sObjID1);
		sObjID1= sObjID1.substring(0, sObjID1.lastIndexOf(","));*/
		/*if(ss1!=null){
			sql=" VilDataCollRecID in("+sObjID1+")";
		}*/
		if(ss.equals("true")){
			String eva="";
			boolean dd=true;
			List<EvalContInvesObj> listdddd=this.evalContInvesObjDAO.findByIsMus(dd);
			for (EvalContInvesObj evalContInvesObj : listdddd) {
				eva=eva+"'"+evalContInvesObj.getInvesObj().getInvesObjId().toString()+"',";
			}
			eva=eva.substring(0,eva.lastIndexOf(","));
			//System.out.println("--------------------------------"+eva);
			sql=" InvesObjId in ("+eva+")";
			if(b!=0){
				sql+= "and VilDataCollRecID = '"+b+"'";
			}else{
			sql+=" and VilDataCollRecID is null";
			}
		}
		else if(fss.equals("sss")){
			sql=" VilDataCollRecID = '"+b+"'";
		}
		else if(fss.equals("hh")){
			String sObjID = "";
			List<InvesObj> fflist = this.invesObjDAO.findByProperty("invesPro.invesProNum", ss.trim());//根据点击的父节点ID查询Up为ID的List
		
			
				for (InvesObj invesObj : fflist) {
					sObjID = sObjID +getInvesObjIds(invesObj.getInvesObjId().toString());
				}
				//System.out.println("--------->"+sObjID);
			
			sObjID= sObjID.substring(0, sObjID.lastIndexOf(","));
		
		sql = " InvesObjId in ("+sObjID+")";
		if(b!=0){
			sql+= "and VilDataCollRecID = '"+b+"'";
		}else{
			sql+=" and VilDataCollRecID is null";
		}
		/*if(jqss!=null){
			sql += " and VilDataCollRecId ='"+jqss+"'";
		}*/
			//sql = " InvesProNum = '"+ss+"'";
			//getSingleList(sql,criteria,from,length,result);
		}else if(ss.equals("hh")){
			String sInvesProID = "";
			List<InvesPro> fflist = this.invesProDAO.findByProperty("invesPro.invesProNum",ColldDataDUIXIANGAction.getObjlFSysIDs().trim());
			
			if (fflist.size() > 0) {
				for (InvesPro object : fflist) {
					sInvesProID = sInvesProID +getEvalMethNums(object.getInvesProNum());
				}
				//System.out.println("--------->"+sInvesProID);
			} else {
				//直接查找
				sInvesProID = fss;
			}
			//sInvesProID= sInvesProID.substring(0, sInvesProID.lastIndexOf(","));
			//System.out.println(sInvesProID);
			String sObjID = "";
			for(String d:sInvesProID.split(",")){
			
			List<InvesObj> fflist1 = this.invesObjDAO.findByProperty("invesPro.invesProNum", d.trim());//根据点击的父节点ID查询Up为ID的List
		
			
				for (InvesObj invesObj : fflist1) {
					sObjID = sObjID +getInvesObjIds(invesObj.getInvesObjId().toString());
				}
				//System.out.println("--------->"+sObjID);
			
			
		
			}
			sObjID= sObjID.substring(0, sObjID.lastIndexOf(","));
			//sql = " InvesProNum in ("+sInvesProID+")";
			
			sql = " InvesObjId in ("+sObjID+")";
			if(b!=0){
				sql+= "and VilDataCollRecID = '"+b+"'";
			}else{
			sql+=" and VilDataCollRecID is null";
			}
				
		}
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		/*String jqs=ColldDataDUIXIANGAction.getJQS();
		String jqss=ColldDataDUIXIANGAction.getJQS1();
		String sObjID = "";
		List<InvesObj> fflist = this.invesObjDAO.findByProperty("invesPro.invesProNum", jqs.trim());//根据点击的父节点ID查询Up为ID的List
	
		
			for (InvesObj invesObj : fflist) {
				sObjID = sObjID +getInvesObjIds(invesObj.getInvesObjId().toString());
			}
			System.out.println("--------->"+sObjID);
		
		sObjID= sObjID.substring(0, sObjID.lastIndexOf(","));
		if(jqs!=null){
	sql = " InvesObjId in ("+sObjID+")";}
	/*if(jqss!=null){
		sql += " and VilDataCollRecId ='"+jqss+"'";
	}*/
		int rows = this.invesObjDataDAO.getCounts(sql, values);
		//int rows = this.invesObjColldDataDAO.getCounts(sql, values);
		return rows;
	}
	private String getInvesObjIds(String InvesObjId){
		String ssInvesObjId = "";
		List<InvesObj> fflist = this.invesObjDAO.findByProperty("invesPro.invesProNum",InvesObjId.trim());//根据点击的父节点ID查询Up为ID的List
		if (fflist.size() > 0) {//
			for (InvesObj invesObj : fflist) {
				ssInvesObjId =ssInvesObjId+ getInvesObjIds(invesObj.getInvesObjId().toString());
			}
		} else {
			ssInvesObjId =ssInvesObjId+ "'"+InvesObjId+"',";
		}
		
		return ssInvesObjId;
	}
	/*private String VIl(int InvesObjI){
		String ssInvesObjId = "";
		
		List<VilDataCollRec> fflist = this.vilDataCollRecDAO.findByProperty("vilBasicInfo.vilBasicInfoId",InvesObjI );//根据点击的父节点ID查询Up为ID的List
		if (fflist.size() > 0) {//
			for (VilDataCollRec vilDataCollRec : fflist) {
				ssInvesObjId =ssInvesObjId+ VIl(vilDataCollRec.getVilDataCollRecId());
			}
		} else {
			ssInvesObjId =ssInvesObjId+ "'"+InvesObjI+"',";
		}
		
		return ssInvesObjId;
	}*/

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		
			/*String sObjID = "";
			List<InvesObj> fflist = this.invesObjDAO.findByProperty("invesPro.invesProNum", jqs.trim());//根据点击的父节点ID查询Up为ID的List
		
			
				for (InvesObj invesObj : fflist) {
					sObjID = sObjID +getInvesObjIds(invesObj.getInvesObjId().toString());
				}
				System.out.println("--------->"+sObjID);
			
			sObjID= sObjID.substring(0, sObjID.lastIndexOf(","));
			if(jqs!=null){
		sql = " InvesObjId in ("+sObjID+")";}
		/*if(jqss!=null){
			sql += " and VilDataCollRecId ='"+jqss+"'";
		}*/
		
		String fss = ColldDataDUIXIANGAction.getObjlFSysIDs().trim();
		String ss = ColldDataDUIXIANGAction.getObjlSysIDs().trim();
		String ss1=ColldDataDUIXIANGAction.getJQS1().trim();
		String ss4=ColldDataDUIXIANGAction.getJQS3().trim();
		
		
		//String sObjID1="";
		Integer g=0;
		List<VilBasicInfo> listvv=this.vilBasicInfoDAO.findByVilNum(ss1.trim());//获取到村庄
		for (VilBasicInfo vilBasicInfo : listvv) {
			g = vilBasicInfo.getVilBasicInfoId();//获得村庄的id
		}
		//List<VilDataCollRec> vd = vilDataCollRecDAO.findByProperty("vilBasicInfo.vilBasicInfoId", g);//根据村庄id找到采集记录
		List<VilDataCollRec> vd = vilDataCollRecDAO.findNewRec1(g, ss4);
		//获取采集记录的id
		Integer b = 0;
		for (VilDataCollRec vilDataCollRec : vd) {
			b = vilDataCollRec.getVilDataCollRecId();
		}
		
		
	/*	
		System.out.println("--------->"+sObjID1);
		sObjID1= sObjID1.substring(0, sObjID1.lastIndexOf(","));
		if(ss1!=null){
			sql=" VilDataCollRecID in ("+sObjID1+")";
		}*/
		
		
		if(ss.equals("true")){
			//System.out.println(ss);
			String eva="";
			boolean dd=true;
			List<EvalContInvesObj> listdddd=this.evalContInvesObjDAO.findByIsMus(dd);
			for (EvalContInvesObj evalContInvesObj : listdddd) {
				eva=eva+"'"+evalContInvesObj.getInvesObj().getInvesObjId().toString()+"',";
			}
			eva=eva.substring(0,eva.lastIndexOf(","));
			//System.out.println("--------------------------------"+eva);
			sql=" InvesObjId in ("+eva+")";
			if(b!=0){
				sql+= "and VilDataCollRecID = '"+b+"'";
			}else{
			sql+=" and VilDataCollRecID is null";
			}
			
		}
		else if(fss.equals("sss")){
			sql=" VilDataCollRecID = '"+b+"'";
		}
		
		else if(fss.equals("hh")){
			
			
			String sObjID = "";
			List<InvesObj> fflist = this.invesObjDAO.findByProperty("invesPro.invesProNum", ss.trim());//根据点击的父节点ID查询Up为ID的List
		
			
				for (InvesObj invesObj : fflist) {
					sObjID = sObjID +getInvesObjIds(invesObj.getInvesObjId().toString());
				}
				//System.out.println("--------->"+sObjID);
			
			sObjID= sObjID.substring(0, sObjID.lastIndexOf(","));
			
			
			sql = " InvesObjId in ("+sObjID+")";
			if(b!=0){
				sql+= "and VilDataCollRecID = '"+b+"'";
			}else{
			sql+=" and VilDataCollRecID is null";
			}
				
			//sql = " InvesProNum = '"+ss+"'";
			//getSingleList(sql,criteria,from,length,result);
		}else if(ss.equals("hh")){
			String sInvesProID = "";
			List<InvesPro> fflist = this.invesProDAO.findByProperty("invesPro.invesProNum",ColldDataDUIXIANGAction.getObjlFSysIDs().trim());
			
			if (fflist.size() > 0) {
				for (InvesPro object : fflist) {
					sInvesProID = sInvesProID +getEvalMethNums(object.getInvesProNum());
				}
				//System.out.println("--------->"+sInvesProID);
			} else {
				//直接查找
				sInvesProID = fss;
			}
			//sInvesProID= sInvesProID.substring(0, sInvesProID.lastIndexOf(","));
			String sObjID = "";
			for(String d:sInvesProID.split(",")){
			
			List<InvesObj> fflist1 = this.invesObjDAO.findByProperty("invesPro.invesProNum", d.trim());//根据点击的父节点ID查询Up为ID的List
		
			
				for (InvesObj invesObj : fflist1) {
					sObjID = sObjID +getInvesObjIds(invesObj.getInvesObjId().toString());
				}
				//System.out.println("--------->"+sObjID);
			
			
		
			}
			sObjID= sObjID.substring(0, sObjID.lastIndexOf(","));
			//sql = " InvesProNum in ("+sInvesProID+")";
			
			sql = " InvesObjId in ("+sObjID+")";
			if(b!=0){
				sql+= "and VilDataCollRecID = '"+b+"'";
			}else{
			sql+=" and VilDataCollRecID is null";
			}
			//sql = " InvesProNum in ("+sInvesProID+")";
		
		}
		//List<InvesObj> fflist2 = this.invesObjDAO.findByProperty("invesPro.invesProNum", d.trim());
		
		
		
		
		
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<InvesObjData> list = new ArrayList<InvesObjData>();
		list = this.invesObjDataDAO.findByConditionAndPager(sql, values,from,length);
		//List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		int count = 0;
		int count1 = 0;
		for (InvesObjData a : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			/*if(a.getInvesObj().getInvesObjId()==a.getInvesObj().getInvesObjId()){
				continue;
			}*/
			boolean hjh = false;
			/*List<EvalContInvesObj> list23=this.evalContInvesObjDAO.findByProperty("invesObj.invesObjId", a.getInvesObj().getInvesObjId());
			for (EvalContInvesObj evalContInvesObj : list23) {
				hjh=evalContInvesObj.getIsMus();
			};*/
			
			if (a.getDataCollDicEntry()==null) {
				
				
				map.put("InvesObjDataId", a.getInvesObjDataId());
				map.put("DataCollDicEntryId","");
				/*if(a.getVilDataCollRec()==null){
					map.put("VilDataCollRecID", null);
				}else {*/
				map.put("VilDataCollRecID", a.getVilDataCollRec().getVilDataCollRecId());
				//map.put("InvesObjId", a.getInvesObj().getInvesObjId());
				//map.put("InvesObjCode",a.getInvesObj().getInvesObjCode());
				/*if(a.getInvesObj()==null){
					map.put("InvesObjId",null);
				}else{*/
				map.put("InvesObjId",a.getInvesObj().getInvesObjId());
				
				/*if(a.getInvesObj()==null){
					map.put("InvesObjCode", null);
				}else if(a.getInvesObj().getInvesObjCode()== null){
					map.put("InvesObjCode", null);
				}else{*/
					map.put("InvesObjCode", a.getInvesObj().getInvesObjCode());
				
				/*if(a.getInvesObj()==null){
					map.put("InvesObjName",null);
				}else{*/
				map.put("InvesObjName",a.getInvesObj().getInvesObjName());
				
				
				if(a.getInvesObj()==null){
					map.put("IsMustCollData", null);
				}else{
					map.put("IsMustCollData",hjh);
				}
				
				if(a.getInvesObjDataValu()==null){
					map.put("InvesObjDataValu","");
				}else{
					map.put("InvesObjDataValu",a.getInvesObjDataValu());
				}
				/*if(a.getInvesObj()==null){
					map.put("InvesObjComp", null);
				}else if(a.getInvesObj().getInvesObjComp()== null&& a.getInvesObj().getDataCollDataDic() == null){
					map.put("InvesObjComp", null);
				}else{
					map.put("InvesObjComp", a.getInvesObj().getInvesObjComp());
				}*/
				
				if ( a.getInvesObj() == null) {
					map.put("DataCollDataDicId",null);
				} else if ( a.getInvesObj().getDataCollDataDic() == null) {
					map.put("DataCollDataDicId", null);
				} else {
					map.put("DataCollDataDicId", a.getInvesObj().getDataCollDataDic().getDataCollDataDicId());
				}
				/*if ( a.getInvesObj() == null) {
					map.put("DataCollDataDicName",null);
				} else if ( a.getInvesObj().getDataCollDataDic() == null) {
					map.put("DataCollDataDicName", null);
				} else if (a.getInvesObj().getDataCollDataDic().getDataDicName()==null) {
					map.put("DataCollDataDicName", null);
				}else{
				map.put("DataCollDataDicName", a.getInvesObj().getDataCollDataDic().getDataDicName());
				*/
				if(a.getInvesObjNote()==null){
					map.put("InvesObjNote","");
				}else{
				map.put("InvesObjNote",a.getInvesObjNote());
				}
				if(a.getInvesObj()==null){
					map.put("IsdChoDic",null);
				}else if(a.getInvesObj().getDataCollDataDic()==null){
					map.put("IsdChoDic",null);
				}else{map.put("IsdChoDic",a.getInvesObj().getDataCollDataDic().getIsdChoDic());}
				if(a.getInvesObj()==null){
					map.put("InvesObjAttri",null);
				}else if(a.getInvesObj().getInvesObjAttri()==null){
					map.put("InvesObjAttri",null);
				}else{map.put("InvesObjAttri",a.getInvesObj().getInvesObjAttri().getInvesObjAttriName());}
			
	
				
			} else {

				if (a.getInvesObj() ==null || a.getVilDataCollRec()==null) {
					continue;
				}else{
					int invesobjid = a.getInvesObj().getInvesObjId();
					int jiluid =a.getVilDataCollRec().getVilDataCollRecId();
					List<InvesObjData> listobj = invesObjDataDAO.findInvIDAndRecD(jiluid, invesobjid);
					if (listobj.size()>1) {
						if(count ==0&&count1==0){
							count =invesobjid;
							count1=jiluid;
							String zuhe="";
							map.put("InvesObjDataId", a.getInvesObjDataId());
							for (InvesObjData invesObjData : listobj) {
								zuhe=zuhe+invesObjData.getDataCollDicEntry().getDicEntryName()+",";
							}
							
							map.put("DataCollDicEntryId",zuhe);
							/*if(a.getVilDataCollRec()==null){
								map.put("VilDataCollRecID", null);
							}else {*/
							map.put("VilDataCollRecID", a.getVilDataCollRec().getVilDataCollRecId());
							//map.put("InvesObjId", a.getInvesObj().getInvesObjId());
							//map.put("InvesObjCode",a.getInvesObj().getInvesObjCode());
							/*if(a.getInvesObj()==null){
								map.put("InvesObjId",null);
							}else{*/
							map.put("InvesObjId",a.getInvesObj().getInvesObjId());
							
							/*if(a.getInvesObj()==null){
								map.put("InvesObjCode", null);
							}else if(a.getInvesObj().getInvesObjCode()== null){
								map.put("InvesObjCode", null);
							}else{*/
								map.put("InvesObjCode", a.getInvesObj().getInvesObjCode());
							
							/*if(a.getInvesObj()==null){
								map.put("InvesObjName",null);
							}else{*/
							map.put("InvesObjName",a.getInvesObj().getInvesObjName());
							
							
							if(a.getInvesObj()==null){
								map.put("IsMustCollData", null);
							}else{
								map.put("IsMustCollData",hjh);
							}
							
							if(a.getInvesObjDataValu()==null){
								map.put("InvesObjDataValu","");
							}else{
								map.put("InvesObjDataValu",a.getInvesObjDataValu());
							}
							/*if(a.getInvesObj()==null){
								map.put("InvesObjComp", null);
							}else if(a.getInvesObj().getInvesObjComp()== null&& a.getInvesObj().getDataCollDataDic() == null){
								map.put("InvesObjComp", null);
							}else{
								map.put("InvesObjComp", a.getInvesObj().getInvesObjComp());
							}*/
							
							if ( a.getInvesObj() == null) {
								map.put("DataCollDataDicId",null);
							} else if ( a.getInvesObj().getDataCollDataDic() == null) {
								map.put("DataCollDataDicId", null);
							} else {
								map.put("DataCollDataDicId", a.getInvesObj().getDataCollDataDic().getDataCollDataDicId());
						}
							/*if ( a.getInvesObj() == null) {
								map.put("DataCollDataDicName",null);
							} else if ( a.getInvesObj().getDataCollDataDic() == null) {
								map.put("DataCollDataDicName", null);
							} else if (a.getInvesObj().getDataCollDataDic().getDataDicName()==null) {
								map.put("DataCollDataDicName", null);
							}else{
							map.put("DataCollDataDicName", a.getInvesObj().getDataCollDataDic().getDataDicName());
							*/
							if(a.getInvesObjNote()==null){
								map.put("InvesObjNote","");
							}else{
							map.put("InvesObjNote",a.getInvesObjNote());
							}
							if(a.getInvesObj()==null){
								map.put("IsdChoDic",null);
							}else if(a.getInvesObj().getDataCollDataDic()==null){
								map.put("IsdChoDic",null);
							}else{map.put("IsdChoDic",a.getInvesObj().getDataCollDataDic().getIsdChoDic());}
							if(a.getInvesObj()==null){
								map.put("InvesObjAttri",null);
							}else if(a.getInvesObj().getInvesObjAttri()==null){
								map.put("InvesObjAttri",null);
							}else{map.put("InvesObjAttri",a.getInvesObj().getInvesObjAttri().getInvesObjAttriName());}
						
						}else if(count ==invesobjid&&count1==jiluid){
							continue;
						}else{
							count =invesobjid;
							count1=jiluid;
							String zuhe="";
							map.put("InvesObjDataId", a.getInvesObjDataId());
							for (InvesObjData invesObjData : listobj) {
								zuhe=zuhe+invesObjData.getDataCollDicEntry().getDicEntryName()+",";
							}
							
							map.put("DataCollDicEntryId",zuhe);
							/*if(a.getVilDataCollRec()==null){
								map.put("VilDataCollRecID", null);
							}else {*/
							map.put("VilDataCollRecID", a.getVilDataCollRec().getVilDataCollRecId());
							//map.put("InvesObjId", a.getInvesObj().getInvesObjId());
							//map.put("InvesObjCode",a.getInvesObj().getInvesObjCode());
							/*if(a.getInvesObj()==null){
								map.put("InvesObjId",null);
							}else{*/
							map.put("InvesObjId",a.getInvesObj().getInvesObjId());
							
							/*if(a.getInvesObj()==null){
								map.put("InvesObjCode", null);
							}else if(a.getInvesObj().getInvesObjCode()== null){
								map.put("InvesObjCode", null);
							}else{*/
								map.put("InvesObjCode", a.getInvesObj().getInvesObjCode());
							
							/*if(a.getInvesObj()==null){
								map.put("InvesObjName",null);
							}else{*/
							map.put("InvesObjName",a.getInvesObj().getInvesObjName());
							
							
							if(a.getInvesObj()==null){
								map.put("IsMustCollData", null);
							}else{
								map.put("IsMustCollData",hjh);
							}
							
							if(a.getInvesObjDataValu()==null){
								map.put("InvesObjDataValu","");
							}else{
								map.put("InvesObjDataValu",a.getInvesObjDataValu());
							}
							/*if(a.getInvesObj()==null){
								map.put("InvesObjComp", null);
							}else if(a.getInvesObj().getInvesObjComp()== null&& a.getInvesObj().getDataCollDataDic() == null){
								map.put("InvesObjComp", null);
							}else{
								map.put("InvesObjComp", a.getInvesObj().getInvesObjComp());
							}*/
							
							/*if ( a.getInvesObj() == null) {
								map.put("DataCollDataDicId",null);
							} else if ( a.getInvesObj().getDataCollDataDic() == null) {
								map.put("DataCollDataDicId", null);
							} else {*/
								map.put("DataCollDataDicId", a.getInvesObj().getDataCollDataDic().getDataCollDataDicId());
							
							/*if ( a.getInvesObj() == null) {
								map.put("DataCollDataDicName",null);
							} else if ( a.getInvesObj().getDataCollDataDic() == null) {
								map.put("DataCollDataDicName", null);
							} else if (a.getInvesObj().getDataCollDataDic().getDataDicName()==null) {
								map.put("DataCollDataDicName", null);
							}else{*/
							map.put("DataCollDataDicName", a.getInvesObj().getDataCollDataDic().getDataDicName());
							
							if(a.getInvesObjNote()==null){
								map.put("InvesObjNote","");
							}else{
							map.put("InvesObjNote",a.getInvesObjNote());
							}
							if(a.getInvesObj()==null){
								map.put("IsdChoDic",null);
							}else if(a.getInvesObj().getDataCollDataDic()==null){
								map.put("IsdChoDic",null);
							}else{map.put("IsdChoDic",a.getInvesObj().getDataCollDataDic().getIsdChoDic());}
							if(a.getInvesObj()==null){
								map.put("InvesObjAttri",null);
							}else if(a.getInvesObj().getInvesObjAttri()==null){
								map.put("InvesObjAttri",null);
							}else{map.put("InvesObjAttri",a.getInvesObj().getInvesObjAttri().getInvesObjAttriName());}
						
						}
						
						
						
						
					} else {
						map.put("InvesObjDataId", a.getInvesObjDataId());
						map.put("DataCollDicEntryId",a.getDataCollDicEntry().getDicEntryName());
						/*if(a.getVilDataCollRec()==null){
							map.put("VilDataCollRecID", null);
						}else {*/
						map.put("VilDataCollRecID", a.getVilDataCollRec().getVilDataCollRecId());
						//map.put("InvesObjId", a.getInvesObj().getInvesObjId());
						//map.put("InvesObjCode",a.getInvesObj().getInvesObjCode());
						/*if(a.getInvesObj()==null){
							map.put("InvesObjId",null);
						}else{*/
						map.put("InvesObjId",a.getInvesObj().getInvesObjId());
						
						/*if(a.getInvesObj()==null){
							map.put("InvesObjCode", null);
						}else if(a.getInvesObj().getInvesObjCode()== null){
							map.put("InvesObjCode", null);
						}else{*/
							map.put("InvesObjCode", a.getInvesObj().getInvesObjCode());
						
						/*if(a.getInvesObj()==null){
							map.put("InvesObjName",null);
						}else{*/
						map.put("InvesObjName",a.getInvesObj().getInvesObjName());
						
						
						if(a.getInvesObj()==null){
							map.put("IsMustCollData", null);
						}else{
							map.put("IsMustCollData",hjh);
						}
						
						if(a.getInvesObjDataValu()==null){
							map.put("InvesObjDataValu","");
						}else{
							map.put("InvesObjDataValu",a.getInvesObjDataValu());
						}
						/*if(a.getInvesObj()==null){
							map.put("InvesObjComp", null);
						}else if(a.getInvesObj().getInvesObjComp()== null&& a.getInvesObj().getDataCollDataDic() == null){
							map.put("InvesObjComp", null);
						}else{
							map.put("InvesObjComp", a.getInvesObj().getInvesObjComp());
						}*/
						
						if ( a.getInvesObj() == null) {
							map.put("DataCollDataDicId",null);
						} else if ( a.getInvesObj().getDataCollDataDic() == null) {
							map.put("DataCollDataDicId", null);
						} else {
							map.put("DataCollDataDicId", a.getInvesObj().getDataCollDataDic().getDataCollDataDicId());
						}
						/*if ( a.getInvesObj() == null) {
							map.put("DataCollDataDicName",null);
						} else if ( a.getInvesObj().getDataCollDataDic() == null) {
							map.put("DataCollDataDicName", null);
						} else if (a.getInvesObj().getDataCollDataDic().getDataDicName()==null) {
							map.put("DataCollDataDicName", null);
						}else{
						map.put("DataCollDataDicName", a.getInvesObj().getDataCollDataDic().getDataDicName());
						*/
						if(a.getInvesObjNote()==null){
							map.put("InvesObjNote","");
						}else{
						map.put("InvesObjNote",a.getInvesObjNote());
						}
						if(a.getInvesObj()==null){
							map.put("IsdChoDic",null);
						}else if(a.getInvesObj().getDataCollDataDic()==null){
							map.put("IsdChoDic",null);
						}else{map.put("IsdChoDic",a.getInvesObj().getDataCollDataDic().getIsdChoDic());}
						if(a.getInvesObj()==null){
							map.put("InvesObjAttri",null);
						}else if(a.getInvesObj().getInvesObjAttri()==null){
							map.put("InvesObjAttri",null);
						}else{map.put("InvesObjAttri",a.getInvesObj().getInvesObjAttri().getInvesObjAttriName());}
					
						
					}
				}
				
				
				
				
				
			}
			
			
			
			
			
			
			
				//map.put("InvesObjAttriId",a.getInvesObj().getInvesObjAttri().getInvesObjAttriId()); 
			/*if(a.getInvesObj().getDataCollDataDic().getDataCollDataDicId()==null){
				map.put("DataCollDataDicId",null);
			}else{
            map.put("DataCollDataDicId",a.getInvesObj().getDataCollDataDic().getDataCollDataDicId());
			}
			
			map.put("InvesProNum",a.getInvesObj().getInvesPro().getInvesProNum());
			
			if(a.getInvesObj().getInvesObjComp()==null){
				map.put("InvesObjComp",null);
			}else{
			map.put("InvesObjComp",a.getInvesObj().getInvesObjComp());
			}*/
			/*if(a.getInvesObj().getInvesObjLengt()==null){
				map.put("InvesObjLengt",null);
			}else{
			map.put("InvesObjLengt",a.getInvesObj().getInvesObjLengt());
			}*/
			//map.put("IsMus",a.getInvesObj().getIsMus());
			
			result.add(map);
		}
		return result;
	}
	private String getEvalMethNums(String EvalIndNum){
		String ssEvalMethID = "";
		List<InvesPro> fflist = this.invesProDAO.findByProperty("invesPro.invesProNum",EvalIndNum.trim());
		if (fflist.size() > 0) {//
			for (InvesPro object : fflist) {
				ssEvalMethID =ssEvalMethID+ getEvalMethNums(object.getInvesProNum());
			}
		} else {
			ssEvalMethID =ssEvalMethID+ EvalIndNum+",";
		}
		
		return ssEvalMethID;
	}
	
	
	public void setInvesObjDAO(InvesObjDAO invesObjDAO) {
		this.invesObjDAO = invesObjDAO;
	}
	public InvesObjDAO getInvesObjDAO() {
		return invesObjDAO;
	}
	public VilDataCollRecDAO getVilDataCollRecDAO() {
		return vilDataCollRecDAO;
	}

	public void setVilDataCollRecDAO(VilDataCollRecDAO vilDataCollRecDAO) {
		this.vilDataCollRecDAO = vilDataCollRecDAO;
	}

	public InvesObjDataDAO getInvesObjDataDAO() {
		return invesObjDataDAO;
	}

	public void setInvesObjDataDAO(InvesObjDataDAO invesObjDataDAO) {
		this.invesObjDataDAO = invesObjDataDAO;
	}

	public InvesProDAO getInvesProDAO() {
		return invesProDAO;
	}

	public void setInvesProDAO(InvesProDAO invesProDAO) {
		this.invesProDAO = invesProDAO;
	}

	public DataCollDicEntryDAO getDataCollDicEntryDAO() {
		return dataCollDicEntryDAO;
	}

	public void setDataCollDicEntryDAO(DataCollDicEntryDAO dataCollDicEntryDAO) {
		this.dataCollDicEntryDAO = dataCollDicEntryDAO;
	}

	public DataCollDataDicDAO getDataCollDataDicDAO() {
		return dataCollDataDicDAO;
	}

	public void setDataCollDataDicDAO(DataCollDataDicDAO dataCollDataDicDAO) {
		this.dataCollDataDicDAO = dataCollDataDicDAO;
	}
	public VilFilDataDAO getVilFilDataDAO() {
		return vilFilDataDAO;
	}
	public void setVilFilDataDAO(VilFilDataDAO vilFilDataDAO) {
		this.vilFilDataDAO = vilFilDataDAO;
	}
	public VilEvalScoDAO getVilEvalScoDAO() {
		return vilEvalScoDAO;
	}
	public void setVilEvalScoDAO(VilEvalScoDAO vilEvalScoDAO) {
		this.vilEvalScoDAO = vilEvalScoDAO;
	}
	public EvalContSubScoDAO getEvalContSubScoDAO() {
		return evalContSubScoDAO;
	}
	public void setEvalContSubScoDAO(EvalContSubScoDAO evalContSubScoDAO) {
		this.evalContSubScoDAO = evalContSubScoDAO;
	}
	public EvalContDAO getEvalContDAO() {
		return evalContDAO;
	}
	public void setEvalContDAO(EvalContDAO evalContDAO) {
		this.evalContDAO = evalContDAO;
	}
	public PrmtMeasDAO getPrmtMeasDAO() {
		return prmtMeasDAO;
	}
	public void setPrmtMeasDAO(PrmtMeasDAO prmtMeasDAO) {
		this.prmtMeasDAO = prmtMeasDAO;
	}
	
	

	
	
	

	


	

}