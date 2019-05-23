import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName;
  password;
  mouseoverLogin;
  loginInvalid=false;

  constructor(private router:Router,
              private authService:AuthService) { }

  ngOnInit() {
  }

  login(formValues) {
    this.authService.loginUser(formValues.userName, formValues.password)
      .subscribe( response => {
      if(!response){
        this.loginInvalid=true;
      }else{
        this.router.navigate(['basket']);
      }
      })
  }

  cancel() {
    this.router.navigate(['home']);
  }
}
