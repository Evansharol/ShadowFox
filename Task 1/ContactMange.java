import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

public class ContactMange {

    public static ArrayList<Contact> contacts = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;  // Correctly exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phoneNumber, email));
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nContacts:");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private static void updateContact() {
        viewContacts();
        if (!contacts.isEmpty()) {
            System.out.print("Enter the number of the contact to update: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the newline

            if (index >= 0 && index < contacts.size()) {
                Contact contact = contacts.get(index);

                System.out.print("Enter new name (leave blank to keep unchanged): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    contact.setName(name);
                }

                System.out.print("Enter new phone number (leave blank to keep unchanged): ");
                String phoneNumber = scanner.nextLine();
                if (!phoneNumber.isEmpty()) {
                    contact.setPhoneNumber(phoneNumber);
                }

                System.out.print("Enter new email (leave blank to keep unchanged): ");
                String email = scanner.nextLine();
                if (!email.isEmpty()) {
                    contact.setEmail(email);
                }

                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }
    }

    private static void deleteContact() {
        viewContacts();
        if (!contacts.isEmpty()) {
            System.out.print("Enter the number of the contact to delete: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the newline

            if (index >= 0 && index < contacts.size()) {
                contacts.remove(index);
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }
    }
}
