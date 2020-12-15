/**
 * Author - Suruchi Shrey
 * Enrollment no.- BT18CSE014
 */

public class BarCode {
    final private int axles;
    final private int truckid;
    
    public BarCode()
    {
        this.axles=0;
        this.truckid=0;
    }
    
    public BarCode(int axles,int tid)
    {
        this.axles=axles;
        this.truckid=tid;
    }
    
    public int getAxles()
    {
        return this.axles;
    }
    
    public  int getTruckId()
    {
        return this.truckid;
    }
}
