/*

    Animal class

 */

package animal;

/**
 *
 * @author Karthikeyan @ cb
 */
public class Animal {
    
    //member of the animal class
    
   private final String name;
   
   private static int c=0;
   //Constructor
   public Animal(String name){
       
       this.name=name;
       
   }
   
   //method to get the animal name
   
   public String getAnimal(){
       return this.name;
   }
   
   public int getCount(){
       return ++c;
       
   }
    
}
