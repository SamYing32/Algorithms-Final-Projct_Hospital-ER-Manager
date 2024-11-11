import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Patient } from "./patient";
import { environment } from "../envir/environments";

@Injectable ({
    providedIn: 'root'
})

export class PatientService {
    private apiServerUrl = environment.apiBaseUrl; 

    constructor(private http: HttpClient) { }

    public getPatients(): Observable<Patient[]> {
        return this.http.get<Patient[]>(`${this.apiServerUrl}/patient/all`); 
    }
    
    public addPatient(patient: Patient): Observable<Patient> {
        return this.http.post<Patient>(`${this.apiServerUrl}/patient/add`, patient); 
    }

    public updatePatient(patient: Patient): Observable<Patient> {
        return this.http.put<Patient>(`${this.apiServerUrl}/patient/update`, patient); 
    }

    public nextPatient(): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/patient/next`); 
    }
}