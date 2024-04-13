import { Component, OnInit } from '@angular/core';
import { ImgApiService } from './img-api.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{
peUser?:string
img:string | ArrayBuffer | null = null;


constructor(private srcv:ImgApiService) {}
 
ngOnInit(): void {
  if (localStorage.getItem('username')) {
    console.log(localStorage.getItem('username'));
    this.srcv.chama().subscribe((resp:Blob) => {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.img = e.target?.result as string | ArrayBuffer | null;
      }
      reader.readAsDataURL(resp);
    });
    this.peUser = localStorage.getItem('username') as string;
    localStorage.removeItem('username');
  }  
}

logout():void{
  this.srcv.logout();
  localStorage.setItem('token','');
  localStorage.setItem('username','');
  localStorage.setItem('id','');

}
}
