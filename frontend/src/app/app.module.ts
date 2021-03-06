import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductService} from "./services/product.service";
import { CategoryService} from "./services/category.service";
import { HomeComponent } from './components/home/home.component';
import { ProductComponent } from './components/product/product.component';
import {FormsModule} from "@angular/forms";
import { BasketComponent } from './components/basket/basket.component';
import { LoginComponent } from './components/login/login.component';
import {AuthService} from "./services/auth.service";
import { OrderComponent } from './components/order/order.component';
import { AuthGuardService} from "./services/auth-guard.service";
import {OrderService} from "./services/order.service";
import { ClientordersComponent } from './components/clientorders/clientorders.component';
import { NotfoundComponent } from './components/notfound/notfound.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductComponent,
    BasketComponent,
    LoginComponent,
    OrderComponent,
    ClientordersComponent,
    NotfoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [ProductService, CategoryService, AuthService, AuthGuardService, OrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
