import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string = '';
  password: string = '';
  invalidLogin = false;
  customer!: Customer;

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {
  }

  checkLogin() {
    this.getCustomerByEmail(this.email);
  }

  getCustomerByEmail(email: string): void {
    this.loginService.getCustomer(email)
      .subscribe(customer => {
        this.customer = customer;
        console.log("this.customer in arrow function :" + this.customer.password);
        if (this.customer.email === this.email && this.customer.password === this.password) {
          this.router.navigate(['customers/'+this.email])
          this.invalidLogin = false;
        } else
          this.invalidLogin = true;

      });
    // console.log("this.customer =" + this.customer);
  }

}
