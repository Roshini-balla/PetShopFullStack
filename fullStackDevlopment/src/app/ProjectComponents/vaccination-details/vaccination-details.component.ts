import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VaccinationService } from 'src/app/ProjectServices/vaccination.service';
import { Vaccinations } from 'src/app/model/Vaccinations';

@Component({
  selector: 'app-vaccination-details',
  templateUrl: './vaccination-details.component.html',
  styleUrls: ['./vaccination-details.component.css']
})
export class VaccinationDetailsComponent {
  vaccinationId: number;
  vaccination: Vaccinations;

  constructor(private route: ActivatedRoute, private vaccinationService: VaccinationService) { }

  ngOnInit(): void {
    this.vaccinationId = this.route.snapshot.params['vaccinationId'];
    this.vaccinationService.getVaccinationById(this.vaccinationId).subscribe(data => {
      this.vaccination = data;
    }, error => console.log(error));
  }
}
