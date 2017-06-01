package com.rural.bean;

/**
 * PrmtMeas entity. @author MyEclipse Persistence Tools
 */

public class PrmtMeas implements java.io.Serializable {

	 // Fields    

    private Integer prmtMeasId;
    private EvalContSubSco evalContSubSco;
    private String prmtMeas;
    private String prmtMeasComp;
    private String prmtMeasValue;
    private String expectPrmtSco;
    private String prmtMeasNote;


   // Constructors

   /** default constructor */
   public PrmtMeas() {
   }

   
   /** full constructor */
   public PrmtMeas(EvalContSubSco evalContSubSco, String prmtMeas, String prmtMeasComp, String prmtMeasValue, String expectPrmtSco, String prmtMeasNote) {
       this.evalContSubSco = evalContSubSco;
       this.prmtMeas = prmtMeas;
       this.prmtMeasComp = prmtMeasComp;
       this.prmtMeasValue = prmtMeasValue;
       this.expectPrmtSco = expectPrmtSco;
       this.prmtMeasNote = prmtMeasNote;
   }

  
   // Property accessors

   public Integer getPrmtMeasId() {
       return this.prmtMeasId;
   }
   
   public void setPrmtMeasId(Integer prmtMeasId) {
       this.prmtMeasId = prmtMeasId;
   }

   public EvalContSubSco getEvalContSubSco() {
       return this.evalContSubSco;
   }
   
   public void setEvalContSubSco(EvalContSubSco evalContSubSco) {
       this.evalContSubSco = evalContSubSco;
   }

   public String getPrmtMeas() {
       return this.prmtMeas;
   }
   
   public void setPrmtMeas(String prmtMeas) {
       this.prmtMeas = prmtMeas;
   }

   public String getPrmtMeasComp() {
       return this.prmtMeasComp;
   }
   
   public void setPrmtMeasComp(String prmtMeasComp) {
       this.prmtMeasComp = prmtMeasComp;
   }

   public String getPrmtMeasValue() {
       return this.prmtMeasValue;
   }
   
   public void setPrmtMeasValue(String prmtMeasValue) {
       this.prmtMeasValue = prmtMeasValue;
   }

   public String getExpectPrmtSco() {
       return this.expectPrmtSco;
   }
   
   public void setExpectPrmtSco(String expectPrmtSco) {
       this.expectPrmtSco = expectPrmtSco;
   }

   public String getPrmtMeasNote() {
       return this.prmtMeasNote;
   }
   
   public void setPrmtMeasNote(String prmtMeasNote) {
       this.prmtMeasNote = prmtMeasNote;
   }

}