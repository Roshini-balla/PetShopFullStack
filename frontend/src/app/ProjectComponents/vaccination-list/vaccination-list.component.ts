import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { VaccinationService } from 'src/app/ProjectServices/vaccination.service';
import { Vaccinations } from 'src/app/model/Vaccinations';

@Component({
  selector: 'app-vaccination-list',
  templateUrl: './vaccination-list.component.html',
  styleUrls: ['./vaccination-list.component.css']
})

export class VaccinationListComponent {
  vaccinations: Vaccinations[];
  constructor(private vaccinationService: VaccinationService, private router: Router) { }

  ngOnInit(): void {
    this.getVaccinations();
  }
  
  private getVaccinations() {
    this.vaccinationService.getVaccinationList().subscribe(data => {
      this.vaccinations = data;
    });
  }
  updateVaccination(vaccinationId: number) {
    this.router.navigate(['update-vaccination', vaccinationId]);
  }
  deleteVaccination(vaccinationId: number) {
    this.vaccinationService.deleteVaccination(vaccinationId).subscribe(data => {
      console.log(data);
      this.getVaccinations();
    });
  }

 
}