/**
 * Author - Suruchi Shrey
 * Enrollment no.- BT18CSE014
 */
package com.mycompany.tollboothsystem;

public class TruckType_1 implements Truck{
    private BarCode barcode;
    private Bill bill;
    private static int truckid=0;
    
    public TruckType_1()
    {}
    
    public TruckType_1(double weight,int axles)
    {
        truckid+=2;
        this.bill=new Bill(weight);
        this.barcode=new BarCode(axles,truckid);
    }
    
    public void print()
    {
        System.out.println("Truck make= Tata(TruckType_1)");
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
