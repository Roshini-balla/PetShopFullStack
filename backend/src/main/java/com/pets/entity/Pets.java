package com.pets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pets")
public class Pets {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "pet_id")
	    private int petId;

	    @Column(name = "name", nullable = false, length = 255)
	    private String name;

	    @Column(name = "breed", nullable = false, length = 50)
	    private String breed;

	    @Column(name = "age")
	    private int age;

	    @Column(name = "price", precision = 10, scale = 2,columnDefinition = "Decimal")
	    private int price;

		public int getPetId() {
			return petId;
		}

		public void setPetId(int petId) {
			this.petId = petId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBreed() {
			return breed;
		}

		public void setBreed(String breed) {
			this.breed = breed;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		
		 @Column(name = "description", columnDefinition = "TEXT")
	        private String description;

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}
		public Pets(int petId, String name, String breed, int age, int price,String description) {
			super();
			this.petId = petId;
			this.name = name;
			this.breed = breed;
			this.age = age;
			this.price = price;
			this.description = description;
		}

		public Pets()
		{
			
			
		}

		@Override
		public String toString() {
			return "pets [petId=" + petId + ", name=" + name + ", breed=" + breed + ", age=" + age + ", price=" + price
					+ ", description=" + description + "]";
		}

		
		


	   

		
	    


}
