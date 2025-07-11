import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/model/customer.model';
import { CustomerService } from 'src/app/ProjectServices/customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent {
  customer: Customer = new Customer(0, '', '', '', '', '', '', '', '');
  customerId: number;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private customerService: CustomerService
  ) {}

  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['customerId'];
    this.customerService.getCustomerById(this.customerId).subscribe(
      (data) => {
        this.customer = data;
      },
      (error) => console.log(error)
    );
  }

  onSubmit(): void {
    this.customerService.updateCustomer(this.customerId, this.customer).subscribe(
      () => {
        this.router.navigate(['/customers']);
      },
      (error) => console.log(error)
    );
  
  }
}