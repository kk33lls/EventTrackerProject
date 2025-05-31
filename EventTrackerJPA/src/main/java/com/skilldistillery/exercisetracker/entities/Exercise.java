package com.skilldistillery.exercisetracker.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String notes;
	
	@Column(name = "duration_in_hours")
	private Double duration;

	@Column(name = "average_heart_rate")
	private Integer averageHeartRate;

	@Column(name = "calories_burned")
	private Integer caloriesBurned;
	
	@Column(name="exercise_date")
	private LocalDateTime exerciseDate;
	
	@ManyToOne
    @JoinColumn(name = "exercise_type_id")
    private ExerciseType exerciseType;


	public Exercise() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getExerciseDate() {
		return exerciseDate;
	}

	public void setExerciseDate(LocalDateTime exerciseDate) {
		this.exerciseDate = exerciseDate;
	}

	public ExerciseType getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(ExerciseType exerciseType) {
		this.exerciseType = exerciseType;
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
		return "Exercise [id=" + id + ", notes=" + notes + ", duration=" + duration + ", averageHeartRate="
				+ averageHeartRate + ", caloriesBurned=" + caloriesBurned + ", exerciseDate=" + exerciseDate
				+ ", exerciseType=" + exerciseType + "]";
	}

}
