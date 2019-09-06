package org.springframework.samples.petclinic;

import org.springframework.samples.petclinic.owner.Owner;

import Interfaces.AbstractJpaDAO;
import Interfaces.IOwnerDAO;

public class OwnerDAO extends AbstractJpaDAO<Owner, Integer> implements IOwnerDAO{

	public OwnerDAO() {
		super();
		
		setClazz(Owner.class);
	}

}
