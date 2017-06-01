package com.rural.townscoreorder.service;

import java.util.List;

import com.rural.bean.EvalSystInd;
import com.rural.bean.LevelsIndSco;
import com.rural.bean.VilBasicInfo;

public interface IFirstLevelScoreOrderService {

	List<EvalSystInd> getFirstLevelInds();
	Integer getTownIdByTownNum(String diviCode);

	List<VilBasicInfo> getVilsByTownId(Integer townId);
	List<LevelsIndSco> getFirstLevelScoresInOrder(List<VilBasicInfo> vils, Integer year, String indNum);

}
