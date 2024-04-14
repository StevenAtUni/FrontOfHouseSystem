package FOHInterface.KitchenInterface;

import FOHClasses.Collection.OrderCollection;

public interface IFrontOfHouseKitchenRequests {
    void makeOrder(int orderID, int tableID, int[] dishNumbers, String orderNotes);
    void amendOrderNotes(int orderID, String orderNote);
}

class FOH implements IFrontOfHouseKitchenRequests{

    @Override
    public void makeOrder(int orderID, int tableID, int[] dishNumbers, String orderNotes){
        
    }


    @Override
    public void amendOrderNotes(int orderID, String orderNote){
        OrderCollection.get(orderID).setNotes(orderNote);
    }
}
