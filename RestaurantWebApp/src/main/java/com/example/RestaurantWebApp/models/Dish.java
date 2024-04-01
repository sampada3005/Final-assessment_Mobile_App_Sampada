package com.example.RestaurantWebApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dish_name", length = 30)
    private String dishName;

    @Column(name = "price")
    private String price;

    @Column(name = "ingredients", length = 400)
    private String ingredients;

    @Column(name = "tag", length = 20)
    private String tag;

    @Column(name = "prep_minutes", length = 30)
    private String prepMinutes;

    @Column(name = "image", length = 100)
    private String image;

    public Dish() {
    }

    public Dish(Long id, String dishName, String price, String ingredients, String tag, String prepMinutes, String image) {
        this.id = id;
        this.dishName = dishName;
        this.price = price;
        this.ingredients = ingredients;
        this.tag = tag;
        this.prepMinutes = prepMinutes;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPrepMinutes() {
        return prepMinutes;
    }

    public void setPrepMinutes(String prepMinutes) {
        this.prepMinutes = prepMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
