import java.util.Scanner;

public class MobileMain {
    private static Scanner scan = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("758 722 7452");


    public static void main(String[] args) {
        boolean quite = false;
        startPhone();
        printActions();
        while(!quite){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scan.nextInt();
            scan.nextLine();

            switch(action){
                case 0:
                    System.out.println("Shutting down...");
                    quite = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void startPhone(){
        System.out.println("Starting phone....");
    }

    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                           "1 - to print contacts\n" +
                           "2 - to add new contact\n" +
                           "3 - update an existing contact\n" +
                           "4 - to remove an existing contact\n" +
                           "5 - query if an existing contact exist\n" +
                           "6 - print list of available actions");
        System.out.println("Choose your action: ");
    }

    private static void addNewContact(){
        System.out.println("Enter contact name:");
        String contactName = scan.nextLine();
        System.out.println("Enter contact number:");
        String contactNumber = scan.nextLine();
        Contacts newContact = Contacts.createNewContact(contactName, contactNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: " + contactName + " phone# " + contactNumber);
        }
        else{
            System.out.println("Cannot add " + contactName + " already on file.");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name:");
        String name = scan.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
        }

        System.out.print("Enter new contact name: ");
        String newName = scan.nextLine();
        System.out.println("Enter new contact number: ");
        String newNumber = scan.nextLine();
        Contacts newContact = Contacts.createNewContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContact, newContact)){
            System.out.println("Successfully updated record");
        }
        else
            System.out.println("Error updating record");
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name:");
        String name = scan.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
        }
        if(mobilePhone.removeContact(existingContact)){
            System.out.println("Successfully deleted");
        }
        else
            System.out.println("Error deleting");
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name:");
        String name = scan.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
        }
        System.out.println("Name: " + existingContact.getName() + " phone number is " + existingContact.getPhoneNumber());
    }
}
