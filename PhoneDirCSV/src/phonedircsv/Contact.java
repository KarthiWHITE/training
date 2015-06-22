package phonedircsv;

// this class will denote the single contact while pprocessing it
public class Contact{
    String name,mobile,home,work;
    
    /**
     *  This is the constructor for this class
     * all the parms are the String type
     * @param name name of the contact
     * @param mobile
     * @param home
     * @param work 
     */
    
    public Contact(String name,String mobile,String home,String work){
        
        this.name=name;
        this.mobile=mobile;
        this.home=home;
        this.work=work;
        
    }
    
    // the following methods are get methods for geting contact informations
    public String getName(){
        return this.name;
    }
    
    public String getMobile(){
        return this.mobile;
    }
    
    public String getWork(){
        return this.work;
    }
    
    public String getHome(){
        return this.home;
    }
}

