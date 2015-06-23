/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studsteachers;

/**
 *
 * @author cb-admin1
 */
public class Person {
   String name,ID,DOJ;
   public Person(String ID,String name,String DOJ){
       this.name=name;
       this.ID=ID;
       this.DOJ=DOJ;
   }
   
   public String getName(){
       return this.name;
   }
   
   public String getID(){
   
       return this.ID;
   }
   
   public String getDOJ(){
       return this.DOJ;
   }
}

