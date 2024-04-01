//
//  ContentView.swift
//  RestaurantApp
//
//  Created by Sampada Deshmukh on 01/04/24.
//

import SwiftUI

struct DishListScreen: View {
    
    @State var dishes : [Dishes] = []
    @State var allDishes : [Dishes] = []
    @State var isVeg : Bool = false
    @State var isNonVeg : Bool = false
    
    var body: some View {
        NavigationView{
            VStack
            {
                HStack(alignment:.center){
                Button(action: {
                    dishes = allDishes
                }, label: {
                    Text("Show All Dishes")
                        .font(.system(size: 15, weight: .bold))
                        .foregroundColor(.white)
                        .frame(width: 100, height: 50)
                        .background(.gray)
                        .cornerRadius(10.0)
                })
                    
                    Button(action: {
                        dishes = allDishes.filter{($0.tag).elementsEqual("veg")}
                    }, label: {
                        Text("Veg Dishes")
                            .font(.system(size: 15, weight: .bold))
                            .foregroundColor(.white)
                            .frame(width: 100, height: 50)
                            .background(.green)
                            .cornerRadius(10.0)
                    })
                    
                    Button(action: {
                        dishes = allDishes.filter{($0.tag).elementsEqual("non veg")}
                    }, label: {
                        Text("Non-Veg Dishes")
                            .font(.system(size: 15, weight: .bold))
                            .foregroundColor(.white)
                            .frame(width: 100, height: 50)
                            .background(.red)
                            .cornerRadius(10.0)
                    })
            }
            
            VStack{
                List(dishes){ item in
                    NavigationLink(destination: {
                        DishDetailsScreen(dishId: item.id)
                    }, label: {
                        HStack(spacing: 20){
                            AsyncImage(
                                url: URL(string: item.image),
                                content: { image in
                                    image.resizable()
                                },
                                placeholder: {
                                    ProgressView()
                                }
                            )
                            .aspectRatio(contentMode: .fit)
                            .frame(minWidth: 80, maxWidth: 80, minHeight: 80, maxHeight: 80)
                            .padding(.horizontal)
                            VStack(alignment: .leading, spacing: 10){
                                Text(item.dishName)
                                    .fontWeight(.bold)
                                HStack{
                                    Text("price :")
                                    Text(item.price)
                                        .fontWeight(.regular)
                                        .lineLimit(/*@START_MENU_TOKEN@*/2/*@END_MENU_TOKEN@*/)
                                }
                            }
                        }
                    })
                    .listStyle(GroupedListStyle())
                }
            }
        }
            .navigationTitle("Dishes")
        }.task {
            await getDishes()
            print(dishes)
        }
        
    }
    
    //to get all dish list from API
    func getDishes() async{
        guard let url = URL(string: "http://172.20.10.5:8080/api/v1/dishes/get") else{
            print("unable to get dishes")
            return
        }
        do{
            let (data, _) = try await URLSession.shared.data(from: url)
            let decodedData = try JSONDecoder().decode(DishListResponse.self, from: data)
            guard let payload = decodedData.payload else {
                return
            }
            allDishes = payload
            dishes = payload
        }
        catch{
            print(error.localizedDescription)
        }
    }
}

#Preview {
    DishListScreen()
}
