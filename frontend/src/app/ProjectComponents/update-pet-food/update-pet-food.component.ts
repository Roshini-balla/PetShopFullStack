import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PetFood } from 'src/app/model/PetFood';
import { PetFoodService } from 'src/app/ProjectServices/pet-food.service';


@Component({
  selector: 'app-update-pet-food',
  templateUrl: './update-pet-food.component.html',
  styleUrls: ['./update-pet-food.component.css']
})
export class UpdatePetFoodComponent implements OnInit {
  foodId: number;
  petFood: PetFood = new PetFood();

  constructor(private petFoodService: PetFoodService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.foodId = this.route.snapshot.params['foodId'];
    this.petFoodService.getPetFoodById(this.foodId).subscribe(data => {
      this.petFood = data;
    }, error => console.log(error));
  }

  updatePetFood() {
    this.petFoodService.updatePetFood(this.foodId, this.petFood).subscribe(data => {
      console.log(data);
      this.goToPetFoodList();
    }, error => console.log(error));
  }

  goToPetFoodList() {
    this.router.navigate(['/pet-foods']);
  }

  onSubmit() {
    this.updatePetFood();
  }
}
