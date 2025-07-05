import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer.model';
import { CustomerService } from 'src/app/ProjectServices/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent {
  customer: Customer = new Customer(0, '', '', '', '', '', '', '', '');

  constructor(private customerService: CustomerService, private router: Router) { }

  onSubmit(): void {
    this.customerService.addCustomer(this.customer).subscribe(
      () => {
        this.router.navigate(['/customers']);
      },
      (error) => console.log(error)
    );
  }
}
