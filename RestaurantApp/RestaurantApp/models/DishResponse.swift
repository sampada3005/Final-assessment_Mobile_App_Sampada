//
//  DishResponse.swift
//  RestaurantApp
//
//  Created by Sampada Deshmukh on 01/04/24.
//

import Foundation

import Foundation

struct Dish: Codable, Identifiable {
    let id: Int
    let dishName: String
    let price: String
    let ingredients: String
    let tag: String
    let prepMinutes: String
    let image: String
    
    init() {
        self.id = 0
        self.dishName = ""
        self.price = ""
        self.ingredients = ""
        self.tag = ""
        self.prepMinutes = ""
        self.image = ""
    }
}

struct DishResponse: Codable {
    let payload: Dish?
    let message: String?
    let status: String?
}
