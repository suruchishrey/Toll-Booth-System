/**
 * Author - Suruchi Shrey
 * Enrollment no.- BT18CSE014
 */

/*
    This is a class which implements Tollbooth interface
*/
package com.mycompany.tollboothsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dell
 */
public class NagpurTollBooth implements Tollbooth {
    
    private int numberOfTrucks=0;
    private double totalReceipts=0;
    ArrayList<String> ReceiptData=new ArrayList<String>();
    
    public NagpurTollBooth()
    {
        System.out.println("------------------------------------Welcome to Nagpur Toll Booth -------------------------------");
    }
    
    //This function calculates the toll of the truck arrived and shows a message
    @Override
    public double calculateToll(Truck truck)
    {
        numberOfTrucks++;   
        double toll;
        toll=(truck.getWeight()/1000)*20+(truck.getAxles()*5);
        totalReceipts+=toll;
        this.printTruckToll(truck, toll);
        Receipt receipt=new Receipt(truck.getId(),toll);
        ReceiptData.add(receipt.getReceipt());
        
        return toll;
    }
    
    //This function shows the receipts since last collection
    public void displayData()
    {
        System.out.println("Totals since last collection - Receipts: "+totalReceipts+" Trucks: "+numberOfTrucks);
    }
    
    //This function shows the totals maintained by the booth and then resets them to zero
    public void cashRemoval()
    {
        System.out.println("*** Collecting receipts ***");
        this.displayData();
        numberOfTrucks=0;
        totalReceipts=0;
    }
    
    public void printTruckToll(Truck truck,double toll)
    {
        System.out.println("Truck arrival - Axles: "+truck.getAxles()+" Total weight: "+truck.getWeight()+" Toll due: Rs."+toll);
    }
    
    //This function stores the receipts into the file
    public void storeReceipt()
    {
        //Path to store the receipt details 
        Path path=Paths.get("E:\\5th SEM\\IOOM","textfile.txt");
        Iterator i=ReceiptData.iterator();
        while (i.hasNext()) 
        {
            try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND,StandardOpenOption.CREATE))
            {
                writer.write(i.next().toString()+"\n");
            }catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
        ReceiptData.clear();
    }
    
    //This function brings details from the file from date d1 to date d2(datewise collection)
    public void datewiseCollection(String d1,String d2)
    {
        try {
            BufferedReader br=new BufferedReader(new FileReader("E:\\5th SEM\\IOOM\\textfile.txt"));
            String content=br.readLine();
            while(content!=null)
            {
                if(content.contains(d1))
                {
                    System.out.println("Details Retrieved");
                   while(content!=null && content.contains(d2)==false) 
                   {
                       System.out.println(content);
                       content=br.readLine();
                   }
                   while(content!=null && content.contains(d2)==true)
                   {
                       System.out.println(content);
                       content=br.readLine();
                   }
                }
                content=br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NagpurTollBooth.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NagpurTollBooth.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getTotalTrucks()
    {
        return this.numberOfTrucks;
    }
    
    public double getTotalReceipts()
    {
        return this.totalReceipts;
    }
    
    public ArrayList getReceitDatatoStore()
    {
        return this.ReceiptData;
    }

}
