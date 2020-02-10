package lateNights;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Contacts {

    public static void main(String[] args) {
        HashMap<String, Contact> contacts = new HashMap<>();
        contactsFile();

    }



    static void contactsFile(){
        String directory = "Contacts Book";
        String filename = "contacts.txt";

        Path contactsDirectory = Paths.get(directory);
        System.out.println(contactsDirectory.toAbsolutePath());
        Path contactsFile = Paths.get(directory, filename);

        try{
            if(Files.notExists(contactsDirectory)){
                Files.createDirectories(contactsDirectory);
                System.out.println("Contacts directory created.");
            }
            if(!Files.exists(contactsFile)){
                Files.createFile(contactsFile);
                System.out.println("Contacts file created.");
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    static void writeContact(){
        List<String> contact = new ArrayList<>();

    }


}
