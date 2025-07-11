import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Address } from 'src/app/model/address.model';

import { AddressService } from 'src/app/ProjectServices/address.service';

@Component({
  selector: 'app-update-address',
  templateUrl: './update-address.component.html',
  styleUrls: ['./update-address.component.css']
})
export class UpdateAddressComponent implements OnInit{
  
  address: Address = { addressId: 0, street: '', city: '', state: '', zipCode: '' };

  constructor(
    private addressService: AddressService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const addressId = +this.route.snapshot.paramMap.get('addressId')!;
    this.addressService.getAddressById(addressId).subscribe(data => {
      this.address = data;
    });
  }

  updateAddress(): void {
    this.addressService.updateAddress(this.address.addressId, this.address).subscribe(() => {
      this.router.navigate(['/addresses']);
    });
  }
}