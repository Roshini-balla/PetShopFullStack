import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { GroomingService } from 'src/app/model/grooming-service.model';
import { GroomingServicesService } from 'src/app/ProjectServices/grooming-services.service';


@Component({
  selector: 'app-add-grooming-service',
  templateUrl: './add-grooming-service.component.html',
  styleUrls: ['./add-grooming-service.component.css']
})
export class AddGroomingServiceComponent {
  groomingService: GroomingService = {
    serviceId: 0,
    name: '',
    description: '',
    price: 0,
    available: 0
  };

  constructor(private groomingServicesService: GroomingServicesService, private router: Router) { }

  addGroomingService(): void {
    this.groomingServicesService.addGroomingService(this.groomingService).subscribe(() => {
      this.router.navigate(['/grooming-services']);
    });
  }
}
