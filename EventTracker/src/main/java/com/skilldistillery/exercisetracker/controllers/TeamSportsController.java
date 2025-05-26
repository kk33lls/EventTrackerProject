package com.skilldistillery.exercisetracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.exercisetracker.entities.TeamSports;
import com.skilldistillery.exercisetracker.services.TeamSportsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class TeamSportsController {

	@Autowired
	private TeamSportsService ts;

	@GetMapping("teamsports/{teamSportsId}")
	public TeamSports findById(@PathVariable("teamSportsId") int teamSportsId, HttpServletResponse res) {

		TeamSports teamSports = ts.findById(teamSportsId);
		if (teamSports == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return teamSports;
	}

	@GetMapping("teamsports/show-all")
	public List<TeamSports> showAll(HttpServletResponse res) {
		return ts.showAll();
	}

	@PostMapping("teamsports/create-new")
	public TeamSports create(@RequestBody TeamSports newSport, HttpServletResponse res, HttpServletRequest req) {
		TeamSports sport;
		try {
		sport = ts.create(newSport);
		if(sport == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}else {
			res.setStatus(HttpServletResponse.SC_CREATED);
			res.setHeader("Location", req.getRequestURL().append("/").append(newSport.getId()).toString());
		}
	} catch (Exception e) {
		e.printStackTrace();
		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		sport = null;
	}
		return sport;
	}
	
	@DeleteMapping("teamsports/{teamSportId}")
	public void deleteCommentFromPost(@PathVariable("teamSportId") int sportId,
			HttpServletResponse res, HttpServletRequest req) {
		try {
			if (ts.delete(sportId)) {
				res.setStatus(HttpServletResponse.SC_NO_CONTENT);
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
	@PutMapping("teamsports/{teamSportId}")
	public TeamSports update(@PathVariable("teamSportId") int sportId, @RequestBody TeamSports updatedTeamSport,
		HttpServletResponse res) {
		try {
			updatedTeamSport = ts.update(sportId, updatedTeamSport);
			if (updatedTeamSport == null) {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		return updatedTeamSport;
	}
}
