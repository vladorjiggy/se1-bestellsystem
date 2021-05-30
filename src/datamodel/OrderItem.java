package datamodel;

public class OrderItem {
    String description;
    final Article article;
    int unitsOrdered;

    protected OrderItem(String description, Article article, int unitsOrdered){
        this.description = description;
        this.article = article;
        this.unitsOrdered = unitsOrdered;
    }

    /**
     * GETTERS
     */

    public String getDescription(){
        return this.description;
    }

    public Article getArticle(){
        return this.article;
    }

    public int getUnitsOrdered(){
        return this.unitsOrdered;
    }

    /**
     * SETTERS
     */

    public void setDescription(String description){
        this.description = description;
    }

    public void setUnitsOrdered(int unitsOrdered){
        this.unitsOrdered = unitsOrdered;
    }
}
