//
//  DishListResponse.swift
//  RestaurantApp
//
//  Created by Sampada Deshmukh on 01/04/24.
//

import Foundation

struct Dishes: Codable, Identifiable {
    let id: Int
    let dishName: String
    let price: String
    let ingredients: String
    let tag: String
    let prepMinutes: String
    let image: String
}

struct DishListResponse: Codable {
    let payload: [Dishes]?
    let message: String?
    let status: String?
}
