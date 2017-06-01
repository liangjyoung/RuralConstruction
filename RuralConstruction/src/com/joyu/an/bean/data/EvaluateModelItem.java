package com.joyu.an.bean.data;

import java.io.Serializable;

/**
 * Created by wolffery on 2017-02-14.
 * 评价规则
 */

public class EvaluateModelItem implements Serializable {

    private static final long serialVersionUID = 6589846712857571140L;
    private String num;//序号
    private String code;//编码
    private String title;//规则描述
    private Integer calculateType;//分值计算类型（主客观值）
    private Integer score;//分值
    private String require;//建设要求
    private String method;//计分方法
    private String remark;//备注
    private String mcode;//评价指标代码


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getCalculateType() {
        return calculateType;
    }

    public void setCalculateType(Integer calculateType) {
        this.calculateType = calculateType;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }
}
