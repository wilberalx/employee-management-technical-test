import { AfterViewInit, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { AgGridModule } from 'ag-grid-angular';
import { ColDef, GridApi } from 'ag-grid-community';
import { SalesOrderHeaderSummary } from '../../core/models/sales/sales-order-header-summary';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoadingService } from '../../core/services/shared/loading.service';
import { SaleOrderHeaderService } from '../../core/services/sales/sale-order-header.service';
import { SnackbarService } from '../../core/services/shared/snackbar.service';
import dayjs from 'dayjs';


@Component({
  selector: 'app-sales-report',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    AgGridModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  templateUrl: './sales-report.component.html'
})
export class SalesReportComponent {

  private gridApi!: GridApi;
  routeEmployeeId: string | null = null;

  columnDefs: ColDef<SalesOrderHeaderSummary>[] = [
    {
      field: 'orderDate',
      headerName: 'Order date',
      width: 150,
      cellClass: params => params.node.rowPinned ? 'bg-gray-100 font-bold' : '',
      valueFormatter: params => {
        if (!params.value) return '';
        return dayjs(params.value).format('MM/DD/YYYY hh:mm A');
      }
    },
    { field: 'statusDescription', headerName: 'Status', width: 125 },
    { field: 'accountNumber', headerName: 'Account #', width: 175 },
    { field: 'address', headerName: 'Bill to Address', width: 200 },
    {
      field: 'subTotal',
      headerName: 'Subtotal',
      width: 150,
      cellClass: params => params.node.rowPinned ? 'bg-gray-100 font-bold text-right' : 'text-right',
      valueFormatter: params => {
        if (params.value == null) return '';
        return new Intl.NumberFormat('en-US', { style: 'decimal', minimumFractionDigits: 2, maximumFractionDigits: 2 }).format(params.value);
      }
    },
    {
      field: 'taxAmt',
      headerName: 'Tax',
      width: 150,
      cellClass: params => params.node.rowPinned ? 'bg-gray-100 font-bold text-right' : 'text-right',
      valueFormatter: params => {
        if (params.value == null) return '';
        return new Intl.NumberFormat('en-US', { style: 'decimal', minimumFractionDigits: 2, maximumFractionDigits: 2 }).format(params.value);
      }
    },
    {
      field: 'freight',
      headerName: 'Freight cost',
      width: 150,
      cellClass: params => params.node.rowPinned ? 'bg-gray-100 font-bold text-right' : 'text-right',
      valueFormatter: params => {
        if (params.value == null) return '';
        return new Intl.NumberFormat('en-US', { style: 'decimal', minimumFractionDigits: 2, maximumFractionDigits: 2 }).format(params.value);
      }
    },
    {
      field: 'totalDue',
      headerName: 'Total',
      width: 150,
      cellClass: params => params.node.rowPinned ? 'bg-gray-100 font-bold text-right' : 'text-right',
      valueFormatter: params => {
        if (params.value == null) return '';
        return new Intl.NumberFormat('en-US', { style: 'decimal', minimumFractionDigits: 2, maximumFractionDigits: 2 }).format(params.value);
      }
    }
  ];

  rowData: SalesOrderHeaderSummary[] = [];
  totalRowData: any[] = [];
  defaultColDef = {
    resizable: true,
    sortable: true,
    filter: true,
  };

  form: FormGroup = new FormGroup({
    startDate: new FormControl(null, [Validators.required]),
    endDate: new FormControl(null, [Validators.required]),
    employeId: new FormControl(null, [Validators.required, Validators.min(1)])
  });


  totalSales: number = 0;
  averageSalesPerDay: number = 0;
  employeeName: string | null = null;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly saleOrderHeaderService: SaleOrderHeaderService,
    private readonly loadingService: LoadingService,
    private readonly snackbar: SnackbarService,
    private readonly router: Router
  ) {

  }

  onSearch(): void {
    this.employeeName = null;
    this.totalSales = 0;
    this.averageSalesPerDay = 0;

    this.loadingService.show();
    this.gridApi.showLoadingOverlay();
    this.form.disable();

    const filterData: any = {
      loadLastSales: !this.form.value.startDate
    }
    if (!filterData.loadLastSales) {
      filterData.startDate = this.form.value.startDate;
      filterData.endDate = this.form.value.endDate;
    }

    this.saleOrderHeaderService.getByFilters(
      this.form.value.employeId,
      filterData
    ).subscribe({
      next: (sales) => {
        this.rowData = sales;
        if (sales.length === 0) {
          this.gridApi.showNoRowsOverlay();
          this.snackbar.show('No sales found');
        } else {
          this.gridApi.hideOverlay();
          this.processSalesData();
        }
        this.form.enable();
        this.loadingService.hide();
      },
      error: () => {
        this.snackbar.show('An unexpected error occurred', true);
        this.gridApi.showNoRowsOverlay();
        this.form.enable();
        this.loadingService.hide();
      }
    });
  }

  processSalesData(): void {
    this.employeeName = this.rowData[0].empployeeFullName || 'Unknown';
    this.totalSales = this.rowData.reduce((sum, sale) => sum + (sale.totalDue || 0), 0);
    this.averageSalesPerDay = this.getAverageSalesPerDay(this.totalSales);
    this.totalRowData = this.getTotalRowData();
  }

  getAverageSalesPerDay(totalSales: number): number {
    let startDate = this.form.value.startDate ? new Date(this.form.value.startDate) : this.getFirstDayOfMonth(this.rowData[0].orderDate);
    let endDate = this.form.value.endDate ? new Date(this.form.value.endDate) : this.getLastDayOfMonth(this.rowData[0].orderDate);
    this.form.controls['startDate'].setValue(this.toStartOfDay(startDate));
    this.form.controls['endDate'].setValue(this.toStartOfDay(endDate));

    const days = endDate.getDate() - startDate.getDate() + 1;

    if (days <= 0) {
      return 0;
    }

    return totalSales / days;
  }

  getFirstDayOfMonth(dateStr: any): Date {
    const date = new Date(dateStr);
    return new Date(date.getFullYear(), date.getMonth(), 1);
  }

  getLastDayOfMonth(dateStr: any): Date {
    const date = new Date(dateStr);
    return new Date(date.getFullYear(), date.getMonth() + 1, 0);
  }

  toStartOfDay(date: Date): Date {
    return new Date(date.getFullYear(), date.getMonth(), date.getDate());
  }

  getTotalRowData(): any[] {
    const totals: any = {};
    const data = this.rowData as any[];

    this.columnDefs.forEach(col => {
      const field = col.field;
      if (!field) return;

      const sampleValue = data[0]?.[field];

      if (typeof sampleValue === 'number') {
        totals[field] = data.reduce((sum, row) => sum + (row[field] || 0), 0);
      } else if (field === 'orderDate') {
        totals[field] = 'Total';
      } else {
        totals[field] = '';
      }
    });

    return [totals];
  }

  onGridReady(params: any) {
    this.gridApi = params.api;
    this.routeEmployeeId = this.route.snapshot.paramMap.get('id');
    this.form.controls['employeId'].setValue(this.routeEmployeeId);
    if (this.routeEmployeeId) {
      this.onSearch();
    }
  }

  backToAdmin() {
    this.router.navigate(['/employee-admin']);
  }
}
