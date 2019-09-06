package org.springframework.samples.petclinic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.owner.Bill;
import org.springframework.samples.petclinic.owner.BillDetails;
import org.springframework.samples.petclinic.owner.BillRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;

import Interfaces.IBillDAO;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private VisitRepository visitRepository;
	@Autowired
	private PetRepository petRepository;

	@Autowired
	private BillDAO billDAO;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) {
		System.out.println("\n\nPruebas de Hibernate\n=====================\n\n");
		Pet p = petRepository.findById(8);
		List<Visit> visits = visitRepository.findByPetId(p.getId());

		/*
		 * for (Visit v : visits) { System.out.println(v.toString()); }
		 */
		/***
		 * Crear aquí las facturas y enlazarlas, por último, volver a mostrar dichas
		 * visitas
		 */
		Bill b = new Bill();
		b.setIdNumber(9898);
		b.setMoney(500.0);
		b.setPaymentDate(new Date());

		Bill c = new Bill();
		c.setIdNumber(23424);
		c.setMoney(5.0);
		c.setPaymentDate(new Date());

		List<Bill> listaFacturas = new ArrayList<Bill>();
		//listaFacturas.add(b);
		//listaFacturas.add(c);
		//listaFacturas = billRepository.save(listaFacturas);
		//visits.get(0).setBill(b);
		//visits.get(1).setBill(c);
		//visitRepository.save(visits.get(0));
		//visitRepository.save(visits.get(1));

		p = petRepository.findById(8);
		visits = visitRepository.findByPetId(p.getId());
		for (Visit v : visits) {
			System.out.println(v.toString());
		}

		BillDetails line = new BillDetails();
		line.setDetails("JoaoRafael");
		line.setBill(c);
		ArrayList<BillDetails> lines = new ArrayList<BillDetails>();
		lines.add(line);
		c.setBillDetails(lines);
		billRepository.save(c);

		/*
		 * Bill billDel = billRepository.findOne(3); billRepository.delete(billDel);
		 */

		/*
		 * Bill d = new Bill(); d.setIdNumber(888); d.setMoney(44.0);
		 * d.setPaymentDate(new Date());
		 * 
		 * billDAO.create(d);
		 */
		
		Visit visita2 = visits.get(0);
		visita2.setBill(b);
		visitRepository.save(visita2);
		
		
		

	}
}
