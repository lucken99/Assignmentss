package com.lalit.app;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TShirtUtility {
    public static void searchTShirts(String colour, String size, String gender) {
        String folderName = "src\\main\\resources\\csv_files\\";
        List<String> csvFiles = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(folderName))) {
            csvFiles = walk.map(Path::toString)
                    .filter(f -> f.endsWith(".csv")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String fileName: csvFiles) {
            try (FileReader fr = new FileReader(fileName)) {
                List<TShirt> resultingTShirts = new CsvToBeanBuilder<TShirt>(fr)
                        .withSeparator('|')
                        .withSkipLines(1)
                        .withType(TShirt.class)
                        .build()
                        .stream().filter(x -> x.getAvailability().equalsIgnoreCase("Y")
                        && (x.getColour().equalsIgnoreCase(colour)
                        && x.getSize().equalsIgnoreCase(size)
                        && x.getGenderRecommended().equalsIgnoreCase(gender))).collect(Collectors.toList());
                resultingTShirts.forEach(System.out::println);
            } catch (IOException e) {
                    e.printStackTrace();
            }

        }

    }
}
