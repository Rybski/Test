package witan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile { // reading data from file
    String readText;

    ReadFile(String readFromWhere) {
        try {
            File myFile = new File(readFromWhere);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readText = data;
                //System.out.println(readText);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
