/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studsteachers;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cb-admin1
 */
public class Teacher extends Person{
    long salary;
    List<String> classes;
    public Teacher(String ID, String name, String DOJ,long salary,List<String> classes) {
        super(ID, name, DOJ);
        this.salary=salary;
        this.classes=classes;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getName(){
        return super.getName();
    }
    
    @Override
    public String getID(){
        return super.getID();
    }
    
    @Override
    public String getDOJ(){
        return super.getDOJ();
    }
    
    public long getSalary(){
        
        return this.salary;
        
    }
    
    public List getClasses(){
        return this.classes;
    }
    
    /**
     * this method will return the String that contains all the classes handle by the teacher
     * @return 
     */
    public String classesToString(){
        
     return Arrays.toString(classes.toArray());
     
    }
    
    /**
     * Add a new class to the teacher
     * @param clas 
     */
    public void addClass(String clas){
        this.classes.add(clas);
    }
    
    /**
     * this method will return true on success of removing the given class otherwise false
     * @param cls
     * @return 
     */
    public boolean removeClass(String cls){
        return classes.contains(cls)?classes.remove(cls):false;
    }
    
    /**
     * this method will return true if the teacher is handles the given class otherwise false
     * @param cls
     * @return 
     */
    public boolean handleClass(String cls){
        return classes.contains(cls);
    }
    
    public void printTeacherDetails(){
        
        System.out.println("----------------------------");
        System.out.println("Name : "+super.getName());
        System.out.println("ID : "+super.getID());
        System.out.println("Date Of Joining : "+super.getDOJ());
        System.out.println("Salary : "+getSalary());
        System.out.println("Classes handle : "+classesToString());
        System.out.println("----------------------------");
        
    
    }
}
