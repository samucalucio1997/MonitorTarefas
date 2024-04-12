import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ListarApiService {
  url:string = "http://localhost:8080/task/listar";
  urldelete:string = "http://localhost:8080/task/removerTarefa";
  header = new HttpHeaders({
     'Authorization':`${localStorage.getItem('token')}`
  })
  
  constructor(private http:HttpClient) { }
  lista = []



  carregar():Array<any>{
   this.http.get(this.url,{headers:this.header}).subscribe((resp:any) => {
     this.lista = resp;
   })
   return this.lista;
  }

  async delete(titulo: string): Promise<string | void> {
    const response:any = await this.http.delete(`${this.urldelete}?titulo=${titulo}`, { headers: this.header }).toPromise();
  
    if (response.status === 200) {
      return `tarefa ${response.nome}`; // Assuming 'nome' is a property in the response object
    } else {
      // Handle error scenario (e.g., log error, return error message)
      console.error('Erro ao excluir tarefa:', response.status);
      return undefined; // Or return an appropriate error message
    }
  }

}
