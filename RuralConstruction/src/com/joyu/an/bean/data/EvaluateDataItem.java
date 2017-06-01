package com.joyu.an.bean.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wolffery on 2017-02-14.
 * 评价得分情况
 */

public class EvaluateDataItem implements Serializable {

    private static final long serialVersionUID = 6589846712857571140L;
    private Float score;//本次得分
    private Date writeDate;//填写时间
    private String acode;//行政区划代码
    private String micode;//模板项目/评价规则编码

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }

    public String getMicode() {
        return micode;
    }

    public void setMicode(String micode) {
        this.micode = micode;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

}
