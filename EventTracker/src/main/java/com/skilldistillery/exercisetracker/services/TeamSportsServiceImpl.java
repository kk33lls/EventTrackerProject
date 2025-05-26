package com.skilldistillery.exercisetracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.exercisetracker.entities.TeamSports;
import com.skilldistillery.exercisetracker.repositories.TeamSportsRepository;

@Service
public class TeamSportsServiceImpl implements TeamSportsService{

	@Autowired
	TeamSportsRepository tr;
	
	@Override
	public TeamSports findById(int id) {
		return tr.findById(id).orElse(null);
	}

	@Override
	public List<TeamSports> showAll() {
		return tr.findAll();
	}

	@Override
	public TeamSports create(TeamSports newSport) {
		if(newSport != null) {
		newSport.setName(newSport.getName());
		return tr.saveAndFlush(newSport);
		}
		return null;
	}

	@Override
	public boolean delete(int teamSportId) {
		Optional<TeamSports> sportId = tr.findById(teamSportId);
		if(sportId.isPresent()) {
			tr.deleteById(teamSportId);
			return true;
		}
		return false;
	}

	@Override
	public TeamSports update(int teamsSportId, TeamSports updatedTeamSport) {
		TeamSports managedTeamSport = tr.findById(teamsSportId).orElse(null);
		
		if(managedTeamSport != null) {
			managedTeamSport.setName(updatedTeamSport.getName());
			tr.saveAndFlush(managedTeamSport);
		}
		return managedTeamSport;
	}

}
