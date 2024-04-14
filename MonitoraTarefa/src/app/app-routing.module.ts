import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { CriarTarefaComponent } from './criar-tarefa/criar-tarefa.component';
import { ListarTarefasComponent } from './listar-tarefas/listar-tarefas.component';
import { EditarTarefaComponent } from './editar-tarefa/editar-tarefa.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"Header",component:HeaderComponent},
  {path:"criar-tarefa",component:CriarTarefaComponent},
  {path:"listar-tarefas",component:ListarTarefasComponent},
  {path:"editar-tarefa",component:EditarTarefaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
