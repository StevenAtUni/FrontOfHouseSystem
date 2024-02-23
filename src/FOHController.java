public class FOHController implements FOHManagementInterface, FOHKitchenInterface {
    // Class name may be changed at a later date when we figure out how we will implement our system/code.

    @Override
    public void sendMenu(Object[][] menu, Object[][] drinksMenu, Object[][] wineMenu) {
    }

    @Override
    public int getAmountBooked(int timestamp) {
        return 0;
    }

    @Override
    public void setServiceCharge(int newCharge) {
    }

    @Override
    public void markItemComplete(int orderID, int itemID) {
    }

    @Override
    public void markItemUnavailable(int itemID) {
    }

    @Override
    public Object[][] getOrders() {
        return null;
    }
}
