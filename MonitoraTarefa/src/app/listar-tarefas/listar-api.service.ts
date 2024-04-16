import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ListarApiService {
  url:string = "http://localhost:8080/task/listar";
  urldelete:string = "http://localhost:8080/task/removerTarefa";
  urlconcl:string = "http://localhost:8080/task/concluir"
  
  header = new HttpHeaders({
     'Authorization':`${localStorage.getItem('token')}`
  })
  
  constructor(private http:HttpClient) { }
  lista = []



  carregar():Array<any>{
    console.log(localStorage.getItem('token'));
   this.http.get(this.url,{headers:this.header}).subscribe((resp:any) => {
     this.lista = resp;
   })
   return this.lista;
  }

  delete(titulo: string): void {
    console.log(this.header);
    const response:any = this.http.delete(`${this.urldelete}?titulo=${titulo}`, { headers: this.header }).subscribe(
      (s:any) => {
        console.log(s);
      }
    );
  }

  concluir(titulo:string): void{
   console.log(this.header);
   const resp:any = this.http.post(this.urlconcl+`?titulo=${titulo}`,{ headers: this.header })
    .subscribe((r:any) => {console.log(r)});
  }

}
