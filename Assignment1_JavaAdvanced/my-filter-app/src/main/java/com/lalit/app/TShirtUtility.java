package com.lalit.app;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TShirtUtility {

    private static final String FOLDER_PATH = "src\\main\\resources\\csv_files\\";

    private static List<String> getCSVFiles() {
        List<String> csvFiles = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(FOLDER_PATH))) {
            csvFiles = walk.map(Path::toString)
                    .filter(f -> f.endsWith(".csv")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvFiles;
    }

    public static List<TShirt> searchTShirts(String colour, String size, String gender) {
        List<TShirt> resultingTShirts = new ArrayList<>();
        for (String fileName: getCSVFiles()) {
            try (FileReader fr = new FileReader(fileName)) {
                 resultingTShirts = new CsvToBeanBuilder<TShirt>(fr)
                        .withSeparator('|')
                        .withSkipLines(1)
                        .withType(TShirt.class)
                        .build()
                        .stream().filter(getCondition(colour, size, gender))
                         .collect(Collectors.toList());
            } catch (IOException e) {
                    e.printStackTrace();
            }
        }
        return resultingTShirts;
    }

    private static Predicate<TShirt> getCondition(String colour, String size, String gender) {
        return x -> x.getAvailability().equalsIgnoreCase("Y")
                && x.getColour().equalsIgnoreCase(colour)
                && x.getSize().equalsIgnoreCase(size)
                && x.getGenderRecommended().equalsIgnoreCase(gender);
    }
    
    // comaprator chaining can be used here

    public static void orderBy(List<TShirt> tShirts, String preference) {
        if (preference.equalsIgnoreCase("price")) {
            Collections.sort(tShirts, new PriceComparator());
        }
        else if (preference.equalsIgnoreCase("rating")) {
            Collections.sort(tShirts, new RatingComparator());
        } else if (preference.equalsIgnoreCase("both")
                        || preference.equalsIgnoreCase("price and rating")) {
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
