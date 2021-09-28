package com.lalit.app;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
public class TShirt {

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String colour;

    @CsvBindByPosition(position = 3)
    private String genderRecommended;

    @CsvBindByPosition(position = 4)
    private String size;

    @CsvBindByPosition(position = 5)
    private double price;

    @CsvBindByPosition(position = 6)
    private double rating;

    @CsvBindByPosition(position = 7)
    private String availability;

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

    public String getGenderRecommended() {
        return genderRecommended;
    }

    public void setGenderRecommended(String genderRecommended) {
        this.genderRecommended = genderRecommended;
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
                ", genderRecommended='" + genderRecommended + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", availability='" + availability + '\'' +
                '}';
    }
}
