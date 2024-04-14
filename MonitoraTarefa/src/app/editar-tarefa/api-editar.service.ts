import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { taskResponseDTO } from '../criar-tarefa/tarefa-api.service';

@Injectable({
  providedIn: 'root'
})
export class ApiEditarService {
  url = "http://localhost:8080/task/tarefax"
  urlCons = "http://localhost:8080/usuario/listarUsers"
  urlcad = "http://localhost:8080/task/atualizar"
  header = new HttpHeaders({
    'Authorization':`${localStorage.getItem('token')}`,
    'Content-Type':'application/json'
  });

  
  constructor(private http:HttpClient) { }

  carregarListaUser():Observable<any>{
    return this.http.get(this.urlCons,{headers:this.header});
  }

  consulta(tarefa:string):Observable<any>{
    return this.http.get(this.url+`?titulo=${tarefa}`,{headers:this.header});
  }
  
  editar(body:taskResponseDTO|any){
    const jsonbo = JSON.stringify(body);
    this.http.patch(this.urlcad+`?titulo=${localStorage.getItem('titulo-tarefa')}`,jsonbo,{headers:this.header}).subscribe(
      (resp:any)=>{console.log(resp)}
    )
    localStorage.setItem('tarefa-titulo','');
  }
}
