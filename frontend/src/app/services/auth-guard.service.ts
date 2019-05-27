import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private router: Router,
              private authService: AuthService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    this.authService.checkAuthenticationStatus();
    if (this.authService.isAuthenticated()) {
      console.log("Guard says authorized to access the page");
      return true;
    } else {
      this.router.navigate(['login']);
      console.log("Guard says not authorized to access the page");
      return false;
    }
  }
}
