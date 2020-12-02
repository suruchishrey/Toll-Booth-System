/**
 * Author - Suruchi Shrey
 * Enrollment no.- BT18CSE014
 */
/*
    This is a class which extends the Thread class,this is responsible for collection of receipts and storing them into 
    a file at certain intervals.
*/
package com.mycompany.tollboothsystem;

import java.util.Timer;


public class StoreReceipts extends Thread{
    private final NagpurTollBooth booth;
    long t0=System.currentTimeMillis();
    public StoreReceipts(NagpurTollBooth booth)
    {
        this.booth=booth;
    }
    
    @Override
    public void run()
    {
        Timer timer=new Timer();
        timer.schedule(
          new java.util.TimerTask(){
            @Override
            public void run() {
                if(System.currentTimeMillis()-t0>60*3*1000){
                    System.out.println("Storing done!");
                    cancel();
                }
                else{
                booth.storeReceipt();
                //System.out.println("Storing the receipts..........");
                }
            }
          },0,10000); 
    }
}
