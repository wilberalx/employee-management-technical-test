import { CommonModule } from '@angular/common';
import { AfterViewInit, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Router } from '@angular/router';
import { MatToolbarModule } from "@angular/material/toolbar";
import { Employee } from '../../core/models/human-resources/employee';
import { MatDividerModule } from '@angular/material/divider';
import { EmployeeService } from '../../core/services/human-resources/employee.service';
import { DepartmentService } from '../../core/services/human-resources/department.service';
import { ShiftService } from '../../core/services/human-resources/shift.service';
import { CountryRegionService } from '../../core/services/person/country-region.service';
import { StateProvinceService } from '../../core/services/person/state-province.service';
import { phoneUSValidator } from '../../shared/validators';
import { Department } from '../../core/models/human-resources/department';
import { Shift } from '../../core/models/human-resources/shift';
import { CountryRegion } from '../../core/models/person/country-region';
import { StateProvince } from '../../core/models/person/state-province';
import { SnackbarService } from '../../core/services/shared/snackbar.service';
import { LoadingService } from '../../core/services/shared/loading.service';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';

@Component({
  selector: 'app-add-edit-employee',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatDividerModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  templateUrl: './add-edit-employee.component.html'
})
export class AddEditEmployeeComponent implements OnInit, AfterViewInit {

  employee: Employee = {};
  departments: Department[] = [];
  shifts: Shift[] = [];
  countries: CountryRegion[] = [];
  filteredCountries: CountryRegion[] = [];
  states: StateProvince[] = [];
  filteredStates: StateProvince[] = [];
  loading = false;

  employeeForm: FormGroup = new FormGroup({
    firstName: new FormControl(null, [Validators.required]),
    middleName: new FormControl(null),
    lastName: new FormControl(null, [Validators.required]),
    birthDate: new FormControl(null, [Validators.required]),
    phoneNumber: new FormControl(null, [Validators.required, phoneUSValidator]),
    emailAddress: new FormControl(null, [Validators.required, Validators.email]),
    shiftId: new FormControl(null, [Validators.required]),
    departmentId: new FormControl(null, [Validators.required]),
    jobTitle: new FormControl(null, [Validators.required]),
    startDate: new FormControl(null, [Validators.required]),
    countryRegionCode: new FormControl(null, [Validators.required]),
    stateProvinceId: new FormControl(null, [Validators.required]),
    city: new FormControl(null, [Validators.required]),
    postalCode: new FormControl(null, [Validators.required]),
    addressLine1: new FormControl(null, [Validators.required]),
    addressLine2: new FormControl(null)
  });

  countryFilterControl = new FormControl('');
  stateFilterControl = new FormControl('');
  isEditMode = false;


  constructor(
    private readonly router: Router,
    private readonly route: ActivatedRoute,
    private readonly employeeService: EmployeeService,
    private readonly departmentService: DepartmentService,
    private readonly shiftService: ShiftService,
    private readonly countryRegionService: CountryRegionService,
    private readonly stateService: StateProvinceService,
    private readonly snackbar: SnackbarService,
    private readonly loadingService: LoadingService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.isEditMode = !!id && id !== 'new';
    this.initFormSubscriptions();
    this.getDepartments();
    this.getShifts();
    this.getCountries();
    if (this.isEditMode && id) {
      this.getEmployee(Number(id));
    }
  }

  initFormSubscriptions(): void {
    this.employeeForm.get('countryRegionCode')?.valueChanges.subscribe(countryCode => {
      if (countryCode) {
        this.getStates(countryCode);
      } else {
        this.states = [];
      }
    });
  }

  getEmployee(id: number): void {
    this.loading = true;
    this.employeeService.getEmployeeById(id).subscribe({
      next: (employee) => {
        this.employee = employee;
        this.fillForm();
      },
      error: (error) => {
        console.error('Error fetching employees:', error);
      },
      complete: () => {
        this.loading = false;
      }
    });
  }

  getDepartments(): void {
    this.departmentService.getAll().subscribe({
      next: (departments) => {
        this.departments = departments;
      },
      error: (error) => {
        console.error('Error fetching departments:', error);
      }
    });
  }

  getShifts(): void {
    this.shiftService.getAll().subscribe({
      next: (shifts) => {
        this.shifts = shifts;
      },
      error: (error) => {
        console.error('Error fetching shifts:', error);
      }
    });
  }

