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
            if ( tShirt.getColour().equalsIgnoreCase(colour)
                && ( tShirt.getGenderRecommended() == "U"
                        || tShirt.getGenderRecommended().equalsIgnoreCase(gender) )
                && tShirt.getSize().equalsIgnoreCase(size) ) {
                searchedTShirts.add(tShirt);
            }
        }

        return searchedTShirts;
    }
}
