import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PetFood } from 'src/app/model/PetFood';
import { PetFoodService } from 'src/app/ProjectServices/pet-food.service';

@Component({
  selector: 'app-add-pet-food',
  templateUrl: './add-pet-food.component.html',
  styleUrls: ['./add-pet-food.component.css']
})
export class AddPetFoodComponent implements OnInit {
  petFood: PetFood = new PetFood();

  constructor(private petFoodService: PetFoodService, private router: Router) { }

  ngOnInit(): void { }

  savePetFood() {
    this.petFoodService.addPetFood(this.petFood).subscribe(data => {
      console.log(data);
      this.goToPetFoodList();
    }, error => console.log(error));
  }

  goToPetFoodList() {
    this.router.navigate(['/pet-foods']);
  }

  onSubmit() {
    this.savePetFood();
  }
}
