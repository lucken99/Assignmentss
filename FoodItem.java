final class FoodItem{

	final private String foodName;
	final private double fatInGrams;
	final private int totalCalories;

	public FoodItem(String foodName, double fatInGrams, int totalCalories){
		this.foodName = foodName;
		this.fatInGrams = fatInGrams;
		this.totalCalories = totalCalories;
	}
	public String getFoodName(){
		return this.foodName;
	}

	public double getFatInGrams(){
		return this.fatInGrams;
	}

	public int getTotalCalories(){
		return this.totalCalories;
	}

	public double calculateFatCalPercent(){
		int gramToCalFactor = 9;
		return ((this.fatInGrams * gramToCalFactor * 100.0) / this.totalCalories);

	}

	public boolean isHealthyFatPercent(){
		return this.calculateFatCalPercent() <= 30;
	}

}