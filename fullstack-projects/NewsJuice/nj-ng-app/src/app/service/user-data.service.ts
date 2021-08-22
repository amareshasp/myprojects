import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { UserModel } from '../model/user.model';
@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  _userEmail: string = "";


  private USER_MICRO_SERVICE_GET_BY_MAIL = "http://localhost:9000/user/get-by-mail";
  private USER_MICRO_SERVICE_SAVE_USER = "http://localhost:9000/user/save";

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


  public set userEmail(email: string) {
    this._userEmail = email;
  }
  public get userEmail() {
    return this._userEmail;
  }
}
