import java.util.Scanner;

class FoodItem{

	private String foodName;
	private double fatGrams;
	private int calories;

	public String getFoodName(){
		return this.foodName;
	}

	public void setFoodName(String foodName){
		this.foodName = foodName;
	}


	public double getFatGrams(){
		return this.fatGrams;
	}

	public void setFatGrams(double fatGrams){
		this.fatGrams = fatGrams;
	}


	public int getCalories(){
		return this.calories;
	}

	public void setCalories(int calories){
		this.calories = calories;
	}


	public double calculateFatCalPercent(){
		int gramToCalFactor = 9;
		return ((getFatGrams() * gramToCalFactor * 100.0) / getCalories());

	}

}


public class Main {

	public static String getInput(String prompt){
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt);
		return sc.nextLine();
	}

	public static void main(String[] args) {
		FoodItem foodObj = new FoodItem();
		try{
			foodObj.setFoodName(getInput("Enter the name of a food item: "));
			foodObj.setFatGrams(Double.parseDouble(getInput("Enter the grams of fat in the "
									+foodObj.getFoodName()+": ")));
			foodObj.setCalories(Integer.parseInt(getInput("Enter the number of calories in "
									+foodObj.getFoodName()+": ")));
		}catch(Exception e){
			System.out.println("Invalid input");
			System.exit(1);
		}

		double fatCalPer = foodObj.calculateFatCalPercent();
		System.out.println(foodObj.getFoodName()+" has "
							+String.format("%.2f", fatCalPer)
							+" % of calories that comes from fat.");

		if(fatCalPer <= 30){
			System.out.println("This item is Heart Healthy!");
		}
		else{
			System.out.println("This item is NOT Heart Healthy!");
		}

	}
}