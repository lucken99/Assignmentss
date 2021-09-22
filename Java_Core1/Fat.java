final class Fat{
    private static final int GRAM_TO_CAL_CONVERSION_FACTOR = 9;

    private final double fatInGrams;

    public Fat(double fatInGrams){
        this.fatInGrams = fatInGrams;
    }

    public double getFatInGrams(){
        return this.fatInGrams;
    }

    public double gramsFatToCalories(){
        return this.fatInGrams * GRAM_TO_CAL_CONVERSION_FACTOR;
    }
}