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
      localStorage.setItem('currentUser', JSON.stringify(this.currentUser));
      console.log("User logged in " +this.currentUser.email);
    }))
      .pipe(catchError(err => {
        return of(false)
      }))
  }

  isAuthenticated() {
    return !!this.currentUser;
  }

  checkAuthenticationStatus() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  logout() {
    let options={headers: new HttpHeaders({'Content-Type':'application/json'})};
    this.http.post('http://localhost:8081/api/v1/logout', {}, options)
      .subscribe(response => console.log("User logged out"));
    localStorage.removeItem('currentUser');
  }

  registerUser(email: string, name: string, surname: string, pass: string) {
    let registerInfo={email:email, name:name, surname:surname, password:pass, role: 'client'};
    let options={headers: new HttpHeaders({'Content-Type':'application/json'})};

    return this.http.post('http://localhost:8081/api/v1/register', registerInfo, options)
      .pipe(catchError(err => {
        return of(false)
      }))
  }
}
