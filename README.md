# EventTrackerProject
<img width="1048" height="631" alt="Screenshot 2025-08-11 at 8 31 59 AM" src="https://github.com/user-attachments/assets/79ee1ba1-0a22-4c46-bcdc-5e1be307b29b" />

## About The Project
This full-stack web application functions as an exercise log, enabling users to record and manage workout details including calories burned, duration, average heart rate, date, and activity type. The application features a responsive front-end for intuitive data entry and a back-end API for secure data storage and retrieval. 

As someone who is highly active and passionate about tracking personal fitness metrics, I developed this event tracker to combine my interest in fitness with my skills in full-stack development, creating a tool that makes tracking and visualizing progress both simple and efficient.

## How to Use
When utilizing this application there are two separate front-ends which can be switched using the hyperlink in the bottom left corner of the page. One front-end was built with AJAX/JavaScript, and the other with Angular, both have the same functions as the back-end logic is used for both. 

To log a new exercise you will be given a form where you can fill out the details of the exercise as input. To edit or delete an exisiting exercise log, the buttons with those fucntions are located next to each individual log. When editing you will be given a form similar to creating a new one, but it will obtain the exisiting information of that specific log.

Once a log is deleted it cannot be retrieved as it is permanently removed from the database.

### Built With
* Java
* Spring Boot
* JPA/Hibernate
* SQL
* JavaScript
* TypeScript
* Angular
* HTML/CSS
* Bootstrap

### Entity Relationship Diagram
<img width="302" height="380" alt="exerciseTracker" src="https://github.com/user-attachments/assets/d4c47d8d-06e1-4192-a654-3f16cae6a369" />

## REST API Endpoints

### 🧗🏼‍♀️ ExerciseController
| Method   | Endpoint                                        | Description                                                    |
|----------|-------------------------------------------------|----------------------------------------------------------------|
| GET      | `/api/exercises/{exerciseId}`                   | Retrieves an exercise by ID                                    |
| POST     | `/api/exercises/exerciseTypes/{exerciseTypeId}` | Creates a new exercise log using the exercise type ID inputted |
| DELETE   | `/api/exercises/{exerciseId}`                   | Deletes an existing exercise log by exercise ID                |
| PUT      | `/api/exercises/{exerciseId}`                   | Edits an existing exercise log by exercise ID                  |

### 🏄🏾‍♀️ ExerciseTypeController
| Method   | Endpoint                           | Description                                                    |
|----------|------------------------------------|----------------------------------------------------------------|
| GET      | `/api/exerciseTypes/{exerciseId}`  | Retrieves an exercise type by ID                               |
| DELETE   | `/api/exerciseTypes/{exerciseId}`  | Deletes an existing exercise log with exercise type ID         |
| PUT      | `/api/exerciseTypes/{exerciseId}`  | Edits an existing exercise log with exercise type ID           |




