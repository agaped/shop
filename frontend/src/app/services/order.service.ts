import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {catchError, tap} from "rxjs/operators";
import {of} from "rxjs/internal/observable/of";
import {CartService} from "./cart.service";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient,
              private authService: AuthService,
              private cartService: CartService) { }

  orderId;
  test;

  makeOrder(payment: String, delivery: String) {
    let orderInfo={payment:payment, status:'nowe', delivery:delivery, total:this.cartService.getTotal(), userId:this.authService.currentUser.id};
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

  saveCart(orderId) {
    let cartInfo={cartItems:this.cartService.items, orderId:orderId};
    let options={headers: new HttpHeaders({'Content-Type':'application/json'})};

    return this.http.post('http://localhost:8081/api/v1/order/cart', cartInfo, options)
      .pipe(tap(data => {
        console.log("Cart info sent");
      }))
      .pipe(catchError(err => {
        return of(false)
      }))
  }

  getOrders() {
    return this.http.get('http://localhost:8081/api/v1/order/'+this.authService.currentUser.id)
  }
}
