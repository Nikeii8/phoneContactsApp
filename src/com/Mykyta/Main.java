package com.Mykyta;

import sun.awt.ModalExclude;

import java.util.Scanner;



// Once you run the program, use the naviagtion to add contacts , their phone nubmers,
// and it will be stored accordingly in the database. You can also remove and check
// the existing contacts.


public class Main {

    private static Scanner scanners = new Scanner(System.in);
    private static mobilePhone mobilePhone = new mobilePhone("435 946 4549");


    public static void main(String[] args) {


        boolean quit = false;
        startUp();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanners.nextInt();
            scanners.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down....");
                    quit = true;
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

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanners.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanners.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: " + name + ", phone = " + phone);

        } else {
            System.out.println("Cannot add, " + name + " already on file");

        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanners.nextLine();
        Contact existingContactRecord = mobilePhone.quertyContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanners.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanners.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanners.nextLine();
        Contact existingContactRecord = mobilePhone.quertyContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");

        } else {
            System.out.println("Error ocurred while deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanners.nextLine();
        Contact existingContactRecord = mobilePhone.quertyContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name " + existingContactRecord.getName() + " Phone number is " + existingContactRecord.getPhoneNumber());

    }


    private static void startUp() {
        System.out.println("Starting up....");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress one of the following:");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - query if an existing cotnact exists\n" +
                "6 - to print a list of available actions.");
        System.out.println("Select your actions ");
    }

}
