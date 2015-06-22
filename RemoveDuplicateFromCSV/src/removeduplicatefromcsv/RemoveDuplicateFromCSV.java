
package removeduplicatefromcsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.csv.*;
import org.apache.commons.io.FilenameUtils;




public class RemoveDuplicateFromCSV {


    File src,dest;
    
    public static void main(String[] args) throws IOException {
     
        RemoveDuplicateFromCSV re= new RemoveDuplicateFromCSV();
        re.removeDuplicate();
        
    }
    
    /**
     * this method will remove the duplicate entry in the given csv file and the result file will store in the same directory where the source file is.
     * Namely result.csv
     * @throws IOException 
     */
    private void removeDuplicate() throws IOException{
        
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        
        String root= System.getProperty("user.home");
    
        System.out.println("Enter the source file path from root ");
        
        src=new File(root+in.readLine());
        
        //checking the given path is valid one or not
        if(! src.exists()|| !FilenameUtils.getExtension(src.getName()).equals("csv")){
            System.out.println("The file is not valid"); 
        }

        CSVParser parser=new CSVParser(new FileReader(src), CSVFormat.EXCEL);
        
        List<CSVRecord> li= parser.getRecords();
        
        File f=new File(src.getParent()+"/result.csv");
        
        f.createNewFile();
        FileWriter fwriter=new FileWriter(f);
        
        CSVPrinter printer=new CSVPrinter(fwriter, CSVFormat.EXCEL);
        
       List<String> list=new ArrayList(); //list to store the records without duplicate
        if(!li.isEmpty()){
            for(CSVRecord re:li){
                if(!list.contains(re.toString())){
                    list.add(re.toString());
                    printer.printRecord(re); //write the record in the file if the record is not available in the list
                }
                
            }
        }
        
       //close the resources
        printer.close();
        fwriter.close();
        System.err.println("Success");
        
    }
}
