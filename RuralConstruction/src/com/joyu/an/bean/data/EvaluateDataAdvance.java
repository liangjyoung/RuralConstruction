package com.joyu.an.bean.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wolffery on 2017-02-14.
 * 诊断提升措施
 */

public class EvaluateDataAdvance implements Serializable {
	
	private static final long serialVersionUID = 2310845397171898756L;
    private String content;//内容
    private String unit;//单位
    private Float number;//数量
    private Integer score;//预计提升分数
    private String acode;//行政区划代码
    private String micode;//模板项目代码
    private Date writeDate;//填写时间

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getMicode() {
        return micode;
    }

    public void setMicode(String micode) {
        this.micode = micode;
    }

    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }


}
