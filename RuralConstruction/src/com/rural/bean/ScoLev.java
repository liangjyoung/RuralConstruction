package com.rural.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * ScoLev entity. @author MyEclipse Persistence Tools
 */

public class ScoLev  implements java.io.Serializable {


    // Fields    

     private Integer scoLevId;
     private String scoLevCode;
     private String scoLevName;
     private Integer scoUp;
     private Integer scoDown;
     private Set vilEvalScos = new HashSet(0);


    // Constructors

    /** default constructor */
    public ScoLev() {
    }

    
    /** full constructor */
    public ScoLev(String scoLevCode, String scoLevName, Integer scoUp, Integer scoDown, Set vilEvalScos) {
        this.scoLevCode = scoLevCode;
        this.scoLevName = scoLevName;
        this.scoUp = scoUp;
        this.scoDown = scoDown;
        this.vilEvalScos = vilEvalScos;
    }

   
    // Property accessors

    public Integer getScoLevId() {
        return this.scoLevId;
    }
    
    public void setScoLevId(Integer scoLevId) {
        this.scoLevId = scoLevId;
    }

    public String getScoLevCode() {
        return this.scoLevCode;
    }
    
    public void setScoLevCode(String scoLevCode) {
        this.scoLevCode = scoLevCode;
    }

    public String getScoLevName() {
        return this.scoLevName;
    }
    
    public void setScoLevName(String scoLevName) {
        this.scoLevName = scoLevName;
    }

    public Integer getScoUp() {
        return this.scoUp;
    }
    
    public void setScoUp(Integer scoUp) {
        this.scoUp = scoUp;
    }

    public Integer getScoDown() {
        return this.scoDown;
    }
    
    public void setScoDown(Integer scoDown) {
        this.scoDown = scoDown;
    }

    public Set getVilEvalScos() {
        return this.vilEvalScos;
    }
    
    public void setVilEvalScos(Set vilEvalScos) {
        this.vilEvalScos = vilEvalScos;
    }
   








}