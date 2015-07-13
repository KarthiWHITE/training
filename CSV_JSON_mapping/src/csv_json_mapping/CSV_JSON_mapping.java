package csv_json_mapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FilenameUtils;
import org.json.*;

/**
 *
 * @author cb-admin1
 */
public class CSV_JSON_mapping {

    File src, dest, conf;
    Iterator<String> headerSet;
    //Map<String, colType> colMap = new HashMap<>();
    //Map<String, String> conMap = new HashMap<>();
    List<MapObj> mapList = new ArrayList();
    JSONObject confObj;

    public enum colType {

        STRING, DATE, BOOLEAN, MONEY, MULTISTRING;
    }

    public CSV_JSON_mapping(File src, File dest, File conf) {
        this.src = src;
        this.dest = dest;
        this.conf = conf;
    }

    private void map() throws Exception {
        genConfMaps();
        CSVParser parser = new CSVParser(new FileReader(src), CSVFormat.EXCEL);
        CSVPrinter printer = new CSVPrinter(new FileWriter(dest), CSVFormat.EXCEL);
        //List<CSVRecord> srcRecords= parser.getRecords();
        Iterable<CSVRecord> srcRecords;
        srcRecords = CSVFormat.EXCEL.withHeader().parse(new FileReader(src));
        headerSet = confObj.keys();
        List l = new ArrayList();
        while (headerSet.hasNext()) {
            l.add(headerSet.next());

        }
        printer.printRecord(l);
        //printer.printRecord(headerSet);
        for (CSVRecord record : srcRecords) {
            //headerSet = confObj.keys();
            printer.printRecord(formetter(record));
        }
        parser.close();
        printer.flush();
        printer.close();
        System.out.println("success");
    }

    private List<String> formetter(CSVRecord record) throws JSONException, ParseException {
        List<String> out = new ArrayList<>();
        //while (headerSet.hasNext()) {
        for (MapObj mo : mapList) {
            String colkey = mo.toCon; //headerSet.next();
            colType ctype = mo.col;//colType.BOOLEAN;// colMap.get(colkey);
            String colVal = mo.frmCon;//"sd"; conMap.get(colkey);
            String val = "";
            if (ctype != colType.MULTISTRING) {
                val = record.get(colVal);
            }
            switch (ctype) {
                case STRING:
                    break;
                case DATE:
                    if (!val.equals("")) {
                        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                        DateFormat targetFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
                        Date d = originalFormat.parse(val);
                        val = targetFormat.format(d);
                        val = targetFormat.parse(val).toString();
                    }
                    break;
                case MULTISTRING:
                    JSONArray arr = confObj.getJSONArray(colkey);
                    arr = arr.getJSONArray(0);
                    JSONObject custDetails = new JSONObject();
                    for (int i = 0; i < arr.length(); i++) {
                        String key = arr.getString(i);
                        String newCol = key.replace("Customer ", "");
                        custDetails.put(newCol, record.get(key));
                    }
                    val = custDetails.toString();
                    break;
                case MONEY:
                    val = (Float.parseFloat(val) / 100) + "";
                    break;
                case BOOLEAN:
                    break;
            }

            /*
             if (ctype == colType.STRING) {
             ;
             } else if (ctype == colType.DATE) {
             if (!val.equals("")) {
             DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
             DateFormat targetFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
             Date d = originalFormat.parse(val);
             val = targetFormat.format(d);
             val=targetFormat.parse(val).toString();
             }

             } else if (ctype == colType.MULTISTRING) {
             JSONArray arr = confObj.getJSONArray(colkey);
             arr = arr.getJSONArray(0);
             JSONObject custDetails = new JSONObject();
             for (int i = 0; i < arr.length(); i++) {
             String key = arr.getString(i);
             String newCol = key.replace("Customer ", "");
             custDetails.put(newCol, record.get(key));
             }
             val = custDetails.toString();
             } else if (ctype == colType.MONEY) {
             val = (Float.parseFloat(val) / 100) + "";
             } else if (ctype == colType.BOOLEAN) {
             ;
             }*/
            out.add(val);

        }

        return out;
    }

    private void genConfMaps() {
        try {
            FileInputStream fin = new FileInputStream(conf);
            byte[] b = new byte[fin.available()];
            fin.read(b);
            confObj = new JSONObject(new String(b));
           // headerSet = confObj.keys();
            //while (headerSet.hasNext()) {
            //String key = headerSet.next();
            for (Iterator<String> it = confObj.keys(); it.hasNext();) {
                String key = it.next();
                JSONArray arr = (JSONArray) confObj.get(key);
                //conMap.put(key, arr.get(0).toString());
                //colMap.put(key, getColType((String) (arr.get(1))));
                mapList.add(new MapObj(arr.get(0).toString(), key, getColType((String) (arr.get(1)))));
            }

        } catch (IOException e) {
            System.out.println("IO Exception");
        } catch (JSONException e) {
            System.out.println("Parser error");
        }
    }

    private void printlist(List<MapObj> m) {
        for (MapObj mo : m) {
            System.out.println(mo.toCon);
        }
        System.exit(0);
    }

    private colType getColType(String type) {
        switch (type) {
            case "String":
                return colType.STRING;
            case "Boolean":
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

        CSV_JSON_mapping cs = new CSV_JSON_mapping(getPath("csv"), getPath("csv"), getPath("json"));
       // File f1=new File(System.getProperty("user.home")+"/myrepo/training/extfiles/sample-input.csv");
        //File f2=new File(System.getProperty("user.home")+"/myrepo/training/extfiles/sample-output.csv");
        //File f3=new File(System.getProperty("user.home")+"/myrepo/training/extfiles/config.json");

        //CSV_JSON_mapping cs=new CSV_JSON_mapping(f1, f2, f3);
        cs.map();

    }

    public static File getPath(String ext) throws IOException {

        File file;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter the " + ext + " file path from the root : " + new File(System.getProperty("user.home")).getAbsolutePath());
            file = new File(System.getProperty("user.home") + in.readLine());
            if (file.exists() && FilenameUtils.getExtension(file.getName()).equals(ext)) {
                return file;
            } else {
                System.out.println("The directory " + file.getAbsolutePath() + " is not valid :(");
            }
        }
    }
}
