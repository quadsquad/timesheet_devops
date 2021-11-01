package tn.esprit.spring.test;

import static org.junit.Assert.*;
import java.text.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
@RunWith(SpringRunner.class)
@SpringBootTest

public class EmployerServiceTest {
	@Autowired
	DepartementRepository depRepo;

	@Autowired
	IEmployeService es;
	
	@Test
	public void testAjouterEmployer() throws ParseException {
		int e= es.ajouterEmploye(new Employe("ahmed", "benhassine", "ahmedbenhassine@esprit.tn", true, Role.CHEF_DEPARTEMENT));
		//assertEquals("ahmed", es.getEmployePrenomById(e));
		es.deleteEmployeById(e);
	}


	
	
	@Test
	public void testGetEmployerPrenomById() throws ParseException {
	
		
	assertEquals("benhassine",es.getEmployePrenomById(1));
	
	}
	
	@Test
	public void testdeletetEmployerById() throws ParseException {
	
		
	int e= es.ajouterEmploye(new Employe("ahmed", "benhassine", "ahmedbhhhhhnh@esprit.tn", true, Role.CHEF_DEPARTEMENT));
	assertEquals("benhassine", es.getEmployePrenomById(e));

		es.deleteEmployeById(e);

	
	}
	@Test
public void TestgetAllEmployes() throws ParseException {
		
		
		es.getAllEmployes();
		
		}

	@Test
		public void TestgetNombreEmployeJPQL() throws ParseException {
		
			
	assertEquals(4,es.getNombreEmployeJPQL());
		
	}
	

	
	@Test
	public void TestgetSalaireByEmployeIdJPQL() throws ParseException {
			
			
			es.getSalaireByEmployeIdJPQL(1);
			
			}

      @Test
		public void TestmettreAjourEmailByEmployeIdJPQL() throws ParseException {
				
				
			es.mettreAjourEmailByEmployeIdJPQL("ahmedbnnh@gmail.com",25);
				
		}


  

	
	
	

}

	


