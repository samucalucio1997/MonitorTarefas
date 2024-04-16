import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiEditarService } from './api-editar.service';

import { TarefaApiService,taskResponseDTO } from '../criar-tarefa/tarefa-api.service';
import { Observable } from 'rxjs';
import { Route, Router } from '@angular/router';

interface ResponsavelDTO {
  id:string;
  nome:string;
}

@Component({
  selector: 'app-editar-tarefa',
  templateUrl: './editar-tarefa.component.html',
  styleUrl: './editar-tarefa.component.css'
})
export class EditarTarefaComponent implements OnInit{
frm?:FormGroup<any>;
lista_responsavel?:ResponsavelDTO[];
sucesso?:boolean;

tarefa:Observable<taskResponseDTO> = this.srvc.consulta(localStorage.getItem('titulo-tarefa') as string);

constructor(private srvc:ApiEditarService,private form:FormBuilder, private rota:Router) {

  this.tarefa.subscribe(res => {
    this.frm = this.form.group({
      titulo: [res.titulo],
      descricao: [res.descricao],
      prioridade: [res.prioridade],
      concluido:[res.concluido],
      responsavel: [res.responsavel],
      data: [res.data]
    });
  });
  this.sucesso = this.frm?.get('concluido')?.value;
}
ngOnInit(): void {
  this.srvc.carregarListaUser().subscribe(
    (resp: ResponsavelDTO[]) => {
      this.lista_responsavel =resp;
    }
  ); 
  }

  editar():void{
      const body:taskResponseDTO = {
        titulo: this.frm?.get('titulo')?.value,
        descricao: this.frm?.get('descricao')?.value,
        prioridade: this.frm?.get('prioridade')?.value,
        data: this.frm?.get('data')?.value,
        concluido: this.frm?.get('concluido')?.value,
        responsavel: this.frm?.get('responsavel')?.value
      }
      this.srvc.editar(body);
      this.rota.navigate(['listar-tarefas']);
  }
}
