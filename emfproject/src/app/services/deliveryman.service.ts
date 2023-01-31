import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Deliveryman } from '../model/deliveryman';

const baseUrl:string="http://localhost:8085/deliveryman";

@Injectable({
  providedIn: 'root'
})
export class DeliverymanService {

  constructor(private http: HttpClient) {  }

  getAllHero(): Observable<any> {
    return this.http.get(baseUrl+"/getall");
  
  }

  createHero(hero: Deliveryman): Observable<any>{
    return this.http.post<any>(baseUrl+"/savehero", Deliveryman);
  }

  deleteHero(heroId: any): Observable<any>{
    return this.http.delete<any>(baseUrl+"/delete/"+heroId)
  }

  updateHero(heroId: number, deliveryman:Deliveryman): Observable <any>{
    return this.http.put<any> (baseUrl+"/edit/"+deliveryman.heroId, deliveryman)
  }

  
  getHeroById(heroId:number): Observable<any>{
    return this.http.get(baseUrl+heroId);
  }

}
