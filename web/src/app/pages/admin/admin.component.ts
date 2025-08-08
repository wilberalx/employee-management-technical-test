import { AfterViewInit, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgGridModule } from 'ag-grid-angular';
import { ColDef, GridApi } from 'ag-grid-community';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { EmployeeService } from '../../core/services/human-resources/employee.service';
import { Employee } from '../../core/models/human-resources/employee';
import { EditCellRendererComponent } from '../../components/edit-cell-renderer/edit-cell-renderer.component';
import { DeleteCellRendererComponent } from '../../components/delete-cell-renderer.component.html/delete-cell-renderer.component';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';
import { LoadingService } from '../../core/services/shared/loading.service';
import { SnackbarService } from '../../core/services/shared/snackbar.service';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogComponent } from '../../components/confirm-dialog/confirm-dialog.component';
import { ActionCellRendererComponent } from '../../components/action-cell-renderer/action-cell-renderer.component';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [CommonModule, AgGridModule,
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    AgGridModule,
    MatButtonModule
  ],
  templateUrl: './admin.component.html'
})
export class AdminComponent {

  private gridApi!: GridApi;

  columnDefs: ColDef<Employee>[] = [
    { field: 'fullName', headerName: 'Name', width: 250 },
    { field: 'jobTitle', headerName: 'Job Title', width: 250 },
    { field: 'departmentName', headerName: 'Department', width: 200 },
    { field: 'departmentStartDate', headerName: 'Start date', width: 125 },
    { field: 'birthDate', headerName: 'Birth Date', width: 125 },
    { field: 'phoneNumber', headerName: 'Phone', width: 150 },
    { field: 'emailAddress', headerName: 'Email', width: 200 },
    { field: 'fullAddress', headerName: 'Address', width: 300 },
    {
      headerName: 'Sales',
      pinned: 'right',
      width: 90,
      sortable: false,
      filter: false,
      suppressMovable: true,
      cellRenderer: ActionCellRendererComponent,
      cellRendererParams: {
        onAction: (data: any) => this.goToSalesReport(data),
      },
    },
    {
      headerName: 'Edit',
      pinned: 'right',
      width: 90,
      sortable: false,
      filter: false,
      suppressMovable: true,
      cellRenderer: EditCellRendererComponent,
      cellRendererParams: {
        onEdit: (data: any) => this.onEdit(data),
      },
    },
    {
      headerName: 'Delete',
      pinned: 'right',
      width: 90,
      sortable: false,
      filter: false,
      suppressMovable: true,
      cellRenderer: DeleteCellRendererComponent,
      cellRendererParams: {
        onDelete: (data: any) => this.onDelete(data),
      },
    },
  ];

  rowData: Employee[] = [];
  filteredData: Employee[] = [];
  defaultColDef = {
    resizable: true,
    sortable: true,
    filter: true,
  };

  searchText: string = '';

  constructor(
    private readonly employeeService: EmployeeService,
    private readonly router: Router,
    private readonly loadingService: LoadingService,
    private readonly snackbar: SnackbarService,
    private readonly dialog: MatDialog
  ) { }

  onSearch() {
    if (this.searchText.trim() === '') {
      this.filteredData = [...this.rowData];
      return;
    }
    const term = this.searchText.toLowerCase();
    this.filteredData = this.rowData.filter(
      item =>
        item.fullName?.toLowerCase().includes(term) ||
        item.departmentName?.toLowerCase().includes(term) ||
        item.jobTitle?.toLowerCase().includes(term)
    );
  }

  onEdit(employee: Employee) {
    this.router.navigate(['/employee-admin', employee.businessEntityId]);
  }

  goToSalesReport(employee: Employee) {
    this.router.navigate(['/sales-report', employee.businessEntityId]);
  }

  onDelete(employee: Employee) {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      data: {
        title: 'Delete Employee',
        message: `Are you sure you want to delete "${employee.fullName}"?`
      }
    });

    dialogRef.afterClosed().subscribe(confirmed => {
      if (confirmed) {
        this.deleteEmployee(employee);
      }
    });
  }

  deleteEmployee(employee: Employee) {
    this.loadingService.show();
    this.employeeService.delete(employee.businessEntityId!).subscribe({
      next: () => {
        this.snackbar.show('Employee deleted successfully');
        this.loadEmployees();
      },
      error: () => {
        this.snackbar.show('An error occurred while deleting the employee', true);
      },
      complete: () => {
        this.loadingService.hide();
      }
    });
  }

  onAdd() {
    this.router.navigate(['/employee-admin', 'new']);
  }

  loadEmployees() {
    this.loadingService.show();
    this.gridApi.showLoadingOverlay();
    this.employeeService.getAllActives().subscribe({
      next: (employees) => {
        this.rowData = employees;
        this.filteredData = [...this.rowData];
        if (employees.length === 0) {
          this.gridApi.showNoRowsOverlay();
        } else {
          this.gridApi.hideOverlay();
        }
      },
      error: (error) => {
        this.snackbar.show('An unexpected error occurred', true);
        this.gridApi.showNoRowsOverlay();
        this.loadingService.hide();
      },
      complete: () => {
        this.loadingService.hide();
      }
    });
  }

  onGridReady(params: any) {
    this.gridApi = params.api;
    this.loadEmployees();
  }

}
