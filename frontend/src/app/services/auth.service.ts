import { Injectable } from '@angular/core';
import {IUser} from "../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  currentUser : IUser;

  constructor() { }

  loginUser(userName: string, password: string) {
    this.currentUser={
      id: 1,
      email: userName,
      name: 'John',
      surname: 'Papa'
    }
  }

  isAuthenticated() {
    return !!this.currentUser;
  }
}
