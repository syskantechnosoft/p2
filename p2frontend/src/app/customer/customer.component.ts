import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customers: Customer[] = [];

  email !: string;
  customer !: Customer;

  constructor(public customerService: CustomerService, private actRoute: ActivatedRoute) {
    this.email = this.actRoute.snapshot.params.email;
  }

  ngOnInit(): void {
    if (this.email == null)
      this.getCustomers();
    else
      this.getCustomer(this.email)
    console.log("I'm inside OnInit of Customer Component");
  }
  getCustomers(): void {
    this.customerService.getCustomers()
      .subscribe(customers => this.customers = customers);
  }

  getCustomer(email: string): void {
    this.customerService.getCustomer(email)
      .subscribe(customer => {this.customer = customer;console.log("test :" + email)});
  }
}
