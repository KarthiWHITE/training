/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task9;

/**
 *
 * @author cb-admin1
 */
public class Student extends SubPersonViewer implements Person{ 

    
    private final String grade;
    
    public Student(String name,String email,String grade){
        super(name,email);
        this.grade=grade;
    }
    
    @Override
    public String getDescription() {
        return "A"+grade+" Student.";
    }
    
    public String getGrade(){
        return grade;
    }
    
}
