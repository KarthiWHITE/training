/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirjson;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author cb-admin1
 */
public class PhoneDirJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the file path from root");
        //json file in path /training/extfiles/phone.json
        PhoneDirectory pd = new PhoneDirectory(new File(System.getProperty("user.home") + in.readLine()));
        //create the contact list
        pd.assignToList();

        // menu oprations
        do {
            System.out.println("menu : \n 1. search by name \n 2. search by name contains \n 3. seach by cell number : \n 4. print all contacts \n 5. exit");
            System.out.println("Enter the index to start");
            switch (Integer.parseInt(in.readLine())) {
                case 1:
                    System.out.println("Enter the name to search : ");
                    pd.searchByName(in.readLine());
                    break;
                case 2:
                    System.out.println("Enter the string that present in the name :");
                    pd.searchByNameContains(in.readLine());
                    break;
                case 3:
                    System.out.println("Enter the cell number to search it : ");
                    pd.searchByCellNo(in.readLine());
                    break;
                case 4:
                    pd.printList();
                    break;

                case 5:
                    System.out.println("The  system will exit now");
                    System.exit(0);
            }
        } while (true);
    }
}
