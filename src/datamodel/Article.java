package datamodel;

public class Article {
    String id;
    String description;
    long unitPrice;
    int unitsInStore;

    protected Article(String id, String description, long unitPrice, int unitsInStore){
        this.id = id;
        this.description = description;
        this.unitPrice = unitPrice;
        this.unitsInStore = unitsInStore;
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
        this.description = description;
    }

    public void setUnitPrice(long unitPrice){
        this.unitPrice = unitPrice;
    }

    public void setUnitsInStore(int unitsInStore){
        this.unitsInStore = unitsInStore;
    }

}
