import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Pet } from 'src/app/model/pet.model';
import { PetService } from 'src/app/ProjectServices/pet.service';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent {

  pet: Pet = new Pet(0, '', '', 0, 0, '');

  constructor(private petService: PetService, private router: Router) { }

  addPet(): void {
    this.petService.addPet(this.pet).subscribe(() => {
      this.router.navigate(['/pets']);
    }, error => {
      console.error('Error adding pet', error);
    });
  }
}