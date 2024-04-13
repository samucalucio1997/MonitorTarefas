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
  headers = new HttpHeaders({
    'Authorization':`${localStorage.getItem('token')}`
  })
  constructor(private srv:HttpClient) { }
  
  carregarResp(): Observable<any>{
     return this.srv.get(this.url, { headers: this.headers });
  }

  SalvarTarefa(taskResponseDTO: taskResponseDTO):void{
      this.srv.post(this.url,taskResponseDTO,{headers:this.headers});
  }
}
