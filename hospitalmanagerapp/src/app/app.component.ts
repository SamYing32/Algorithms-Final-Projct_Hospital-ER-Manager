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
  public editPatient!: Patient | null; 
  public deletePatient!: Patient | null; 
  public displayPatient!: Patient | null; 
  
  constructor(private patientService: PatientService) { }

  ngOnInit() {
    this.getPatients();
  }

  public searchPatients(key: string): void {
    console.log(key);
    const results: Patient[] = [];
    for (const patient of this.patients) {
      if (patient.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || patient.gender.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || patient.birthDate.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(patient);
      }
    }
    console.log(results);
    this.patients = results;
    if (key.length === 0){ 
      this.getPatients(); 
    }
    if (results.length != 0) {
    }
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
    document.getElementById('add-patient-form')!.click();
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
    this.patientService.updatePatient(patient).subscribe({
      error: error => {
          alert(error.message); 
          console.error('There was an error!', error);
      }, 
      complete: () => {
        this.getPatients(); 
        console.log('complete'); 
      }
  });
  }

  public onDeletePatient(patientId: string): void {
    this.patientService.deletePatient(patientId).subscribe({
      next: (response: Patient) => {
        console.log(response);
        this.getPatients();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }, 
      complete: () => {
        console.log('complete'); 
      }
    });
  }

  public onNextPatient(): void {
    if (this.patients.length == 0) {
      this.onOpenModal(null, 'empty'); 
      return; 
    }
    this.patientService.nextPatient().subscribe({
      next: (response: Patient) => {
        console.log(response); 
        this.onOpenModal(response, 'display'); 
      }, 
      error: (error: HttpErrorResponse) => {
        alert(error.message); 
      },
      complete: () => {
        this.getPatients(); 
        console.log('complete'); 
      }
    });
  }

  public onOpenModal(patient: Patient | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addPatientModal');
    }
    if (mode === 'edit') {
      this.editPatient = patient; 
      button.setAttribute('data-target', '#updatePatientModal');
    }
    if (mode === 'delete') {
      this.deletePatient = patient; 
      button.setAttribute('data-target', '#deletePatientModal');
    }
    if (mode === 'next') {
      button.setAttribute('data-target', '#nextPatientModal'); 
    }
    if (mode === 'display') {
      this.displayPatient = patient; 
      button.setAttribute('data-target', '#displayPatientModal'); 
    }
    if (mode === 'empty') {
      button.setAttribute('data-target', '#emptyPatientModal'); 
    }
    container?.appendChild(button);
    button.click();
  }

}
