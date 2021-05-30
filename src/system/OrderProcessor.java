package system;

import datamodel.Order;

final class OrderProcessor implements Components.OrderProcessor{

    //public OrderProcessor orderProcessor;
    public InventoryManager inventoryManager;

    OrderProcessor(InventoryManager inventoryManager){
        //this.orderProcessor = new OrderProcessor(inventoryManager);
        this.inventoryManager = inventoryManager;
    }

    @Override
    public boolean accept(Order order) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public long orderValue(Order order) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long vat(long grossValue) {
        
        return (grossValue/100)*19;
    }

    @Override
    public long vat(long grossValue, int rateIndex) {
        if(rateIndex == 1){
            return (grossValue/100)*19;
        }
        else{
            return (grossValue/100)*7;
        }
        
    }
    
}
