package com.skilldistillery.exercisetracker.services;

import java.util.List;

import com.skilldistillery.exercisetracker.entities.TeamSports;


public interface TeamSportsService {
	TeamSports findById(int id);
	List<TeamSports> showAll();
	TeamSports create(TeamSports newSport);
}
