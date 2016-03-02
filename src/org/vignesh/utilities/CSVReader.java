package org.vignesh.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vignesh.prabhu@outlook.com on 3/2/16.
 */
public class CSVReader {

    public static List<String> read(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String separator = ",";
        String[] tokens= null;
        List<String> bindVariables = new ArrayList<String>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                tokens = line.split(separator);
            }

            for (int i = 0; i < tokens.length; i++) {
                    bindVariables.add(tokens[i]);
            }
       } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bindVariables;
    }
}
