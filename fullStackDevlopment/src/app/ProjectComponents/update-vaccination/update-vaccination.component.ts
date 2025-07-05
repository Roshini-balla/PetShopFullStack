import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { VaccinationService } from 'src/app/ProjectServices/vaccination.service';
import { Vaccinations } from 'src/app/model/Vaccinations';

@Component({
  selector: 'app-update-vaccination',
  templateUrl: './update-vaccination.component.html',
  styleUrls: ['./update-vaccination.component.css']
})
export class UpdateVaccinationComponent {
  vaccinationId: number;
  vaccination: Vaccinations = new Vaccinations();
 constructor(private route: ActivatedRoute, private vaccinationService: VaccinationService, private router: Router,private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.vaccinationId = this.route.snapshot.params['vaccinationId'];
    this.vaccinationService.getVaccinationById(this.vaccinationId).subscribe(data => {
      this.vaccination = data;
    }, error => console.log(error));}

  onSubmit() {
    this.vaccinationService.updateVaccination(this.vaccinationId, this.vaccination).subscribe(data => {
      this.showSuccessMessage();
      this.goToVaccinationList();
    }, error => console.log(error));
  }

  showSuccessMessage() {
    this.snackBar.open('Vaccination updated successfully', 'Close', {
      duration: 3000
    });
  }
  goToVaccinationList() {
    this.router.navigate(['/vaccinations']);
  }
}