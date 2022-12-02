package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        // -----------
        String fromTextName = "";
        Integer fromTextAge = 0;
        String fromTextEmail = "";
        Long fromTextNumber = Long.valueOf(0);
        // -----------
        String[] constructor = new String[4];
        StringBuilder textInFile = new StringBuilder();
        try (FileInputStream in = new FileInputStream(file)){
            int c;
            while ((c = in.read()) != -1){
                textInFile.append((char)c);
            }
        }
        catch (FileNotFoundException fe){
            return new Profile();
        }
        catch (IOException e){
            return null;
        }
        String[] linesInFile;
        linesInFile = textInFile.toString().split("\n");
        for (int i = 0; i < linesInFile.length; i++) {
            linesInFile[i] = linesInFile[i].replace("\r","");
        }
        for (int i = 0; i < linesInFile.length; i++) {
            String[] temp = linesInFile[i].split(": ");
            constructor[i] = temp[1];
        }
        fromTextName = constructor[0];
        try {
            fromTextAge = Integer.valueOf(constructor[1]);
        }
        catch (Exception e){
            fromTextAge = null;
        }
        fromTextEmail = constructor[2];
        try {
            fromTextNumber = Long.valueOf(constructor[3]);
        }
        catch (Exception e){
            fromTextNumber = null;
        }
        return new Profile(fromTextName,fromTextAge,fromTextEmail,fromTextNumber);
    }
}
