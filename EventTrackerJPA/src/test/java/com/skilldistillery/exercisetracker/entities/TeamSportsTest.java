package com.skilldistillery.exercisetracker.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class TeamSportsTest {
	private static EntityManagerFactory emf; 
	private static EntityManager em;
	private TeamSports teamSports;

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
		teamSports = em.find(TeamSports.class, 1);
	}
	

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		teamSports = null;
	}

	@Test
	void test() {
		
		assertEquals("Basketball", teamSports.getName());
	}
	
	@Test
	void test_TeamSports_Exercise_MTO_mapping() {
		assertNotNull(teamSports.getExercise());
	}

}
