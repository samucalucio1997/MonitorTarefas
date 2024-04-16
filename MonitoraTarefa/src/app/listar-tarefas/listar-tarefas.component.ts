import { Component, OnInit } from '@angular/core';
import { ListarApiService } from './listar-api.service';
import { taskResponseDTO } from '../criar-tarefa/tarefa-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-tarefas',
  templateUrl: './listar-tarefas.component.html',
  styleUrl: './listar-tarefas.component.css'
})
export class ListarTarefasComponent implements OnInit{
  lista:any[]=[]

  constructor(private srv:ListarApiService,private rout:Router) {}
  
  ngOnInit(): void {
    this.ApiChamaLista();
  }
  ApiChamaLista():void{
    this.lista = this.srv.carregar();
    console.log(this.lista);
  }

  remover(titulo: string):void{
     this.srv.delete(titulo);
     this.rout.navigate(['/listar-tarefas']);
  }
  
  editar(tarefa:string):void{
     localStorage.setItem('titulo-tarefa',tarefa);
     this.rout.navigate(['/editar-tarefa']);
  }

  concluir(tarefa:string):void{
      this.srv.concluir(tarefa);
  }

}
