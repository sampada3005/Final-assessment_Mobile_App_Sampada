package com.example.RestaurantWebApp.controllers;

import com.example.RestaurantWebApp.beans.ResponseHandler;
import com.example.RestaurantWebApp.models.Dish;
import com.example.RestaurantWebApp.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dishes")
public class DishController {

    @Autowired
    DishService dishService;

    @GetMapping("/get")
    public ResponseEntity<Object> getAllDishes(){
        return ResponseHandler.createResponse(
                "dish Found !!!",
                HttpStatus.OK,
                dishService.getAllDishes()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id){
        return ResponseHandler.createResponse(
                "Required dish found !!!",
                HttpStatus.OK,
                dishService.getDishById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addProduct(@RequestBody Dish dish){
        return ResponseHandler.createResponse(
                "Product added successfully !!!",
                HttpStatus.CREATED,
                dishService.addDish(dish));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id){
        String deletedResponse =  dishService.deleteDish(id);
        return ResponseHandler.createResponse("dish deleted successfully", HttpStatus.OK, deletedResponse);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody Dish dish, @PathVariable Long id){
        Object response = dishService.update(id, dish);
        return ResponseHandler.createResponse("dish updated", HttpStatus.CREATED, response);
    }

}
