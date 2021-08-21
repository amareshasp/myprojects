import { Injectable } from '@angular/core';
import { HttpClient,HttpParams  } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  _userEmail :string ="";

  private USER_MICRO_SERVICE = "http://localhost:9000/user/get-by-mail";

  constructor(private httpClient: HttpClient) { }

  public sendGetRequest(){
     let params = new HttpParams();
    params = params.append('userEmail', this._userEmail);

    return this.httpClient.get(this.USER_MICRO_SERVICE,{params: params});
  }

  public set userEmail(email:string){
    this._userEmail = email;
  }
  public get userEmail(){
    return this._userEmail;
  }
}
