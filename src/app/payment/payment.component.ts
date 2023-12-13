import { Component, OnInit } from '@angular/core';


declare var Razorpay:any;

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
  
})
export class PaymentComponent  {
 /*submit=false;
  customer:Customer=new Customer();

 firstname: string=this.customer.firstname;

  email:string="";
  
 
  constructor(private userService:UserServiceService,
    private router:Router){}
  ngOnInit(): void 
  {

  }
OnSubmit()
{  
  if(this.password1==this.password2)
  {
  console.log(this.user);
  this.user.userPassword=this.password1;
  this.email=this.user.userEmail;
  this.data.changeMessage(this.email);
  console.log(this.email);
  this.userService.addUser(this.user).subscribe(data=>
    {
      console.log(data);
       alert("Register Successfull");
       this.goToProfile();
    },
    (error:any)=>{
      alert("Email Id  is Alredy Exists");
      console.log(error)
    });
  }
  }
 /* id!:number;
  constructor(private router:Router){}
  upi()
  {
    this.router.navigate(['/upi',this.id]);
  }
  cod(){
this.router.navigate(['cod',this.id]);
  }*/

}
