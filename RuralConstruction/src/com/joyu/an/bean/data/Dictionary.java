package com.joyu.an.bean.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-02-14.
 * 数据字典
 */

public class Dictionary implements Serializable {

    private static final long serialVersionUID = 6589846712857571140L;
    private String code;//编码
    private String name;//名称
    private String typeCode;//数据字典类型代码


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
