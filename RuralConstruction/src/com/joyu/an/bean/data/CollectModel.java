package com.joyu.an.bean.data;

import java.io.Serializable;

/**
 * Created by wolffery on 2017-02-14.
 * 采集模板（项目）
 */

public class CollectModel implements Serializable {

    private static final long serialVersionUID = 6589846712857571140L;
    private String code;//编码
    private String name;//名称
    private String remark;//备注
    private String fcode;//上级项目代码


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }
}
