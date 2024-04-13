import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiLoginService } from './api-login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  @Output() token = localStorage.getItem('token')!=null?localStorage.getItem('token'):null
  login:FormGroup<any>;
$: any;
   
   constructor(private fr:FormBuilder, private api:ApiLoginService,private rout:Router) {
    this.login = this.fr.group({
      nome:["",Validators.required],
      senha:["",Validators.required]
    })
   }

   Submeter():void{
      const username = this.login.get('nome')?.value;
      const senha = this.login.get('senha')?.value;
      this.api.fazerLogin(username,senha);
      this.rout.navigate(['listar-tarefas']);  
   }
}
