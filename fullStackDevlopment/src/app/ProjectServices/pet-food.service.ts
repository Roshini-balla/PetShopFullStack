import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PetFood } from '../model/PetFood';


@Injectable({
  providedIn: 'root'
})
export class PetFoodService {
  private baseURL = "http://localhost:8080/api/v1/pet_foods";

  constructor(private httpClient: HttpClient) { }

  getPetFoodsList(): Observable<PetFood[]> {
    return this.httpClient.get<PetFood[]>(`${this.baseURL}`);
  }

  addPetFood(petFood: PetFood): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}/add`, petFood);
  }

  getPetFoodById(id: number): Observable<PetFood> {
    return this.httpClient.get<PetFood>(`${this.baseURL}/${id}`);
  }

  updatePetFood(id: number, petFood: PetFood): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/update/${id}`, petFood);
  }

  deletePetFood(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/delete/${id}`);
  }
}
