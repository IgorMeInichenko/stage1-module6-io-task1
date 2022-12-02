package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        // -----------
        String fromTextName;
        Integer fromTextAge;
        String fromTextEmail;
        Long fromTextNumber;
        // -----------
        String[] constructor = new String[4];
        String textInFile = "";
        try (FileInputStream in = new FileInputStream(file)){
            int c;
            while ((c = in.read()) != -1){
                textInFile += (char)c;
            }
        }
        catch (FileNotFoundException fe){
            return new Profile();
        }
        catch (IOException e){
            return null;
        }
        String[] linesInFile;
        linesInFile = textInFile.split("\r\n");
        for (int i = 0; i < linesInFile.length; i++) {
            String[] temp = linesInFile[i].split(": ");
            constructor[i] = temp[1];
        }
        fromTextName = constructor[0];
        fromTextAge = Integer.valueOf(constructor[1]);
        fromTextEmail = constructor[2];
        fromTextNumber = Long.valueOf(constructor[3]);
        return new Profile(fromTextName,fromTextAge,fromTextEmail,fromTextNumber);
    }
}
