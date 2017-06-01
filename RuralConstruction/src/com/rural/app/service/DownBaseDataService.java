package com.rural.app.service;

import java.util.ArrayList;
import java.util.List;

import com.joyu.an.bean.BaseDataBean;
import com.joyu.an.bean.data.Area;
import com.joyu.an.bean.data.CollectModel;
import com.joyu.an.bean.data.CollectModelItem;
import com.joyu.an.bean.data.Dictionary;
import com.joyu.an.bean.data.DictionaryType;
import com.joyu.an.bean.data.EvaluateCollectItemIds;
import com.joyu.an.bean.data.EvaluateModel;
import com.joyu.an.bean.data.EvaluateModelItem;
import com.rural.bean.CityBasicInfo;

import com.rural.bean.CitysCont;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.CountryCont;
import com.rural.bean.DataCollDataDic;
import com.rural.bean.DataCollDicEntry;
import com.rural.bean.EvalCont;
import com.rural.bean.EvalContInvesObj;
import com.rural.bean.EvalSyst;
import com.rural.bean.EvalSystInd;
import com.rural.bean.EvalSystState;
import com.rural.bean.InvesObj;
import com.rural.bean.InvesPro;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.TownCont;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilCont;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CitysContDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.CountryContDAO;
import com.rural.dao.DataCollDataDicDAO;
import com.rural.dao.DataCollDicEntryDAO;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.EvalSystDAO;
import com.rural.dao.EvalSystIndDAO;
import com.rural.dao.EvalSystStateDAO;
import com.rural.dao.InvesObjDAO;
import com.rural.dao.InvesProDAO;
import com.rural.dao.ProBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.TownContDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilContDAO;

public class DownBaseDataService implements IDownBaseDataService{
	private ProBasicInfoDAO proBasicInfoDAO = new ProBasicInfoDAO();
	private CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private CitysContDAO citysContDAO = new CitysContDAO();
	private CountryContDAO countryContDAO = new CountryContDAO();
	private TownContDAO townContDAO = new TownContDAO();
	private VilContDAO vilContDAO = new VilContDAO();
	private DataCollDataDicDAO dataCollDataDicDAO = new DataCollDataDicDAO();
	private DataCollDicEntryDAO dataCollDicEntryDAO = new DataCollDicEntryDAO();
	private InvesProDAO invesProDAO = new InvesProDAO();
	private InvesObjDAO invesObjDAO = new InvesObjDAO();
	private EvalSystStateDAO evalSystStateDAO = new EvalSystStateDAO();
	private EvalSystDAO evalSystDAO = new EvalSystDAO();
	private EvalSystIndDAO evalSystIndDAO =  new EvalSystIndDAO();
	private EvalContDAO evalContDAO = new EvalContDAO();
	private EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
    public static int totalRows = 0;
    public static int handleRows = 0;
	
