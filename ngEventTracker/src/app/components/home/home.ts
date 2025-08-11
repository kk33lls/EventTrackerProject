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
  editExercise: Exercise | null = null;
  selectedExercise: Exercise | null = null;
  showForm: boolean = false;
  showDetails: boolean = false;

  constructor(private es: ExerciseService, private ets: ExerciseTypeService) {}

  ngOnInit(): void {
    this.loadExercises();
    this.loadExerciseTypes();
  }

  displayExerciseForm(): void {
    this.showForm = !this.showForm;

    this.selectedExercise = null;
    this.editExercise = null;
  }


  viewExercise(exercise: Exercise): void {
    this.selectedExercise = exercise;
    this.showForm = false;
    this.editExercise = null;
  }


  editExerciseForm(exercise: Exercise): void {
    this.editExercise = { ...exercise };
    this.selectedExercise = null;
    this.showForm = false;
  }


  cancelEdit(): void {
    this.editExercise = null;
  }


  cancelForm(): void {
    this.showForm = false;
    this.selectedExercise = null;
  }


  backToList(): void {
    this.selectedExercise = null;
    this.editExercise = null;
    this.showForm = false;
  }

  loadExercises(): void{
    this.es.index().subscribe({
      next: (exerciseList) => {
        this.exercises = exerciseList;
        this.sortExercisesByDate();
      },
      error: (err) => {
        console.error('Home.loadExercises: error getting exercises');
        console.error(err);
      }
    })
  }
  sortExercisesByDate(ascending: boolean = true): void {
        this.exercises.sort((a, b) => {
          const dateA =  new Date(a.exerciseDate).getTime();
          const dateB = new Date(b.exerciseDate).getTime();
           console.log(`Comparing ${dateA} with ${dateB}`);
          return ascending ? dateA - dateB : dateB - dateA;
        });
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
    this.es.createExercise(exercise, exercise.exerciseType.id).subscribe({
      next: (createdExercise) => {
        this.loadExercises();
        this.newExercise = new Exercise();
        this.showForm = false;
      },
      error: (err) => {
        console.log(err)
        console.error('Error creating exercise');
      },
    });
  }

  deleteExercise(exerciseId: number) {
    this.es.destroyExercise(exerciseId).subscribe({
      next: (success) => {
        this.loadExercises();
        this.loadExerciseTypes();

        this.selectedExercise = null;
        this.editExercise = null;
      },
      error: (err) => {
        console.log(err)
        console.error('Error deleting exercise');
      },
    });
  }

  updateExercise(updatedExercise: Exercise) {
    this.es.update(updatedExercise, updatedExercise.id).subscribe({
      next: (success) => {
        this.loadExercises();
        this.editExercise = null;
      },
      error: (err) => {
        console.log(err)
        console.error('Error updating exercise');
      },
    });
  }
}
