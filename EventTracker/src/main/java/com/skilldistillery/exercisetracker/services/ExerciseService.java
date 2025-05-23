package com.skilldistillery.exercisetracker.services;

import com.skilldistillery.exercisetracker.entities.Exercise;

public interface ExerciseService {
	Exercise findById(int id);
}
