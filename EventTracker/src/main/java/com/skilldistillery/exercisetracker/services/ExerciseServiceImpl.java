package com.skilldistillery.exercisetracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.exercisetracker.entities.Exercise;
import com.skilldistillery.exercisetracker.repositories.ExerciseRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	@Autowired
	private ExerciseRepository er;

	@Override
	public Exercise findById(int id) {
		return er.findById(id).orElse(null);
	}
	
	
}
