import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Exercise } from '../models/exercise';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService {
private url = environment.baseUrl + 'api/exercises';

constructor(private http: HttpClient) {}

index(): Observable<Exercise[]>{
  return this.http.get<Exercise[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ExerciseService.index(): error retrieving exercise: ' + err)
        );
      })
    );
}
 createExercise(exercise: Exercise, exerciseTypeId: number) {
    return this.http.post<Exercise>(this.url + "/exerciseTypes/" + exerciseTypeId, exercise).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Exercise.createExercise(): error creating exercise: ' + err)
        );
      })
    );
  }
  destroyExercise(exerciseId: number) {
    return this.http.delete<Exercise>(this.url + '/' + exerciseId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Exercise.delete(): error deleting exercise: ' + err)
        );
      })
    );
  }
  update(updatedExercise: Exercise, exerciseId: number) {
    return this.http.put<Exercise>(this.url + '/' + exerciseId, updatedExercise).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Exercise.update(): error updating exercise: ' + err)
        );
      })
    );
  }
}
