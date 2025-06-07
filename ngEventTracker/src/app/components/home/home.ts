import { ExerciseService } from './../../services/exercise-service';
import { Component, OnInit } from '@angular/core';
import { Exercise } from '../../models/exercise';
import { ExerciseType } from '../../models/exercise-type';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ExerciseTypeService } from '../../services/exercise-type-service';

@Component({
  selector: 'app-home',
  imports: [CommonModule, FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {

  exercises: Exercise[] = [];
  exerciseTypes: ExerciseType[] = [];
  selected: Exercise | null = null;
  newExercise: Exercise = new Exercise();
  showForm: boolean = false;

  constructor(private es: ExerciseService, private ets: ExerciseTypeService) {}

  ngOnInit(): void {
    this.loadExercises();
    this.loadExerciseTypes();
  }
  displayExerciseForm(): void {
    this.showForm = ! this.showForm;
  }

  loadExercises(): void{
    this.es.index().subscribe({
      next: (exerciseList) => {
        this.exercises = exerciseList;
      },
      error: (err) => {
        console.error('Home.loadExercises: error getting exercises');
        console.error(err);
      }
    })
  }
  loadExerciseTypes(): void{
     this.ets.index().subscribe({
      next: (exerciseTypesList) => {
        this.exerciseTypes = exerciseTypesList;
      },
      error: (err) => {
        console.error('Home.loadExerciseTypes: error getting exerciseTypes');
        console.error(err);
      }
    })
  }
   addExercise(exercise: Exercise) {
    this.es.createExercise(exercise).subscribe({
      next: (createdExercise) => {
        this.loadExercises();
      },
      error: (err) => {
        console.log(err)
        console.error('Error creating exercise');
      },
    });
  }
}
