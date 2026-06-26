package org.springframework.samples.petclinic.owner;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.Specialty;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class Tests {

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

	@Test
	void TestGetSpecialitiesString() {
		Vet vet1 = new Vet();
		Specialty doctor = new Specialty();
		doctor.setName("doctor");
		Specialty surgerist = new Specialty();
		surgerist.setName("surgerist");
		vet1.addSpecialty(doctor);
		vet1.addSpecialty(surgerist);

		assertThat(vet1.getSpecialitiesAsText()).isEqualTo("doctor,surgerist");
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
