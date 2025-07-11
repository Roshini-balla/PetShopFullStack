import { Component } from '@angular/core';
import { Customer } from 'src/app/model/customer.model';
import { CustomerService } from 'src/app/ProjectServices/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {
  customers: Customer[];


  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers():void {
    this.customerService.getCustomers().subscribe(data => {
      this.customers = data;
    });
  }

  deleteCustomer(customerId: number) {
    this.customerService.deleteCustomer(customerId).subscribe(()=> {
      this.getCustomers();
    });
  }

  

  
}