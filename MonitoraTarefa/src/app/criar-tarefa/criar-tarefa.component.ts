import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TarefaApiService, taskResponseDTO } from './tarefa-api.service';
import { Observable } from 'rxjs';

interface ResponsavelDTO {
  id:string;
  nome:string;
}

@Component({
  selector: 'app-criar-tarefa',
  templateUrl: './criar-tarefa.component.html',
  styleUrl: './criar-tarefa.component.css'
})
export class CriarTarefaComponent implements OnInit{
 frm:FormGroup;
 lista_responsavel?:ResponsavelDTO[];
 task!:taskResponseDTO;
 
 constructor(private form:FormBuilder,private tarsr:TarefaApiService) {
  this.frm = form.group({
       titulo:['', Validators.required],
       descricao:['',Validators.required],
       prioridade:['',Validators.required],
       responsavel:['',Validators.required],
       data: [Date.now(), Validators.required]

  })
 }
  
 
ngOnInit(): void {
  this.tarsr.carregarResp().subscribe(
    (responsaveis: ResponsavelDTO[]) => {
       this.lista_responsavel =responsaveis
    }
  );     
}
  
Salvar(){
  if (this.frm.valid) { // Verifique se o formulário é válido
    this.task.titulo = this.frm.get('titulo')?.value;
    this.task.descricao = this.frm.get('descricao')?.value;
    this.task.prioridade = this.frm.get('prioridade')?.value;
    this.task.data = this.frm.get('data')?.value;
    this.tarsr.SalvarTarefa(this.task);
  }
} 

}
