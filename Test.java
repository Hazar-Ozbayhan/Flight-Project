/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proje2;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author rushl
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NullPointerException, Exception {

        ArrayList<Date> arr = new ArrayList<>();
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        BSTClass bst = new BSTClass();

        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome! To start please enter 1: ");
        int op = scn.nextInt();

        if (op == 1) {
            System.out.println("Lets start!");
            System.out.println("Choose an event!");
            System.out.println("1)Insert and remove flight information");
            System.out.println("2)Search for flights by date");
            System.out.println("3)Search for flights by date, however if the given date does not exist in the table show the closest before and after dates which have flight.");
            System.out.println("4)Search for flights by from city");
            System.out.println("5)Search for flights with both from city and date.");
            System.out.println("6)Search for flights between two dates.");
            System.out.println("7)Search for flights less than a given price in a given date.");
            int event = scn.nextInt();
            boolean quit = true;

            while (quit) {
                event = scn.nextInt();
                switch (event) {
                    case 1:
                        File file = new File("FlightInformation.txt");
                        bst.readFromFile(file);
                        break;
                    case 2:
                        Date a = new Date();
                        System.out.println("Enter year");
                        int x = scn.nextInt();
                        a.setYear(x - 1900);
                        System.out.println("Enter month");
                        int y = scn.nextInt();
                        a.setMonth(y);
                        System.out.println("Enter day");
                        int z = scn.nextInt();
                        a.setDate(z);
                        if (bst.searchDate(a).isEmpty()) {
                            System.out.println("It is empty");
                            return;
                        }
                        System.out.println(bst.searchDate(a).toString());
                        break;
                    case 3:

                        break;
                    case 4:
                        System.out.println("Enter name of city");
                        String city = scn.next();
                        if (bst.searchFrom(city).isEmpty()) {
                            System.out.println("It is empty");
                            break;
                        }
                        for (int i = 0; i < bst.searchFrom(city).size(); i++) {
                            System.out.println(bst.searchFrom(city).get(i).toString());
                        }
                        break;
                    case 5:
                        Date b = new Date();
                        System.out.println("Enter year");
                        int k = scn.nextInt();
                        b.setYear(k - 1900);
                        System.out.println("Enter month");
                        int l = scn.nextInt();
                        b.setMonth(l);
                        System.out.println("Enter day");
                        int m = scn.nextInt();
                        b.setDate(m);
                        System.out.println("Enter name of city");
                        String city1 = scn.next();

                        if (bst.searchFrom(city1).isEmpty()) {
                            System.out.println("It is empty");
                            break;
                        }

                        System.out.println();
                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    default:

                }
            }
        }
    }

}
