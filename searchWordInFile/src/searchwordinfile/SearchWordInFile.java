/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchwordinfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author cb-admin1
 */
public class SearchWordInFile {

    private File src;
    private String searchWodrd;

    public SearchWordInFile() throws IOException {

        getInput();

    }

    private void getInput() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String root = System.getProperty("user.home") + "/";
        System.out.println("Enter the source file path from root : " + root);

        do {

            src = new File(root + in.readLine());

        } while (!(src.isFile() && src.canRead()));
       
        System.out.println("Enter the word to seach in the file :");
        searchWodrd = in.readLine();
    }
/**
 * this method will search the given word in the source file and write its positions in a another file
 */
    public void search() {

        try {
            FileInputStream fin = new FileInputStream(src);
            File dest=new File(src.getParent()+"/"+searchWodrd+".txt");
            dest.createNewFile();
            FileOutputStream fout = new FileOutputStream(dest);
            
            byte[] b= new byte[fin.available()];    // create array of bytes to read from fin        
            fin.read(b);

            String[] lines= new String(b).split("\n"); //create list of stringd each has a single line
            
            for(int i=0;i<lines.length;i++){
                
                String line=lines[i];
                
                String reslt=i+" : ";
                
                boolean isWordAvailable=false;
                int indx=line.indexOf(searchWodrd);
                
                while(indx!=-1){
                    
                    reslt+=indx+",";  //store the index values in variable
                    
                    isWordAvailable=true;
                    
                    int d=line.substring(indx+searchWodrd.length()).indexOf(searchWodrd); //search the index for next occurrence in the remaining line
                    
                    if(d!=-1){
                        indx=indx+searchWodrd.length()+d;  //calculate the orignal index in the current line
                    }else{
                        indx=d;
                    }
                    
                }
                
                if(isWordAvailable){
                    reslt+="\n";
                    fout.write(reslt.getBytes()); //write the qout put to the file if the word is present
                }
            }
            
            System.out.println("Successfully completed :)");
            fin.close();
            fout.close();

        } catch (Exception e) {

        }

    }
    
    public static void main(String[] args) throws IOException {
        SearchWordInFile sin=new SearchWordInFile();
        sin.search();
        
    }

}
