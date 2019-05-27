import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {ProductComponent} from "./components/product/product.component";
import {BasketComponent} from "./components/basket/basket.component";
import {LoginComponent} from "./components/login/login.component";
import {OrderComponent} from "./components/order/order.component";
import {AuthGuardService} from "./services/auth-guard.service";

const routes: Routes = [
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'product/:id', component: ProductComponent
  },
  {
    path: 'cart', component: BasketComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'order', component: OrderComponent, canActivate:[AuthGuardService]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
