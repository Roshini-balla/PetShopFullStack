import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pet } from 'src/app/model/pet.model';
import { PetService } from 'src/app/ProjectServices/pet.service';

@Component({
  selector: 'app-update-pet',
  templateUrl: './update-pet.component.html',
  styleUrls: ['./update-pet.component.css']
})
export class UpdatePetComponent implements OnInit {
  id: number;
  pet: Pet;

  constructor(
    private petService: PetService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.pet = new Pet(0,'','',0,0,'');
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.petService.getPetById(this.id).subscribe(data => {
      this.pet = data;
    });
  }

  onSubmit(): void {
    this.petService.updatePet(this.id, this.pet).subscribe(() => {
      this.router.navigate(['/pets']);
    });
  }
}
