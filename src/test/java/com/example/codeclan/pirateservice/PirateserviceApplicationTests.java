package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPirateAndShipAndRaid(){
		Ship ship = new Ship("Black Pearl");
		Ship shipTwo = new Ship("Queen Anne's Revenge");
		Ship shipThree = new Ship("Neptune");
		shipRepository.save(ship);
		shipRepository.save(shipTwo);
		shipRepository.save(shipThree);

		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		Pirate drake = new Pirate("Francis", "Drake", 41, shipThree);
		Pirate blackbeard = new Pirate("Edward", "Teach", 38, shipTwo);
		Pirate kid = new Pirate("William", "Kid", 28, shipTwo);
		pirateRepository.save(jack);
		pirateRepository.save(drake);
		pirateRepository.save(blackbeard);
		pirateRepository.save(kid);

		Raid raid = new Raid ("Tortuga", 100);
		raid.addPirates(blackbeard);
		raid.addPirates(drake);

		Raid raidTwo = new Raid ("Port Royal", 150);
		raidTwo.addPirates(blackbeard);
		raidTwo.addPirates(jack);
		raidTwo.addPirates(kid);

		Raid raidThree = new Raid ("Clew Bay", 80);
		raidThree.addPirates(blackbeard);
		raidThree.addPirates(kid);
		raidThree.addPirates(drake);

		raidRepository.save(raid);
		raidRepository.save(raidTwo);
		raidRepository.save(raidThree);

	}

}
