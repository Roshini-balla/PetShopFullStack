import { Component } from '@angular/core';
import { EmployeeService } from 'src/app/ProjectServices/employee.service';
import { Employee } from 'src/app/model/employee.model';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent {

  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService) {}

  addEmployee(): void {
    this.employeeService.addEmployee(this.employee).subscribe((data: Employee) => {
      console.log('Employee added successfully', data);
      // Handle success, e.g., redirect or reset form
    });
  }
}
