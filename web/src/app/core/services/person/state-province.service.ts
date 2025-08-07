import { Injectable } from "@angular/core";
import { environment } from "../../../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { StateProvince } from "../../models/person/state-province";

@Injectable({
  providedIn: 'root'
})
export class StateProvinceService {

  constructor(private http: HttpClient) { }

  getByCountry(countryCode: String): Observable<StateProvince[]> {
    const apiUrl = `${environment.apiUrl}/country/${countryCode}/state-province`;
    return this.http.get<StateProvince[]>(`${apiUrl}`);
  }

}
