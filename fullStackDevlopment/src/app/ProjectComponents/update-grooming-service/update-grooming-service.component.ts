import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GroomingService } from 'src/app/model/grooming-service.model';
import { GroomingServicesService } from 'src/app/ProjectServices/grooming-services.service';


@Component({
  selector: 'app-update-grooming-service',
  templateUrl: './update-grooming-service.component.html',
  styleUrls: ['./update-grooming-service.component.css']
})
export class UpdateGroomingServiceComponent implements OnInit {
  groomingService: GroomingService = {
    serviceId: 0,
    name: '',
    description: '',
    price: 0,
    available: 0
  };

  constructor(
    private groomingServicesService: GroomingServicesService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const serviceId = +this.route.snapshot.paramMap.get('service_id');
    if (serviceId) {
      this.groomingServicesService.getGroomingServiceById(serviceId).subscribe(service => {
        this.groomingService = service;
      });
    }
  }

  updateGroomingService(): void {
    this.groomingServicesService.updateGroomingService(this.groomingService.serviceId, this.groomingService).subscribe(() => {
      this.router.navigate(['/grooming-services']);
    }, error => {
      console.error('Error updating grooming service', error);
    });
  }
}
