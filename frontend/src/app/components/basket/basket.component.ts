import {Component, OnInit} from '@angular/core';
import {CartService} from "../../services/cart.service";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {

  cart;

  constructor(public cartService: CartService,
              public authService: AuthService) { }

  ngOnInit() {
    this.loadCart();
  }

  private loadCart() {
    this.cartService.loadCart();
    this.cart=this.cartService.items;
  }

  getTotal() {
    let total = 0;
    for(let i = 0; i < this.cart.length; i++){
      let product = this.cart[i];
      total += (product.item.price * product.quantity);
    }
    return total;
  }

  addToCart(product) {
    this.cartService.addToCart(product.item);
    this.loadCart();
  }

  removeFromCart(product : any) {
    this.cartService.removeFromCart(product);
    this.loadCart()
  }

  isCartValid() {
    if (this.cart === undefined) {
      return false;
    }
    if (this.cart.length == 0) {
      return false;
    }
    return true;
  }
}
