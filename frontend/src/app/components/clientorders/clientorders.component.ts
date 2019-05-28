import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../services/order.service";


@Component({
  selector: 'app-clientorders',
  templateUrl: './clientorders.component.html',
  styleUrls: ['./clientorders.component.css']
})
export class ClientordersComponent implements OnInit {
  orders;

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.getOrders();
  }

  getOrders() {
    this.orderService.getOrders().subscribe(
      data => this.orders = data,
      err => console.log(err),
      () => console.log('orders loaded')
    );
  }

  areThereAnyOrders() {
      if (this.orders === undefined) {
        return false;
      }
      if (this.orders.length == 0) {
        return false;
      }
      return true;
    }
}
