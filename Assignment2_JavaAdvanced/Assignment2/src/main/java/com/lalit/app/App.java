package com.lalit.app;

import com.lalit.TShirt;
import com.lalit.csvutil.ProcessCSVFiles;
import com.lalit.dao.TShirtDAOHibernate;

import java.util.List;
import java.util.Scanner;

import static com.lalit.TShirt.orderBy;


public class App {
    public static void main(String[] args) {
        try {
            ProcessCSVFiles launcher = new ProcessCSVFiles();
            launcher.initiateCSVHandlerThread();

            Scanner sc = new Scanner(System.in);
            while ( true ){
                System.out.println("Enter the colour");
                String colour = sc.nextLine();

                System.out.println("Enter the size of TShirt ( for e.g., S, M, L, XL, XXL )");
                String size = sc.nextLine();

                System.out.println("Enter the gender(M, F)");
                String gender = sc.nextLine();

                System.out.println("Sort the searched t-shirts by: 1.Price 2.Rating 3.Price and Rating");
                int outputPreference = Integer.parseInt(sc.nextLine());

                List<TShirt> tshirts = TShirtDAOHibernate.searchTShirts(colour, gender, size);
//                orderBy(tshirts, outputPreference);
                System.out.println(tshirts);
                System.out.println("Search more ??: Y or N");
                if ( sc.nextLine().equalsIgnoreCase("n") )
                    System.exit(1);
            }
    } catch (Exception e) {
        System.out.println("Error in db operations");
        e.printStackTrace();
    }
    }
}
