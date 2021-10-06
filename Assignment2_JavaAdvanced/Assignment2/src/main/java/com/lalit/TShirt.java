package com.lalit;

import com.opencsv.bean.CsvBindByPosition;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Entity
@Table( name = "TSHIRTS")
@Indexed
public class TShirt {

    @Id
    @KeywordField
    @Column(name = "id", nullable = false)
    @CsvBindByPosition(position = 0, required = true)
    private String id;

    @FullTextField
    @CsvBindByPosition(position = 1, required = true)
    private String name;

    @KeywordField
    @CsvBindByPosition(position = 2, required = true)
    private String colour;

    @KeywordField
    @CsvBindByPosition(position = 3, required = true)
    private String genderRecommendation;

    @KeywordField
    @CsvBindByPosition(position = 4, required = true)
    private String size;

    @CsvBindByPosition(position = 5, required = true)
    private double price;

    @CsvBindByPosition(position = 6, required = true)
    private double rating;

    @KeywordField
    @CsvBindByPosition(position = 7, required = true)
    private String availability;

    public TShirt() {
        // this form used by Hibernate
    }

    public TShirt(String id, String name, String colour,
                  String genderRecommendation,
                  String size, double price, double rating,
                  String availability) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.genderRecommendation = genderRecommendation;
        this.size = size;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getGenderRecommendation() {
        return genderRecommendation;
    }

    public void setGenderRecommendation(String genderRecommendation) {
        this.genderRecommendation = genderRecommendation;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", genderRecommendation='" + genderRecommendation + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", availability='" + availability + '\'' +
                '}';
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
