package com.rural.villageColldData.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.InvesPro;
import com.rural.dao.InvesObjDAO;
import com.rural.dao.InvesProDAO;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;
import com.rural.villageColldData.service.IColldDataDUIXIANGService;



public class ColldDataDUIXIANGAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private IColldDataDUIXIANGService colldDataDUIXIANGService;
	private String InvesObjDataId;
	private String VilDataCollRecId;
	private String InvesObjId;
	//private String InvesObjName;
	private String DataCollDicEntryId;
	//private String DataCollDataDicId;
	private String InvesObjDataValu;
	private String InvesObjNote;
	//private InvesObj invesObj;
	private InvesObjDAO invesObjDAO=new InvesObjDAO();
	private InvesProDAO invesProDAO = new InvesProDAO();
	private String FilIdef;
	private String Apps;
	private String vfile;
	private static String ObjlSysIDs;//判断选中的节点是叶子节点还是父节点
	private static String ObjlFSysIDs;//判断选中的节点是叶子节点还是父节点

	private String ObjFSID;
	private String JQID;
	public static String JQS;
	private int isFirstItem = 0;
	private static String root = null;
	
	private String JQID1;
	public static String JQS1;//村庄的num
	
	private String JQID3;
	public static String JQS3;
	
	
	public String getVfile() {
		return vfile;
	}
	public void setVfile(String vfile) {
		this.vfile = vfile;
	}
	public String getJQID3() {
		return JQID3;
	}
	public void setJQID3(String jQID3) {
		JQID3 = jQID3;
	}
	public static String getJQS3() {
		return JQS3;
	}
	public static void setJQS3(String jQS3) {
		JQS3 = jQS3;
	}
	public static String getObjlSysIDs() {
		return ObjlSysIDs;
	}
	public static void setObjlSysIDs(String objlSysIDs) {
		ObjlSysIDs = objlSysIDs;
	}
	public static String getObjlFSysIDs() {
		return ObjlFSysIDs;
	}
	public static void setObjlFSysIDs(String objlFSysIDs) {
		ObjlFSysIDs = objlFSysIDs;
	}
	public String getObjFSID() {
		return ObjFSID;
	}
	public void setObjFSID(String objFSID) {
		ObjFSID = objFSID;
	}
	public String getInvesObjDataId() {
		return InvesObjDataId;
	}
	public void setInvesObjDataId(String invesObjDataId) {
		InvesObjDataId = invesObjDataId;
	}
	public String getVilDataCollRecId() {
		return VilDataCollRecId;
	}
	public void setVilDataCollRecId(String vilDataCollRecId) {
		VilDataCollRecId = vilDataCollRecId;
	}
	public String getInvesObjId() {
		return InvesObjId;
	}
	public void setInvesObjId(String invesObjId) {
		InvesObjId = invesObjId;
	}
	
	public String getDataCollDicEntryId() {
		return DataCollDicEntryId;
	}
	public void setDataCollDicEntryId(String dataCollDicEntryId) {
		DataCollDicEntryId = dataCollDicEntryId;
	}
	
	public String getInvesObjDataValu() {
		return InvesObjDataValu;
	}
	public void setInvesObjDataValu(String invesObjDataValu) {
		InvesObjDataValu = invesObjDataValu;
	}
	public String getInvesObjNote() {
		return InvesObjNote;
	}
	public void setInvesObjNote(String invesObjNote) {
		InvesObjNote = invesObjNote;
	}


	
	
	
	
	public String getJQID1() {
		return JQID1;
	}
	public void setJQID1(String jQID1) {
		JQID1 = jQID1;
	}
	public static String getJQS1() {
		return JQS1;
	}
	public static void setJQS1(String jQS1) {
		JQS1 = jQS1;
	}
	public String getJQID() {
		return JQID;
	}
	public void setJQID(String jQID) {
		JQID = jQID;
	}
	public static String getJQS() {
		return JQS;
	}
	public static void setJQS(String jQS) {
		JQS = jQS;
	}
	
	
	
	public String DDD(){
		String ss="";
		ss=colldDataDUIXIANGService.DDD(VilDataCollRecId);
		this.dataMap.put("success", ss);
		return SUCCESS;
	}
	
	
	
	
	public String manageDUI3() {
		//ColldDataDUIXIANGAction.setJQS(JQID);
		//ColldDataDUIXIANGAction.setJQS1(JQID1);
		
		if (!search) {
			if ("add".equals(oper)) {// ����
				addColldDataDUIXIANG3();
			} else if ("search".equals(oper)) {// ����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {// ɾ��
				delColldDataDUIXIANG();
			} else if ("edit".equals(oper)) {// �޸�
				ediColldDataDUIXIANG();
			}
		} else {//��ѯ����
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	public String addColldDataDUIXIANG3(){
		
		String message = "成功！";
		String old1;
		String old2;
		try {
			old1 = java.net.URLDecoder.decode(InvesObjNote,"UTF-8");
			old2=java.net.URLDecoder.decode(InvesObjDataValu,"UTF-8");
			colldDataDUIXIANGService.addColldDataDUIXIANG3(Integer.parseInt(InvesObjDataId),Integer.parseInt(InvesObjId),Integer.parseInt(VilDataCollRecId),old2,old1);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			this.dataMap.put("success", message);
			return SUCCESS;
			
		}
	public boolean isAdd(){
		boolean flag = true;
		/*for(String a: DataCollDicEntryId.split(",")){
			if(!colldDataDUIXIANGService.isAdd(Integer.parseInt(a))){
				flag = false;
				break;			
			}
		}*/
		return flag;
	} 
public String addColldDataDUIXIANG1() {
	String message = "";
	boolean c;
	String old1;
	if(isAdd()){
		//for(String b:DataCollDicEntryId.split(",")){
		
		try {
			old1 = java.net.URLDecoder.decode(InvesObjNote,"UTF-8");
			message =colldDataDUIXIANGService.addColldDataDUIXIANG1(Integer.parseInt(InvesObjDataId),Integer.parseInt(InvesObjId),Integer.parseInt(VilDataCollRecId),DataCollDicEntryId,old1);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//}
	}else{
		message="请勿重复输入!";
	}
		this.dataMap.put("success", message);
		return SUCCESS;
		
	}
public String manageDUI1() {
	//ColldDataDUIXIANGAction.setJQS(JQID);
	//ColldDataDUIXIANGAction.setJQS1(JQID1);
	if (!search) {
		if ("add".equals(oper)) {// ����
			addColldDataDUIXIANG1();
		} else if ("search".equals(oper)) {// ����ҳ��ʱ��ѯ
			refreshGridModel();
			responseData();
		} else if ("del".equals(oper)) {// ɾ��
			//delColldDataDUIXIANG();
		} else if ("edit".equals(oper)) {// �޸�
			//ediColldDataDUIXIANG1();
		}
	} else {//��ѯ����
		refreshGridModel();
		responseData();
	}
	return SUCCESS;
}
	public String delColldDataDUIXIANG(){
		for (String a : InvesObjDataId.split(",")) {
			int i = Integer.parseInt(a);
			colldDataDUIXIANGService.delColldDataDUIXIANG(i);
		}
		
		this.dataMap.put("success", true);
		return SUCCESS;

	}
	
	public String ediColldDataDUIXIANG(){
		for (String a : InvesObjDataId.split(",")) {
			int b = Integer.parseInt(a);
			colldDataDUIXIANGService.ediColldDataDUIXIANG(b,InvesObjDataValu.trim(),InvesObjNote.trim());
		}
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	/*public String ediColldDataDUIXIANG1(){
		for (String a : InvesObjDataId.split(",")) {
			int b = Integer.parseInt(a);
			colldDataDUIXIANGService.ediColldDataDUIXIANG1(b,Integer.parseInt(InvesObjId),Integer.parseInt(VilDataCollRecId),Integer.parseInt(DataCollDicEntryId));
		}
		this.dataMap.put("success", true);
		return SUCCESS;
	}*/
	/**
	 * У�ڵ�ʦ��Ϣ��������ڣ����search��oper��ֵ
	 * @return
	 */
	public boolean isAdd1(){
		boolean flag = true;
		for(String a: VilDataCollRecId.split(",")){
			if(!colldDataDUIXIANGService.isAdd1(Integer.parseInt(a))){
				flag = false;
				break;			
			}
		}
		return flag;
	} 
public String addColldDataDUIXIANG(){
	
	
	/*String []a=InvesObjId.split(",");
	List<String> list = new ArrayList<String>();
	 for(int i=0; i<a.length; i++){
	     String b = a[i].trim();
	     list.add(b);
	 }*/
	// System.out.println(list);
		//ColldDataDUIXIANGAction.setJQS1(JQID1);
		//String s=ColldDataDUIXIANGAction.getJQS1();
	String message = "";
	boolean c;
	
	if(isAdd1()){
		//for(String b:DataCollDicEntryId.split(",")){
		message = colldDataDUIXIANGService.addColldDataDUIXIANG(Integer.parseInt(VilDataCollRecId));
	}else{
		message="请勿重复增加采集数据";
	}
		this.dataMap.put("success", message);
		return SUCCESS;
		
	}
	public String manageDUI() {
		ColldDataDUIXIANGAction.setJQS1(JQID1);
		ColldDataDUIXIANGAction.setJQS3(JQID3);
		
		ColldDataDUIXIANGAction.setObjlFSysIDs(ObjFSID);
		ColldDataDUIXIANGAction.setObjlSysIDs(JQID);
		if (!search) {
			if ("add".equals(oper)) {// ����
				addColldDataDUIXIANG();
			} else if ("search".equals(oper)) {// ����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {// ɾ��
				delColldDataDUIXIANG();
			} else if ("edit".equals(oper)) {// �޸�
				ediColldDataDUIXIANG();
			}
		} else {//��ѯ����
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	
	public void aa(){
		System.out.println(11);
	}
	
	/**
	 * ����������Ӧ���
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	public String queryAllMenusAsTree(){
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		items = getChildNodes(items, null);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		
		//JSONObject json = JSONObject.fromObject(items);
		
		dataMap.put("ss",items);
		return SUCCESS;
	}
		
		//����������
		public String sss()
		{
			Map<String, Item> items = new LinkedHashMap<String, Item>();
			
			AdditionalParameters additionalParameters = new AdditionalParameters();
			additionalParameters.setId("sss");
			Item item =new Item();
			item.setName("全部");
			item.setType(ItemType.NODE_FOLDER);
			
			
			Map<String, Item> items1 = new LinkedHashMap<String, Item>();
			AdditionalParameters additionalParameters1 = new AdditionalParameters();
			additionalParameters1.setId("true");
			Item item1 =new Item();
			item1.setName("必填项");
			item1.setType(ItemType.NODE_ITEM);
			item1.setAdditionalParameters(additionalParameters1);
			items1.put("ssssyyyy1",item1);
			
			items1 = getChildNodes(items1, null);
			
			additionalParameters.setChildren(items1);
			item.setAdditionalParameters(additionalParameters);
			items.put("ssssyyyy",item);
			//ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
			
			//JSONObject json = JSONObject.fromObject(items);
			
			dataMap.put("ss",items );
			return SUCCESS;
		}
		
		private Map getChildNodes(Map<String, Item> items, String parentId) {
			
			//get all root
			List<InvesPro> permissions = colldDataDUIXIANGService.getChildPermissions(parentId);
			if(permissions.size( )>0){  
	            for ( InvesPro permission : permissions )  
	            {  
	                //�ݹ��ӽڵ�  
	                Item item=new Item( );  
	                item.setName( permission.getInvesProName());  
	                item.setType( ItemType.NODE_FOLDER );  
	                //�õ��ĸ��ڵ�Ľڵ�
	                getChildItems(item,permission.getInvesProNum().toString( ),permission.getInvesProName( ));  
	                items.put( permission.getInvesProName(), item );  
	            }  
	        }  
			
			
	        return items;
		}
		
		
		


		private void getChildItems(Item item, String parentId,String parentName){
			//��ýڵ���ΪparentiD�������ӽڵ�
			
			List<InvesPro> childPermissions = colldDataDUIXIANGService.getChildPermissions( parentId );  
	        if(childPermissions.size( )>0){  
	            //���ڵ�Ϊ��folder��  
	            item.setName(parentName);  
	            item.setType( ItemType.NODE_FOLDER );  
	            AdditionalParameters additionalParameters=new AdditionalParameters( );  
	            additionalParameters.setId( parentId );  
	            Map<String, Item> children=new LinkedHashMap<String, Item>();
	            
	            
	            for ( InvesPro childPermission : childPermissions )  
	            {  
	                Item item2=new Item( );  
	                getChildItems( item2, childPermission.getInvesProNum().toString( ),childPermission.getInvesProName() );  
	                children.put( childPermission.getInvesProName(), item2 );  
	            }  
	            additionalParameters.setChildren( children );  
	            item.setAdditionalParameters( additionalParameters );  
	              
	        }else{  
	            //���ڵ�Ϊ��item��,��ȡ��ǰ  
	            item.setName(parentName);  
	            item.setType( ItemType.NODE_ITEM );
	            AdditionalParameters additionalParameters=new AdditionalParameters( ); 
	            additionalParameters.setId( parentId );
	            /*Map<String, Item> prooAsChild = new LinkedHashMap<String, Item>();
				
				
				List<InvesObj> objs = colldDataDUIXIANGService.getObj(parentId.toString());
				for(InvesObj obj : objs){
					Item item_2 = new Item();
					item_2.setName(obj.getInvesObjName());
					item_2.setType(ItemType.NODE_ITEM);
					AdditionalParameters objAdditionalParameters = new AdditionalParameters();
					objAdditionalParameters.setId(obj.getInvesObjNum());
					if(this.isFirstItem == 0){
						objAdditionalParameters.setItemSelected(true);
						this.isFirstItem++;
					}
					item_2.setAdditionalParameters(objAdditionalParameters);
					prooAsChild.put(obj.getInvesObjName(), item_2);
				}
	             
	            
	            additionalParameters.setChildren(prooAsChild);*/
	            if(this.isFirstItem==0){
	            	additionalParameters.setItemSelected(true);
	            	this.isFirstItem++;
	            }
	            item.setAdditionalParameters( additionalParameters );  
	        }  
			
		}
	///上传
	public String UploadData() throws SQLException{
		String filed;
		try{
			filed=java.net.URLDecoder.decode(FilIdef,"UTF-8");
		 colldDataDUIXIANGService.UploadData(filed);
		 }catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 dataMap.put("success",true );
		 return SUCCESS;
	}
	public String UploadApps() {
		String Apps1;
		try {
			Apps1 = java.net.URLDecoder.decode(Apps,"UTF-8");
			colldDataDUIXIANGService.UploadApps(Apps1);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataMap.put("success",true );
		return SUCCESS;
	}
	public String UploadFile() {
		String vfile1;
		try {
			vfile1 = java.net.URLDecoder.decode(vfile,"UTF-8");
			colldDataDUIXIANGService.UploadFile(vfile1,Integer.parseInt(InvesObjId.trim()),Integer.parseInt(VilDataCollRecId.trim()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataMap.put("success",true );
		return SUCCESS;
	}
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.colldDataDUIXIANGService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.colldDataDUIXIANGService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.colldDataDUIXIANGService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.colldDataDUIXIANGService.queryByPage(criteria, from, length);
		return results;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOper() {
		return oper;
	}

	public IColldDataDUIXIANGService getColldDataDUIXIANGService() {
		return colldDataDUIXIANGService;
	}


	public void setColldDataDUIXIANGService(
			IColldDataDUIXIANGService colldDataDUIXIANGService) {
		this.colldDataDUIXIANGService = colldDataDUIXIANGService;
	}
	public String getFilIdef() {
		return FilIdef;
	}
	public void setFilIdef(String filIdef) {
		FilIdef = filIdef;
	}
	public String getApps() {
		return Apps;
	}
	public void setApps(String apps) {
		Apps = apps;
	}


	
	

	
}