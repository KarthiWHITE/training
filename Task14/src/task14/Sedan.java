/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task14;

/**
 *
 * @author cb-admin1
 */
public class Sedan extends Car{
    
    int length;

    public Sedan(int speed, double regularPrice, String color,int length) {
        super(speed, regularPrice, color);
        this.length=length;
    }
	public double getSalePrice(){
        
            double sPrice=super.getSalesPrice();
            return (length>20)? sPrice-(sPrice/20) : sPrice-(sPrice/10);
        
        }
        
        
        
}
