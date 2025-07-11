import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../model/customer.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8080/api/v1/customers';

  constructor(private http: HttpClient) { }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.baseUrl}`);
  }

  getCustomerById(customerId: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.baseUrl}/${customerId}`);
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${this.baseUrl}/add`, customer);
  }

  updateCustomer(customerId: number, customer: Customer): Observable<object> {
    return this.http.put(`${this.baseUrl}/update/${customerId}`, customer);
  }

  deleteCustomer(customerId: number): Observable<Customer> {
    return this.http.delete<Customer>(`${this.baseUrl}/delete/${customerId}`);
  }
}