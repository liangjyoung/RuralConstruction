package com.rural.table.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.rural.bean.EvalContSubSco;
import com.rural.bean.PrmtMeas;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.PrmtMeasDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilEvalScoDAO;


public class ApplicationTableService implements ApplicationTableIService{
	 private Boolean CTREATE_FILE_FLAG=true;
	 private CreateFile createfile = new CreateFile();
	 private EvalContSubScoDAO contSubScoDAO = new EvalContSubScoDAO();
	 private PrmtMeasDAO measDAO = new PrmtMeasDAO();
	 private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	 public EvalContSubScoDAO getContSubScoDAO() {
		return contSubScoDAO;
	}

	public void setContSubScoDAO(EvalContSubScoDAO contSubScoDAO) {
		this.contSubScoDAO = contSubScoDAO;
	}

	public boolean createTableFromDb(String VilEvalscoID,List<String> stuloginnamelist,String VilNum) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("VilEvalscoID:-------"+VilEvalscoID+"VilNum :----"+VilNum+" ,loginnamelist :----"+stuloginnamelist);
		EvalContSubSco contSubSco = new EvalContSubSco();
		String total =  stuloginnamelist.size()+"";
		String vill ="";
		List<VilBasicInfo> vilBasicInfos = vilBasicInfoDAO.findByVilNum(VilNum);
		for (VilBasicInfo vilBasicInfo : vilBasicInfos) {
			vill = vilBasicInfo.getVilName();
			break;
		}
		int i = 0;
		int vilevalscoID = Integer.parseInt(VilEvalscoID);
		//int evalID = Integer.parseInt(E)
		CTREATE_FILE_FLAG=true;
		
