package com.rural.townscoreorder.service;

import java.util.List;

import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilEvalSco;

public interface ITotalScoreOrderService {
	Integer getTownIdByTownNum(String diviCode);

	List<VilBasicInfo> getVilsByTownId(Integer townId);

	List<Integer> getYears(List<VilBasicInfo> vils);

	List<VilEvalSco> getScoresInOrder(List<VilBasicInfo> vils, Integer yr);
}
