public class Cow extends Mammal implements Vegetarian{

   String name="Cow"; 
    @Override
    public void mam() {
        System.out.println("Cow is a mammal.");
    }

    @Override
    public String getName() {
        return name;
    }
    
}
