import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  private USER_MICRO_SERVICE = "http://localhost:9000/user/get";

  constructor(private httpClient: HttpClient) { }

  public sendGetRequest(){
    return this.httpClient.get(this.USER_MICRO_SERVICE);
  }
}
