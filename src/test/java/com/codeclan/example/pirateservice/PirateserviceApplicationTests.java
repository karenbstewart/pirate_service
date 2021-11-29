package com.codeclan.example.pirateservice;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.models.Raid;
import com.codeclan.example.pirateservice.models.Ship;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import com.codeclan.example.pirateservice.repositories.RaidRepository;
import com.codeclan.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	public void createPirate(){
		Ship ship = new Ship("the bloody awful");
		shipRepository.save(ship);
		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		Pirate fred = new Pirate("fred", "Jackson", 30, ship);
		pirateRepository.save(jack);
		pirateRepository.save(fred);

		Raid raid1 = new Raid("Oddbins", 100);
		raidRepository.save(raid1);

		raid1.addPirate(jack);
		raidRepository.save(raid1);
	}

}
