// src/app/services/address.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Address } from '../components/address.model';


@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private baseUrl = 'http://localhost:8080/api/v1/address';

  constructor(private http: HttpClient) { }

  getAllAddresses(): Observable<Address[]> {
    return this.http.get<Address[]>(this.baseUrl);
  }

  getAddressById(addressId: number): Observable<Address> {
    return this.http.get<Address>(`${this.baseUrl}/${addressId}`);
  }

  addAddress(address: Address): Observable<Address> {
    return this.http.post<Address>(`${this.baseUrl}/add`, address);
  }

  updateAddress(addressId: number, address: Address): Observable<Address> {
    return this.http.put<Address>(`${this.baseUrl}/update/${addressId}`, address);
  }

  deleteAddress(addressId: number): Observable<Address> {
    return this.http.delete<Address>(`${this.baseUrl}/delete/${addressId}`);
  }
}
