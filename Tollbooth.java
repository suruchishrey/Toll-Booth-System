/**
 * Author - Suruchi Shrey
 * Enrollment no.- BT18CSE014
 */

public interface Tollbooth {
    public double calculateToll(Truck truck);
    public void displayData();
    public void cashRemoval();
    public void storeReceipt();
    public void datewiseCollection(String d1,String d2);
}
