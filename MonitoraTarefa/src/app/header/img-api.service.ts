import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImgApiService {
  urlIn:string = 'http://localhost:8080/Usuario/image';
  urlOut:string = 'http://localhost:8080/home/logout';
  
  constructor(private api:HttpClient) {}
  
  headers = new HttpHeaders({
    'Authorization':String(localStorage.getItem('token'))
  });

  id = localStorage.getItem('id');
  chama():any{
    if (this.id!=null) {
      const form:FormData = new  FormData();
      form.append('id',String(this.id));
      return this.api.post(this.urlIn, form,{
        headers: this.headers,
        responseType: 'blob'
      });     
    }else{
      return null;
    }
  }
  
  logout():void{
      this.api.get(this.urlOut);
      // localStorage.setItem('id',null);
      // localStorage.setItem()
  }
}
