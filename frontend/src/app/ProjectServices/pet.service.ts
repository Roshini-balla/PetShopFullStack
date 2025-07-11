import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pet } from '../model/pet.model';


@Injectable({
  providedIn: 'root'
})
export class PetService {
  private baseURL = "http://localhost:8080/api/v1/pets";

  constructor(private httpClient: HttpClient) { }

  getPetsList(): Observable<Pet[]> {
    return this.httpClient.get<Pet[]>(`${this.baseURL}`);
  }

  addPet(pet: Pet): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}/add`, pet);
  }

  getPetById(id: number): Observable<Pet> {
    return this.httpClient.get<Pet>(`${this.baseURL}/pet/${id}`);
  }

  updatePet(id: number, pet: Pet): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/update/${id}`, pet);
  }

  deletePet(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/delete/${id}`);
  }
}
