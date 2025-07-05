import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pet } from 'src/app/model/pet.model';
import { PetService } from 'src/app/ProjectServices/pet.service';

@Component({
  selector: 'app-pet-details',
  templateUrl: './pet-details.component.html',
  styleUrls: ['./pet-details.component.css']
})
export class PetDetailsComponent {

  petId: number;
  pet:Pet;

  constructor(private route: ActivatedRoute, private petService: PetService) { }

  ngOnInit(): void {
    this.petId = this.route.snapshot.params['petId'];
    this.petService.getPetById(this.petId).subscribe(data => {
    this.pet= data;
    }, error => console.log(error));
  }
}