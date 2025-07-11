package com.pets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_food")
public class PetFood {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "food_id")
	    private int foodId;

	    @Column(name = "name", nullable = false, length = 255)
	    private String name;

	    @Column(name = "brand", length = 100)
	    private String brand;

	    @Column(name = "type", length = 50)
	    private String type;

	    @Column(name = "quantity")
	    private Integer quantity;

	    @Column(name = "price")
	    private Double price;
	    

		public int getFoodId() {
			return foodId;
		}


		public void setFoodId(int foodId) {
			this.foodId = foodId;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getBrand() {
			return brand;
		}


		public void setBrand(String brand) {
			this.brand = brand;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public Integer getQuantity() {
			return quantity;
		}


		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}


		public Double getPrice() {
			return price;
		}


		public void setPrice(Double price) {
			this.price = price;
		}


		public PetFood (int foodId, String name, String brand, String type, Integer quantity, Double price) {
			
			this.foodId = foodId;
			this.name = name;
			this.brand = brand;
			this.type = type;
			this.quantity = quantity;
			this.price = price;
		}

		public PetFood (String name, String brand, String type, Integer quantity, Double price) {
			
			this.name = name;
			this.brand = brand;
			this.type = type;
			this.quantity = quantity;
			this.price = price;
		}
		
		public PetFood()
		{
			super();
		}


		@Override
		public String toString() {
			return "pet_food [foodId=" + foodId + ", name=" + name + ", brand=" + brand + ", type=" + type
					+ ", quantity=" + quantity + ", price=" + price + "]";
		}
	    

}
