import { Injectable } from "@angular/core";
import { environment } from "../../../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Department } from "../../models/human-resources/department";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private apiUrl = `${environment.apiUrl}/department`;

  constructor(private http: HttpClient) { }

  getAll(): Observable<Department[]> {
    return this.http.get<Department[]>(`${this.apiUrl}`);
  }

}
