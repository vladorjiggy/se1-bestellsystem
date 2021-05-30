package datamodel;

public class Customer {
    final String id;
    String firstName;
    String lastName;
    String contact;

    protected Customer(String id, String name, String contact){
        this.lastName = name;
        this.firstName = "";
        this.id = id;
        this.contact = contact;
    }

    /**
     * GETTERS
     * 
     */
    public String getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getContact(){
        return this.contact;
    }

    /**
    * SETTERS
    * 
    */

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setContact(String contact){
        this.contact = contact;
    }
}
