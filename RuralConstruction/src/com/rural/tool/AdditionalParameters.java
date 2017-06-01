package com.rural.tool;

import java.util.Map;
import org.apache.struts2.json.annotations.JSON;
public class AdditionalParameters  
{  
    /** 
     * node id 
     */  
    private String id;  
      
    /** 
     * subnode ifno 
     */  
    private Map<String,Item> children;  
      
    /** 
     * node chosen 
     */  
  
    private boolean itemSelected ;  
  
      
    public String getId( )  
    {  
        return id;  
    }  
  
      
    public void setId( String id )  
    {  
        this.id = id;  
    }  
  
      
      
    public Map<String, Item> getChildren( )  
    {  
        return children;  
    }  
  
  
      
    public void setChildren( Map<String, Item> children )  
    {  
        this.children = children;  
    }  
  
    @JSON(name="item-selected")
    public boolean isItemSelected( )  
    {  
        return itemSelected;  
    }  
  
      
    public void setItemSelected( boolean itemSelected )  
    {  
        this.itemSelected = itemSelected;  
    }  
      
      
}  