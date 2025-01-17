/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounttxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author cb-admin1
 */
public class WordCountTxt {

    File src, dest;

    public WordCountTxt(File src, File dest) {
        this.src = src;
        this.dest = dest;
    }

    /**
     * This method will read the file and count the word counts and write it in
     * new file
     */
    public void wcToTxtFile() {

        try {

            FileInputStream fin = new FileInputStream(src); //create file input stream to read the data

            byte[] bytes = new byte[fin.available()];

            fin.read(bytes);                                // read the bytes from file

            String str = new String(bytes);

            String[] arrStr = str.split(" ");

            Arrays.sort(arrStr);

            HashMap<String, Integer> map = new HashMap<String, Integer>();

            //count the occurrence of the words on the file
            for (String s : arrStr) {
                if (map.containsKey(s)) {
                    map.replace(s, map.get(s), map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }

            FileOutputStream fout = new FileOutputStream(dest);

            Object[] keyarr = map.keySet().toArray();

            Arrays.sort(keyarr);

            // write the words along with its count in a ooutput file
            for (Object s : keyarr) {
                String w = (String) s + " : " + map.get((String) s).toString() + "\n";

                fout.write(w.getBytes());

            }
            fin.close();
            fout.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (Exception e) {
        }
        System.out.println("Success");

    }

    public static void main(String[] args) throws IOException {

        File src, dest;

        System.out.println("Enter the source file path");

        src = getDir();

        System.out.println("Enter the destination file path");

        dest = getDir();

        WordCountTxt wc = new WordCountTxt(src, dest);

        wc.wcToTxtFile();

    }

    /**
     * This method will read the path for the file and return the path this read
     * option will repeat until the path or file is valid one
     *
     * @return File object
     * @throws IOException it throws the IOException
     */
    public static File getDir() throws IOException {
        File file;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter the File path from the root : " + new File(System.getProperty("user.home")).getAbsolutePath());
            file = new File(System.getProperty("user.home") + in.readLine());
            if (file.exists() && file.isFile()) {
                return file;
            } else {
                System.out.println("The file " + file.getAbsolutePath() + " is not valid :(");
            }
        }
    }
}
