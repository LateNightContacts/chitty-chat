package lateNights;

public class Contact extends Contacts {
    private String contactName;
    private long phoneNumber;
    private String email;
    private boolean availability;

//    DEFAULT CONSTRUCTOR
    public Contact(){}
//    CONSTRUCTOR FOR CONTACT
    public Contact(String name, long phoneNumber, String email, boolean availability){
        this.contactName = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.availability = availability;
    }

//    GETTERS
    public String getContactName() { return contactName; }
    public String getEmail() { return email; }
    public long getPhoneNumber() { return phoneNumber; }
//    SETTERS
    public void setContactName(String contactName) { this.contactName = contactName; }
    public void setPhoneNumber(long phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setAvailability(boolean availability) { this.availability = availability; }
}
