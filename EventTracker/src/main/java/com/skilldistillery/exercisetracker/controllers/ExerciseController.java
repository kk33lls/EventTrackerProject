package com.skilldistillery.exercisetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.exercisetracker.entities.Exercise;
import com.skilldistillery.exercisetracker.services.ExerciseService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class ExerciseController {

	@Autowired
	private ExerciseService es;

	@GetMapping("exercises/{exerciseId}")
	public Exercise findById(@PathVariable("exerciseId") int exerciseId, HttpServletResponse res) {

		Exercise exercise = es.findById(exerciseId);
		if (exercise == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return exercise;


	}
}
