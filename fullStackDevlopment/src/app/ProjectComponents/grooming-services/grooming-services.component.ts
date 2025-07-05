import { Component } from '@angular/core';
import { GroomingService } from 'src/app/model/grooming-service.model';
import { GroomingServicesService } from 'src/app/ProjectServices/grooming-services.service';

@Component({
  selector: 'app-grooming-services',
  templateUrl: './grooming-services.component.html',
  styleUrls: ['./grooming-services.component.css']
})
export class GroomingServicesComponent {

  groomingServices: GroomingService[] = [];

  constructor(private groomingServicesService: GroomingServicesService) { }

  ngOnInit(): void {
    this.groomingServicesService.getAllGroomingServices().subscribe(data => {
      this.groomingServices = data;
    });
  }

  deleteGroomingService(serviceId: number): void {
    this.groomingServicesService.deleteGroomingService(serviceId).subscribe(() => {
      this.groomingServices = this.groomingServices.filter(service => service.serviceId !== serviceId);
    });
  }
}