package com.skilldistillery.exercisetracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class ExerciseTest {
	
	private static EntityManagerFactory emf; 
	private static EntityManager em;
	private Exercise exercise;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("EventTrackerJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		exercise = em.find(Exercise.class, 1);
		
	}
	

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		exercise = null;
	}

	@Test
	void test() {
		assertEquals("Weightlifting", exercise.getName());
	}

}
