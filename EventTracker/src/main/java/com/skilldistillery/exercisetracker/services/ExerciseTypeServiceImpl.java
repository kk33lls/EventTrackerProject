package com.skilldistillery.exercisetracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.exercisetracker.entities.Exercise;
import com.skilldistillery.exercisetracker.entities.ExerciseType;
import com.skilldistillery.exercisetracker.repositories.ExerciseTypeRepository;

@Service
public class ExerciseTypeServiceImpl implements ExerciseTypeService {

	@Autowired
	private ExerciseTypeRepository etr;

	@Override
	public ExerciseType findById(int id) {
		return etr.findById(id).orElse(null);
	}

	@Override
	public List<ExerciseType> showAll() {
		return etr.findAll();
	}

	@Override
	public ExerciseType create(ExerciseType newExercise) {
		if (newExercise != null) {
			newExercise.setDescription(newExercise.getDescription());
			newExercise.setImageURL(newExercise.getImageURL());
			newExercise.setName(newExercise.getName());
			newExercise.setTeamSport(newExercise.getTeamSport());
			return etr.saveAndFlush(newExercise);
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		Optional<ExerciseType> exerciseId = etr.findById(id);
		if(exerciseId.isPresent()) {
			etr.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public ExerciseType update(int id, ExerciseType updatedExercise) {
		ExerciseType managedExercise = etr.findById(id).orElse(null);
		
		if(managedExercise != null) {
			managedExercise.setDescription(updatedExercise.getDescription());
			managedExercise.setImageURL(updatedExercise.getImageURL());
			managedExercise.setName(updatedExercise.getName());
			managedExercise.setTeamSport(updatedExercise.getTeamSport());
			etr.saveAndFlush(managedExercise);
		}
	
		return managedExercise;
	}

}
