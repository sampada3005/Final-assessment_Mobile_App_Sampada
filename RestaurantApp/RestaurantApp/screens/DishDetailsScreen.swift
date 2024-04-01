//
//  DishDetailsScreen.swift
//  RestaurantApp
//
//  Created by Sampada Deshmukh on 01/04/24.
//

import SwiftUI

struct DishDetailsScreen: View {
    
    var dishId : Int
    
    @State var dishDetails: Dish = Dish()
    
    var body: some View {
        VStack(alignment: .leading){
                AsyncImage(
                    url: URL(string: dishDetails.image),
                    content: { image in
                        image.resizable()
                    },
                    placeholder: {
                        ProgressView()
                    }
                )
                .aspectRatio(contentMode: .fit)
                .frame(minWidth: 300, maxWidth: 300, minHeight: 200, maxHeight: 200)
                .padding(.horizontal)
               
        
            
                HStack{
                    Text("Name :")
                    Text(dishDetails.dishName )
                        .fontWeight(/*@START_MENU_TOKEN@*/.bold/*@END_MENU_TOKEN@*/)
                }
                
                HStack{
                    Text("Ingredients :")
                    Text(dishDetails.ingredients )
                        .fontWeight(.bold)
                        .padding(20)
                }
    
                HStack{
                    Text("Price :")
                    Text(dishDetails.price )
                        .fontWeight(.bold)
                        .padding(20)
                }
                                
                HStack{
                    Text("Prep Minutes :")
                    Text(dishDetails.prepMinutes )
                        .fontWeight(.bold)
                        .padding(20)
                }
               
                HStack{
                    Text("tag :")
                    Text(dishDetails.tag)
                        .fontWeight(.bold)
                        .padding(20)
                }
            Spacer()
            }
            .navigationTitle("Details")
        .task {
           await getDishDetails()
           print(dishDetails)
        }
    }
    
    //to get all dish details from API
    func getDishDetails() async{
        
            guard let url = URL(string: "http://172.20.10.5:8080/api/v1/dishes/get/\(dishId)") else{
                print("unable to get product")
                return
            }
            
            do{
                let (data, _) = try await URLSession.shared.data(from: url)
                let decodedData = try JSONDecoder().decode(DishResponse.self, from: data)
                guard let payload = decodedData.payload else {
                    return
                }
                dishDetails = payload
            }
            catch{
                print(error.localizedDescription)
            }
   }
}


