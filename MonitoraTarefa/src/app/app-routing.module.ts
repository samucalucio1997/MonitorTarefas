import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { CriarTarefaComponent } from './criar-tarefa/criar-tarefa.component';
import { ListarTarefasComponent } from './listar-tarefas/listar-tarefas.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"Header",component:HeaderComponent},
  {path:"criar-tarefa",component:CriarTarefaComponent},
  {path:"listar-tarefas",component:ListarTarefasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
