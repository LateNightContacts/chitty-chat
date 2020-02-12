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
        contactsApp.loadContacts(contactsFile);
        do {
            contactsApp.contactsMenu(directory, filename);
        } while (switcher);


    }

    public Contacts() {
        this.contactBook = new ArrayList<>();
    }

    public void loadContacts(Path contactsFile) {
        try {
            List<String> readLines = Files.readAllLines(contactsFile);
            String[] contactDetails;
            for (int i = 0; i < readLines.size(); i++) {
                contactDetails = readLines.get(i).split(", ");
                this.contactBook.add(new Contact(contactDetails[0], contactDetails[1], contactDetails[2],
                        contactDetails[3]));
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

//  CREATE FILE IF NOT EXISTING
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

// WRITE TO CONTACT BOOK
    public void writeToFile() {
        try {
            Path contactFile = Paths.get("Contacts Book", "contacts.txt");
            Files.writeString(contactFile, "", StandardOpenOption.TRUNCATE_EXISTING);
            for (int i = 0; i < this.contactBook.size(); i++) {
                Files.writeString(contactFile, contactBook.get(i).toString() + System.lineSeparator(),
                        StandardOpenOption.APPEND);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

// ADD NEW CONTACT
    public void addContact(){
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
    }

// VIEW ALL CONTACTS
    public void viewAllContacts() {
        for (int i = 0; i < this.contactBook.size(); i++) {
            System.out.println((i + 1) + ": " + this.contactBook.get(i));
        }
    }

//  SEARCH CONTACTS BOOK
    public void searchContactBook() {
        Scanner contactSearch = new Scanner(System.in);
        System.out.println("\nSearch address book: ");
        String userSearch = contactSearch.nextLine();
        System.out.println(userSearch);

        for (int i = 0; i < contactBook.size(); i++) {
            if (contactBook.get(i).getContactName().contains(userSearch)) {
                System.out.println(contactBook.get(i).toString());
            }
        }
    }

//  CONTACTS MENU
    public void contactsMenu(String directory, String file) {
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

        while ((choice != '1') && (choice != '2') && (choice != '3') && (choice != '4')) {
            System.out.println("Invalid choice!  Please select Add, Delete, Modify, Search or Quit: ");
            choice = sc.nextLine().toUpperCase().charAt(0);
        }
        switch (choice) {
            case '1':
                viewAllContacts();
                break;
            case '2':
                addContact();
                break;
            case '3':
                searchContactBook();
                break;
            case '4':
                switcher = false;
                System.out.println("Have a nice day!");
                writeToFile();
                System.exit(0);
                break;
            default:
        }
    }

}
