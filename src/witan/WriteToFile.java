package witan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {  // Putting content into file

    WriteToFile(String textToWrite, String whereToWrite) {
        try {
            File file;
            FileWriter myWriter = new FileWriter(whereToWrite);
            myWriter.write(textToWrite);
            myWriter.close();
            System.out.println("Text was saved to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
