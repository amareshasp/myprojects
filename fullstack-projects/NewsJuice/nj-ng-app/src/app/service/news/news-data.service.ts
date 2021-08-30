import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NewsDataService {

  private NEWS_DATA_URL = 'assets/newsdata.json';

  constructor(private httpClient: HttpClient) { }


  public getNews() {

    return this.httpClient.get(this.NEWS_DATA_URL);
  }


}
