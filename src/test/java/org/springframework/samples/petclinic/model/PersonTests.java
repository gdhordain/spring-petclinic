package org.springframework.samples.petclinic.owner;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;

class Tests {
	@Test
	void PersonTests() {
		Owner owner = new Owner();
		owner.setFirstName("Marie");

		assertThat(owner.getFirstName()).isEqualTo("Marie");
	}

	@Test
	void fullNameTest() {
		Owner owner = new Owner();
		owner.setFirstName("Marie");
		owner.setLastName("Dupont");

		assertThat(owner.getFullName()).isEqualTo("Marie Dupont");
	}

	@Test
	void hasNoPetsTest() {
		Owner owner = new Owner();

		assertThat(owner.getNumberOfPets()).isEqualTo(0);
	}

	@Test
	void hasPetsTest() {
		Owner owner = new Owner();
		Pet pet = new Pet();
		owner.addPet(pet);

		assertThat(owner.getNumberOfPets()).isEqualTo(1);
	}

	@Test
	void getAgeTest() {
		Pet pet = new Pet();
		pet.setBirthDate(LocalDate.now().minusYears(3));

		assertThat(pet.getAge()).isEqualTo(3);
	}
}
