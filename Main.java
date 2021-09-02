import java.util.Scanner;

public class Main {

	private static String getInput(String prompt){
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt);
		return sc.nextLine();
	}

	public static void main(String[] args) {
		String foodName = getInput("Enter the name of a food item: ");
		double fatInGrams = Double.parseDouble(getInput("Enter the grams of fat: "));
		int totalCalories = Integer.parseInt(getInput("Enter the number of calories: "));

		FoodItem foodObj = new FoodItem(foodName, fatInGrams, totalCalories);

		double fatCalPer = foodObj.calculateFatCalPercent();
		System.out.println(foodObj.getFoodName()+" has "
							+String.format("%.2f", fatCalPer)
							+" % of calories that comes from fat.");

		if(foodObj.isHealthyFatPercent()){
			System.out.println("This item is Heart Healthy!");
		}
		else{
			System.out.println("This item is NOT Heart Healthy!");
		}

	}
}