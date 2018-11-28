package mvc;

/**
 *
 * @author Sang To
 * @version 1.0
 */
public enum RoomType {

    LUXURY(300), ECONOMY(100);

    private double price;

    RoomType(double p) {
        price = p;
    }

    public double getPrice() {
        return price;
    }
}
