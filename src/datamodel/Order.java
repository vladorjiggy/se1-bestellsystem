package datamodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * WAS IST MIT addItem(), wenn nur getter und setter existieren sollen
 */

public class Order {
    final long id;
    final Date date;
    final Customer customer;
    final List<OrderItem> items = new ArrayList<OrderItem>();

    protected Order(long id, Date date, Customer customer){
        this.id = id;
        if (date == null){
            this.date = new Date();
        }
        else{
            this.date = date;
        }
        
        this.customer = customer;
    }

    /**
     * GETTERS
     */

    public long getId(){
        return this.id;
    }

    public Date getDate(){
        return this.date;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public Iterable<OrderItem> getItems(){
        return this.items;
    }

    public int count(){
        return this.items.size();
    }

    public Order addItem(OrderItem item){
        if (!this.items.contains(item) && item != null){
            this.items.add(item);
        }        
        return this;
    }

    public Order removeItem(OrderItem item){
        this.items.remove(item);
        return this;
    }

    public Order clearItems(){
        this.items.clear();
        return this;
    }
}
