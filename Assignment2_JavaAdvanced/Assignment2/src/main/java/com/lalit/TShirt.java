package com.lalit;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;

@Entity
@Table( name = "TSHIRTS")
public class TShirt {

    @Id
    @Column(name = "id", nullable = false)
    @CsvBindByPosition(position = 0, required = true)
    private String id;

    @CsvBindByPosition(position = 1, required = true)
    private String name;

    @CsvBindByPosition(position = 2, required = true)
    private String colour;

    @CsvBindByPosition(position = 3, required = true)
    private String genderRecommendation;

    @CsvBindByPosition(position = 4, required = true)
    private String size;

    @CsvBindByPosition(position = 5, required = true)
    private double prize;

    @CsvBindByPosition(position = 6, required = true)
    private double rating;

    @CsvBindByPosition(position = 7, required = true)
    private String availability;

    public TShirt() {
        // this form used by Hibernate
    }

    public TShirt(String id, String name, String colour,
                  String genderRecommendation,
                  String size, double prize, double rating,
                  String availability) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.genderRecommendation = genderRecommendation;
        this.size = size;
        this.prize = prize;
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

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
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
                ", prize=" + prize +
                ", rating=" + rating +
                ", availability='" + availability + '\'' +
                '}';
    }
}
