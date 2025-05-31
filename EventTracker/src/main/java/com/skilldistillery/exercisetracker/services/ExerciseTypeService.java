package com.skilldistillery.exercisetracker.services;

import java.util.List;

import com.skilldistillery.exercisetracker.entities.Exercise;
import com.skilldistillery.exercisetracker.entities.ExerciseType;

public interface ExerciseTypeService {
	ExerciseType findById(int id);
	List<ExerciseType> showAll();
	ExerciseType create(ExerciseType newExercise);
	boolean delete(int id);
	ExerciseType update(int id, ExerciseType updatedExercise);
}
