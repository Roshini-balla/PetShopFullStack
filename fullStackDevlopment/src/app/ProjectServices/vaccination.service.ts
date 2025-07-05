import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vaccinations } from '../model/Vaccinations';

@Injectable({
  providedIn: 'root'
})
export class VaccinationService {

  private baseUrl = 'http://localhost:8080/api/v1/vaccinations';
 constructor(private http: HttpClient) { }

  getVaccinationList(): Observable<Vaccinations[]> {
    return this.http.get<Vaccinations[]>(`${this.baseUrl}`);
  }

  getVaccinationById(vaccinationId: number): Observable<Vaccinations> {
    return this.http.get<Vaccinations>(`${this.baseUrl}/${vaccinationId}`);
  }

  addVaccination(vaccination: Vaccinations): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add`, vaccination);
  }

  updateVaccination(vaccinationId: number, vaccination: Vaccinations): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${vaccinationId}`, vaccination);
  }

  deleteVaccination(vaccinationId: number): Observable<Object> {
    return this.http.delete(`${this.baseUrl}/delete/${vaccinationId}`);
  }
}