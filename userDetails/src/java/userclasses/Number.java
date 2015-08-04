
package userclasses;

import utils.Utils;

public class Number {
    int type;
    String number;
    
    public Number(int type,String number){
        this.type=type;
        this.number=number;
    }   
    
    public int getType(){
        return this.type;
    }
    
    public String getNumber(){
        return this.number;
    }
    
    public Utils.MobileTypes getMobileType(){
        
        for(Utils.MobileTypes mtype:Utils.MobileTypes.values()){
            if(mtype.value()==type){
                return mtype;
            }
        }
        
        return null;
    }
}
