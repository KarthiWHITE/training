/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studsteachers;

import java.util.Map;

public class Student extends Person{
    String std;
    Map<String,Mark> marks;
    
    public Student(String ID,String name,String std,String DOJ,Map<String,Mark> marks){
        
        super(ID,name,DOJ);
        this.std=std;
        this.marks=marks;
        
    }
    
    
    /**
     * this method will return the mark for the student for given subject. the subject is not valid one then it is return -1
     * @param subject String type 
     * @return mark if the subject is valid otherwise -1
     */
    public long getMark(String subject){
    
        if(marks.containsKey(subject)){
            return marks.get(subject).getMark();
        }else
            return -1;
    }
    
    /**
     * Get methods for the members
     * @return 
     */
    
    @Override
    public String getName(){
        return super.getName();
    }
    
    @Override
    public String getDOJ(){
        return super.getDOJ();
    }
    
    @Override
    public String getID(){
        return super.getID();
    }
    
    public String getStd(){
        return std;
    }
    
    
    /**
     * print the current student details
     */
    public void printStudDeatails(){
        
        System.out.println("-------------------------------------");
        System.out.println("ID : "+ getID());
        System.out.println("Name : "+getName());
        System.out.println("Std :"+getStd());
        System.out.println("Date Of Joining : "+getDOJ());
        printAllMArks();
        System.out.println("-------------------------------------");
        System.out.println("-------END OF THE STATEMENT ---------");
        System.out.println("-------------------------------------");
    }
    
    public void printAllMArks(){
    
        marks.keySet().stream().forEach((sub) -> {
            System.out.println(sub+ " : "+getMark(sub));
        });
    }
}