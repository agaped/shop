import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {catchError, tap} from "rxjs/operators";
import {of} from "rxjs/internal/observable/of";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient,
              private authService: AuthService) { }

  orderId;
  test;

  makeOrder(payment: String, delivery: String) {
    let orderInfo={payment:payment, status:'nowe', delivery:delivery, userId:this.authService.currentUser.id};
    let options={headers: new HttpHeaders({'Content-Type':'application/json'})};
    console.log(orderInfo);

    return this.http.post('http://localhost:8081/api/v1/order', orderInfo, options)
      .pipe(tap(data => {
        this.orderId=data;
        console.log("Order placed "+this.orderId);
      }))
      .pipe(catchError(err => {
        return of(false)
      }))
  }

}
