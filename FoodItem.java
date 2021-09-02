final class FoodItem{
	private final int GRAM_TO_CAL_CONVERSION_FACTOR = 9;
	private final double PERCENT = 100.0;
	private final int HEALTHY_FAT_LIMIT = 30;
	
	private final String foodName;
	private final Fat fatObj;
	private final int totalCalories;

	public FoodItem(String foodName, double fatInGrams, int totalCalories){
		assert totalCalories > 0 : "Please provide valid calories.";
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
		return (((this.fatObj.getFatInGrams() * this.GRAM_TO_CAL_CONVERSION_FACTOR) / this.totalCalories) * this.PERCENT);

	}
	public boolean isHealthyFatPercent(){
		return calculateFatCalPercent() <= this.HEALTHY_FAT_LIMIT;
	}



}