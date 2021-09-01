import java.util.Scanner;

final class FoodItem{

	final private String foodName;
	final private double fatGrams;
	final private int calories;

	public FoodItem(String foodName, double fatGrams, int calories){
		this.foodName = foodName;
		this.fatGrams = fatGrams;
		this.calories = calories;
	}
	public String getFoodName(){
		return this.foodName;
	}

//	public void setFoodName(String foodName){
//		this.foodName = foodName;
//	}


	public double getFatGrams(){
		return this.fatGrams;
	}

//	public void setFatGrams(double fatGrams){
//		this.fatGrams = fatGrams;
//	}


	public int getCalories(){
		return this.calories;
	}

//	public void setCalories(int calories){
//		this.calories = calories;
//	}


	public double calculateFatCalPercent(){
		int gramToCalFactor = 9;
		return ((getFatGrams() * gramToCalFactor * 100.0) / getCalories());

	}

	public boolean isHealthyFatPercent(double fatCalPer){
		return fatCalPer <= 30;
	}

}


public class Main {

	public static String getInput(String prompt){
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt);
		return sc.nextLine();
	}

	public static void main(String[] args) {
//		FoodItem foodObj = new FoodItem();

//			foodObj.setFoodName(getInput("Enter the name of a food item: "));
//			foodObj.setFatGrams(Double.parseDouble(getInput("Enter the grams of fat in the "
//									+foodObj.getFoodName()+": ")));
//			foodObj.setCalories(Integer.parseInt(getInput("Enter the number of calories in "
//									+foodObj.getFoodName()+": ")));
		String foodName = getInput("Enter the name of a food item: ");
		double fatGrams = Double.parseDouble(getInput("Enter the grams of fat: "));
		int calories = Integer.parseInt(getInput("Enter the number of calories: "));
		FoodItem foodObj = new FoodItem(foodName, fatGrams, calories);

		double fatCalPer = foodObj.calculateFatCalPercent();
		System.out.println(foodObj.getFoodName()+" has "
							+String.format("%.2f", fatCalPer)
							+" % of calories that comes from fat.");

		if(foodObj.isHealthyFatPercent(fatCalPer)){
			System.out.println("This item is Heart Healthy!");
		}
		else{
			System.out.println("This item is NOT Heart Healthy!");
		}

	}
}