import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { UserModel } from '../model/user.model';
import { BehaviorSubject } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  _userEmail: string = "";
  _userName: string = "";

  _isLoginSuccess = false;

  public isLogin = new BehaviorSubject<boolean>(false);
  cast = this.isLogin.asObservable();

  private baseUrl = environment.baseUrl;
  private USER_MICRO_SERVICE_GET_BY_MAIL = this.baseUrl + '/get-by-mail';
  private USER_MICRO_SERVICE_SAVE_USER = this.baseUrl + '/save';

  constructor(private httpClient: HttpClient) { }

  public sendGetRequest() {
    let params = new HttpParams();
    params = params.append('userEmail', this._userEmail);

    return this.httpClient.get(this.USER_MICRO_SERVICE_GET_BY_MAIL, { params: params });
  }



  public sendGetRequestByEmail(email: string) {
    let params = new HttpParams();
    params = params.append('userEmail', email);

    return this.httpClient.get(this.USER_MICRO_SERVICE_GET_BY_MAIL, { params: params });
  }


  public sendPostRequest(userData: UserModel) {
    return this.httpClient.post(this.USER_MICRO_SERVICE_SAVE_USER, userData);
  }


  public set isLoginSuccess(success: boolean) {
    this._isLoginSuccess = success;
  }
  public get isLoginSuccess() {
    return this._isLoginSuccess;
  }


  public set userEmail(email: string) {
    this._userEmail = email;
  }
  public get userEmail() {
    return this._userEmail;
  }

  public set userName(name: string) {
    this._userName = name;
  }
  public get userName() {
    return this._userName;
  }

  changeLogin(value: boolean) {
    this.isLogin.next(value);
  }

}
