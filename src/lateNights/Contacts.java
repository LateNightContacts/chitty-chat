package lateNights;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Contacts {
    public List<Contact> contactBook;
    private int totalContacts = 0;

    public static void main(String[] args) {
        Contacts contactsApp = new Contacts();
        String directory = "Contacts Book";
        String filename = "contacts.txt";

        Path contactsDirectory = Paths.get(directory);
        System.out.println(contactsDirectory.toAbsolutePath());
        Path contactsFile = Paths.get(directory, filename);

        contactsApp.contactsFile(contactsDirectory, contactsFile);
        contactsApp.readContact(contactsFile);
        contactsApp.writeContact();
    }

    public Contacts() {
        this.contactBook = new ArrayList<>();
    }

    public void contactsFile(Path contactsDirectory, Path contactsFile) {
        try {
            if (Files.notExists(contactsDirectory)) {
                Files.createDirectories(contactsDirectory);
                System.out.println("Contacts directory created.");
            }
            if (!Files.exists(contactsFile)) {
                Files.createFile(contactsFile);
                System.out.println("Contacts file created.");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void readContact(Path contactsFile) {
        try {
            File myCont = new File(contactsFile.toString());
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

    public void writeContact() {
        Contact newContact = new Contact();
        Scanner scanner = new Scanner(System.in);

        //======CONTACT INFO======//
        //   SETS NAME
        System.out.println("New contacts Name: ");
        String contName = scanner.nextLine();
        newContact.setContactName(contName);
        //  SETS PHONE NUMBER
        System.out.println("What's " + contName + "'s phone number?");
        String phoneNumber = scanner.nextLine();
        newContact.setPhoneNumber(phoneNumber);
        //  SETS EMAIL
        System.out.println("What about " + contName + "'s email?");
        String email = scanner.nextLine();
        newContact.setEmail(email);
        //  SETS SNAPCHAT
        System.out.println("How about that SnapChat?");
        String snapChat = scanner.nextLine();
        newContact.setSnapChat(snapChat);

        Contact entry;
        entry = new Contact(contName, phoneNumber, email, snapChat);
        contactBook.add(entry);
        totalContacts++;


        try {
            Path contactFile = Paths.get("Contacts Book", "contacts.txt");
            for (int i = 0; i < totalContacts; i = totalContacts + 1) {
                Files.writeString(contactFile,
                        contactBook.get(i).getContactName() +" | "+
                             contactBook.get(i).getPhoneNumber() +" | "+
                             contactBook.get(i).getEmail() +" | "+
                             contactBook.get(i).getSnapChat() +
                             System.lineSeparator(),
                             StandardOpenOption.APPEND);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
