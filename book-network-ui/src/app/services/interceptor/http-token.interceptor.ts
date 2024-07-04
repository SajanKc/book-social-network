import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {TokenService} from "../token/token.service";

@Injectable()
export class HttpTokenInterceptor implements HttpInterceptor {

  constructor(
    private tokenService: TokenService
  ) {
  }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token: string = this.tokenService.token;
    if (token) {
      const authRequest = request.clone({
        headers: new HttpHeaders({
          'Authorization': `Bearer ${token}`
        })
      });
      return next.handle(authRequest);
    }
    return next.handle(request);
  }
}
