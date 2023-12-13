import { Component } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';
import { Product } from 'src/app/modules/product';
import { Router } from '@angular/router';


@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent  {
 product:Product=new Product();
  constructor(private productService:ProductsService,private router:Router)
  {}
  ngOnInit(): void {
    
  }
  saveProduct()
  {
    this.productService['createProduct'](this.product).subscribe((data: any)=>
    {
      console.log(data);
      alert("Product added Successfully");
      this.goToProductList();
     
    },
    (error:any)=>console.log(error)
    );
  }
  goToProductList()
  {
    this.router.navigate(['/products']);
  }
  onSubmit()
  {
    console.log(this.product);
    this.saveProduct();
  }
 }

