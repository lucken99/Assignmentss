final class FoodItem{

	private static final double PERCENT = 100.0;
	private static final int HEALTHY_FAT_LIMIT = 30;
	
	private final String foodName;
	private final Fat fatObj;
	private final int totalCalories;

	public FoodItem(String foodName, double fatInGrams, int totalCalories){
		assert totalCalories < 0 : "Please provide valid calories.";
		this.foodName = foodName;
		this.fatObj = new Fat(fatInGrams);
		this.totalCalories = totalCalories;
	}
	public String getFoodName(){
		return this.foodName;
	}

	public Fat getFatObj(){
		return this.fatObj;
	}

	public int getTotalCalories(){
		return this.totalCalories;
	}

	public double calculateFatCalPercent(){
		if (this.totalCalories == 0){
			return  0;
		}
		return ((this.fatObj.gramsFatToCalories() / this.totalCalories) * PERCENT);

	}

	public boolean isHealthyFatPercent(){
		return calculateFatCalPercent() <= HEALTHY_FAT_LIMIT;
	}
}