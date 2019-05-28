import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clientorders',
  templateUrl: './clientorders.component.html',
  styleUrls: ['./clientorders.component.css']
})
export class ClientordersComponent implements OnInit {
  orders;

  constructor() { }

  ngOnInit() {
  }

  areThereAnyOrders() {
    return false;
  }
}
