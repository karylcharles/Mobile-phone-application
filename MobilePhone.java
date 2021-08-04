import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts = new ArrayList<Contacts>();

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }
        else {
            myContacts.add(contact);
            return true;
        }
    }

    private int findContact(Contacts contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i = 0; i < myContacts.size(); i++){
            Contacts contact  = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + " Contact does not exist");
            return false;
        }
        else if(findContact(newContact.getName()) != -1){
            System.out.println("Contact " + newContact.getName() + " already exist");
            return false;
        }
        else{
            myContacts.set(foundPosition, newContact);
            System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
            return true;
        }

    }

    public String queryContact(Contacts contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        else
            return null;
    }

    public boolean removeContact(Contacts contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName() + " Contact does not exist");
            return false;
        }
        else{
            myContacts.remove(foundPosition);
            System.out.println(contact.getName() + " was deleted.");
            return true;
        }
    }

    public void printContacts(){
        System.out.println("Contact list:");
        for(int i = 0; i < this.myContacts.size(); i++){
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + "-- #" +
                               myContacts.get(i).getPhoneNumber());
        }
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }
}
