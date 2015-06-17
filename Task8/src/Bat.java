public  class Bat extends Mammal implements Flying{
    String name="Bat";
    @Override
    public void mam() {
        System.out.println("Bat is a mammal");
    }

    @Override
    public void locomation(){
      System.out.println("Bat will fly for its locomation.");
    }
    @Override
    public String getName() {
        return name;
    }
    
  
}
