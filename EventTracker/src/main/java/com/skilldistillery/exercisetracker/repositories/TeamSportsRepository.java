package com.skilldistillery.exercisetracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.exercisetracker.entities.TeamSports;

public interface TeamSportsRepository extends JpaRepository<TeamSports, Integer>{

}
