package com.joyu.an.bean;

import com.joyu.an.bean.data.Area;
import com.joyu.an.bean.data.CollectModel;
import com.joyu.an.bean.data.CollectModelItem;
import com.joyu.an.bean.data.Dictionary;
import com.joyu.an.bean.data.DictionaryType;
import com.joyu.an.bean.data.EvaluateCollectItemIds;
import com.joyu.an.bean.data.EvaluateModel;
import com.joyu.an.bean.data.EvaluateModelItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wolffery on 2017-04-06.
 */

public class BaseDataBean implements Serializable {

    private List<Area> areaList;//行政区划列表
    private List<DictionaryType> dictionaryTypeList;//数据字典类型列表
    private List<Dictionary> dictionaryList;//数据字典条目列表
    private List<CollectModel> collectModelList;//采集模板列表
    private List<CollectModelItem> collectModelItemList;//采集对象列表
    private List<EvaluateModel> evaluateModelList;//评价指标体系列表
    private List<EvaluateModelItem> evaluateModelItemList;//评价规则（属性、条目）列表
    private List<EvaluateCollectItemIds> evaluateCollectItemIdsList;//评价采集对照表

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public List<DictionaryType> getDictionaryTypeList() {
        return dictionaryTypeList;
    }

    public void setDictionaryTypeList(List<DictionaryType> dictionaryTypeList) {
        this.dictionaryTypeList = dictionaryTypeList;
    }

    public List<Dictionary> getDictionaryList() {
        return dictionaryList;
    }

    public void setDictionaryList(List<Dictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }

    public List<CollectModel> getCollectModelList() {
        return collectModelList;
    }

    public void setCollectModelList(List<CollectModel> collectModelList) {
        this.collectModelList = collectModelList;
    }

    public List<CollectModelItem> getCollectModelItemList() {
        return collectModelItemList;
    }

    public void setCollectModelItemList(List<CollectModelItem> collectModelItemList) {
        this.collectModelItemList = collectModelItemList;
    }

    public List<EvaluateModel> getEvaluateModelList() {
        return evaluateModelList;
    }

    public void setEvaluateModelList(List<EvaluateModel> evaluateModelList) {
        this.evaluateModelList = evaluateModelList;
    }

    public List<EvaluateModelItem> getEvaluateModelItemList() {
        return evaluateModelItemList;
    }

    public void setEvaluateModelItemList(List<EvaluateModelItem> evaluateModelItemList) {
        this.evaluateModelItemList = evaluateModelItemList;
    }

    public List<EvaluateCollectItemIds> getEvaluateCollectItemIdsList() {
        return evaluateCollectItemIdsList;
    }

    public void setEvaluateCollectItemIdsList(List<EvaluateCollectItemIds> evaluateCollectItemIdsList) {
        this.evaluateCollectItemIdsList = evaluateCollectItemIdsList;
    }
}
