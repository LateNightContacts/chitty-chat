package lateNights;

public class Contact extends Contacts {
    private String contactName;
    private String phoneNumber;
    private String email;
    private String snapChat;

    //    DEFAULT CONSTRUCTOR
    public Contact() {
    }

    //    CONSTRUCTOR FOR CONTACT
    public Contact(String name, String phoneNumber, String email, String snapChat) {
        this.contactName = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.snapChat = snapChat;
    }


    public String toString(){
        return this.contactName +" | "+ this.phoneNumber +" | "+ this.email +" | "+ this.snapChat;
    }

//    GETTERS
    public String getContactName() { return this.contactName; }
    public String getEmail() { return this.email; }
    public String getPhoneNumber() { return this.phoneNumber; }
    public String getSnapChat() { return this.snapChat; }



    //    SETTERS
    public void setContactName(String contactName) { this.contactName = contactName;}
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setSnapChat(String snapChat) { this.snapChat = snapChat; }

}
