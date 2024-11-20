import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PatientService } from './patient.service';
import { FormsModule } from '@angular/forms';
import { provideHttpClient, withFetch, withInterceptorsFromDi } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    
    FormsModule
  ],
  providers: [provideHttpClient(withInterceptorsFromDi(), withFetch()), PatientService],
  bootstrap: [AppComponent]
})
export class AppModule { }