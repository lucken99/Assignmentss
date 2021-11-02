package com.lalit.app;

import java.util.List;
import java.util.Scanner;

import static com.lalit.app.TShirtUtility.orderBy;
import static com.lalit.app.TShirtUtility.searchTShirts;

/**
 * Author {
 *     name = "Lalit Singh",
 *     date = "26-09-2021"
 *         }
 */

public class App 
{
    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Color of T-Shirt to search: ");
        String color = sc.nextLine();
        System.out.println("Enter the gender(M, F, U) preference: ");
        String gender = sc.nextLine();
        System.out.println("Enter the Size(S, M, L, XL) of T-Shirt: ");
        String size = sc.nextLine();
        System.out.println("Output Preference for sorting by (Price, Rating or Price and Rating): ");
        String outputPreference = sc.nextLine();

        List<TShirt> availTShirt = searchTShirts(color, size, gender);
        orderBy(availTShirt, outputPreference);
        if (availTShirt.size() == 0) {
            System.out.println("Sorry! No T-Shirts Found.");
        }
        else {
            for (TShirt tshirt : availTShirt) {
                System.out.println(tshirt);
            }
        }
    }
}
