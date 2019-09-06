package org.springframework.samples.petclinic;

import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.stereotype.Repository;

import Interfaces.AbstractJpaDAO;
import Interfaces.IBillDAO;

@Repository
public class BillDAO extends AbstractJpaDAO<Bill, Integer> implements IBillDAO {

    public BillDAO() {
        super();

        setClazz(Bill.class);
    }
    
}