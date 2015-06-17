public class Dog extends Mammal{
    String name="Dog";
    
    @Override
    public void mam() {
        System.out.println("Dog is a mammal");
    }

    @Override
    public String getName() {
        return name;
    }
    
}
