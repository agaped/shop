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

  mouseoverRegister;
  registerInvalid=false;
  loginInfo=false;
  name;
  surname;
  email;
  pass;

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

  registerUser(formValues) {
    this.authService.registerUser(formValues.email,formValues.name, formValues.surname,formValues.pass)
      .subscribe( response => {
        if(!response){
          this.registerInvalid=true;
          console.log("registerUser(),if, response: "+response);
        }else{
          this.router.navigate(['login']);
          this.loginInfo=true;
          console.log("registerUser(), else, response: "+response);
        }
      })
  }
}
