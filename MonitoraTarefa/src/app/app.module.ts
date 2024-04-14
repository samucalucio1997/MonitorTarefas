import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { CriarTarefaComponent } from './criar-tarefa/criar-tarefa.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ListarTarefasComponent } from './listar-tarefas/listar-tarefas.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule, DatePipe } from '@angular/common';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { EditarTarefaComponent } from './editar-tarefa/editar-tarefa.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    CriarTarefaComponent,
    ListarTarefasComponent,
    CadastrarUsuarioComponent,
    EditarTarefaComponent
  ],
  imports: [
    HttpClientModule,
    ReactiveFormsModule,
    BrowserModule,
    CommonModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
