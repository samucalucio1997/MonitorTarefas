import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiLoginService } from './api-login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  login:FormGroup<any>;
   
   constructor(private fr:FormBuilder, private api:ApiLoginService) {
    this.login = this.fr.group({
      nome:["",Validators.required],
      senha:["",Validators.required]
    })
   }

   Submeter():void{
      const username = this.login.get('nome')?.value;
      const senha = this.login.get('senha')?.value;
      this.api.fazerLogin(username,senha);
   }
}
