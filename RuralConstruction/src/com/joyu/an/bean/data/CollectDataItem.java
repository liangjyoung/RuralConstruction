package com.joyu.an.bean.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wolffery on 2017-02-14.
 * 采集数据
 */

public class CollectDataItem implements Serializable {
	private static final long serialVersionUID = 6589846712857571140L;
    private String value;//本次采集的数据
    private String remark;//备注
    private Date writeDate;//填写时间
    private String acode;//行政区划代码
    private String micode;//模板项目代码

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
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
}
