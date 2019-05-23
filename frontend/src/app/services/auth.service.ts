import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, tap} from "rxjs/operators";
import {of} from "rxjs/internal/observable/of";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  currentUser;

  constructor(private http: HttpClient) { }

  loginUser(userName: string, password: string) {
    let loginInfo={username:userName, password:password};
    let options={headers: new HttpHeaders({'Content-Type':'application/json'})};

    return this.http.post('http://localhost:8081/api/v1/login', loginInfo, options)
    .pipe(tap(data => {
      this.currentUser=data;
    }))
      .pipe(catchError(err => {
        return of(false)
      }))
  }

  isAuthenticated() {
    return !!this.currentUser;
  }

  checkAuthenticationStatus() {
    this.http.get('http://localhost:8081/api/v1/currentIdentity')
      .pipe(tap(data => {
        if (data instanceof Object) {
          this.currentUser = data;
        }
      }))
      .subscribe();
  }

  logout() {
    let options={headers: new HttpHeaders({'Content-Type':'application/json'})};
    this.http.post('http://localhost:8081/api/v1/logout', {}, options)
      .subscribe(response => console.log("Logged user: "+response));
  }
}
