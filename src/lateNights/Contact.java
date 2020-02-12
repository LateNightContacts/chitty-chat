/*
*
*
charlie, 3456782, charlie2@gmail.com, snap
charlie2, 1234556, three@gmail.com, no
gaston, 78958743, gaston@gmail.com, yes
NEW EEMP, 38947656, EEMP@GMAIL.COM, SNAP
gt, 323232323223, gt@gmail.com, gt
gt, 423423423, gt@gmaillll,com, fdsf
gt, 3423423423423, gt^terter, trter
hung, 9876654, hung@gmail.com, snappers
laugh, 1234557, laughy@gmail.com, gigglesalot
charlie, 234567456\, ahdjah, snap
charlie3, 1234245798, acahel@gmail.com, aslkdfj
* */
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
        return this.contactName +", "+ this.phoneNumber +", "+ this.email +", "+ this.snapChat;
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
