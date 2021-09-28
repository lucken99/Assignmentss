package com.lalit.app;

import java.util.Scanner;

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
        System.out.println("Enter the Size(S, M, L, XL) of T-Shirt: ");
        String size = sc.nextLine();
        System.out.println("Enter the gender(M, F) preference: ");
        String gender = sc.nextLine();
        System.out.println("Output Preference (for e.g., by Price, by Rating or by Price and Rating: ");
        String outputPreference = sc.nextLine();

        searchTShirts(color, size, gender);
    }
}
