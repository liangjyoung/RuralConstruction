package com.rural.ctvrank.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.EvalSystInd;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;

public interface ICTVRankService {

	List<Integer> getYears(Integer roleId, String diviCode);

	List<CityBasicInfo> getCityByCityNum(String diviCode);
	List<CountryBasicInfo> getCountryByCountryNum(String diviCode);
	List<TownBasicInfo> getTownByTownNum(String diviCode);

	List<CountryBasicInfo> getCountrysByCitys(List<CityBasicInfo> cityBasicInfos);

	List<TownBasicInfo> getTownsByCountrys(
			List<CountryBasicInfo> countryBasicInfos);

	List<VilBasicInfo> getVilsByTowns(List<TownBasicInfo> townBasicInfos);

	Integer DistinguishDivi(String treeDiviCode);

	List<Entry<String, Double>> getScoreInDesc(Integer divi,String treeDiviCode,Integer year);

	List<EvalSystInd> getFirstLevelInds();

	List<Entry<String, Double>> getScoreInDesc(Integer divi,
			String treeDiviCode, Integer year, String selectedFirstLevelInd);

}
