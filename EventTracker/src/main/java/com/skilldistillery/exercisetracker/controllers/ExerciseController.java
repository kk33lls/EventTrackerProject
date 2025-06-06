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

import com.skilldistillery.exercisetracker.entities.Exercise;
import com.skilldistillery.exercisetracker.services.ExerciseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RequestMapping("api")
@RestController
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
	@GetMapping("exercises")
	public List<Exercise> showAll(HttpServletResponse res) {
		return es.showAll();
	}

	@PostMapping("exercises")
	public Exercise create(@RequestBody Exercise newExercise, HttpServletResponse res, HttpServletRequest req) {
		Exercise exercise;
		try {
		exercise = es.create(newExercise);
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
	
	@DeleteMapping("exercises/{exerciseId}")
	public void deleteCommentFromPost(@PathVariable("exerciseId") int exerciseId,
			HttpServletResponse res, HttpServletRequest req) {
		try {
			if (es.delete(exerciseId)) {
				res.setStatus(HttpServletResponse.SC_NO_CONTENT);
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
	@PutMapping("exercises/{exerciseId}")
	public Exercise update(@PathVariable("exerciseId") int exerciseId, @RequestBody Exercise updatedExercise,
		HttpServletResponse res) {
		try {
			updatedExercise = es.update(exerciseId, updatedExercise);
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

