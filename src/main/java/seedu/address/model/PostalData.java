package seedu.address.model;

/**
 * Represents the a memory model of a postal code.
 */
public class PostalData {

    private final String postal;
    private final double x;
    private final double y;

    public PostalData(String postal, double x, double y) {
        this.postal = postal;
        this.x = x;
        this.y = y;
    }

    public String getPostal() {
        return this.postal;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }


}
