/**
 * Author - Suruchi Shrey
 * Enrollment no.- BT18CSE014
 */
package com.mycompany.tollboothsystem;

public class Bill {
    final private double weight;
    
    public Bill()
    {
        this.weight=0;
    }
    
    public Bill(double weight)
    {
        this.weight=weight;
    }
    
    public double getWeight()
    {
        return this.weight;
    }
}
