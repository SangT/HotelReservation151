package general;

/**
 * RoomType.java - Define enum type for RoomType
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

    public String toString() {
        switch(this) {
            case LUXURY:
                return "Luxury";
            case ECONOMY:
                return "Economy";
            default:
                return "";
        }
    }
}