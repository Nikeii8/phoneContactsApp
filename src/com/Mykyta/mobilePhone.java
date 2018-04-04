package com.Mykyta;

import java.util.ArrayList;

public class mobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContact;

    public mobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on ile");
            return false;
        }
        myContact.add(contact);
        return true;

    }

    public boolean updateContact(Contact oldContact, Contact newContact) {

        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " not found");
            return false;
        }else if ( findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists, cant be replaced with " + newContact.getName());
            return true;
        }
        this.myContact.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced" + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false;
        }
        this.myContact.remove(foundPosition);
        System.out.println(contact.getName() + " , was deleted");
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContact.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContact.size(); i++) {
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact quertyContact(String name) {

        int position = findContact(name);
        if(position >= 0) {
            return this.myContact.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact list");
        for (int i = 0; i < this.myContact.size(); i++) {
            System.out.println((i + 1) + "," +
                    this.myContact.get(i).getName() + " -> " +
                    this.myContact.get(i).getPhoneNumber());
        }
    }
}