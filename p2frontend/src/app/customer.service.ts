import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Customer } from "./customer";

import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private baseUrl = "http://localhost:8090";

  constructor(private http: HttpClient) { }

  private log(message: string) {
    console.log(`CustomerService: ${message}`);
  }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl + "/customers")
      .pipe(
        tap(_ => this.log('fetched customers')),
        catchError(this.handleError<Customer[]>('getCustomers', []))
      );
  }

  getCustomer(email:string):Observable<Customer> {
    const fullUrl = this.baseUrl + "/customerByEmail/"+email;
    console.log("full Url =" + fullUrl)
    return this.http.get<Customer>(fullUrl)
      .pipe(
        tap(_ => this.log('fetched a customer')),
        catchError(this.handleError<Customer>('getCustomerByEmail'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
