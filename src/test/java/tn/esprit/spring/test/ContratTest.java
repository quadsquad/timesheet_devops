package tn.esprit.spring.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.EmployeServiceImpl;

public class ContratTest {
	
	@Autowired
	public EmployeServiceImpl emp_service;
	
	@Test
	public void testAjoutContrat() {
		Contrat c1 = new Contrat();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		try {
		  date = DateFor.parse("08/07/2019");
		  System.err.println("Date : "+date);
			} catch (ParseException e) {
			e.printStackTrace();
		}
		c1.setDateDebut(date);
		c1.setTypeContrat("Contrat de travail temporaire");
		c1.setSalaire(500);
		emp_service.ajouterContrat(c1);
	}

}
