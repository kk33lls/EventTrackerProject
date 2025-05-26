package com.skilldistillery.exercisetracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.exercisetracker.entities.Exercise;
import com.skilldistillery.exercisetracker.repositories.ExerciseRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository er;

	@Override
	public Exercise findById(int id) {
		return er.findById(id).orElse(null);
	}

	@Override
	public List<Exercise> showAll() {
		return er.findAll();
	}

	@Override
	public Exercise create(Exercise newExercise) {
		if (newExercise != null) {
			newExercise.setName(newExercise.getName());
			newExercise.setAverageHeartRate(newExercise.getAverageHeartRate());
			newExercise.setCaloriesBurned(newExercise.getCaloriesBurned());
			newExercise.setDuration(newExercise.getDuration());
			return er.saveAndFlush(newExercise);
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		Optional<Exercise> exerciseId = er.findById(id);
		if(exerciseId.isPresent()) {
			er.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Exercise update(int id, Exercise updatedExercise) {
		Exercise managedExercise = er.findById(id).orElse(null);
		
		if(managedExercise != null) {
			managedExercise.setName(updatedExercise.getName());
			managedExercise.setAverageHeartRate(updatedExercise.getAverageHeartRate());
			managedExercise.setCaloriesBurned(updatedExercise.getCaloriesBurned());
			managedExercise.setDuration(updatedExercise.getDuration());
			er.saveAndFlush(managedExercise);
		}
	
		return managedExercise;
	}

}
