/**
 * Author - Suruchi Shrey
 * Enrollment no.- BT18CSE014
 */

public class TruckType_2 implements Truck{
    private BarCode barcode;
    private Bill bill;
    private static int id=1;
    
    public TruckType_2()
    {}
    
    public TruckType_2(double weight,int axles)
    {
        id+=2;
        this.bill=new Bill(weight);
        this.barcode=new BarCode(axles,id);
    }
    
    public void print()
    {
        System.out.println("Truck make= LandT(TruckType_2)");
    }
    
    public double getWeight()
    {
        return this.bill.getWeight();
    }
    
    public int getAxles()
    {
        return this.barcode.getAxles();
    }
    
    public int getId()
    {
        return this.barcode.getTruckId();
    }
}
