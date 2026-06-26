package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PetTests {
	@Test
	void TestLastVisit() {
		Pet pet = new Pet();
		Visit visit1 = new Visit();
		visit1.setDate(LocalDate.of(2026, 6, 21));
		Visit visit2 = new Visit();
		visit2.setDate(LocalDate.of(2026, 6, 22));
		pet.addVisit(visit1);
		pet.addVisit(visit2);

		assertThat(pet.getLatestVisit()).isEqualTo(visit2);
	}
}