	public BaseDataBean downApp() {
		// TODO Auto-generated method stub
		BaseDataBean baseDataBean = new BaseDataBean();
		/*
		 * 乡政区划
		 * */
		List<Area> areaList = new ArrayList<Area>();
		
		//获得省的信息
		ProBasicInfo proBasicInfo = new ProBasicInfo();
		proBasicInfo = proBasicInfoDAO.findById(1);
		//获得上级单位编码
		String fcode = proBasicInfo.getProNum();
	
		
		//获得市的信息
		List<CityBasicInfo> cityBasicInfoList = cityBasicInfoDAO.findByProperty("proBasicInfo.proBasicInfoId", proBasicInfo.getProBasicInfoId());
		for (CityBasicInfo cityBasicInfo : cityBasicInfoList) {
			Area area = new Area();
			area.setFcode(null);
			area.setId(Long.valueOf(cityBasicInfo.getCityBasicInfoId()));
			area.setName(cityBasicInfo.getCityName());
			area.setCode(cityBasicInfo.getCityNum());
			//获得市联系人
			List<CitysCont> citysContList =citysContDAO.findByProperty("cityBasicInfo.cityBasicInfoId", cityBasicInfo.getCityBasicInfoId());
			for (CitysCont citysCont : citysContList) {
				area.setContactsName1(citysCont.getCitysContName());
				if (citysCont.getCitysContMobTel()==null) {
					area.setContactsTel1(citysCont.getCitysContWorkTel());
				} else {
					area.setContactsTel1(citysCont.getCitysContMobTel());
				}
			
				break;
			}
		
			areaList.add(area);
			
			//获得县信息
			List<CountryBasicInfo> countryBasicInfolist = countryBasicInfoDAO.findByProperty("cityBasicInfo.cityBasicInfoId", cityBasicInfo.getCityBasicInfoId()) ;
			for (CountryBasicInfo countryBasicInfo : countryBasicInfolist) {
				Area areacountyr = new Area();
				areacountyr.setId(Long.valueOf(countryBasicInfo.getCountryBasicInfoId()));
				areacountyr.setCode(countryBasicInfo.getCountryNum());
				areacountyr.setName(countryBasicInfo.getCountryName());
				areacountyr.setFcode(cityBasicInfo.getCityNum());
				List<CountryCont> countryContList = countryContDAO.findByProperty("countryBasicInfo.countryBasicInfoId", countryBasicInfo.getCountryBasicInfoId());
				for (CountryCont countryCont : countryContList) {
					areacountyr.setContactsName1(countryCont.getCountryContName());
					if (countryCont.getCountryContMobTel()==null) {
						areacountyr.setContactsTel1(countryCont.getCountryContWorkTel());
					} else {
						areacountyr.setContactsTel1(countryCont.getCountryContMobTel());
					}
					
					break;
				}
				areaList.add(areacountyr);
				
				//获得镇信息
				List<TownBasicInfo> townBasicInfoList = townBasicInfoDAO.findByProperty("countryBasicInfo.countryBasicInfoId", countryBasicInfo.getCountryBasicInfoId());
				for (TownBasicInfo townBasicInfo : townBasicInfoList) {
					Area areatown = new Area();
					areatown.setId(Long.valueOf(townBasicInfo.getTownBasicInfoId()));
					areatown.setCode(townBasicInfo.getTownNum());
					areatown.setName(townBasicInfo.getTownName());
					areatown.setFcode(countryBasicInfo.getCountryNum());
					List<TownCont> townContslist = townContDAO.findByProperty("townBasicInfo.townBasicInfoId",townBasicInfo.getTownBasicInfoId());
					for (TownCont townCont : townContslist) {
						areatown.setContactsName1(townCont.getTownContName());
						if (townCont.getTownContMobTel()==null) {
							areatown.setContactsTel1(townCont.getTownContWorkTel());
						} else {
							areatown.setContactsTel1(townCont.getTownContMobTel());
						}
					
						break;
					}
					areaList.add(areatown);
					
					//获得村信息
					List<VilBasicInfo> vilBasicInfoslist = vilBasicInfoDAO.findByProperty("townBasicInfo.townBasicInfoId",townBasicInfo.getTownBasicInfoId());
					for (VilBasicInfo vilBasicInfo : vilBasicInfoslist) {
						Area areavill = new Area();
						areavill.setId(Long.valueOf(vilBasicInfo.getVilBasicInfoId()));
						areavill.setCode(vilBasicInfo.getVilNum());
						areavill.setName(vilBasicInfo.getVilName());
						areavill.setFcode(townBasicInfo.getTownNum());
						List<VilCont> vilContslsit = vilContDAO.findByProperty("vilBasicInfo.vilBasicInfoId", vilBasicInfo.getVilBasicInfoId());
						for (VilCont vilCont : vilContslsit) {
							areavill.setContactsName1(vilCont.getVilContName());
							if (vilCont.getVilContMobTel()==null) {
								areavill.setContactsTel1(vilCont.getVilContWorkTel());
							} else {
								areavill.setContactsTel1(vilCont.getVilContMobTel());
							}
							
							break;
						}
						handleRows++;
					areaList.add(areavill);
					}
				}
			}
		}
		//将行政区划的list加入到basedata的对象中
		baseDataBean.setAreaList(areaList);
		
		/*
		 * 数据字典类型
		 * */
		List<DictionaryType> dictionaryTypesList = new ArrayList<DictionaryType>();
		List<DataCollDataDic> dataCollDataDicslist=dataCollDataDicDAO.findAll();
		for (DataCollDataDic dataCollDataDic : dataCollDataDicslist) {
			DictionaryType dictionaryType = new DictionaryType();
			dictionaryType.setCode(dataCollDataDic.getDataDicCode());
			dictionaryType.setMultiSelect(dataCollDataDic.getIsdChoDic());
			dictionaryType.setName(dataCollDataDic.getDataDicName());
			handleRows++;
			dictionaryTypesList.add(dictionaryType);
		}
		baseDataBean.setDictionaryTypeList(dictionaryTypesList);
		
		
		/*
		 * 数据字典条目
		 * */
		List<Dictionary> dictionaryList = new ArrayList<Dictionary>();
		List<DataCollDicEntry> dataCollDicEntrieslist = dataCollDicEntryDAO.findAll();
		for (DataCollDicEntry dataCollDicEntry : dataCollDicEntrieslist) {
			Dictionary dictionary = new Dictionary();
			dictionary.setCode(dataCollDicEntry.getDicEntryCode());
			dictionary.setName(dataCollDicEntry.getDicEntryName());
			dictionary.setTypeCode(dataCollDicEntry.getDataCollDataDic().getDataDicCode());
			handleRows++;
			dictionaryList.add(dictionary);
		}
		baseDataBean.setDictionaryList(dictionaryList);
		
		
		/*
		 * 采集模板列表
		 * */
		List<CollectModel> collectModelList = new ArrayList<CollectModel>();
		List<InvesPro> invesProslist = invesProDAO.findAll();
		for (InvesPro invesPro : invesProslist) {
			CollectModel collectModel = new CollectModel();
			collectModel.setCode(invesPro.getInvesProNum());
			if (invesPro.getInvesPro() == null) {
				collectModel.setFcode(null);
			} else {
				collectModel.setFcode(invesPro.getInvesPro().getInvesProNum());
			}
			
			collectModel.setName(invesPro.getInvesProName());
			collectModel.setRemark(invesPro.getInvesProNote());
			handleRows++;
			collectModelList.add(collectModel);
		}
		baseDataBean.setCollectModelList(collectModelList);
		
		/*
		 *采集对象列表 
		 * 
		*/
		List<CollectModelItem> collectModelItemList = new ArrayList<CollectModelItem>();
		List<InvesObj> invesObjslist = invesObjDAO.findAll();
		for (InvesObj invesObj : invesObjslist) {
			CollectModelItem collectModelItem = new CollectModelItem();
			collectModelItem.setCode(invesObj.getInvesObjCode());
			collectModelItem.setName(invesObj.getInvesObjName());
			collectModelItem.setUnit(invesObj.getInvesObjComp());
			if (invesObj.getDataCollDataDic() == null) {
				collectModelItem.setDictTypeCode(null);
			} 
			else {
				//collectModelItem.setDictTypeCode(null);
				collectModelItem.setDictTypeCode(invesObj.getDataCollDataDic().getDataDicCode());
			}
			if (invesObj.getInvesObjAttri()== null) {
				collectModelItem.setTypeId(null);
			} else {
				collectModelItem.setTypeId(invesObj.getInvesObjAttri().getInvesObjAttriId());
			}
			
			if (invesObj.getInvesObjLengt() == null) {
				collectModelItem.setLength(null);
			} else {
				//collectModelItem.setLength(null);
				collectModelItem.setLength(Integer.parseInt(invesObj.getInvesObjLengt()));
			}
			collectModelItem.setLength(null);
			collectModelItem.setRequired(invesObj.getIsMustCollData());
			collectModelItem.setRemark(invesObj.getInvesObjNote());
			if (invesObj.getInvesPro()==null) {
				collectModelItem.setMcode(null);
			} else {
				collectModelItem.setMcode(invesObj.getInvesPro().getInvesProNum());
			}
			handleRows++;
			collectModelItemList.add(collectModelItem);
		}
		baseDataBean.setCollectModelItemList(collectModelItemList); 
		
		/*
		 * 评价指标体系
		 * 
		*/
		List<EvaluateModel> evaluateModelList = new ArrayList<EvaluateModel>();
		List<EvalSystState> evalSystStateslist = evalSystStateDAO.findByEvalSystStateDes("在使用");
		int evalsysstateid = 0;;
		for (EvalSystState evalSystState : evalSystStateslist) {
			evalsysstateid = evalSystState.getEvalSystStateId();
			break;
		}
		int evalsysid = 0;
		String evalsysnum ="";
		List<EvalSyst> evalSystslist = evalSystDAO.findByProperty("evalSystState.evalSystStateId", evalsysstateid);
		for (EvalSyst evalSyst : evalSystslist) {
			evalsysid = evalSyst.getEvalSystId();
			evalsysnum = evalSyst.getEvalSystNote();
			break;
		}
		List<EvalSystInd> evalSystIndslist = evalSystIndDAO.findByProperty("evalSyst.evalSystId", evalsysid);
		for (EvalSystInd evalSystInd : evalSystIndslist) {
			EvaluateModel evaluateModel = new EvaluateModel();
			evaluateModel.setCode(evalSystInd.getEvalIndNum());
			if (evalSystInd.getEvalSystInd() == null) {
				evaluateModel.setFcode(null);
			} else {
				evaluateModel.setFcode(evalSystInd.getEvalSystInd().getEvalIndNum() );
			}
			evaluateModel.setName(evalSystInd.getEvalIndName());
			evaluateModel.setNum(evalSystInd.getEvalIndSeqNum());
			evaluateModel.setRemark(evalSystInd.getEvalIndNote());
			evaluateModel.setScore(Integer.parseInt(evalSystInd.getEvalIndScore()));
			handleRows++;
			evaluateModelList.add(evaluateModel);
		}
		baseDataBean.setEvaluateModelList(evaluateModelList);
		
		
		/*
		 * 评价规则
		 * */
		List<EvaluateModelItem> evaluateModelItemList = new ArrayList<EvaluateModelItem>();
		List<EvaluateCollectItemIds> evaluateCollectItemIdsList = new ArrayList<EvaluateCollectItemIds>();
		//evalsysnum
		List<EvalCont> evalContslist = evalContDAO.findBycondition(evalsysnum);
		for (EvalCont evalCont : evalContslist) {
			EvaluateModelItem evaluateModelItem = new EvaluateModelItem();
			evaluateModelItem.setCalculateType(Integer.parseInt(evalCont.getSubjObjecValu()));
			evaluateModelItem.setCode(evalCont.getEvalContNum());
			if (evalCont.getEvalSystInd() == null) {
				evaluateModelItem.setMcode(null);
			} else {
				evaluateModelItem.setMcode(evalCont.getEvalSystInd().getEvalIndNum());
			}
			evaluateModelItem.setMethod(evalCont.getEvalContScorMeth());
			evaluateModelItem.setNum(evalCont.getEvalContSeqNum());
			evaluateModelItem.setRemark(evalCont.getEvalContNote());
			evaluateModelItem.setRequire(evalCont.getBulReq());
			evaluateModelItem.setScore(null);
			if (evalCont.getEvalContScore() == null) {
				evaluateModelItem.setScore(null);
			} else {
				evaluateModelItem.setScore(Integer.parseInt(evalCont.getEvalContScore()));
			}
		//	evaluateModelItem.setScore(Integer.parseInt(evalCont.getEvalContScore()));
			evaluateModelItem.setTitle(evalCont.getEvalContDes());
			
			evaluateModelItemList.add(evaluateModelItem);
			
			
			/*
			 * 评价采集对照表
			 * */
			List<EvalContInvesObj> contInvesObjslist = evalContInvesObjDAO.findByProperty("evalCont.evalContId",evalCont.getEvalContId());
			if (contInvesObjslist.size() > 0) {
				for (EvalContInvesObj evalContInvesObj : contInvesObjslist) {
					EvaluateCollectItemIds evaluateCollectItemIds = new EvaluateCollectItemIds();
					evaluateCollectItemIds.setEvaluateItemCode(evalContInvesObj.getEvalCont().getEvalContNum());
					if (evalContInvesObj.getInvesObj() == null) {
						evaluateCollectItemIds.setCollectItemCode(null);
					} else {
						evaluateCollectItemIds.setCollectItemCode(evalContInvesObj.getInvesObj().getInvesObjCode());
					}
					evaluateCollectItemIds.setIsMus(evalContInvesObj.getIsMus());
					evaluateCollectItemIds.setRemark(evalContInvesObj.getEvalContInvesObjNote());
					evaluateCollectItemIds.setValueStr(evalContInvesObj.getEvalContInvesObjScorValu());
					handleRows++;
					evaluateCollectItemIdsList.add(evaluateCollectItemIds);
				}
			} else {
				continue;
			}
		}
		baseDataBean.setEvaluateModelItemList(evaluateModelItemList);
		baseDataBean.setEvaluateCollectItemIdsList(evaluateCollectItemIdsList);
		
		
		
		return baseDataBean;
	}


