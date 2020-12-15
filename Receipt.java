/**
 * Author - Suruchi Shrey
 * Enrollment no.- BT18CSE014
 */

import java.time.LocalDate;
import java.time.LocalTime;

public class Receipt {
    final private int truckid;
    final private int receiptid;
    static private int id=0;
    private double amount;
    private String Date;
    private String Time;
    
    public Receipt(int truckid,double amount)
    {
        id++;
        this.amount=amount;
        this.truckid=truckid;
        this.receiptid=id;
        LocalDate date = LocalDate.now();
        this.Date=date.toString();
        LocalTime time = LocalTime.now();
        this.Time=time.toString();
    }
    public String getReceipt()
    {
        String data=this.Date+" "+this.Time+" "+Integer.toString(this.truckid)+" "+Double.toString(amount);
        return data;
    }
    public void printReceipt()
    {
        System.out.println("Receipts: Rs "+this.amount+" Truck: "+this.truckid);
    }
}
