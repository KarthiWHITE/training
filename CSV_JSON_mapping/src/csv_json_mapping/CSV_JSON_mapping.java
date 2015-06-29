
package csv_json_mapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FilenameUtils;
import org.json.*;
import sun.util.BuddhistCalendar;
import sun.util.calendar.Gregorian;
/**
 *
 * @author cb-admin1
 */
public class CSV_JSON_mapping {

    File src,dest,conf; 
    
    Iterator<String> headerSet;
    
    Map<String,colType> colMap=new HashMap<>();
    Map<String,String> conMap=new HashMap<>();
    
   JSONObject confObj; 
    
    
    
    public enum colType{
        STRING,DATE,BOOLEAN,MONEY,MULTISTRING;
    }
    
    public CSV_JSON_mapping(File src,File dest, File conf){
        this.src=src;
        this.dest=dest;
        this.conf=conf;
    }
    
    private void map() throws Exception{
    
        genConfMaps();
  
        CSVParser parser= new CSVParser(new FileReader(src), CSVFormat.EXCEL);
        
        CSVPrinter printer =new CSVPrinter(new FileWriter(dest), CSVFormat.EXCEL);
        
        //List<CSVRecord> srcRecords= parser.getRecords();
        Iterable<CSVRecord> srcRecords;
        srcRecords = CSVFormat.EXCEL.withHeader().parse(new FileReader(src));
        headerSet=confObj.keys();
        List<String> li=new ArrayList<>();
       while(headerSet.hasNext()){
           li.add(headerSet.next());
       }
        printer.printRecord(li);
        for(CSVRecord record:srcRecords){
            headerSet=confObj.keys(); 
            printer.printRecord(formetter(record, headerSet));
        }
        
        parser.close();
        printer.flush();
        printer.close();
        System.out.println("success");
    }
    
    private List<String> formetter(CSVRecord record,Iterator<String> headerSet) throws JSONException, ParseException{
        
        List<String> out=new ArrayList<>();
        
        while(headerSet.hasNext()){
            String colkey= headerSet.next();
            
            colType ctype=colMap.get(colkey);
            
            String colVal=conMap.get(colkey);
            String val="";
            if(ctype!=colType.MULTISTRING)
                val=record.get(colVal);
            if(ctype==colType.STRING){
                ;
            }else if(ctype==colType.DATE){
               ;

                
            }else if(ctype==colType.MULTISTRING){
                JSONArray arr=confObj.getJSONArray(colkey);
                arr=arr.getJSONArray(0);
                val="{";
                for(int i=0;i<arr.length();i++){
                    String key=arr.getString(i);
                    String newCol=key.replace("Customer ", "");
                    val+="\""+newCol+"\" : \""+record.get(key)+"\",";
                }
                val=val.substring(0,val.length()-1);
                val+="}";
                
            }else if(ctype==colType.MONEY){
                val= (Float.parseFloat(val)/100)+"";
            }else if(ctype==colType.BOOLEAN){
                ;
            }
            
             out.add(val);
        
        }
        
        return out;
    }
    
    
    private void genConfMaps() {
        try{
            
            FileInputStream fin=new FileInputStream(conf);
            
            byte[] b= new byte[fin.available()];
            
            fin.read(b);
            
            confObj=new JSONObject(new String(b));
                
            headerSet= confObj.keys();
                           
                while(headerSet.hasNext()){
                    
                    String key=headerSet.next();
                    
                    JSONArray arr=(JSONArray)confObj.get(key);
                    conMap.put(key, arr.get(0).toString());
                    colMap.put(key, getColType((String)(arr.get(1))));
                    
                }
                
        }catch(IOException e){
            System.out.println("IO Exception");
        }catch(JSONException e){
            System.out.println("Parser error");
        }
    
    }
    
    private colType getColType(String type){
        switch(type){
            case  "String":
                return colType.STRING;
            case  "Boolean":
                return colType.BOOLEAN;
            case "Date":
                return colType.DATE;
            case "Money":
                return colType.MONEY;
            case "Multystring":
                return colType.MULTISTRING;
        }
        return colType.STRING;
    }
    
    public static void main(String[] args) throws Exception {
       
        CSV_JSON_mapping cs=new CSV_JSON_mapping(getPath("csv"),getPath("csv"),getPath("json"));
       // File f1=new File(System.getProperty("user.home")+"/myrepo/training/extfiles/sample-input.csv");
       // File f2=new File(System.getProperty("user.home")+"/myrepo/training/extfiles/sample-output.csv");
       /// File f3=new File(System.getProperty("user.home")+"/myrepo/training/extfiles/config.json");
        
       // CSV_JSON_mapping cs=new CSV_JSON_mapping(f1, f2, f3);
        cs.map();
        
    }
    
    public static File getPath(String ext) throws IOException{
    
        File file;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter the "+ext +" file path from the root : " + new File(System.getProperty("user.home")).getAbsolutePath());
            file = new File(System.getProperty("user.home") + in.readLine());
            if (file.exists()&& FilenameUtils.getExtension(file.getName()).equals(ext)) {
                return file;
            } else {
                System.out.println("The directory " + file.getAbsolutePath() + " is not valid :(");
            }
        }
    }
}
