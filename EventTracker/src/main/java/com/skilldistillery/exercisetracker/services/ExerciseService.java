package com.skilldistillery.exercisetracker.services;

import java.util.List;

import com.skilldistillery.exercisetracker.entities.Exercise;

public interface ExerciseService {
	Exercise findById(int id);
	List<Exercise> showAll();
	Exercise create(Exercise newExercise);
	boolean delete(int id);
	Exercise update(int id, Exercise updatedExercise);
}
