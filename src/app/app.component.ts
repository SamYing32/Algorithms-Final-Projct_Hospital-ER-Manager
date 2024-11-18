import { Component, OnInit } from '@angular/core';
import { Patient } from './patient';
import { PatientService } from './patient.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title(title: any) {
    throw new Error('Method not implemented.');
  }

  public patients!: Patient[]; 
  public editPatient!: Patient; 
  public deletePatient!: Patient; 
  
  constructor(private patientService: PatientService) { }

  ngOnInit() {
    this.getPatients();
  }

  public getPatients(): void {
    this.patientService.getPatients().subscribe(
      {
        next: (response: Patient[]) => {
          this.patients = response; 
          console.log(this.patients);
        },
        error: (err: HttpErrorResponse) => {
          console.log(err);
        },
        complete: () => {
          console.log('complete');
        }
      }
    ); 
  }

  public onAddPatient(addForm: NgForm): void {
    document.getElementById('add-patient-form')?.click();
    this.patientService.addPatient(addForm.value).subscribe({
      next: (response: Patient) => {
        console.log(response);
        this.getPatients();
        addForm.reset();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
      complete: () => {
        console.log('complete');
      }
    }
    );
  }

  public onUpdatePatient(patient: Patient): void {
    this.patientService.updatePatient(patient);
  }

  public onNextPatient(): void {
    this.patientService.nextPatient();
  }

  public onOpenModal(patient: Patient | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'edit') {
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }
    container?.appendChild(button);
    button.click();
  }

}
