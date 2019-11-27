package org.springframework.samples.petclinic;

import org.springframework.samples.petclinic.owner.Pet;

import Interfaces.AbstractJpaDAO;
import Interfaces.IPetDAO;

public class PetDAO extends AbstractJpaDAO<Pet, Integer> implements IPetDAO{

	public PetDAO() {
		super();
		setClazz(Pet.class);
	}

}
