import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor() { }

  makeOrder(payment: String, delivery: String) {
    console.log(" Order Service: make order");
  }
}
