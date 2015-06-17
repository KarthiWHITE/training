
package task14;

public class Truck extends Car{

    int weight;
    
    public Truck(int speed, double regularPrice, String color,int weight) {
        super(speed, regularPrice, color);
        this.weight=weight;
    }
    @Override
    public double getSalesPrice(){
        double sPrice=super.getSalesPrice();
        if(weight>2000){
            return sPrice-(sPrice/10);
        }
        return sPrice-(sPrice/5);
    
    }
    
}