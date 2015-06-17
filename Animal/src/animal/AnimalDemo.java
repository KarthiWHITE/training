

package animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Karthikeyan @ CB
 */

public class AnimalDemo {

    
    //Input reader to read user input from the console
    
    private BufferedReader in;
    
    private Animal an;
    
    //main method
    
    public static void main(String arg[]) throws IOException{
    
        AnimalDemo ad=new AnimalDemo();
        
        ad.in = new BufferedReader(new InputStreamReader(System.in)); //creating input reader object
        
        // loop will repeat until the user say E (Exit)
        
        while(true){
            
            // Menu for the user
            
            System.out.println("Menu \n Enter \n A : Add a animal\n E : Exit");
            
            String input=ad.in.readLine(); //read menu selection from the user
            
            
            
            //switch case for selecting and directing menu item
            
            switch(input){
                
                //In the case of add a animal
                
                case "A":
                        System.out.println("Add a animal to the list.");
                        ad.addAnimal();
                        ad.printAnimal();
                        break;
                case "E": //for Exit system and come out....
                    System.out.println("The system will Exit now...");
                    System.exit(0);
                     break;
            }
            
        }
    }
    
    
    
    //Method that read user input and add it into animalList
    
    private void addAnimal() throws IOException{
        
            System.out.print("Enter the animal name:");
            
            an=new Animal(in.readLine());
            
            
    }
     private void printAnimal(){
         System.out.println("Animal Name : "+an.getAnimal());
         System.out.println("Animal Count : "+an.getCount());
     }
    
    
}

