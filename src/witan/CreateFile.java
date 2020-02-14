package witan;

import java.io.File;
import java.io.IOException;

public class CreateFile {           // Creating empty file
    boolean exists;

    CreateFile(String filename) {
        try {
            File newFile = new File(filename);
            exists = !newFile.createNewFile(); //if file exists true if not false
            //System.out.println(exists);   // Checking if value match
        } catch (IOException e) {
            e.printStackTrace();
            exists = false;
            //System.out.println(exists);   // Checking if value match
        }
    }
}
