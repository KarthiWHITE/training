/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displayetensioncout;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author cb-admin1
 */
public class DisplayEtensionCout {

    List<File> listFile;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DisplayEtensionCout dis = new DisplayEtensionCout();
        String root = System.getProperty("user.home");
        System.out.println("Enter your path from root dir : ");
        root += in.readLine();
        File homedir = new File(root);
        dis.listFile = new ArrayList<File>();
        dis.listFiles(homedir);
        dis.countExtention();

        //System.out.println(root);
    }

    public void listFiles(File direcotry) {
        for (File f : direcotry.listFiles()) {
            if (f.isDirectory()) {
                listFiles(f);
            } else {
                listFile.add(f);
            }
        }
    }

    public void countExtention() {

        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for (ListIterator<File> itr = listFile.listIterator(); itr.hasNext();) {
            File f = itr.next();
            String fileName = f.getName();
            if (fileName.lastIndexOf(".") != -1) {
                String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                if(countMap.containsKey(extension)){
                    countMap.replace(extension, countMap.get(extension), countMap.get(extension)+1);
                }else{
                    countMap.put(extension, 1);
                }
            }

        }
        printCount(countMap);
    }
    
    
    private void printCount(Map<String,Integer> map){
        
        Set<String> KeySet=map.keySet();
      
        Iterator<String> itr=KeySet.iterator();
       
        while(itr.hasNext()){
        
            String key= itr.next();
            
            System.out.println(key +" : "+ map.get(key));
        }
    }

}
