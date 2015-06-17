public class Ostrich extends Bird implements Vegetarian{
    
    String name="Ostrich";
    
    @Override
    public void locomation(){
        System.out.println("Ostrich will walk or run for its locomation.");
    }

    @Override
    public String getName() {
       return name;
    }
}
