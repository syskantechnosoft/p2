import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Account } from "./account";

import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private baseUrl = "http://localhost:8090";

  constructor(private http: HttpClient) { }

  private log(message: string) {
    console.log(`AccountService: ${message}`);
  }

  getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(this.baseUrl + "/accounts")
      .pipe(
        tap(_ => this.log('fetched accounts')),
        catchError(this.handleError<Account[]>('getAccounts', []))
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
