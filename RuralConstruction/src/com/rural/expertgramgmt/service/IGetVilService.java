package com.rural.expertgramgmt.service;

import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;

public interface IGetVilService {

	List<TownBasicInfo> getTownsByCountryId(Integer countryBasicInfoId);

	List<VilBasicInfo> getVilsByTownId(Integer townBasicInfoId);

	List<CountryBasicInfo> getCountriesByCityId(Integer cityBasicInfoId);

	List<CityBasicInfo> getCitiesByProId(int proid);

	Integer getCityIdByCityNum(String diviCode);

	Integer getCountryIdByCountryNum(String diviCode);

	Integer getTownIdByTownNum(String diviCode);

}
