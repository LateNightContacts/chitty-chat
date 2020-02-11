package lateNights;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class Contacts {
    public List<Contact> contactBook;
    private static boolean switcher = true;

    public static void main(String[] args) {
        Contacts contactsApp = new Contacts();
        String directory = "Contacts Book";
        String filename = "contacts.txt";

        Path contactsDirectory = Paths.get(directory);
        System.out.println(contactsDirectory.toAbsolutePath());
        Path contactsFile = Paths.get(directory, filename);

        contactsApp.contactsFile(contactsDirectory, contactsFile);

        do {
            contactsApp.contactsMenu(directory, filename);
        } while(switcher);

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

// WRITE TO CONTACT BOOK
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

        //  ADDING USER INPUTS TO NEW CONTACT INSTANCE
        Contact entry;
        entry = new Contact(contName, phoneNumber, email, snapChat);
        contactBook.add(entry);

        //  WRITE NEW CONTACT TO FILE
        try {
            Path contactFile = Paths.get("Contacts Book", "contacts.txt");
            Files.writeString(contactFile, contactBook.get(0).toString() +
                            System.lineSeparator(),
                    StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

// VIEW ALL CONTACTS
    public void viewAllContacts(String directory, String filename) {
        try {
            Path contactsPath = Paths.get(directory, filename);
            List<String> contactsBook = Files.readAllLines(contactsPath);

            for (int i = 0; i < contactsBook.size(); i++) {
                System.out.println((i + 1) + ": " + contactsBook.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//  SEARCH CONTACTS BOOK
    public void searchContactBook(String file) {
        Scanner contactSearch = new Scanner(System.in);
        System.out.println("\nSearch address book: ");
        String userSearch = contactSearch.nextLine();


        for (int i = 0; i < contactBook.size() ; i++) {
            if (contactBook.get(i).getContactName().contains(userSearch)){

            }
        }
    }

//  CONTACTS MENU
    public void contactsMenu(String directory, String file){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\tAddress Book Menu");
        System.out.println("\t-----------------");
        System.out.println("  1: Show all contacts ");
        System.out.println("  2: Add Person");
        System.out.println("  3: Edit Person");
        System.out.println("  4: Search Address Book ");
        System.out.println("  5: Quit");
        System.out.print("\n\tType your choice: ");
        char choice = sc.nextLine().toUpperCase().charAt(0);

        while ((choice != '1') && (choice != '2') && (choice != '3') && (choice != '4') && (choice != '5')) {
            System.out.println("Invalid choice!  Please select Add, Delete, Modify, Search or Quit: ");
            choice = sc.nextLine().toUpperCase().charAt(0);
        }
        switch (choice) {
            case '1':
                viewAllContacts(directory, file);
                break;
            case '2':
                writeContact();
                break;
            case '3':
                break;
            case '4':
                searchContactBook(file);
                break;
            case '5':
                switcher = false;
                System.out.println("Have a nice day!");
                System.exit(0);
                break;
            default:
        }
    }

}





//                            contactBook.get(i).getContactName() +" | "+
//            contactBook.get(i).getPhoneNumber() +" | "+
//            contactBook.get(i).getEmail() +" | "+
//            contactBook.get(i).getSnapChat() +
