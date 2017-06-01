package com.joyu.an.bean;

import com.joyu.an.bean.data.CollectDataFile;
import com.joyu.an.bean.data.CollectDataItem;
import com.joyu.an.bean.data.EvaluateDataAdvance;
import com.joyu.an.bean.data.EvaluateDataItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wolffery on 2017-04-06.
 */

public class UploadDataBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4136729300131053490L;
	private String areaCode;//村庄编码
    private String userCode;//平板电脑机器码/用户
    private List<CollectDataItem> collectDataItemList;//采集数据列表
    private List<CollectDataFile> collectDataFileList;//采集文件（附件）列表
    private List<EvaluateDataItem> evaluateDataItemList;//自评得分列表
    private List<EvaluateDataAdvance> evaluateDataAdvanceList;//诊断提升措施列表

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<CollectDataItem> getCollectDataItemList() {
        return collectDataItemList;
    }

    public void setCollectDataItemList(List<CollectDataItem> collectDataItemList) {
        this.collectDataItemList = collectDataItemList;
    }

    public List<CollectDataFile> getCollectDataFileList() {
        return collectDataFileList;
    }

    public void setCollectDataFileList(List<CollectDataFile> collectDataFileList) {
        this.collectDataFileList = collectDataFileList;
    }

    public List<EvaluateDataItem> getEvaluateDataItemList() {
        return evaluateDataItemList;
    }

    public void setEvaluateDataItemList(List<EvaluateDataItem> evaluateDataItemList) {
        this.evaluateDataItemList = evaluateDataItemList;
    }

    public List<EvaluateDataAdvance> getEvaluateDataAdvanceList() {
        return evaluateDataAdvanceList;
    }

    public void setEvaluateDataAdvanceList(List<EvaluateDataAdvance> evaluateDataAdvanceList) {
        this.evaluateDataAdvanceList = evaluateDataAdvanceList;
    }
}
