import { Injectable } from "@angular/core";
import { environment } from "../../../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { CountryRegion } from "../../models/person/country-region";


@Injectable({
  providedIn: 'root'
})
export class CountryRegionService {

  private apiUrl = `${environment.apiUrl}/country-region`;

  constructor(private http: HttpClient) { }

  getAll(): Observable<CountryRegion[]> {
    return this.http.get<CountryRegion[]>(`${this.apiUrl}`);
  }

}
