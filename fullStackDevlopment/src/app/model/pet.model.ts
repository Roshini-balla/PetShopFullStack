export class Pet {
  id: number;
  name: string;
  breed: string;
  age: number;
  price: number;
  description: string;

  constructor(id: number, name: string, breed: string, age: number, price: number, description: string) {
    this.id = id;
    this.name = name;
    this.breed = breed;
    this.age = age;
    this.price = price;
    this.description = description;
  }
}
