package com.skilldistillery.exercisetracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.exercisetracker.entities.TeamSports;
import com.skilldistillery.exercisetracker.services.TeamSportsService;

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
	
	@GetMapping("teamsports/showall")
	public List<TeamSports> showAll(HttpServletResponse res){
			try {
				 return ts.showAll();
			} catch (Exception e) {
				res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				e.printStackTrace();
			}
			return null;
		
	}
}
