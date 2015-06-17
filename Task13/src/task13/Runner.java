
package task13;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author cb-admin1
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vechicle j=new Jeep();
        Vechicle h=new Hovercraft();
        Vechicle f=new Frigate();
        
       List<Vechicle> lv=new ArrayList();
       
       lv.add(j);
       lv.add(h);
       lv.add(f);
       
        ListIterator lit=lv.listIterator();
        
        while(lit.hasNext()){
        System.out.println("--------------------------------------------------------------------");
            Vechicle v= (Vechicle) lit.next();
            
            System.out.println("Name: "+v.name());
            System.out.println("Maximum Speed: "+v.maxSpeed());
            System.out.println("Maximum Passenger :"+v.maxPassenger());
            
            if(v instanceof LandVechicle){
                System.out.println("No.Of Wheels : "+((LandVechicle)v).numWheels());
                ((LandVechicle)v).drive();
                
            }
            
            if(v instanceof SeaVessel){
                ((SeaVessel)v).dispalcement();
                ((SeaVessel)v).lunch();
            }
            
            if(v instanceof Jeep){
                ((Jeep)v).soundHorn();
            }
            
            if(v instanceof Hovercraft){
                ((Hovercraft)v).enterLand();
                ((Hovercraft)v).enterSea();
                
            }
            
            if(v instanceof Frigate){
                ((Frigate)v).fireGun();
            }
            
            
            
        }
        
    }
    
}
