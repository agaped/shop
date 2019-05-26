import { Component } from '@angular/core';
import {AuthService} from "./services/auth.service";
import {CartService} from "./services/cart.service";
import {Router} from "@angular/router";
import {Location} from "@angular/common"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

  constructor(public authService:AuthService,
              public cartService:CartService,
              private router:Router,
              private location:Location) {
  }

  ngOnInit() {
    this.authService.checkAuthenticationStatus();
  }

  logout() {
    this.authService.currentUser = undefined;
    this.authService.logout();
    this.cartService.deleteCart();
    this.refreshPage();
  }

  private refreshPage() {
    let currentPath=this.location.path();
    this.router.navigateByUrl('/home', {skipLocationChange: true}).then(()=>
      this.router.navigate([currentPath]));
  }
}
