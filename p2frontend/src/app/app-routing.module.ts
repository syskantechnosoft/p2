import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './account/account.component';
import { CustomerComponent } from './customer/customer.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path:"customers",component:CustomerComponent},
  {path:"customers/:email",component:CustomerComponent},
  {path:"accounts",component:AccountComponent},
  {path:"", component : LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
