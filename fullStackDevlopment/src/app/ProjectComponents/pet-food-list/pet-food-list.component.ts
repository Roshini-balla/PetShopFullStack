import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PetFood } from 'src/app/model/PetFood';
import { PetFoodService } from 'src/app/ProjectServices/pet-food.service';

@Component({
  selector: 'app-pet-food-list',
  templateUrl: './pet-food-list.component.html',
  styleUrls: ['./pet-food-list.component.css']
})
export class PetFoodListComponent implements OnInit {
  petFoods: PetFood[];

  constructor(private petFoodService: PetFoodService, private router: Router) { }

  ngOnInit(): void {
    this.getPetFoods();
  }

  private getPetFoods() {
    this.petFoodService.getPetFoodsList().subscribe(data => {
      this.petFoods = data;
    });
  }

  updatePetFood(id: number) {
    this.router.navigate(['update-pet-food', id]);
  }

  deletePetFood(id: number) {
    this.petFoodService.deletePetFood(id).subscribe(() => {
      this.getPetFoods(); // Refresh the list after deletion
    });
  }
}
