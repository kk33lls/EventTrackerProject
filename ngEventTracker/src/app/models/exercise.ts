import { not } from 'rxjs/internal/util/not';
import { ExerciseType } from './exercise-type';

export class Exercise {
  id: number;
  notes: string;
  duration: number;
  averageHeartRate: number;
  caloriesBurned: number;
  exerciseDate: string;
  exerciseType: ExerciseType;

  constructor(
  id: number = 0,
  notes: string = "",
  duration: number = 0,
  averageHeartRate: number = 0,
  caloriesBurned: number = 0,
  exerciseDate: string = "",
  exerciseType: ExerciseType = new ExerciseType()
  ){
    this.id = id;
    this.notes = notes;
    this.duration = duration;
    this.averageHeartRate = averageHeartRate;
    this.caloriesBurned = caloriesBurned;
    this.exerciseDate = exerciseDate;
    this.exerciseType = exerciseType;
  }
}
