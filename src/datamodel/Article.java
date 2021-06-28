package datamodel;

public class Article {
    String id;
    String description;
    long unitPrice;
    int unitsInStore;

    protected Article(String id, String description, long unitPrice, int unitsInStore){
        this.id = id;
        if(description == null){
            this.description = "";
        }
        else{
            this.description = description;
        }
        if(unitsInStore < 0 || unitsInStore == Long.MAX_VALUE){
            this.unitsInStore = 0;
        }
        else{
            this.unitsInStore = unitsInStore;
        }
        if(unitPrice < 0 || unitPrice == Long.MAX_VALUE){
            this.unitPrice = 0;
        }
        else{
            this.unitPrice = unitPrice;
        }
        
    }

    /**
     * GETTERS
     */

    public String getId(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public long getUnitPrice(){
        return this.unitPrice;
    }

    public int getUnitsInStore(){
        return this.unitsInStore;
    }

    /**
     * SETTERS
     */

    public void setDescription(String description){
        if(description == null){
            this.description = "";
        }
        else{
            this.description = description;
        }
    }

    public void setUnitPrice(long unitPrice){
        if(unitPrice < 0 || unitPrice == Long.MAX_VALUE){
            this.unitPrice = 0;
        }
        else{
            this.unitPrice = unitPrice;
        }
        
    }

    public void setUnitsInStore(int unitsInStore){
        if(unitsInStore < 0 || unitsInStore == Integer.MAX_VALUE){
            this.unitsInStore = 0;
        }
        else{
            this.unitsInStore = unitsInStore;
        }

        
    }

}
