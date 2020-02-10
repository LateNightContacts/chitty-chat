package lateNights;

import jdk.jshell.spi.ExecutionControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Contacts {

    public static List<Contact> contactBook = new ArrayList<>();

    public static void main(String[] args) {

        contactsFile();
        writeContact();
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



    static void readContact(){
        try {
            File myCont = new File ("contacts.txt");
            Scanner contReader = new Scanner(myCont);
            while (contReader.hasNextLine()) {
                String contData = contReader.nextLine();
                System.out.println(contData);
            }
            contReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }

    }



    public static void writeContact(){
//        HashMap<String, Contact> contactBook = new HashMap<>();
        Contact newContact = new Contact();
        Scanner scanner = new Scanner(System.in);

    //======CONTACT INFO======//
        //   SETS NAME
        System.out.println("New contacts Name: ");
        String contName = scanner.nextLine();
        newContact.setContactName(contName);
        //  SETS PHONE NUMBER
        System.out.println(contName + "'s phone number?");
        String phoneNumber = scanner.nextLine();
        newContact.setPhoneNumber(phoneNumber);
        //  SETS EMAIL
        System.out.println("What about "+ contName +"'s email?");
        String email = scanner.nextLine();
        newContact.setEmail(email);
        //  SETS SNAPCHAT
        System.out.println("How about that SnapChat?");
        String snapChat = scanner.nextLine();
        newContact.setSnapChat(snapChat);

        contactBook.add(newContact);
        try {
            Path contactFile = Paths.get("Contacts Book", "contacts.txt");
            Files.writeString(contactFile, contactBook.get(0).getContactName());
        } catch (IOException ioe){
            ioe.printStackTrace();
        }




    }


}
