package tn.esprit.spring.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratTest {
	
	@Autowired
	public EmployeServiceImpl empservice;
	
	private static final Logger l = LogManager.getLogger(ContratTest.class);
	
	@After("execution(* tn.esprit.spring.services.*.*(..))")
	@Test
	public void testAjoutContrat() {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateDebut = dateFormat.parse("2021-04-30");
			Contrat c1 = new Contrat (dateDebut, "Contrat de travail temporaire", 500);
			l.debug("Contract is being added!");
			empservice.ajouterContrat(c1);
			empservice.deleteContratById(c1.getReference());
			String successMsg = "Contract added successfully!";
			l.info(successMsg);
			l.info("\n");
			l.info(c1);
		} catch (Exception e) {
			l.error(e);
		}
	}
	
	@Test
	public void testAffectContratToEmp() {
		try {
			l.debug("Affecting contract to employe");
			empservice.affecterContratAEmploye(1, 1);
			l.info("Contract affected to employe");
		} catch (Exception e) {
			l.error(e);
		}
	}
	
	@Test
	public void testDeleteAllContracts() {
		try {
			l.debug("Deleting all contracts");
			empservice.deleteAllContratJPQL();
			l.info("All contracts are deleted");
		} catch (Exception e) {
			l.error("Error deleting all contracts");
		}
	}

}
