import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        // Create lists to store contacts and missed calls
        ArrayList<Contact> contacts = new ArrayList<>();
        ArrayList<MissedCall> missedCalls = new ArrayList<>();

        // Adding initial contacts to the list
        contacts.add(new Contact(1234, "name1"));
        contacts.add(new Contact(9980, "name2"));
        contacts.add(new Contact(3415, "name3"));

        System.out.println(contacts);

        Scanner sc = new Scanner(System.in);  // Create a Scanner object for user input

        while (true) {  // Infinite loop to keep the application running
            System.out.println("SELECT 1.ADD MISSED CALL 2.DISPLAY 3.DELETE");
            int choice = sc.nextInt();  // Read user choice

            switch (choice) {
                case 1: {
                    // Adding a missed call
                    System.out.println("ENTER THE MISSED CALL NUMBER");
                    long num = sc.nextLong();
                    missedCalls.add(new MissedCall(num, new Date()));
                    // If the size of the missed calls list exceeds 3, remove the oldest missed call
                    if (missedCalls.size() > 3) {
                        missedCalls.remove(0);
                    }
                    break;
                }
                case 2: {
                    // Displaying all missed calls
                    System.out.println(missedCalls);
                    break;
                }
                case 3: {
                    // Deleting a missed call
                    System.out.println("delete using 1.index 2.number");
                    int deleteChoice = sc.nextInt();
                    int i = 1;

                    if (deleteChoice == 1) {
                        // Delete missed call by index
                        for (MissedCall mc : missedCalls) {
                            System.out.println(i++ + ": " + mc.number);
                        }
                        System.out.println("enter the index to be deleted");
                        int index = sc.nextInt();
                        missedCalls.remove(index - 1);
                    } else {
                        // Delete missed call by number
                        System.out.println("enter number to be deleted");
                        long number = sc.nextLong();
                        boolean found = false;
                        for (Contact c : contacts) {
                            if (c.number == number) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            contacts.add(new Contact(number));
                            System.out.println(contacts);
                        }
                        for (MissedCall m : missedCalls) {
                            if (m.number == number) {
                                missedCalls.remove(m);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

// sub class 1

import java.util.*;
public class MissedCall {
long number;
Date date;
public MissedCall(long number,Date date) {
this.number=number;
this.date=date;
}
public String toString() {
return number+" "+date;}}
// subclass 2

public class Contact {
    long number;
    String name;
    public Contact(long number,String name) {
    this.number=number;
    this.name=name;
    }
    public Contact(long number) {
    this.name="private caller";
    this.number=number;
    }
    public String toString() {
    return number+" "+name;
    }}
