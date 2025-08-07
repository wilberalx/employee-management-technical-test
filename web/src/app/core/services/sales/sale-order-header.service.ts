import { Injectable } from "@angular/core";
import { environment } from "../../../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { SalesOrderHeaderSummary } from "../../models/sales/sales-order-header-summary";

@Injectable({
  providedIn: 'root'
})
export class SaleOrderHeaderService {

  private apiUrl = `${environment.apiUrl}/sales-order-header`;

  constructor(private http: HttpClient) { }

  getByFilters(salesPersonId: number, filterData: any): Observable<SalesOrderHeaderSummary[]> {
    return this.http.post<SalesOrderHeaderSummary[]>(`${this.apiUrl}/sales-person/${salesPersonId}`, filterData);
  }

}
