package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerTests {
	@Test
	void getNumberPets() {
		Owner owner = new Owner();
		owner.setId(2);
		owner.setFirstName("John");
		owner.setLastName("Doe");
		owner.setAddress("Center Street");
		owner.setCity("New York");
		owner.setTelephone("0123456789");
		Pet pedro = new Pet();
		owner.addPet(pedro);
		Pet sam = new Pet();
		owner.addPet(sam);

		assertThat(owner.getNumberOfPets()).isEqualTo(2);
	}

	@Test
	void hasPetsWorking() {
		Owner owner = new Owner();
		owner.setId(2);
		owner.setFirstName("John");
		owner.setLastName("Doe");
		owner.setAddress("Center Street");
		owner.setCity("New York");
		owner.setTelephone("0123456789");
		Pet pedro = new Pet();
		owner.addPet(pedro);

		assertThat(owner.hasPets()).isEqualTo(true);
	}

	@Test
	void getPetsNull() {
		Owner owner = new Owner();
		assertThat(owner.getNumberOfPets()).isEqualTo(0);
	}

	@Test
	void TestGetPetsType() {
		Owner owner = new Owner();
		Pet pet1 = new Pet();
		Pet pet2 = new Pet();
		Pet pet3 = new Pet();
		PetType type1 = new PetType();
		PetType type2 = new PetType();
		type1.setName("dog");
		type2.setName("cat");
		pet1.setType(type1);
		pet2.setType(type2);
		pet3.setType(type1);
		owner.addPet(pet1);
		owner.addPet(pet2);
		owner.addPet(pet3);

		assertThat(owner.getPetsOfType("cat").size()).isEqualTo(1);
	}

	@Test
	void TestNbTotalVisits() {
		Owner owner = new Owner();
		Pet pet1 = new Pet();
		Pet pet2 = new Pet();
		Visit visit1 = new Visit();
		Visit visit2 = new Visit();
		Visit visit3 = new Visit();
		pet1.addVisit(visit1);
		pet1.addVisit(visit2);
		pet2.addVisit(visit3);
		owner.addPet(pet1);
		owner.addPet(pet2);

		assertThat(owner.getTotalNumberOfVisits()).isEqualTo(3);
	}

	@Test
	void TestGetTelephoneValide() {
		Owner owner1 = new Owner();
		Owner owner2 = new Owner();
		Owner owner3 = new Owner();
		owner1.setTelephone("0612345678");
		owner2.setTelephone("0t1a3)56!8");
		owner3.setTelephone(null);

		assertThat(owner1.hasValidTelephone()).isEqualTo(true);
		assertThat(owner2.hasValidTelephone()).isEqualTo(false);
		assertThat(owner3.hasValidTelephone()).isEqualTo(false);
	}
}
