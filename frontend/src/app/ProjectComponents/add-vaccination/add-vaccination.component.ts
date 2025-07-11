import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { VaccinationService } from 'src/app/ProjectServices/vaccination.service';
import { Vaccinations } from 'src/app/model/Vaccinations';

@Component({
  selector: 'app-add-vaccination',
  templateUrl: './add-vaccination.component.html',
  styleUrls: ['./add-vaccination.component.css']
})
export class AddVaccinationComponent {

  vaccination: Vaccinations = new Vaccinations();
 constructor(private vaccinationService: VaccinationService, private router: Router) { }
 ngOnInit(): void {}

  saveVaccination() {
    this.vaccinationService.addVaccination(this.vaccination).subscribe(data => {
      console.log(data);
      this.goToVaccinationList();
    }, error => console.log(error));
  }

  goToVaccinationList() {
    this.router.navigate(['/vaccinations']);
  }

  onSubmit() {
    this.saveVaccination();
  }
}
