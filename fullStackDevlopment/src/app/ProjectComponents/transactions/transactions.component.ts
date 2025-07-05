import { Component, OnInit } from '@angular/core';
import { Transactions } from 'src/app/model/transactions.model';
import { TransactionService } from 'src/app/ProjectServices/transaction.service';


@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  transactions: Transactions[] = [];
  newTransaction: Transactions = {
    transactionId: 0,
    customer: null,
    pet: null,
    transactionDate: new Date(),
    amount: 0,
    transactionStatus: 'Success'
  };

  constructor(private transactionService: TransactionService) { }

  ngOnInit(): void {
    this.getAllTransactions();
  }

  getAllTransactions(): void {
    this.transactionService.getAllTransactions().subscribe(
      (data) => {
        this.transactions = data;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  addTransaction(): void {
    this.transactionService.addTransaction(this.newTransaction).subscribe(
      (data) => {
        this.transactions.push(data);
        this.newTransaction = {
          transactionId: 0,
          customer: null,
          pet: null,
          transactionDate: new Date(),
          amount: 0,
          transactionStatus: 'Success'
        };
      },
      (error) => {
        console.error(error);
      }
    );
  }

  deleteTransaction(transactionId: number): void {
    this.transactionService.deleteTransaction(transactionId).subscribe(
      (data) => {
        this.transactions = this.transactions.filter(t => t.transactionId !== transactionId);
      },
      (error) => {
        console.error(error);
      }
    );
  }
}
