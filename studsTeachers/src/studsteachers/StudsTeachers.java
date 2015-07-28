/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studsteachers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.print.attribute.HashAttributeSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author cb-admin1
 */
public class StudsTeachers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        File src=new File(System.getProperty("user.home")+"/myrepo/training/studsTeachers/stud.json");
        JSONObject jobject=(JSONObject)new JSONParser().parse(new FileReader(src));
        
        Student student=createStudent((JSONObject)jobject.get("Student"));
        
        Teacher teacher=createTeacher((JSONObject)jobject.get("Teacher"));
        
        
        student.printStudDeatails();
        teacher.printTeacherDetails();
        
    }
    
    /**
     * this method will create the student object from student JSON object
     * @param studentObj
     * @return 
     */
    public static Student createStudent(JSONObject studentObj){
    
        Map<String,Mark> marks=new HashMap<String, Mark>();
        
        JSONArray ArrayOfMarks=(JSONArray)studentObj.get("Marks");
        for (Iterator<JSONObject> it = ArrayOfMarks.iterator(); it.hasNext();) {
            JSONObject subMark = it.next();
            String sub=(String)subMark.get("Subject");
            marks.put(sub, new Mark(sub,(long)subMark.get("Mark")));
        }
        
        String name=(String)studentObj.get("Name");
        String ID=(String)studentObj.get("ID");
        String std=(String)studentObj.get("Std");
        String DOJ=(String)studentObj.get("Date Of Joining");
        return new Student(ID, name, std, DOJ, marks);
    }
    
    
    /**
     * this method will create Teacher object for given teacher json object
     * @param tchr
     * @return 
     */
    public static Teacher createTeacher(JSONObject tchr){
    
        List<String> classes=new ArrayList<String>();
        
        JSONArray arrayofClasses=(JSONArray)tchr.get("Classes Taking Care Of");
        for (Iterator<String> it = arrayofClasses.iterator(); it.hasNext();) {
        
            classes.add((String)it.next());
        }
        String name=(String)tchr.get("Name");
        String ID=(String)tchr.get("ID");
        long salary=(long)tchr.get("Salary");
        String DOJ=(String)tchr.get("Date Of Joining");
        return new Teacher(ID,name,DOJ,salary,classes);
    }
    
}
