import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {CartService} from "../../services/cart.service";
import {OrderService} from "../../services/order.service";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  payment;
  delivery;
  orderInvalid=false;

  constructor(private router: Router,
              private cartService:CartService,
              private orderService:OrderService) { }

  ngOnInit() {
  }

    makeOrder(formValues) {
      if (this.cartService.isCartValid()) {
        this.orderService.makeOrder(formValues.payment, formValues.delivery)
          .subscribe(response => {
            if (!response) {
              this.orderInvalid = true;
            } else {
              this.router.navigate(['clientOrders']);
            }
          });
      } else {
        this.orderInvalid=true;
        console.log("Order invalid, cart is empty");
      }

    }

  cancel() {
    this.router.navigate(['cart']);
  }
}