		this.createfile.checkFilePath( new File(this.createfile.getApplicationTablePath()));
		for(String EvlScoreIDs:stuloginnamelist){
			 i++;	 
			 String start = i+"";
			 int EvlScoreID = Integer.parseInt(EvlScoreIDs);
			 contSubSco = this.contSubScoDAO.findByVilAndEval(vilevalscoID, EvlScoreID);
			
			
			 
			 if(contSubSco!=null){
				 CTREATE_FILE_FLAG=false; 
				 List<String> items=this.getItemsList();
				 List<String> data=new ArrayList<String>();
				 String sevalIndname = "";
				 String evalIndname = "";
				 String evalmeth = "";
				 String score = "";
				 String constat = "";
				 String impromeas =  "";
				 String impromeass =  "";
				 String toscore =  "";
				 int toscores =0; 
				 String evalseq = String.valueOf(contSubSco.getEvalCont().getEvalContSeqNum());
				 
				 if (contSubSco.getEvalCont().getEvalSystInd().getEvalSystInd().getEvalSystInd()==null) {
					  sevalIndname = String.valueOf(contSubSco.getEvalCont().getEvalSystInd().getEvalSystInd().getEvalIndName());
					  evalIndname = String.valueOf(contSubSco.getEvalCont().getEvalSystInd().getEvalIndName());
				 } else {
					if (contSubSco.getEvalCont().getEvalSystInd().getEvalSystInd()==null) {
						sevalIndname = String.valueOf(contSubSco.getEvalCont().getEvalSystInd().getEvalIndName());
						evalIndname = "无";
					
					} else {
						sevalIndname = String.valueOf(contSubSco.getEvalCont().getEvalSystInd().getEvalSystInd().getEvalSystInd().getEvalIndName());
						evalIndname = String.valueOf(contSubSco.getEvalCont().getEvalSystInd().getEvalIndName());
					}
				 }
				 String evalname = String.valueOf(contSubSco.getEvalCont().getEvalContDes());
				 String value = String.valueOf(contSubSco.getEvalCont().getEvalContScore());
				
				 if (contSubSco.getEvalMeth()==null) {
					 evalmeth = "无";
				} else {
					evalmeth = String.valueOf(contSubSco.getEvalMeth());
				}
			
				 if (contSubSco.getAutoEvalSco() == null) {
					 score = "无";
				} else {
					 score = String.valueOf(contSubSco.getAutoEvalSco());
				}
				
				 
				 List<PrmtMeas> measlist = measDAO.findByProperty("evalContSubSco.evalScoId",contSubSco.getEvalScoId());
				 
				 if (measlist.size()<= 0){
					  constat =  "无";
					  impromeas =  "无";
					  toscore =  "无";
				} else {
					constat = "wu";
					for (PrmtMeas prmtMeas : measlist) {
						impromeass =impromeass +prmtMeas.getPrmtMeas()+prmtMeas.getPrmtMeasValue()+prmtMeas.getPrmtMeasComp()+";";
						if (prmtMeas.getExpectPrmtSco() == null) {
							toscores = toscores+0;
						} else {
							toscores = toscores+Integer.parseInt(prmtMeas.getExpectPrmtSco());
						}
						
					}
					if (contSubSco.getAutoEvalSco()==null) {
						toscores = toscores+0;
					} else {
						toscores=toscores+Integer.parseInt(contSubSco.getAutoEvalSco());
					}
					impromeas =  String.valueOf(impromeass);
					toscore = String.valueOf(toscores);
					
					/*
					for (PrmtMeas prmtMeas : measlist) {
						PrmtMeas meas = new PrmtMeas();
						meas = measDAO.findById(prmtMeas.getPrmtMeasId());
					}
					if (meas.getConsStat() == null) {
						 constat =  "无";
					} else {
						 constat =  String.valueOf(meas.getConsStat());
					}

					if (meas.getImproMeas() == null) {
						 impromeas =  "无";
					} else {
						impromeas = String.valueOf(meas.getImproMeas());
					}
					  
					if (meas.getExpectToSco() == null) {
						 toscore =  "无";
					} else {
						 toscore = String.valueOf(meas.getExpectToSco());
					}
					 */
				}
				 
				 vill = String.valueOf(contSubSco.getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getVilName());
				 String town = String.valueOf(contSubSco.getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getTownBasicInfo().getTownName());
				 String country = String.valueOf(contSubSco.getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getTownBasicInfo().getCountryBasicInfo().getCountryName());
				 String city = String.valueOf(contSubSco.getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getTownBasicInfo().getCountryBasicInfo().getCityBasicInfo().getCityName());
				// String start = String.valueOf(start);
				// String total = String.valueOf();
				 
				 
				 data.add(vill);
				 data.add(city);
				 data.add(country);
				 data.add(town);
				 data.add(total);
				 data.add(start);
				 data.add(evalseq);
				 data.add(sevalIndname);
				 data.add(evalIndname);
				 data.add(evalname);
				 data.add(value);
				 data.add(evalmeth);
				 data.add(score);
				 data.add(constat);
				 data.add(impromeas);
				 data.add(toscore);
				 
				 if(!this.createfile.createApplicationTable(vill+evalseq,items,data)) return false;
					
			 }
			 
			 
			 
		 }
		if(CTREATE_FILE_FLAG) return false;
		Zip zip=new Zip();
		System.out.println();
		String name = String.valueOf(this.createfile.getApplicationZipPath()+vill+".zip");
		System.out.println("test--------------------------->"+name);
		zip.zip(this.createfile.getApplicationTablePath(), name);
	//	zip.zip(vill,this.createfile.getApplicationZipPath(),new File(this.createfile.getApplicationTablePath()));
	 
		 /*
		 Zip zip=new Zip();
		 zip.zip(this.createfile.getApplicationZipPath(),new File(this.createfile.getApplicationTablePath()));
			*/
		 return true;
	}

	

	public List<String > getItemsList(){
		 List<String >  list =new ArrayList<String>();
		 
		 list.add("vill");
		 list.add("city");
		 list.add("country");
		 list.add("town");
		 list.add("total");
		 list.add("start");
		 list.add("evalseq");
		 list.add("sevalIndname");
		 list.add("evalIndname");
		 list.add("evalname");
		 list.add("value");
		 list.add("evalmeth");
		 list.add("score");
		 list.add("constat");
		 list.add("impromeas");
		 list.add("toscore");
		 return list;
	 }

	public void setMeasDAO(PrmtMeasDAO measDAO) {
		this.measDAO = measDAO;
	}

	public PrmtMeasDAO getMeasDAO() {
		return measDAO;
	}

	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}

	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}
}
