import { Injectable } from "@angular/core";
import { environment } from "../../../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Shift } from "../../models/human-resources/shift";

@Injectable({
  providedIn: 'root'
})
export class ShiftService {

  private apiUrl = `${environment.apiUrl}/shift`;

  constructor(private http: HttpClient) { }

  getAll(): Observable<Shift[]> {
    return this.http.get<Shift[]>(`${this.apiUrl}`);
  }

}
