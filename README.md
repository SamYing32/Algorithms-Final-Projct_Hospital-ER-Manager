# Hospital ER Manager
This project aims to design a hospital emergency room patient management system that prioritizes patients based on their medical condition severity and time spent waiting. The system uses priority queues to ensure that patients in critical condition are treated first while also accounting for patients with extended wait times.

This project's backend was generated with [Spring Boot](https://start.spring.io/)  
This project's frontend was generated with [Angular CLI](https://github.com/angular/angular-cli) version 18.2.11.

## Spring Boot
The backend handles the logic for managing patient data and priority queues. It is responsible for:
- Storing patient information.
- Managing priority assignments based on severity and wait times.
- Serving APIs for frontend interaction.

To run the backend server, follow these steps:
1. Clone the repository.
2. Navigate to the backend folder: `Hospital-Manager\src\main\java\com\algorithms\Hospital_Manager`
3. Open and run `HospitalManagerApplication` to start the server. 
4. The backend API will be available at `http://localhost:8080/`.

## Angular
The frontend provides an interactive user interface for hospital staff to manage patient queues efficiently.

To run the frontend server, follow these steps: 
1. Clone the repository. 
2. Navigate to the frontend folder: `hospitalmanagerapp`
3. Open command and use following propts to start server: 

### Development server
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

### Code scaffolding
Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

### Build
Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

### Running unit tests
Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

### Running end-to-end tests
Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

### Further help
To get more help on the Angular CLI, use `ng help` or check out the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.

## Contributions
Contributions to this project are welcome. If you encounter any issues or have ideas for improvement, feel free to submit an issue or create a pull request.
