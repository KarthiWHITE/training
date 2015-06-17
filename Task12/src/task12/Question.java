/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task12;

/**
 *
 * @author cb-admin1
 */
public abstract class Question {

    private final int marks;
    
    public Question(int marks){
        this.marks=marks;
    }
    public int getMarks(){
        return marks;
    }
    
}
