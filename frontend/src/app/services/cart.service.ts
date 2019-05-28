import {Injectable} from '@angular/core';
import {IProduct} from "../models/product.model";
import {ICartItem} from "../models/cartItem.model";
import {Router} from "@angular/router";


@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cart;
  public items;

  constructor(private router: Router) {}

  public loadCart() {
    this.items=[];
    this.cart = JSON.parse(localStorage.getItem('cart'));
    if(this.cart==null){
      this.items=[];
    }else {
      for (let i = 0; i < this.cart.length ; i++) {
        let item : ICartItem = JSON.parse(this.cart[i]);
        this.items.push({
          item: item.item,
          quantity: item.quantity
        });
      }
    }
  }

  addToCart(product: IProduct) {
    var item: ICartItem={
      item: product,
      quantity: 1
    };
    if (localStorage.getItem("cart") == null) {
      this.cart = [];
      this.saveToCart(item);
      this.saveToLocalStorage();
    } else {
      this.cart = JSON.parse(localStorage.getItem("cart"));
      let index: number = -1;
      for (let i = 0; i < this.cart.length; i++) {
        let item: ICartItem = JSON.parse(this.cart[i]);
        if (item.item.id == product.id) {
          index=i;
          break;
        }
      }
      if (index == -1) {
        this.saveToCart(item);
        this.saveToLocalStorage();
      } else {
        let item : ICartItem= JSON.parse(this.cart[index]);
        item.quantity++;
        this.cart[index] = JSON.stringify(item);
        this.saveToLocalStorage();
      }
    }
    this.loadCart();
    console.log("Added to cart: " + product.name);
    this.router.navigate(['cart']);
    }

  private saveToCart(item: ICartItem) {
    this.cart.push(JSON.stringify(item));
  }

  private saveToLocalStorage() {
    localStorage.setItem('cart', JSON.stringify(this.cart));
  }

  removeFromCart(product: any) {
    this.cart = JSON.parse(localStorage.getItem("cart"));
    let index: number = -1;
    for (let i = 0; i < this.cart.length; i++) {
      let item: ICartItem = JSON.parse(this.cart[i]);
      if (item.item.id == product.item.id) {
        index=i;
        break;
      }
  }
    let item: ICartItem = JSON.parse(this.cart[index]);
    if (item.quantity === 1) {
      this.cart.splice(index, 1);
    } else {
      item.quantity--;
      this.cart[index] = JSON.stringify(item);
    }
    this.saveToLocalStorage();
    this.loadCart();
    console.log("Removed from cart: " + product.item.name);
    }


  deleteCart() {
    localStorage.removeItem("cart");
    this.loadCart();
  }

  isCartValid() {
    this.loadCart();
    return this.items.length != 0;
  }

  getTotal() {
    this.loadCart();
    let total=0;
    for (let item of this.items) {
      total += item.item.price * item.quantity;
    }
    return total;
  }
}