	public ProBasicInfoDAO getProBasicInfoDAO() {
		return proBasicInfoDAO;
	}


	public void setProBasicInfoDAO(ProBasicInfoDAO proBasicInfoDAO) {
		this.proBasicInfoDAO = proBasicInfoDAO;
	}


	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}


	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
	}


	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}


	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}


	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}


	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}


	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}


	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}


	public CitysContDAO getCitysContDAO() {
		return citysContDAO;
	}


	public void setCitysContDAO(CitysContDAO citysContDAO) {
		this.citysContDAO = citysContDAO;
	}


	public CountryContDAO getCountryContDAO() {
		return countryContDAO;
	}


	public void setCountryContDAO(CountryContDAO countryContDAO) {
		this.countryContDAO = countryContDAO;
	}


	public TownContDAO getTownContDAO() {
		return townContDAO;
	}


	public void setTownContDAO(TownContDAO townContDAO) {
		this.townContDAO = townContDAO;
	}


	public VilContDAO getVilContDAO() {
		return vilContDAO;
	}


	public void setVilContDAO(VilContDAO vilContDAO) {
		this.vilContDAO = vilContDAO;
	}


	public DataCollDataDicDAO getDataCollDataDicDAO() {
		return dataCollDataDicDAO;
	}


	public void setDataCollDataDicDAO(DataCollDataDicDAO dataCollDataDicDAO) {
		this.dataCollDataDicDAO = dataCollDataDicDAO;
	}


	public DataCollDicEntryDAO getDataCollDicEntryDAO() {
		return dataCollDicEntryDAO;
	}


	public void setDataCollDicEntryDAO(DataCollDicEntryDAO dataCollDicEntryDAO) {
		this.dataCollDicEntryDAO = dataCollDicEntryDAO;
	}


	public InvesProDAO getInvesProDAO() {
		return invesProDAO;
	}


	public void setInvesProDAO(InvesProDAO invesProDAO) {
		this.invesProDAO = invesProDAO;
	}


	public void setInvesObjDAO(InvesObjDAO invesObjDAO) {
		this.invesObjDAO = invesObjDAO;
	}


	public InvesObjDAO getInvesObjDAO() {
		return invesObjDAO;
	}


	public EvalSystStateDAO getEvalSystStateDAO() {
		return evalSystStateDAO;
	}


	public void setEvalSystStateDAO(EvalSystStateDAO evalSystStateDAO) {
		this.evalSystStateDAO = evalSystStateDAO;
	}


	public EvalSystDAO getEvalSystDAO() {
		return evalSystDAO;
	}


	public void setEvalSystDAO(EvalSystDAO evalSystDAO) {
		this.evalSystDAO = evalSystDAO;
	}


	public EvalSystIndDAO getEvalSystIndDAO() {
		return evalSystIndDAO;
	}


	public void setEvalSystIndDAO(EvalSystIndDAO evalSystIndDAO) {
		this.evalSystIndDAO = evalSystIndDAO;
	}


	public EvalContDAO getEvalContDAO() {
		return evalContDAO;
	}


	public void setEvalContDAO(EvalContDAO evalContDAO) {
		this.evalContDAO = evalContDAO;
	}


	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}


	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

}
