package com.example.RestaurantWebApp.repositories;

import com.example.RestaurantWebApp.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository  extends JpaRepository<Dish, Long> {
}
