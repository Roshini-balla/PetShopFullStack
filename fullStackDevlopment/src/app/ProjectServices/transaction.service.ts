import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transactions } from '../model/transactions.model';


@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private baseUrl = 'http://localhost:8080/api/v1/transactions';

  constructor(private http: HttpClient) { }

  getAllTransactions(): Observable<Transactions[]> {
    return this.http.get<Transactions[]>(`${this.baseUrl}`);
  }

  getTransactionById(transactionId: number): Observable<Transactions> {
    return this.http.get<Transactions>(`${this.baseUrl}/${transactionId}`);
  }

  getFailedTransactions(): Observable<Transactions[]> {
    return this.http.get<Transactions[]>(`${this.baseUrl}/failed`);
  }

  getSuccessfulTransactions(): Observable<Transactions[]> {
    return this.http.get<Transactions[]>(`${this.baseUrl}/successful`);
  }

  addTransaction(transaction: Transactions): Observable<Transactions> {
    return this.http.post<Transactions>(`${this.baseUrl}/add`, transaction);
  }

  deleteTransaction(transactionId: number): Observable<Transactions> {
    return this.http.delete<Transactions>(`${this.baseUrl}/delete/${transactionId}`);
  }
}
