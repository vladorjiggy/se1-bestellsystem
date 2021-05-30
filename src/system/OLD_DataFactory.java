package system;

import datamodel.Article;
import datamodel.Customer;
import datamodel.Order;
import datamodel.OrderItem;

final class OLD_DataFactory implements Components.DataFactory{

    
    //public DataFactory datafactory;
    public InventoryManager inventoryManager;
    public OutputProcessor outputProcessor;

    OLD_DataFactory(InventoryManager inventoryManager, OutputProcessor outputProcessor){
        //this.datafactory = new DataFactory(inventoryManager, outputProcessor);
        this.inventoryManager = inventoryManager;
        this.outputProcessor = outputProcessor;
    }

    @Override
    public Customer createCustomer(String name, String contact) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Article createArticle(String descr, long price, int units) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Order createOrder(Customer customer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OrderItem createOrderItem(String descr, Article article, int units) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
