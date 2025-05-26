package com.skilldistillery.exercisetracker.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private Double duration;

	@Column(name = "average_heart_rate")
	private Integer averageHeartRate;

	@Column(name = "calories_burned")
	private Integer caloriesBurned;

	@JsonIgnore
	@OneToMany(mappedBy = "exercise")
	private List<TeamSports> teamSports;


	public Exercise() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Integer getAverageHeartRate() {
		return averageHeartRate;
	}

	public void setAverageHeartRate(Integer averageHeartRate) {
		this.averageHeartRate = averageHeartRate;
	}

	public Integer getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(Integer caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}


	public List<TeamSports> getTeamSports() {
		return teamSports;
	}

	public void setTeamSports(List<TeamSports> teamSports) {
		this.teamSports = teamSports;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", duration=" + duration + ", averageHeartRate="
				+ averageHeartRate + ", caloriesBurned=" + caloriesBurned + ", teamSports=" + teamSports + "]";
	}

}
