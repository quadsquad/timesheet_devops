package tn.esprit.spring.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
@RunWith(SpringRunner.class)
@SpringBootTest

public class EmployerServiceTest {
	@Autowired
	DepartementRepository depRepo;
	private static final Logger l = LogManager.getLogger(EmployerServiceTest.class);

	@Autowired
	IEmployeService es;
	@After("execution(* tn.esprit.spring.services.*.*(..))")

	@Test
	public void testAjouterEmployer() {
		int e= es.ajouterEmploye(new Employe("amed", "benassine", "ahmedbh@esprit.tn", true, Role.CHEF_DEPARTEMENT));
		l.debug("Employer added!");
		es.deleteEmployeById(e);
		l.info(e);

	}


	
	
	@Test
	public void testGetEmployerPrenomById()  {
	
		int e= es.ajouterEmploye(new Employe("ahmed", "benhassine", "ahmedbenhassine@esprit.tn", true, Role.CHEF_DEPARTEMENT));

	assertEquals("benhassine",es.getEmployePrenomById(e));
	l.info("get employer Prenom");

	}
	
	@Test
	public void testdeletetEmployerById() {
		int e= es.ajouterEmploye(new Employe("ahmed", "benhassine", "ahmedbenhassine@esprit.tn", true, Role.CHEF_DEPARTEMENT));

	       l.debug("Deleting employer by prenom");
		es.deleteEmployeById(e);
		l.info("employer deleted");

	
	}
	@Test
public void testgetAllEmployes()  {
		l.debug("getting all employes");
		es.getAllEmployes();
		l.info("all employes");

		}

	
	
	
	

}

	


