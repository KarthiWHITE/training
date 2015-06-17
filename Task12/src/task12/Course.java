/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task12;

import java.util.ArrayList;

/**
 *
 * @author cb-admin1
 */
public class Course {

    private final String courseId,name;
    
    public final ArrayList<Assessment> assessmentList;
    
    public Course(String courseId,String name,ArrayList<Assessment> assessmentList){
        this.courseId=courseId;
        this.name=name;
        this.assessmentList=new ArrayList(assessmentList);
    }
}
