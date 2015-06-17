
package task14;

public class MyOwnAutoShop {

    public static void main(String[] args) {
        Sedan sedan=new Sedan(90, 10000000, "White", 30);
        Ford ford=new Ford(120, 2000000, "Balck", 2001, 25000);
        
        Ford ford1=new Ford(120, 1500000, "Red", 2010,5000);
        
        Car car=new Car(100, 1300000, "white");
        
        //for sedan
        
        System.out.println("Sedan");
        printSuperClassInfo(sedan);
        System.out.println("Length : "+sedan.length);
        System.out.println("Sales Price : "+sedan.getSalePrice());
        
        System.out.println("_________________________________________________");
        
        printFord(ford);
        System.out.println("_________________________________________________");
        
        printFord(ford1);
        System.out.println("_________________________________________________");
        
        printSuperClassInfo(car);
        System.out.println("_________________________________________________");
        
    }
    
    
    private static void printSuperClassInfo(Car car){
        System.out.println("Speed : "+car.speed);
        System.out.println("Color : "+car.color);
        System.out.println("Regular Price : "+car.regularPrice);
    }
    
    
    private static void printFord(Ford ford){
        System.out.println("Ford");
        printSuperClassInfo(ford);
        System.out.println("Year : "+ford.year);
        System.out.println("Manufacturer Discount : "+ford.manufacturerDiscount);
        System.out.println("Sales Price : "+ford.getSalePrice());
    }
    
}
