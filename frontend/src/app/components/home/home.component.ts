import {Component, OnChanges, OnInit} from '@angular/core';
import {ProductService} from "../../services/product.service";
import {CategoryService} from "../../services/category.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  public products;
  public categories;
  public visibleProducts;
  private _nameSearch : String;
  private _producerSearch : String;

  constructor(private productService: ProductService,
              private categoryService: CategoryService) { }


  get nameSearch(): String {
    return this._nameSearch;
  }

  set nameSearch(value: String) {
    this._nameSearch = value;
    this.visibleProducts = this.filterProductsByName(value);
  }


  get producerSearch(): String {
    return this._producerSearch;
  }

  set producerSearch(value: String) {
    this._producerSearch = value;
    this.visibleProducts = this.filterProductsByProducer(value);
  }

  ngOnInit() {
    this.getProducts();
    this.getCategories();
    this.visibleProducts = this.products;
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

  filterProductsByName(searchString: String) {
    return this.products.filter(product =>
      product.name.toLowerCase().indexOf(searchString.toLowerCase()) !==-1);
  }

  filterProductsByProducer(searchString: String) {
    return this.products.filter(product =>
      product.producer.toLowerCase().indexOf(searchString.toLowerCase()) !==-1);
  }

  filterByCategory(searchString : String) {
    this.visibleProducts = this.products.filter(product =>
      product.category.toLowerCase().indexOf(searchString.toLowerCase()) !==-1);
  }
}
