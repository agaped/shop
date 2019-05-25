import { Component, OnInit } from '@angular/core';
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {

  cart;

  constructor(public cartService: CartService) { }

  ngOnInit() {
    this.loadCart();
  }

  private loadCart() {
    this.cartService.loadCart();
    this.cart=this.cartService.items;
    console.log("Cart component loaded");
  }

  getTotal() {
    let total = 0;
    for(let i = 0; i < this.cart.length; i++){
      let product = this.cart[i];
      total += (product.item.price * product.quantity);
    }
    return total;
  }
}
