package com.rural.tool;

public class Item  
{  
    /** 
     * node name 
     */  
    private String name;  
      
    /** 
     * node type:'folder' or 'item' 
     */  
    private String type;  
      
    /** 
     * node parameters info and subnode info 
     */  
    private AdditionalParameters additionalParameters;  
  
      
    
  
      
    public String getType( )  
    {  
        return type;  
    }  
  
      
    public void setType( String type )  
    {  
        this.type = type;  
    }  
  
      
    public AdditionalParameters getAdditionalParameters( )  
    {  
        return additionalParameters;  
    }  
  
      
    public void setAdditionalParameters( AdditionalParameters additionalParameters )  
    {  
        this.additionalParameters = additionalParameters;  
    }


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}  
}  