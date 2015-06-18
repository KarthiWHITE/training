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
import org.apache.commons.io.FilenameUtils;

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

    /**
     * this method will read all the files to list. it read the files form its
     * sub directories too
     *
     * @param direcotry is source directory
     */
    public void listFiles(File direcotry) {
        for (File f : direcotry.listFiles()) {
            if (f.isDirectory()) {
                listFiles(f);
            } else {
                listFile.add(f);
            }
        }
    }

    /**
     * This method will count the files by its extension and store it in the map
     * which contains the extension and count pair
     */
    public void countExtention() {

        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for (File f : listFile) {
            String fileName = f.getName();
            if (!FilenameUtils.getExtension(fileName).isEmpty()) {
                String extension = FilenameUtils.getExtension(fileName);
                if (countMap.containsKey(extension)) {
                    countMap.replace(extension, countMap.get(extension), countMap.get(extension) + 1);
                } else {
                    countMap.put(extension, 1);
                }
            } else {
                if (countMap.containsKey("with out extension")) {
                    countMap.replace("with out extension", countMap.get("with out extension"), countMap.get("with out extension") + 1);
                } else {
                    countMap.put("with out extension", 1);
                }
            }

        }
        printCount(countMap);
    }

    /**
     * this method will print the count by extension from the map.
     *
     * @param map
     */
    private void printCount(Map<String, Integer> map) {

        Set<String> KeySet = map.keySet();

        Iterator<String> itr = KeySet.iterator();

        while (itr.hasNext()) {
            String key = itr.next();
            System.out.println(key + " : " + map.get(key));
        }
    }

}
