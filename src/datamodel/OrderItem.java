package datamodel;

public class OrderItem {
    String description;
    final Article article;
    int unitsOrdered;

    protected OrderItem(String description, Article article, int unitsOrdered){
        
        if(description == null){
            this.description = "";
        }
        else{
            this.description = description;
        }
        this.article = article;
        if(unitsOrdered < 0){
            this.unitsOrdered = 0;
        }
        else{
            this.unitsOrdered = unitsOrdered;
        }
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

        if(description == null){
            this.description = "";
        }
        else{
            this.description = description;
        }
    }

    public void setUnitsOrdered(int unitsOrdered){
        if(unitsOrdered < 0){
            this.unitsOrdered = 0;
        }
        else{
            this.unitsOrdered = unitsOrdered;
        }
    }
}