  getCountries(): void {
    this.countryRegionService.getAll().subscribe({
      next: (countries) => {
        this.countries = countries;
        this.filteredCountries = countries;
      },
      error: (error) => {
        console.error('Error fetching countries:', error);
      }
    });
  }

  getStates(countryCode: string): void {
    this.stateService.getByCountry(countryCode).subscribe({
      next: (states) => {
        this.states = states;
        this.filteredStates = states;
      },
      error: (error) => {
        console.error('Error fetching states:', error);
      }
    });

  }

  fillForm(): void {
    this.employeeForm.controls['firstName'].setValue(this.employee.firstName);
    this.employeeForm.controls['middleName'].setValue(this.employee.middleName);
    this.employeeForm.controls['lastName'].setValue(this.employee.lastName);
    this.employeeForm.controls['birthDate'].setValue(this.employee.birthDate);
    this.employeeForm.controls['phoneNumber'].setValue(this.employee.phoneNumber);
    this.employeeForm.controls['emailAddress'].setValue(this.employee.emailAddress);
    this.employeeForm.controls['shiftId'].setValue(this.employee.shiftId);
    this.employeeForm.controls['departmentId'].setValue(this.employee.departmentId);
    this.employeeForm.controls['jobTitle'].setValue(this.employee.jobTitle);
    this.employeeForm.controls['startDate'].setValue(this.employee.departmentStartDate);
    this.employeeForm.controls['countryRegionCode'].setValue(this.employee.countryRegionCode);
    this.employeeForm.controls['stateProvinceId'].setValue(this.employee.stateProvinceId);
    this.employeeForm.controls['city'].setValue(this.employee.city);
    this.employeeForm.controls['postalCode'].setValue(this.employee.postalCode);
    this.employeeForm.controls['addressLine1'].setValue(this.employee.addressLine1);
    this.employeeForm.controls['addressLine2'].setValue(this.employee.addressLine2);
  }

  onCancel(): void {
    this.router.navigate(['/employee-admin']);
  }

  onSave(): void {
    let service: any;
    let message: string;
    this.loadingService.show();
    this.employeeForm.disable();

    if (this.isEditMode) {
      message = "Employee updated successfully";
      const employeeRequest = this.buildEmployee(this.employee);
      service = this.employeeService.update(this.employee.businessEntityId!, employeeRequest);
    } else {
      message = "Employee created successfully";
      const employeeRequest = this.buildEmployee({});
      service = this.employeeService.create(employeeRequest);
    }
    service.subscribe({
      next: () => {
        this.snackbar.show(message);
        this.router.navigate(['/employee-admin']);
      },
      error: () => {
        this.snackbar.show('An error occurred while saving the employee', true);
        this.employeeForm.enable();
        this.loadingService.hide();
      },
      complete: () => {
        this.loadingService.hide();
      }
    });
  }

  buildEmployee(employee: Employee): Employee {
    employee.firstName = this.employeeForm.controls['firstName'].value;
    employee.middleName = this.employeeForm.controls['middleName'].value;
    employee.lastName = this.employeeForm.controls['lastName'].value;
    employee.birthDate = this.employeeForm.controls['birthDate'].value;
    employee.phoneNumber = this.employeeForm.controls['phoneNumber'].value;
    employee.emailAddress = this.employeeForm.controls['emailAddress'].value;
    employee.shiftId = this.employeeForm.controls['shiftId'].value;
    employee.departmentId = this.employeeForm.controls['departmentId'].value;
    employee.jobTitle = this.employeeForm.controls['jobTitle'].value;
    employee.departmentStartDate = this.employeeForm.controls['startDate'].value;
    employee.countryRegionCode = this.employeeForm.controls['countryRegionCode'].value;
    employee.stateProvinceId = this.employeeForm.controls['stateProvinceId'].value;
    employee.city = this.employeeForm.controls['city'].value;
    employee.postalCode = this.employeeForm.controls['postalCode'].value;
    employee.addressLine1 = this.employeeForm.controls['addressLine1'].value;
    employee.addressLine2 = this.employeeForm.controls['addressLine2'].value;
    return employee;
  }

  ngAfterViewInit(): void {
    this.countryFilterControl.valueChanges.subscribe(value => {
      this.filteredCountries = this.countries.filter(c =>
        c.name?.toLowerCase().includes(value?.toLowerCase() || '')
      );
    });

    this.stateFilterControl.valueChanges.subscribe(value => {
      this.filteredStates = this.filteredStates.filter(c =>
        c.name?.toLowerCase().includes(value?.toLowerCase() || '')
      );
    });
  }

}
