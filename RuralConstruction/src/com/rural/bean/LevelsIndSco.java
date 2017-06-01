package com.rural.bean;

import com.rural.bean.EvalSystInd;
import com.rural.bean.VilEvalSco;



/**
 * LevelsIndSco entity. @author MyEclipse Persistence Tools
 */

public class LevelsIndSco  implements java.io.Serializable {


    // Fields    

     private Integer levelsIndScoId;
     private VilEvalSco vilEvalSco;
     private EvalSystInd evalSystInd;
     private String levelsIndSco;


    // Constructors

    /** default constructor */
    public LevelsIndSco() {
    }

    
    /** full constructor */
    public LevelsIndSco(VilEvalSco vilEvalSco, EvalSystInd evalSystInd, String levelsIndSco) {
        this.vilEvalSco = vilEvalSco;
        this.evalSystInd = evalSystInd;
        this.levelsIndSco = levelsIndSco;
    }

   
    // Property accessors

    public Integer getLevelsIndScoId() {
        return this.levelsIndScoId;
    }
    
    public void setLevelsIndScoId(Integer levelsIndScoId) {
        this.levelsIndScoId = levelsIndScoId;
    }

    public VilEvalSco getVilEvalSco() {
        return this.vilEvalSco;
    }
    
    public void setVilEvalSco(VilEvalSco vilEvalSco) {
        this.vilEvalSco = vilEvalSco;
    }

    public EvalSystInd getEvalSystInd() {
        return this.evalSystInd;
    }
    
    public void setEvalSystInd(EvalSystInd evalSystInd) {
        this.evalSystInd = evalSystInd;
    }

    public String getLevelsIndSco() {
        return this.levelsIndSco;
    }
    
    public void setLevelsIndSco(String levelsIndSco) {
        this.levelsIndSco = levelsIndSco;
    }
   








}