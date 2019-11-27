package org.springframework.samples.petclinic;

import org.springframework.samples.petclinic.visit.Visit;

import Interfaces.AbstractJpaDAO;
import Interfaces.IVisitDAO;

public class VisitDAO extends AbstractJpaDAO<Visit, Integer> implements IVisitDAO{

	public VisitDAO() {
		super();
		setClazz(Visit.class);
	}

}
