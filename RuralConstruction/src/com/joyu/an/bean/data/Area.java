package com.joyu.an.bean.data;

import java.io.Serializable;

/**
 * Created by wolffery on 2017-02-14.
 * 行政区划
 */

public class Area implements Serializable {

    private static final long serialVersionUID = 6589846712857571140L;
    private Long id;//代码
    private String code;//编号
    private String name;//名称
    private String fcode;//上级单位编码
    private String contactsName1;//联系人姓名1
    private String contactsTel1;//联系人电话1

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getContactsName1() {
        return contactsName1;
    }

    public void setContactsName1(String contactsName1) {
        this.contactsName1 = contactsName1;
    }

    public String getContactsTel1() {
        return contactsTel1;
    }

    public void setContactsTel1(String contactsTel1) {
        this.contactsTel1 = contactsTel1;
    }
}
