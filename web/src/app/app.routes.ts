import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'employee-admin',
    loadComponent: () => import('./pages/admin/admin.component').then(m => m.AdminComponent)
  },
  {
    path: 'employee-admin/new',
    loadComponent: () => import('./pages/add-edit-employee/add-edit-employee.component').then(m => m.AddEditEmployeeComponent)
  },
  {
    path: 'employee-admin/:id',
    loadComponent: () => import('./pages/add-edit-employee/add-edit-employee.component').then(m => m.AddEditEmployeeComponent)
  },
  {
    path: 'sales-report',
    loadComponent: () => import('./pages/sales-report/sales-report.component').then(m => m.SalesReportComponent)
  },
  {
    path: 'sales-report/:id',
    loadComponent: () => import('./pages/sales-report/sales-report.component').then(m => m.SalesReportComponent)
  },
  { path: '', redirectTo: 'employee-admin', pathMatch: 'full' }
];
