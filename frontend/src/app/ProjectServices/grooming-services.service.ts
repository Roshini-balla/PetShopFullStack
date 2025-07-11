import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GroomingService } from '../model/grooming-service.model';


@Injectable({
  providedIn: 'root'
})
export class GroomingServicesService {
  private baseUrl = 'http://localhost:8080/api/v1/services';

  constructor(private http: HttpClient) { }

  getAllGroomingServices(): Observable<GroomingService[]> {
    return this.http.get<GroomingService[]>(this.baseUrl);
  }

  getGroomingServiceById(serviceId: number): Observable<GroomingService> {
    return this.http.get<GroomingService>(`${this.baseUrl}/${serviceId}`);
  }

  addGroomingService(service: GroomingService): Observable<GroomingService> {
    return this.http.post<GroomingService>(`${this.baseUrl}/add`, service);
  }

  updateGroomingService(serviceId: number, service: GroomingService): Observable<GroomingService> {
    return this.http.put<GroomingService>(`${this.baseUrl}/update/${serviceId}`, service);
  }

  deleteGroomingService(serviceId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${serviceId}`);
  }
}
