import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { AddproductComponent } from './components/addproduct/addproduct.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductComponent } from './components/product/product.component';
import { UpdateproductComponent } from './components/updateproduct/updateproduct.component';
import { ProductdetailsComponent } from './components/productdetails/productdetails.component';
import { CartPageComponent } from 'src/app/cart-page/cart-page.component';

const routes: Routes = [
  {path:'',component:AdminDashboardComponent,
  children:[
   
   {path:'productdetails/:id',component:ProductdetailsComponent},
   {path:'add',component:AddproductComponent},
   {path:'productlist',component:ProductListComponent},
   {path:'products',component:ProductComponent},
   {path:'updateproduct/:id',component:UpdateproductComponent},
   {path:'cart',component:CartPageComponent}
  // {path:'',redirectTo:'add',pathMatch:'full'},
  ],  
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
