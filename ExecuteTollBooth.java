/**
 * Author - Suruchi Shrey
 * Enrollment no.- BT18CSE014
 */
//Driver program

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecuteTollBooth{

    public static void main(String[] args) throws InterruptedException
    {
        NagpurTollBooth booth=new NagpurTollBooth();
        Scanner sc=new Scanner(System.in);
        StoreReceipts storeThread=new StoreReceipts(booth);
        storeThread.start();
          
        try {
            
            BufferedReader br=new BufferedReader(new FileReader("E:\\5th SEM\\IOOM\\inputTrucks.txt"));
            String content=br.readLine();
            int choice;
            while(content!=null)
            {
                String[] str=content.split(" ",4);
                int time=Integer.parseInt(str[0]);
                int trucktype=Integer.parseInt(str[1]);
                double weight=Double.parseDouble(str[2]);
                int axles=Integer.parseInt(str[3]);
                Thread.sleep(time);                 //wait for arrival
                if(trucktype==1)
                {
                   TruckType_1 truck1=new TruckType_1(weight,axles);
                   booth.calculateToll(truck1);
                }
                else{
                    TruckType_2 truck2=new TruckType_2(weight,axles);
                   booth.calculateToll(truck2);
                }
                   System.out.println("What do you want to do?(can do one at a time)\n1.Display Data\n2.Reset(Cash removal, collect all receipts)\n3.None\n");
                   choice=sc.nextInt();
                   if(choice==1)
                   {
                       booth.displayData();
                   }
                   else if(choice==2)
                   {
                       booth.cashRemoval();
                   }
                content=br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NagpurTollBooth.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NagpurTollBooth.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Thread.sleep(1000);
        storeThread.join();
        System.out.println("Showing you details from date 01-12-2020 to date 03-12-2020");
        String d1="2020-12-01";
        String d2="2020-12-03";
        booth.datewiseCollection(d1, d2);
        System.out.println("Ending....Bye!");
        sc.close();
    }
}
