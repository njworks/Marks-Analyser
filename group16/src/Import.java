/**
 * Created by tramch 1502020 on 08/02/2017.
 * Contributor njosepa
 */

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Import {

    //reading csv file
    public static void fileRead(){
        BufferedReader fileBuffer = null;
        try {
            String fileLine;

            fileBuffer = new BufferedReader(new FileReader(GUI.f));

            // read file in java line by line
            while ((fileLine = fileBuffer.readLine()) != null) {
                Modules.store.add(Import.CSVtoArrayList(fileLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "File Not Found");
        } finally {
            try {
                if (fileBuffer != null) fileBuffer.close();
            } catch (IOException Exception) {
                Exception.printStackTrace();
            }
        }
    }

    // converts CSV to ArrayList using Split Operation
    public static ArrayList<String> CSVtoArrayList(String CSVfile) {
        ArrayList<String> output = new ArrayList<String>();

        if (CSVfile != null) {
            String[] Data = CSVfile.split("\\s*,\\s*"); // splits data with separator
            for (int i = 0; i < Data.length; i++) {
                if (!(Data[i] == null) || !(Data[i].length() == 0)) {
                    output.add(Data[i].trim()); // add for output when all data from a line is added
                }
            }
        }
        return output;
    }
}

// Reference: http://crunchify.com/how-to-read-convert-csv-comma-separated-values-file-to-arraylist-in-java-using-split-operation/