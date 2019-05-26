import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../services/product.service";
import {CategoryService} from "../../services/category.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public categories;
  public product;

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private cartService: CartService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.getCategories();

    const param = this.route.snapshot.paramMap.get('id');
    if (param) {
      const id = +param;
      this.getProduct(id);
    }
  }

  getProduct(id : number) {
    this.productService.getProduct(id).subscribe(
      data => this.product=data,
     err=> console.log(err),
  () => console.log('product loaded')
    );
  }

  getCategories() {
    this.categoryService.getCategories().subscribe(
      data=> this.categories=data,
      err=> console.log(err),
      () => console.log('categories loaded')
    );
  }

  addToCart(product) {
    this.cartService.addToCart(product);
  }
}
