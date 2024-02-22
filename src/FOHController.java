public abstract class FOHController implements FOHManagementInterface, FOHKitchenInterface {

    @Override
    public void sendMenu(Object[][] menu) {
    }

    @Override
    public int getAmountBooked(int timestamp) {
        return 0;
    }

    @Override
    public void markOrderComplete(int orderID) {
    }

    @Override
    public void markItemUnavailable(int itemID) {
    }
}
