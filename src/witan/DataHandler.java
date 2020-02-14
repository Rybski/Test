package witan;

import java.util.Scanner;

public class DataHandler {
    String data;

    DataHandler(String dataToHandle) {
        CreateFile newFile = new CreateFile(dataToHandle + "Settings.json");   //Create file if not exists
        //System.out.println(userFile.exists);    //Checking value from CreateFile true if exists false if not or error

        if (newFile.exists) {                        //if file exists
            ReadFile myFile = new ReadFile(dataToHandle + "Settings.json");
            System.out.println("Last used " + dataToHandle + " was: " + myFile.readText);
            IsNullOrEmpty nullCheck = new IsNullOrEmpty(myFile.readText);
            if (nullCheck.isOrIsNot) {                //if file exists and is empty
                //System.out.println("File is empty");
                data = GetDataFromUser(dataToHandle, dataToHandle + "Settings.json");

            } else {                                    //if file exists and is not empty
                data = myFile.readText;
                //System.out.println("File is not empty");
            }
        } else {                                       //Get info from user and write to file if possible
            data = GetDataFromUser(dataToHandle, dataToHandle + "Settings.json");
        }
    }

    private static String GetDataFromUser(String dataToTake, String whereItShouldGo) {
        Scanner scan = new Scanner(System.in);
        System.out.println(dataToTake + ": ");
        final String data = scan.nextLine();
        new WriteToFile(data, whereItShouldGo);
        return data;
    }

}
