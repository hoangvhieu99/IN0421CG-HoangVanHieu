package utils;

import constants.CSVConstant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    /**
     *
     * @param file
     * @return <String> fileData || null
     */
    public static List<String> read(File file) {
        //row is an Object
        List<String> rows = new ArrayList<>();
        BufferedReader br = null;
        try {
            String row;
            br = new BufferedReader(new FileReader(file));

            while ((row = br.readLine()) != null) {
                rows.add(row);
            }

            return rows;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    /**
     *
     * @param fileData
     * @return <Boolean> true if success
     */
    public static Boolean write(List<String> fileData, File file) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file.getPath());
            for (String row : fileData) {
                fileWriter.append(row.toString());
                fileWriter.append(CSVConstant.NEW_LINE_SEPARATOR);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
