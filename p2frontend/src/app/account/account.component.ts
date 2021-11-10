import { Component, OnInit } from '@angular/core';
import { Account } from '../account';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  
  accounts : Account [] = [];

  constructor(public accountService:AccountService) { }

  ngOnInit(): void {
    this.getAccounts();
    console.log("I'm inside OnInit of Account Component");
  }
  getAccounts(): void {
    this.accountService.getAccounts()
    .subscribe(accounts => this.accounts = accounts);
  }

}
