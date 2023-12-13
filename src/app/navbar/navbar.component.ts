import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(private router:Router){}
  ShowNavbar():boolean{
    return !this.router.url.includes('login') && !this.router.url.includes('register') && !this.router.url.includes('admin') &&!this.router.url.includes('home1');
  }
}
