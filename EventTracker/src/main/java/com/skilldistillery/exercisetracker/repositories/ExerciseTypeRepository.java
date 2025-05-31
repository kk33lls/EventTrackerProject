package com.skilldistillery.exercisetracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.exercisetracker.entities.ExerciseType;

public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Integer>{

}
