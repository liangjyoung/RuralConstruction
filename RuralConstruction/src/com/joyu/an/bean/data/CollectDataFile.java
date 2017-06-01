package com.joyu.an.bean.data;

import java.io.Serializable;

/**
 * Created by wolffery on 2017-02-14.
 * 采集文件
 */

public class CollectDataFile implements Serializable {
	private static final long serialVersionUID = 6589846712857571140L;
    private String fileName;//采集的文件名称
    private String filePath;//采集的文件相对路径
    private String fileTitle;//采集文件的标题
    private String acode;//行政区划代码
    private String micode;//采集对象编码

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
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
