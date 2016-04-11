import {Component} from 'angular2/core';
import {Product} from './product'

@Component({
	selector: 'my-app',
	template: `
  <h1>{{title}}</h1>
  <h2>My favorite hero is: {{myProduct.name}}</h2>
  <p>Heroes:</p>
  <ul>
    <li *ngFor="#product of products">
      {{ product.name }}
      </li>
  </ul>
  <p *ngIf="products.length > 3">There are many products!</p>
`
})

export class AppComponent {
	title = 'List of products';
    products = [
		new Product(1, 'Windstorm','desc','img','img','img'),
		new Product(13, 'Bombasto','desc','img','img','img'),
		new Product(15, 'Magneta','desc','img','img','img'),
		new Product(20, 'Tornado','desc','img','img','img')
	];
	myProduct = this.products[0];
}