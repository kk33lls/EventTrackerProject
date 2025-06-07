import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { ExerciseType } from '../models/exercise-type';
import { catchError, Observable, throwError } from 'rxjs';
import { Exercise } from '../models/exercise';

@Injectable({
  providedIn: 'root'
})
export class ExerciseTypeService {
  private url = environment.baseUrl + 'api/exerciseTypes'

  constructor(private http: HttpClient) { }

  index(): Observable<ExerciseType[]>{
    return this.http.get<ExerciseType[]>(this.url).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error('ExerciseTypeService.index(): error retrieving exerciseType: ' + err)
          );
        })
      );
  }

  createExerciseType(exerciseType: ExerciseType) {
    return this.http.post<ExerciseType>(this.url, exerciseType).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ExerciseType.createExerciseType(): error creating exercise types: ' + err)
        );
      })
    );
  }

   destroyExerciseType(exerciseTypeId: number) {
    return this.http.delete<ExerciseType>(this.url + '/' + exerciseTypeId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ExerciseType.delete(): error deleting exerciseType: ' + err)
        );
      })
    );
  }
}
