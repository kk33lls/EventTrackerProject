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
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise_type")
public class ExerciseType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String description;
	
	@Column(name="image_url")
	private String imageURL;
	
	@Column(name="team_sport")
	private Boolean teamSport;
	
	@JsonIgnore
	@OneToMany(mappedBy = "exerciseType")
	private List<Exercise> exercises;

	public ExerciseType() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Boolean getTeamSport() {
		return teamSport;
	}

	public void setTeamSport(Boolean teamSport) {
		this.teamSport = teamSport;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
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
		ExerciseType other = (ExerciseType) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "ExerciseType [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", teamSport=" + teamSport + ", exercises=" + exercises + "]";
	}
	
}
