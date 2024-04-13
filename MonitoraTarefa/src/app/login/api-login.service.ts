import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ApiLoginService {
  url:string = "http://localhost:8080/usuario/login"
  
  headers:HttpHeaders = new HttpHeaders({
    'Content-Type':'application/json'
  });

  constructor(private rout:Router,private httpclient: HttpClient) {}

  fazerLogin(nome: string, senha:string):void{
    
    const login ={
      username: nome,
      password: senha
    }
    const body = JSON.stringify(login);
    this.httpclient.post(this.url,body,{headers:this.headers}).subscribe((resp:any) => {
      localStorage.setItem('username',resp['usuario']['nome']);
      localStorage.setItem('id',resp['usuario']['id']);
      localStorage.setItem('token',resp['token']);
      console.log(localStorage.getItem('token'))
      this.rout.navigate(['listar-tarefas']);     
    });
  }
}
