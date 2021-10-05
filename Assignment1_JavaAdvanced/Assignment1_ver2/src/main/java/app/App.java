package app;

import csvservices.ProcessCSVFiles;
import entities.TShirt;
import datastructures.TShirtData;

import java.util.List;
import java.util.Scanner;

import static datastructures.TShirtData.orderBy;

public class App {
	public static void main( String[] args ) {
		try {
			/*
			 * Initializes the class that perform all csv
			 * files related operations
			 */
			ProcessCSVFiles launcher = new ProcessCSVFiles();
			launcher.initialteThreadClass();

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

				TShirtData singleton = TShirtData.getInstance();
				List<TShirt> tShirts = singleton.getRequiredTShirts(colour, gender, size);
				orderBy(tShirts, outputPreference);
				System.out.println(tShirts);

				System.out.println("Search more ??: Y or N");
				if ( sc.nextLine().equalsIgnoreCase("n") )
					System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("Error while reading input!");
			e.printStackTrace();
		}
	}
}