package com.skilldistillery.exercisetracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.exercisetracker.entities.ExerciseType;
import com.skilldistillery.exercisetracker.services.ExerciseTypeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RequestMapping("api")
@RestController
public class ExerciseTypeController {

	@Autowired
	private ExerciseTypeService ets;

	@GetMapping("exerciseTypes/{exerciseId}")
	public ExerciseType findById(@PathVariable("exerciseId") int exerciseId, HttpServletResponse res) {
		ExerciseType exercise = ets.findById(exerciseId);
		if (exercise == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return exercise;
	}
	@GetMapping("exerciseTypes")
	public List<ExerciseType> showAll(HttpServletResponse res) {
		return ets.showAll();
	}

	@PostMapping("exerciseTypes")
	public ExerciseType create(@RequestBody ExerciseType newExercise, HttpServletResponse res, HttpServletRequest req) {
		ExerciseType exercise;
		try {
		exercise = ets.create(newExercise);
		if(exercise == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}else {
			res.setStatus(HttpServletResponse.SC_CREATED);
			res.setHeader("Location", req.getRequestURL().append("/").append(newExercise.getId()).toString());
		}
	} catch (Exception e) {
		e.printStackTrace();
		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		exercise = null;
	}
		return exercise;
	}
	
	@DeleteMapping("exerciseTypes/{exerciseId}")
	public void deleteCommentFromPost(@PathVariable("exerciseId") int exerciseId,
			HttpServletResponse res, HttpServletRequest req) {
		try {
			if (ets.delete(exerciseId)) {
				res.setStatus(HttpServletResponse.SC_NO_CONTENT);
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
	@PutMapping("exerciseTypes/{exerciseId}")
	public ExerciseType update(@PathVariable("exerciseId") int exerciseId, @RequestBody ExerciseType updatedExercise,
		HttpServletResponse res) {
		try {
			updatedExercise = ets.update(exerciseId, updatedExercise);
			if (updatedExercise == null) {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		return updatedExercise;
	}
}

