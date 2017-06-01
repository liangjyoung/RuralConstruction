package com.joyu.an.bean.data;

import java.io.Serializable;

/**
 * Created by wolffery on 2017-02-14.
 * 评价规则与采集对象对照表
 */

public class EvaluateCollectItemIds implements Serializable {

    private String evaluateItemCode;//评价规则编码
    private String collectItemCode;//采集对象（属性）编码
    private String valueStr;//计分值
    private String remark;//备注说明
    private Boolean isMus;//是否必填

    public String getEvaluateItemCode() {
        return evaluateItemCode;
    }

    public void setEvaluateItemCode(String evaluateItemCode) {
        this.evaluateItemCode = evaluateItemCode;
    }

    public String getCollectItemCode() {
        return collectItemCode;
    }

    public void setCollectItemCode(String collectItemCode) {
        this.collectItemCode = collectItemCode;
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIsMus() {
        return isMus;
    }

    public void setIsMus(Boolean mus) {
        isMus = mus;
    }

}
