import { Component, OnInit } from '@angular/core';
import { ListarApiService } from './listar-api.service';

@Component({
  selector: 'app-listar-tarefas',
  templateUrl: './listar-tarefas.component.html',
  styleUrl: './listar-tarefas.component.css'
})
export class ListarTarefasComponent implements OnInit{
  lista:any[]=[]

  constructor(private srv:ListarApiService) {}
  
  ngOnInit(): void {
    this.ApiChamaLista();
  }
  ApiChamaLista():void{
    this.lista = this.srv.carregar();
    console.log(this.lista);
  }

  remover(titulo: string):void{
     this.srv.delete(titulo);
  }
  

}
