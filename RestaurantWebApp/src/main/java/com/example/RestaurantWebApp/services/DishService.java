package com.example.RestaurantWebApp.services;

import com.example.RestaurantWebApp.models.Dish;
import com.example.RestaurantWebApp.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    DishRepository dishRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Dish getDishById(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        if (dish.isPresent()) {
            return dish.get();
        } else {
            return new Dish();
        }
    }

    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public String deleteDish(Long id) {
        if (dishRepository.findById(id).isPresent()) {
            dishRepository.deleteById(id);
            return "dish deleted successfully";
        } else {
            return "unable to deleted dish";
        }
    }

    public Dish update(Long id, Dish dish) {
        Optional<Dish> optionalDish = dishRepository.findById(dish.getId());

        if (optionalDish.isPresent()) {
            optionalDish.get().setDishName(dish.getDishName());
            optionalDish.get().setImage(dish.getImage());
            optionalDish.get().setIngredients(dish.getIngredients());
            optionalDish.get().setPrice(dish.getPrice());
            optionalDish.get().setPrepMinutes(dish.getPrepMinutes());
            optionalDish.get().setTag(dish.getTag());

            Dish updatedDish = dishRepository.save(optionalDish.get());
            return updatedDish;
        }
        else{
            return new Dish();
        }
    }
}
