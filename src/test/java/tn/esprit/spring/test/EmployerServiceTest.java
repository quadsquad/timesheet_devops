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
@RunWith(SpringRunner.class)
@SpringBootTest

public class EmployerServiceTest {
	@Autowired
	DepartementRepository depRepo;

	@Autowired
	IEmployeService es;
	
	@Test
	public void testAjouterEmployer() {
		int e= es.ajouterEmploye(new Employe("ahmed", "Benhassine", "ahmedbenhassine@esprit.tn", true, Role.CHEF_DEPARTEMENT));
		
		es.deleteEmployeById(e);
	}


	
	
	@Test
	public void testGetEmployerPrenomById()  {
	
		
	assertEquals("benhassine",es.getEmployePrenomById(1));
	
	}
	
	@Test
	public void testdeletetEmployerById() {
	
		
	int e= es.ajouterEmploye(new Employe("ahmed", "BeNHASSINE", "ahmedbhhhhhnh@esprit.tn", true, Role.CHEF_DEPARTEMENT));
	assertEquals("benhassine", es.getEmployePrenomById(e));

		es.deleteEmployeById(e);

	
	}
	@Test
public void testgetAllEmployes()  {
		
		
		es.getAllEmployes();
		
		}

	@Test
		public void testgetNombreEmployeJPQL()  {
		
			
				assertEquals(4,es.getNombreEmployeJPQL());
		
	}
	

	
	@Test
	public void testgetSalaireByEmployeIdJPQL() {
			
			
			es.getSalaireByEmployeIdJPQL(1);
			
			}

      @Test
		public void testmettreAjourEmailByEmployeIdJPQL() {
				
				
			es.mettreAjourEmailByEmployeIdJPQL("ahmedbnnh@gmail.com",25);
				
		}


  

	
	
	

}

	


