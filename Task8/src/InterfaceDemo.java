import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;


/*

Example for implemention of interface and abstract calss, overriding,anonymousclasses.

@ author Karthikeyan @ CB 

*/



public class InterfaceDemo {
    
    //Array list to store all the animals
    
    private static ArrayList  list;
    
    //Main Method
    
    public static void main(String[] args) throws IOException{
    
        //Stream reader to read user input from the console
        
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        
        list=new ArrayList();
        
//menu operations
        
        while(true) {            
            System.out.println("Menu\n-------------------------\nO : Ostrich\nD : Dog \nBA : Bat \nC : Cow\n P : Parrot\nL : Locomation \nLA : List All Animal\n LV : List all animals which are Vegetarian\nLF : List all animals which are all Flying\n E : Exit\n------------------------\nEnter Your Choice : ");
            
            String ch=in.readLine();
            switch(ch){
                case "O":
                    list.add(new Ostrich()); //add Ostrich to the list
                    break;
                case "D":
                    list.add(new Dog());   //add Dog to the list
                    break;
                case "BA":
                    list.add(new Bat());  // Add Bat to the list
                    break;
                case "C":
                    list.add(new Cow());
                    break;
                case "P":
                    list.add(new Parrot());
                    break;
                case "L":
                    movement();
                    break;
                    
                case "LA":
                    printAllAnimal();       //invoke method that print all animals in list 
                    break;
                case "LV":
                    printVegetarian();  //invoke method that print all animals which are all vegetarian in list 
                    break;
                case "LF":
                    printFlayingAnimals(); //invoke method that print all animals which are all fly in list 
                    break;
                case "E":
                    System.out.println("The system will exit now");
                    System.exit(0);         // Close the system (loop)
            }
        }
        
    }
    
    //the following methods will print the list elements using list iterator
    
    private static void printAllAnimal(){
        
        if(list.isEmpty()){
            System.out.println("Our List is Empty Now");
        }else{
            ListIterator li=list.listIterator();
            System.out.println("List of all animals");
            while(li.hasNext()){
                LivingBeings lb=(LivingBeings)li.next();
                System.out.println("Name : "+lb.getName());
            }
        }
                
    }
    private static void printVegetarian(){
        if(list.isEmpty()){
            System.out.println("Our List is Empty Now");
        }else{
            ListIterator li=list.listIterator();
            System.out.println("List of animals which are all Vegetarian.");
            while(li.hasNext()){
                LivingBeings lb=(LivingBeings)li.next();
                if(lb instanceof Vegetarian)
                    System.out.println("Name : "+lb.getName());
            }
        }
    }
    
    private static void printFlayingAnimals(){
        if(list.isEmpty()){
            System.out.println("Our List is Empty Now");
        }else{
            ListIterator li=list.listIterator();
            System.out.println("List of animals that can Fly");
            while(li.hasNext()){
                LivingBeings lb=(LivingBeings)li.next();
                if(lb instanceof Flying)
                    System.out.println("Name : "+lb.getName());
            }
        }
    }
    
    private static void movement(){
        if(list.isEmpty()){
            System.out.println("Our List is Empty Now");
        }else{
            ListIterator li=list.listIterator();
            System.out.println("The locomation of the animals");
            while(li.hasNext()){
                LivingBeings lb=(LivingBeings)li.next();
                System.out.println("Name : "+lb.getName());
                lb.locomation();
                
            }
        }
        
    }
        
}
