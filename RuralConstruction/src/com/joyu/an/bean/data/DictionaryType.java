package com.joyu.an.bean.data;

import java.io.Serializable;

/**
 * Created by wolffery on 2017-02-14.
 * 数据字典类型
 */

public class DictionaryType implements Serializable {

    private static final long serialVersionUID = 6589846712857571140L;
    private String code;//编码
    private String name;//名称
    private Boolean multiSelect;//是否多选

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

    public Boolean getMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(Boolean multiSelect) {
        this.multiSelect = multiSelect;
    }
}
