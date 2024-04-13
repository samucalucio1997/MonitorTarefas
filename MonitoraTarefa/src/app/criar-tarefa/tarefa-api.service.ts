import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface taskResponseDTO {
  titulo:string;
  descricao:string;
  prioridade:string;
  data:string;
  nome:string;
}


@Injectable({
  providedIn: 'root'
})
export class TarefaApiService {


  
  url = "http://localhost:8080/usuario/listarUsers";
  urlCadTaf = "http://localhost:8080/task/cadastrarTarefa"
  headers = new HttpHeaders({
    'Authorization':`${localStorage.getItem('token')}`,
    'Content-Type':'application/json'
  })
  constructor(private srv:HttpClient) { }
  
  carregarResp(): Observable<any>{
     return this.srv.get(this.url, { headers: this.headers });
  }

 async SalvarTarefa(taskResponseDTO: any):Promise<void>{
      const json = JSON.stringify(taskResponseDTO);
      console.log(json);
      this.srv.post(this.urlCadTaf, json, { headers: this.headers }).subscribe(
        (resp:any)=>{
          console.log(resp['Tarefa']['titulo']);
        }
      );
  }
}
