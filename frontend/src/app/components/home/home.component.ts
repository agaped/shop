import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../services/product.service";
import {CategoryService} from "../../services/category.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public products;
  public categories;

  constructor(private productService: ProductService,
              private categoryService: CategoryService) { }

  ngOnInit() {
    this.getProducts();
    this.getCategories();
  }

  getProducts() {
    this.productService.getProducts().subscribe(
      data => this.products = data,
      err => console.log(err),
   () => console.log('products loaded')
    );
  }

  getCategories() {
    this.categoryService.getCategories().subscribe(
      data=> this.categories=data,
      err=> console.log(err),
      () => console.log('categories loaded')
    );
  }
}
