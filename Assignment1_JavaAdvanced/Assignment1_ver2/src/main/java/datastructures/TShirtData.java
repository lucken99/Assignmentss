package datastructures;

import entities.TShirt;

import java.util.*;

public class TShirtData {
    /*
    Instance of Singleton Class
     */

    private static TShirtData singletonInstance;

    private List<TShirt> tShirtDataCollection = new ArrayList<>();

    public static synchronized TShirtData getInstance() {
        if ( null == singletonInstance ) {
            singletonInstance = new TShirtData();
        }
        return singletonInstance;
    }

    public void insertCSVFileData(List<TShirt> tShirtData) {
        for (TShirt tShirt : tShirtData ) {
            tShirtDataCollection.add(tShirt);
        }
    }

    public List<TShirt> getRequiredTShirts(String colour, String gender, String size) {
        List<TShirt> searchedTShirts = new ArrayList<>();
        for (TShirt tShirt : tShirtDataCollection) {
            if (tShirt.getAvailability() && tShirt.getColour().equalsIgnoreCase(colour)
                && ( tShirt.getGenderRecommended() == "U"
                        || tShirt.getGenderRecommended().equalsIgnoreCase(gender) )
                && tShirt.getSize().equalsIgnoreCase(size) ) {
                searchedTShirts.add(tShirt);
            }
        }

        return searchedTShirts;
    }

    public static void orderBy(List<TShirt> tShirts, int preference) {
        if (preference == 1) {
            Collections.sort(tShirts, new PriceComparator());
        }
        else if (preference == 2) {
            Collections.sort(tShirts, new RatingComparator());
        } else if (preference == 3) {
            Collections.sort(tShirts, new PriceComparator().thenComparing(new RatingComparator()));
        }
    }
    public static class PriceComparator implements Comparator<TShirt> {

        @Override
        public int compare(TShirt tShirt1, TShirt tShirt2) {
            return Double.compare(tShirt1.getPrice(), tShirt2.getPrice());
        }
    }

    public static class RatingComparator implements Comparator<TShirt> {

        @Override
        public int compare(TShirt tShirt1, TShirt tShirt2) {
            return Double.compare(tShirt1.getRating(), tShirt2.getRating());
        }
    }

}
