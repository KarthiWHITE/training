
package task14;
public class Car {
    int speed; 
    double regularPrice; 
    String color; 
    
    public Car(int speed,double regularPrice,String color){
        this.speed=speed;
        this.regularPrice=regularPrice;
        this.color=color;
    }
    public double getSalesPrice(){
        return regularPrice;   
    }

}


